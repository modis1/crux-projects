package org.cruxframework.crossdeviceshowcase.client.controller.samples.randompager;

import java.util.ArrayList;
import java.util.List;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.deviceadaptivegrid.DeviceAdaptiveGrid;
import org.cruxframework.crux.widgets.client.event.row.RowRenderEvent;
import org.cruxframework.crux.widgets.client.event.row.RowRenderHandler;
import org.cruxframework.crux.widgets.client.grid.DataRow;
import org.cruxframework.crux.widgets.client.image.Image;

import com.google.gwt.user.client.ui.HTML;

@Controller("randomPagerController")
public class RandomPagerController
{
	@Inject
	private MyWidgetAccessor myWidgetAccessor;
	
	@Inject
	private RandomPagerMessages messages;
	
	@Expose
	public void onLoad()
	{
		/* Insert the component description*/
		myWidgetAccessor.htmlDescText().setHTML(messages.htmlDescText());	
		
		loadData();
	}
	
	private void loadData(){
		
		CountryDS countryDS = (CountryDS) myWidgetAccessor.grid().getDataSource();
		List<CountryDTO> countryList = new ArrayList<CountryDTO>();
		
		countryList.add(new CountryDTO("bandArgentina", messages.argentina(), messages.capitalArgentina(), messages.southAmerica()));
		countryList.add(new CountryDTO("bandBrasil", messages.brazil(), messages.capitalBrazil(), messages.southAmerica()));
		countryList.add(new CountryDTO("bandChile", messages.chile(), messages.capitalChile(), messages.southAmerica()));
		
		countryList.add(new CountryDTO("bandCosta Rica", messages.costaRica(), messages.capitalCostaRica(), messages.centralAmerica()));
		
		countryList.add(new CountryDTO("bandEstados", messages.usa(), messages.capitalUsa(), messages.america()));
		countryList.add(new CountryDTO("bandMéxico", messages.mexico(), messages.capitalMexico(), messages.america()));
		countryList.add(new CountryDTO("bandCanadá", messages.canada(), messages.capitalCanada(), messages.america()));
		
		countryList.add(new CountryDTO("bandAlemanha", messages.germany(), messages.capitalGermany(), messages.europe()));
		countryList.add(new CountryDTO("bandEspanha", messages.spain(), messages.capitalSpain(),  messages.europe()));
		countryList.add(new CountryDTO("bandFrança‎", messages.france(), messages.capitalFrance(),  messages.europe()));
		countryList.add(new CountryDTO("bandItália", messages.italy(), messages.capitalItaly(),  messages.europe()));
		
		countryList.add(new CountryDTO("bandChina", messages.china(), messages.capitalChina(), messages.asia()));
		countryList.add(new CountryDTO("bandCoreadoSul", messages.southKorea(), messages.capitalSouthKorea(), messages.asia()));
		countryList.add(new CountryDTO("bandJapão", messages.japan(), messages.capitalJapan(), messages.asia()));
		
		countryList.add(new CountryDTO("bandAfricaDoSul", messages.southAfrica(), messages.capitalSouthAfrica(), messages.africa()));
		countryList.add(new CountryDTO("bandArgélia", messages.algeria(), messages.capitalAlgeria(), messages.africa()));
		countryList.add(new CountryDTO("bandMarrocos", messages.morocco(), messages.capitalMorocco(), messages.africa()));
		
		countryList.add(new CountryDTO("bandAustrália‎", messages.australia(), messages.capitalAustralia(), messages.oceania()));
		
		countryDS.setCountries(countryList);
		
		myWidgetAccessor.grid().addRowRenderHandler(new RowRenderHandler()
		{
			@Override
			public void onRowRender(RowRenderEvent event) {
				DataRow row = event.getRow();
				Image image = (Image) row.getWidget("flag");
				image.setUrl(((CountryDTO)row.getDataSourceRecord().getRecordObject()).getFlag());
			}
		});
		myWidgetAccessor.grid().loadData();
		myWidgetAccessor.grid().refresh();	
	}
	
	@BindView("randomPager")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
		DeviceAdaptiveGrid grid();
	}

	public void setMyWidgetAccessor(MyWidgetAccessor myWidgetAccessor) {
		this.myWidgetAccessor = myWidgetAccessor;
	}

	public void setMessages(RandomPagerMessages messages) {
		this.messages = messages;
	}
}
