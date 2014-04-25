package org.cruxframework.crux.core.client.controller;

import com.google.gwt.core.client.GWT;
import org.cruxframework.crux.core.client.screen.Screen;
import com.google.gwt.core.client.RunAsyncCallback;
import org.cruxframework.crux.core.client.Crux;
import org.cruxframework.crux.core.client.collection.FastMap;
import org.cruxframework.crux.core.client.utils.StringUtils;

public class RegisteredControllers_cruxtestsmartgwt_WEB_INF_classes_org_cruxframework_test_cruxtestsmartgwt_public_index_html_largeDisplayMouse implements org.cruxframework.crux.core.client.controller.RegisteredControllers {
  public RegisteredControllers_cruxtestsmartgwt_WEB_INF_classes_org_cruxframework_test_cruxtestsmartgwt_public_index_html_largeDisplayMouse(org.cruxframework.crux.core.client.screen.views.View view, org.cruxframework.crux.core.client.ioc.IocContainer_cruxtestsmartgwt_WEB_INF_classes_org_cruxframework_test_cruxtestsmartgwt_public_index_html_largeDisplayMouse iocContainer){
    this.view = view;
    this.iocContainer = iocContainer;
  }
  public <T> T getController(String controller){
    T ret = (T)controllers.get(controller);
    if (ret == null){
      if (org.cruxframework.crux.core.client.utils.StringUtils.unsafeEquals(controller, "homeController")){
        org.cruxframework.test.cruxtestsmartgwt.client.HomeController_ControllerProxy __cont  = new org.cruxframework.test.cruxtestsmartgwt.client.HomeController_ControllerProxy(this.view);
        controllers.put("homeController", __cont);
      }
      if (ret == null){
        ret = (T)controllers.get(controller);
      }
    }
    return ret;
  }
  private FastMap<Object> controllers = new FastMap<Object>();
  private org.cruxframework.crux.core.client.screen.views.View view;
  private org.cruxframework.crux.core.client.ioc.IocContainer_cruxtestsmartgwt_WEB_INF_classes_org_cruxframework_test_cruxtestsmartgwt_public_index_html_largeDisplayMouse iocContainer;
}
