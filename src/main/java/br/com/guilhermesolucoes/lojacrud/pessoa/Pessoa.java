package br.com.guilhermesolucoes.lojacrud.pessoa;


import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.guilhermesolucoes.lojacrud.nucleo.utils.indicadores.IndSexo;
import br.com.guilhermesolucoes.lojacrud.nucleo.utils.validacoes.ValidaCPF;

/**
 * @author Guilherme Pacheco De Medeiros
 * @version 1.0
 */

@Entity
@Table(name = "TB_Pessoa")
public class Pessoa {

	//Attributes... 
	//Atributos...
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@NotBlank
	@Column(name = "rg", nullable = false)
	private String rg;
	
	@NotBlank
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;
	
	@Column(name = "sexo", nullable = false)
	@Enumerated(value = EnumType.ORDINAL)
	private IndSexo sexo;
	
	@JsonFormat (shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "dt_nascimento", nullable = false)
	private Date dtNascimento;
	
	//builders...
	//Construtores...
	public Pessoa(){
	
	}

	public Pessoa(int id) {
		this.id = id;
	}

	public Pessoa(int id, String cpf) {
		this.id = id;
		this.cpf = cpf;
	}

	public Pessoa(int id, String cpf, String rg) {
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
	}

	public Pessoa(int id, String cpf, String rg, String nome) {
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
	}
	
	public Pessoa(int id, String cpf, String rg, String nome, IndSexo sexo) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.sexo = sexo;
	}

	public Pessoa(int id, String cpf, String rg, String nome, IndSexo sexo, Date dtNascimento) {
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.sexo = sexo;
		this.dtNascimento = dtNascimento;
	}

	//Methods Gets and sets... 
	//Métodos Gets e Sets...
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCpfFormatado() {
		return ValidaCPF.imprimeCPFormatado(this.cpf);
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public IndSexo getSexo() {
		return sexo;
	}

	public void setSexo(IndSexo sexo) {
		this.sexo = sexo;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	//Method To String...
	//Método To Sting...
	@Override
	public String toString() {
		return  "Pessoa" + "\n" +
				"Id: " + id + "\n" +
				"Cpf: " + cpf + "\n" + 
				"Rg: " + rg + "\n" +
				"Nome: " + nome + "\n" + 
				"Sexo: " + sexo.getDescricao() + "\n" +
				"Data de Nascimento: " + dtNascimento;
	}
	
}
