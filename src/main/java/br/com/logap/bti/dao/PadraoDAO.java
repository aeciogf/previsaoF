package br.com.logap.bti.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import br.com.logap.bti.dominio.PadraoDominio;

public class PadraoDAO<T extends PadraoDominio> {
	
	
	@Inject
	private Session sessao;
	
	private Transaction transacao;
	
	public PadraoDAO() {
		
	}

	public boolean atualizar(T objeto) throws HibernateException {
		iniciarOperacao();
		sessao.merge(objeto);
		encerrarOperacao();
		return true;
	}
	
	public boolean inserir(T objeto) throws HibernateException {
		iniciarOperacao();
		sessao.persist(objeto);
		encerrarOperacao();
		return true;
	}
	
	public boolean remover(T objeto) throws HibernateException {
		iniciarOperacao();
		sessao.delete(objeto);
		encerrarOperacao();
		return true;
	}
	
	public T buscarPorIdClasse(long id, Class<T> classe) throws HibernateException, IndexOutOfBoundsException {
		
		iniciarOperacao();
		
		StringBuilder textoConsulta = new StringBuilder();
		textoConsulta.append("SELECT objeto FROM ");
		textoConsulta.append(classe.getSimpleName());
		textoConsulta.append(" objeto WHERE id = ");
		textoConsulta.append(id);
		
		Query consulta = (Query) sessao.createQuery(textoConsulta.toString());
		
		@SuppressWarnings("unchecked")
		T resultado = (T) consulta.uniqueResult();
		
		encerrarOperacao();
		
		return resultado;
	}	
	
	public void criaArquivo() throws IOException {
		File arquivo = new File("arquivo.txt");
		 
		try {
		 
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
		 
		
			FileWriter fw = new FileWriter(arquivo, true);
		 
			BufferedWriter bw = new BufferedWriter(fw);
		 
			bw.write("Texto a ser escrito no txt");
		 	bw.newLine();
		 	bw.close();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void iniciarOperacao() {
		transacao = sessao.beginTransaction();
	}
	
	private void encerrarOperacao() {
		transacao.commit();
	}
}
