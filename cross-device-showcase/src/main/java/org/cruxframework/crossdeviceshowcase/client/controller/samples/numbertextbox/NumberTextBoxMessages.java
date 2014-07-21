package org.cruxframework.crossdeviceshowcase.client.controller.samples.numbertextbox;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_numberTextBox")
public interface NumberTextBoxMessages extends Messages
{
	@DefaultMessage("Number Text Box")
	String title();

	@DefaultMessage("Insira um número abaixo")
	String labelText();
	
	@DefaultMessage("Escolha o limite para inserção dos números")
	String labelMaxlength();
	
	@DefaultMessage("Livre")
	String radioButtonFree();
	
	@DefaultMessage("<p>Number Text Box é uma caixa de texto que permite apenas a inserção de números inteiros positivos.</p>"
			+ "<p>Este componente permite a definição de um valor máximo de caracteres que podem ser inseridos e também pode "
			+ "disparar um evento a partir da mudança dos valores da caixa de texto.")
	String htmlDescText();
}