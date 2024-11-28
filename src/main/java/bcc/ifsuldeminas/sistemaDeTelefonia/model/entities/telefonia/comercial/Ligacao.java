package bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial;

import jakarta.persistence.*;

import java.util.Date;

//Nome: Jean Francisco Da Silva

@Entity
public class Ligacao{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date data;
    private int duracao;

    public Ligacao() {}

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}