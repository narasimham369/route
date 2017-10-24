package com.route21.ws.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.route21.ws.bean.Menu;
import com.route21.ws.repository.MenuRepository;
import com.route21.ws.request.SaveMenuRequest;
import com.route21.ws.response.ListMenuResponse;
import com.route21.ws.response.MenuResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.MenuService;



@Service
public class MenuServiceImpl implements MenuService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Autowired
	MenuRepository menuRepository;

	@Override
	public MenuResponse saveMenu(SaveMenuRequest request) {
		
		Menu menu = null;
		MenuResponse response = new MenuResponse();
		if(request.getId() == 0) {
			menu = new Menu();
		} else {
			menu = menuRepository.findOne(request.getId());
		}
		
		menu.setName(request.getName());
		menu.setSort(request.getSort());
		menu.setType(request.getType());
		menu.setUrl(request.getUrl());
		menuRepository.saveAndFlush(menu);
		response.setMenu(menu);
		response.setStatusCode(200);
		response.setStatusMessage("Menu stored successful");
		
		return response;
	}

	@Override
	public MenuResponse getMenu(long id) {
		Menu menu = menuRepository.findOne(id);
		MenuResponse response = new MenuResponse();
		response.setMenu(menu);
		response.setStatusCode(200);
		response.setStatusMessage("Menu");
		return response;
	}

	@Override
	public ListMenuResponse listMenu(String type) {
		List<Menu> menu = null;
		System.out.println("TYPE "+type);
		if(type == null) {
			menu = menuRepository.findAll();
		} else {
			menu = menuRepository.findByTypeOrderBySortAsc(type);
		}
		
		ListMenuResponse response = new ListMenuResponse();
		response.setMenu(menu);
		response.setStatusCode(200);
		response.setStatusMessage("Menu listing");
		return response;
	}

	@Override
	public Response deleteMenu(long Id) {
		Response response = new Response();
		menuRepository.delete(Id);
		response.setStatusCode(200);
		response.setStatusMessage("Menu deleted successfully");
		return response;
	}

	
	
}
