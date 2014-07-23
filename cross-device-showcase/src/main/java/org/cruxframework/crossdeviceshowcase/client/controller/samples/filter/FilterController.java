package org.cruxframework.crossdeviceshowcase.client.controller.samples.filter;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.filter.Filter;
import org.cruxframework.crux.widgets.client.filter.Filterable;

import com.google.gwt.user.client.ui.HTML;

@Controller("filterController")
public class FilterController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private FilterMessages messages;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
//		myWidgetAccessor.filterWidget().setLimit(2); Não ta funfando
		
		myWidgetAccessor.filterWidget().setFilterable(new Filterable<String>() {
			
			@Override
			public void onSelectItem(String selectedItem) {
				FlatMessageBox.show("Palavra sugerida", MessageType.SUCCESS);
			}
			
			@Override
			public List<FilterResult<String>> filter(String query) {
				
				List<String> wordList = new ArrayList<String>();
				wordList.add("Carro"); 
				wordList.add("Caminhão");
				wordList.add("Ônibus");
				wordList.add("Motocicleta");
				wordList.add("Metrô");
				wordList.add("Trem");
				wordList.add("Navio");
				wordList.add("Barco");
				wordList.add("Caravela");
				wordList.add("Barcas");
				wordList.add("Balsas");
				wordList.add("Avião");
				wordList.add("Balão");
				wordList.add("Dirigível");
				
				List<FilterResult<String>> result = new ArrayList<FilterResult<String>>();
				
				for(String wordItem : wordList)
				{
					if (wordItem.toLowerCase().contains(query.toLowerCase()))
					{
						result.add(new FilterResult<String>(wordItem, wordItem, wordItem));
					}
				}
				return result;
			}
		});
	}
	
	@BindView("filter")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
		Filter filterWidget();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(FilterMessages messages) {
		this.messages = messages;
	}
}
