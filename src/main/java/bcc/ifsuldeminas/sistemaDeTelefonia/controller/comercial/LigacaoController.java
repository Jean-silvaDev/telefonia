package bcc.ifsuldeminas.sistemaDeTelefonia.controller.comercial;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.Operadora;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial.Celular;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial.Ligacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

//Nome: Jean Francisco Da Silva

@RestController
@RequestMapping("ligacao")
public class LigacaoController {
    @Autowired
    private Operadora operadora;

    @GetMapping("{numero}")
    public Set<Ligacao> listarLigacoes(@PathVariable long numero){
        return this.operadora.getCelulares().stream().filter(celular -> celular.getNumero() == numero).findFirst().get().getLigacoes();
    }

    @PostMapping("{numero}")
    public void salvarLigacao(@PathVariable long numero, @RequestBody Ligacao ligacao){
        this.operadora.getCelulares().stream().filter(celular -> celular.getNumero() == numero).findFirst().get().addLigacoes(ligacao);
    }

    @PutMapping("{numero}")
    public void atualizarLigacao(@PathVariable long numero, @RequestBody Ligacao ligacao){
        Set<Ligacao> ligacoes = this.operadora.getCelulares().stream().filter(celular -> celular.getNumero() == numero).findFirst().get().getLigacoes();
        ligacoes.stream().filter(lig -> lig.getData().equals(ligacao.getData())).findFirst().get().setDuracao(ligacao.getDuracao());
    }

    @DeleteMapping("{numero}")
    public void deletarLigacao(@PathVariable long numero, @RequestParam int duracao){
        Celular celularF = this.operadora.getCelulares().stream().filter(celular -> celular.getNumero() == numero).findFirst().get();
        celularF.removeLigacoes(celularF.getLigacoes().stream().filter(lig -> lig.getDuracao() == duracao).findFirst().get());
    }
}
