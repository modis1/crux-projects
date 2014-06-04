package org.cruxframework.crossdeviceshowcase.client.controller.samples.tabviewcontainer;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_tabViewContainer")
public interface TabViewContainerMessages extends Messages
{
	@DefaultMessage("Tab View Container")
	String title();
	 
	@DefaultMessage("Estas views estão sendo carregadas por um TabViewContainer.")
	String labelText();
	
	@DefaultMessage("Insira uma url válida")
	String labelUrl();
	
	@DefaultMessage("http://www.cruxframework.org")
	String textBoxUrl();
	
	@DefaultMessage("Adicionar View Message Box")
	String buttonAddViewMessageBox();
	
	@DefaultMessage("Adicionar View Dialog Box")
	String buttonAddViewDialogBox();
	
	@DefaultMessage("Adicionar View Progress Box")
	String buttonAddViewProgressBox();

	@DefaultMessage("Adicionar URL")
	String buttonAddURL();
	
	@DefaultMessage("Remover aba selecionada")
	String buttonRemove();
	
	@DefaultMessage("Não há view selecionada para ser removida.")
	String alert();
	
	@DefaultMessage("O componente TabViewContainer permite que várias views compartilhem o mesmo espaço. "
			+"A aba desejada pode ser visualizada clicando sobre seu nome na parte superior e pode ser fechada " 
			+"através de um clique no botão fechar (x). "
			+"No exemplo apresentado é possível remover uma aba clicando no botão Remover aba selecionada e também é "
			+"possível adicionar várias outras abas clicando no botão Adicionar e inserindo uma Url por exemplo. "
			+"Perceba que a medida em que mais abas são criadas a barra de rolagem se torna funcional automaticamente.")
	String labelDescText();
}
 
 


  
