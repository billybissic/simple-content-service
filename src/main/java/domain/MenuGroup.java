/**
 * 
 * @license
 * Copyright Billy Bissic. All Rights Reserved.
 *
 * Use of this source code is governed by an MIT-style license that can be
 * found in the LICENSE file at http://www.magnificenteyes.com/magnificent-essentials/license
 */
package domain;

public class MenuGroup {
	private MenuItem menuItems[];

	/**
	 * @return the menuItems
	 */
	public MenuItem[] getMenuItems() {
		return menuItems;
	}

	/**
	 * @param menuItems the menuItems to set
	 */
	public void setMenuItems(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}
}
