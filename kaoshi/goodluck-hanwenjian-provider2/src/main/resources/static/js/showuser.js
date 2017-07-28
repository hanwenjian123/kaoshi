$(document).ready(function () {
    /* $("#but").click(function () {*/
    $("button[name='but']").click(function () {
        var da = $(this).attr("id");
        alert(da)
        url = "updateuser";
        ajaxPost(url, da);
    });
});

function ajaxPost(url, da) {
    $.ajax({
        url: url,
        data: {"uid": 2},
        type: "POST",
        dataType: "json",
        success: function (data) {
            alert(data.uname)
            $("#uid").val(data.uid)
            $("#name1").val(data.uname);
            $("#pwd1").val(data.upwd);
        }
    });


}

/*  user_role 查询 */
$(document).ready(function () {
    $("button[name='urbut']").click(function () {
        var da = $(this).attr("id");
        $('#urid').val(da);
        url = "/role/ur";
        ajaxUr(url);
    });
});

function ajaxUr(url) {
    $.ajax({
        url: url,
        async: false,
        type: "GET",
        dataType: "json",
        success: function (data) {
            var htmlStr = "";
            $.each(data, function (i, role) {
                htmlStr += " <label> <input id=" + role.rId + " type='checkbox' name='rid'  value=" + role.rId + " /></label>" + role.rName;
            });
            $('#roleSel').html(htmlStr);
        }
    });
}


