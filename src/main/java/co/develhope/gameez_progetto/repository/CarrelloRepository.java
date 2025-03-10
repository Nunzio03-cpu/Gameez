package co.develhope.gameez_progetto.repository;

import co.develhope.gameez_progetto.entity.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
    List<Carrello> findAllByStatusCarrelloTrue();
}
