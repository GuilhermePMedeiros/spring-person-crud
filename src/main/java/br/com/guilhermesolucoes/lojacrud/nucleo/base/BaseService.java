package br.com.guilhermesolucoes.lojacrud.nucleo.base;

import java.util.List;

/**
 * @author Guilherme Pacheco De Medeiros
 * @version 1.0
 */

public abstract class BaseService<T> {
	
	//métodos base para os serviços dos objetos
	public abstract List<T> findAll();
	public abstract T findById(int id);
	public abstract void saveObject(T t);
	public abstract void updateObjectById(int id,T t);
	public abstract void removeById(int id);
	
}
