$(function(){

    $("#btn-login").click(function(){
        var userName = $.trim($("#userName").val());
        var password = $.trim($("#password").val());

        if(userName === ""){
            alert("用户名不能为空！")
        }
        if(password === ""){
            alert("密码不能为空！")
        }

        $.ajax({
            url: "/doLogin",
            type: "post",
            data: {"userName":userName,"password":password},

            success: function(data){
                $("#btn_login").val("登陆");
                if(data["statusCode"] === 200){
                    location.href="/Home"
                }else{
                    alert("账号或密码错误，请重新输入！")
                }
            }
        })
    })
})