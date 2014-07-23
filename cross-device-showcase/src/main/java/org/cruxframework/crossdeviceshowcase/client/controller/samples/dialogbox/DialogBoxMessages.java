package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogbox;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_dialogBox")
public interface DialogBoxMessages extends Messages
{
	@DefaultMessage("Dialog Box")
	String title();
	
	@DefaultMessage("Mostrar Dialog")
	String btnShowDialog();
	
	@DefaultMessage("<p>DialogBoxes são janelas flutuantes, que se sobrepõem à janela principal para realizar"
			+ "algum tipo de comunicação adicional com usuário. São bastante úteis para exibir porções de dados"
			+ "que ocupariam muito espaço na tela ou para tratar fluxos secundários nos casos de uso da aplicação.</p>"
			+ "<p>É possível adicionar apenas um componente ao DialogBox, porém este pode ser qualquer componente válido, "
			+ "desde um simples botão até um painel (que pode conter vários outros componentes).</p>")
	String htmlDescText();
}
