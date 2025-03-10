package co.develhope.gameez_progetto.service;

import co.develhope.gameez_progetto.entity.Carrello;
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

    //public Optional<Carrello> update(Long id, Carrello updateCarrello)
    //questa entity non ha campi propri tali da aver necessità di un
    //metodo put "update"

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
