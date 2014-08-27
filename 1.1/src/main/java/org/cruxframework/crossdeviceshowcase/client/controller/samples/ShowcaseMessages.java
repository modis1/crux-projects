package org.cruxframework.crossdeviceshowcase.client.controller.samples;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_showcase")
public interface ShowcaseMessages extends Messages
{
	@DefaultMessage("Bem-vindo")
	String shortWelcome();
	
	@DefaultMessage("Site")
	String site();
	
	@DefaultMessage("Projeto")
	String project();
	
	@DefaultMessage("Bem-vindo ao Crux 5 Showcase!")
	String welcome();
	
	@DefaultMessage("O Crux Framework 5 provê uma série de componentes cross-device para aplicações Web."
			+ "Neste showcase são apresentados exemplos de uso dos componentes oferecidos pelo Crux.") 
	String info1();
	
	@DefaultMessage("Em cada exemplo é apresentado o componente, como é o seu funcionamento e sua apresentação na tela."
			+ "Também está disponível para consulta o código fonte de cada exemplo.")
	String info2();
	
	@DefaultMessage("Este site está em construção, a cada dia novos exemplos são elaborados e adicionados ao showcase.")
	String info3();
	
	@DefaultMessage("Elementos de Formulário")
	String formElements();
	
	@DefaultMessage("FileUploader")
	String fileUploader();
	
	@DefaultMessage("MaskedLabel")
	String maskedLabel();
	
	@DefaultMessage("MaskedTextBox")
	String maskedTextbox();
	
	@DefaultMessage("Button")
	String button();
	
	@DefaultMessage("TextBox")
	String textBox();
	
	@DefaultMessage("TextArea")
	String textArea();
	
	@DefaultMessage("Elementos de Layout")
	String layoutElements();
	
	@DefaultMessage("StyledPanel")
	String styledPanel();
	
	@DefaultMessage("FormDisplay")
	String formDisplay();
	
	@DefaultMessage("Caixas de Diálogo")
	String dialogBoxes();
	
	@DefaultMessage("ProgressBox")
	String progressBox();
	
	@DefaultMessage("MessageBox")
	String messageBox();
	
	@DefaultMessage("Elementos de Dados")
	String dataElements();
	
	@DefaultMessage("DeviceAdaptiveGrid")
	String deviceAdaptiveGrid();
	
	@DefaultMessage("Elementos de Imagem")
	String imageElements();
	
	@DefaultMessage("PromoBanner")
	String promoBanner();
	
	@DefaultMessage("Slideshow")
	String slideShow();
	
	@DefaultMessage("StoryBoard")
	String storyBoard();
	
	@DefaultMessage("Elementos de Informação")
	String infoElements();
	
	@DefaultMessage("ScrollBanner")
	String scrollBanner();

	@DefaultMessage("Database não suportada")
	String databaseNotSupportedError();
	
	@DefaultMessage("TopMenuDisposal")
	String topMenuDisposal();
	
	@DefaultMessage("StackMenu")
	String stackMenu();
	
	@DefaultMessage("ColorPicker")
	String colorPicker();
	
	@DefaultMessage("ListShuttle")
	String listShuttle();
	
	@DefaultMessage("Image")
	String image();
	
	@DefaultMessage("SingleSelect")
	String singleSelect();
	
	@DefaultMessage("Timer")
	String timer();
	
	@DefaultMessage("DialogViewContainer")
	String dialogViewContainer();
	
	@DefaultMessage("Elementos de menu")
	String menuElements();
	
	@DefaultMessage("Elementos diversos")
	String miscellaneousElements();
	
	@DefaultMessage("Elementos de aba")
	String tabElements();
	
	@DefaultMessage("DialogBox")
	String dialogBox();
	
	@DefaultMessage("Anchor")
	String anchor();
	
	@DefaultMessage("NumberTextBox")
	String numberTextBox();
	
	@DefaultMessage("Filter")
	String filter();
	
	@DefaultMessage("DateBox")
	String dateBox();
}
