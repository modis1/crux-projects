package org.cruxframework.crossdeviceshowcase.client.controller.samples.sortablelist;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.sortablelist.SortableList;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

@Controller("sortableListController")
public class SortableListController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private SortableListMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
		
		myWidgetAccessor.sortableList().addItem(new Label("Entrar em contato com o fornecedor"));
		myWidgetAccessor.sortableList().addItem(new Label("Verificar e-mails."));
		myWidgetAccessor.sortableList().addItem(new Label("Agendar reunião para revisão de orçamento."));
		myWidgetAccessor.sortableList().addItem(new Label("Revisar relatório e encaminhar à contabilidade."));
		myWidgetAccessor.sortableList().addItem(new Label("Preparar reunião com os ivestidores."));
		myWidgetAccessor.sortableList().addItem(new Label("Analisar relatório de qualidade."));
	}
	
	@Expose
	public void addActivity()
	{
		String newActivity = myWidgetAccessor.textBoxActivity().getValue();
		if (!newActivity.equals(""))
		{
			myWidgetAccessor.sortableList().addItem(new Label(newActivity));
		}
	}
	
	@BindView("sortableList")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
		SortableList sortableList();
		TextBox textBoxActivity();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(SortableListMessages messages) {
		this.messages = messages;
	}
}
