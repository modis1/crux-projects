package org.cruxframework.crossdeviceshowcase.client.controller.samples.topmenudisposal;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.disposal.topmenudisposal.TopMenuDisposal;

@Controller("topMenuDisposalController")
public class TopMenuDisposalController 
{
	@Inject
	private TopMenuDisposalView topmenudisposalview;

	@Expose
	public void onLoad()
	{			
		topmenudisposalview.menu().addMenuEntry("Form Display", "formDisplay");
		topmenudisposalview.menu().addMenuEntry("Masked Text Box", "maskedTextBox");
	}
	
	@BindView("topMenuDisposal")
	public static interface TopMenuDisposalView extends WidgetAccessor
	{
		TopMenuDisposal menu();
		Button buttonShow();
	}

	public void setTopmenudisposalview(TopMenuDisposalView topmenudisposalview) 
	{
		this.topmenudisposalview = topmenudisposalview;
	}
}
