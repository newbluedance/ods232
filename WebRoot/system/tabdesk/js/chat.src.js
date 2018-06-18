var nodes2 = [{
    id: 1,
    parentId: 0,
    name: "部门1",
    icon: "../../libs/icons/user_group.gif",
    drag: false,
    open: true
}, {
    id: 11,
    parentId: 1,
    name: "员工1",
    icon: "../../libs/icons/user.gif",
    drop: false
}, {
    id: 12,
    parentId: 1,
    name: "员工2",
    icon: "../../libs/icons/user_female.gif",
    drop: false
}, {
    id: 13,
    parentId: 1,
    name: "员工3",
    icon: "../../libs/icons/user_worker.gif",
    drop: false
}, {
    id: 14,
    parentId: 1,
    name: "员工4",
    icon: "../../libs/icons/user_off.gif",
    drop: false
}, {
    id: 15,
    parentId: 1,
    name: "员工5",
    icon: "../../libs/icons/user.gif",
    drop: false
}, {
    id: 16,
    parentId: 1,
    name: "员工6",
    icon: "../../libs/icons/user_off.gif",
    drop: false
}, {
    id: 17,
    parentId: 1,
    name: "员工7",
    icon: "../../libs/icons/user.gif",
    drop: false
}, {
    id: 18,
    parentId: 1,
    name: "员工8",
    icon: "../../libs/icons/user_worker.gif",
    drop: false
}, {
    id: 2,
    parentId: 0,
    name: "部门2",
    icon: "../../libs/icons/user_group.gif",
    drag: false,
    open: true
}, {
    id: 21,
    parentId: 2,
    name: "员工9",
    icon: "../../libs/icons/user.gif",
    drop: false
}, {
    id: 22,
    parentId: 2,
    name: "员工10",
    icon: "../../libs/icons/user_female.gif",
    drop: false
}, {
    id: 23,
    parentId: 2,
    name: "员工11",
    icon: "../../libs/icons/user_worker.gif",
    drop: false
}, {
    id: 24,
    parentId: 2,
    name: "员工12",
    icon: "../../libs/icons/user_off.gif",
    drop: false
}, {
    id: 25,
    parentId: 2,
    name: "员工13",
    icon: "../../libs/icons/user.gif",
    drop: false
}, {
    id: 26,
    parentId: 2,
    name: "员工14",
    icon: "../../libs/icons/user_off.gif",
    drop: false
}, {
    id: 3,
    parentId: 0,
    name: "部门3",
    icon: "../../libs/icons/user_group.gif",
    drag: false,
    open: true
}, {
    id: 31,
    parentId: 3,
    name: "员工15",
    icon: "../../libs/icons/user.gif",
    drop: false
}, {
    id: 32,
    parentId: 3,
    name: "员工16",
    icon: "../../libs/icons/user_female.gif",
    drop: false
}, {
    id: 33,
    parentId: 3,
    name: "员工17",
    icon: "../../libs/icons/user_off.gif",
    drop: false
}, {
    id: 34,
    parentId: 3,
    name: "员工18",
    icon: "../../libs/icons/user_off.gif",
    drop: false
}];
var setting2 = {
    edit: {
        enable: true,
        showRemoveBtn: false,
        showRenameBtn: false,
        drag: {
            prev: false,
            next: false
        }
    },
    view: {
        fontCss: getFontCss2,
        dblClickExpand: false
    },
    callback: {
        beforeDrag: beforeDrag,
        beforeDrop: beforeDrop,
        onDrag: onDrag,
        onClick: onNodeClick,
        onDblClick: onNodDblClick
    }
};
var zTree_Menu2;
$(function () {
    $.fn.zTree.init($("#treeDemo2"), setting2, nodes2);
    zTree_Menu2 = $.fn.zTree.getZTreeObj("treeDemo2");
    $("#searchKey").keydown(function (b) {
        if (b.keyCode == 13) {
            findNode()
        }
    });
    var a = 0;
    $("#topArr").toggle(function () {
        chatMainShow = true;
        $("#chat_main").animate({
            right: 0 + "px"
        }, function () {
            $("#chat_main").height(402);
            $("#chat_main").css("bottom", -402 + 30);
            $("#chat_main").animate({
                bottom: a + "px"
            })
        });
        $("#icon_arr").removeClass("img_btn_up");
        $("#icon_arr").addClass("img_btn_down");
        return false
    }, function () {
        chatMainShow = false;
        $("#chat_main").animate({
            bottom: -402 + 30 + "px"
        }, function () {
            $("#chat_main").animate({
                right: -190 + "px"
            }, function () {
                $("#chat_main").height(30);
                $("#chat_main").css("bottom", 0)
            })
        });
        $("#icon_arr").removeClass("img_btn_down");
        $("#icon_arr").addClass("img_btn_up");
        return false
    })
});

