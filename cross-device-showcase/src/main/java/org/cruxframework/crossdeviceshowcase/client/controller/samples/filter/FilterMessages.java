package org.cruxframework.crossdeviceshowcase.client.controller.samples.filter;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_filter")
public interface FilterMessages extends Messages
{
	@DefaultMessage("Filter")
	String title();
	
	@DefaultMessage("Meios de transporte")
	String caption();
	
	@DefaultMessage("Digite um meio de transporte")
	String labelText();
	
	@DefaultMessage("Palavra sugerida selecionada.")
	String wordFound();
	
	@DefaultMessage("Bicicleta")
	String bike();
	
	@DefaultMessage("Carro")
	String car();
	
	@DefaultMessage("Caminhão")
	String truck();
	
	@DefaultMessage("Ônibus")
	String bus();
	
	@DefaultMessage("Motocicleta")
	String motorcycle();
	
	@DefaultMessage("Metrô")
	String subway();
	
	@DefaultMessage("Trem")
	String train();
	
	@DefaultMessage("Navio")
	String ship();

	@DefaultMessage("Barco")
	String boat();
	
	@DefaultMessage("Caravela")
	String caravela();
	
	@DefaultMessage("Barca")
	String barge();
	
	@DefaultMessage("Balsa")
	String raft();
	
	@DefaultMessage("Avião")
	String airplane();
	
	@DefaultMessage("Balão")
	String balloon();
	
	@DefaultMessage("Dirigível")
	String airship();
	
	@DefaultMessage("<p>O componente Filter é uma caixa de texto que sugere possíveis resultados a partir "
			+ "do conteúdo inserido pelo usuário. É um facilitador para o usuário no momento em que necessita "
			+ "inserir alguma informação ou fazer uma busca.</p><p>O Filter ainda permite Habilitar "
			+ "recursos como: animação, selecionar automaticamente e ativar um foco na sequência localizada.</p>"
			+ "<p>No exemplo acima, quando o usuário começar a digitar, a caixa de texto apresentará possíveis sugestões "
			+ "de meios de transporte de acordo com o dado inserido.</p>")
	String htmlDescText();
}
