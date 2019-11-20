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

import domain.SimpleContent;

/**
 * @author Billy Bissic
 *
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DocumentAlreadyExistsException extends RuntimeException {
	public DocumentAlreadyExistsException(SimpleContent simpleContent) {
		super("Document already exists under document name '" + simpleContent.getDocumentName() + "'.");
	}

}
