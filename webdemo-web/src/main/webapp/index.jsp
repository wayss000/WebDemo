<script>
    //TODO 默认进入首页，如果没有权限则跳转到登录页面,但目前有bug，详见web.xml中的描述
    //window.location.href="index";

    //下面的跳转走静态页面
     window.location.href="/static/html/login/login.html";
    //下面的跳转走后台Controller
    //window.location.href="/login/login_page";
</script>