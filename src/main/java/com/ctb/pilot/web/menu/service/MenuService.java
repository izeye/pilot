package com.ctb.pilot.web.menu.service;

import java.util.List;

import com.ctb.pilot.web.menu.domain.SubMenuSection;

public interface MenuService {

	List<SubMenuSection> getSubMenu(String menuName);

}
