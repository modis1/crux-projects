package org.cruxframework.crossdeviceshowcase.client.controller.samples.listshuttle;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.listshuttle.ListShuttle;

@Controller("listShuttleController")
public class ListShuttleController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Expose
	public void onLoad()
	{
		loadItems();
	}

	private void loadItems(){

		List<String> itemsA = new ArrayList<String>();
		itemsA.add("Alexandre");
		itemsA.add("Bruno");
		itemsA.add("Cláudio ");
		itemsA.add("Samuel");
		itemsA.add("Thiago ");
		itemsA.add("Wesley");
		itemsA.add("Ricardo");
		itemsA.add("Felipe");
		itemsA.add("Guilherme");
		itemsA.add("Juliano");

		List<String> itemsS = new ArrayList<String>();
		itemsS.add("Guilherme");
		itemsS.add("Juliano");

		myWidgetAccessor.listShuttle().setAvailableItems(itemsA);
		myWidgetAccessor.listShuttle().setSelectedItems(itemsS);
	}

	@BindView("listShuttle")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		ListShuttle<String> listShuttle();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}
}
