package sn.ucad.jugtours;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.ucad.jugtours.model.Event;
import sn.ucad.jugtours.model.Group;
import sn.ucad.jugtours.repository.EventRepository;
import sn.ucad.jugtours.repository.GroupRepository;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;


//@Component
public class Initializer implements CommandLineRunner {
    private final GroupRepository groupRepository;

    private final  EventRepository eventRepository;

    public Initializer(GroupRepository groupRepository, EventRepository eventRepository) {
        this.groupRepository = groupRepository;

        this.eventRepository = eventRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*Stream.of("Omaha JUG", "Kansas City JUG", "Chicago JUG",
                        "Dallas JUG", "Philly JUG", "Garden State JUG", "NY Java SIG")
                .forEach(name -> groupRepository.save(new Group(name)));
*/
        Group jug = groupRepository.findByName("Garden State JUG");
        Event e = new Event(Instant.parse("2023-10-18T18:00:00.000Z"),
                "OAuth for Java Developers", "Learn all about OAuth and OIDC + Java!");

        eventRepository.save(e);
        jug.setEvents(Collections.singleton(e));
        groupRepository.save(jug);

        groupRepository.findAll().forEach(System.out::println);

    }
}
