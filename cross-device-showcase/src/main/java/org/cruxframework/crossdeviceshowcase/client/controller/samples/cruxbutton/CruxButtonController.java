package org.cruxframework.crossdeviceshowcase.client.controller.samples.cruxbutton;

import org.cruxframework.crossdeviceshowcase.client.util.StatesController;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.views.View;

import com.google.gwt.user.client.ui.Widget;

@Controller("cruxButtonController")
public class CruxButtonController extends StatesController
{

	private Widget widget = View.of(CruxButtonController.this).getWidget("cruxBtn");
	
	private void handleStates(String state) throws Exception
	{
		StatesController.changeWidgetState(widget, state);
	}
	
	@Expose
	public void setStateDefault() throws Exception
	{	
		handleStates("default");
	}

	@Expose
	public void setStateSuccess() throws Exception
	{
		handleStates("success");
	}

	@Expose
	public void setStateWarn() throws Exception
	{
		handleStates("warn");
	}

	@Expose
	public void setStateError() throws Exception
	{
		handleStates("error");
	}
	
}
