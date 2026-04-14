package com.senai.backend.controle_frequencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.controle_frequencia.repositories.PautaRepository;
import com.senai.models.Pauta;

@Service
public class PautaService {
    
    @Autowired
    private PautaRepository pautaRepository;

    public Long contarPautas(){
        return pautaRepository.count();
    }

    public Pauta buscarPauta(Integer id){
        return pautaRepository.findById(id).get();
    }

    public List<Pauta> listarPautas(){
        return pautaRepository.findAll();
        
    }

    public Boolean deletarPauta(Integer id){
        if (pautaRepository.existsById(id)) {
            pautaRepository.deleteById(id);
            return true;
        }
        return false;
    }



    public Pauta cadastrarPauta(Pauta pauta){
        return pautaRepository.save(pauta);

    }

    public Pauta atualizarPauta(Integer id, Pauta pauta){
        Pauta pautaRecuperada = buscarPauta(id);
        if (pautaRecuperada != null) {
            pautaRecuperada.setId(id);
            if (pauta.getTurma()!=null) {
                pautaRecuperada.setTurma((pauta.getTurma()));
            }
            return pautaRepository.save(pautaRecuperada);
        }
        return null;
    }
}
