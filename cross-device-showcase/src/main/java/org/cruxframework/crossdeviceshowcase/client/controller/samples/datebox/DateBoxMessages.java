package org.cruxframework.crossdeviceshowcase.client.controller.samples.datebox;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_datebox")
public interface DateBoxMessages extends Messages
{
	@DefaultMessage("DateBox")
	String title();
	
	@DefaultMessage("Imprimir o Valor")
	String printValue();
	
	@DefaultMessage("Insira uma data válida.")
	String warnDate();
	
	@DefaultMessage("<p>O componente DateBox permite selecionar datas que serão atribuídas para um "
			+ "textBox. Este componente utiliza o componente DatePicker.</p>")
	String htmlDescText();
}
