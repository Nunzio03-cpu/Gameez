package co.develhope.gameez_progetto.controller;

import co.develhope.gameez_progetto.entity.Carrello;
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

    @GetMapping("/get-all-carrelli-attivi")
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
    //todo cancellare
    //todo fare i metodi di add e remove(vedere CoarrelloService)
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Carrello>> updateCarrello(@PathVariable Long id, @RequestBody Carrello carrello) {
        Optional<Carrello> updatedCarrello = carrelloService.updateCarrello(id, carrello);
        return ResponseEntity.ok(updatedCarrello);
    }

    @PutMapping("/delete-logical/{id}")
    public ResponseEntity<Optional<Carrello>> deleteLogical(@PathVariable Long id){
        Optional<Carrello> carrelloOptional = carrelloService.deleteLogical(id);
        if (carrelloOptional.isPresent()){
            return ResponseEntity.ok(carrelloOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/active-status/{id}")
    public ResponseEntity<Optional<Carrello>> activeStatus(@PathVariable Long id){
        Optional<Carrello> carrelloOptional = carrelloService.activeStatus(id);
        if (carrelloOptional.isPresent()){
            return ResponseEntity.ok(carrelloOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
