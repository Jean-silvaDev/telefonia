package bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.pessoal.Cliente;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

//Nome: Jean Francisco Da Silva
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Herança
@DiscriminatorColumn(name = "classe")
public class Celular{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long numero;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Plano plano;
    @OneToMany
    @JoinColumn(name = "celular_id")
    private Set<Ligacao> ligacoes;

    public Celular() {
        this.ligacoes = new HashSet<>();
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Set<Ligacao> getLigacoes() {
        return ligacoes;
    }

    public void addLigacoes(Ligacao ligacao) {
        this.ligacoes.add(ligacao);
    }

    public void removeLigacoes(Ligacao ligacao) {
        this.ligacoes.remove(ligacao);
    }
}