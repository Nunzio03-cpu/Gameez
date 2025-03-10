package co.develhope.gameez_progetto.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "recensione")
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "data")
    private LocalDate data = LocalDate.now();
    @Column(name = "commento")
    private String commento;
    @Column(name = "status_recensione")
    private boolean statusRecensione = true;

    public Recensione() {}

    public Recensione(Long id, String commento) {
        this.id = id;
        this.commento = commento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public boolean isStatusRecensione() {
        return statusRecensione;
    }

    public void setStatusRecensione(boolean statusRecensione) {
        this.statusRecensione = statusRecensione;
    }
}
