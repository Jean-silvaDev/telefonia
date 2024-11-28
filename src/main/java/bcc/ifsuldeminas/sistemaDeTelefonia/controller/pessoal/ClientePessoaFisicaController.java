package bcc.ifsuldeminas.sistemaDeTelefonia.controller.pessoal;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.Operadora;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.pessoal.ClientePessoaFisica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.stream.Collectors;

//Nome: Jean Francisco Da Silva

@RestController
@RequestMapping("pessoaFisica")
public class ClientePessoaFisicaController {
    @Autowired
    private Operadora operadora;

    @GetMapping
    public Set<ClientePessoaFisica> listarPessoasFisicas(){
        return this.operadora.getClientes().stream().filter(cliente -> cliente instanceof ClientePessoaFisica).map(cliente -> (ClientePessoaFisica)cliente).collect(Collectors.toSet());
    }

    @PostMapping
    public void salvarPessoaFisica(@RequestBody ClientePessoaFisica clientePessoaFisica){
        this.operadora.addClientes(clientePessoaFisica);
    }

    @PutMapping("{cpf}")
    public void atualizarPessoaFisica(@PathVariable String cpf, @RequestBody ClientePessoaFisica clientePessoaFisica){
        ClientePessoaFisica clienteF = this.operadora.getClientes().stream().map(cliente -> (ClientePessoaFisica)cliente).filter(cliente -> cliente.getCpf().equals(cpf)).findFirst().get();
        clienteF.setNome(clientePessoaFisica.getNome());
        clienteF.setEndereco(clientePessoaFisica.getEndereco());
        clienteF.setPlano(clientePessoaFisica.getPlano());
    }

    @DeleteMapping("{cpf}")
    public void removerPessoaFisica(@PathVariable String cpf){
        ClientePessoaFisica clienteR = this.operadora.getClientes().stream().map(cliente -> (ClientePessoaFisica)cliente).filter(cliente -> cliente.getCpf().equals(cpf)).findFirst().get();
        this.operadora.removeClientes(clienteR);
    }
}
