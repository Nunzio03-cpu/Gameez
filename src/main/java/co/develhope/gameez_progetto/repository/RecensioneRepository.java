package co.develhope.gameez_progetto.repository;

import co.develhope.gameez_progetto.entity.Prodotto;
import co.develhope.gameez_progetto.entity.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecensioneRepository extends JpaRepository<Recensione, Long> {

    List<Recensione> findAllByStatusRecensioneTrue();
}
