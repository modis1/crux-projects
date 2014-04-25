package org.cruxframework.test.cruxtestsmartgwt.client;

import java.util.HashMap;
import java.util.Map;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.smartgwt.client.Canvas;
import org.cruxframework.crux.smartgwt.client.DateChooser;
import org.cruxframework.crux.smartgwt.client.DateRangeDialog;
import org.cruxframework.crux.smartgwt.client.Dialog;
import org.cruxframework.crux.smartgwt.client.EdgedCanvas;
import org.cruxframework.crux.smartgwt.client.HTMLFlow;
import org.cruxframework.crux.smartgwt.client.HTMLPane;
import org.cruxframework.crux.smartgwt.client.Img;
import org.cruxframework.crux.smartgwt.client.ImgSplitbar;
import org.cruxframework.crux.smartgwt.client.Label;
import org.cruxframework.crux.smartgwt.client.MultiFilePicker;
import org.cruxframework.crux.smartgwt.client.NavigationButton;
import org.cruxframework.crux.smartgwt.client.RangeSlider;
import org.cruxframework.crux.smartgwt.client.RichTextEditor;
import org.cruxframework.crux.smartgwt.client.Snapbar;
import org.cruxframework.crux.smartgwt.client.Splitbar;
import org.cruxframework.crux.smartgwt.client.StatefulCanvas;
import org.cruxframework.crux.smartgwt.client.StretchImg;
import org.cruxframework.crux.smartgwt.client.StretchImgButton;
import org.cruxframework.crux.smartgwt.client.ViewLoader;
import org.cruxframework.crux.smartgwt.client.Window;
import org.cruxframework.crux.smartgwt.client.button.Button;
import org.cruxframework.crux.smartgwt.client.button.IButton;
import org.cruxframework.crux.smartgwt.client.button.IconButton;
import org.cruxframework.crux.smartgwt.client.calendar.Calendar;
import org.cruxframework.crux.smartgwt.client.calendar.Timeline;
import org.cruxframework.crux.smartgwt.client.form.ColorPicker;
import org.cruxframework.crux.smartgwt.client.grid.ColumnTree;
import org.cruxframework.crux.smartgwt.client.grid.DateGrid;
import org.cruxframework.crux.smartgwt.client.grid.ListGrid;
import org.cruxframework.crux.smartgwt.client.layout.FlowLayout;
import org.cruxframework.crux.smartgwt.client.layout.HLayout;
import org.cruxframework.crux.smartgwt.client.layout.HStack;
import org.cruxframework.crux.smartgwt.client.layout.ImgSectionHeader;
import org.cruxframework.crux.smartgwt.client.layout.Layout;
import org.cruxframework.crux.smartgwt.client.layout.LayoutSpacer;
import org.cruxframework.crux.smartgwt.client.layout.NavigationBar;
import org.cruxframework.crux.smartgwt.client.layout.PortalLayout;
import org.cruxframework.crux.smartgwt.client.layout.Portlet;
import org.cruxframework.crux.smartgwt.client.layout.SectionHeader;
import org.cruxframework.crux.smartgwt.client.layout.SectionStack;
import org.cruxframework.crux.smartgwt.client.layout.VLayout;
import org.cruxframework.crux.smartgwt.client.layout.VStack;
import org.cruxframework.crux.smartgwt.client.rte.ListPropertiesDialog;
import org.cruxframework.crux.smartgwt.client.rte.ListPropertiesPane;
import org.cruxframework.crux.smartgwt.client.tableview.TableView;
import org.cruxframework.crux.smartgwt.client.tile.TileGrid;
import org.cruxframework.crux.smartgwt.client.tile.TileLayout;
import org.cruxframework.crux.smartgwt.client.toolbar.ToolStrip;
import org.cruxframework.crux.smartgwt.client.toolbar.Toolbar;
import org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.data.AnimalXmlDS;
import org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.data.PartData;
import org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.effects.dragdrop.PartsListGrid;

import com.google.gwt.user.client.Random;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Progressbar;
import com.smartgwt.client.widgets.Scrollbar;
import com.smartgwt.client.widgets.Slider;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.FilterClause;
import com.smartgwt.client.widgets.form.PropertySheet;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.menu.IMenuButton;
import com.smartgwt.client.widgets.menu.IconMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuBar;
import com.smartgwt.client.widgets.menu.MenuButton;
import com.smartgwt.client.widgets.menu.TreeMenuButton;
import com.smartgwt.client.widgets.tab.ImgTab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tile.TileRecord;
import com.smartgwt.client.widgets.toolbar.RibbonBar;
import com.smartgwt.client.widgets.toolbar.RibbonGroup;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.toolbar.ToolStripGroup;
import com.smartgwt.client.widgets.toolbar.ToolStripMenuButton;
import com.smartgwt.client.widgets.toolbar.ToolStripResizer;
import com.smartgwt.client.widgets.toolbar.ToolStripSeparator;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

