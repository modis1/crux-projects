package org.cruxframework.test.cruxtestwidgets.client.database.objectstore;

import org.cruxframework.crux.core.client.db.annotation.Store;
import org.cruxframework.crux.core.client.db.annotation.Store.Indexed;
import org.cruxframework.crux.core.client.db.annotation.Store.Key;

@Store(PlaceOS.STORE_NAME)
public class PlaceOS
{
	public static final String STORE_NAME = "Place";

	private Integer key;
	private String name;
	
	@Key
	public Integer getKey() 
	{
		return key;
	}
	public void setKey(Integer key) 
	{
		this.key = key;
	}
	@Indexed
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
}
