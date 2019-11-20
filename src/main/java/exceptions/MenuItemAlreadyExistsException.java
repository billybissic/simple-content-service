/**
 * 
 * @license
 * Copyright Billy Bissic. All Rights Reserved.
 *
 * Use of this source code is governed by an MIT-style license that can be
 * found in the LICENSE file at http://www.magnificenteyes.com/magnificent-essentials/license
 */
package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Billy Bissic
 *
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MenuItemAlreadyExistsException extends RuntimeException {
	public MenuItemAlreadyExistsException() {
		super("Menu item already exists.");
	}
}
