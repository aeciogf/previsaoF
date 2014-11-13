package br.com.logap.bti.teste;

import java.io.IOException;

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
		
		criaArquivo();
		
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
	
	private void criaArquivo() throws IOException {
		processador.criaArquivo();
	}
}
