package co.develhope.gameez_progetto.repository;

import co.develhope.gameez_progetto.entity.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
//todo metodi: findAll, activateStatusProdotto(fa tornare da false a true lo status), deleteLogical,
}
