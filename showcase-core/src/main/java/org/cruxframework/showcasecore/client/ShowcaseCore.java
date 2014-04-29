package org.cruxframework.showcasecore.client;

import org.cruxframework.showcasecore.client.resource.common.ShowcaseResourcesCommon;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.core.client.ScriptInjector;

public class ShowcaseCore implements EntryPoint 
{
	@Override
	public void onModuleLoad() 
	{
		final ShowcaseResourcesCommon bundle = GWT.create(ShowcaseResourcesCommon.class);
		
		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
			
			@Override
			public boolean execute() {
				ScriptInjector.fromString(bundle.jsShBrushJava().getText()).inject();
				ScriptInjector.fromString(bundle.jsShBrushXml().getText()).inject();
				ScriptInjector.fromString(bundle.jsShCore().getText()).inject();
				initBrushFunction();
				return false;
			}

			private native void initBrushFunction() /*-{
			    SyntaxHighlighter.defaults['auto-links'] = false;
				SyntaxHighlighter.defaults['quick-code'] = false;
				SyntaxHighlighter.highlight();
			  }-*/;
		}, 1000);
		
	}
}
