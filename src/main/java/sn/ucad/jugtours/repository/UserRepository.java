package sn.ucad.jugtours.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ucad.jugtours.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}