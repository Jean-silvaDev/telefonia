package bcc.ifsuldeminas.sistemaDeTelefonia.controller.comercial;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.Operadora;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial.CelularPosPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.stream.Collectors;

//Nome: Jean Francisco Da Silva

@RestController
@RequestMapping("celularPosPago")
public class CelularPosPagoController {
    @Autowired
    private Operadora operadora;

    @GetMapping
    public Set<CelularPosPago> listarPosPago(){
        return this.operadora.getCelulares().stream().filter(celular -> celular instanceof CelularPosPago).map(celular -> (CelularPosPago)celular).collect(Collectors.toSet());
    }

    @PostMapping
    public void salvarPosPago(@RequestBody CelularPosPago celularPosPago){
        this.operadora.addCelulares(celularPosPago);
    }

    @PutMapping("{numero}")
    public void atualizarPosPago(@PathVariable long numero, @RequestBody CelularPosPago celularPosPago){
        CelularPosPago celularF = (CelularPosPago) this.operadora.getCelulares().stream().filter(celular -> celular.getNumero() == numero).findFirst().get();
        celularF.setCliente(celularPosPago.getCliente());
        celularF.setPlano(celularPosPago.getPlano());
        celularF.setDiaDeVencimento(celularPosPago.getDiaDeVencimento());
    }

    @DeleteMapping("{numero}")
    public void deletaPosPago(@PathVariable long numero){
        CelularPosPago celularF = (CelularPosPago) this.operadora.getCelulares().stream().filter(celular -> celular.getNumero() == numero).findFirst().get();
        this.operadora.removeCelulares(celularF);
    }
}
