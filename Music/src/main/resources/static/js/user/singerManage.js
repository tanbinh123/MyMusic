$(function(){
    $("#btn-singer-submit").click(function(){
        let singerName = $.trim($("#singerName").val());
        let singerSex = $.trim($("#singerSex").val());
        let singerAge = $.trim($("#singerAge").val());
        let singerAddress = $.trim($("#singerAddress").val());
        let singerIntroduction = $.trim($("#singerIntroduction").val());

        //console.log("name: ",singerName,singerSex,singerAge,singerAddress,singerIntroduction);
        if(checkInput()){
            $.ajax({
                url:"/singerSubmit",
                type:"POST",
                data: {"singerName":singerName,
                        "singerSex":singerSex,
                        "singerAge":singerAge,
                        "singerAddress":singerAddress,
                        "singerIntroduction":singerIntroduction},

                success: function(data){
                    var status = data["statusCode"];
                    if(status === 200){
                        alert("提交成功!")
                    }else{
                        alert("提交失败,请重新提交!");
                    }
                }
            })
        }else{
            alert("存在空值,请重新填写")
        }

    })

})