package co.develhope.gameez_progetto.service;

import co.develhope.gameez_progetto.repository.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineService {
    @Autowired
    private OrdineRepository ordineRepository;
}
