package bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.pessoal;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial.Plano;
import jakarta.persistence.*;

//Nome: Jean Francisco Da Silva

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Herança - Uma única tabela
@DiscriminatorColumn(name = "classe") // Coluna que irá definir qual classe é a especifica
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String endereco;
    private Plano plano;

    public Cliente(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}