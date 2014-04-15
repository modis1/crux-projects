package org.cruxframework.test.cruxtestwidgets.client.database.offline;

import org.cruxframework.crux.core.client.db.Database;
import org.cruxframework.crux.core.client.db.annotation.DatabaseDef;
import org.cruxframework.crux.core.client.db.annotation.DatabaseDef.ObjectStoreDef;
import org.cruxframework.test.cruxtestwidgets.client.database.objectstore.PersonOS;
import org.cruxframework.test.cruxtestwidgets.client.database.objectstore.PlaceOS;

@DatabaseDef(name = "CruxCompanyDatabase", version = 1, defaultErrorHandler = DatabaseErrorHandlerImpl.class, 
objectStores = { @ObjectStoreDef(targetClass = PersonOS.class), @ObjectStoreDef(targetClass = PlaceOS.class) })
public interface MyDatabase extends Database {
}
