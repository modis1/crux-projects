package org.cruxframework.crossdeviceshowcase.client.controller.samples.formdisplay;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.views.View;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;

@Controller("formDisplayController")
public class FormDisplayController {
	
	@Expose
	public void clearFields()
	{
		TextBox frameworktextbox = View.of(this).getWidget("frameworkTextBox", TextBox.class);
		TextBox versionTextBox = View.of(this).getWidget("versionTextBox", TextBox.class);
		TextBox subjectTextBox = View.of(this).getWidget("subjectTextBox", TextBox.class);
		CheckBox desktopCheckBox = View.of(this).getWidget("desktopCheckBox", CheckBox.class);
		CheckBox smartPhoneCheckBox = View.of(this).getWidget("smartPhoneCheckBox", CheckBox.class);
		CheckBox tabletCheckBox = View.of(this).getWidget("tabletCheckBox", CheckBox.class);
		frameworktextbox.setText("");
		versionTextBox.setText("");
		subjectTextBox.setText("");	
		desktopCheckBox.setValue(false);
		smartPhoneCheckBox.setValue(false);
		tabletCheckBox.setValue(false);
	}
}
