package br.com.guilhermesolucoes.lojacrud.nucleo.utils.dummydata;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.guilhermesolucoes.lojacrud.nucleo.utils.indicadores.IndSexo;
import br.com.guilhermesolucoes.lojacrud.pessoa.Pessoa;
import br.com.guilhermesolucoes.lojacrud.pessoa.PessoaRepository;

/**
 * @author Guilherme Pacheco De Medeiros
 * @version 1.0
 */

@Component
public class DummyData {

	@Autowired
	PessoaRepository pessoaRepository;
	
	//@PostConstruct
	public void savePessoas() {
		
		//Lista de pessoas
		List<Pessoa> pessoaList = new ArrayList<Pessoa>();
		
		//Pessoa 1
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setCpf("13453609409");
		pessoa1.setRg("1049545");
		pessoa1.setNome("Guilherme Pacheco De Medeiros");
		pessoa1.setSexo(IndSexo.MASCULINO);
		//Date dtNascimento1 = new Date(0, 0, 0);
		//dtNascimento1.setDate(24);;
		//dtNascimento1.setMonth(10);
		//dtNascimento1.setYear(2002);
		//pessoa1.setDtNascimento(dtNascimento1);
		
		//Pessoa 2
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setCpf("03267085454");
		pessoa2.setRg("847556");
		pessoa2.setNome("Marcia Maria Pacheco");
		pessoa2.setSexo(IndSexo.FEMININO);
		//Date dtNascimento2 = new Date(0, 0, 0);
		//dtNascimento2.setDate(8);
		//dtNascimento2.setMonth(12);
		//dtNascimento2.setYear(1980);
		//pessoa1.setDtNascimento(dtNascimento2);
		
		pessoaList.add(pessoa1);
		pessoaList.add(pessoa2);
		
		for(Pessoa pessoa: pessoaList) {
			pessoaRepository.save(pessoa);
			System.out.println("______________________");
			System.out.println(pessoa.toString());
		}
	}

}
