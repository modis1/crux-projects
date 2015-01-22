package org.cruxframework.gwtcreate.client.resource;

import org.cruxframework.crux.core.client.resources.Resource;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive.Device;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;


@Resource(value = "sampleResources", supportedDevices = {Device.all})
public interface SampleResources extends ClientBundle
{

	@Source({"mainStyles.css"})
	CssResource css();
	
}
