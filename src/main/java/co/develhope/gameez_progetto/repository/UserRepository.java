package co.develhope.gameez_progetto.repository;

import co.develhope.gameez_progetto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByStatusUserTrue();
}
