package org.cruxframework.crossdeviceshowcase.client.controller.samples.messagebox;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;

@Controller("messageBoxController")
public class MessageBoxController 
{
	@Inject
	private MessageBoxMessages messages;
	
	private String MESSAGE_TYPE;
	
	@Expose
	public void onLoad()
	{
		MESSAGE_TYPE = messages.messageType();
	}
	
	@Expose
	public void showInfo()
	{
		showMessage(MessageType.INFO);
	}
	
	@Expose
	public void showSuccess()
	{
		showMessage(MessageType.SUCCESS);
	}
	
	@Expose
	public void showWarn()
	{
		showMessage(MessageType.WARN);
	}
	
	@Expose
	public void showError()
	{
		showMessage(MessageType.ERROR);
	}
	
	private void showMessage(MessageType type)
	{
		FlatMessageBox.show(MESSAGE_TYPE + type.name(), type);
	}

	public void setMessages(MessageBoxMessages messages) 
	{
		this.messages = messages;
	}
}
