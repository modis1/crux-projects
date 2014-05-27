package org.cruxframework.crossdeviceshowcase.client.controller.samples.colorpickerdialog;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.colorpicker.ColorPickerDialog;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.UIObject;

@Controller("colorPickerDialogController")
public class ColorPickerDialogController 
{
	@Inject
	public ColorPickerView colorpickerview;
	
	@Expose
	public void onLoad()
	{

	}
	
//	private void clearColorPicker()
//	{
//		colorpickerview.colorPickerDialog().hide();
//	}
	
	
	@Expose
	public void changeColor()
	{
		if (colorpickerview.colorPickerDialog().getColor() != null)
		{
			colorpickerview.labelText().getElement().getStyle().setColor("#"+colorpickerview.colorPickerDialog().getColor());
			colorpickerview.labelColor().setText("Choosed color: #"+colorpickerview.colorPickerDialog().getColor());
			
		}
	}
	
	@Expose
	public void callColorPicker()
	{
		colorpickerview.colorPickerDialog().show();
		colorpickerview.colorPickerDialog().setPopupPosition(700, 200);
	}
	
	@BindView("colorPickerDialog")
	public static interface ColorPickerView extends WidgetAccessor
	{
		ColorPickerDialog colorPickerDialog();
		Button button();
		Label labelText();
		Label labelColor();
	}    
}
