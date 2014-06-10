package org.cruxframework.crossdeviceshowcase.client.controller.samples.dialogbox;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_dialogBoxTarget")
public interface DialogBoxTargetMessages extends Messages
{
	@DefaultMessage("Dialog Box")
	String title();
	
	@DefaultMessage("Um DialogBox pode conter desde um simples componente até um conjunto de views!")
	String label();
//	A DialogBox widget can handle from simple widgets to whole views!
	
	@DefaultMessage("Fechar")
	String btn();
}
