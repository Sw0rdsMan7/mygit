$("#btnLogin").on("click",loginCLick);
function loginCLick(){
    var name =$("#userName").val();
    var password=$("#userPwd").val();
    $.post("src/server/loginCheck.php",{
        "name":name,
        "password":password

    },function(data){
        
        console.log(data);
        var obj=data[0];
        alert(obj.msg);
        if(obj.code==1)
            window.location="index.html";
    },"json")   
}