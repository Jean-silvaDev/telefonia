package bcc.ifsuldeminas.sistemaDeTelefonia.controller.pessoal;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.Operadora;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.pessoal.ClientePessoaJuridica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.stream.Collectors;

//Nome: Jean Francisco Da Silva

@RestController
@RequestMapping("pessoaJuridica")
public class ClientePessoaJuridicaController {
    @Autowired
    private Operadora operadora;

    @GetMapping
    public Set<ClientePessoaJuridica> listaPessoaJuridica(){
        return this.operadora.getClientes().stream().filter(cliente -> cliente instanceof ClientePessoaJuridica).map(cliente -> (ClientePessoaJuridica)cliente).collect(Collectors.toSet());
    }

    @PostMapping
    public void salvarPessoaJuridica(@RequestBody ClientePessoaJuridica clientePessoaJuridica){
        this.operadora.addClientes(clientePessoaJuridica);
    }

    @PutMapping("{cnpj}")
    public void atualizaPessoaJuridica(@PathVariable String cnpj, @RequestBody ClientePessoaJuridica clientePessoaJuridica){
        ClientePessoaJuridica clienteF = this.operadora.getClientes().stream().map(cliente -> (ClientePessoaJuridica)cliente).filter(clientePJ -> clientePJ.getCnpj().equals(cnpj)).findFirst().get();
        clienteF.setNome(clientePessoaJuridica.getNome());
        clienteF.setEndereco(clientePessoaJuridica.getEndereco());
        clienteF.setPlano(clientePessoaJuridica.getPlano());
    }

    @DeleteMapping("{cnpj}")
    public void removerPessoaJuridica(@PathVariable String cnpj){
        ClientePessoaJuridica clienteF = this.operadora.getClientes().stream().map(cliente -> (ClientePessoaJuridica)cliente).filter(clientePJ -> clientePJ.getCnpj().equals(cnpj)).findFirst().get();
        this.operadora.removeClientes(clienteF);
    }
}
