package org.cruxframework.test.cruxtestsmartgwt.client;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.smartgwt.client.EdgedCanvas;
import org.cruxframework.crux.smartgwt.client.NavigationButton;
import org.cruxframework.crux.smartgwt.client.RangeSlider;
import org.cruxframework.crux.smartgwt.client.button.Button;
import org.cruxframework.crux.smartgwt.client.button.IButton;
import org.cruxframework.crux.smartgwt.client.toolbar.ToolStrip;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.smartgwt.client.docs.Toolbar;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.FieldPickerWindow;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.ImgSplitbar;
import com.smartgwt.client.widgets.Progressbar;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.Scrollbar;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.FilterClause;
import com.smartgwt.client.widgets.form.PropertySheet;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.menu.IMenuButton;
import com.smartgwt.client.widgets.menu.IconMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuBar;
import com.smartgwt.client.widgets.menu.MenuButton;
import com.smartgwt.client.widgets.menu.TreeMenuButton;
import com.smartgwt.client.widgets.tab.ImgTab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.toolbar.RibbonBar;
import com.smartgwt.client.widgets.toolbar.RibbonGroup;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.toolbar.ToolStripGroup;
import com.smartgwt.client.widgets.toolbar.ToolStripMenuButton;
import com.smartgwt.client.widgets.toolbar.ToolStripResizer;
import com.smartgwt.client.widgets.toolbar.ToolStripSeparator;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.viewer.DetailViewer;

@Controller("homeController")
public class HomeController 
{
	@Expose
	public void onLoad()
	{

		/* TESTES ATÉ 11 DE ABRIL
		
//		HTMLFlow panel = (HTMLFlow) Screen.get().get("painel");
//		panel.add(button);
		//vou tentar mudar para o painel do smartCrux
		
		Button button = (Button) Screen.get().get("btnSmart");
		button.setTitle("Button Jesus");
		button.setBackgroundColor("green");
		//OK
		
		IButton iButton = (IButton) Screen.get().get("btnIButton");
		iButton.setBorder("10px");
		iButton.setTitle("IButon Maria");
		iButton.setHeight(100);
		iButton.setWidth(100);
		iButton.setBackgroundImage("http://www.kboing.com.br/fotos/imagens/4e1d9bf0c990b-tb.jpg");
		iButton.setLayoutAlign(Alignment.RIGHT);
		//OK
		
		ImgButton imgButton = (ImgButton) Screen.get().get("btnImgButton");
		imgButton.setTitle("imgButton Jose"); //Não ta indo
		imgButton.setBackgroundColor("purple");
		imgButton.setAltText("imgButton José");
		//OK
		
		ImgTab imgtab = (ImgTab) Screen.get().get("testeImgTab");
		imgtab.setIcon("http://www.kboing.com.br/fotos/imagens/4e1d9bf0c990b-tb.jpg");
		//OK
	
		Progressbar progressbar = (Progressbar) Screen.get().get("testeProgressbar");
		progressbar.setTitle("Progressbar teste");
		progressbar.setBackgroundColor("red");
		progressbar.setHeight(50);
		progressbar.setWidth(50);
		progressbar.setCanDragResize(true);
		progressbar.moveBy(80, 3);
		//OK
		
		TabSet tabSet = (TabSet) Screen.get().get("testeTabSet");
		tabSet.setTitle("TabSet teste");
		tabSet.setBackgroundColor("blue");
		tabSet.setScrollbarSize(40);
		//OK
		
//		FieldPickerWindow fieldPickerWindow = (FieldPickerWindow) Screen.get().get("testeFieldPickerWindow");
//		fieldPickerWindow.setTitle("teste FielPickerWindow");
//		fieldPickerWindow.setBackgroundColor("yellow");
		//Deu um problema create()([]):Cannot read property canAddFormulaFields
		
//		HTMLPane hTMLPane = (HTMLPane) Screen.get().get("testeHTMLPane");
//		hTMLPane.scrollToBottom();
		//OK
		
//		ImgSplitbar testeImgSplitbar = (ImgSplitbar) Screen.get().get("testeImgSplitbar");
//		testeImgSplitbar.setSrc("http://www.kboing.com.br/fotos/imagens/4e1d9bf0c990b-tb.jpg");
		//PARECE QUE NÃO FUNFOU
		
//		RichTextEditor richTextEditor = (RichTextEditor) Screen.get().get("testeRichTextEditor");
//		richTextEditor.setBackgroundColor("green");
//		richTextEditor.setShadowOffset(33);
//		//Não modificou nada
		
		NavigationButton testeNavigationButton = (NavigationButton) Screen.get().get("testeNavigationButton");
		testeNavigationButton.setTitle("NavigationButton");
		testeNavigationButton.setBackgroundImage("http://www.kboing.com.br/fotos/imagens/4e1d9bf0c990b-tb.jpg");
		testeNavigationButton.setIcon("http://www.kboing.com.br/fotos/imagens/4e1d9bf0c990b-tb.jpg");
		//OK
		
		EdgedCanvas testeEdgedCanvas = (EdgedCanvas) Screen.get().get("testeEdgedCanvas");
		testeEdgedCanvas.setBackgroundImage("http://www.kboing.com.br/fotos/imagens/4e1d9bf0c990b-tb.jpg");
		//OK
		
		RangeSlider testeRangeSlider = (RangeSlider) Screen.get().get("testeRangeSlider");
		testeRangeSlider.setBackgroundColor("orange");
		testeRangeSlider.setTitle("Fy rangeSlider");
		//Window.alert(testeNavigationButton.getTitle());
		
		Scrollbar testeScrollbar = (Scrollbar) Screen.get().get("testeScrollbar");
		testeScrollbar.setIcon("http://www.kboing.com.br/fotos/imagens/4e1d9bf0c990b-tb.jpg");
		testeScrollbar.setBackgroundImage("http://www.kboing.com.br/fotos/imagens/4e1d9bf0c990b-tb.jpg");
		
		DynamicForm testeDynamicForm = (DynamicForm) Screen.get().get("testeDynamicForm");
		testeDynamicForm.setImage("fy", "http://www.kboing.com.br/fotos/imagens/4e1d9bf0c990b-tb.jpg");
		
		FIM TESTES ATÉ 11 DE ABRIL */
		
		FilterClause testeFilterClause = (FilterClause) Screen.get().get("testeFilterClause");
		testeFilterClause.setBackgroundColor("green");
		testeFilterClause.moveBy(100, 100);
		testeFilterClause.setCanDragResize(true);
		
		PropertySheet testePropertySheet = (PropertySheet) Screen.get().get("testePropertySheet");
		testePropertySheet.setBackgroundImage("http://www.kboing.com.br/fotos/imagens/4e1d9bf0c990b-tb.jpg");
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
		
//		Toolbar testeToolbar = (Toolbar) Screen.get().get("testeToolbar");
//		testeToolbar.

		
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
	}

}
