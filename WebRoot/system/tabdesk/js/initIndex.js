function tabAddHandler(a, b, c) {
    tab.add({
        id: a,
        title: b,
        url: c,
        isClosed: !0,
        iframeAddtion: 'style="background-color:#ffffff"'
    }), tab.activate(a)
}

function backHome() {
    tabAddHandler("desk_index", "导航首页", "system/tabdesk/desk.jsp")
}

function resizeHandler() {
    document.documentElement.clientWidth;
    var b = document.documentElement.clientHeight;
    $("#page").height(b - 31 - 30 - taskBarHeight), $("#leftMenu").height(b - 31 - 30 - taskBarHeight), $("#spliter").height(b - 31 - 30 - taskBarHeight), $("#allIconContainer").height(b)
}
var tab, zNodes = [{
		id: 3001,
        parentId: 0,
        name: "集装箱监管"
    }, {
        id: "1-9",
        parentId: 3001,
        name: "入境查验放行",
        link: "../../pages/集装箱监管/入境查验放行.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "1-9-2",
        parentId: 3001,
        name: "集装箱放行记录",
        link: "../../pages/集装箱监管/集装箱放行记录.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
		id: 3002,
        parentId: 0,
        name: "移动查验"
	}, {
		id: "1-10-1",
        parentId: 3002,
        name: "移动查验",
        link: "../../pages/移动查验/移动查验index.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
	}, {
        id: 3003,
        parentId: 0,
        name: "旅客监管"
    }, {
        id: "1-15-1",
        parentId: 3003,
        name: "调查记录",
        link: "/travellerCheck/survey",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "1-15-2",
        parentId: 3003,
        name: "排查登记",
        link: "travellerCheck/investigation",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "skin/titlebar_arrow.gif"
    }, {
        id: "1-15-3",
        parentId: 3003,
        name: "采样登记",
        link: "travellerCheck/getSample",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "1-15-4",
        parentId: 3003,
        name: "送样登记",
        link: "travellerCheck/sendSample",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "skin/titlebar_arrow.gif"
    }, {
        id: 3004,
        parentId: 0,
        name: "旅客携带物"
    }, {
        id: "1-16-1",
        parentId: 3004,
        name: "旅客携带物",
        link: "../../pages/旅客携带物/table-pop-content-xdw.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "1-16-2",
        parentId: 3004,
        name: "排查登记",
        link: "../../pages/旅客携带物/table-pop-content-xdw.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "skin/titlebar_arrow.gif"
    }, {
        id: 3005,
        parentId: 0,
        name: "伴侣宠物"
    }, {
        id: "1-17-1",
        parentId: 3005,
        name: "伴侣宠物",
        link: "../../pages/伴侣宠物/blcw.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: 3006,
        parentId: 0,
        name: "航空器监管"
    }, {
        id: "1-18",
        parentId: 3006,
        name: "航空器监管",
        link: "../../pages/航空器监管/hkqjg.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
		id: 3007,
        parentId: 0,
        name: "赛马监管"
	}, {
		id: "1-1-1",
        parentId: 3007,
        name: "赛马备案",
        link: "./horse/toHorseList.action",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
	}, {
		id: "1-1-2",
        parentId: 3007,
        name: "赛马检查",
        link: "./horse/toHorseCheckList.action",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
	}, {
        id: "1-1-3",
        parentId: 3007,
        name: "异常处理",
        link: "./horse/toHorseAbnormalList.action",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "1-1-4",
        parentId: 3007,
        name: "饲料，添加剂使用记录",
        link: "./horseFodder/toHorseFodderList.action",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
		id: 3008,
        parentId: 0,
        name: "航空配餐"
	}, {
		id: "2-1-1",
        parentId: 3008,
        name: "企业备案",
        link: "./catering/toHorseCompanyList.action",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
	}, {
		id: "2-1-2",
        parentId: 3008,
        name: "配餐申请",
        link: "./catering/toHorseCompanyList.action",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
	}, {
		id: "2-1-3",
        parentId: 3008,
        name: "配餐审核",
        link: "./catering/toHorseCompanyList.action",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
	}, {
        id: "2-1-4",
        parentId: 3008,
        name: "修改企业信息",
        link: "./catering/toHorseCompanyList.action",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: 3009,
        parentId: 0,
        name: "邮检管理"
    }, {
        id: "2-2",
        parentId: 3009,
        name: "邮包查验",
        link: "../../pages/邮检管理/yjgl-1.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    },{
        id: "2-202",
        parentId: 3009,
        name: "邮包台账表",
        link: "../../pages/邮检管理/yjgl-2.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    },{
        id: "2-203",
        parentId: 3009,
        name: "查验结果登记表",
        link: "../../pages/邮检管理/yjgl-3.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "2-204",
        parentId: 3009,
        name: "邮袋统计",
        link: "../../pages/邮检管理/yjgl-4.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    },{
        id: "2-205",
        parentId: 3009,
        name: "邮包统计",
        link: "../../pages/邮检管理/yjgl-5.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    },{
        id: "2-206",
        parentId: 3009,
        name: "邮包批次",
        link: "../../pages/邮检管理/yjgl-6.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    },{
        id: "2-207",
        parentId: 3009,
        name: "禁止进境物",
        link: "../../pages/邮检管理/yjgl-7.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    },{
        id: 3010,
        parentId: 0,
        name: "查询统计"
    }, {
        id: "2-3",
        parentId: 3010,
        name: "入境查询统计",
        link: "../../pages/查询统计/table-pop-content-tj.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: 3021,
        parentId: 0,
        name: "综合查询"
    }, {
        id: "2-4",
        parentId: 3021,
        name: "综合查询",
        link: "../../sample_skin/normal/form-page.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "2-5",
        parentId: 3021,
        name: "部门管理",
        link: "../../sample_skin/normal/form-page.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "2-6",
        parentId: 3021,
        name: "职务管理",
        link: "../../sample_skin/normal/form-page.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "2-7",
        parentId: 3021,
        name: "角色管理",
        link: "../../sample_skin/normal/form-page.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "2-8",
        parentId: 3021,
        name: "用户管理",
        link: "../../sample_skin/normal/form-page.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "2-9",
        parentId: 3021,
        name: "菜单管理",
        link: "../../sample_skin/normal/form-page.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "2-10",
        parentId: 3021,
        name: "系统管理",
        link: "../../sample_skin/normal/form-page.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "2-11",
        parentId: 3021,
        name: "公告管理",
        link: "../../sample_skin/normal/form-page.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }, {
        id: "2-12",
        parentId: 3021,
        name: "用户导入",
        link: "../../sample_skin/normal/form-page.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    },{
        id: 3022,
        parentId: 0,
        name: "密码修改"
    }, {
        id: "2-13",
        parentId: 3022,
        name: "密码修改",
        link: "../../sample_skin/normal/form-page.html",
        iconOpen: "../../libs/icons/folder_doc.gif",
        iconClose: "../../libs/icons/folder_doc.gif",
        icon: "system/tabdesk/skin/titlebar_arrow.gif"
    }],
    taskBarShow = !1,
    taskBarHeight = 0,
    chatMainShow = !1,
    storeLoadedFlag = 0;
