package org.cruxframework.gwtcreate.client.message;

import org.cruxframework.crux.core.client.i18n.MessageName;

import com.google.gwt.i18n.client.Messages;

@MessageName("messages")
public interface ContactsMessages extends Messages
{
	@DefaultMessage("New")
	String newContact();

	@DefaultMessage("Remove")
	String removeContact();

	@DefaultMessage("Edit")
	String editContact();

	@DefaultMessage("Save")
	String save();

	@DefaultMessage("Cancel")
	String cancel();

	@DefaultMessage("Undo")
	String undoChanges();
	
	@DefaultMessage("My Contacts")
	String 	myContacts();

	@DefaultMessage("First Name:")
	String 	firstName();

	@DefaultMessage("Last Name:")
	String 	lastName();

	@DefaultMessage("Email:")
	String 	email();
	
	@DefaultMessage("Contact Info")
	String contactInfo ();

	@DefaultMessage("Select a contact into the contact list first.")
	String selectOneContactFirst();
}
