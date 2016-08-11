package com.issueking.test.api.controller.main.menu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.issueking.test.api.common.utils.MenuUtil;
import com.issueking.test.api.persistance.main.menu.MenuMapper;




@Controller
@RequestMapping(value = "apis/main/menu")
public class MenuController {
    
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    
    @Autowired
    MenuMapper menuMapper;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object readMenuList() throws Exception {
        
        /*HttpSession session = request.getSession();*/
        
        List<Map<String, Object>> menuList = menuMapper.readMenuList();
        logger.debug("menuList:::::::::::::::"+menuList);
        
        /** 그룹별 메뉴 리스트 트리 구현 */
        List<Map<String, Object>> groupMenuList = MenuUtil.buildMenu(menuList);
        logger.debug("gropMenuList:::::::::::::::"+groupMenuList);
        
        Map<String, Object> result = new HashMap<String, Object>();
        
        /*Iterator<String> iterator = groupMenuList.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            //System.out.print("key="+key);
            //.out.println(" value="+result.get(key));
            String LowerKey = key.toLowerCase();
            result.put(LowerKey, result.get(key));
        }*/
        
        result.put("menu_list", groupMenuList);
        
        return result;
    }

}