$(function () {
    tab = new TabView({
        containerId: "tab_menu",
        pageid: "page",
        cid: "tab1",
        position: "top"
    }), tab.add({
        id: "desk_index",
        title: "桌面导航",
        url: "system/tabdesk/desk.jsp",
        isClosed: !1,
        iframeAddtion: 'scrolling="no"'
    }), $("body").bind("dynamicTabActived", function (a, b) {
        if ("desk_index" == b ? ($("#leftMenu").hide(), $("#spliter").hide()) : ($("#leftMenu").show(), $("#spliter").show(), getNodesByParam("id", b)), "appstore" == b && 1 == storeLoadedFlag) try {
            document.getElementById("page_appstore").contentWindow.resetStoreIcon()
        } catch (a) {}
    }), $("body").bind("dynamicTabClose", function (a, b) {
        "appstore" == b && (storeLoadedFlag = 0)
    }), $("body").bind("dynamicTabCloseOther", function (a, b) {
        "appstore" != b && (storeLoadedFlag = 0)
    }), $("body").bind("dynamicTabCloseAll", function () {
        storeLoadedFlag = 0
    }), $("#spliter").hide(), $(".spliter").each(function () {
        $(this).spliterRender()
    }), resizeHandler(), $("body").bind("dialogTaskShow", function () {
        taskBarShow = !0, taskBarHeight = 29, 1 == chatMainShow ? $(".chat_main").css("bottom", taskBarHeight + "px") : $(".chat_main").css("bottom", -402 + taskBarHeight + "px"), resizeHandler()
    }), $("body").bind("dialogTaskHide", function () {
        taskBarShow = !1, taskBarHeight = 0, 1 == chatMainShow ? $(".chat_main").css("bottom", "0") : $(".chat_main").css("bottom", "-402px"), resizeHandler()
    })
}), window.onresize = function () {
    resizeHandler()
};