package org.cruxframework.crossdeviceshowcase.client.controller.samples.rest;

import org.cruxframework.crossdeviceshowcase.shared.dto.MyDTO;
import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.core.client.rest.RestProxy;
import org.cruxframework.crux.core.client.rest.RestProxy.TargetRestService;

@TargetRestService("myRestService")
public interface MyRestProxy extends RestProxy
{
	void myRestCall(String param1, int param2, Callback<MyDTO> callback);
}