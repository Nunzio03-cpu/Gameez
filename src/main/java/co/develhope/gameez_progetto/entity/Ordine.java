package co.develhope.gameez_progetto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ordini")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "costo_spedizione")
    private Double costoSpedizione;
    @OneToOne
    @JoinColumn(name = "carello", nullable = false)
    private Carrello carrello;
    @Column(name = "citta_di_spedizione")
    private String citta;
    @Column(name = "status_ordine")
    private boolean statusOrdine = true;

    public Ordine() {
    }

    public Ordine(Long id, Double costoSpedizione, Carrello carrello, String citta) {
        this.id = id;
        this.costoSpedizione = costoSpedizione;
        this.carrello = carrello;
        this.citta = citta;
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

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public boolean isStatusOrdine() {
        return statusOrdine;
    }

    public void setStatusOrdine(boolean statusOrdine) {
        this.statusOrdine = statusOrdine;
    }
}
