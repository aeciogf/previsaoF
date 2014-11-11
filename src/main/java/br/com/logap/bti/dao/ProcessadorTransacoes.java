package br.com.logap.bti.dao;

import java.io.IOException;

import javax.inject.Inject;

import org.hibernate.HibernateException;

import br.com.logap.bti.dominio.DadosColetados;

public class ProcessadorTransacoes {
	@Inject
	private TempoDAO tempoDAO;

	@Inject
	private Arquivo arquivo;
	
	public ProcessadorTransacoes() {
	}
	
	public void criarArquivo() throws IOException{
		arquivo.criar();
	}
	
	public void transferirRegistrosArquivo(String lista) throws IOException{
		arquivo.transferirRegistros(lista);
	}
	
	
	public boolean atualizar(DadosColetados dados) throws HibernateException {
		return tempoDAO.atualizar(dados);
	}
	
	public DadosColetados buscarPorId(long id) throws HibernateException, IndexOutOfBoundsException {
		return tempoDAO.buscarPorId(id);
	}
	
	public String buscarTudo() throws HibernateException, IndexOutOfBoundsException {
		return tempoDAO.buscarTudo().toString();
	}
	
	public boolean inserir(DadosColetados dados) throws HibernateException {
		return tempoDAO.inserir(dados);
	}
	
	public boolean remover(DadosColetados dados) throws HibernateException {
		return tempoDAO.remover(dados);
	}
}