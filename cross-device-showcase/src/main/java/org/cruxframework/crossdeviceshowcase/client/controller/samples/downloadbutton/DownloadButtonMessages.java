package org.cruxframework.crossdeviceshowcase.client.controller.samples.downloadbutton;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_downloadButton")
public interface DownloadButtonMessages extends Messages
{
	@DefaultMessage("Download Button")
	String title();
	
	@DefaultMessage("<p>O Download Button</p>")
	String htmlDescText();
}
