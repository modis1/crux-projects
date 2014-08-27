package org.cruxframework.crossdeviceshowcase.client.controller.samples.timer;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.event.timeout.TimeoutEvent;
import org.cruxframework.crux.widgets.client.event.timeout.TimeoutHandler;
import org.cruxframework.crux.widgets.client.timer.Timer;

import com.google.gwt.user.client.ui.HTML;

@Controller("timerController")
public class TimerController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private TimerMessages messages;
	
	private boolean statusStart = false;
	private boolean statusStop = false;
	
	@Expose
	public void onLoad()
	{
		//Insert the component description
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
	}

	@Expose
	public void start()
	{
		warnTime();
		myWidgetAccessor.timer().reset();
		statusStart = true;
		statusStop = false;
		changeStatusButton();
	}
	
	@Expose
	public void warnTime()
	{
		myWidgetAccessor.timer().addTimeoutHandler(new TimeoutHandler() {
			
			@Override
			public void onTimeout(TimeoutEvent event) {
				FlatMessageBox.show(messages.warnTime(), MessageType.ERROR);
			}
			
			@Override
			public long getScheduledTime() {
				return 5;
			}
		});
	}
	
	@Expose
	public void stopAndRestart()
	{
		if(statusStart == true && statusStop == false)
		{
			myWidgetAccessor.timer().stop();
			statusStart = false;
			statusStop = true;
			changeStatusButton();
		}else if(statusStart == false && statusStop == true)
		{
			myWidgetAccessor.timer().start();
			statusStart = true;
			statusStop = false;
			changeStatusButton();
		}
	}
	
	@Expose
	public void clear()
	{
		myWidgetAccessor.timer().clear();
		statusStop = false;
		statusStart = false;
		changeStatusButton();
	}
	
	private void changeStatusButton()
	{
		if(statusStart == true && statusStop == false)
		{
			myWidgetAccessor.buttonStop().setText(messages.buttonStop());
		}else if(statusStart == false && statusStop == true)
		{
			myWidgetAccessor.buttonStop().setText(messages.buttonRestart());
		}else
		{
			myWidgetAccessor.buttonStop().setText(messages.buttonStop());
		}
	}
	
	@BindView("timer")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		Timer timer();
		Button buttonStop();
		HTML htmlDescText();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(TimerMessages messages) {
		this.messages = messages;
	}
}
