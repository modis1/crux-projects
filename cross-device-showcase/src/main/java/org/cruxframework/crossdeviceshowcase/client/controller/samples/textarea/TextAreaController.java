package org.cruxframework.crossdeviceshowcase.client.controller.samples.textarea;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.textarea.TextArea;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

@Controller("textAreaController")
public class TextAreaController 
{
	@Inject
	private DescriptionMessages componentDescription;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	private String MESSAGE_INVALID_NUMBER;
	private String MESSAGE_NEGATIVE_NUMBER;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(componentDescription.textAreaDescription());
		
		MESSAGE_INVALID_NUMBER = "Please enter a valid integer value such as 50, 73, 95 etc.";
		MESSAGE_NEGATIVE_NUMBER = "Please enter a positive value.";

		applyMaxLength();	
	}

	@Expose
	public void applyMaxLength()
	{
		try
		{
			myWidgetAccessor.textArea().setMaxLength(valueMaxLenght());
		}
		catch (NumberFormatException e)
		{
			FlatMessageBox.show(MESSAGE_INVALID_NUMBER, MessageType.ERROR);
		}
		catch (IllegalArgumentException e1)
		{
			FlatMessageBox.show(MESSAGE_NEGATIVE_NUMBER, MessageType.ERROR);
		}
	}

	private int valueMaxLenght()
	{
		return Integer.parseInt(myWidgetAccessor.textBox().getText());
	}

	@BindView("textArea")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		TextArea textArea();
		TextBox textBox();
		HTML componentDescription();
	}

	private void setState(String state)
	{	
		Widget textarea = myWidgetAccessor.textArea();

		textarea.removeStyleName("success");
		textarea.removeStyleName("warn");
		textarea.removeStyleName("error");
		textarea.setStyleName("gwt-TextArea " + state);
	}

	@Expose
	public void handleDefault()
	{
		this.setState("");
	}

	@Expose
	public void handleSuccess()
	{
		this.setState("success");
	}

	@Expose
	public void handleWarning()
	{
		this.setState("warn");
	}

	@Expose
	public void handleError()
	{
		this.setState("error");
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
	
	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}
}