@Controller("homeController")
public class HomeController 
{
	@Expose
	public void onLoad()
	{
		
		/*Drag Tiles*/
		TileGrid tileGrid = (TileGrid) Screen.get().get("tileGrid");  
        tileGrid.setWidth(500);  
        tileGrid.setHeight(400);  
        tileGrid.setTileWidth(150);  
        tileGrid.setTileHeight(150);  
        tileGrid.setCanAcceptDrop(true);  
        tileGrid.setCanDrag(true);  
        tileGrid.setData(new TileRecord[]{});  
  
        DetailViewerField pictureField = new DetailViewerField("picture");  
        pictureField.setType("image");  
        pictureField.setImageURLPrefix("animals/");  
        DetailViewerField commonNameField = new DetailViewerField("commonName");  
  
        tileGrid.setFields(pictureField, commonNameField);  
  
        ListGrid listGrid = (ListGrid) Screen.get().get("listGrid");
        listGrid.setWidth(300);  
        listGrid.setHeight(400);  
        listGrid.setDataSource(AnimalXmlDS.getInstance());  
        listGrid.setAutoFetchData(true);  
        listGrid.setCanDragRecordsOut(true);  
        listGrid.setCanAcceptDroppedRecords(true);  
        listGrid.setCanReorderRecords(true);  
  
        ListGridField commonNameField2 = new ListGridField("commonName");  
        ListGridField lifeSpanField = new ListGridField("lifeSpan");  
        lifeSpanField.setWidth(50);  
        ListGridField statusField = new ListGridField("status");  
        listGrid.setFields(commonNameField2, lifeSpanField, statusField);  
        listGrid.setCanEdit(true);
  
//        VLayout vLayout = new VLayout();  
//        vLayout.setMargin(10);  
//        vLayout.addMember(new HTMLFlow(DESCRIPTION));  
  
        HLayout hLayout = new HLayout();  
        hLayout.setBackgroundColor("gray");
        hLayout.addMember(listGrid);  
        hLayout.addMember(tileGrid);  
  
        //vLayout.addMember(hLayout);
		
		/*Fim Drag Tiles*/
		
		/*teste*/
	    HStack hStack = (HStack) Screen.get().get("hStack");  
	    //HStack hStack = new HStack(10);  
        hStack.setHeight(160);  
  
        final PartsListGrid myList1 = new PartsListGrid();  
        myList1.setEmptyMessage("No Records");  
        myList1.setCanDragRecordsOut(true);  
        myList1.setCanReorderFields(true);  
        myList1.setDragDataAction(DragDataAction.MOVE);  
        //RecordList data = new RecordList();  
        Record[] data = PartData.getRecords();  
        myList1.setData(data);  
        hStack.addMember(myList1);  
  
        VStack transferStack = new VStack();  
        transferStack.setWidth(20);  
        transferStack.setAlign(VerticalAlignment.CENTER);  
  
        final PartsListGrid myList2 = new PartsListGrid();  
        myList2.setEmptyMessage("No Records");  
        myList2.setCanAcceptDroppedRecords(true);  
        myList2.setCanReorderRecords(true);  
  
        TransferImgButton right = new TransferImgButton(TransferImgButton.RIGHT);  
        right.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
                myList2.transferSelectedData(myList1);  
            }  
        });  
  
        TransferImgButton rightAll = new TransferImgButton(TransferImgButton.RIGHT_ALL);  
        rightAll.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
                Record[] records = myList1.getRecords();  
                myList1.setData(new Record[]{});  
                for (Record record : records) {  
                    myList2.addData(record);  
                }  
            }  
        });  
  
        TransferImgButton left = new TransferImgButton(TransferImgButton.LEFT);  
        left.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
                myList1.transferSelectedData(myList2);  
            }  
        });  
  
        TransferImgButton leftAll = new TransferImgButton(TransferImgButton.LEFT_ALL);  
        leftAll.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
                Record[] records = myList2.getRecords();  
                myList2.setData(new Record[]{});  
                for (Record record : records) {  
                    myList1.addData(record);  
                }  
            }  
        });  
        transferStack.addMember(right);  
        transferStack.addMember(left);  
        transferStack.addMember(rightAll);  
        transferStack.addMember(leftAll);  
  
        hStack.addMember(transferStack);  
        hStack.addMember(myList2);  
  
        VStack modifyStack = new VStack();  
        modifyStack.setWidth(20);  
        modifyStack.setAlign(VerticalAlignment.CENTER);  
  
        TransferImgButton up = new TransferImgButton(TransferImgButton.UP);  
        up.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
                ListGridRecord selectedRecord = myList2.getSelectedRecord();  
                if(selectedRecord != null) {  
                    int idx = myList2.getRecordIndex(selectedRecord);  
                    if(idx > 0) {  
                        RecordList rs = myList2.getRecordList();  
                        rs.removeAt(idx);  
                        rs.addAt(selectedRecord, idx - 1);  
                    }  
                }  
            }  
        });  
  
        TransferImgButton upFirst = new TransferImgButton(TransferImgButton.UP_FIRST);  
        upFirst.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
                ListGridRecord selectedRecord = myList2.getSelectedRecord();  
                if(selectedRecord != null) {  
                    int idx = myList2.getRecordIndex(selectedRecord);  
                    if(idx > 0) {  
                        RecordList rs = myList2.getRecordList();  
                        rs.removeAt(idx);  
                        rs.addAt(selectedRecord, 0);  
                    }  
                }  
            }  
        });  
  
        TransferImgButton down = new TransferImgButton(TransferImgButton.DOWN);  
        down.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
                ListGridRecord selectedRecord = myList2.getSelectedRecord();  
                if(selectedRecord != null) {  
                    RecordList rs = myList2.getRecordList();  
                    int numRecords = rs.getLength();  
                    int idx = myList2.getRecordIndex(selectedRecord);  
                    if(idx < numRecords - 1) {  
                        rs.removeAt(idx);  
                        rs.addAt(selectedRecord, idx + 1);  
                    }  
                }  
            }  
        });  
  
        TransferImgButton downLast = new TransferImgButton(TransferImgButton.DOWN_LAST);  
        downLast.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
                ListGridRecord selectedRecord = myList2.getSelectedRecord();  
                if(selectedRecord != null) {  
                    RecordList rs = myList2.getRecordList();  
                    int numRecords = rs.getLength();  
                    int idx = myList2.getRecordIndex(selectedRecord);  
                    if(idx < numRecords - 1) {  
                        rs.removeAt(idx);  
                        rs.addAt(selectedRecord, rs.getLength());  
                    }  
                }  
            }  
        });  
  
        TransferImgButton delete = new TransferImgButton(TransferImgButton.DELETE);  
        delete.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
                ListGridRecord selectedRecord = myList2.getSelectedRecord();  
                if(selectedRecord != null) {  
                    myList2.removeData(selectedRecord);  
                }  
            }  
        });  
  
        modifyStack.addMember(upFirst);  
        modifyStack.addMember(up);  
        modifyStack.addMember(down);  
        modifyStack.addMember(downLast);  
        modifyStack.addMember(delete);  
  
        hStack.addMember(modifyStack);
		
		/*Fim - teste*/
		
		
		/*Basics - Create*/
		
		VLayout layout = (VLayout) Screen.get().get("layout"); 
		layout.setMembersMargin(10);  
		  
        final Canvas cubeBin = new Canvas();
        cubeBin.setTitle("cubeBin");
        cubeBin.setTop(40);  
        cubeBin.setWidth(400);  
        cubeBin.setHeight(300);  
        cubeBin.setShowEdges(true);  
  
        IButton button = new IButton();  
        button.setTitle("Create");  
        button.setIcon("https://code.google.com/p/crux-framework/logo?cct=1397219537");  
        button.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
                final Img img = new Img();  
                img.setLeft(Random.nextInt(340));  
                img.setTop(Random.nextInt(240));  
                img.setWidth(48);  
                img.setHeight(48);  
                //img.setParentElement(cubeBin);  
                img.setSrc("https://code.google.com/p/crux-framework/logo?cct=1397219537");  
                img.addClickHandler(new ClickHandler() {  
                    public void onClick(ClickEvent event) {  
                        img.destroy();  
                    }  
                });  
                img.draw();  
            }  
        });  
        layout.addMember(button);  
        layout.addMember(cubeBin); 
	  
	        //layout.draw(); 
		
		
		/*Fim Basics - Create*/
		
		
		
			/*Combo*/
		    final DynamicForm form = (DynamicForm) Screen.get().get("form");
	        form.setWidth(500);  
	        form.setNumCols(4); 
	        form.setBackgroundColor("green");
	  
	        final Map<String, String[]> departments = new HashMap<String, String[]>();  
	        departments.put("Marketing", new String[]{"Advertising", "Community Relations"});  
	        departments.put("Sales", new String[]{"Channel Sales", "Direct Sales"});  
	        departments.put("Manufacturing", new String[]{"Design", "Development", "QA"});  
	        departments.put("Services", new String[]{"Support", "Consulting"});  
	  
	        SelectItem divisionItem = new SelectItem();  
	        divisionItem.setName("division");  
	        divisionItem.setTitle("Division");  
	        divisionItem.setValueMap("Marketing", "Sales", "Manufacturing", "Services");  
	        divisionItem.addChangeHandler(new ChangeHandler() {  
	            public void onChange(ChangeEvent event) {  
	                String selectedItem = (String) event.getValue();  
	                form.getField("department").setValueMap(departments.get(selectedItem));  
	            }  
	        });  
	  
	        SelectItem departmentItem = new SelectItem();  
	        departmentItem.setName("department");  
	        departmentItem.setTitle("Department");  
	        departmentItem.setAddUnknownValues(false);  
	  
	        form.setItems(divisionItem, departmentItem);
		
		/*Fim Combo*/
		
		
		
		
		/*HTMLFlow painel2 = (HTMLFlow) Screen.get().get("painel2");
		painel2.setBackgroundColor("pink");
		
		Button button3 = new Button();
		button3.setBackgroundColor("green");
		button3.setTitle("button3");
		button3.setWidth(50);
		button3.setHeight(50);
		
		Button button4 = new Button();
		button4.setBackgroundColor("yellow");
		button4.setTitle("button4");
		button4.setWidth(50);
		button4.setHeight(50);
		button4.setMargin(30);
		
		painel2.addChild(button3);
		painel2.addChild(button4);
		
		
	        
		HTMLFlow painel = (HTMLFlow) Screen.get().get("painel");
		painel.setBackgroundColor("red");
		
		Button button1 = (Button) Screen.get().get("button1");
		button1.setBackgroundColor("green");
		Button button2 = (Button) Screen.get().get("button2");
		button2.setBackgroundColor("yellow");
		
		painel.addChild(button1);
		painel.addChild(button2);*/
		
		
		
		// TESTES ATÉ 11 DE ABRIL
		
		HTMLFlow testeHTMLFlow = (HTMLFlow) Screen.get().get("testeHTMLFlow");
		testeHTMLFlow.setBackgroundColor("yellow");
		testeHTMLFlow.setCanDragResize(true);
		
		Button testeButton = (Button) Screen.get().get("testeButton");
		testeButton.setTitle("Button Triggo");
		testeButton.setBackgroundColor("green");
		testeButton.setCanDragResize(true);
		//OK
		
		IButton testeIButton = (IButton) Screen.get().get("testeIButton");
		testeIButton.setHeight(100);
		testeIButton.setWidth(100);
		testeIButton.setBackgroundImage("https://code.google.com/p/crux-framework/logo?cct=1397219537");
		testeIButton.setLayoutAlign(Alignment.RIGHT);
		testeIButton.setCanDragResize(true);
		//OK
		
		ImgButton testeImgButton = (ImgButton) Screen.get().get("testeImgButton");
		testeImgButton.setTitle("imgButton Triggo"); //Não ta indo
		testeImgButton.setBackgroundColor("purple");
		testeImgButton.setAltText("imgButton Triggo");
		testeImgButton.setCanDragResize(true);
		//OK
		
		Dialog testeDialog = (Dialog) Screen.get().get("testeDialog");
		testeDialog.setBackgroundColor("yellow");
		testeDialog.setCanDragResize(true);
		
		
		Slider testeSlider = (Slider) Screen.get().get("testeSlider");
		testeSlider.setBackgroundColor("blue");
		testeSlider.setCanDragResize(true);
		//OK
		
		Label testeLabel = (Label) Screen.get().get("testeLabel");
		testeLabel.setBackgroundColor("pink");
		testeLabel.setCanDragResize(true);
		//OK
		
		ImgTab testeImgTab = (ImgTab) Screen.get().get("testeImgTab");
		testeImgTab.setIcon("https://code.google.com/p/crux-framework/logo?cct=1397219537");
		testeImgTab.setCanDragResize(true);
		//OK
	
		Progressbar testeProgressbar = (Progressbar) Screen.get().get("testeProgressbar");
		testeProgressbar.setTitle("Progressbar teste");
		testeProgressbar.setBackgroundColor("red");
		testeProgressbar.setHeight(50);
		testeProgressbar.setWidth(50);
		testeProgressbar.setCanDragResize(true);
		testeProgressbar.moveBy(80, 3);
		testeProgressbar.setCanDragResize(true);
		//OK
		
		TabSet testeTabSet = (TabSet) Screen.get().get("testeTabSet");
		testeTabSet.setTitle("TabSet teste");
		testeTabSet.setBackgroundColor("blue");
		testeTabSet.setScrollbarSize(40);
		testeTabSet.setCanDragResize(true);
		//OK
		
		IconButton testeIconButton = (IconButton) Screen.get().get("testeIconButton");
		testeIconButton.setBackgroundColor("green");
		testeIconButton.setCanDragResize(true);
		//OK
		
		//batchUploader APRENDER A INSTANCIAR
		
		DateRangeDialog testeDateRangeDialog = (DateRangeDialog) Screen.get().get("testeDateRangeDialog");
		testeDateRangeDialog.setBackgroundColor("purple");
		testeDateRangeDialog.setCanDragResize(true);
		//OK
		
