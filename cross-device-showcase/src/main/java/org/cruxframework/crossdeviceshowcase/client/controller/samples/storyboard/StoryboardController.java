package org.cruxframework.crossdeviceshowcase.client.controller.samples.storyboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.deviceadaptivegrid.DeviceAdaptiveGrid;
import org.cruxframework.crux.widgets.client.image.Image;
import org.cruxframework.crux.widgets.client.storyboard.Storyboard;

import com.google.gwt.user.client.ui.Label;

@Controller("storyboardController")
public class StoryboardController
{
	@Inject
	public StoryboardView storyboardview;

	@Expose
	public void onLoad()
	{
		loadItens();
	}

	public void loadItens()
	{
		List<StoryboardItem> listItem = new ArrayList<StoryboardItem>();

		new StoryboardItem("img/celular1.jpg", "Smartphone Dual Chip Desbloqueado Preto Android Kit Kat", "Por: R$ 899,00", "Comprar",listItem);
		new StoryboardItem("img/laptop.jpg", "Notebook Ultrafino com Intel Core i3 2GB 500GB LED 14\" Preto", "Por: R$ 1.449,00", "Comprar",listItem);
		new StoryboardItem("img/celular2.jpg", "Smartphone Desbloqueado Preto Android 4.2.2", "Por: R$ 999,90", "Comprar",listItem);
		new StoryboardItem("img/tv1.jpg", "Smart TV LED 42\" HD com Conversor Digital 3 HDMI 3 USB", "Por: R$ 1.469,90", "Comprar",listItem);
		new StoryboardItem("img/lavadora.jpg", "Lavadora de Roupas - 11Kg - Branca", "Por: R$ 1.209,90", "Comprar",listItem);
		new StoryboardItem("img/tablet.jpg", "Tablet Galaxy Tab 3 T110N Lite Android 4.2 Tela", "Por: R$ 859,90", "Comprar",listItem);
		new StoryboardItem("img/tv2.jpg", "TV LED 14\" HD com Conversor Digital, HDMI, USB", "Por: R$ 599,90", "Comprar",listItem);
		new StoryboardItem("img/celular3.jpg", "Smartphone Desbloqueado Android 4.2.2", "Por: R$ 699,90", "Comprar",listItem);
		
		for(StoryboardItem w : listItem){
			storyboardview.storyboard().add(w);
		}
	}

	@BindView("storyBoard")
	public static interface StoryboardView extends WidgetAccessor
	{
		Storyboard storyboard();
	}

}
