package co.develhope.gameez_progetto.controller;

import co.develhope.gameez_progetto.service.GameezService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameez")
public class GameezController {
    @Autowired
    private GameezService gameezService;
}
