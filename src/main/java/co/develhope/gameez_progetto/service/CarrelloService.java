package co.develhope.gameez_progetto.service;

import co.develhope.gameez_progetto.entity.Carrello;
import co.develhope.gameez_progetto.entity.Prodotto;
import co.develhope.gameez_progetto.entity.Recensione;
import co.develhope.gameez_progetto.entity.User;
import co.develhope.gameez_progetto.repository.CarrelloRepository;
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

    public Optional<Carrello> addProdottoToCarrello(Long id, Prodotto prodotto) {
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()) {

            Carrello carrelloEsistente = carrelloOptional.get();

            carrelloEsistente.addProdotto(prodotto);

            Carrello carrelloAggiornato = carrelloRepository.save(carrelloEsistente);

            calcolaPrezzoTotale(carrelloAggiornato);

            return Optional.of(carrelloAggiornato);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Carrello> removeProdottoToCarrello(Long id, Prodotto prodotto) {
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()) {

            Carrello carrelloEsistente = carrelloOptional.get();

            carrelloEsistente.removeProdotto(prodotto);

            Carrello carrelloAggiornato = carrelloRepository.save(carrelloEsistente);

            calcolaPrezzoTotale(carrelloAggiornato);

            return Optional.of(carrelloAggiornato);
        } else {
            return Optional.empty();
        }
    }
}
