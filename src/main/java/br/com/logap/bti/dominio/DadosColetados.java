package br.com.logap.bti.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "dados_coletados", schema = "public")
public class DadosColetados extends PadraoDominio {

	@Id
	@SequenceGenerator(name = "sequencia", sequenceName = "dados_coletados_id_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequencia")
	@Column(name = "id")
	private int id;
	
	@Column(name = "temperatura")
	private float temperatura;
	
	@Column(name = "umidade")
	private float umidade;
	
	@Column(name = "choveu")
	private boolean choveu;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTemperatura(){
		return temperatura;
	}
	
	public void setTemperatura(float temperatura){
		this.temperatura = temperatura;
	}
	
	public float getUmidade(){
		return umidade;
	}

	public void setUmidade(float umidade){
		this.umidade = umidade;
	}

	public boolean getChoveu(){
		return choveu;
	}

	public void setChoveu(boolean choveu){
		this.choveu = choveu;
	}

}
