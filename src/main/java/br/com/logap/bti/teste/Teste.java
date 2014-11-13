package br.com.logap.bti.teste;

import java.io.IOException;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.logap.bti.dao.ProcessadorTransacoes;
import br.com.logap.bti.dominio.DadosColetados;

@ApplicationScoped  
public class Teste {
	
	
	@Inject
	private ProcessadorTransacoes processador;
	
	public void executarTestes() throws IOException {
				
		DadosColetados registro = criarRegistro();
		
		inserirRegistro(registro);
		
		atualizarRegistro(registro);
		
		ArrayList<String> lista = buscarTudo();
		
		criarArquivo(lista);
		
		DadosColetados registroConsultado = buscarDadosPorId(registro.getId());
		
		removerRegistro(registro);
		
	}
	
	private DadosColetados criarRegistro() {
		DadosColetados registro = new DadosColetados();
		registro.setTemperatura(70);
		registro.setUmidade(35);
		registro.setChoveu(true);
		return registro;
	}
	
	private void atualizarRegistro(DadosColetados dados) {
		processador.atualizar(dados);
	}
	
	private void inserirRegistro(DadosColetados dados) {
		processador.inserir(dados);
	}
	
	private void removerRegistro(DadosColetados dados) {
		processador.remover(dados);
	}
	
	private DadosColetados buscarDadosPorId(int id) {
		return processador.buscarPorId(id);
	}
	
	private ArrayList<String> buscarTudo() {
		return processador.buscarTudo();
	}
	
	private void criarArquivo(ArrayList<String> lista) throws IOException {
		processador.criarArquivo(lista);
	}
}
