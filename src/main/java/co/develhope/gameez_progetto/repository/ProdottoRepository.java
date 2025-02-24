package co.develhope.gameez_progetto.repository;

import co.develhope.gameez_progetto.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
}
