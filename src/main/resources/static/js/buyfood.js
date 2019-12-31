function changeCZ(fid) {
    var str  = {"id":fid}
    $.ajax({
        url:'/changeCZ',
        type:'post',
        data:str,
        success:function (res) {
            document.getElementById("meatli").innerHTML = "";
            for (var i = 0; i < res.length; i++) {

                var a = document.createElement("button");
                a.setAttribute("onclick","#")
                var node = document.createTextNode("link");
                a.appendChild(node)
                document.getElementById("meatli")
                    .appendChild(a)

                document.getElementById("meatli")
                    .append(document.createElement("br"))

            }
        }
    })
}

function changeCP(fid) {
    var str  = {"id":fid}
    $.ajax({
        url:'/changeCZ',
        type:'post',
        data:str,
        success:function (res) {
            document.getElementById("meatli").innerHTML = "";
            for (var i = 0; i < res.length; i++) {

                var a = document.createElement("button");
                a.setAttribute("onclick","#")
                var node = document.createTextNode("link");
                a.appendChild(node)
                document.getElementById("meatli")
                    .appendChild(a)

                document.getElementById("meatli")
                    .append(document.createElement("br"))

            }
        }
    })
}

