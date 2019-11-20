/**
 * 
 * @license
 * Copyright Billy Bissic. All Rights Reserved.
 *
 * Use of this source code is governed by an MIT-style license that can be
 * found in the LICENSE file at http://www.magnificenteyes.com/magnificent-essentials/license
 */
package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.DynamicMenu;
import domain.SimpleContent;
import exceptions.DocumentAlreadyExistsException;
import exceptions.DocumentNotFoundException;
import exceptions.MenuItemNotFoundException;
import exceptions.NoDataAvailableException;
import repository.DynamicMenuRepository;
import repository.SimpleContentRepository;

/**
 * @author Billy Bissic
 *
 */

@Controller
@RequestMapping(path="/api/ContentManagement")
public class ContentManagementController {

	@Autowired
	private SimpleContentRepository simpleContentRepository;
	
	@Autowired
	private DynamicMenuRepository dynamicMenuRepository;
	
	@RequestMapping(path="/getSimpleContentById/{_id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getSimpleContentById(@PathVariable String _id)
	{
		try
		{
			SimpleContent simpleContent = simpleContentRepository.findOne(_id);
			if (simpleContent == null) {
				throw new DocumentNotFoundException();
			}
			return new ResponseEntity<SimpleContent>(simpleContent, HttpStatus.OK);
		}
		catch (DataAccessException ex)
		{
			/* All other errors send generic message to browser */
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			/* TODO: log the exception */
		}
	}
	@RequestMapping(path="/getAllSimpleDocuments", method = RequestMethod.GET)
	public @ResponseBody Iterable<SimpleContent> getAllContentById()
	{
		return simpleContentRepository.findAll();
	}
	
	@RequestMapping(path="/getSimpleContentByDocumentName", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getSimpleContentByDocumentName(@RequestParam String documentName)
	{
		try
		{
			SimpleContent simpleContent = simpleContentRepository.findByDocumentName(documentName);
			if (simpleContent == null) {
				throw new DocumentNotFoundException();
			}
			return new ResponseEntity<SimpleContent>(simpleContent, HttpStatus.OK);
		}
		catch (DataAccessException ex)
		{
			/* All other errors send generic message to browser */
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			/* TODO: log the exception */
		}
	}
	
	@RequestMapping(path="/createNewSimpleContentDocument", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> createNewSimpleContentDocument(@RequestBody SimpleContent document)
	{
		try
		{
			SimpleContent simpleContent = simpleContentRepository.findByDocumentName(document.getDocumentName());
			if (simpleContent == null)
			{
				simpleContentRepository.save(document);
				return new ResponseEntity<SimpleContent>(document, HttpStatus.CREATED);
			}
			else
			{
				throw new DocumentAlreadyExistsException(document);
			}
		}
		catch (DataAccessException ex)
		{
			/* All other errors send generic message to browser */
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		
			/* TODO: log the exception */
		}
	}
	
	@RequestMapping(path="/updateSimpleContentDocument", method = RequestMethod.POST)
	public ResponseEntity<?> updateSimpleContentDocument(@RequestBody SimpleContent document)
	{
		try
		{
			SimpleContent simpleContent = simpleContentRepository.findOne(document.getDocumentName());
			if (simpleContent == null)
			{
				throw new DocumentNotFoundException();
			}
			else 
			{
				simpleContentRepository.save(document);
				return new ResponseEntity<SimpleContent>(document, HttpStatus.ACCEPTED);
			}
		}
		catch (DataAccessException ex)
		{
			/* All other errors send generic message to browser */
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		
			/* TODO: log the exception */
		}
	}
	
	@RequestMapping(path="/deleteSimpleContentById/{_id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteSimpleContentById(@PathVariable String _id)
	{
		try
		{
			SimpleContent simpleContent = simpleContentRepository.findOne(_id);
			if (simpleContent == null)
			{
				throw new DocumentNotFoundException();
			}
			else
			{
				simpleContentRepository.delete(simpleContent);
				return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			}
		}
		catch (DataAccessException ex)
		{
			/* All other errors send generic message to browser */
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		
			/* TODO: log the exception */
		}
	}
	
	@RequestMapping(path="/getAllMenus", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMenus()
	{
		try
		{
			Iterable<DynamicMenu> menus = dynamicMenuRepository.findAll();
			if( menus == null )
			{
				throw new NoDataAvailableException();
			}
			return new ResponseEntity<Iterable<DynamicMenu>>(menus, HttpStatus.OK);
		}
		catch (DataAccessException ex)
		{
			/* All other errors send generic message to browser */
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		
			/* TODO: log the exception */
		}
	}
	
	@RequestMapping(path="/updateMenu", method = RequestMethod.POST)
	public ResponseEntity<?> updateMenuItem(@RequestBody DynamicMenu menu)
	{
		try
		{
			dynamicMenuRepository.save(menu);
			return new ResponseEntity<DynamicMenu>(menu, HttpStatus.OK);
		}
		catch (DataAccessException ex)
		{
			/* All other errors send generic message to browser */
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		
			/* TODO: log the exception */
		}
	}
	
	@RequestMapping(path="getMenuById/{_id}", method = RequestMethod.GET)
	public ResponseEntity<?> getMenuById(@PathVariable String _id)
	{
		try
		{
			DynamicMenu dynamicMenu = dynamicMenuRepository.findOne(_id);
			if (dynamicMenu == null)
			{
				throw new MenuItemNotFoundException();
			}
			return new ResponseEntity<DynamicMenu>(dynamicMenu, HttpStatus.OK);
		}
		catch (DataAccessException ex)
		{
			/* All other errors send generic message to browser */
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		
			/* TODO: log the exception */
		}
	}
	
	@RequestMapping(path="/deleteMenuById/{_id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteMenuById(@PathVariable String _id)
	{
		try
		{
			DynamicMenu dynamicMenu = dynamicMenuRepository.findOne(_id);
			if (dynamicMenu == null)
			{
				throw new MenuItemNotFoundException();
			}
			else
			{
				dynamicMenuRepository.delete(dynamicMenu);
				return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			}
		}
		catch (DataAccessException ex)
		{
			/* All other errors send generic message to browser */
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		
			/* TODO: log the exception */
		}
	}
}
