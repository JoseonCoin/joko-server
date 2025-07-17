package com.example.demo.presentation.event;

import com.example.demo.domain.coin.Era;
import com.example.demo.domain.coin.Event;
import com.example.demo.presentation.event.dto.EraChangeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/event")
public class EventController {

    private final Random random = new Random();

    @GetMapping("/random")
    public EraChangeResponse getRandomEvent(@RequestParam Era era) {
        List<Event> events = Arrays.stream(Event.values())
                .filter(e -> e.getEra() == era)
                .collect(Collectors.toList());

        if (events.isEmpty()) {
            throw new IllegalArgumentException("해당 시대의 이벤트가 없습니다.");
        }

        Event randomEvent = events.get(random.nextInt(events.size()));
        return EraChangeResponse.from(randomEvent);
    }
}
