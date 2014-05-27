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
	public ListShuttleView listshuttleView;

	@Expose
	public void onLoad()
	{
		loadItems();
	}

	private void loadItems(){

		List<String> items = new ArrayList<String>();
		items.add("Alexandre");
		items.add("Bruno");
		items.add("Cláudio ");
		items.add("Samuel");
		items.add("Thiago ");
		items.add("Wesley");
		items.add("Ricardo");
		items.add("Felipe");
		
		List<String> itemsSel = new ArrayList<String>();
		itemsSel.add("Guilherme");
		itemsSel.add("Juliano");
		
		listshuttleView.listShuttle().setAvailableItems(items);
		listshuttleView.listShuttle().setSelectedItems(itemsSel);
	}
	

	@BindView("listShuttle")
	public static interface ListShuttleView extends WidgetAccessor
	{
		ListShuttle<String> listShuttle();
	}    
}
