package co.develhope.gameez_progetto.controller;

import co.develhope.gameez_progetto.service.RecensioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recensione")
public class RecensioneController {
    @Autowired
    private RecensioneService recensioneService;
}