//		FieldPickerWindow testeFieldPickerWindow = (FieldPickerWindow) Screen.get().get("testeFieldPickerWindow");
//		testeFieldPickerWindow.setTitle("teste FielPickerWindow");
//		testeFieldPickerWindow.setBackgroundColor("yellow");
		//Deu um problema create()([]):Cannot read property canAddFormulaFields
		
		HTMLPane testeHTMLPane = (HTMLPane) Screen.get().get("testeHTMLPane");
		testeHTMLPane.setCanDragResize(true);
		testeIconButton.setBackgroundColor("yellow");
		//OK
		
		Img testeImg = (Img) Screen.get().get("testeImg");
		testeImg.setCanDragResize(true);
		//OK
		
		ImgSplitbar testeImgSplitbar = (ImgSplitbar) Screen.get().get("testeImgSplitbar");
		testeImgSplitbar.setCanDragResize(true);
		testeImgSplitbar.setBackgroundColor("gray");
		//OK
		
		StretchImgButton testeStretchImgButton = (StretchImgButton) Screen.get().get("testeStretchImgButton");
		testeStretchImgButton.setBackgroundColor("orange");
		testeStretchImgButton.setCanDragResize(true);
		//OK
		
		MultiFilePicker testeMultiFilePicker = (MultiFilePicker) Screen.get().get("testeMultiFilePicker");
		testeMultiFilePicker.setBackgroundColor("red");
		testeMultiFilePicker.setCanDragResize(true);
		//OK
		
		DateChooser testeDateChooser = (DateChooser) Screen.get().get("testeDateChooser");
		testeDateChooser.setBackgroundColor("blue");
		testeDateChooser.setCanDragResize(true);
		//OK
		
		//multiGroupDialog  APRENDER A INSTANCIAR
		
		
		NavigationButton testeNavigationButton = (NavigationButton) Screen.get().get("testeNavigationButton");
		testeNavigationButton.setTitle("NavigationButton");
		testeNavigationButton.setBackgroundImage("https://code.google.com/p/crux-framework/logo?cct=1397219537");
		testeNavigationButton.setIcon("https://code.google.com/p/crux-framework/logo?cct=1397219537");
		//OK
		
		EdgedCanvas testeEdgedCanvas = (EdgedCanvas) Screen.get().get("testeEdgedCanvas");
		testeEdgedCanvas.setBackgroundImage("https://code.google.com/p/crux-framework/logo?cct=1397219537");
		testeEdgedCanvas.setCanDragResize(true);
		//OK
		
		RangeSlider testeRangeSlider = (RangeSlider) Screen.get().get("testeRangeSlider");
		testeRangeSlider.setBackgroundColor("orange");
		testeRangeSlider.setCanDragResize(true);
		//OK

		RichTextEditor richTextEditor = (RichTextEditor) Screen.get().get("testeRichTextEditor");
		richTextEditor.setBackgroundImage("https://code.google.com/p/crux-framework/logo?cct=1397219537");
		richTextEditor.setCanDragResize(true);
		//OK
		
		Scrollbar testeScrollbar = (Scrollbar) Screen.get().get("testeScrollbar");
		testeScrollbar.setIcon("https://code.google.com/p/crux-framework/logo?cct=1397219537");
		testeScrollbar.setBackgroundImage("https://code.google.com/p/crux-framework/logo?cct=1397219537");
		//OK
		
		StatefulCanvas testeStatefulCanvas = (StatefulCanvas) Screen.get().get("testeStatefulCanvas");
		testeStatefulCanvas.setBackgroundColor("yellow");
		testeStatefulCanvas.setCanDragResize(true);
		//OK
		
		ViewLoader testeViewLoader = (ViewLoader) Screen.get().get("testeViewLoader");
		testeViewLoader.setBackgroundColor("pink");
		testeViewLoader.setCanDragResize(true);
		//OK
		
		ColorPicker testeColorPicker = (ColorPicker) Screen.get().get("testeColorPicker");
		testeColorPicker.setBackgroundColor("green");
		testeColorPicker.setCanDragResize(true);
		//OK
		
		DynamicForm testeDynamicForm = (DynamicForm) Screen.get().get("testeDynamicForm");
		testeDynamicForm.setBackgroundImage("https://code.google.com/p/crux-framework/logo?cct=1397219537");
		testeDynamicForm.setCanDragResize(true);
		//OK
		
		//FIM TESTES ATÉ 11 DE ABRIL //////////////////////////////////////////////
		
		FilterClause testeFilterClause = (FilterClause) Screen.get().get("testeFilterClause");
		testeFilterClause.setBackgroundColor("green");
		testeFilterClause.moveBy(100, 100);
		testeFilterClause.setCanDragResize(true);
		
		PropertySheet testePropertySheet = (PropertySheet) Screen.get().get("testePropertySheet");
		testePropertySheet.setBackgroundImage("https://code.google.com/p/crux-framework/logo?cct=1397219537");
		testePropertySheet.setCanDragResize(true);
		
		SearchForm testeSearchForm=(SearchForm)Screen.get().get("testeSearchForm");
		testeSearchForm.setBackgroundColor("blue");
		testeSearchForm.animateFade(50);
		testeSearchForm.setCanDragResize(true);
		
		IconMenuButton testeIconMenuButton =(IconMenuButton) Screen.get().get("testeIconMenuButton");
		testeIconMenuButton.setBackgroundColor("orange");
		testeIconMenuButton.setCanDragResize(true);

		IMenuButton testeIMenuButton = (IMenuButton) Screen.get().get("testeIMenuButton");
		testeIMenuButton.setBackgroundImage("http://img268.imageshack.us/img268/7388/fundov13.jpg");
		testeIMenuButton.setCanDragResize(true);
		
		Menu testeMenu = (Menu) Screen.get().get("testeMenu");
		testeMenu.setBackgroundImage("http://img268.imageshack.us/img268/7388/fundov13.jpg");
		testeMenu.setCanDragResize(true);
		
		MenuBar testeMenuBar = (MenuBar) Screen.get().get("testeMenuBar");
		testeMenuBar.setBackgroundColor("red");
		testeMenuBar.setCanDragResize(true);
		
		MenuButton testeMenuButton = (MenuButton) Screen.get().get("testeMenuButton");
		testeMenuButton.setBackgroundColor("yellow");
		testeMenuButton.setCanDragResize(true);
		
		TreeMenuButton testeTreeMenuButton = (TreeMenuButton) Screen.get().get("testeTreeMenuButton");
		testeTreeMenuButton.setBackgroundColor("pink");
		testeTreeMenuButton.setCanDragResize(true);
		
