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
            result = res
            for (var i = 0; i < res.length; i++) {
                var a = document.createElement("button");
                a.setAttribute("id", "meat" + i)
                a.setAttribute("value", i)
                var node = document.createTextNode(res[i].mname);
                a.appendChild(node)
                document.getElementById("foodli")
                    .appendChild(a)
                var b = document.getElementById("meat" + i)
                b.setAttribute("onclick", "changeCP(this.value)")
                document.getElementById("foodli")
                    .append(document.createElement("br"))

            }
        }
    })
}

function changeCP(i) {

    document.getElementById("meatli").innerHTML = "";
    var info = document.createElement("p");
    var nodeinfo = document.createTextNode("风味：" + result[i].mstyle + "   每份" + result[i].mprice + "元" + "    评分：" + result[i].mscore);
    info.appendChild(nodeinfo)
    document.getElementById("meatli")
        .appendChild(info)

    var pic = document.createElement("img");
    pic.setAttribute("id","img"+i)
    pic.setAttribute("src", result[i].mpicture)
    document.getElementById("meatli")
        .appendChild(pic)

    var img=document.getElementById("img"+i)
    img.setAttribute("width","100 px")
    img.setAttribute("height","100 px")











    var jian = document.createElement("button");
    jian.setAttribute("id", "num-jian")
    var nodejian = document.createTextNode("-");
    jian.appendChild(nodejian)
    document.getElementById("meatli")
        .appendChild(jian)

    var numtext = document.createElement("input");
    numtext.setAttribute("id", "num")
    numtext.setAttribute("type", "text")
    numtext.setAttribute("value", "0")
    document.getElementById("meatli")
        .appendChild(numtext)

    var jia = document.createElement("button");
    jia.setAttribute("id", "num-jia")
    var nodejia = document.createTextNode("+");
    jia.appendChild(nodejia)
    document.getElementById("meatli")
        .appendChild(jia)

    var input_num = document.getElementById("num");
    document.getElementById("num-jia").onclick = function () {

        input_num.value = parseInt(input_num.value) + 1;
        input_num.setAttribute("value",input_num.value)
    }

    document.getElementById("num-jian").onclick = function () {

        if(input_num.value <= 0) {
            input_num.value = 0;
        } else {

            input_num.value = parseInt(input_num.value) - 1;
            input_num.setAttribute("value",input_num.value)
        }
    }

    var incar = document.createElement("button");

    incar.setAttribute("id", "incar")
    var nodeincar = document.createTextNode("加入购物车");
    incar.appendChild(nodeincar)
    document.getElementById("meatli")
        .appendChild(incar)
    document.getElementById("incar")

    incar.onclick=function(){
        var str = {"mid": result[i].mid,"number":num.value}
        $.ajax({
            url: '/incar',
            type: 'post',
            data: str,
            success: function (res) {
                alert(res)
            }

        })
    }
    document.getElementById("meatli")
        .append(document.createElement("br"))


}


