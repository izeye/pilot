package com.ctb.pilot.web.menu.domain;

import java.util.ArrayList;
import java.util.List;

public class SubMenuSection {

	private final String header;
	private final List<MenuItem> menuItems = new ArrayList<MenuItem>();

	public SubMenuSection(String header) {
		this.header = header;
	}

	public String getHeader() {
		return header;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void addMenuItem(MenuItem menuItem) {
		menuItems.add(menuItem);
	}

	public void addMenuItem(String menuItemName, String menuItemUrl) {
		addMenuItem(new MenuItem(menuItemName, menuItemUrl));
	}

	@Override
	public String toString() {
		return "SubMenuSection [header=" + header + ", menuItems=" + menuItems
				+ "]";
	}

}
