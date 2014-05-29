package org.cruxframework.crossdeviceshowcase.client.controller.samples.colorpickerdialog;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.colorpicker.ColorPickerDialog;

import com.google.gwt.user.client.ui.Label;

@Controller("colorPickerDialogController")
public class ColorPickerDialogController 
{
	@Inject
	private ColorPickerView colorpickerview;
	
	@Expose
	public void onLoad()
	{
		//TODO finish this implementation
	}	
	
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
//	1) Ele tem um bug que, ao clicarmos sobre ele e depois clicarmos no botão de back ou forward do navegador, a janela dele continua aberta. Isto é um bug, mas para contornar este problema por enquanto, faça:
//		final ColorPickerDialog picker = screen.corPicker();
//		        History.addValueChangeHandler(new ValueChangeHandler<String>()
//		        {
//		            
//		            @Override
//		            public void onValueChange(ValueChangeEvent<String> event)
//		            {
//		                picker.hide();
//		            }
//		        });
//
//		2) Para diferenciar o clique no botão "Cancelar" de "OK" quando você abre um colorPicker, veja a propriedade "screen.corPicker().getColor()". Se ela vier vazia, então o usuário clicou no botão "Cancelar". Achei esse contrato terrível, por isso estou adicionando o Thiago na conversa para ver a opinião dele.
//
//		Att,

	@BindView("colorPickerDialog")
	public static interface ColorPickerView extends WidgetAccessor
	{
		ColorPickerDialog colorPickerDialog();
		Button button();
		Label labelText();
		Label labelColor();
	}

	public void setColorpickerview(ColorPickerView colorpickerview) 
	{
		this.colorpickerview = colorpickerview;
	}    
}
