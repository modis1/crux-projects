/**
 * 
 */
package org.cruxframework.crossdeviceshowcase.client.controller.samples.simpledatabase;

import org.cruxframework.crossdeviceshowcase.client.controller.samples.ShowcaseMessages;
import org.cruxframework.crux.core.client.Crux;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.db.DatabaseCallback;
import org.cruxframework.crux.core.client.db.DatabaseRetrieveCallback;
import org.cruxframework.crux.core.client.db.DatabaseWriteCallback;
import org.cruxframework.crux.core.client.db.ObjectStore;
import org.cruxframework.crux.core.client.db.Transaction;
import org.cruxframework.crux.core.client.db.Transaction.Mode;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.ioc.Inject.Scope;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.BindableView;
import org.cruxframework.crux.core.client.screen.views.ViewAccessor;
import org.cruxframework.crux.core.client.screen.views.ViewActivateEvent;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.dialog.MessageDialog;
import org.cruxframework.crux.widgets.client.dialogcontainer.DialogViewContainer;
import org.cruxframework.crux.widgets.client.event.row.RowDoubleClickEvent;
import org.cruxframework.crux.widgets.client.grid.Grid;

/**
 * @author Thiago da Rosa de Bustamante
 *
 */
@Controller("simpleDatabaseController")
public class SimpleDatabaseController 
{
	@Inject(scope=Scope.DOCUMENT)
	private CompanyDatabase database;

	@Inject(scope=Scope.DOCUMENT)
	private ShowcaseMessages messages;
	
	@Inject
	private DatabaseWidgets databaseWidgets;

	@Inject
	private Views views;
	
	public void setViews(Views views) 
	{
		this.views = views;
	}

	public void setDatabaseWidgets(DatabaseWidgets view) 
	{
		this.databaseWidgets = view;
	}

	public void setDatabase(CompanyDatabase database) 
	{
		this.database = database;
	}
	
	public void setMessages(ShowcaseMessages messages) 
	{
		this.messages = messages;
	}

	@Expose
	public void onActivate() 
	{
		if (!database.isSupported())
		{
			Crux.getErrorHandler().handleError(messages.databaseNotSupportedError());
		}
		else 
		{
			if (!database.isOpen())
			{
				database.open(new DatabaseCallback() 
				{
					@Override
					public void onSuccess() 
					{
						databaseWidgets.peopleGrid().loadData();
					}
				});
			}
		}
	}
	
	@Expose
	public void add()
	{
		DialogViewContainer dialog = DialogViewContainer.createDialog("person");
		dialog.center();
	}
	
	@Expose
	public void openPersonView(ViewActivateEvent event)
	{
		Person person = event.getParameterObject();
		if (person == null)
		{
			person = new Person();
		}
		views.person().setData(person);
	}
	
	@Expose
	public void editPerson(RowDoubleClickEvent event)
	{
		PersonResume personResume = (PersonResume) event.getRow().getBoundObject();
		
		Transaction transaction = database.getTransaction(new String[]{Person.STORE_NAME}, Mode.readOnly);
		ObjectStore<Integer, Person> personStore = transaction.getObjectStore(Person.STORE_NAME);
		personStore.get(personResume.getId(), new DatabaseRetrieveCallback<Person>() {
			@Override
			public void onSuccess(Person person) 
			{
				DialogViewContainer dialog = new DialogViewContainer();
				dialog.showView("person", "person", person);
				dialog.center();
			}
		});
	}

	@Expose
	public void savePerson()
	{
		Person person = views.person().getData();
		Transaction transaction = database.getTransaction(new String[]{Person.STORE_NAME}, Mode.readWrite);
		ObjectStore<Integer, Person> personStore = transaction.getObjectStore(Person.STORE_NAME);
		
		personStore.put(person, new DatabaseWriteCallback<Integer>() {
			@Override
			public void onSuccess(Integer result) 
			{
				MessageDialog.show("Sucesso", "Objeto salvo com sucesso", null);
			}
		});
	}
	
	@Expose
	public void refreshGrid()
	{
		databaseWidgets.peopleGrid().clear();
		databaseWidgets.peopleGrid().loadData();
	}
	
	
	@BindView("simpleDatabase")
	public static interface DatabaseWidgets extends WidgetAccessor
	{
		Grid peopleGrid();
	}
	
	@BindView("simpleDatabase")
	public interface Views extends ViewAccessor
	{
		BindableView<Person> person();
	}
}
