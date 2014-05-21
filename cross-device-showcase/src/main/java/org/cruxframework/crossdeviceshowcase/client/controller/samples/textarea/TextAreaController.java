package org.cruxframework.crossdeviceshowcase.client.controller.samples.textarea;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.textarea.TextArea;

import com.google.gwt.user.client.ui.TextBox;

@Controller("textAreaController")
public class TextAreaController 
{

	@Inject
	public TextAreaView textareaview;

	@Expose
	public void onLoad()
	{
		applyMaxLength();
	}

	@Expose
	public void applyMaxLength()
	{
		try
		{
			textareaview.textArea().setMaxLength(valueMaxLenght());
		}
		catch (NumberFormatException e)
		{
			FlatMessageBox.show("Por favor, insira um número inteiro válido.", MessageType.ERROR);
		}
		catch (IllegalArgumentException e1)
		{
			FlatMessageBox.show("Por favor, insira um valor positivo.", MessageType.ERROR);
		}

	}

	private int valueMaxLenght()
	{
		return Integer.parseInt(textareaview.textBox().getText());
	}

	@BindView("textArea")
	public static interface TextAreaView extends WidgetAccessor
	{
		TextArea textArea();
		TextBox textBox();
	}    
}
