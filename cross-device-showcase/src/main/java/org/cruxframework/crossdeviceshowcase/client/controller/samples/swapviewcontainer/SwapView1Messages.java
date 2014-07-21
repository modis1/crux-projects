package org.cruxframework.crossdeviceshowcase.client.controller.samples.swapviewcontainer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_swapView1")
public interface SwapView1Messages extends Messages
{
	@DefaultMessage("Cara")
	String title();
	
	@DefaultMessage("Esta é uma view simples carregada por um Swap View Container.")
	String labelTextView();
}




