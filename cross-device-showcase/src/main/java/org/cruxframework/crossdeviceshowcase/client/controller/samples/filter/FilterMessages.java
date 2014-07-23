package org.cruxframework.crossdeviceshowcase.client.controller.samples.filter;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_filter")
public interface FilterMessages extends Messages
{
	@DefaultMessage("Filter")
	String title();
	
	@DefaultMessage("<p>O componente Filter é uma caixa de texto que sugere possíveis resultados a partir "
			+ "do conteúdo inserido pelo usuário. É um facilitador para o usuário no momento em que necessita"
			+ "inserir alguma informação ou fazer uma busca por exemplo.</p><p>O Filter ainda permite Habilitar "
			+ "recursos como: animação, selecionar automaticamente e ativar um foco na sequência localizada.</p>"
			+ "<p>No exemplo acima, quando o usuário começar a digitar, a caixa de texto apresentará possíveis sugestões "
			+ "de meios de transporte de acordo com o dado inserido.</p>")
	String htmlDescText();
}
