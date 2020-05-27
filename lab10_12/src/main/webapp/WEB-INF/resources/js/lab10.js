var TIME_WAIT = 400;
var t_send = new Date();

function autocomplete(inp_name, resource_url) {
    var inp = document.getElementById(inp_name);
    var currentFocus;
    var h;

    h = document.createElement("input");
    h.setAttribute("type", "hidden");
    h.setAttribute("name", inp.getAttribute("name") + "_id");
    h.setAttribute("id", inp.getAttribute("id") + "_id");
    inp.parentNode.appendChild(h);


    inp.parentNode.addEventListener("focusout", function () {
        console.log("focusout");
        e = document.getElementById(inp.id + "_id").value;
        if (!e || e == '') inp.value = '';
    });


    inp.addEventListener("input", function (e) {
        var a, b, i, val = this.value;
        var element = this;
        document.getElementById(inp.id + "_id").value = '';
        closeAllLists();
        if (!val) {
            return false;
        }
        currentFocus = -1;

        if (t_send != 0) {
            t_send = 0;
            setTimeout(function () {
                t_send = new Date();
                getarr(inp, element, resource_url);
            }, TIME_WAIT);
        }
    });

    inp.addEventListener("keydown", function (e) {
        var x = document.getElementById(this.id + "autocomplete-list");
        if (x) x = x.getElementsByTagName("div");
        if (e.keyCode == 40) {
            addActive(x);
        } else if (e.keyCode == 38) {
            addActive(x);
        } else if (e.keyCode == 13) {
            e.preventDefault();
            if (currentFocus > -1) {
                if (x) x[currentFocus].click();
            }
        } else if (e.keyCode == 27) {
            closeAllLists();
        }
    });

    function findinarrbyid(id, arr) {
        var res;
        for (i = 0; i < arr.length; i++) {
            if (arr[i]["id"] == id) {
                res = arr[i]["name"];
                break;
            }
        }
        return res;
    }

    function addActive(x) {
        if (!x) return false;
        removeActive(x);
        if (currentFocus >= x.length) currentFocus = 0;
        if (currentFocus < 0) currentFocus = (x.length - 1);
        x[currentFocus].classList.add("autocomplete-active");
    }

    function removeActive(x) {
        for (var i = 0; i < x.length; i++) {
            x[i].classList.remove("autocomplete-active");
        }
    }

    function closeAllLists(elmnt) {
        var x = document.getElementsByClassName("autocomplete-items");
        for (var i = 0; i < x.length; i++) {
            if (elmnt != x[i] && elmnt != inp) {
                x[i].parentNode.removeChild(x[i]);
            }
        }
    }

    function getarr(inp, element, resource_url) {
        var a, b, i, name = inp.value, val = inp.value;
        var t_s = new Date();

        var xhr = new XMLHttpRequest();
        xhr.open("POST", resource_url, true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
        var params = 'name=' + encodeURIComponent(name);

        xhr.onreadystatechange = function () {
            if ((xhr.status == 200) && (xhr.readyState == 4)) {
                var dict_values = JSON.parse(xhr.response);

                a = document.createElement("DIV");
                a.setAttribute("id", inp.id + "autocomplete-list");
                a.setAttribute("class", "autocomplete-items");
                element.parentNode.appendChild(a);
                for (i = 0; i < dict_values.length; i++) {
                    b = document.createElement("DIV");
                    var p = 0;
                    p = dict_values[i]['name'].toUpperCase().indexOf(val.toUpperCase());
                    b.innerHTML = '';
                    if (p > 0) b.innerHTML = dict_values[i]['name'].substr(0, p); else p = 0;
                    b.innerHTML += "<strong>" + dict_values[i]['name'].substr(p, val.length) + "</strong>";
                    b.innerHTML += dict_values[i]['name'].substr(p + val.length);
                    b.innerHTML += "<input type='hidden' value='" + dict_values[i]["id"] + "'>";
                    b.addEventListener("click", function (e) {
                        console.log("click");
                        inp.value = findinarrbyid(this.getElementsByTagName("input")[0].value, dict_values);
                        document.getElementById(inp.id + "_id").value = this.getElementsByTagName("input")[0].value;
                        closeAllLists();
                    });
                    a.appendChild(b);
                }

            } else {
            }
        };

        xhr.send(params);
    }

    document.addEventListener("click", function (e) {
        closeAllLists(e.target);
    });
}


function formatDate(d) {
    return d.getDate() + '.' + d.getMonth() + '.' + d.getFullYear();
}