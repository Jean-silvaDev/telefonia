package bcc.ifsuldeminas.sistemaDeTelefonia.configuration;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.Operadora;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Nome: Jean Francisco Da Silva

@Configuration
public class Configuracoes {
    @Bean
    public Operadora operadora(){
        return new Operadora();
    }
}
