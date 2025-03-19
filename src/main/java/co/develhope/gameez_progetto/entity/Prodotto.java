package co.develhope.gameez_progetto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String descrizione;
    @ElementCollection(targetClass = PiattaformaEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "prodotto_piattaforme", joinColumns = @JoinColumn(name = "prodotto_id"))
    @Column(name = "piattaforma")
    @Enumerated(EnumType.STRING)
    private List<PiattaformaEnum> piattaforma;
    @OneToMany(mappedBy = "prodotto", cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Recensione> recensioni;
    @Column(name = "status_prodotto")
    private boolean statusProdotto = true;

    public Prodotto(){}

    public Prodotto(Long id, String titolo, Double prezzo, Integer annoDiPubblicazione, String descrizione,
                    List <PiattaformaEnum> piattaforma, List<Recensione> recensioni) {
        this.id = id;
        this.titolo = titolo;
        this.prezzo = prezzo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.descrizione = descrizione;
        this.piattaforma = piattaforma;
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

    public List <PiattaformaEnum> getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(List <PiattaformaEnum> piattaforma) {
        this.piattaforma = piattaforma;
    }


    public List<Recensione> getRecensioni() {
        return recensioni;
    }

    public void setRecensioni(List<Recensione> recensioni) {
        this.recensioni = recensioni;
    }

    public boolean isStatusProdotto() {
        return statusProdotto;
    }

    public void setStatusProdotto(boolean statusProdotto) {
        this.statusProdotto = statusProdotto;
    }
}