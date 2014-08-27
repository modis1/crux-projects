package org.cruxframework.crossdeviceshowcase.client.controller.samples.topmenudisposal;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_views")
public interface ViewsMessages extends Messages
{
	// Messagens View Home
	@DefaultMessage("Home")
	String homeTitle();
	
	@DefaultMessage("Bem vindo ao ByMore!")
	String homeLabelText();
	
	@DefaultMessage("Aqui você encontra tudo que precisa.")
	String homeLabelTextComp();
	
	// Messagens View Purchase
	@DefaultMessage("Meus pedidos")
	String purchaseTitle();
	
	@DefaultMessage("Veja os dados dos seus pedidos.")
	String purchaseLabelInfo();
	
	@DefaultMessage("Lista de Pedidos")
	String purchaseList();
	
	// Messagens View Store	
	@DefaultMessage("Buscar Lojas")
	String storeTitle();
	
	@DefaultMessage("Encontre uma loja mais perto de você.")
	String storeLabelInfo();
		
	@DefaultMessage("Lojas Encontradas.")
	String storesFound();
	
}
  




  
