package org.cruxframework.crossdeviceshowcase.client.controller.samples.cruxbutton;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.views.View;

import com.google.gwt.user.client.ui.Widget;

@Controller("cruxButtonController")
public class CruxButtonController
{
	private void handleStates(String state)
	{
		Widget widget = View.of(CruxButtonController.this).getWidget("cruxBtn");
		widget.setStyleName(state);
	}
	
	@Expose
	public void handleDefault()
	{	
		handleStates("default");
	}

	@Expose
	public void handleSuccess()
	{
		handleStates("success");
	}

	@Expose
	public void handleWarning()
	{
		handleStates("warn");
	}

	@Expose
	public void handleError()
	{
		handleStates("error");
	}
	
}
