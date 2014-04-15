package org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.effects.dragdrop;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.PanelFactory;
import org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.ShowcasePanel;
import org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.data.PartData;


public class DragListSelectSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag and drop to copy items from the first list to the second list. You can drag over the top or bottom " +
            "edge of a scrolling list to scroll in that direction before dropping.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DragListSelectSample panel = new DragListSelectSample();
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
        Canvas canvas = new Canvas();

        final PartsListGrid mirrorSelectionList = new PartsListGrid();
        mirrorSelectionList.setHeight(160);
        mirrorSelectionList.setEmptyMessage("<br><br>Nothing selected");
        mirrorSelectionList.setLeft(200);

        final PartsListGrid myList1 = new PartsListGrid();
        myList1.setHeight(160);
        myList1.setCanDragSelect(true);
        myList1.setData(PartData.getRecords());
        myList1.addSelectionChangedHandler(new SelectionChangedHandler() {
            public void onSelectionChanged(SelectionEvent event) {
                mirrorSelectionList.setData(myList1.getSelection());
            }
        });

        canvas.addChild(myList1);
        canvas.addChild(mirrorSelectionList);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}