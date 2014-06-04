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
	
	@DefaultMessage("O componente DateBox permite selecionar datas que serão atribuídas para um"
			+ "textBox. Este componente utiliza o componente DatePicker.")
	String descText();
}
