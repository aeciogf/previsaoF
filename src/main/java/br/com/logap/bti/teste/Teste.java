package br.com.logap.bti.teste;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.logap.bti.dao.Arquivo;
import br.com.logap.bti.dao.ProcessadorTransacoes;
import br.com.logap.bti.dominio.DadosColetados;

@ApplicationScoped  
public class Teste {
	
	
	@Inject
	private ProcessadorTransacoes processador;
	
	@Inject
	private Arquivo arquivo;
	
	public void executarTestes() throws IOException {
				
		DadosColetados registro = criarRegistro();
		
		String lista = buscarTudo();
				
		inserirRegistro(registro);
		
		atualizarRegistro(registro);
		
		DadosColetados registroConsultado = buscarDadosPorId(registro.getId());
		
		removerRegistro(registro);
		
		criarArquivo();
		
		transferirRegistros(lista);
		
	}
	
	private void criarArquivo() throws IOException{
		processador.criarArquivo();
	}
	
	private void transferirRegistros(String lista) throws IOException{
		processador.transferirRegistrosArquivo(lista);
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
	
	private String buscarTudo(){
		return processador.buscarTudo();
	}
	
		
}
