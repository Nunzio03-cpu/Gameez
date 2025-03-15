package co.develhope.gameez_progetto.service;

import co.develhope.gameez_progetto.entity.Ordine;
import co.develhope.gameez_progetto.repository.OrdineRepository;
import co.develhope.gameez_progetto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OrdineService {
    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private UserRepository userRepository;



    // Metodo per recuperare l'ordine tramite ID (puoi sostituirlo con la logica effettiva di repository)
    private Ordine getOrdineById(Long ordineId) {
        return ordineRepository.findById(ordineId).orElse(null);
    }

    // Calcola il costo di spedizione in base alla città
    private Double calcolaCostoSpedizionePerCitta(String citta) {
        // Se citta è null o una stringa vuota (""), restituisce 7.99 (presumibilmente il costo di spedizione predefinito).
        if (citta == null || citta.isEmpty()) return 7.99;

        // Generazione random basata sulla città
        int generate = citta.hashCode();  // Fisso per ogni città, viene utilizzato per generare un valore hash,
        // che è un numero intero derivato dallo stato interno di un oggetto
        Random random = new Random(generate);

        // Calcola il costo in base alla città con un offset fisso e un valore random
        double costoSpedizione = 4.99 + random.nextInt(500) / 100.0;  // Tra 4.99€ e 9.99€

        // Formatta il costo con due decimali
        String costoFormattato = String.format("%.2f", costoSpedizione);

        // Sostituisce la virgola con il punto nel caso in cui il sistema locale usi la virgola
        return Double.valueOf(costoFormattato.replace(",", "."));
    }


    // Metodo per calcolare il costo di spedizione
    public Double calcolaCostoSpedizione(Long ordineId) {
        // Recupera l'ordine
        Ordine ordine = getOrdineById(ordineId);

        if (ordine == null || ordine.getCarrello() == null || ordine.getCarrello().getUser() == null) {
            return 0.0;
        }

        String citta = ordine.getCarrello().getUser().getCitta();

        // Restituisce il costo con due decimali (già formattato dalla funzione precedente)
        return calcolaCostoSpedizionePerCitta(citta);
    }

    public Ordine creaOrdine(Ordine ordine) {
        // Se la città è presente nel JSON, la imposta direttamente nell'oggetto ordine
        if (ordine.getCitta() != null) {
            // Usa la città passata direttamente nel JSON
            ordine.setCostoSpedizione(calcolaCostoSpedizionePerCitta(ordine.getCitta()));
        } else {
            // Se la città non è presente, gestisci l'errore o imposta una città di default
            ordine.setCitta("Città sconosciuta");
        }

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
