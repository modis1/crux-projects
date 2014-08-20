package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogviewcontainer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_dialogViewContainer")
public interface DialogViewContainerMessages extends Messages
{
	@DefaultMessage("DialogViewContainer")
	String title();
	
	@DefaultMessage("Mostrar DialogViewContainer")
	String buttonShowDialog();
	
	@DefaultMessage("<p>DialogViewContainer é um container de views que utiliza uma caixa de diálogo "
			+ "flutuante para apresentá-las, possibilitando utilizar os benefícios de uma janela "
			+ "flutuante para views completas. </p> <p>No exemplo apresentado o container carrega uma view "
			+ "simulando uma tela de cadastro.</p>")
	String htmlDescText();
}
