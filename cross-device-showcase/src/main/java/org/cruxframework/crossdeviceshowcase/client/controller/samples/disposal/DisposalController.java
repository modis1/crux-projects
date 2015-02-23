package org.cruxframework.crossdeviceshowcase.client.controller.samples.disposal;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.dialog.DialogBox;
import org.cruxframework.crux.smartfaces.client.dialog.animation.DialogAnimation;
import org.cruxframework.crux.smartfaces.client.disposal.menudisposal.SideMenuDisposal;
import org.cruxframework.crux.smartfaces.client.disposal.menudisposal.TopMenuDisposal;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.smartfaces.client.menu.Type.LargeType;
import org.cruxframework.crux.smartfaces.client.menu.Type.SmallType;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;

@Controller("disposalController")
public class DisposalController {
	
	@Inject
	private DescriptionMessages messages;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(messages.sideMenuDisposal());
		
		defineListBoxItemsMobile();
	}
	
	@Expose
	public void showTopMenuDisposal()
	{
		myWidgetAccessor.topMenuDisposalPanel().setVisible(true);
		myWidgetAccessor.sideMenuDisposalPanel().setVisible(false);
		myWidgetAccessor.listTopMenuType().setVisible(true);
		myWidgetAccessor.listVerticalMenuType().setVisible(false);
		myWidgetAccessor.btnTopMenuDisposal().removeStyleName("unselected-button");
		myWidgetAccessor.btnSideMenuDisposal().addStyleName("unselected-button");
		
		defineListBoxItemsMobile();
	}
	
	@Expose
	public void showSideMenuDisposal()
	{
		myWidgetAccessor.sideMenuDisposalPanel().setVisible(true);
		myWidgetAccessor.topMenuDisposalPanel().setVisible(false);	
		myWidgetAccessor.listTopMenuType().setVisible(false);
		myWidgetAccessor.listVerticalMenuType().setVisible(true);
		myWidgetAccessor.btnSideMenuDisposal().removeStyleName("unselected-button");
		myWidgetAccessor.btnTopMenuDisposal().addStyleName("unselected-button");
		
		defineListBoxItemsMobile();
	}
	
	/*Check device type*/
	private boolean isMobile()
	{
		if(!Screen.getCurrentDevice().getInput().equals(DeviceAdaptive.Input.mouse))
		{
			return true;
		}else
		{
			return false;
		}	
	}
	
	/*Defines menu types according to the device*/
	private void defineListBoxItemsMobile()
	{
		if(isMobile())
		{
			if(myWidgetAccessor.topMenuDisposal().isVisible())
			{
				myWidgetAccessor.listTopMenuType().removeItem(1);
			}
			else
			{
				myWidgetAccessor.listVerticalMenuType().removeItem(1);
			}
		}
	}

	/*Defines top menu type choosed by user*/
	@Expose
	public void changeTopMenuType()
	{
		String menuType = myWidgetAccessor.listTopMenuType().getValue(myWidgetAccessor.listTopMenuType().getSelectedIndex());
		
		switch (menuType) 
		{
		case "horizontalDropdown":
			myWidgetAccessor.topMenuDisposal().getMenu().setMenuType(LargeType.HORIZONTAL_DROPDOWN, null);
			break;
		case "horizontalAccordion":
			myWidgetAccessor.topMenuDisposal().getMenu().setMenuType(LargeType.HORIZONTAL_ACCORDION, SmallType.HORIZONTAL_ACCORDION);
			break;
		default:
			break;
		}
	}
	
	
	/*Defines vertical menu type choosed by user*/
	@Expose
	public void changeVerticalMenuType()
	{
		String menuType = myWidgetAccessor.listVerticalMenuType().getValue(myWidgetAccessor.listVerticalMenuType().getSelectedIndex());
		
		switch (menuType) 
		{
		case "verticalAccordion":
			myWidgetAccessor.sideMenuDisposal().getMenu().setMenuType(LargeType.VERTICAL_ACCORDION, SmallType.VERTICAL_ACCORDION);
			break;
		case "verticalDropdown":
			myWidgetAccessor.sideMenuDisposal().getMenu().setMenuType(LargeType.VERTICAL_DROPDOWN, null);
			break;	
		case "verticalTree":
			myWidgetAccessor.sideMenuDisposal().getMenu().setMenuType(LargeType.VERTICAL_TREE, SmallType.VERTICAL_TREE);
			break;		
		case "verticalSlide":
			myWidgetAccessor.sideMenuDisposal().getMenu().setMenuType(LargeType.VERTICAL_SLIDE, SmallType.VERTICAL_SLIDE);
			break;		
		default:
			break;
		}
	}
	
	@Expose
	public void showMessage()
	{
		DialogBox.show(new Label("You clicked on a sub-item under construction"), DialogAnimation.fade);
	}
	
	@BindView("disposal")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		ListBox listTopMenuType();
		ListBox listVerticalMenuType();
		Button btnTopMenuDisposal();
		Button btnSideMenuDisposal();
		FlowPanel topMenuDisposalPanel();
		FlowPanel sideMenuDisposalPanel();
		TopMenuDisposal topMenuDisposal();
		SideMenuDisposal sideMenuDisposal();
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

}
