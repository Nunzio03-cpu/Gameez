package co.develhope.gameez_progetto.service;

import co.develhope.gameez_progetto.entity.Prodotto;
import co.develhope.gameez_progetto.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {
    @Autowired
    private ProdottoRepository prodottoRepository;


    public Prodotto createProdotto(Prodotto prodotto) {
        return prodottoRepository.save(prodotto);
    }

    public List<Prodotto> getAllProdotti() {
        return prodottoRepository.findAllByStatusProdottoTrue();
    }

    public Optional<Prodotto> cercaPerId(Long id) {
        return prodottoRepository.findById(id);
    }

    public Optional<Prodotto> updateProdotto(Long id, Prodotto updateProdotto){
        Optional<Prodotto> prodottoOptional = prodottoRepository.findById(id);
        if(prodottoOptional.isPresent()){
            prodottoOptional.get().setTitolo(updateProdotto.getTitolo());
            prodottoOptional.get().setAnnoDiPubblicazione(updateProdotto.getAnnoDiPubblicazione());
            prodottoOptional.get().setDescrizione(updateProdotto.getDescrizione());
            prodottoOptional.get().setPiattaforma(updateProdotto.getPiattaforma());
            Prodotto prodotto = prodottoRepository.save(prodottoOptional.get());
            return Optional.of(prodotto);
        } else{
            return Optional.empty();
        }
    }

    public Optional<Prodotto> deleteLogicalProdotto(Long id) {
        Optional<Prodotto> prodottoOpt = prodottoRepository.findById(id);
        if (prodottoOpt.isPresent()) {
            Prodotto prodotto = prodottoOpt.get();
            prodotto.setStatusProdotto(false);
            return Optional.of(prodottoRepository.save(prodotto));
        }
        return Optional.empty();
    }

    public Optional<Prodotto> activateStatusProdotto(Long id) {
        Optional<Prodotto> prodottoOpt = prodottoRepository.findById(id);
        if (prodottoOpt.isPresent()) {
            Prodotto prodotto = prodottoOpt.get();
            prodotto.setStatusProdotto(true);
            return Optional.of(prodottoRepository.save(prodotto));
        }
        return Optional.empty();
    }




}
