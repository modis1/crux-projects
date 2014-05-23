package org.cruxframework.crossdeviceshowcase.client.controller.samples.rest;

import org.cruxframework.crossdeviceshowcase.client.remote.MyRestProxy;
import org.cruxframework.crossdeviceshowcase.shared.dto.MyDTO;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.rest.Callback;

import com.google.gwt.user.client.Window;

@Controller("restController")
public class RestController 
{
	@Inject
	private MyRestProxy myRestProxy; 
	
	@Expose
	public void onLoad()
	{
		myRestProxy.myRestCall("A", 1, new Callback<MyDTO>() 
		{
			@Override
			public void onSuccess(MyDTO result) 
			{
				Window.alert("A: " + result.getA() + " B: " + result.getB());
			}
			
			@Override
			public void onError(Exception e) 
			{
				Window.alert(e.getMessage());
			}
		});
	}

	public MyRestProxy getMyRestProxy() 
	{
		return myRestProxy;
	}

	public void setMyRestProxy(MyRestProxy myRestProxy) 
	{
		this.myRestProxy = myRestProxy;
	}
	
}