//		DetailViewer testeDetailViewer = (DetailViewer) Screen.get().get("testeDetailViewer");
//		testeDetailViewer.setBackgroundColor("purple");
//		testeDetailViewer.setCanDragResize(true);
		
		TreeGrid testeTreeGrid = (TreeGrid) Screen.get().get("testeTreeGrid");
		testeTreeGrid.setBackgroundColor("purple");
		testeTreeGrid.setCanDragResize(true);
		
		RibbonBar testeRibbonBar = (RibbonBar) Screen.get().get("testeRibbonBar");
		testeRibbonBar.setBackgroundColor("GRAY");
		testeRibbonBar.setCanDragResize(true);
		
		RibbonGroup testeRibbonGroup = (RibbonGroup) Screen.get().get("testeRibbonGroup");
		testeRibbonGroup.setBackgroundColor("brown");
		testeRibbonGroup.setCanDragResize(true);
		
		Toolbar testeToolbar = (Toolbar) Screen.get().get("testeToolbar");
		testeToolbar.setBackgroundColor("orange");
		testeToolbar.setCanDragResize(true);

		
		ToolStrip testeToolStrip = (ToolStrip) Screen.get().get("testeToolStrip");
		testeToolStrip.setBackgroundColor("green");
		testeToolStrip.setCanDragResize(true);
		
		ToolStripButton testeToolStripButton = (ToolStripButton) Screen.get().get("testeToolStripButton");
		testeToolStripButton.setBackgroundColor("orange");
		testeToolStripButton.setCanDragResize(true);
		
		ToolStripGroup testeToolStripGroup = (ToolStripGroup) Screen.get().get("testeToolStripGroup");
		testeToolStripGroup.setBackgroundColor("red");
		testeToolStripGroup.setCanDragResize(true);
		
		ToolStripMenuButton testeToolStripMenuButton = (ToolStripMenuButton) Screen.get().get("testeToolStripMenuButton");
		testeToolStripMenuButton.setBackgroundColor("blue");
		testeToolStripMenuButton.setCanDragResize(true);
		
		ToolStripResizer testeToolStripResizer = (ToolStripResizer) Screen.get().get("testeToolStripResizer");
		testeToolStripResizer.setBackgroundColor("gray");
		
		ToolStripSeparator testeToolStripSeparator = (ToolStripSeparator) Screen.get().get("testeToolStripSeparator");
		testeToolStripSeparator.setBackgroundColor("pink");
		testeToolStripSeparator.setCanDragResize(true);
		
		
