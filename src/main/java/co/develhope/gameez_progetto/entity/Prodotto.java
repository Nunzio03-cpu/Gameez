package co.develhope.gameez_progetto.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "prodotto")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titolo", nullable = false)
    private String titolo;
    @Column(name = "prezzo")
    private Double prezzo;
    @Column(name = "anno_di_pubblicazione")
    private Integer annoDiPubblicazione;
    @Column(name = "descrizione", length = 1000)
    @Lob//Serve per lunghe descrizioni
    private String descrizione;
    @Column(name = "piattaforma")
    @Enumerated(EnumType.STRING)
    private PiattaformaEnum piattaforma;
    @ManyToOne
    @JoinColumn(name = "carrello")
    private Carrello carrello;
    @ManyToOne
    @JoinColumn(name = "recensioni")
    private List<Recensione> recensioni;

    public Prodotto(){}

    public Prodotto(Long id, String titolo, Double prezzo, Integer annoDiPubblicazione, String descrizione,
                    PiattaformaEnum piattaforma, Carrello carrello, List<Recensione> recensioni) {
        this.id = id;
        this.titolo = titolo;
        this.prezzo = prezzo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.descrizione = descrizione;
        this.piattaforma = piattaforma;
        this.carrello = carrello;
        this.recensioni = recensioni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(Integer annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public PiattaformaEnum getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(PiattaformaEnum piattaforma) {
        this.piattaforma = piattaforma;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public List<Recensione> getRecensioni() {
        return recensioni;
    }

    public void setRecensioni(List<Recensione> recensioni) {
        this.recensioni = recensioni;
    }
}