package org.cruxframework.crossdeviceshowcase.client.controller.samples.swapviewcontainer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_swapViewContainer")
public interface SwapViewContainerMessages extends Messages
{
	@DefaultMessage("SwapViewContainer")
	String title();
	
	@DefaultMessage("Mostrar próxima view")
	String buttonShowNextView();
	
	@DefaultMessage("<p>O SwapViewContainer é um container de views no qual é possível carregar mais "
			+ "de uma view no mesmo container, sendo possível realizar a troca da view a ser visualizada."
			+ "As views podem ser adicionadas ao container de forma declarativa ou programática, e também "
			+ "pode-se definir qual será a view ativa </p>")
	String htmlDescText();
}


