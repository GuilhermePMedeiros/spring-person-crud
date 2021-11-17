package br.com.guilhermesolucoes.lojacrud.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilhermesolucoes.lojacrud.nucleo.base.BaseService;


/**
 * @author Guilherme Pacheco De Medeiros
 * @version 1.0
 */

@Service
public class PessoaService extends BaseService<Pessoa> {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Override
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa findById(int id) {
		return pessoaRepository.findById(id).get();
	}

	@Override
	public void saveObject(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	@Override
	public void updateObjectById(int id, Pessoa pessoa) {
		//TODO
		removeById(id);
		pessoaRepository.save(pessoa);
	}
	
	@Override
	public void removeById(int id) {
		pessoaRepository.deleteById(id);
	}
	
	
}
