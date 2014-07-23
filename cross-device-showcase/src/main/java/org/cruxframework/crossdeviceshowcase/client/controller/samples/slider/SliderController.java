package org.cruxframework.crossdeviceshowcase.client.controller.samples.slider;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.slider.Slider;
import org.cruxframework.crux.widgets.client.textbox.NumberTextBox;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

@Controller("sliderController")
public class SliderController 
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;

	@Inject
	private SliderMessages messages;

	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());
		
		myWidgetAccessor.slider().changeControlsVisibility(false);
		myWidgetAccessor.slider().showFirstWidget();
	
		statusButtons();
	}
	
	@Expose
	public void previous()
	{
		myWidgetAccessor.slider().previous();
		statusButtons();
	}
	
	@Expose
	public void next()
	{
		int currentWidgetIndex = myWidgetAccessor.slider().getCurrentWidgetIndex();
		
		if(currentWidgetIndex == 1)
		{
			if(verifyPersonal())
			{
				myWidgetAccessor.slider().next();
				statusButtons();
			}else
			{
				FlatMessageBox.show(messages.emptyFields(), MessageType.WARN);
			}
		}else if(currentWidgetIndex == 2)
		{
			if(verifyProfessional())
			{
				printResult(newPerson());
				myWidgetAccessor.slider().next();
				statusButtons();
			}else
			{
				FlatMessageBox.show(messages.emptyFields(), MessageType.WARN);
			}
		}else
		{
			myWidgetAccessor.slider().next();
			statusButtons();
		}			
	}
	
	@Expose
	public void cancel()
	{
		clearFields();
		myWidgetAccessor.slider().showFirstWidget();
		statusButtons();
	}
	
	@Expose
	public void finish()
	{
		if(verifyPersonal() && verifyProfessional())
		{
			clearFields();
			FlatMessageBox.show(messages.thanks(), MessageType.SUCCESS);
			myWidgetAccessor.slider().showFirstWidget();
			statusButtons();
		}
	}
	
	private Person newPerson()
	{
		Person person = new Person();
		person.setName(myWidgetAccessor.textBoxName().getText());
		person.setAge(myWidgetAccessor.numberBoxAge().getValue());
		person.setPhone(myWidgetAccessor.numberCodPhone().getValue());
		person.setProfession(myWidgetAccessor.textBoxProfession().getText());
		person.setExperienceTime(myWidgetAccessor.numberTimeExperience().getValue());
		
		return person;
	}
	
	private void printResult(Person person)
	{
		String experience = "Mês(es)";
		if (myWidgetAccessor.radioButtonYears().getValue())
		{
			experience = "Ano(s)";
		}
		
		String result = "<p>Nome: " + person.getName() + "</p>"
		+ "<p>Idade: " + person.getAge() + "</p>"
		+ "<p>Telefone: " + person.getPhone() + "</p>"
		+ "<p>Profissão: " + person.getProfession() +"</p>"
		+ "<p>Tempo de Experiência: " + person.getExperienceTime()+ " "+experience+"</p>";
		
//		String result = "<p>Nome: " + myWidgetAccessor.textBoxName().getText() +"</p>"
//				+ "<p>Idade: " + myWidgetAccessor.numberBoxAge().getValue() +"</p>"
//				+ "<p>Telefone: (" + myWidgetAccessor.numberCodPhone().getValue()+") "
//				+myWidgetAccessor.numberInitPhone().getValue()+"-"+myWidgetAccessor.numberFinalPhone().getValue()+"</p>"
//				+ "<p>Profissão: "+myWidgetAccessor.textBoxProfession().getText() +"</p>"
//				+ "<p>Tempo de Experiência: "+myWidgetAccessor.numberTimeExperience().getValue()+ " "+experience+"</p>";
		
		myWidgetAccessor.htmlResult().setHTML(result);
	}
	
	private void statusButtons()
	{
		int widgetIndex = myWidgetAccessor.slider().getCurrentWidgetIndex();
		
		switch (widgetIndex)
		{
			case 0: myWidgetAccessor.btnCancel().setEnabled(false);
			myWidgetAccessor.btnPrevious().setEnabled(false);
			myWidgetAccessor.btnNext().setEnabled(true);
			myWidgetAccessor.btnFinish().setEnabled(false);
			break;	
			
			case 1: myWidgetAccessor.btnCancel().setEnabled(true);
			myWidgetAccessor.btnPrevious().setEnabled(true);
			myWidgetAccessor.btnNext().setEnabled(true);
			myWidgetAccessor.btnFinish().setEnabled(false);
			break;	
			
			case 2: myWidgetAccessor.btnCancel().setEnabled(true);
			myWidgetAccessor.btnPrevious().setEnabled(true);
			myWidgetAccessor.btnNext().setEnabled(true);
			myWidgetAccessor.btnFinish().setEnabled(false);
			break;	
			
			case 3: myWidgetAccessor.btnCancel().setEnabled(true);
			myWidgetAccessor.btnPrevious().setEnabled(true);
			myWidgetAccessor.btnNext().setEnabled(false);
			myWidgetAccessor.btnFinish().setEnabled(true);
			break;	
		}
	}
	
	private void clearFields()
	{
		myWidgetAccessor.textBoxName().setText(null); 
		myWidgetAccessor.numberBoxAge().setValue(null); 
		myWidgetAccessor.numberCodPhone().setValue(null);
		myWidgetAccessor.numberInitPhone().setValue(null);
		myWidgetAccessor.numberFinalPhone().setValue(null);
		myWidgetAccessor.textBoxProfession().setText(null);
		myWidgetAccessor.numberTimeExperience().setValue(null);
		myWidgetAccessor.radioButtonYears().setValue(true);
	}
	
	private boolean verifyPersonal()
	{
		boolean complete = false;
		
		if(!myWidgetAccessor.textBoxName().getValue().equals("") &&  
			myWidgetAccessor.numberBoxAge().getValue() != null && 
			myWidgetAccessor.numberCodPhone().getValue() != null &&
			myWidgetAccessor.numberInitPhone().getValue() != null &&
			myWidgetAccessor.numberFinalPhone().getValue() != null)
		{
			complete = true;
		}
		return complete;
	}
	
	private boolean verifyProfessional()
	{
		boolean complete = false;
		
		if(!myWidgetAccessor.textBoxProfession().getValue().equals("") && 
			myWidgetAccessor.numberTimeExperience().getValue() != null) 
		{
			complete = true;
		}
		return complete;
	}

	@BindView("slider")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
		Slider slider();
		
		TextBox textBoxName();
		NumberTextBox numberBoxAge();
		NumberTextBox numberCodPhone();
		NumberTextBox numberInitPhone();
		NumberTextBox numberFinalPhone();
		
		TextBox textBoxProfession();
		NumberTextBox numberTimeExperience();
		RadioButton radioButtonYears();
		
		HTML htmlResult();
		
		Button btnCancel();
		Button btnPrevious();
		Button btnNext();
		Button btnFinish();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(SliderMessages messages) {
		this.messages = messages;
	}
}
