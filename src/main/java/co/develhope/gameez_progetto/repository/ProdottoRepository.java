package co.develhope.gameez_progetto.repository;

import co.develhope.gameez_progetto.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
    // Metodo per ottenere tutti i prodotti attivi (status = true)
    List<Prodotto> findAllByStatusProdottoTrue();
}
