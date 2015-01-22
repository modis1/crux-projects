package org.cruxframework.gwtcreate.shared.data;

import java.io.Serializable;

import org.cruxframework.crux.core.client.dto.DataObject;

@DataObject("contact")
public class Contact implements Serializable
{
    private static final long serialVersionUID = -848444894214013789L;
 
    private String firstName;
	private String lastName;
	private String email;
	
	public Contact()
    {
    }
	
	public Contact(String firstName, String lastName, String email)
    {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
    }

	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
}
