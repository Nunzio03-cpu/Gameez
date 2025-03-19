package co.develhope.gameez_progetto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "recensione")
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private LocalDate data = LocalDate.now();

    @Column(name = "commento")
    private String commento;

    @Column(name = "status_recensione")
    private boolean statusRecensione = true;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"nome", "cognome", "email", "password", "dataNascita", "citta", "indirizzo", "recensioni", "statusUser"})
    // Evita di serializzare la lista delle recensioni dentro User
    private User user;

    @ManyToOne
    @JoinColumn(name = "prodotto_id", nullable = false)
    @JsonIgnoreProperties({"recensioni", "prezzo", "annoDiPubblicazione", "descrizione", "piattaforma", "statusProdotto", "carrello"})
    private Prodotto prodotto;


    public Recensione() {
    }

    public Recensione(Long id, String commento, User user, Prodotto prodotto) {
        this.id = id;
        this.commento = commento;
        this.user = user;
        this.prodotto = prodotto;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }
}