//		16/04
		
		TileGrid testeTileGrid = (TileGrid) Screen.get().get("testeTileGrid");
		testeTileGrid.setBackgroundColor("green");
		testeTileGrid.setCanDragResize(true);
		
		TileLayout testeTileLayout = (TileLayout) Screen.get().get("testeTileLayout");
		testeTileLayout.setBackgroundColor("purple");
		testeTileLayout.setCanDragResize(true);
		
		TableView testeTableView = (TableView) Screen.get().get("testeTableView");
		testeTableView.setBackgroundColor("pink");
		testeTableView.setCanDragResize(true);
		
		ListPropertiesDialog testeListPropertiesDialog = (ListPropertiesDialog) Screen.get().get("testeListPropertiesDialog");
		testeListPropertiesDialog.setBackgroundColor("yellow");
		testeListPropertiesDialog.setCanDragResize(true);
		
		ListPropertiesPane testeListPropertiesPane = (ListPropertiesPane) Screen.get().get("testeListPropertiesPane");
		testeListPropertiesPane.setBackgroundColor("gray");
		testeListPropertiesPane.setCanDragResize(true);
		
		Button buttonTeste = new Button();
		buttonTeste.setTitle("Botão");
		buttonTeste.setIcon("http://www.wpclipart.com/signs_symbol/button/button_direction/direction_arrow_green_down.png");
		buttonTeste.setBackgroundColor("blue");
		
		FlowLayout testeFlowLayout = (FlowLayout) Screen.get().get("testeFlowLayout");
		testeFlowLayout.setBackgroundColor("pink");
		testeFlowLayout.setCanDragResize(true);

		
		HLayout testeHLayout = (HLayout) Screen.get().get("testeHLayout");
		testeHLayout.setBackgroundColor("green");
		testeHLayout.setCanDragResize(true);
		
		HStack testeHStack = (HStack) Screen.get().get("testeHStack");
		//testeHStack.setBackgroundImage("http://img268.imageshack.us/img268/7388/fundov13.jpg");
		testeHStack.setBackgroundColor("blue");
		testeHStack.setCanDragResize(true);
		
		
		ImgSectionHeader testeImgSectionHeader = (ImgSectionHeader) Screen.get().get("testeImgSectionHeader");
		testeImgSectionHeader.setCanDragResize(true);
		testeImgSectionHeader.setBackgroundColor("blue");
		
		
		Layout testeLayout = (Layout) Screen.get().get("testeLayout");
		testeLayout.setBackgroundColor("orange");
		testeLayout.setCanDragResize(true);
		
		
		LayoutSpacer testeLayoutSpacer = (LayoutSpacer) Screen.get().get("testeLayoutSpacer");
		testeLayoutSpacer.setBackgroundColor("purple");
		testeLayoutSpacer.setCanDragResize(true);
		
		
		NavigationBar testeNavigationBar = (NavigationBar) Screen.get().get("testeNavigationBar");
		testeNavigationBar.setBackgroundColor("pink");
		testeNavigationBar.setCanDragResize(true);
		
		
		PortalLayout testePortalLayout = (PortalLayout) Screen.get().get("testePortalLayout");
		testePortalLayout.setBackgroundColor("blue");
		testePortalLayout.setCanDragResize(true);
		
		
		Portlet testePortlet = (Portlet) Screen.get().get("testePortlet");
		testePortlet.setBackgroundColor("green");
		testePortlet.setCanDragResize(true);
		
		SectionHeader testeSectionHeader = (SectionHeader) Screen.get().get("testeSectionHeader");
		testeSectionHeader.setBackgroundColor("purple");
		testeSectionHeader.setCanDragResize(true);
		
		SectionStack testeSectionStack = (SectionStack) Screen.get().get("testeSectionStack");
		testeSectionStack.setBackgroundColor("orange");
		testeSectionStack.setCanDragResize(true);
		
