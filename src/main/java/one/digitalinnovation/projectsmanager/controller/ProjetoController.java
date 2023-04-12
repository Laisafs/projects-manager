package one.digitalinnovation.projectsmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.projectsmanager.model.Projeto;
import one.digitalinnovation.projectsmanager.service.ProjetoService;

@RestController
@RequestMapping("projeto")
public class ProjetoController {

	@Autowired
	private ProjetoService produtoService;
	
	@GetMapping
	public ResponseEntity<Iterable<Projeto>> buscarTodos() {
		return ResponseEntity.ok(produtoService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Projeto> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(produtoService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Projeto> inserir(@RequestBody Projeto projeto) {
		produtoService.inserir(projeto);
		return ResponseEntity.ok(projeto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Projeto> atualizar(@PathVariable Long id, @RequestBody Projeto projeto) {
		produtoService.atualizar(id, projeto);
		return ResponseEntity.ok(projeto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) { 
		produtoService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
