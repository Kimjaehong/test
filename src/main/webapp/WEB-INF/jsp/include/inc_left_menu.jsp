<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
            <nav>
                <ul id="main_menu">
                </ul>
            </nav>
            <span class="minifyme" data-action="minifyMenu"> <i class="fa fa-arrow-circle-left hit"></i> </span>
<script type="text/javascript">
$(function() {
    $.ajax({
        url: 'apis/main/menu/list',
        type: 'GET',
        async: true,
        cache: false,
        headers: {'AJAX':true},
        success: function(obj) {
            var menu = $('#main_menu');
            menu.empty();

						var parent = obj.menu_list[0].menu_items;
            console.log(parent);
            $.each(parent, function(i, items) {
                console.log("items"+items);
                menu.append(getMainMenuTree(items,0));
            });
           /*  var testItem = {
                menu_auth_type_cd: 370002
                ,menu_icon_nm: "fa-building"
                ,menu_id: "19100000"
                ,menu_items : []
                , menu_nm: "암/복호화 테스트"
                ,menu_role_type_crud : "370006"
                , up_menu_id: "10100000"
                ,url : "/mngt/view/main/enc" 
            }
            menu.append(getMainMenuTree(testItem,0)); */
            
            /* var testItem1 = {
                menu_auth_type_cd: 370002
                ,menu_icon_nm: "fa-money"
                ,menu_id: "19200000"
                ,menu_items : []
                , menu_nm: "아무거나"
                ,menu_role_type_crud : "370001"
                , up_menu_id: "10000000"
                ,url : "/mngt/view/main/top" 
            }
            menu.append(getMainMenuTree(testItem1,0)); */
        },
        error: function(obj) {
            cf_errMsg(obj);
            return;
        },
        complete: function() {
            cf_activeUrl();
            initApp.leftNav();
        }
    });
});
</script>