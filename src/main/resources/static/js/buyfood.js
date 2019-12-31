var result
function changeCZ(fid) {
    var str = {"id": fid}
    $.ajax({
        url: '/changeCZ',
        type: 'post',
        data: str,
        success: function (res) {
            document.getElementById("foodli").innerHTML = "";
            document.getElementById("meatli").innerHTML = "";
            result=res
            for (var i = 0; i < res.length; i++) {
                var a = document.createElement("button");
                a.setAttribute("id","meat"+i)
                a.setAttribute("value",i)
                var node = document.createTextNode(res[i].mname);
                a.appendChild(node)
                document.getElementById("foodli")
                    .appendChild(a)
                var b=document.getElementById("meat"+i)
                b.setAttribute("onclick","changeCP(this.value)")
                document.getElementById("foodli")
                    .append(document.createElement("br"))

            }
        }
    })
}

function changeCP(i) {

    document.getElementById("meatli").innerHTML = "";

    var b = document.createElement("p");
    var nodea = document.createTextNode("风味："+result[i].mstyle+"   每份" + result[i].mprice + "元"+"    评分："+result[i].mscore);
    b.appendChild(nodea)
    document.getElementById("meatli")
        .appendChild(b)

    var c = document.createElement("img");
    c.setAttribute("src", result[i].mpicture)
    document.getElementById("meatli")
        .appendChild(c)

    var c = document.createElement("button");
    c.setAttribute("onclick", "#")
    var nodeb = document.createTextNode("加入购物车");
    c.appendChild(nodeb)
    document.getElementById("meatli")
        .appendChild(c)

    document.getElementById("meatli")
        .append(document.createElement("br"))


}

