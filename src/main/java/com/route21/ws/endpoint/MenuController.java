package com.route21.ws.endpoint;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.route21.ws.constants.Route21Constants;
import com.route21.ws.request.SaveMenuRequest;
import com.route21.ws.response.ListMenuResponse;
import com.route21.ws.response.MenuResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.MenuService;

/**
* 
* This is the Menu Controller class .
* 
* It has Autowired annotation to inject Menu service.
* 
* It has methods to add, get and delete  the records.
* 
* It has logger tool also to expose the structure of class.
* 
* @author admin-pc
*
*/
@RestController
@Path("/")
public class MenuController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	protected MenuService menuService;
	
	
	/**
	 * 
	 * This controller is used to insert MenuResponse table.
	 * 
	 * In side the method it has only return type.
	 * 
	 * @param SaveMenuRequest to hold the records.
	 * 
	 * @return saveMenu object to save the records in database.
	 * 
	 */
	
	@POST
	@Path(Route21Constants.SAVE_MENU)
	@Consumes("application/json")
	@Produces("application/json")
	public MenuResponse saveMenu(SaveMenuRequest request) {
		
		return menuService.saveMenu(request);
	}
	
	/**
	 * 
	 * This controller is used to list ListMenuResponse from menu table.
	 * 
	 * @param type is the variable.
	 * 
	 * In side the method it has only return type.
	 * 
	 * @return listMenu object to retrieve the records in database.
	 * 
	 */
	
	@GET
	@Path(Route21Constants.LIST_MENU)
	@Produces("application/json")
	public ListMenuResponse listMenu(@QueryParam("type") String type) {
		
		return menuService.listMenu(type);
	}
	
	/**
	 * 
	 * This controller is used to get Menu table  ById.
	 * 
	 * In side the method it has only return type.
	 * 
	 * @param Id to get the records based on Id.
	 * 
	 * @return getMenu object to get the records in database.
	 * 
	 */
	
	@GET
	@Path(Route21Constants.GET_MENU)
	@Produces("application/json")
	public MenuResponse getMenuById(@PathParam("Id")int Id) {
		System.out.println("GET MENU SERVICE"+ Id);
		return menuService.getMenu(Id);
	}
	
	/**
	 * 
	 * This controller is used to delete records from menu table.
	 * 
	 * In side the method it has only return type.
	 * 
	 * @param Id to delete the records based on Id.
	 * 
	 * @return deleteMenu object to delete the records in database.
	 * 
	 */
	
	@DELETE
	@Path(Route21Constants.DELETE_MENU)
	public Response deleteMenu(@PathParam("Id") int Id) {
		return menuService.deleteMenu(Id);
	}
	
}
