package org.cruxframework.crossdeviceshowcase.client.controller.samples.slideshow;

import java.util.logging.Logger;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.widgets.client.slideshow.Slideshow;

@Controller("slideshowController")
public class SlideshowController 
{
	private static Logger logger = Logger.getLogger(SlideshowController.class.getName());
	
	@Expose
	public void onLoad()
	{
		logger.info("loading slideshow view");
		Slideshow slideshow = (Slideshow) View.of(this).getWidget("slideshow");
		slideshow.setScaleImages(false);
	}
	
}
