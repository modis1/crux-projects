package org.cruxframework.crux.core.client.screen.views;

import com.google.gwt.core.client.GWT;
import org.cruxframework.crux.core.client.Crux;
import org.cruxframework.crux.core.client.collection.FastMap;
import org.cruxframework.crux.core.client.screen.views.ViewFactory;
import org.cruxframework.crux.core.client.utils.StringUtils;
import com.google.gwt.user.client.ui.Widget;
import org.cruxframework.crux.core.rebind.screen.widget.WidgetCreatorContext;
import org.cruxframework.crux.core.client.screen.InterfaceConfigException;

public class ViewFactory_Impl_largeDisplayMouse implements org.cruxframework.crux.core.client.screen.views.ViewFactory {
  public void createView(String name, CreateCallback callback) throws InterfaceConfigException{ 
    createView(name, name, callback);
  }
  
  public void createView(String name, String id, CreateCallback callback) throws InterfaceConfigException{ 
    if (callback == null){
      callback = CreateCallback.EMPTY_CALLBACK;
    }
    if (StringUtils.unsafeEquals(name, "cruxtestsmartgwt/WEB-INF/classes/org/cruxframework/test/cruxtestsmartgwt/public/index.html")){
      callback.onViewCreated(new org.cruxframework.crux.core.client.screen.views.cruxtestsmartgwt_WEB_INF_classes_org_cruxframework_test_cruxtestsmartgwt_public_index_html_largeDisplayMouse(id));
      org.cruxframework.crux.core.client.screen.DisplayHandler.configureViewport("user-scalable=no, width=device-width, height=device-height");
    }
    else if (StringUtils.unsafeEquals(name, "inputs")){
      callback.onViewCreated(new org.cruxframework.crux.core.client.screen.views.inputs_largeDisplayMouse(id));
    }
    else if (StringUtils.unsafeEquals(name, "inputs")){
      callback.onViewCreated(new org.cruxframework.crux.core.client.screen.views.inputs_largeDisplayMouse(id));
    }
    else if (StringUtils.unsafeEquals(name, "cruxtestsmartgwt/index.html")){
      callback.onViewCreated(new org.cruxframework.crux.core.client.screen.views.cruxtestsmartgwt_index_html_largeDisplayMouse(id));
      org.cruxframework.crux.core.client.screen.DisplayHandler.configureViewport("user-scalable=no, width=device-width, height=device-height");
    }
    else 
    throw new InterfaceConfigException("View ["+name+"] was not found. Check if you import it using useView attribute.");
  }
  public org.cruxframework.crux.core.client.screen.DeviceAdaptive.Device getCurrentDevice(){ 
    return org.cruxframework.crux.core.client.screen.DeviceAdaptive.Device.largeDisplayMouse;
  }
}
