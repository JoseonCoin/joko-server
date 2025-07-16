package com.example.demo.presentation.event;

import com.example.demo.presentation.event.dto.EraChangeResponse;
import com.example.demo.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/random")
    public ResponseEntity<EraChangeResponse> getRandomEvent(@RequestParam Long userId) {
        EraChangeResponse response = eventService.getRandomHistoricalEvent(userId);
        return ResponseEntity.ok(response);
    }
}
