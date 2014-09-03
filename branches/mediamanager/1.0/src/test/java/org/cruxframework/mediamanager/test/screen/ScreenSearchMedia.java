/*
 * Copyright 2011 cruxframework.org.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.cruxframework.mediamanager.test.screen;

import org.cruxframework.mediamanager.test.procedure.SetUp;

import br.ufmg.dcc.saotome.beholder.ui.form.Button;
import br.ufmg.dcc.saotome.beholder.ui.form.Select;
import br.ufmg.dcc.saotome.beholder.ui.form.TextField;
import br.ufmg.dcc.saotome.beholder.ui.table.Table;

/**
 * Class description: 
 * @author guilherme.alecrim
 */
// TODO guilherme.alecrim: documentar classe e métodos
public class ScreenSearchMedia
{
	private Select type;
	private TextField name;
	private TextField borrowed;
	private Button btnSearch;
	private Table tableResult;

	private Button btnEdit;
	private Button btnDelete;
	private Button btnLend;

	private PopUp popUpNoResultsFound;
	private PopUpDelete popUpDelete;
	private PopUp popUpSucessDelete;
	private LendMedia lendMedia;

	public ScreenSearchMedia()
	{
		type = SetUp.BUILDER.uiComponentBuilderInstance().selectFieldInstance();
		name = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		borrowed = SetUp.BUILDER.uiComponentBuilderInstance().textFieldInstance();
		btnSearch = SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();
		tableResult = SetUp.BUILDER.uiComponentBuilderInstance().tableInstance();
		btnEdit = SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();
		btnDelete = SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();
		btnLend = SetUp.BUILDER.uiComponentBuilderInstance().buttonInstance();
		
		popUpNoResultsFound = new PopUp(
				"/html/body/div[4]/div",
				"/html/body/div[4]/div/div/div[2]/div/div",
				"/html/body/div[4]/div/div/div[2]/div/button"
				);
		
		popUpDelete = new PopUpDelete("/html/body/div[5]/div",
				"/html/body/div[5]/div/div/div[2]/div/div", 
				"/html/body/div[5]/div/div/div[2]/div/nav/button ",
				"/html/body/div[5]/div/div/div[2]/div/nav/button[2]"
				);
		
		
		popUpSucessDelete = new PopUp(
				"/html/body/div[4]/div",
				"/html/body/div[4]/div/div/div[2]/div/div",
				"/html/body/div[4]/div/div/div[2]/div/button"
				);
		
		
		lendMedia = new LendMedia();
	}

	public Select getType()
	{
		type = SetUp.BUILDER.uiComponentBuilderInstance().selectFieldInstance();
		type.loadById("medias_typeListBox");
		return type;
	}

	public TextField getName()
	{
		name.loadById("medias_nameTextBox");
		return name;
	}

	public TextField getBorrowed()
	{
		borrowed.loadById("medias_personTextBox");
		return borrowed;
	}

	public Button getBtnSearch()
	{
		btnSearch.loadById("medias_pesquisarButton");
		return btnSearch;
	}

	public Table getTableResult()
	{
		tableResult.loadByXPath("/html/body/div[3]/div[2]/div/div[2]/div/div/div/table");
		return tableResult;
	}

	public PopUp getPopUpNoResultsFound()
	{
		return popUpNoResultsFound;
	}

	public Button getBtnEdit()
	{
		btnEdit.loadById("medias_edit");
		return btnEdit;
	}

	public Button getBtnDelete()
	{
		btnDelete.loadById("medias_delete");
		return btnDelete;
	}

	public Button getBtnLend()
	{
		btnLend.loadById("medias_lend");
		return btnLend;
	}

	public PopUpDelete getPopUpDelete()
	{
		return popUpDelete;
	}

	public PopUp getPopUpSucessDelete()
	{
		return popUpSucessDelete;
	}

	public LendMedia getLendMedia()
	{
		return lendMedia;
	}
}