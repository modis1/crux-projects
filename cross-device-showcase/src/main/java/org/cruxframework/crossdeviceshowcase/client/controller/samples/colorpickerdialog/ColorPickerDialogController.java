package org.cruxframework.crossdeviceshowcase.client.controller.samples.colorpickerdialog;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.colorpicker.ColorPickerDialog;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Label;

@Controller("colorPickerDialogController")
public class ColorPickerDialogController 
{
	@Inject
	private ColorPickerView colorpickerview;

	@Inject
	private ColorPickerDialogMessages messages;

	@Expose
	public void showColorPicker()
	{
		colorpickerview.colorPicker().show();
		colorpickerview.colorPicker().setPopupPosition(700, 200);
		close();
	}	

	private void close()
	{
		History.addValueChangeHandler(new ValueChangeHandler<String>()
				{  
			public void onValueChange(ValueChangeEvent<String> event)
			{
				colorpickerview.colorPicker().hide();
			}
				});
	}

	@Expose
	public void changeColor()
	{
		if (colorpickerview.colorPicker().getColor() != null || colorpickerview.colorPicker().getColor().trim().equals(""))
		{
			colorpickerview.labelClickButton().getElement().getStyle().setColor("#"+colorpickerview.colorPicker().getColor());
			colorpickerview.labelColorValue().setText(messages.labelColorValue()+" #"+colorpickerview.colorPicker().getColor());
		}
	}

	@BindView("colorPickerDialog")
	public static interface ColorPickerView extends WidgetAccessor
	{
		ColorPickerDialog colorPicker();
		Label labelClickButton();
		Label labelColorValue();
	}

	public void setColorpickerview(ColorPickerView colorpickerview) 
	{
		this.colorpickerview = colorpickerview;
	}

	public void setMessages(ColorPickerDialogMessages messages) {
		this.messages = messages;
	}    
}
