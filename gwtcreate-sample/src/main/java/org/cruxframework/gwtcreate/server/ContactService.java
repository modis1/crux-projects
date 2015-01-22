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
		new Contact("Thiago", "Bustamante", "thiago@cruxframework.org"),
		new Contact("Samuel", "Cardoso", "samuel@cruxframework.org"),
		new Contact("Cláudio", "Júnior", "claudio.junior@triggolabs.com"),
		new Contact("Alexandre", "Costa", "alexandre.costa@triggolabs.com"),
		new Contact("Wesley", "Diniz", "wesley.diniz@triggolabs.com"),
		new Contact("Bruno", "Rafael", "bruno.rafael@triggolabs.com"),
		new Contact("Flavia", "Yeshua", "flavia.yeshua@triggolabs.com"),
		new Contact("Juliano", "Santos", "juliano@triggolabs.com"),
		new Contact("Gustavo", "Borja", "gustavo.borja@triggolabs.com"),
		new Contact("Virgínia", "Bonfante", "virginia.bonfante@triggolabs.com"),
		new Contact("Gessé", "Dafé", "gessedafe@gmail.com")
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
