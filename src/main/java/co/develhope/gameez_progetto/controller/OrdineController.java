package co.develhope.gameez_progetto.controller;

import co.develhope.gameez_progetto.entity.Ordine;
import co.develhope.gameez_progetto.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordine")
public class OrdineController {
    @Autowired
    private OrdineService ordineService;

    @PostMapping("/create-ordine")
    public ResponseEntity<Ordine> createOrdine(@RequestBody Ordine ordine) {
        Ordine ordine1 = ordineService.creaOrdine(ordine);
        return ResponseEntity.ok(ordine1);
    }

    @GetMapping("/get-all-ordini-attivi")
    public ResponseEntity<List<Ordine>> getAllOrdini() {
        List<Ordine> ordineList = ordineService.getAllOrdini();
        return ResponseEntity.ok(ordineList);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Optional<Ordine>> findById(@PathVariable Long id) {
        Optional<Ordine> ordineOptional = ordineService.findById(id);
        if (ordineOptional.isPresent()) {
            return ResponseEntity.ok(ordineOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Ordine>> updateById(@PathVariable Long id, @RequestBody Ordine ordine) {
        Optional<Ordine> ordineOptional = ordineService.updateOrdine(id, ordine);
        if (ordineOptional.isPresent()) {
            return ResponseEntity.ok(ordineOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/delete-logical/{id}")
    public ResponseEntity<Optional<Ordine>> deleteLogicalById(@PathVariable Long id) {
        Optional<Ordine> ordineOptional = ordineService.deleteLogicalOrdine(id);
        if (ordineOptional.isPresent()) {
            return ResponseEntity.ok(ordineOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/active-status/{id}")
    public ResponseEntity<Optional<Ordine>> updateStatusById(@PathVariable Long id) {
        Optional<Ordine> ordineOptional = ordineService.deleteLogicalOrdine(id);
        if (ordineOptional.isPresent()) {
            return ResponseEntity.ok(ordineOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}