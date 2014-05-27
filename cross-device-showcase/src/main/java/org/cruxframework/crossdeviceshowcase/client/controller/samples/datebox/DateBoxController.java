package org.cruxframework.crossdeviceshowcase.client.controller.samples.datebox;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.datebox.DateBox;

import com.google.gwt.user.client.Window;

@Controller("dateBoxController")
public class DateBoxController 
{
	@Inject
	private DateBoxWidgets viewWidgets;
	
	public interface DateBoxWidgets extends WidgetAccessor
	{
		DateBox dateBox();
	}
	
	@Expose
	public void onClickButtonValueTextBox()
	{
		Window.alert(viewWidgets.dateBox().getValue().toString());
	}
	
	public void setViewWidgets(DateBoxWidgets viewWidgets) 
	{
		this.viewWidgets = viewWidgets;
	}
}
