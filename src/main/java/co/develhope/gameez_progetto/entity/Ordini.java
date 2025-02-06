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
    @JoinColumn(name = "carello", nullable = false)
    private Carrello carrello;

    public Ordini() {
    }

    public Ordini(Long id, Double costoSpedizione, Carrello carrello) {
        this.id = id;
        this.costoSpedizione = costoSpedizione;
        this.carrello = carrello;
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
}
