package org.cruxframework.test.cruxtestwidgets.client;

import org.cruxframework.crux.core.client.formatter.InvalidFormatException;
import org.cruxframework.crux.core.client.formatter.annotation.FormatterName;
import org.cruxframework.crux.widgets.client.maskedtextbox.MaskedTextBoxBaseFormatter;

@FormatterName("mutableMaskedDateFormatter")
public class MutableMaskedDateFormatter extends MaskedTextBoxBaseFormatter
{
	public static final String DEFAULT_MASK_STRING = "aaaa";
	
	private String mask;
	
	public MutableMaskedDateFormatter()
	{
		mask = DEFAULT_MASK_STRING;
	}
	
	@Override
	public String format(Object input) throws InvalidFormatException
	{
		return input == null ? "" : input.toString();
	}

	@Override
	public Object unformat(String input) throws InvalidFormatException
	{
		return input == null || input.trim().length() == 0 ? "" : input;
	}
	
	/******************************************
	 * Getters and setters
	 ******************************************/

	@Override
	public String getMask() 
	{
		return mask;
	}

	public void setMask(String mask)
	{
		this.mask = mask;
	}
}