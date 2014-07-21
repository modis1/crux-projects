package org.cruxframework.crossdeviceshowcase.client.controller.samples.sequentialpager;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_sequentialPager")
public interface SequentialPagerMessages extends Messages
{
	@DefaultMessage("Sequential Pager")
	String title();
	
	@DefaultMessage("<p>Sequential Pager é um componente.</p>")
	String htmlDescText();
}
