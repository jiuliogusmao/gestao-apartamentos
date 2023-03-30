package com.gestaoapartamentos.apartamento;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/apartamento")
public class ApartamentoController {

	
	private final ApartamentoService apartamentoService;

	public ApartamentoController(ApartamentoService apartamentoService) {
		this.apartamentoService = apartamentoService;
	}

	@PostMapping
	public ResponseEntity<Object> cadastrarApartamento(@RequestBody ApartamentoDto apartamentoDto) {
		return apartamentoService.cadastrarApartamento(apartamentoDto);
	}
	
	@GetMapping("/disponivel")
	public ResponseEntity<Object> visualizarApartamentosDisponiveis(){
		return apartamentoService.visualizarApartamentosDisponiveis();
	}
	
	@GetMapping("/todos")
	public ResponseEntity<Object> visualizarApartamentos(){
		return apartamentoService.visualizarApartamentos();
	}
	
	@PutMapping("/atualiza")
	public ResponseEntity<Object> atualizarApartamento(@RequestBody ApartamentoDto apartamentoDto){
		return apartamentoService.atualizarApartamento(apartamentoDto);
	}
}
