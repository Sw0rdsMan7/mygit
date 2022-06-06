/*
    function:期中测试
    author：周一班-XXX
    build-date：2022-4-18

    要求如下：
    1、根据截图“demo1.jpg”完成做题框的布局，结构自定，样式写在style.css下方，素材见images文件夹；
    2、页面加载后，请求data/questions.json文件并将内容显示到做题框中，做题框最开始不可见；
    3、页面加载后，生成一对随机数，并记录下索引值，记录在rndArr数组中；
    4、鼠标移动到卡片上后（mouseover事件），卡片的图像更换，如果卡片的索引值是rndArr数组中的索引值，加载paleNpc-card类，否则加载kidneyNpc-card类；
    5、卡片切换过程中应用了jQuery的淡入淡出的动画组合效果；
    6、鼠标移开卡片后（mouseout事件），如果为kidneyNpc-card类的卡片还原到初始状态，否则保留卡片上的内容，即不用还原卡片初始状态；
    7、当2张随机数索引值对应的卡片都翻出后，过1秒钟后淡入显示做题框；
    8、做题时，单击错误答案没有任何反应，单击正确答案出现答案解析等文字；
    9、做题过程中可随时关闭做题框，如果答案不正确，重新开始翻牌，规则从第2步到第8步；如果答案正确，保留2张翻开的卡片状态，鼠标移动到卡片上无反应。

    提醒：做题过程中需要及时注册或移除事件，需要做些初始化工作。


*/
var NUMS=15;  
var rndArr=[0,0];  //保存2个随机索引值

var refAns="";  //正确答案
var userAns="";  //用户选择答案

var findArr=[0,0];  


function loadQuestion(){
    $.getJSON("data/questions.json",function(data){

        refAns=data[0].ans;

        $("#content").text(data[0].content);
        $(".option-content").eq(0).text(data[0].optionA);
        $(".option-content").eq(1).text(data[0].optionB);
        $(".option-content").eq(2).text(data[0].optionC);
        $(".option-content").eq(3).text(data[0].optionD);
        $(".option-content").eq(4).text(data[0].optionE);
        $(".option-content").eq(5).text(data[0].optionF);
        $(".value").eq(0).text(data[0].ans);
        $(".value").eq(1).text(data[0].keyConcept);
        $(".value").eq(2).text(data[0].level);

        $(".buttons").hide();
        $(".option-item input").on("click",onOptionClick);
        
    });
}

function initCard(){
    var rnd=parseInt(Math.random()*NUMS+1);
    rndArr[0]=rnd;
    rndArr[1]=NUMS*2-rnd+1;
    console.log(rndArr);
}
function showQuestion(){
    $(".do-question").fadeIn(200);
    $("#close").on("click",onCloseClick);
}

function findAll(){
    var ret=false;
    if(findArr[0]==1 && findArr[1]==1){
        ret=true;
    }
    return ret;
}

function onOptionClick(){
    userAns=$(this).val().toUpperCase();

    if(userAns==refAns){
        $(".buttons").fadeIn();
    }else{
        $(".buttons").hide();
        
    }
   
}

function onCloseClick(){
    if(userAns!=refAns){
        $("#matrix ul li").removeClass().addClass("card").on("mouseover",onLiMouseOver);
        initCard();
    }else{
        $(".buttons").hide();
    }
    for(let i=0;i<$(".option-item input").length;i++){
        $(".option-item input").eq(i).prop("checked",false);
    }
    userAns="";
    findArr=[0,0];
    $(".do-question").hide();

}



function onLiMouseOver(){
    var index=$(this).index()+1;
    $("#matrix ul li").off("mouseover");
    $(this).removeClass();
    if(index==rndArr[0]){
        $(this).addClass("paleNpc-card");
        $("#matrix ul li").on("mouseover",onLiMouseOver);
        $(this).off("mouseover");
        findArr[0]=1;
       
    }else if(index==rndArr[1]){
        $(this).addClass("paleNpc-card");
        $("#matrix ul li").on("mouseover",onLiMouseOver);
        $(this).off("mouseover");
        findArr[1]=1;  
    } 
    else{
        $(this).removeClass().addClass("kidneyNpc-card");
        $(this).on("mouseout",onLiMouseOut);
       
    }
   
    $(this).fadeOut(100).fadeIn(300);
    if(findAll()) {
        $("#matrix ul li").off("mouseover");
        setTimeout(showQuestion,1000);
    }
    
}

function onLiMouseOut(){
    $(this).removeClass().addClass("card");
    $("#matrix ul li").on("mouseover",onLiMouseOver);
    $(this).off("mouseout");
}
function init(){
   $("#matrix ul li").on("mouseover",onLiMouseOver);
   initCard(); 
   loadQuestion();
}

init();