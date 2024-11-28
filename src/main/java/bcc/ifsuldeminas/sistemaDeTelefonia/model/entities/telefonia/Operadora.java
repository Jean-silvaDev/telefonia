package bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial.*;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.pessoal.Cliente;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

//Nome: Jean Francisco Da Silva

@Entity
public class Operadora{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToMany // Relacionamento unidirecional(mappedBy(Bidirecional))
    @JoinColumn(name = "operadora_id")
    private Set<Cliente> clientes;
    @OneToMany
    @JoinColumn(name = "operadora_id")
    private Set<Celular> celulares;
    @OneToMany
    @JoinColumn(name = "operadora_id")
    private Set<Plano> planos;

    public Operadora(){
        this.planos = new HashSet<>();
        this.clientes = new HashSet<>();
        this.celulares = new HashSet<>();
    }

    public Set<Plano> getPlanos() {
        return planos;
    }

    public String getNome() {
        return nome;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setCelulares(Set<Celular> celulares) {
        this.celulares = celulares;
    }

    public void setPlanos(Set<Plano> planos) {
        this.planos = planos;
    }

    public void addPlano(Plano plano){
        this.planos.add(plano);
    }

    public void removerPlano(Plano plano){
        this.planos.remove(plano);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void addClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void removeClientes(Cliente cliente) {
        this.clientes.remove(cliente);
    }

    public Set<Celular> getCelulares() {
        return celulares;
    }

    public void addCelulares(Celular celular) {
        this.celulares.add(celular);
    }

    public void removeCelulares(Celular celular) {
        this.celulares.remove(celular);
    }
}