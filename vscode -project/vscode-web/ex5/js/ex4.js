var INTERVAL = 2000;
var userAns = [];
var correctAns = {
    ans: "",
    analysis: "",
    isMulti: 0
    
}
function onTimeout() {
    $("#video")[0].pause();
    
    
    $.getJSON("data/questions.json", function (data) {
        var index = parseInt(Math.random() * 15);
        var obj = data[index];
        var str = "";
        $(".content").text(obj.content);

        str += "<ul>";
        if (obj.isMulti != 1) {
            if (obj.optionA != "") str += "<li><input type ='radio' value='A' name ='option'> A" + obj.optionA + "</li>"
            if (obj.optionB != "") str += "<li><input type ='radio' value='B' name ='option'> B" + obj.optionB + "</li>"
            if (obj.optionC != "") str += "<li><input type ='radio' value='C' name ='option'> C" + obj.optionC + "</li>"
            if (obj.optionD != "") str += "<li><input type ='radio' value='D' name ='option'> D" + obj.optionD + "</li>"
            if (obj.optionE != "") str += "<li><input type ='radio' value='E' name ='option'> E" + obj.optionE + "</li>"
            if (obj.optionF != "") str += "<li><input type ='radio' value='F' name ='option'> F" + obj.optionF + "</li>"

        }
        else {

            if (obj.optionA != "") str += "<li><input type ='checkbox' value='A' name ='option'> A" + obj.optionA + "</li>"
            if (obj.optionB != "") str += "<li><input type ='checkbox' value='B' name ='option'> B" + obj.optionB + "</li>"
            if (obj.optionC != "") str += "<li><input type ='checkbox' value='C' name ='option'> C" + obj.optionC + "</li>"
            if (obj.optionD != "") str += "<li><input type ='checkbox' value='D' name ='option'> D" + obj.optionD + "</li>"
            if (obj.optionE != "") str += "<li><input type ='checkbox' value='E' name ='option'> E" + obj.optionE + "</li>"
            if (obj.optionF != "") str += "<li><input type ='checkbox' value='F' name ='option'> F" + obj.optionF + "</li>"

        }
        str += "</ul";
        $(".option").append(str);
        $(".option input").click(onInputClick);
        $("#btnSubmit").click(onBtnSubmitClick);
        $("#result").hide();
        correctAns.ans = obj.ans;
        correctAns.analysis = obj.analysis;
        correctAns.isMulti = obj.isMulti;
        $("#refAns").text("参考答案" + obj.ans);
        $("#analysis").text("答案解析: " + obj.analysis);
        $(".do-question").show();
    });

}
function onInputClick() {
    if (correctAns.isMulti == 0) {
        userAns = [];
        userAns.push($(this).val());
    } else {

        if (userAns.indexOf($(this).val()) != -1)
            userAns.splice(userAns.indexOf($(this).val()), 1);
        else
            userAns.push($(this).val());
    }

}
function onBtnSubmitClick() {
    var ans = userAns.join("");
    if (ans == correctAns.ans) {
        $("#result").removeClass();
        $("#result").text("回答正确").addClass("green").show();
    }
    else {
        $("#result").removeClass();
        $("#result").text("回答错误").addClass("red").show();
        $("#video")[0].currentTimes = 1;

    }
    $(".ans").show();
    $("#close").click(onCloseClick);
}
function onCloseClick() {
    $("#video")[0].play();
    $(".do-question").hide();

    $("#close").off(onCloseClick);
    $(".option input").off(onInputClick);
    $("#btnSubmit").off(onBtnSubmitClick);z

}
function init() {
    $("#video")[0].play();
    setTimeout(onTimeout, INTERVAL);
}
init();