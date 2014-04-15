package org.cruxframework.test.cruxtestsmartgwt.client;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.data.CalendarData;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.smartgwt.client.widgets.calendar.Calendar;

@Controller("inputsController")
public class InputsController {
	@Expose
	public void onLoad() {
		createBasicCalendar();
	}

	private void createBasicCalendar() {
			Calendar calendar = new Calendar();
		calendar.setData(CalendarData.getRecords());
		FlowPanel fp = (FlowPanel) View.of(this).getWidget("wrapper");
		fp.getElement().setId("teste_calendar");
		fp.add(calendar);
	}
	
	@Expose
	public void teste(){
		Window.alert("Olá Flávia");
	}
}