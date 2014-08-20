package org.cruxframework.crossdeviceshowcase.client.controller.samples.sortablelist;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_sortableList")
public interface SortableListMessages extends Messages
{
	@DefaultMessage("SortableList")
	String title();
	
	@DefaultMessage("<p>O SortableList é um componente.</p>")
	String htmlDescText();
}


