/*
* 添加用户验证
* */
$(function () {
    $(".btn-primary").click(function () {
        var user_id = $("input[name='user_id']");
        var user_name = $("input[name='user_name']");
        var user_pass = $("input[name='user_pass']");
        var user_birthday = $("input[name='user_birthday']");
        var user_city = $("input[name='user_city']");
        var re_pass = $("input[name='re_pass']");

        if(user_id.val()==""){
            user_id.focus();
            return false
        }

        if(user_name.val()==""){
            user_name.focus();
            return false
        }
        if(user_pass.val()==""){
            user_pass.focus();
            return false
        }
        if(user_birthday.val()==""){
            user_birthday.focus();
            return false
        }
        if(user_city.val()==""){
            user_city.focus();
            return false
        }
        if(re_pass.val()==""){
            re_pass.focus();
            return false
        }

        if(user_pass.val()!=re_pass.val()){
            re_pass.select();
            return false;
        }

        $("form").submit();

    });
  /*  /!**
     * 验证登录账号是否已经被使用过了
     *!/
    user_id.blur(function(){
        if(user_id.val()!=""){
            $.ajax({
                type:"post",
                url:"check.do",
                data:{"user_id":user_id.val(),"time":new Date().getTime()},
                dataType:"json",
                success:function(msg){
                    console.log(msg)
                    if(msg==1){
                        $(".spmsg").html("该登录账号已被使用，请更换！");
                        $(".btn").hide();
                        return false;
                    }else{
                        $(".spmsg").html("该登录账号可以使用！");
                        $(".btn").show();
                    }
                },
                error:function(er){
                    alert(er.error);
                }
            });
        }


    });
*/
});
