package org.cruxframework.gwtcreate.client.accessor;

import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.list.WidgetList;
import org.cruxframework.gwtcreate.shared.data.Contact;

@BindView("main")
public interface MainViewWidgets extends WidgetAccessor
{
	WidgetList<Contact> contacts();
}
