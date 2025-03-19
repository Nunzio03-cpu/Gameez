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


    public Carrello createCarrello(Carrello carrello){
        double totale = 0.0;
        for (Prodotto prodotto : carrello.getProdotti()) {
            totale += prodotto.getPrezzo();
        }
        carrello.setCalcoloTotale(totale);
        return carrelloRepository.save(carrello);
    }

    public List<Carrello> getAllCarrelli(){
        return carrelloRepository.findAllByStatusCarrelloTrue();
    }

    public Optional<Carrello> findById(Long id){
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()){
            return carrelloOptional;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Carrello> updateCarrello(Long id, Carrello carrello) {
        Double totale = 0.0;
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()) {
            Carrello carrelloEsistente = carrelloOptional.get();
            // Rimuove i prodotti esistenti dal carrello senza eliminarli dal database
            List<Prodotto> prodottiDaRimuovere = new ArrayList<>();
            for (Prodotto prodotto : carrelloEsistente.getProdotti()) {
                if (!carrello.getProdotti().contains(prodotto)) {
                    prodottiDaRimuovere.add(prodotto);
                }
            }
            // Rimuove i prodotti dal carrello senza eliminarli dal database
            carrelloEsistente.getProdotti().removeAll(prodottiDaRimuovere);
            // Aggiunge i nuovi prodotti
            for (Prodotto prodotto : carrello.getProdotti()) {
                if (!carrelloEsistente.getProdotti().contains(prodotto)) {
                    carrelloEsistente.getProdotti().add(prodotto);
                }
            }
            // Calcola il totale
            for (Prodotto prodotto : carrelloEsistente.getProdotti()) {
                totale += prodotto.getPrezzo();
            }

            carrelloEsistente.setCalcoloTotale(totale);
            carrelloRepository.save(carrelloEsistente);
            return Optional.of(carrelloEsistente);
        } else {
            return Optional.empty();
        }
    }




    public Optional<Carrello> deleteLogical(Long id){
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()){
            Carrello carrello = carrelloOptional.get();
            carrello.setStatusCarrello(false);
            carrelloRepository.save(carrello);
            return  Optional.of(carrello);
        }else{
            return Optional.empty();
        }
    }

    public Optional<Carrello> activeStatus(Long id){
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()){
            Carrello carrello = carrelloOptional.get();
            carrello.setStatusCarrello(true);
            carrelloRepository.save(carrello);
            return  Optional.of(carrello);
        }else{
            return Optional.empty();
        }
    }
}
