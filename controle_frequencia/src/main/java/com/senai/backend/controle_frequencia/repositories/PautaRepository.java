package com.senai.backend.controle_frequencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.models.Pauta;

@Repository
public interface PautaRepository extends JpaRepository <Pauta, Integer>{


    
}
