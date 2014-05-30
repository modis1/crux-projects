package org.cruxframework.crossdeviceshowcase.client.controller.samples.listshuttle;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_listShuttle")
public interface ListShuttleMessages extends Messages
{
	@DefaultMessage("List Shuttle")
	String title();
	 
	@DefaultMessage("Monte seu time com os jogadores disponíveis")
	String labelChoosePlayers();
	
	@DefaultMessage("Jogadores disponíveis")
	String availableHeader();
	
	@DefaultMessage("Jogadores selecionados")
	String selectedHeader();
	
	@DefaultMessage("O ListShuttle é um componente que possibilita a transferência de itens de uma lista para outra. " 
			+ "É possível transferir um, vários ou todos os elementos de uma só vez. "
			+ "No exemplo apresentado os itens das listas (jogadores) foram adicionados através de uma controller, " 
			+ "possibilitando buscar estes itens de uma fonte de dados.")
	String labelDescText();
}
