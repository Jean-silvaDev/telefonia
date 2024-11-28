package bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial;

import jakarta.persistence.*;

import java.util.Date;

//Nome: Jean Francisco Da Silva

@Entity
@DiscriminatorValue(value = "CelularPrePago")
public class CelularPrePago extends Celular {
    private double saldo;
    @Temporal(TemporalType.DATE)
    private Date dataDeValidade;

    public CelularPrePago() {}

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(Date dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }
}
