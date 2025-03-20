package co.develhope.gameez_progetto.service;

import co.develhope.gameez_progetto.entity.Carrello;
import co.develhope.gameez_progetto.entity.Prodotto;
import co.develhope.gameez_progetto.entity.Recensione;
import co.develhope.gameez_progetto.entity.User;
import co.develhope.gameez_progetto.repository.CarrelloRepository;
import co.develhope.gameez_progetto.repository.ProdottoRepository;
import co.develhope.gameez_progetto.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarrelloService {
    @Autowired
    private CarrelloRepository carrelloRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProdottoRepository prodottoRepository;


    public Carrello createCarrello(Carrello carrello) {
        calcolaPrezzoTotale(carrello);
        return carrelloRepository.save(carrello);
    }

    private static void calcolaPrezzoTotale(Carrello carrello) {
        double totale = 0.0;
        for (Prodotto prodotto : carrello.getProdotti()) {
            totale += prodotto.getPrezzo();
        }
        carrello.setCalcoloTotale(totale);
    }

    public List<Carrello> getAllCarrelli() {
        return carrelloRepository.findAll();
    }

    public Optional<Carrello> findById(Long id) {
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()) {
            return carrelloOptional;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Carrello> addProdottoToCarrello(Long idCarrello, Long idProdotto) {
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(idCarrello);
        Optional<Prodotto> prodottoOptional = prodottoRepository.findById(idProdotto);
        if (carrelloOptional.isPresent() && prodottoOptional.isPresent()) {
            Carrello carrelloEsistente = carrelloOptional.get();
            Prodotto prodotto = prodottoOptional.get();
            // Rimuove il prodotto basandosi sull'oggetto esatto recuperato dal DB
            carrelloEsistente.getProdotti().add(prodotto);
            // Ricalcola il prezzo totale
            calcolaPrezzoTotale(carrelloEsistente);
            // Salva il carrello aggiornato
            carrelloRepository.save(carrelloEsistente);
            return Optional.of(carrelloEsistente);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Carrello> removeProdottoToCarrello(Long idCarrello, Long idProdotto) {
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(idCarrello);
        Optional<Prodotto> prodottoOptional = prodottoRepository.findById(idProdotto);
        if (carrelloOptional.isPresent() && prodottoOptional.isPresent()) {
            Carrello carrelloEsistente = carrelloOptional.get();
            Prodotto prodotto = prodottoOptional.get();
            // Rimuove il prodotto basandosi sull'oggetto esatto recuperato dal DB
            carrelloEsistente.getProdotti().remove(prodotto);
            // Ricalcola il prezzo totale
            calcolaPrezzoTotale(carrelloEsistente);
            // Salva il carrello aggiornato
            carrelloRepository.save(carrelloEsistente);
            return Optional.of(carrelloEsistente);
        } else {
            return Optional.empty();
        }
    }
}
