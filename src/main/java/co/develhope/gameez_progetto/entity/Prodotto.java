package co.develhope.gameez_progetto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Prodotto")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Titolo", nullable = false, length = 255)
    private String titolo;

    private Double prezzo;

    private Integer annoDiPubblicazione;

    @Lob//Serve per lunghe descrizioni
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private PiattaformaEnum piattaforma;

    public Prodotto(String descrizione, Integer annoDiPubblicazione, Double prezzo, String titolo, Long id, PiattaformaEnum piattaforma) {
        this.descrizione = descrizione;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.prezzo = prezzo;
        this.titolo = titolo;
        this.id = id;
        this.piattaforma = piattaforma;
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

    public Integer getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(Integer annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }
}
