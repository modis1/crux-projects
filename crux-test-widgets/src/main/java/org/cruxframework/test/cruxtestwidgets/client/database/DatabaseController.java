package org.cruxframework.test.cruxtestwidgets.client.database;

import java.util.logging.Logger;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.db.DatabaseCallback;
import org.cruxframework.crux.core.client.db.DatabaseRetrieveCallback;
import org.cruxframework.crux.core.client.db.ObjectStore;
import org.cruxframework.crux.core.client.db.Transaction;
import org.cruxframework.crux.core.client.db.Transaction.TransactionCallback;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.test.cruxtestwidgets.client.database.objectstore.PersonOS;
import org.cruxframework.test.cruxtestwidgets.client.database.offline.MyDatabase;

import com.google.gwt.user.client.Window;

@Controller("databaseController")
public class DatabaseController 
{
	Logger LOG = Logger.getLogger(DatabaseController.class.getName());
	
	@Inject
	private MyDatabase myDatabase;

	@Expose
	public void onLoad() 
	{
		myDatabase.open(new DatabaseCallback()
		{
			@Override
			public void onSuccess()
			{
				LOG.info("database opened");
				PersonOS person = new PersonOS();
				person.setKey(1);
				person.setName("Person1");
				savePersonOS(person);	
			}
			
			@Override
			public void onError(String message) 
			{
				super.onError(message);
			}
		});
	}

	private void loadPersonOS(Integer id) 
	{
		myDatabase.get(id, PersonOS.STORE_NAME, new DatabaseRetrieveCallback<PersonOS>()
		{
			public void onSuccess(PersonOS personOS)
			{
				Window.alert("PersonOS name: "+personOS.getName());
			}
			@Override
			public void onError(String message) 
			{
				super.onError(message);
			}
		});
	}

	private void savePersonOS(final PersonOS personOS) 
	{
		TransactionCallback transactionCallback = new TransactionCallback()
		{
			public void onComplete()
			{
				LOG.info("Transaction Completed!");
			}
			public void onAbort() 
			{
				LOG.info("Transaction aborted!");
			}

			public void onError(String message) 
			{
				LOG.info("Error ["+message+"]. Transaction rolled back!");
			}
		};
			
		Transaction transaction = myDatabase.getTransaction(new String[]{PersonOS.STORE_NAME}, Transaction.Mode.readWrite, transactionCallback);
		ObjectStore<Integer, PersonOS> personOSStore = transaction.getObjectStore(PersonOS.STORE_NAME);
		personOSStore.put(personOS);
		loadPersonOS(1);
	}

	public void setMyDatabase(MyDatabase myDatabase) 
	{
		this.myDatabase = myDatabase;
	}
}
