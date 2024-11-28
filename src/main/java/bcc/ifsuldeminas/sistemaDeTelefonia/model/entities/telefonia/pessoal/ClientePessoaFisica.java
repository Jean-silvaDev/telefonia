package bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.pessoal;

//Nome: Jean Francisco Da Silva

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ClientePessoaFisica")
public class ClientePessoaFisica extends Cliente{
    private String cpf;

    public ClientePessoaFisica(){}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}