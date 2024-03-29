package com.gestaoapartamentos.edificio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoapartamentos.apartamento.ApartamentoDto;

@RestController
@RequestMapping("api/v1/edificio")
public class EdificioController {

	private final EdificioService edificioService;
	public EdificioController(EdificioService edificioService) {
		this.edificioService = edificioService;
	}
	
	@PostMapping
	public ResponseEntity<Object> cadastrarEdificio(@RequestBody EdificioDto edificioDto){
		return edificioService.cadastrarEdificio(edificioDto);
	}
	
	@PostMapping("/{edificioId}/cadastroapartamento")
	public ResponseEntity<Object> cadastrarApartamento(@PathVariable Long edificioId, @RequestBody ApartamentoDto apartamentoDto){
		return edificioService.cadastrarApartamento(edificioId, apartamentoDto);
	}
	
	@GetMapping("/todos")
	public ResponseEntity<Object> listarEdificios(){
		return edificioService.listarEdificios();
	}
        
        @GetMapping("/{nome}")
        public ResponseEntity<Object> buscarEdificioPorNome(@PathVariable String nome){
            return edificioService.buscarEdificioPorNome(nome);
        }
	
}
