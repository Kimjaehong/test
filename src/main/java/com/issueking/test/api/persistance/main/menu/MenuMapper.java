package com.issueking.test.api.persistance.main.menu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository(value="MenuMapper")
public interface MenuMapper {
    
    @Select("SELECT menu_id, up_menu_id, menu_nm, menu_icon_nm, url FROM MENU_MST WHERE USE_YN = 'Y'")
    public List<Map<String, Object>> readMenuList();
}
