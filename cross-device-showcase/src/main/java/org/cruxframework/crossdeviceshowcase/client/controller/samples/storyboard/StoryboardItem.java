package org.cruxframework.crossdeviceshowcase.client.controller.samples.storyboard;

import java.util.List;

import org.cruxframework.crux.widgets.client.image.Image;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class StoryboardItem extends Composite{

	private FlowPanel painel = new FlowPanel(); 
	private Image imagem = new Image();
	private Label labelDescricao = new Label();
	private Label labelPreco = new Label();
	private Button button = new Button();
	private String url;
	private String descricao;
	private String preco;
	private String textButton;
	
	public StoryboardItem(String url, String descricao, String preco, String textButton, List<StoryboardItem> listItem)
	{
		initWidget(painel);
		painel.add(imagem);
		painel.add(labelDescricao);
		painel.add(labelPreco);
		painel.add(button);	
		
		imagem.setSize("200px", "200px");
		imagem.setUrl(url);
		labelDescricao.setText(descricao);
		//labelDescricao.setStyleName("storyboardDescricao");
		labelPreco.setText(preco);
		//labelPreco.setStyleName("storyboardPreco");
		button.setText(textButton);
		
		button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Você clicou no botão comprar.");
			}

		});
		
		if(listItem != null)
		{
			listItem.add(this);
		}
	}
	
}
