package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogviewcontainer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_viewRegister")
public interface ViewRegisterMessages extends Messages
{
	@DefaultMessage("Cadastro")
	String title();
	
	@DefaultMessage("Insira as informações solicitadas abaixo e clique em confirmar.")
	String labelText();
	
	@DefaultMessage("Confirmar")
	String buttonView();
	
	@DefaultMessage("Cadastro realizado com sucesso!")
	String labelResult();
	
	@DefaultMessage("Nome: ")
	String fieldName();
	
	@DefaultMessage("E-mail: ")
	String fieldEmail();
	
	@DefaultMessage("Endereço: ")
	String fieldAddress();
	
	@DefaultMessage("Preencha todos os campos.")
	String errorMessage();
}
