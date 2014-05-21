package org.cruxframework.crossdeviceshowcase.client.controller.samples.transferlist;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.Confirm;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.event.moveitem.BeforeMoveItemsEvent;
import org.cruxframework.crux.widgets.client.transferlist.TransferList;
import org.cruxframework.crux.widgets.client.transferlist.TransferList.Item;
import org.cruxframework.crux.widgets.client.transferlist.TransferList.ItemLocation;

import com.google.gwt.user.client.Window;

@Controller("transferListController")
public class TransferListController 
{

	@Inject
	public TransferListView transferlistview;

	@Expose
	public void onLoad()
	{
		loadItems();
	}

	@SuppressWarnings("deprecation")
	private void loadItems(){

		List<Item> items = new ArrayList<Item>();
		items.add(new TransferList.Item("Alexandre ", "Alexandre", ItemLocation.left));
		items.add(new TransferList.Item("Bruno ", "Bruno", ItemLocation.left));
		items.add(new TransferList.Item("Cláudio ", "Cláudio", ItemLocation.left));
		items.add(new TransferList.Item("Guilherme ", "Guilherme", ItemLocation.right));
		items.add(new TransferList.Item("Juliano ", "Juliano", ItemLocation.right));
		items.add(new TransferList.Item("Samuel ", "Samuel", ItemLocation.left));
		items.add(new TransferList.Item("Thiago ", "Thiago", ItemLocation.left));
		items.add(new TransferList.Item("Wesley ", "Wesley", ItemLocation.left));
		transferlistview.transferList().setCollection(items);
	}

	@Expose
	public void onBeforeMoveItems(BeforeMoveItemsEvent event)
	{
		List<Item> items = event.getItems();

		if(items.size() > 0)
		{
			boolean plural = items.size() > 1;
			String pronoun = plural ? "estes" : "este";
			String noun = plural ? "jogadores" : "jogador";
			String destination = event.isMovingToLeft() ? "remover" : "selecionar";
			String message = null; 
			if (plural == true)
			{
				message = "Tem certeza que deseja " + destination +" "+ pronoun + " " + items.size() +" " + noun + "?";
			}
			else
			{
				message = "Tem certeza que deseja "+ destination +" "+ pronoun  + " " + noun + "?";
			}
				
				if(!Window.confirm(message))//trocar pelo confirm do faces
			{
				event.cancel();
			}
		}
		else
		{
			FlatMessageBox.show("Você deve selecionar um jogador primeiro.", MessageType.ERROR);
		}
	}

	@BindView("transferList")
	public static interface TransferListView extends WidgetAccessor
	{
		TransferList transferList();
	}    
}
