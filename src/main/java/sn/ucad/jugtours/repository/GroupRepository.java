package sn.ucad.jugtours.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ucad.jugtours.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);

}