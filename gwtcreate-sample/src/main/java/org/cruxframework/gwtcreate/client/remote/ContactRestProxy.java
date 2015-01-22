package org.cruxframework.gwtcreate.client.remote;

import java.util.List;

import org.cruxframework.crux.core.client.rest.Callback;
import org.cruxframework.crux.core.client.rest.RestProxy;
import org.cruxframework.crux.core.client.rest.RestProxy.TargetRestService;
import org.cruxframework.gwtcreate.shared.data.Contact;

@TargetRestService("contactService")
public interface ContactRestProxy extends RestProxy
{ 
	void countContacts(Callback<Integer> callback);
	void getContacts(int startRecord, int pageSize, Callback<List<Contact>> callback);
}
