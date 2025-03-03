package co.develhope.gameez_progetto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "prodotto_id")
    private List<Prodotto> prodotti;
    @Column(name = "calcolo_totale")
    private Double calcoloTotale;
    @Column(name= "status_carrello")
    private boolean statusCarrello;



    public Carrello() {}

    public Carrello(Long id, User user, List<Prodotto> prodotti) {
        this.id = id;
        this.user = user;
        this.prodotti = prodotti;
        this.statusCarrello = true;
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

