package br.com.logap.bti.util;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class FabricaSessoes {

	
	@Produces @Singleton
	public SessionFactory getFabricaSessoes() {

		
		Configuration configuracao = new Configuration();
		configuracao.configure("hibernate.cfg.xml");
		
		ServiceRegistry registroServico = new ServiceRegistryBuilder().applySettings(configuracao.getProperties()).buildServiceRegistry();
		
		return configuracao.buildSessionFactory(registroServico);
	}
	
	
}
