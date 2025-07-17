package com.example.demo.domain.event.repository;

import com.example.demo.domain.coin.Era;
import com.example.demo.domain.event.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findByEra(Era era);
}
