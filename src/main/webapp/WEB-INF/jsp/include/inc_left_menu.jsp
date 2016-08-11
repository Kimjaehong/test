<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <nav>
        <ul id="main_menu">
        </ul>
    </nav>
            <!--       <span class="minifyme" data-action="minifyMenu"> <i class="fa fa-arrow-circle-left hit"></i> </span> -->
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
            $.each(parent, function(i, items) {
                menu.append(getMainMenuTree(items,0));
            });
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