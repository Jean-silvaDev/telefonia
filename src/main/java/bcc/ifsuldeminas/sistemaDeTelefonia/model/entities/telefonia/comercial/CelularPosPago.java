package bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial;

//Nome: Jean Francisco Da Silva

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "CelularPosPago")
public class CelularPosPago extends Celular {
    private int diaDeVencimento;

    public CelularPosPago() {}

    public int getDiaDeVencimento() {
        return diaDeVencimento;
    }

    public void setDiaDeVencimento(int diaDeVencimento) {
        this.diaDeVencimento = diaDeVencimento;
    }
}
