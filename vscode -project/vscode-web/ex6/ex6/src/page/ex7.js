$("#btnLogin").on("click",onLoginClick);
function onLoginClick(){
    var name =$("#userName").val();
    var pwd=$("#userPwd").val();

    $.post("src/server/logCheck.php",{
        "name":name,
        "pwd":pwd
    },function(data){
        console.log(data)
    },"json");
}