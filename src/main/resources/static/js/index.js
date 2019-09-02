//页面加载完执行
window.onload=function(){
    /*alert("欢迎光临");*/
}
//声明式函数 调用执行
//查看当前时间
function Dates(){
    document.getElementById("Dates").value=Date();
}
//更换图片
function changeImage(t){
    var pic_bulboff="Practice/JavaScript/img/pic_bulboff.gif";
    var pic_bulbon="Practice/JavaScript/img/pic_bulbon.gif";
    t.src=t.src.match("bulbon") ? pic_bulboff : pic_bulbon;//match:检索src路径里面有没有bulbon这个字符串，有就变为另一个
}


function testdd(e){
    /*alert(e.src)*/
    document.getElementById("ImagesShows").innerHTML="<img src='"+ e.src +"' width='100%'>"
}