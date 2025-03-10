package co.develhope.gameez_progetto.repository;

import co.develhope.gameez_progetto.entity.Ordine;
import co.develhope.gameez_progetto.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdineRepository extends JpaRepository<Ordine, Long> {

    List<Ordine> findAllByStatusOrdineTrue();
}