//		SplitPane testeSplitPane = (SplitPane) Screen.get().get("testeSplitPane");
//		testeSplitPane.setBackgroundColor("pink");
		//TA FUNCIONANDO, MAS APARECEM ALGUMAS INFORMAÇÕES NA TELA QUE TRAVAM O PROCESSO.
		
		VLayout testeVLayout = (VLayout) Screen.get().get("testeVLayout");
		testeVLayout.setBackgroundColor("red");
		testeVLayout.setCanDragResize(true);
		testeVLayout.addChild(buttonTeste);
		
		VStack testeVStack = (VStack) Screen.get().get("testeVStack");
		testeVStack.setBackgroundColor("yellow");
		testeVStack.setCanDragResize(true);
		testeVStack.addChild(testeVLayout);
		
		//Testes 17/04/14
		
		
//		AdvancedHiliteEditor testeAdvancedHiliteEditor = (AdvancedHiliteEditor) Screen.get().get("testeAdvancedHiliteEditor");
//		testeAdvancedHiliteEditor.setBackgroundColor("purple");
//		testeAdvancedHiliteEditor.setCanDragResize(true);
		//TRABALHAR NO INSTANCIAMENTO
		
		ColumnTree testeColumnTree = (ColumnTree) Screen.get().get("testeColumnTree");
		testeColumnTree.setBackgroundColor("gray");
		testeColumnTree.setCanDragResize(true);
		
		DateGrid testeDateGrid = (DateGrid) Screen.get().get("testeDateGrid");
		testeDateGrid.setBackgroundColor("blue");
		testeDateGrid.setCanDragResize(true);
		
