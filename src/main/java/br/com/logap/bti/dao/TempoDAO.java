package br.com.logap.bti.dao;

import org.hibernate.HibernateException;

import br.com.logap.bti.dominio.DadosColetados;


public class TempoDAO extends PadraoDAO<DadosColetados> {

	public DadosColetados buscarPorId(long id) throws HibernateException, IndexOutOfBoundsException {
		return super.buscarPorIdClasse(id, DadosColetados.class);
	}
	
}
