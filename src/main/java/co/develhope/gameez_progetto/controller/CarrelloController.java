package co.develhope.gameez_progetto.controller;

import co.develhope.gameez_progetto.entity.Carrello;
import co.develhope.gameez_progetto.entity.Prodotto;
import co.develhope.gameez_progetto.service.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrello")
public class CarrelloController {
    @Autowired
    private CarrelloService carrelloService;

    @PostMapping("/create")
    public ResponseEntity<Carrello> createCarrello(@RequestBody Carrello carrello){
        return ResponseEntity.ok(carrelloService.createCarrello(carrello));
    }

    @GetMapping("/get-all-carrelli")
    public ResponseEntity<List<Carrello>> gatAllCarrelli(){
        return ResponseEntity.ok(carrelloService.getAllCarrelli());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Optional<Carrello>> findById(@PathVariable Long id){
        Optional<Carrello> carrelloOptional = carrelloService.findById(id);
        if (carrelloOptional.isPresent()){
            return ResponseEntity.ok(carrelloOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/add-prodotto/{idCarrello}/{idProdotto}")
    public ResponseEntity<Optional<Carrello>> addProdotto(@PathVariable Long idCarrello, @PathVariable Long idProdotto) {
        Optional<Carrello> updatedCarrello = carrelloService.addProdottoToCarrello(idCarrello, idProdotto);
        if (updatedCarrello.isPresent()){
            return ResponseEntity.ok(updatedCarrello);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/remove-prodotto/{idCarrello}/{idProdotto}")
    public ResponseEntity<Optional<Carrello>> removeProdotto(@PathVariable Long idCarrello, @PathVariable Long idProdotto) {
        Optional<Carrello> updatedCarrello = carrelloService.removeProdottoToCarrello(idCarrello, idProdotto);
        if (updatedCarrello.isPresent()){
            return ResponseEntity.ok(updatedCarrello);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
