package org.cruxframework.gwtcreate.client.controller;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.ViewLoadEvent;
import org.cruxframework.gwtcreate.client.accessor.MainViewControllers;
import org.cruxframework.gwtcreate.shared.data.Contact;

@Controller("contactInfoController")
public class ContactInfoController
{
	@Inject
	public MainViewControllers mainControllers;
	
	private boolean newRecord;
	
	@Expose
	public void onLoad(ViewLoadEvent event)
    { 
		Contact contact = event.getParameterObject();
		newRecord = contact == null;
		if (!newRecord)
		{
			View.of(this).write(contact);
		}
    }
	
	private Contact getContact()
    {
	    return View.of(this).read(Contact.class);
    }  

	@Expose
	public void saveAddOrUpdate()
	{
		Contact contact = getContact();
		if (newRecord)
		{
			mainControllers.contactsController().addNewContact(contact);
		}
		else
		{
			mainControllers.contactsController().updateSelectedContact(contact);
		}
	}
	
	@Expose
	public void cancel()
	{
		mainControllers.contactsController().cancelEditing();
	}
	
}
