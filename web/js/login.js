/*
* 用户登录的js验证
* */
$(function(){
    $(".admin_login_btn").click(function () {
       /*alert("点击");*/
       var account = $("#account");
       var password = $("#password");
       if(account.val()==""){
           //alert("用户名不能为空");
           account.focus();//焦点
           return false;
       }
       if(password.val()==""){
           password.focus();
           return flase;
       }

       $.ajax({
           url:"login.do",
           type:"POST",
           //json对象
           data:{"account":account.val(),"password":password.val(),"t":new Date().getTime()},
           dataType:"json",
           /*data:"account="+account.val()+"&password="+password.val()+
               "&time="+new Date().getTime(),*/
           success:function (msg) {

               if(msg==1){
                   $(".link_pwd").html("用户名错误");
                   return flase;
               }else if(msg == 2){
                   $(".link_pwd").html("密码错误");
                   return flase;
               }else if(msg==3){
                   location.href = 'main.jsp';
               }

           },
           error:function(er){
               alert(er.message);
           }
       })
    })
});