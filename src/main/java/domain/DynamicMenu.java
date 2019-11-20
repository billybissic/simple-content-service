/**
 * 
 * @license
 * Copyright Billy Bissic. All Rights Reserved.
 *
 * Use of this source code is governed by an MIT-style license that can be
 * found in the LICENSE file at http://www.magnificenteyes.com/magnificent-essentials/license
 */
package domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Billy Bissic
 *
 */

@Document(collection = "dynamic-menus")
public class DynamicMenu {

	@Id private String _id;
	private String menuName;
	private String menuDescription;
	private MenuGroup menuGroups[];
	private String menuVisibility;
	private String menuStyle;
	private String menuOrientation;
	private String menuFunction;
	
	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}
	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * @return the menuDescription
	 */
	public String getMenuDescription() {
		return menuDescription;
	}
	/**
	 * @param menuDescription the menuDescription to set
	 */
	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}
	/**
	 * @return the menuGroups
	 */
	public MenuGroup[] getMenuGroups() {
		return menuGroups;
	}
	/**
	 * @param menuGroups the menuGroups to set
	 */
	public void setMenuGroups(MenuGroup[] menuGroups) {
		this.menuGroups = menuGroups;
	}
}