function onNodeClick(a, c, b) {
    zTree_Menu2.expandNode(b)
}

function beforeDrag(d, c) {
    for (var b = 0, a = c.length; b < a; b++) {
        if (c[b].drag === false) {
            return false
        }
    }
    return true
}

function beforeDrop(c, b, d, a) {
    return d ? d.drop !== false : true
}

function onDrag(a, c, b) {
    zTree_Menu2.expandAll(false)
}

function findNode2() {
    var a = $.trim($("#searchKey").val());
    if (a != "") {
        getNodesByParamFuzzy2("name", a)
    }
}

function getNodesByParamFuzzy2(d, e, a) {
    var b = zTree_Menu2.getNodesByParamFuzzy(d, e, a);
    highlightNodes2(zTree_Menu2, zTree_Menu2.highlightNodeList, false);
    highlightNodes2(zTree_Menu2, b, true);
    zTree_Menu2.highlightNodeList = b;
    if (null != b && b.length > 0) {
        zTree_Menu2.expandAll(false);
        var c = b[0].getParentNode();
        zTree_Menu2.expandNode(c, true);
        zTree_Menu2.expandNode(b[0], true)
    }
}

function highlightNodes2(d, c, b) {
    if (null == c) {
        return
    }
    for (var e = 0, a = c.length; e < a; e++) {
        c[e].highlight = b;
        d.updateNode(c[e])
    }
}

function getFontCss2(b, a) {
    return ( !! a.highlight) ? {
        color: "#A60000",
        "font-weight": "bold"
    } : {
        color: "#333",
        "font-weight": "normal"
    }
}

function viewInfo() {
    top.Dialog.open({
        URL: "../../sample_skin/normal/user-management-content2.html",
        Title: "查看信息",
        MinToTask: true,
        ID: "viewinfo",
        Width: 500,
        Height: 330,
        Modal: false,
        ResizeResetPosition: false,
        ShowMinButton: true
    })
}

function onNodDblClick(a, c, b) {
    if (!b.isParent) {
        var d = new top.Dialog();
        d.ID = b.id;
        d.Title = "协同：" + b.name;
        d.URL = "include/chat.html";
        d.ShowButtonRow = true;
        d.OkButtonText = " 发 送 ";
        d.CancelButtonText = " 关 闭 ";
        d.Modal = false;
        d.ResizeResetPosition = false;
        d.Width = 530;
        d.Height = 390;
        d.ShowMinButton = true;
        d.ShowMaxButton = true;
        d.MinToTask = true;
        d.OKEvent = function () {
            d.innerFrame.contentWindow.setUserName("张小三");
            d.innerFrame.contentWindow.chatHandler()
        };
        d.show()
    }
}

function addFriend() {
    top.Dialog.open({
        URL: "include/add.html",
        Title: "添加好友",
        MinToTask: true,
        ID: "addfriend",
        Width: 300,
        Height: 180,
        Modal: false,
        ResizeResetPosition: false,
        ShowMinButton: true
    })
}
var nodeid = 100;

function addFriendHandler(b, e) {
    var d = parseInt(b);
    var c = zTree_Menu2.getNodeByParam("id", d);
    if (c) {
        d++;
        var a = {
            id: d,
            name: e,
            icon: "../../libs/icons/user.gif",
            drop: false
        };
        zTree_Menu2.expandNode(c, true);
        zTree_Menu2.addNodes(c, a)
    }
}

function searchRoom() {
    top.Dialog.open({
        URL: "include/room.html",
        Title: "搜索聊天室",
        Width: 400,
        Height: 260,
        Modal: false,
        MinToTask: true,
        ID: "searchroom",
        ResizeResetPosition: false,
        ShowMinButton: true
    })
};