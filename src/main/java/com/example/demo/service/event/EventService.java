package com.example.demo.service.event;

import com.example.demo.domain.coin.Era;
import com.example.demo.domain.event.Event;
import com.example.demo.domain.event.repository.EventRepository;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.exception.UserNotFoundException;
import com.example.demo.domain.user.repository.UserRepository;
import com.example.demo.presentation.event.dto.EraChangeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public EraChangeResponse getRandomHistoricalEvent(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException());

        Era era = user.getEra();

        List<Event> events = eventRepository.findByEra(era);
        if (events.isEmpty()) {
            throw new IllegalStateException("해당 시대에 사건 정보가 없습니다.");
        }

        Event selected = getRandomEvent(events);

        return EraChangeResponse.from(selected);
    }

    private Event getRandomEvent(List<Event> events) {
        int index = ThreadLocalRandom.current().nextInt(events.size());
        return events.get(index);
    }
}
