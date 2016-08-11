package com.issueking.test.api.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MenuUtil {
    
    /** 그룹별 메뉴 리스트 생성 */
    public static List<Map<String, Object>> buildMenu(List<Map<String, Object>> menuList) {
        List<Map<String, Object>> rtnMenuList = new ArrayList<Map<String, Object>>();
        rtnMenuList = appendMenu(menuList, "TOP");
        
        return rtnMenuList;
    }
    
    /** 그룹별 메뉴 리스트 추가 */
    private static List<Map<String, Object>> appendMenu(List<Map<String, Object>> menuList, Object object) {
        List<Map<String, Object>> childMenu = new ArrayList<Map<String, Object>>();
        
        for(Map<String, Object> menuItem : menuList) {
            if(menuItem.get("UP_MENU_ID".toLowerCase()).equals(object)) {
                if(hasChildren(menuList, menuItem.get("MENU_ID".toLowerCase()))) {
                    List<Map<String, Object>> childMenuList = appendMenu(menuList, menuItem.get("MENU_ID".toLowerCase()));
                    menuItem.put("menu_items", childMenuList);
                }
                else {
                    List<Map<String, Object>> childMenuList = new ArrayList<Map<String, Object>>();
                    menuItem.put("menu_items", childMenuList);
                }
                
                childMenu.add(menuItem);
            }
        }

        return childMenu;
    }
        
    /** 해당 메뉴의 하위 정보가 존재하는지 여부 확인 */
    private static boolean hasChildren(List<Map<String, Object>> menuList, Object object) {
        for(Map<String, Object> menu : menuList) {
            if(menu.get("UP_MENU_ID".toLowerCase()).equals(object)) {
                return true;
            }
        }
        
        return false;
    }

}
