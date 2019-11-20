/**
 * 
 * @license
 * Copyright Billy Bissic. All Rights Reserved.
 *
 * Use of this source code is governed by an MIT-style license that can be
 * found in the LICENSE file at http://www.magnificenteyes.com/magnificent-essentials/license
 */
package domain;

public class MenuItem {
	private String menuItemName;
	private String menuItemDescription;
	private String menuItemLink; /* can be a link to another page or link to section on the page */
	
	/**
	 * @return the menuItemName
	 */
	public String getMenuItemName() {
		return menuItemName;
	}
	/**
	 * @param menuItemName the menuItemName to set
	 */
	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}
	/**
	 * @return the menuItemDescription
	 */
	public String getMenuItemDescription() {
		return menuItemDescription;
	}
	/**
	 * @param menuItemDescription the menuItemDescription to set
	 */
	public void setMenuItemDescription(String menuItemDescription) {
		this.menuItemDescription = menuItemDescription;
	}
	/**
	 * @return the menuItemLink
	 */
	public String getMenuItemLink() {
		return menuItemLink;
	}
	/**
	 * @param menuItemLink the menuItemLink to set
	 */
	public void setMenuItemLink(String menuItemLink) {
		this.menuItemLink = menuItemLink;
	}
}
