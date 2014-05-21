package org.cruxframework.crossdeviceshowcase.client.controller.samples.colorpickerdialog;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.colorpicker.ColorPickerDialog;
import org.cruxframework.crux.widgets.client.styledpanel.StyledPanel;
import org.cruxframework.crux.widgets.client.textarea.TextArea;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;

@Controller("colorPickerDialogController")
public class ColorPickerDialogController 
{
	@Inject
	public ViewColorPicker viewcolorpicker;
	
	@Expose
	public void readColor()
	{
		//viewcolorpicker.pannelColor().
		
		//viewcolorpicker.colorPickerDialog().setColor("yellow");
		//String teste = viewcolorpicker.colorPickerDialog().getColor();
		//viewcolorpicker.colorPickerDialog().
	   // Window.alert(teste);
	    //viewcolorpicker.pannelColor().setText(teste);
	}
	
	@BindView("colorPickerDialog")
	public static interface ViewColorPicker extends WidgetAccessor
	{
		ColorPickerDialog colorPickerDialog();
		TextArea pannelColor();
	}    
}
