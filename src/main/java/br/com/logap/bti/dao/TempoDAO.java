package br.com.logap.bti.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;

import br.com.logap.bti.dominio.DadosColetados;


public class TempoDAO extends PadraoDAO<DadosColetados> {

	public DadosColetados buscarPorId(long id) throws HibernateException, IndexOutOfBoundsException {
		return super.buscarPorIdClasse(id, DadosColetados.class);
	}
	
	public ArrayList<String> buscarTudo() {
		return super.buscarTudo(DadosColetados.class);
	}
}
