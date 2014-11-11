package br.com.logap.bti.teste;

import java.io.IOException;

import br.com.logap.bti.util.WeldContext;


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Teste teste = WeldContext.INSTANCE.getBean(Teste.class);
		teste.executarTestes();
	}
}