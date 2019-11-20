/**
 * 
 * @license
 * Copyright Billy Bissic. All Rights Reserved.
 *
 * Use of this source code is governed by an MIT-style license that can be
 * found in the LICENSE file at http://www.magnificenteyes.com/magnificent-essentials/license
 */
package controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import exceptions.DocumentAlreadyExistsException;
import exceptions.DocumentNotFoundException;
import exceptions.MenuItemAlreadyExistsException;
import exceptions.MenuItemNotFoundException;
import exceptions.NoDataAvailableException;

/**
 * @author Billy Bissic
 *
 */
@ControllerAdvice
@RequestMapping(produces = "application/vnd.error")
public class ContentManagementControllerAdvice {
	
	@ResponseBody
	@ExceptionHandler(DocumentAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	VndErrors documentAlreadyExistsException(DocumentAlreadyExistsException ex) {
		return new VndErrors("error", ex.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(MenuItemAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	VndErrors menuItemAlreadyExistsException(MenuItemAlreadyExistsException ex) {
		return new VndErrors("error", ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(NoDataAvailableException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	VndErrors nodataAvailableException(NoDataAvailableException ex) {
		return new VndErrors("error", ex.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(DocumentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	VndErrors documentAlreadyExistsException(DocumentNotFoundException ex) {
		return new VndErrors("error", ex.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(MenuItemNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	VndErrors menuItemNotFoundException(MenuItemNotFoundException ex) {
		return new VndErrors("error", ex.getMessage());
	}
}
