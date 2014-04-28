package org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.grid.databinding;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.PanelFactory;
import org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.ShowcasePanel;

public class GridDataBindingXMLDataSourceSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This ListGrid binds to a DataSource that loads" +
                                              " data from a remote XML data provider. This" +
                                              " approach of loading simple XML data over HTTP" +
                                              " can be used with PHP and other server" +
                                              " technologies.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDataBindingXMLDataSourceSample panel = new GridDataBindingXMLDataSourceSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    public Canvas getViewPanel() {
        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(400);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setDataSource(CountryDS.getInstance());
        countryGrid.setAutoFetchData(true);

        return countryGrid;
    }

    private static class CountryDS extends DataSource {
        // The DataSource would normally be defined external to any classes that use it.

        private static CountryDS instance = null;
        
        public static CountryDS getInstance() {
            if (instance == null) {
              instance = new CountryDS("countryDS_XML");
            }
            return instance;
        }

        public CountryDS(String id) {
            setID(id);
            setDataFormat(DSDataFormat.XML);
            setRecordXPath("/List/country");
            DataSourceField countryCodeField = new DataSourceField("countryCode", FieldType.TEXT,
                                                                   "Code");
            DataSourceField countryNameField = new DataSourceField("countryName", FieldType.TEXT,
                                                                   "Country");
            DataSourceField capitalField = new DataSourceField("capital", FieldType.TEXT,
                                                               "Capital");
            setFields(countryCodeField, countryNameField, capitalField);
            setDataURL("ds/test_data/country.data.xml");
        }

    }

    public String getIntro() {
        return DESCRIPTION;
    }


}