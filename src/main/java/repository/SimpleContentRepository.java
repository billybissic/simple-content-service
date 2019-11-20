/**
 * 
 * @license
 * Copyright Billy Bissic. All Rights Reserved.
 *
 * Use of this source code is governed by an MIT-style license that can be
 * found in the LICENSE file at http://www.magnificenteyes.com/magnificent-essentials/license
 */
package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.SimpleContent;

/**
 * @author Billy Bissic
 *
 */
public interface SimpleContentRepository extends MongoRepository<SimpleContent, String> {
	
	/**
	 * @param _id
	 * @return
	 */
	SimpleContent findOne(String _id);

	SimpleContent findByDocumentName(String documentName);

}
