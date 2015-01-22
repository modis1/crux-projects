package org.cruxframework.gwtcreate.client.controller;

import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.dataprovider.FetchDataEvent;
import org.cruxframework.crux.core.client.dataprovider.LazyProvider;
import org.cruxframework.crux.core.client.dataprovider.MeasureDataEvent;
import org.cruxframework.crux.core.client.dataprovider.PagedDataProvider;
import org.cruxframework.crux.core.client.event.SelectEvent;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.smartfaces.client.dialog.DialogViewContainer;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;
import org.cruxframework.crux.smartfaces.client.list.WidgetList;
import org.cruxframework.gwtcreate.client.accessor.MainViewWidgets;
import org.cruxframework.gwtcreate.client.message.ContactsMessages;
import org.cruxframework.gwtcreate.client.remote.ContactRestProxy;
import org.cruxframework.gwtcreate.shared.data.Contact;

import com.google.gwt.user.client.ui.Widget;

@Controller("contactsController")
public class ContactsController 
{
	@Inject
	public ContactRestProxy contractService; 
	
	@Inject
	public MainViewWidgets mainWidgets;
	
	@Inject
	public ContactsMessages messages;

	private Widget selectedContactWidget;

	private DialogViewContainer dialogViewContainer; 
	
    @Expose   
    public void onCountContacts(final MeasureDataEvent<Contact> event)
    {
    	contractService.countContacts(new Callback<Integer>()
		{
			@Override
            public void onSuccess(Integer result)
            {
				event.getSource().setSize(result);
            }

			@Override
            public void onError(Exception e)
            {
				MessageBox.show(e.getMessage(), MessageType.ERROR);
            }
		});
    }

	@Expose   
    public void onFetchContacts(final FetchDataEvent<Contact> event)
    {
    	contractService.getContacts(event.getStartRecord(), event.getSource().getPageSize(), new Callback<List<Contact>>()
		{
			@Override
            public void onSuccess(List<Contact> result)
            {
				if (result != null && result.size() > 0)
				{
					LazyProvider<Contact> source = event.getSource();
					source.setData(result, event.getStartRecord());
				}
            }

			@Override
            public void onError(Exception e)
            {
				MessageBox.show(e.getMessage(), MessageType.ERROR);
            }
		});
    }  

	@Expose   
    public void onSelectContact(SelectEvent event)
    {
		if (selectedContactWidget != null)
		{
			selectedContactWidget.removeStyleDependentName("selected");
		}
		
		Widget widget = (Widget) event.getSource();
		if (widget != selectedContactWidget)
		{
			selectedContactWidget = widget;
			selectedContactWidget.addStyleDependentName("selected");
		}
    }  

	@Expose   
    public void editContact()
    {
    	if (checkSelectedContact())
    	{
	    	dialogViewContainer = DialogViewContainer.createDialog("contact", "contact", false, 
	    			mainWidgets.contacts().getDataObject(selectedContactWidget));
	    	
	    	dialogViewContainer.center();
    	}
    }

	@Expose   
    public void removeContact()
    {
    	if (checkSelectedContact())
    	{
    		WidgetList<Contact> contacts = mainWidgets.contacts();
    		Contact contact = contacts.getDataObject(selectedContactWidget);
    		
    		int index = contacts.getDataProvider().indexOf(contact);
    		if (index >= 0)
    		{
    			contacts.getDataProvider().remove(index);
    			contacts.refresh();
    		}
    	}
    }  

	@Expose   
    public void addContact()
    {
    	dialogViewContainer = DialogViewContainer.createDialog("contact", "contact", false);
    	dialogViewContainer.center();
    }  

	@Expose   
    public void commit()
    {
    	PagedDataProvider<Contact> dataProvider = mainWidgets.contacts().getDataProvider();
		if (dataProvider.isDirty())
		{
			dataProvider.commit();
		}
    }  

	@Expose   
    public void rollback()
    {
    	WidgetList<Contact> contacts = mainWidgets.contacts();
		PagedDataProvider<Contact> dataProvider = contacts.getDataProvider();
		if (dataProvider.isDirty())
		{
			dataProvider.rollback();
			contacts.refresh();
		}
    }

	protected void addNewContact(Contact contact)
	{
    	WidgetList<Contact> contacts = mainWidgets.contacts();
    	PagedDataProvider<Contact> dataProvider = contacts.getDataProvider();
    	dataProvider.add(contact);
		dialogViewContainer.hide(true);
		contacts.refresh();
	}
	
	protected void updateSelectedContact(Contact contact)
	{
		if (checkSelectedContact())
		{
			WidgetList<Contact> contacts = mainWidgets.contacts();
			PagedDataProvider<Contact> dataProvider = contacts.getDataProvider();
			int widgetIndex = contacts.getWidgetIndex(selectedContactWidget);
			dataProvider.set(widgetIndex, contact);
			contacts.refresh();
		}
		dialogViewContainer.hide(true);
	}

	protected void cancelEditing()
    {
		dialogViewContainer.hide(true);
    }
	
	private boolean checkSelectedContact()
    {
	    if (selectedContactWidget == null)
    	{
    		MessageBox.show(messages.selectOneContactFirst(), MessageType.ERROR);
    		return false;
    	}
	    return true;
    }
}