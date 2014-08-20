package org.cruxframework.crossdeviceshowcase.client.controller.samples.stackmenu;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_stackMenu")
public interface StackMenuMessages extends Messages
{
	@DefaultMessage("StackMenu")
	String title();
	
	@DefaultMessage("Você selecionou o ítem ")
	String info();
	
	@DefaultMessage("dentro de ")
	String complementInfo();
	
	@DefaultMessage("Ação")
	String labelAction();
	
	@DefaultMessage("Comédia")
	String labelComedy();
	
	@DefaultMessage("Meu Malvado Favorito")
	String labelDespicableMe();
	
	@DefaultMessage("Orgulho e Preconceito")
	String labelPrideAndPrejudice();
	
	@DefaultMessage("A Orfã")
	String labelOrphan();
	
	@DefaultMessage("<p>O StackMenu é um menu hierárquico e vertical. Cada ítem em um StackMenu pode "
			+"ter um ou vários sub-ítens, inseridos de forma declarativa ou programática. "
			+"Também é possível disparar eventos de seleção neste componente, no exemplo apresentado "
			+ "são exibidas informações do ítem selecionado.</p>")
	String htmlDescText();
}
