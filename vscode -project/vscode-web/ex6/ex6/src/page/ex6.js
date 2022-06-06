var intervals=0;
const MESSAGES=[
    "对不起，您的浏览器不支持 web 存储。",
    "我也吐槽下",
    "吐槽完毕，提交",
    "添加成功",
    "添加失败"];
                                                                                                                                
function testUser(){
    let sUserName=localStorage.getItem("userName");
    if(sUserName==undefined){
        localStorage.setItem("userName","test1"); 
    }
}

function getLists(){
    
    $.getJSON("src/server/getMessageList.php",function(res){
        console.log(res);
        let str="";
        $(".list").append("<ul></ul>");
        $.each(res, function(i, obj){
            str="<span class='title'>"+obj.user + "</span>" + "<span class='text'><br/>"+obj.text+ "</span>";
            $(".list ul").append("<li class='border shadow'>" + str + "</li>");
        });
        animateLis();
        
    });

}

function animateLis(){
    $(".list li").hide();
    intervals=0;
    $(".list li").each(function(i){
        
        $(this).delay(i*1000).fadeIn();
        intervals=i;
    });
    intervals=(intervals+1)*1000;
    setTimeout(addButton,intervals);
}

function addButton(){
    $(".list").append("<p class='margin_top_50 center'><button id='btnAdd' class='border shadow '>"+MESSAGES[1]+"</button></p>").slideDown();
}

function addPostToPage(){

    var key_name = localStorage.getItem("userName");  
    var content = localStorage.getItem(key_name);    
    str="<span class='title'>"+key_name + "</span>" + "<span class='text'><br/>"+content+ "</span>";
    $(".list ul").append("<li class='border shadow'>" + str + "</li>");
}
  
function savePostToStorage(value){  
    var num = new Object();
    num.key_name =localStorage.getItem("userName");  
    num.text = value.replace(/(^\s*)|(\s*$)/g, "");
  
    
   localStorage.setItem(num.key_name,num.text);  
   $.post("src/server/saveMessage.php",{"name":num.key_name,"text":num.text},function(res){
        console.log(res);
        if(res=="1")
            alert(MESSAGES[3]);
        else
            alert(MESSAGES[4]);
   });
   
}



$(document).on("click","#btnAdd",function(e){
    if( $("#btnAdd").text()==MESSAGES[1]){
        $(".form").show();
        $("#btnAdd").text(MESSAGES[2]);
    }else{
        $(".form").hide();
        $("#btnAdd").text(MESSAGES[1]);

        savePostToStorage($("#post_text").val());
        addPostToPage();
        $("#post_text").val("");
    }
        
});

//init
function init(){
    if(typeof(Storage)=="undefined")
    {
        document.getElementById("result").innerHTML=MESSAGES[0];
    }else{
        testUser();
        getLists();
    }
}

init();

        