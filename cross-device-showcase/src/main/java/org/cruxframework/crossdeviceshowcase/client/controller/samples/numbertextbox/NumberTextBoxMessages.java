package org.cruxframework.crossdeviceshowcase.client.controller.samples.numbertextbox;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_numberTextBox")
public interface NumberTextBoxMessages extends Messages
{
	@DefaultMessage("NumberTextBox")
	String title();

	@DefaultMessage("Insira um número abaixo")
	String labelText();
	
	@DefaultMessage("Escolha o limite para inserção dos números")
	String labelMaxlength();
	
	@DefaultMessage("0 a 9")
	String radioButton09();
	
	@DefaultMessage("0 a 99")
	String radioButton099();

	@DefaultMessage("0 a 999")
	String radioButton0999();

	@DefaultMessage("Livre")
	String radioButtonFree();
	
	@DefaultMessage("<p>NumberTextBox é uma caixa de texto que permite apenas a inserção de números inteiros positivos.</p>"
			+ "<p>Este componente permite a definição de um valor máximo de caracteres que podem ser inseridos e também pode "
			+ "disparar um evento a partir da mudança dos valores da caixa de texto.")
	String htmlDescText();
}