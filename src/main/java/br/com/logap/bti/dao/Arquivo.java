package br.com.logap.bti.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.sql.*;

public class Arquivo {

	File arquivo = new File("C:\\previsao\\arquivo.txt");
	
	public void criar() throws IOException{
		try{
			if (!arquivo.exists())
				arquivo.createNewFile();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public void transferirRegistros(String lista) throws IOException {
	
		try {
		FileWriter fw = new FileWriter(arquivo);  
		BufferedWriter bw = new BufferedWriter(fw);  
		  
		bw.write(lista);  
		bw.flush();  
		bw.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

}		
