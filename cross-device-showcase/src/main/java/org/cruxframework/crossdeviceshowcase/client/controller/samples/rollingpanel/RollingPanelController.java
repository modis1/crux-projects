package org.cruxframework.crossdeviceshowcase.client.controller.samples.rollingpanel;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.rollingpanel.RollingPanel;
import org.cruxframework.showcasecore.client.resource.large.ShowcaseResourcesLarge;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

@Controller("rollingPanelController")
public class RollingPanelController {
	
	@Inject
	private DescriptionMessages messages;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private ShowcaseResourcesLarge resources;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(messages.menuDescription());	
		
		/*Insert list components created to Sport Store*/
		loadSaleItems();
	}
	
	private void loadSaleItems()
	{
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Football Boots", "$89,99", resources.footballboots()));
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Pink Ball", "$12,99", resources.pinkball()));
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Basketball shoes ", "$149,99", resources.basketballshoes()));
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Back Pack", "$99,99", resources.backpack()));
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Swim Shorts", "$59,99", resources.swimshorts()));
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Baseball Bats", "$112,99", resources.baseballbats()));
		myWidgetAccessor.rollingPanelCustomizedWidget().add(new SaleItem("Boxing Gloves", "$49,99", resources.gloves()));
	}

	@BindView("rollingPanel")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		FlowPanel innerPanel();
		RollingPanel rollingPanelCustomizedWidget();
		HTML componentDescription();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) 
	{
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(DescriptionMessages messages) 
	{
		this.messages = messages;
	}

	public void setResources(ShowcaseResourcesLarge resources) {
		this.resources = resources;
	}
}
