package org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase;

import com.smartgwt.client.widgets.Canvas;

public interface PanelFactory {

    Canvas create();

    String getID();

    String getDescription();
}
