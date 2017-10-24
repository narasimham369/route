package com.route21.ws.service;

import com.route21.ws.request.SaveMenuRequest;
import com.route21.ws.response.ListMenuResponse;
import com.route21.ws.response.MenuResponse;
import com.route21.ws.response.Response;

public interface MenuService {
	
	public MenuResponse saveMenu(SaveMenuRequest request);
	
	public MenuResponse getMenu(long id );
	
	public ListMenuResponse listMenu(String type);
	
	public Response deleteMenu(long Id);
}