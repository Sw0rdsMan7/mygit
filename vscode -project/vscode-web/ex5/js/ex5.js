/*
	Functions  :ex5
	Author    :zjvivi
	Build_Date:2022-3-15
	Version   :1.0
 */
//=========================================================================

// ==============常量============================

var VIDEO_WIDTH=1244;
var VIDEO_HEIGHT=640;
var VIDEO_PATH="video/demo.mp4";

var INTERVAL=2000;  //做题时间，从视频开始播放INTERVAL秒后

var CORRECT_TEXT="回答正确";
var ERROR_TEXT="回答错误";
var QUESTION_JSON="data/questions.json";
//=========================变量定义区=======================================


var flag = 0;
var lastTime = + new Date();
var finished=0;  //控制是否出现题目，0出现，1不出现

// var currentNo=1;
var userAns=[""];  //可能为多选
var currentQuestionInfo=[
    "b",  //"ans"
    "",   //"analysis":
    "",   //"keyConcept":
    "",   // "level":
    0     //"isMulti":
];
var questionNums=0;
var video=document.createElement("video");

var questionArr;

//=========================变量定义区 end=======================================

//=========================函数定义区=======================================


function getQuestionMaps(){
    $.getJSON(QUESTION_JSON,function(data){
        questionNums=addQuestionToPage(data);
        flag++;
        if(flag==2) video.play();
    });
    
}

function addQuestionToPage(data){
    var items = [];
    var str="";
    var iCount=0;
   
    $.each(data, function(index,obj) {
        //console.log(obj);
        str="<ul id='"+obj.id+"'>";
        $.each(obj,function(key,value){
            if(key!=="id")
                str+= "<li data-item='" + key + "'>" + value + "</li>" ;
            // console.log(key,":",value);
        });
        str+="</ul>";
        items.push(str);
        iCount++;
    });
   
    $( "<div/>", {
      "class": "question-list",
      html: items.join( "" )
    }).appendTo(".container");
    
    return iCount;

}


function setQuestionToPanel(index){
    let str="";
    let arr=["A","B","C","D","E","F"];
    let question=$(".question-list ul[id='"+index+"']").children();
    $(".do-question .content h1").text($(question).eq(0).text());
    for(let i=0;i<arr.length;i++){
        if($(question).eq(i+1).text()!=""){
            str+="<li class='option-item'>";
            if($(question).eq(11).text()!="1")  //isMulti=1为多选题
                str+="<input id='option"+arr[i]+"' type='radio' name='options' value='"+arr[i]+"' class='option-check'>";
            else
                str+="<input id='option"+arr[i]+"' type='checkbox' name='options' value='"+arr[i]+"' class='option-check'>";
            str+="<label for='option"+arr[i]+"' class='option-label'>"+arr[i]+"  "+$(question).eq(i+1).text()+"</label>";
            str+="</li>";
        } 
    }

    for(let i=7;i<=11;i++){  //第i=7项开始,正确答案、题目解析等
        currentQuestionInfo[i-7]=$(question).eq(i).text();
    }
    $(".do-question .operation ul").eq(0).html(str);              
  
}



function doQuestion(e){
    let index=parseInt(questionNums*Math.random()+1);

    currentQuestionInfo=[];
    setQuestionToPanel(index);
    $("#close").on("click",onCloseClick);
    $("body").bind("click",".option-check",onOptionClick);
    $("#btnOk").on("click",onQuestionSubmitClick);
    $(".do-question").show();
}

function onOptionClick(){
    
    let isExisted=0;
    let arr;
    arr=$(".option-check");
    userAns=[];
    for(let i=0;i<arr.length;i++){
        if(arr[i].checked) userAns.push(arr[i].value);
    }  
    console.log(userAns); 
}
function onQuestionSubmitClick(){
    let ans=userAns.join("").toLowerCase();
    
    $("#refAns").text(currentQuestionInfo[0]);
    $("#refAnlysis").text(currentQuestionInfo[1]);
    $(".ans").css("visibility","visible");
    
    $("#btnOk").hide();
    // console.log(ans,currentQuestionInfo[0].toLowerCase());
    if(ans===currentQuestionInfo[0].toLowerCase()) {

       $("#result").addClass("green");
       $("#result").text(CORRECT_TEXT);
    }     
    else{
        video.currentTime=1;
        finished=0;
        $("#result").addClass("red");
        $("#result").text(ERROR_TEXT);
    }
   
}



function onCloseClick(){
    var now= + new Date();

    $(".ans").css("visibility","hidden");
    $("#btnOk").show();
    $(".do-question").hide();
    $("#result").text("");
    userAns=[];
    $("#close").off("click");
    $("body").off("click");
    $("#btnOk").off("click");
    flag=2;
    video.play();
    lastTime=now;
    requestNextAnimationFrame(animate);    
}

function animate(){
    var now= + new Date();

    if(flag==2){  //1表示视频或题目准备好，2表示两者都ok
       
        if(!finished && (now-lastTime)>INTERVAL){
            video.pause();
            flag=3;
            doQuestion(); 
            finished=1;
        }else{
            requestNextAnimationFrame(animate);
        }   
    }
    
}
function onVideoCanplay(){
    flag++;
    requestNextAnimationFrame(animate);  //开始播放视频
    if(flag==2) video.play();
   
}

function init() {
    //init，此块内容如非必要，请勿修改
    $(".container").eq(0).append(video);
    video.src=VIDEO_PATH;
    video.oncanplay=onVideoCanplay;
    
    getQuestionMaps();
    
}

//=========================函数定义区 end=======================================

