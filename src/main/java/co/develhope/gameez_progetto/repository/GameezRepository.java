package co.develhope.gameez_progetto.repository;

import co.develhope.gameez_progetto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameezRepository extends JpaRepository<User, Long> {
}
