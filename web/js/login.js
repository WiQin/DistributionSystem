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
           /*data:"{account:"+account.val()+",password:"+password.val()+"t:"+new Date().getTime()+"}",
           datatype:"json",*/
           data:"account="+account.val()+"&passWord="+password.val()+
               "&time="+new Date().getTime(),
           success:function (msg) {
               alter(mag == 1);
               if(amg==1){
                   $(".link_pwd").html("用户名错误");
                   return flase;
               }else if(mag == 2){
                   $(".link_pwd").html("密码错误");
                   return flase;
               }else if(msg==3){
                   location.href = 'main.jsp';
               }
               //alert(msg);
           },
           error:function(er){
               alert(er.message);
           }
       })
    })
});