package org.cruxframework.crux.core.client.screen.views;

import com.google.gwt.core.client.GWT;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.utils.StringUtils;
import com.google.gwt.user.client.Window;
import org.cruxframework.crux.core.client.screen.views.ViewFactoryUtils;
import org.cruxframework.crux.core.client.screen.views.ViewFactory.CreateCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import org.cruxframework.crux.core.client.screen.views.ViewLoadEvent;
import com.google.gwt.user.client.ui.Panel;
import org.cruxframework.crux.core.client.screen.InterfaceConfigException;
import com.google.gwt.user.client.ui.Widget;
import org.cruxframework.crux.core.client.Crux;

public class inputs_largeDisplayMouse extends org.cruxframework.crux.core.client.screen.views.View {
  protected inputs_largeDisplayMouse(String id){
    super(id);
    setTitle("Inputs");
    this.iocContainer = new org.cruxframework.crux.core.client.ioc.IocContainer_inputs_largeDisplayMouse(this);
    this.registeredControllers = new org.cruxframework.crux.core.client.controller.RegisteredControllers_inputs_largeDisplayMouse(this, iocContainer);
    this.registeredDataSources = new org.cruxframework.crux.core.client.datasource.RegisteredDataSources_inputs_largeDisplayMouse(this, iocContainer);
  }
  public org.cruxframework.crux.core.client.controller.RegisteredControllers getRegisteredControllers(){
    return this.registeredControllers;
  }
  public org.cruxframework.crux.core.client.datasource.DataSource<?> createDataSource(String dataSource){
    return this.registeredDataSources.getDataSource(dataSource);
  }
  protected void createWidgets(){
    __view.addViewLoadHandler(new org.cruxframework.crux.core.client.screen.views.ViewLoadHandler(){
      public void onLoad(org.cruxframework.crux.core.client.screen.views.ViewLoadEvent event){
        ((org.cruxframework.test.cruxtestsmartgwt.client.InputsController_ControllerProxy)__view.getController("inputsController")).onLoad_Exposed_();
      }
    });
    final org.cruxframework.crux.smartgwt.client.button.Button widget406 = GWT.create(org.cruxframework.crux.smartgwt.client.button.Button.class);
    __view.addWidget("btnSmart", widget406);
    widget406.setTitle("Botão");
    widget406.setWidth("100px");
    widget406.setHeight("50px");
    if (com.google.gwt.logging.client.LogConfiguration.loggingIsEnabled()){
      logger0.info(Crux.getMessages().viewContainerViewCreated(getId()));
    }
  }
  protected void render(com.google.gwt.user.client.ui.Panel rootPanel6, final org.cruxframework.crux.core.client.screen.views.View.RenderCallback renderCallback) throws InterfaceConfigException{
    if (this.viewPanel0 == null){
      this.viewPanel0 = new com.google.gwt.user.client.ui.HTMLPanel(" <div id=\"_crux_"+__view.getPrefix()+"btnSmart\"></div> ");
      rootPanel6.add(this.viewPanel0);
      this.viewPanel0.addAndReplaceElement(widgets.get("btnSmart"), ViewFactoryUtils.getEnclosingPanelId("btnSmart", __view));
      renderCallback.onRendered();
    }
    else {
      rootPanel6.add(this.viewPanel0);
      renderCallback.onRendered();
    }
    if(!StringUtils.isEmpty(this.width)){
      updateViewWidth(this.width);
    }
    if(!StringUtils.isEmpty(this.height)){
      updateViewHeight(this.height);
    }
    if (com.google.gwt.logging.client.LogConfiguration.loggingIsEnabled()){
      logger0.info(Crux.getMessages().viewContainerViewRendered(getId()));
    }
  }
  protected void updateViewHeight(String height){
    if (this.viewPanel0 != null){
      this.viewPanel0.setHeight(height);
    }
  }
  protected void updateViewWidth(String width){
    if (this.viewPanel0 != null){
      this.viewPanel0.setWidth(width);
    }
  }
  protected native org.cruxframework.crux.core.client.collection.Map<String> initializeLazyDependencies()/*-{
  return {};
}-*/;
public org.cruxframework.crux.core.client.ioc.IocContainer getIocContainer(){
  return iocContainer;
}
public org.cruxframework.crux.core.client.ioc.IocContainer_inputs_largeDisplayMouse getTypedIocContainer(){
  return iocContainer;
}
private org.cruxframework.crux.core.client.controller.RegisteredControllers registeredControllers;
private org.cruxframework.crux.core.client.datasource.RegisteredDataSources registeredDataSources;
protected org.cruxframework.crux.core.client.ioc.IocContainer_inputs_largeDisplayMouse iocContainer;
private final View __view = this;
private static java.util.logging.Logger logger0 = java.util.logging.Logger.getLogger(inputs_largeDisplayMouse.class.getName());
private com.google.gwt.user.client.ui.HTMLPanel viewPanel0 = null;
}
