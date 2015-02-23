package org.cruxframework.crossdeviceshowcase.client.controller.samples.confirm;

import org.cruxframework.crossdeviceshowcase.shared.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.event.OkEvent;
import org.cruxframework.crux.core.client.event.OkHandler;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.dialog.Confirm;
import org.cruxframework.crux.smartfaces.client.dialog.animation.DialogAnimation;
import org.cruxframework.crux.smartfaces.client.label.Label;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;

@Controller("confirmController")
public class ConfirmController 
{
	Byte status = 0;
	Confirm confirm;
	static final String MESSAGE_NAME = "Are you sure that want send your name?";
	static final String MESSAGE_NAME_EMPTY = "Are you sure that want send your name empty?";
	static final String MESSAGE_CLEAR_TEXT = "Are you sure that want clear text?";
	
	@Inject
	private DescriptionMessages messages;

	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.componentDescription().setHTML(messages.menuDescription());
	}
	
	private Confirm getInstanceConfirm()
	{
		if(confirm==null)
		{
			confirm = new Confirm();
			confirm.setDialogTitle("Confirm your action");
			confirm.center();
			confirm.setOkLabel("Yes");
			confirm.setCancelLabel("No");
			confirm.setAnimation(DialogAnimation.bounce);
		}
		return confirm;
	}

	@Expose
	public void actionTask()
	{
		if(status==0)
		{
			if(myWidgetAccessor.textBoxName().getText().equals(""))
			{
				getInstanceConfirm().setMessage(MESSAGE_NAME_EMPTY);
				getInstanceConfirm().addOkHandler(new OkHandler() 
				{
					@Override
					public void onOk(OkEvent event) 
					{
						sendName();
					}
				});
				getInstanceConfirm().show();
			}
			else
			{
				getInstanceConfirm().setMessage(MESSAGE_NAME);
				getInstanceConfirm().addOkHandler(new OkHandler() 
				{
					@Override
					public void onOk(OkEvent event) 
					{
						sendName();
					}
				});
				getInstanceConfirm().show();
			}
		}
		else
		{
			getInstanceConfirm().setMessage(MESSAGE_CLEAR_TEXT);
			getInstanceConfirm().addOkHandler(new OkHandler() 
			{
				@Override
				public void onOk(OkEvent event) 
				{
					clearLabel();
				}
			});
			getInstanceConfirm().show();
		}
	}
	
	@Expose
	public void sendName()
	{
		myWidgetAccessor.labelName().setText("Your name is: "+myWidgetAccessor.textBoxName().getText());
		myWidgetAccessor.textBoxName().setText("");
		myWidgetAccessor.textBoxName().setVisible(false);
		myWidgetAccessor.btnAction().setText("Clear text");
		status = 1;
	}
	
	@Expose
	public void clearLabel()
	{
		myWidgetAccessor.labelName().setText("");
		myWidgetAccessor.textBoxName().setVisible(true);
		myWidgetAccessor.btnAction().setText("Send Name");
		status = 0;
	}

	@BindView("confirm")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Button btnAction();
		Label labelName();
		TextBox textBoxName();
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
