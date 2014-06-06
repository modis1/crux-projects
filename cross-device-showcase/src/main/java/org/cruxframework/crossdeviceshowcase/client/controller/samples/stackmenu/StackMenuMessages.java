package org.cruxframework.crossdeviceshowcase.client.controller.samples.stackmenu;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_stackMenu")
public interface StackMenuMessages extends Messages
{
	@DefaultMessage("Stack Menu")
	String title();
	
	@DefaultMessage("Você selecionou o item ")
	String info();
	
	@DefaultMessage("dentro de ")
	String complementInfo();
	
	@DefaultMessage("Insira um nome para o item de menu.")
	String errorAdd();
	
	@DefaultMessage("Insira o nome do item a ser adicionado ou removido")
	String labelItem();
	
	@DefaultMessage("Adicionar item de menu")
	String buttonAddItem();
	
	@DefaultMessage("Remover item de menu")
	String buttonRemoveItem();
	
	@DefaultMessage("O StackMenu é um menu hierárquico e vertical. Cada item em um StackMenu pode "
			+"ter um ou vários sub-itens. Inseridos de forma declarativa ou programática. "
			+"Também é possível disparar eventos de seleção neste componente. "
			+"No exemplo apresentado é possível ter a informação de qual ítem final foi seleciondo, assim como "
			+"adicionar ou remover ítens do menu, basta inserir o nome do ítem e clicar no botão correspondente.")
	String labelDescText();
}
