package org.cruxframework.crossdeviceshowcase.client.controller.samples.anchor;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_anchor")
public interface AnchorMessages extends Messages
{
	@DefaultMessage("Anchor")
	String title();
	
	@DefaultMessage("Link implementado de forma declarativa.")
	String labelDeclarative();
	
	@DefaultMessage("Link implementado por uma controller.")
	String labelProgramatic();
	
	@DefaultMessage("Abrir página")
	String buttonLink();
	
	@DefaultMessage("Fim da página.")
	String pgEnd();
	
	@DefaultMessage("Indo para o início da página")
	String pgHome();
	
	@DefaultMessage("flavia")
	String flavia();
	
	@DefaultMessage("<p>O componente Anchor é uma âncora cross-device. Com este componente é possível criar links "
			+ "para navegação em uma mesma página (Ir para o fim da página, Ir para o início da página) e também links "
			+ "para abrir páginas externas (Link Crux Framework do exemplo). É possível ainda disparar eventos a partir "
			+ "do clique no componente, como o pop-up informativo que aparece ao clicar no primeiro exemplo.</p>")
	String htmlDescText();
}
