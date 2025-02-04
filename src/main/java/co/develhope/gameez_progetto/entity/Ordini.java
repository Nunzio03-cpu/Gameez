package co.develhope.gameez_progetto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ordini")
public class Ordini {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "costo_spedizione")
    private Double costoSpedizione;
    @OneToOne
    @JoinColumn(name = "id_carello", nullable = false)
    private Carrello carrello;
    @ManyToOne
    @JoinColumn(name= "prezzo_prodotto", nullable = false)
    private Prodotto prodottoPrezzo;
    @ManyToOne
    @JoinColumn(name = "citta_user", nullable = false)
    private User userCitta;
    @ManyToOne
    @JoinColumn(name = "indirizzo_user", nullable = false)
    private User userIndirizzo;

    public Ordini() {
    }

    public Ordini(Long id, Double costoSpedizione, Carrello carrello, Prodotto prodottoPrezzo, User userCitta, User userIndirizzo) {
        this.id = id;
        this.costoSpedizione = costoSpedizione;
        this.carrello = carrello;
        this.prodottoPrezzo = prodottoPrezzo;
        this.userCitta = userCitta;
        this.userIndirizzo = userIndirizzo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCostoSpedizione() {
        return costoSpedizione;
    }

    public void setCostoSpedizione(Double costoSpedizione) {
        this.costoSpedizione = costoSpedizione;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public Prodotto getProdottoPrezzo() {
        return prodottoPrezzo;
    }

    public void setProdottoPrezzo(Prodotto prodottoPrezzo) {
        this.prodottoPrezzo = prodottoPrezzo;
    }

    public User getUserCitta() {
        return userCitta;
    }

    public void setUserCitta(User userCitta) {
        this.userCitta = userCitta;
    }

    public User getUserIndirizzo() {
        return userIndirizzo;
    }

    public void setUserIndirizzo(User userIndirizzo) {
        this.userIndirizzo = userIndirizzo;
    }
}
