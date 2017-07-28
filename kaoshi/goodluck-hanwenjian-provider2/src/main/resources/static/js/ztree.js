
var setting = {
    callback: {
        beforeClick: beforeClick
    },
    data : {
        key : {
            name : "tname",
            /* children : "Ztree" */
        },
        simpleData : {
            enable : true,
            idKey : "id",
            pIdKey : "tid",
            rootPId : 0
        }
    }

};
var zTree;
var treeNodes;

$(function() {
    $.ajax({
        async : false,
        cache : false,
        type : "post",
        dataType : "json",
        url : "../ztree",//请求的action路径
        error : function() {//请求失败处理函数
            alert('fail');
        },
        success : function(data) { //请求成功后处理函数。
            /* alert(data); */
            treeNodes = data; //把后台封装好的简单Json格式赋给treeNodes
        }
    });
    $.fn.zTree.init($("#treeDemo"), setting, treeNodes);

});
function beforeClick(treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj("treeDemo");
    if (treeNode.isParent) {
        zTree.expandNode(treeNode);
        return false;
    } else {
        var name = treeNode.name;
        var url = treeNode.url;
        /* alert(url); */
        return true;
    }

}

