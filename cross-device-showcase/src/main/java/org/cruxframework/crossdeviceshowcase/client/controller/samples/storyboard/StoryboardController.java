package org.cruxframework.crossdeviceshowcase.client.controller.samples.storyboard;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.storyboard.Storyboard;

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

		new StoryboardItem("Product 1", "$ 899.00", "Add to cart",listItem);
		new StoryboardItem("Product 2", "$ 399.00", "Add to cart",listItem);
		new StoryboardItem("Product 3", "$ 1,899.00", "Add to cart",listItem);
		new StoryboardItem("Product 4", "$ 159.00", "Add to cart",listItem);
		new StoryboardItem("Product 5", "$ 839.00", "Add to cart",listItem);
		new StoryboardItem("Product 6", "$ 729.00", "Add to cart",listItem);
		new StoryboardItem("Product 7", "$ 2.199.00", "Add to cart",listItem);
		new StoryboardItem("Product 8", "$ 599.00", "Add to cart",listItem);
				
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
