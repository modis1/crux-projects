package org.cruxframework.gwtcreate.client.accessor;

import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.ControllerAccessor;
import org.cruxframework.gwtcreate.client.controller.ContactsController;

@BindView("main")
public interface MainViewControllers extends ControllerAccessor
{
	ContactsController contactsController();
}
