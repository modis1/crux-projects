package org.cruxframework.crossdeviceshowcase.client.controller.samples.menu;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.menu.Menu;
import org.cruxframework.crux.smartfaces.client.menu.MenuWidget.Orientation;
import org.cruxframework.crux.smartfaces.client.menu.MenuWidget.Type;

import com.google.gwt.user.client.ui.FlowPanel;

@Controller("menuController")
public class MenuController 
{
	@Inject
	private MenuView view;
	
	@Expose
	public void onLoad()
	{
		Menu menu = new Menu(Orientation.HORIZONTAL, Type.TREE);
		
		Button w1 = new Button();
		w1.setText("AAAAA");
		Button w2 = new Button();
		w2.setText("BBBBB");
		
		menu.add(w1);
		menu.add(w2);
		
		view.rootPanel().add(menu);
	}
	
	@BindView("menu")
	public static interface MenuView extends WidgetAccessor
	{
		FlowPanel rootPanel();
	}

	public void setView(MenuView view) 
	{
		this.view = view;
	}
}
