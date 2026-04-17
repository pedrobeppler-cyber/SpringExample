package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.controle_frequencia.services.PautaService;
import com.senai.models.Pauta;
import com.senai.models.Usuario;

@RestController
@RequestMapping("/pauta")
public class PautaControllers {
    
    @Autowired
    private PautaService pautaService;

    @GetMapping("/contar-pautas")
    public Long contarPautas(){
        return pautaService.contarPautas();
    }

    @GetMapping("/buscar-pautas/{id}")
    public Pauta buscarPauta(@PathVariable Integer id){
        return pautaService.buscarPauta(id);
    }

    @GetMapping("/listar-pautas")
    public List<Pauta> listarPautas(){
        return pautaService.listarPautas();
    }

    @DeleteMapping("/deletar-pauta/{id}")
    public String deletarPauta(@PathVariable Integer id){
        if (pautaService.deletarPauta(id)) {
            return "Pauta excluida com sucesso";
        }
        return "Falha na exclusão da pauta";
    }

    @PostMapping("/salvar-pauta")
    public Pauta cadastrarPauta(@RequestBody Pauta pauta){
        return pautaService.cadastrarPauta(pauta);
    }

    @PutMapping("/atualizar-pauta/{id}")
    public String atualizarPauta(
        @PathVariable Integer id,
        @RequestBody Pauta pauta
    ){
        if (pautaService.atualizarPauta(id, pauta)!= null) {
            return "Pauta atualizada com sucesso";
        }
        return "Falha na atualização da pauta";
    }


}
