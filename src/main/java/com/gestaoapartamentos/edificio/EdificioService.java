package com.gestaoapartamentos.edificio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestaoapartamentos.apartamento.Apartamento;
import com.gestaoapartamentos.apartamento.ApartamentoDto;
import com.gestaoapartamentos.apartamento.ApartamentoRepository;

@Service
public class EdificioService {

    private final EdificioRepository edificioRepository;

    private final ApartamentoRepository apartamentoRepository;

    public EdificioService(EdificioRepository edificioRepository, ApartamentoRepository apartamentoRepository) {
        this.edificioRepository = edificioRepository;
        this.apartamentoRepository = apartamentoRepository;
    }

    public ResponseEntity<Object> cadastrarEdificio(EdificioDto edificioDto) {
        Optional<Edificio> edificioOptional = edificioRepository.findByNome(edificioDto.getNome());
        if (edificioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este edifício já está cadastrado.");
        }
        Edificio edificio = new Edificio();
        BeanUtils.copyProperties(edificioDto, edificio);
        edificioRepository.save(edificio);

        return ResponseEntity.status(HttpStatus.CREATED).body("Edifício cadastrado com sucesso!");

    }

    public ResponseEntity<Object> listarEdificios() {
        List<Edificio> listaEdificio = edificioRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listaEdificio);
    }

    public ResponseEntity<Object> buscarEdificioPorNome(String nome) {
        Optional<Edificio> edificioOptional = edificioRepository.findByNome(nome);
        if (edificioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(edificioOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Edifício não encontrado.");
        }
    }

    public ResponseEntity<Object> cadastrarApartamento(Long idEdificio, ApartamentoDto apartamentoDto) {
        Optional<Apartamento> apartamentoOptional = apartamentoRepository.findByNumeroApartamento(apartamentoDto.getNumeroApartamento());
        if (apartamentoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este apartamento já está cadastrado.");
        }
        Apartamento apartamento = new Apartamento();
        BeanUtils.copyProperties(apartamentoDto, apartamento);
        Edificio edificio = edificioRepository.getReferenceById(idEdificio);
        apartamento.setEdificio(edificio);
        apartamentoRepository.save(apartamento);
        edificio.addApartamento(apartamento);

        return ResponseEntity.status(HttpStatus.OK).body("Apartamento cadastrado com sucesso.");
    }
}
