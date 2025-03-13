package co.develhope.gameez_progetto.service;

import co.develhope.gameez_progetto.entity.Carrello;
import co.develhope.gameez_progetto.entity.Prodotto;
import co.develhope.gameez_progetto.entity.Recensione;
import co.develhope.gameez_progetto.repository.CarrelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrelloService {
    @Autowired
    private CarrelloRepository carrelloRepository;


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

    public Optional<Carrello> updateCarrello(Long id, Carrello updateCarrello) {
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(id);
        if (carrelloOptional.isPresent()) {
            Carrello carrello = carrelloOptional.get();
            carrello.setProdotti(updateCarrello.getProdotti());
            double totale = 0.0;
            for (Prodotto prodotto : carrello.getProdotti()) {
                totale += prodotto.getPrezzo();
            }
            carrello.setCalcoloTotale(totale);
            return Optional.of(carrello);
        }else{
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
