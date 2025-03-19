package co.develhope.gameez_progetto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({ "nickName", "password", "dataNascita", "citta", "indirizzo", "statusUser", "recensioni"})
    private User user;
    @ManyToMany
    @JoinTable(
            name = "carrello_prodotto",
            joinColumns = @JoinColumn(name = "carrello_id"),
            inverseJoinColumns = @JoinColumn(name = "prodotto_id"))
    @JsonIgnoreProperties({"annoDiPubblicazione", "descrizione", "piattaforma", "recensioni"})
    private List<Prodotto> prodotti = new ArrayList<>();
    @Column(name = "calcolo_totale")
    private Double calcoloTotale;
    @Column(name= "status_carrello")
    private boolean statusCarrello = true;





    public Carrello() {}

    public Carrello(Long id, User user, List<Prodotto> prodotti) {
        this.id = id;
        this.user = user;
        this.prodotti = prodotti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public Double getCalcoloTotale() {
        return calcoloTotale;
    }

    public void setCalcoloTotale(Double calcoloTotale) {
        this.calcoloTotale = calcoloTotale;
    }

    public boolean isStatusCarrello() {
        return statusCarrello;
    }

    public void setStatusCarrello(boolean statusCarrello) {
        this.statusCarrello = statusCarrello;
    }
}

