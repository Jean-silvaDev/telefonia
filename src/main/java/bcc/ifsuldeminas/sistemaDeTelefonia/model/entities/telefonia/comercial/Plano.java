package bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial;

//Nome: Jean Francisco Da Silva

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private float valorPorMinuto;

    public Plano() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorPorMinuto() {
        return valorPorMinuto;
    }

    public void setValorPorMinuto(float valorPorMinuto) {
        this.valorPorMinuto = valorPorMinuto;
    }
}