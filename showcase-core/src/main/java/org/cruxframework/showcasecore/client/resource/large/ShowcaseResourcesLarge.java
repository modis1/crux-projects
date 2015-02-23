/*
 * Copyright 2013 cruxframework.org.
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
package org.cruxframework.showcasecore.client.resource.large;

import org.cruxframework.crux.core.client.resources.Resource;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive.Device;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * @author Gesse Dafe
 *
 */
@Resource(value="showcaseCoreResources", supportedDevices={Device.all})
public interface ShowcaseResourcesLarge extends ClientBundle
{
	@Source("cssShowcaseLarge.css")
	CssShowcaseLarge css();
	
	@Source("icon-layout.png")
	DataResource layoutSectionIcon();
	
	@Source("icon-site.png")
	DataResource siteIcon();
	
	@Source("icon-project.png")
	DataResource projectIcon();
	
	@Source("svg-icon-present.svg")
	DataResource svgIconPresent();
	
	@Source("svg-icon-arrow.svg")
	DataResource svgIconArrow();
	
	@Source("banner1.jpg")
	ImageResource banner1promo();
	
	@Source("banner2.jpg")
	ImageResource banner2promo();
	
	@Source("banner3.jpg")
	ImageResource banner3promo();
	
	@Source("coliseu.jpg")
	DataResource image1Image();
	
	@Source("eiffel.jpg")
	DataResource image2Image();
	
	@Source("liberty.jpg")
	DataResource image3Image();
	
	@Source("crux.png")
	ImageResource crux();
	
	@Source("heads.png")
	ImageResource heads();
	
	@Source("tails.png")
	ImageResource tails();
	
	@Source("swapView1.png")
	DataResource swapView1();
	
	@Source("swapView2.png")
	DataResource swapView2();
	
	@Source("swapView3.png")
	DataResource swapView3();
	
	@Source("countries/argentina.jpg")
	ImageResource argentina();
	
	
//	Menu
	@Source("audi.png")
	ImageResource audi();
	
	@Source("bmw.png")
	ImageResource bmw();
	
	@Source("chevrolet.png")
	ImageResource chevrolet();
	
	@Source("ford.png")
	ImageResource ford();
	
	@Source("gmc.png")
	ImageResource gmc();
	
	@Source("hondaCar.png")
	ImageResource hondaCar();
	
	@Source("hyundai.png")
	ImageResource hyundai();
	
	@Source("mercedes.png")
	ImageResource mercedes();
	
	@Source("peterbilt.png")
	ImageResource peterbilt();
	
	@Source("scania.png")
	ImageResource scania();
	
	@Source("volkswagen.png")
	ImageResource volkswagen();
	
	@Source("volvo.png")
	ImageResource volvo();
	
	@Source("yamaha.png")
	ImageResource yamaha();
	
	@Source("honda.png")
	ImageResource honda();
	
	@Source("mitsubishi.png")
	ImageResource mitsubishi();
	
	@Source("mammals.jpg")
	ImageResource mammals();
	
	@Source("reptiles.jpg")
	ImageResource reptiles();
	
	@Source("birds.jpg")
	ImageResource birds();
	
	@Source("amphibians.jpg")
	ImageResource amphibians();	
	
	@Source("animals.png")
	ImageResource animals();	
	
	
//	Image RollingPanel
	@Source("sports/baseball.jpg")
	ImageResource baseball();	
	
	@Source("sports/basketball.jpg")
	ImageResource basketball();	
	
	@Source("sports/canoeing.jpg")
	ImageResource canoeing();	
	
	@Source("sports/football.jpg")
	ImageResource football();	
	
	@Source("sports/motocross.jpg")
	ImageResource motocross();
	
	@Source("sports/running.jpg")
	ImageResource running();
	
	@Source("sports/snowboard.jpg")
	ImageResource snowboard();
	
	@Source("sports/soccerball.jpg")
	ImageResource soccerball();
	
	@Source("sports/swimming.jpg")
	ImageResource swimming();
	
	@Source("sports/volleyball.jpg")
	ImageResource volleyball();
	
	
//	RollingPanel custom component
	@Source("sports/backpack.png")
	ImageResource backpack();

	@Source("sports/baseballbats.png")
	ImageResource baseballbats();
	
	@Source("sports/basketballshoes.png")
	ImageResource basketballshoes();
	
	@Source("sports/footballboots.png")
	ImageResource footballboots();
	
	@Source("sports/gloves.png")
	ImageResource gloves();
	
	@Source("sports/pinkball.png")
	ImageResource pinkball();
	
	@Source("sports/swimshorts.png")
	ImageResource swimshorts();
	
	
//	SwapViewContainer
	@Source("shopping.png")
	ImageResource shopping();
	
	@Source("product.png")
	ImageResource product();
	
	@Source("addedProduct.png")
	ImageResource addedProduct();
	
	@Source("purchaseCompleted.png")
	ImageResource purchaseCompleted();
}
