package br.com.logap.bti.dao;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;

import org.hibernate.HibernateException;

import br.com.logap.bti.dominio.DadosColetados;

public class ProcessadorTransacoes {
	@Inject
	private TempoDAO tempoDAO;

	
	public ProcessadorTransacoes() {
	}
	
	public boolean atualizar(DadosColetados dados) throws HibernateException {
		return tempoDAO.atualizar(dados);
	}
	
	public DadosColetados buscarPorId(long id) throws HibernateException, IndexOutOfBoundsException {
		return tempoDAO.buscarPorId(id);
	}
	
	public boolean inserir(DadosColetados dados) throws HibernateException {
		return tempoDAO.inserir(dados);
	}
	
	public boolean remover(DadosColetados dados) throws HibernateException {
		return tempoDAO.remover(dados);
	}
	
	public ArrayList<String> buscarTudo() {
		return tempoDAO.buscarTudo();
	}
	
	public void criarArquivo(ArrayList<String> lista) throws IOException {
		tempoDAO.criarArquivo(lista);
	}
}