//		GridRenderer testeGridRenderer = (GridRenderer) Screen.get().get("testeGridRenderer");
//		testeGridRenderer.setBackgroundColor("yellow");
//		testeGridRenderer.setCanDragResize(true);
		//PASSAR PARA CA

		
		
//		HiliteEditor testeHiliteEditor = (HiliteEditor) Screen.get().get("testeHiliteEditor");
//		testeHiliteEditor.setBackgroundColor("orange");
//		testeHiliteEditor.setCanDragResize(true);
		
//		HiliteRule testeHiliteRule = (HiliteRule) Screen.get().get("testeHiliteRule");
//		testeHiliteRule.setBackgroundColor("gray");
//		testeHiliteRule.setCanDragResize(true);
		
		ListGrid testeListGrid = (ListGrid) Screen.get().get("testeListGrid");
		testeListGrid.setBackgroundColor("purple");
		testeListGrid.setCanDragResize(true);
		
//		RecordEditor testeRecordEditor = (RecordEditor) Screen.get().get("testeRecordEditor");
//		testeRecordEditor.setBackgroundColor("blue");
//		testeRecordEditor.setCanDragResize(true);
		//NÃO DEU:BaseWidget::draw()([]):Cannot read property 'getInnerContentWidth' of undefined
		
		
