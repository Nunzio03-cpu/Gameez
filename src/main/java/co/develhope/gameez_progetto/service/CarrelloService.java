package co.develhope.gameez_progetto.service;

import co.develhope.gameez_progetto.repository.CarrelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService {
    @Autowired
    private CarrelloRepository carrelloRepository;
}
