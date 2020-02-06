function addBotton(){
    if (i<5) {
        var ddt=document.createElement("dt");
        ddt.setAttribute("class","items");
        var input2=document.createElement("input");
        var l=document.createElement("label");
        input2.setAttribute("type","text");
        input2.setAttribute("class","uploadinput");
        input2.setAttribute("name","label");

        ddt.appendChild(l);
        ddt.appendChild(input2);

        cont.appendChild(ddt);
        i++;}
    else window.alert("不可添加多于5个标签");
}
function delBotton(){
    if (i>1) {
        cont.removeChild(cont.lastChild);
        i--;
    }
    else{
        window.alert("至少应该有一个标签");
    }
}

function validate_required(field,alerttxt)
{
    with (field)
    {
        if (value==null||value=="")
        {alert(alerttxt);return false}
        else {return true}
    }
}

function  deal(){
    var labelList=document.getElementsByName("label");
    var labels="";
    for (var i=0;i<labelList.length;i++) {
        if (labelList[i].value!=null||labelList[i].value!="") {
            labels += "," + labelList[i].value;
        }
    }
    document.getElementById("labels").value=labels;

    if (validate_required(document.getElementById("title"),"标题不可为空!")==false)
    {
        document.getElementById("title").focus();
        return false;
    }
    if (validate_required(document.getElementById("content"),"内容不可为空!")==false)
    {
        document.getElementById("content").focus();
        return false;
    }
    return true;
}