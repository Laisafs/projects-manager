package one.digitalinnovation.projectsmanager.service;

import one.digitalinnovation.projectsmanager.model.Projeto;

public interface ProjetoService {

	Iterable<Projeto> buscarTodos();
	
	Projeto buscarPorId(Long id);
	
	void inserir(Projeto produto);
	
	void atualizar(Long id, Projeto produto);
	
	void deletar(Long id);
}
