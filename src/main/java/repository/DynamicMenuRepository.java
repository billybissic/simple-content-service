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

import domain.DynamicMenu;

/**
 * @author Billy Bissic
 *
 */
public interface DynamicMenuRepository extends MongoRepository<DynamicMenu, String>{

	/**
	 * @param _id
	 * @return
	 */
	DynamicMenu findOne(String _id);

}
