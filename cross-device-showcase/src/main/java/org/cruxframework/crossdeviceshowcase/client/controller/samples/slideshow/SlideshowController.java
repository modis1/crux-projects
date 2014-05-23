package org.cruxframework.crossdeviceshowcase.client.controller.samples.slideshow;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.widgets.client.slideshow.Slideshow;

@Controller("slideshowController")
public class SlideshowController 
{
	@Expose
	public void onLoad()
	{
		Slideshow slideshow = (Slideshow) View.of(this).getWidget("slideshow");
		slideshow.setScaleImages(false);
	}
	
}
