package org.cruxframework.crossdeviceshowcase.client.controller.samples.topmenudisposal;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;
import com.google.gwt.safehtml.shared.SafeHtml;

@MessageName("messages_topMenuDisposal")
public interface TopMenuDisposalMessages extends Messages
{
	@DefaultMessage("Top Menu Disposal")
	String title();
	
	@DefaultMessage("Inicial")//init page
	String title2();
	
	@DefaultMessage("Bem vindo!")//init page
	String labelWelcome();
	
	@DefaultMessage("Navegue pelo menu e encontre o que necessita.")
	String labelText();
	
	@DefaultMessage("<p>Menu interativo cross-device, se adpta a dispositivos de tela grande como descktops e telas pequenas como celulares. </p>"
			+"Possui definição da página inicial do menu e também possibilita que as páginas possam ser inseridas no menu de forma declativa e programática." 
			+"Neste exemplo as páginas Form Display e Masked Text Box são adicionadas programaticamente através de uma controller.")
	String labelDescText();
}
  




  
