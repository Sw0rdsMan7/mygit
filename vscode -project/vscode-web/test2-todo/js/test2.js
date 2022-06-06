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

var rndArr=[0,0];  //保存2个随机索引值

var refAns="";  //正确答案
var userAns="";  //用户选择答案



//页面加载后调用init函数
function init(){
    $.getJSON("data/questions.json", function (data){
        rndArr[0]=parseInt(Math.random()*2);
        rndArr[1]=parseInt(Math.random()*2);
        var obj = data[index]; 
        $(".content").text(obj.content);
        str += "<ul>";
            if (obj.optionA != "") str += "<li><input type ='radio' value='A' name ='option'> A" + obj.optionA + "</li>"
            if (obj.optionB != "") str += "<li><input type ='radio' value='B' name ='option'> B" + obj.optionB + "</li>"
            if (obj.optionC != "") str += "<li><input type ='radio' value='C' name ='option'> C" + obj.optionC + "</li>"
            if (obj.optionD != "") str += "<li><input type ='radio' value='D' name ='option'> D" + obj.optionD + "</li>"
            if (obj.optionE != "") str += "<li><input type ='radio' value='E' name ='option'> E" + obj.optionE + "</li>"
            if (obj.optionF != "") str += "<li><input type ='radio' value='F' name ='option'> F" + obj.optionF + "</li>"
        str += "</ul";
        $(".option").append(str);
    })
}

init();