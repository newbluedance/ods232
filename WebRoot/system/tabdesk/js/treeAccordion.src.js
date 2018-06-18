var zTree_Menu = null;
var setting = {
    view: {
        fontCss: getFontCss,
        showLine: false,
        selectedMulti: false,
        dblClickExpand: false
    },
    callback: {
        beforeClick: beforeClick,
        onClick: onClick
    }
};
$(function () {
    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
    $("#searchKey").keydown(function (a) {
        if (a.keyCode == 13) {
            findNode()
        }
    })
});

function showContent() {}

function beforeClick(d, c) {
    if (c.level === 0) {
        $("#" + d).find("a").each(function () {
            if ($(this).hasClass("cur")) {
                $(this).removeClass("cur")
            }
        });
        var b = $("#" + c.tId + "_a");
        b.addClass("cur");
        if (c.open) {
            zTree_Menu.expandNode(c, false);
            var b = $("#" + c.tId + "_a");
            b.removeClass("cur");
            b.removeClass("curSelectedNode")
        } else {
            zTree_Menu.expandAll(false);
            zTree_Menu.expandNode(c)
        }
    } else {
        zTree_Menu.expandNode(c)
    }
}

function onClick(c, b, a) {
    if (a.link != null) {
        tabAddHandler(a.id, a.name, a.link)
    }
}

function showAll() {
    zTree_Menu.expandAll(true)
}

function hideAll() {
    zTree_Menu.expandAll(false);
    jQuery.jCookie("leftTreeNodeId", "false")
}

function findNode() {
    var a = $.trim($("#searchKey").val());
    if (a != "") {
        getNodesByParamFuzzy("name", a)
    }
}

function getNodesByParamFuzzy(d, e, a) {
    var b = zTree_Menu.getNodesByParamFuzzy(d, e, a);
    highlightNodes(zTree_Menu, zTree_Menu.highlightNodeList, false);
    highlightNodes(zTree_Menu, b, true);
    zTree_Menu.highlightNodeList = b;
    if (null != b && b.length > 0) {
        zTree_Menu.expandAll(false);
        var c = b[0].getParentNode();
        zTree_Menu.expandNode(c, true);
        zTree_Menu.expandNode(b[0], true)
    }
}

function getNodesByParam(d, e, a) {
    var b = zTree_Menu.getNodesByParam(d, e, a);
    highlightNodes(zTree_Menu, zTree_Menu.highlightNodeList, false);
    highlightNodes(zTree_Menu, b, true);
    zTree_Menu.highlightNodeList = b;
    if (null != b && b.length > 0) {
        var c = b[0].getParentNode();
        if (!c.open) {
            zTree_Menu.expandAll(false);
            zTree_Menu.expandNode(c, true)
        }
    }
}

function highlightNodes(d, c, b) {
    if (null == c) {
        return
    }
    for (var e = 0, a = c.length; e < a; e++) {
        c[e].highlight = b;
        d.updateNode(c[e])
    }
}

function getFontCss(b, a) {
    return ( !! a.highlight) ? {
        color: "#A60000",
        "font-weight": "bold"
    } : {
        color: "#333",
        "font-weight": "normal"
    }
}

function homeHandler() {
    zTree_Menu.expandAll(false)
};