package org.cruxframework.test.cruxtestwidgets.client;

import java.util.Date;
import java.util.logging.Logger;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.widgets.client.datebox.DateBox;
import org.cruxframework.crux.widgets.client.datepicker.DatePicker;
import org.cruxframework.crux.widgets.client.datepicker.gwtoverride.CalendarUtil;
import org.cruxframework.test.cruxtestwidgets.client.resource.Resources;

import com.google.gwt.event.logical.shared.ShowRangeEvent;
import com.google.gwt.event.logical.shared.ShowRangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

@Controller("inputsController")
public class InputsController 
{
	private static final Logger LOG = Logger.getLogger(InputsController.class.getName());
	//LOG.log(Level.INFO, 

	@Expose
	public void onLoad()
	{
		createDatebox();
		createDatePicker();
	}

	private void createDatebox() 
	{
		appendToView(getNewDatebox());
		appendToView(getNewDatebox());
		appendToView(getNewDatebox());
		appendToView(getNewDatebox());		
	}

	private void createDatePicker() 
	{
		appendToView(new DatePicker());
		appendToView(new DatePicker());
		appendToView(new DatePicker());
		appendToView(new DatePicker());
	}
	
	private DateBox getNewDatebox() 
	{
		final DateBox dateBox = new DateBox();
		final Resources resource = (Resources) View.getResource("testWidgetsResources");
		
		dateBox.getDatePicker().addShowRangeHandler(new ShowRangeHandler<Date>() 
		{
			@Override
			public void onShowRange(ShowRangeEvent<Date> event) 
			{
				System.out.println("Date interval changed! Start date: " + event.getStart() + " End date: " + event.getEnd());	
			}
		});
		
		dateBox.getDatePicker().addValueChangeHandler(new ValueChangeHandler<Date>() 
		{
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) 
			{
				String visible = dateBox.getDatePicker().isDateVisible(event.getValue()) ? "visible" : "not visible";
				String styleOfDate = dateBox.getDatePicker().getStyleOfDate(event.getValue());
				System.out.println("Date "+ visible +" selected: " + event.getValue() + " Style: " + styleOfDate);
				if(styleOfDate == null 
						|| 
						!styleOfDate.contains(resource.css().datePickerEnabled())
						||
						styleOfDate.contains(resource.css().datePickerHoliday()))
				{
					Window.alert("This date is not available!");
					dateBox.getDatePicker().setValue(null);
				}
			}
		});
		
		Date initEnabledDate = new Date();
		CalendarUtil.addMonthsToDate(initEnabledDate, -1);
		Date finalEnabledDate = new Date();
		CalendarUtil.addMonthsToDate(finalEnabledDate, +3);
		
		dateBox.getDatePicker().addStyleToDates(resource.css().datePickerEnabled(), initEnabledDate, finalEnabledDate);
		
		Date initHolidayDate = new Date();
		CalendarUtil.addDaysToDate(initHolidayDate, -5);
		Date finalHolidayDate = new Date();
		CalendarUtil.addDaysToDate(finalHolidayDate, +5);
		
		dateBox.getDatePicker().addStyleToDates(resource.css().datePickerHoliday(), initHolidayDate, finalHolidayDate);
		
		return dateBox;
	}

	private void appendToView(final Widget widget) 
	{
		FlowPanel wrapper = (FlowPanel) View.of(this).getWidget("wrapper");
		wrapper.add(widget);
	}
}