//		FacetChart testeFacetChart = (FacetChart) Screen.get().get("testeFacetChart");
//		testeFacetChart.setBackgroundColor("red");
//		testeFacetChart.setCanDragResize(true);
		

		Calendar testeCalendar = (Calendar) Screen.get().get("testeCalendar");
		testeCalendar.setBackgroundColor("yellow");
		testeCalendar.setCanDragResize(true);
		
//		EventWindow testeEventWindow = (EventWindow) Screen.get().get("testeEventWindow");
//		testeEventWindow.setBackgroundColor("orange");
//		testeEventWindow.setCanDragResize(true);
		
		Timeline testeTimeline = (Timeline) Screen.get().get("testeTimeline");
		testeTimeline.setBackgroundColor("red");
		testeTimeline.setCanDragResize(true);
		
		//TESTES 23-04
		
		Canvas testeCanvas = (Canvas) Screen.get().get("testeCanvas");
		testeCanvas.setBackgroundColor("yellow");
		testeCanvas.setCanDragResize(true);
		
//		PrintCanvas testePrintCanvas = (PrintCanvas) Screen.get().get("testePrintCanvas");
//		testePrintCanvas.setBackgroundColor("blue");
//		testePrintCanvas.setCanDragResize(true);
		
//		PrintWindow testePrintWindow = (PrintWindow) Screen.get().get("testePrintWindow");
//		testePrintWindow.setBackgroundColor("green");
//		testePrintWindow.setCanDragResize(true);
		
		Snapbar testeSnapbar = (Snapbar) Screen.get().get("testeSnapbar");
		testeSnapbar.setBackgroundColor("red");
		testeSnapbar.setCanDragResize(true);
		
		Splitbar testeSplitbar = (Splitbar) Screen.get().get("testeSplitbar");
		testeSplitbar.setBackgroundColor("orange");
		testeSplitbar.setCanDragResize(true);
		
		StretchImg testeStretchImg = (StretchImg) Screen.get().get("testeStretchImg");
		testeStretchImg.setBackgroundColor("gray");
		testeStretchImg.setCanDragResize(true);
		
		Window testeWindow = (Window) Screen.get().get("testeWindow");
		testeWindow.setBackgroundColor("purple");
		testeWindow.setCanDragResize(true);
		
	}

}
