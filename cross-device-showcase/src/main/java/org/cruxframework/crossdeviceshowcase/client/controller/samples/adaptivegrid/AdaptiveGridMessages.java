package org.cruxframework.crossdeviceshowcase.client.controller.samples.adaptivegrid;

import org.cruxframework.showcasecore.client.ShowcaseMessages;

public interface AdaptiveGridMessages extends ShowcaseMessages
{
	@DefaultMessage("O seu navegador não suporta a criação de bancos de dados locais.")
	String databaseNotSupportedError();
}
