package org.cruxframework.smartgwtshowcase.client.controller.samples.tree;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartgwt.client.button.Button;
import org.cruxframework.crux.smartgwt.client.calendar.Calendar;

import com.google.gwt.user.client.Window;

@Controller("simpleCalendarController")
public class SimpleCalendarController 
{
	@Expose
	public void onLoad() {
		Calendar calendar = (Calendar) View.of(this).getWidget("simpleCalendar");
		calendar.setData(CalendarData.getRecords());  
	}
}
