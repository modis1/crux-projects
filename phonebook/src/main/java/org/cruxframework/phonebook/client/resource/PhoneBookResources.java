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
package org.cruxframework.phonebook.client.resource;

import org.cruxframework.crux.core.client.resources.Resource;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive.Device;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;

/**
 * @author Flavia.Yeshua
 *
 */
@Resource(value = "phonebookResources", supportedDevices = {Device.all })
public interface PhoneBookResources extends ClientBundle
{
	/**
	 * @return resources css.
	 */
	@Source({"phonebook.css" })
	CssResource css();
	
	/**
	 * @return image resources according the method.
	 */
	@Source("flag-pt.png")
	DataResource flagPtbr();
	
	/**
	 * @return image resources according the method.
	 */
	@Source("flag-en.png")
	DataResource flagEn();
}
