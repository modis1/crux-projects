package org.cruxframework.crossdeviceshowcase.client.controller.samples.slider;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.image.Image;
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
		loadItems();
		sliderView.slider().showFirstWidget();
	}
	
	private void loadItems()
	{
		Image image1 = new Image();
		image1.setUrl("http://3.bp.blogspot.com/-7BkqgCIORRI/UuvYXs1ZiTI/AAAAAAAAAAc/s8AeI16hFoo/s1600/big-transculent-blue.png");
		
		Image image2 = new Image();
		image2.setTitle("Marco");
		image2.setUrl("http://i.vimeocdn.com/portrait/2026174_300x300.jpg");
		
		Image image3 = new Image();
		image3.setTitle("Jesus");
		image3.setUrl("http://2.bp.blogspot.com/-m4dNNiZ54fg/Tqgx-IqahzI/AAAAAAAAADM/hXWUerRgjgo/s1600/crux-3-released.png");
		
		Image image4 = new Image();
		image4.setUrl("http://2.bp.blogspot.com/-He-FKvx0gKg/Tqg1o_RbZtI/AAAAAAAAADU/aWPZb9DeHNg/s1600/beta.png");

		sliderView.slider().add(image1);
		sliderView.slider().add(image2);
		sliderView.slider().add(image3);
		sliderView.slider().add(image4);
		//sliderView.slider().setSlideTransitionDuration(1000);
		sliderView.slider().setCircularShowing(true);
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
