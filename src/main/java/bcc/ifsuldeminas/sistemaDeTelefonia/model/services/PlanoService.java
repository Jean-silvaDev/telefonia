package bcc.ifsuldeminas.sistemaDeTelefonia.model.services;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.repositories.comercial.PlanoRepository;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial.Plano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {
    @Autowired
    PlanoRepository planoRepository;

    public Plano create(Plano plano){
        this.planoRepository.save(plano);
        return plano;
    }

    public Plano read(Long id){
        Optional opt = this.planoRepository.findById(id);
        if(!opt.isPresent()){
            throw new PlanoNotFoundException("Plano id " + id);
        }
        return (Plano)opt.get();
    }

    public ResponseEntity read(){
        return new ResponseEntity(this.planoRepository.findAll(), HttpStatus.OK);
    }

    public Plano update(Long id, Plano plano){
        Plano planoAntigo = read(id);
        planoAntigo.setNome(plano.getNome());
        planoAntigo.setValorPorMinuto(plano.getValorPorMinuto());
        this.planoRepository.save(planoAntigo);
        return plano;
    }

    public void delete(Long id) throws PlanoNotFoundException {
        if(!this.planoRepository.existsById(id)){
            throw new PlanoNotFoundException(id.toString());
        }
        this.planoRepository.deleteById(id);
    }
}
