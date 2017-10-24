package com.route21.ws.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.Menu;

public class ListMenuResponse extends Response {
	
	@JsonProperty("MENU_LIST")
	private List<Menu> menu;

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	
}
