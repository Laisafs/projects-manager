package one.digitalinnovation.projectsmanager.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.projectsmanager.model.Projeto;
import one.digitalinnovation.projectsmanager.repository.ProjetoRepository;
import one.digitalinnovation.projectsmanager.service.ProjetoService;

@Service
public class ProjetoServiceImpl implements ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Override
	public Iterable<Projeto> buscarTodos() {
		return projetoRepository.findAll();
	}

	@Override
	public Projeto buscarPorId(Long id) {
		Optional<Projeto> produto = projetoRepository.findById(id); 
		return produto.get();
	}

	@Override
	public void inserir(Projeto projeto) {
		projetoRepository.save(projeto);
	}

	@Override
	public void atualizar(Long id, Projeto projeto) {
		Projeto projetoDb = projetoRepository.findById(id).orElseGet(() -> {
			return new Projeto();
		});
		
		projetoDb.setNome(projeto.getNome());
		projetoDb.setDescricao(projeto.getDescricao());
		projetoDb.setDataCadastro(projeto.getDataCadastro());
		
		projetoRepository.save(projetoDb);
	}

	@Override
	public void deletar(Long id) {
		projetoRepository.deleteById(id);
	}

}
