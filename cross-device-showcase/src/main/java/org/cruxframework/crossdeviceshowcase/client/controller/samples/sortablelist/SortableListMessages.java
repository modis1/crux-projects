package org.cruxframework.crossdeviceshowcase.client.controller.samples.sortablelist;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_sortableList")
public interface SortableListMessages extends Messages
{
	@DefaultMessage("Sortable List")
	String title();
	
	@DefaultMessage("<p>O Sortable List é um componente.</p>")
	String htmlDescText();
}


