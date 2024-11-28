package bcc.ifsuldeminas.sistemaDeTelefonia.controller.comercial;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.Operadora;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial.CelularPrePago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.stream.Collectors;

//Nome: Jean Francisco Da Silva

@RestController
@RequestMapping("celularPrePago")
public class CelularPrePagoController {
    @Autowired
    private Operadora operadora;

    @GetMapping
    public Set<CelularPrePago> listarPrePago(){
        return this.operadora.getCelulares().stream().filter(celular -> celular instanceof CelularPrePago).map(celular -> (CelularPrePago)celular).collect(Collectors.toSet());
    }

    @PostMapping
    public void salvarPrePago(@RequestBody CelularPrePago celularPrePago){
        this.operadora.addCelulares(celularPrePago);
    }

    @PutMapping("{numero}")
    public void atualizarPrePago(@PathVariable long numero, @RequestBody CelularPrePago celularPrePago){
        CelularPrePago celularF = (CelularPrePago) this.operadora.getCelulares().stream().filter(celular -> celular.getNumero() == numero).findFirst().get();
        celularF.setCliente(celularPrePago.getCliente());
        celularF.setPlano(celularPrePago.getPlano());
        celularF.setDataDeValidade(celularPrePago.getDataDeValidade());
    }

    @DeleteMapping("{numero}")
    public void deletaPosPago(@PathVariable long numero){
        CelularPrePago celularF = (CelularPrePago) this.operadora.getCelulares().stream().filter(celular -> celular.getNumero() == numero).findFirst().get();
        this.operadora.removeCelulares(celularF);
    }
}

