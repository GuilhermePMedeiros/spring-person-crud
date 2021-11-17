package br.com.guilhermesolucoes.lojacrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.guilhermesolucoes.lojacrud.nucleo.utils.validacoes.ValidaCPF;
import br.com.guilhermesolucoes.lojacrud.pessoa.Pessoa;
import br.com.guilhermesolucoes.lojacrud.pessoa.PessoaService;

/**
 * @author Guilherme Pacheco De Medeiros
 * @version 1.0
 */

//@RestController
@org.springframework.stereotype.Controller
public class Controller {

	//instanciando a classe service do objeto Pessoa
	@Autowired
	PessoaService pessoaService = new PessoaService();
	
	//Objeto da api string para model e view.
	private ModelAndView mv;
	
	//Método de requisição para página inicial (Index).
	@GetMapping("/index")
	public String getIndex(){
		return "index";
	}
	
	//Método de requisição para página da listagem das pessoas cadastradas (pessoasList).
	@GetMapping("/pessoa/pessoasList")
	public ModelAndView getPessoasList(RedirectAttributes attributes) {
		mv = new ModelAndView("pessoa/pessoasList");
		List<Pessoa> pessoasList = pessoaService.findAll();
		mv.addObject("pessoasList", pessoasList);
		return mv;
	}
	
	//Método de requisição para página dos detalhamentos da pessoa por id (pessoaDetalhes).
	@GetMapping("/pessoa/{id}")
	public ModelAndView getPessoaById(@PathVariable("id") int id){
		mv = new ModelAndView("pessoa/pessoaDetails");
		Pessoa pessoa = pessoaService.findById(id);
		mv.addObject("pessoa", pessoa);
		return mv;
	}
	
	//Método de requisição para página de formulario para adicionar a pessoa (pessoaForm).
	@GetMapping("/pessoa/pessoaForm")
	public ModelAndView getNewPessoa() {
		mv = new ModelAndView("pessoa/pessoaForm");
		Pessoa pessoa = new Pessoa(0);
		mv.addObject("pessoa", pessoa);
		return mv;
	}
	
	//Método de requisição para página de formulario para alterar a pessoa by id (pessoaForm).
	@GetMapping("/pessoa/pessoaForm/update/{id}")
	public ModelAndView editPessoaById(@PathVariable("id") int id) {
		mv = new ModelAndView("pessoa/pessoaForm");
		Pessoa pessoa = pessoaService.findById(id);
		mv.addObject("pessoa", pessoa);
		return mv;
	}
	
	//Método de requisição para página de formulário para salvar a pessoa (pessoaForm).
	@PostMapping("/pessoa/pessoaForm/save")
	public String savePessoa(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attributes) {
		// se apresentar algum erro no processo de salvamento da pessoa
		if(result.hasErrors()) {
			//imprimir no console o erro
			System.out.println(result.toString());
			//Enviar uma mensagem de alerta para o formulário e redirecionar para o mesmo 
			attributes.addFlashAttribute("mensage", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/pessoa/pessoaForm";
		}
		//Se o CPF não for inválido ...
		if(!ValidaCPF.isCPF(pessoa.getCpf())) {
			//Enviar uma mensagem de alerta para o formulário e redirecionar para o mesmo
			attributes.addFlashAttribute("mensage", "CPF inválido! Por favor, digite novamente.");
			return "redirect:/pessoa/pessoaForm";
		}
		//Se tudo ocorreu bem...
		//salva a pessoa e redireciona para a página da listagem das pessoas
		pessoaService.saveObject(pessoa);
		return "redirect:/pessoa/pessoasList";
	}
	
	//Método de requisição para página de formulário para alterar a pessoa (pessoaForm).
		
		//@PutMapping("/pessoa/pessoaForm")
		@PostMapping("/pessoa/update/{id}")
		public String updatePessoa(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attributes) {
			// se apresentar algum erro no processo de salvamento da pessoa
			if(result.hasErrors()) {
				//imprimir no console o erro
				System.out.println(result.toString());
				//Enviar uma mensagem de alerta para o formulário e redirecionar para o mesmo 
				attributes.addFlashAttribute("mensage", result.toString());
				return "redirect:/pessoa/pessoaForm";
			}
			//Se o CPF não for inválido ...
			if(!ValidaCPF.isCPF(pessoa.getCpf())) {
				//Enviar uma mensagem de alerta para o formulário e redirecionar para o mesmo
				attributes.addFlashAttribute("mensage", "CPF inválido! Por favor, digite novamente.");
				return "redirect:/pessoa/pessoaForm";
			}
			//Se tudo ocorreu bem...
			//salva a pessoa e redireciona para a página da listagem das pessoas
			System.out.println(pessoa.getId());
			pessoaService.updateObjectById(pessoa.getId(), pessoa);
			return "redirect:/pessoa/pessoasList";
		}
	
	//Método de requisição para remover uma pessoa por id.
	@GetMapping("/pessoa/remove/{id}")
	public String removePessoaById(@PathVariable("id") int id, RedirectAttributes attributes) {
		//...
		pessoaService.removeById(id);
		return "redirect:/pessoa/pessoasList";
	}
	
}
