package org.cruxframework.gwtcreate.server;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crux.core.server.rest.annotation.RestService;
import org.cruxframework.crux.core.shared.rest.annotation.GET;
import org.cruxframework.crux.core.shared.rest.annotation.Path;
import org.cruxframework.crux.core.shared.rest.annotation.QueryParam;
import org.cruxframework.gwtcreate.shared.data.Contact;


@RestService("contactService")
@Path("contact")
public class ContactService
{
	private static final int DEFAULT_PAGE_SIZE = 10;
	
	private static Contact[] CONTACT_DATA = {
		new Contact("Thiago", "Bustamante", "thiago.bustamente@triggolabs.com"),
		new Contact("John", "Smith", "jonh.smith@cruxframework.org"),
		new Contact("Paul", "Brown", "paul.brown@cruxframework.org"),
		new Contact("Mary", "White", "mary.white@cruxframework.org"),
		new Contact("Jane", "Smith", "jane.smith@cruxframework.org"),
		new Contact("Tom", "Wilson", "tom.wilson@cruxframework.org"),
		new Contact("Peter", "Parkes", "peter.parker@cruxframework.org"),
		new Contact("Logan", "Smith", "Logan.smith@cruxframework.org"),
		new Contact("Paul", "White", "paul.white@cruxframework.org"),
		new Contact("James", "Wester", "james.wester@cruxframework.org"),
		new Contact("Jan", "Doe", "jon.doe@cruxframework.org")
	};
	
	@GET
	@Path("size")
	public Integer countContacts()
	{
		return CONTACT_DATA.length;
	}
	
	@GET
	@Path("all")
	public Contact[] getContacts(@QueryParam("start")int startRecord, 
								@QueryParam("size")int pageSize)
	{
		if (startRecord < CONTACT_DATA.length - 1)
		{
			if (pageSize <= 0)
			{
				pageSize = DEFAULT_PAGE_SIZE;
			}
			
			List<Contact> result = new ArrayList<Contact>();
			
			int endRecord = startRecord+pageSize;
			if (endRecord >= CONTACT_DATA.length)
			{
				endRecord = CONTACT_DATA.length - 1;
			}
			for (int i = startRecord; i <= endRecord; i++)
			{
				result.add(CONTACT_DATA[i]);
			}
			
			return result.toArray(new Contact[result.size()]);
		}
		
		return null;
	}
}
