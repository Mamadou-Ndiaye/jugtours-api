package sn.ucad.jugtours.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ucad.jugtours.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}