package com.ctb.pilot.web.menu.service;

import static com.ctb.pilot.web.menu.domain.MenuConstants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.ctb.pilot.web.menu.domain.SubMenuSection;

@Service("menuService")
public class DefaultMenuService implements MenuService {

	private Map<String, List<SubMenuSection>> menuNameAndSubMenuSectionListMap = new HashMap<String, List<SubMenuSection>>();

	@PostConstruct
	public void init() {
		// Pilot
		List<SubMenuSection> subMenuSections = new ArrayList<SubMenuSection>();

		// Pilot -> Algorithm Contest
		SubMenuSection subMenuSection = new SubMenuSection(
				SUB_MENU_HEADER_ALGORITHM_CONTEST);
		subMenuSection.addMenuItem(SUB_MENU_ITEM_NAME_PROGRAMMING_CHALLENGE,
				SUB_MENU_ITEM_URL_PROGRAMMING_CHALLENGE);
		subMenuSections.add(subMenuSection);

		menuNameAndSubMenuSectionListMap.put(MENU_NAME_PILOT, subMenuSections);
	}

	@Override
	public List<SubMenuSection> getSubMenu(String menuName) {
		return menuNameAndSubMenuSectionListMap.get(menuName);
	}

}
