package org.cruxframework.crossdeviceshowcase.client.controller.samples.swappanel;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.swappanel.SwapAnimation;
import org.cruxframework.crux.smartfaces.client.swappanel.SwapPanel;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.formdisplay.FormDisplay;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;

@Controller("swapPanelController")
public class SwapPanelController 
{
	int status = 0;
	
	@Inject
	private DescriptionMessages messages;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(messages.sideMenuDisposal());
	}
	
//	Performs swap of the widgets in the panel.
	@Expose
	public void swapPanel()
	{
		switch (status) {
		case 0:
			myWidgetAccessor.image().setVisible(true);
			myWidgetAccessor.swapPanel().transitTo(myWidgetAccessor.image(), chooseAnimation());
			status = 1;
			break;
		case 1:
			myWidgetAccessor.form().setVisible(true);
			myWidgetAccessor.swapPanel().transitTo(myWidgetAccessor.form(), chooseAnimation());
			status = 2;
			break;	
		case 2:
			myWidgetAccessor.swapPanel().transitTo(myWidgetAccessor.button(), chooseAnimation());
			status = 0;
			break;	
		default:
			break;
		}
	}
	
//	Returns animation type chosen in the listBox by the user
	private SwapAnimation chooseAnimation()
	{
		String animation = myWidgetAccessor.listAnimation().getValue(myWidgetAccessor.listAnimation().getSelectedIndex());
		SwapAnimation swapAnimation = null;
		
		switch (animation) 
		{
		case "bounce":
			swapAnimation = SwapAnimation.bounce;
			break;
		case "fade":
			swapAnimation = SwapAnimation.fade;
			break;	
		case "flipX":
			swapAnimation = SwapAnimation.flipX;
			break;	
		case "flipY":
			swapAnimation = SwapAnimation.flipY;
			break;	
		case "lightSpeed":
			swapAnimation = SwapAnimation.lightSpeed;
			break;			
		case "roll":
			swapAnimation = SwapAnimation.roll;
			break;	
		case "rotate":
			swapAnimation = SwapAnimation.rotate;
			break;		
		default:
			break;
		}
		return swapAnimation;
	}
	
//	Shows message when occurs swap widget
	@Expose
	public void showMessage()
	{
		FlatMessageBox.show("Swaped Widget", MessageType.INFO);
	}
	
	@BindView("swapPanel")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{		
		ListBox listAnimation();
		Button button();
		FlowPanel image();
		FormDisplay form();
		SwapPanel swapPanel();
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
