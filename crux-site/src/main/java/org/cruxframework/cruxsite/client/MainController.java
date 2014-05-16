package org.cruxframework.cruxsite.client;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.plugin.google.analytics.client.GoogleAnalytics;
import org.cruxframework.crux.widgets.client.rss.feed.Loader;
import org.cruxframework.cruxsite.client.accessor.ManualAccessor;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.logging.client.LogConfiguration;
import com.google.gwt.user.client.Window;

@Controller("mainController")
public class MainController 
{
	private static Logger logger = Logger.getLogger(MainController.class.getName());
	
	@Inject
	private ManualAccessor manual;
	
	public static boolean isFeedAPILoaded = false;
	
	@Expose
	public void onLoad()
	{
		// Código do "Mapa Termico de Cliques" 
		String scriptURL = Window.Location.getProtocol()+"//dnn506yrbagrg.cloudfront.net/pages/scripts/0018/5757.js?"+Math.floor(new Date().getTime()/3600000);
		ScriptInjector.fromUrl(scriptURL).setRemoveTag(false).setWindow(ScriptInjector.TOP_WINDOW).inject();
		
		// Inicia Analytics
		GoogleAnalytics.init("UA-7689544-6"); 
		
		//Inicia Post do Blog
		loadFeedAPI();
	}
	
	private static void loadFeedAPI() 
	{
		Loader.init("ABQIAAAArGIZjhmsan61DtT58_d6cRQNU4gAv_Jc96TUa1T-tg6v_fuASxRtwAMNaJHgnp12SaDI9Cs17oKAzw", new Loader.LoaderCallback()
		{
			public void onError(Throwable t)
			{
				if (LogConfiguration.loggingIsEnabled())
				{
					Window.alert("Erro carregando a API de feed.");
					logger.log(Level.SEVERE, "Error loading Google Feed API...");
				}
			}

			public void onLoad()
			{
				isFeedAPILoaded = true;
			}
		});
	}
	
	public void setManual(ManualAccessor manual) 
	{
		this.manual = manual;
	}
	
}
