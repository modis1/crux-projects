package org.cruxframework.crossdeviceshowcase.client.controller.samples.slider;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.slider.Slider;

import com.google.gwt.user.client.ui.Label;

@Controller("sliderController")
public class SliderController 
{
	@Inject
	public SliderView sliderView;
	
	@Expose
	public void onLoad()
	{
		countItems();
	}
	
	private void countItems()
	{
		sliderView.labelCount().setText("Total pages: "+Integer.toString(sliderView.slider().getPageCount()));
	}
	
	@BindView("slider")
	public static interface SliderView extends WidgetAccessor
	{
		Slider slider();
		Label labelCount();
		Label widgetNumber();
	}
}
