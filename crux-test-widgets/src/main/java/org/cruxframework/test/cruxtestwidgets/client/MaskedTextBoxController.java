
package org.cruxframework.test.cruxtestwidgets.client;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.widgets.client.maskedtextbox.MaskedTextBox;

import com.google.gwt.user.client.ui.TextBox;

@Controller("maskedTextBoxController")
public class MaskedTextBoxController
{
	@Expose
	public void readMask()
	{
		View view = View.of(this);
		TextBox maskTextBox = (TextBox) view.getWidget("gwtTxtBoxMask");
		MaskedTextBox masked = (MaskedTextBox) view.getWidget("dateInput");
		
		MutableMaskedDateFormatter formatter = 
			(MutableMaskedDateFormatter) masked.getFormatter();
		
		masked.setUnformattedValue("");
		formatter.setMask(maskTextBox.getText());
		masked.setFormatter(formatter, true);
	}
	

}
