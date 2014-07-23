package org.cruxframework.crossdeviceshowcase.client.controller.samples.slider;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages_slider")
public interface SliderMessages extends Messages
{
	@DefaultMessage("Slider")
	String title();
	
	@DefaultMessage("Preencha todos os campos.")
	String emptyFields();
	
	@DefaultMessage("Obrigado pelas informações.")
	String thanks();
	
	@DefaultMessage("Bem vindo!")
	String labelWelcome();

	@DefaultMessage("Para começar clique em Próximo")
	String labeNext();

	@DefaultMessage("Dados Pessoais")
	String labelPersonal();

	@DefaultMessage("Nome:")
	String personalName();

	@DefaultMessage("Idade:")
	String personalAge();

	@DefaultMessage("Telefone:")
	String personalPhone();

	@DefaultMessage("Dados Profissionais")
	String labelProfessional();

	@DefaultMessage("Profissão:")
	String profession();

	@DefaultMessage("Tempo de Experiência:")
	String labelExperience();

	@DefaultMessage("Anos")
	String radioYears();

	@DefaultMessage("Meses")
	String radioMonths();

	@DefaultMessage("Confira as informações:")
	String labelCheckData();

	@DefaultMessage("Clique em voltar para alterar ou em Fim para finalizar.")
	String labelFinish();

	@DefaultMessage("Cancelar")
	String btnCancel();

	@DefaultMessage("Voltar")
	String btnPrevious();

	@DefaultMessage("Próximo")
	String btnNext();

	@DefaultMessage("Fim")
	String btnFinish();
	
	@DefaultMessage("<p>O componente Slider é um painel cross-device que troca seu conteúdo usando animações de slides.</p>"
			+ "<p>É possível adicionar qualquer componente válido dentro de um Slider, também é possível definir o tempo de duração "
			+ "das transições, definir a página inicial do painel e ainda se terá um efeito circular para apresentação das páginas "
			+ "do painel, ou seja, quando chegar na última página, volta para a primeira automaticamente.</p>")
	String htmlDescText();
}


