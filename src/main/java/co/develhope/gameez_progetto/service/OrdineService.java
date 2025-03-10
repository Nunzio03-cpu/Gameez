package co.develhope.gameez_progetto.service;

import co.develhope.gameez_progetto.entity.Ordine;
import co.develhope.gameez_progetto.repository.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdineService {
    @Autowired
    private OrdineRepository ordineRepository;

    public Ordine creaOrdine(Ordine ordine) {
        return ordineRepository.save(ordine);
    }

    public List<Ordine> getAllOrdini() {
        return ordineRepository.findAllByStatusOrdineTrue();
    }

    public Optional<Ordine> findById(Long id) {
        Optional<Ordine> ordine = ordineRepository.findById(id);
        if (ordine.isPresent()) {
            return ordine;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Ordine> updateOrdine(Long id, Ordine ordine) {
        Optional<Ordine> optionalOrdine = ordineRepository.findById(id);
        if (optionalOrdine.isPresent()) {
            optionalOrdine.get().setCostoSpedizione(ordine.getCostoSpedizione());
            Ordine ordine1 = ordineRepository.save(optionalOrdine.get());
            return Optional.of(ordine1);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Ordine> deleteLogicalOrdine(Long id) {
        Optional<Ordine> ordineOptional = ordineRepository.findById(id);
        if (ordineOptional.isPresent()) {
            Ordine ordine = ordineOptional.get();
            ordine.setStatusOrdine(false);
            ordineRepository.save(ordine);
            return Optional.of(ordine);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Ordine> activeStatusOrdine(Long id) {
        Optional<Ordine> ordineOptional = ordineRepository.findById(id);
        if (ordineOptional.isPresent()) {
            Ordine ordine = ordineOptional.get();
            ordine.setStatusOrdine(true);
            ordineRepository.save(ordine);
            return Optional.of(ordine);
        } else {
            return Optional.empty();
        }
    }
}
