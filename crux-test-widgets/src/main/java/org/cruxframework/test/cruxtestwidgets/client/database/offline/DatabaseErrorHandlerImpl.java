package org.cruxframework.test.cruxtestwidgets.client.database.offline;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.cruxframework.crux.core.client.db.DatabaseErrorHandler;

import com.google.gwt.user.client.Window;

public class DatabaseErrorHandlerImpl implements DatabaseErrorHandler
{
	Logger LOG = Logger.getLogger(DatabaseErrorHandlerImpl.class.getName());
	
	@Override
	public void onError(String message)
	{
		Window.alert(message);
	}
	
	@Override
	public void onError(String message, Throwable t)
	{
		LOG.log(Level.SEVERE, message, t);
		Window.alert(message);
	}
}
