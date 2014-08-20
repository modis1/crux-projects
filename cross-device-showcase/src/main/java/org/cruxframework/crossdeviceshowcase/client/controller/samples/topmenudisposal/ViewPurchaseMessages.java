package org.cruxframework.crossdeviceshowcase.client.controller.samples.topmenudisposal;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_viewPurchase")
public interface ViewPurchaseMessages extends Messages
{
	@DefaultMessage("Meus pedidos")
	String title();
	
	@DefaultMessage("Informe seu e-mail e senha e clique em “ver meus pedidos” para exibir a lista de pedidos.")
	String labelInfo();
	
	@DefaultMessage("E-mail:")
	String labelEmail();
	
	@DefaultMessage("Senha:")
	String labelPassword();
	
	@DefaultMessage("Ver Meus Pedidos")
	String viewPurchase();
	
	@DefaultMessage("Lista de Pedidos")
	String purchaseList();
}
  




  
