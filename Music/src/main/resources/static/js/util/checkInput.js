function checkInput(){
    debugger
    var inputNodes = document.getElementsByClassName("form-control");

    for(var i=0;i<inputNodes.length;i++){
        if(inputNodes[i].value === ""){
            console.log("存在空值")
            return false;
        }
    }
    return true;
}

function clearInput(){
    console.log("清除输入...");
}