package co.develhope.gameez_progetto.service;

import co.develhope.gameez_progetto.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdottoService {
    @Autowired
    private ProdottoRepository prodottoRepository;
}
