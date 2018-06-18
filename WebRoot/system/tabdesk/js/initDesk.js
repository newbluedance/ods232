var iconData;
var $iconList;
var iconDiag;
var depth = 500;
var currentScreenIdx = 0;
var $container;
$(function () {
    if (broswerFlag == "IE6") {
        iconData = {
            list: [{
                id: "1",
                 group: [{
                    children: [{
                        id: "1-9",
                        name: "集装箱监管",
                        link: "../../pages/集装箱监管/入境查验放行.html",
                        icon:"skin/newicons/demo1.png",
                        smallIcon: "skin/newicons/demo1.png"
                    }, {
                        id: "1-10-1",
                        name: "移动查验",
                        link: "../../pages/移动查验/移动查验index.html",
                        icon: "skin/newicons/demo2.png",
                        smallIcon:"skin/newicons/demo2.png"
                    }],
                    name: "口岸监管",
                    id: "group2"
                }, {
                    children: [{
                        id: "1-15-1",
                        name: "旅客监管",
                        link: "travellerCheck/survey",
                        icon: "skin/newicons/demo3.png",
                        smallIcon: "skin/newicons/demo3.png"
                    }, {
                        id: "1-16",
                        name: "旅客携带物",
                        link: "../../pages/旅客携带物/table-pop-content-xdw.html",
                        icon: "skin/newicons/demo4.png",
                        smallIcon: "skin/newicons/demo4.png"
                    }, {
                        id: "1-17",
                        name: "伴侣宠物",
                        link: "../../pages/伴侣宠物/blcw.html",
                        icon: "skin/newicons/demo5.png",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "1-18",
                        name: "航空器监管",
                        link: "../../pages/航空器监管/hkqjg.html",
                        icon: "skin/newicons/demo6.png",
                        smallIcon: "skin/newicons/demo6.png"
                    }],
                    name: "青奥旅检",
                    id: "group3"
                }, {
                    children: [{
                        id: "1-1-1",
                        name: "赛马监管",
                        link: "./horse/horseList.action",
                        icon: "skin/newicons/demo7.png",
                        smallIcon: "skin/newicons/demo7.png"
                    }],
                    name: "动植检",
                    id: "group1"
                }]
            }, {
                id: "2",
                group: [{
                    children: [{
                        id: "2-1-1",
                        name: "航空配餐",
                        icon: "skin/newicons/demo8.png",
                        link: "./catering/toHorseCompanyList.action",
                        smallIcon: "skin/newicons/demo5.png"
                    }],
                    name: "航空配餐",
                    id: "group4"
                }, {
                    children: [{
                        id: "2-2",
                        name: "邮检管理",
                        icon: "skin/newicons/demo9.png",
                        link: "../../pages/邮检管理/yjgl-1.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }],
                    name: "邮检管理",
                    id: "group5"
                }, {
                    children: [{
                        id: "2-3",
                        name: "入境查询统计",
                        icon: "skin/newicons/demo10.png",
                        link: "../../pages/查询统计/table-pop-content-tj.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }],
                    name: "查询统计",
                    id: "group6"
                }]
            }, {
                id: "3",
                group: [{
                    children: [{
                        id: "2-4",
                        name: "综合查询",
                        icon: "skin/newicons/demo11.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-5",
                        name: "部门管理",
                        icon: "skin/newicons/demo12.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-6",
                        name: "职务管理",
                        icon: "skin/newicons/demo13.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-7",
                        name: "角色管理",
                        icon:"skin/newicons/demo14.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-8",
                        name: "用户管理",
                        icon:"skin/newicons/demo15.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-9",
                        name: "菜单管理",
                        icon: "skin/newicons/demo16.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-10",
                        name: "系统管理",
                        icon: "skin/newicons/demo17.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-11",
                        name: "公告管理",
                        icon:"skin/newicons/demo18.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-12",
                        name: "用户导入",
                        icon:"skin/newicons/demo19.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }],
                    name: "综合查询",
                    id: "group7"
                }, {
                    children: [{
                        id: "2-13",
                        name: "密码修改",
                        icon: "skin/newicons/demo20.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }],
                    name: "密码修改",
                    id: "group9"
                }]
            }],
            dock: [/*{
                id: "0-1",
                name: "计算器",
                link: "../../sample_skin/normal/form-page.html",
                icon: "skin/newicons_gif/demo22.gif",
                smallIcon: "skin/smallicons/demo22.png"
            }, {
                id: "0-2",
                name: "照相机",
                link: "../../sample_skin/normal/form-page.html",
                icon: "skin/newicons_gif/demo24.gif",
                smallIcon: "skin/smallicons/demo24.png"
            }, */{
                id: "0-3",
                name: "会展",
                icon: "skin/newicons_gif/demo38.png",
                smallIcon: "skin/smallicons/demo38.png"
            }, {
                id: "0-4",
                name: "微平台",
                icon: "skin/newicons_gif/demo50.png",
                smallIcon: "skin/smallicons/demo50.png"
            }]
        }
    } else {
        iconData = {
            list: [{
                id: "1",
                group: [{
                    children: [{
                        id: "1-9",
                        name: "集装箱监管",
                        link: "../../pages/集装箱监管/入境查验放行.html",
                        icon:"skin/newicons/demo1.png",
                        smallIcon: "skin/newicons/demo1.png"
                    }, {
                        id: "1-10-1",
                        name: "移动查验",
                        link: "../../pages/移动查验/移动查验index.html",
                        icon: "skin/newicons/demo2.png",
                        smallIcon:"skin/newicons/demo2.png"
                    }],
                    name: "口岸监管",
                    id: "group2"
                }, {
                    children: [{
                        id: "1-15-1",
                        name: "旅客监管",
                        link: "travellerCheck/survey",
                        icon: "skin/newicons/demo3.png",
                        smallIcon: "skin/newicons/demo3.png"
                    }, {
                        id: "1-16",
                        name: "旅客携带物",
                        link: "../../pages/旅客携带物/table-pop-content-xdw.html",
                        icon: "skin/newicons/demo4.png",
                        smallIcon: "skin/newicons/demo4.png"
                    }, {
                        id: "1-17",
                        name: "伴侣宠物",
                        link: "../../pages/伴侣宠物/blcw.html",
                        icon: "skin/newicons/demo5.png",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "1-18",
                        name: "航空器监管",
                        link: "../../pages/航空器监管/hkqjg.html",
                        icon: "skin/newicons/demo6.png",
                        smallIcon: "skin/newicons/demo6.png"
                    }],
                    name: "青奥旅检",
                    id: "group3"
                }, {
                    children: [{
                        id: "1-1-1",
                        name: "赛马监管",
                        link: "./horse/toHorseList.action",
                        icon: "skin/newicons/demo7.png",
                        smallIcon: "skin/newicons/demo7.png"
                    }],
                    name: "动植检",
                    id: "group1"
                }]
            }, {
                id: "2",
                group: [{
                    children: [{
                        id: "2-1-1",
                        name: "航空配餐",
                        icon: "skin/newicons/demo8.png",
                        link: "./catering/toHorseCompanyList.action",
                        smallIcon: "skin/newicons/demo5.png"
                    }],
                    name: "航空配餐",
                    id: "group4"
                }, {
                    children: [{
                        id: "2-2",
                        name: "邮检管理",
                        icon: "skin/newicons/demo9.png",
                        link: "../../pages/邮检管理/yjgl-1.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }],
                    name: "邮检管理",
                    id: "group5"
                }, {
                    children: [{
                        id: "2-3",
                        name: "入境查询统计",
                        icon: "skin/newicons/demo10.png",
                        link: "../../pages/查询统计/table-pop-content-tj.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }],
                    name: "查询统计",
                    id: "group6"
                }]
            }, {
                id: "3",
                group: [{
                    children: [{
                        id: "2-4",
                        name: "综合查询",
                        icon: "skin/newicons/demo11.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-5",
                        name: "部门管理",
                        icon: "skin/newicons/demo12.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-6",
                        name: "职务管理",
                        icon: "skin/newicons/demo13.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-7",
                        name: "角色管理",
                        icon:"skin/newicons/demo14.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-8",
                        name: "用户管理",
                        icon:"skin/newicons/demo15.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-9",
                        name: "菜单管理",
                        icon: "skin/newicons/demo16.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-10",
                        name: "系统管理",
                        icon: "skin/newicons/demo17.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-11",
                        name: "公告管理",
                        icon:"skin/newicons/demo18.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }, {
                        id: "2-12",
                        name: "用户导入",
                        icon:"skin/newicons/demo19.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }],
                    name: "综合查询",
                    id: "group7"
                }, {
                    children: [{
                        id: "2-13",
                        name: "密码修改",
                        icon: "skin/newicons/demo20.png",
                        link: "../../sample_skin/normal/role-management.html",
                        smallIcon: "skin/newicons/demo5.png"
                    }],
                    name: "密码修改",
                    id: "group9"
                }]
            }],
            dock: [/*{
                id: "0-1",
                name: "计算器",
                link: "../../sample_skin/normal/form-page.html",
                icon: "skin/newicons/demo22.png",
                smallIcon: "skin/smallicons/demo22.png"
            }, {
                id: "0-2",
                name: "照相机",
                link: "../../sample_skin/normal/form-page.html",
                icon: "skin/newicons/demo24.png",
                smallIcon: "skin/smallicons/demo24.png"
            }, */{
                id: "0-3",
                name: "会展",
                icon: "skin/newicons/demo38.png",
                smallIcon: "skin/smallicons/demo38.png"
            }, {
                id: "0-4",
                name: "微平台",
                icon: "skin/newicons/demo50.png",
                smallIcon: "skin/smallicons/demo50.png"
            }]
        }
    }
    createDeskIcon(iconData);
    resizeHandler();
    window.onresize = function () {
        resizeHandler()
    };
    $container = $(top.document.getElementById("allIconContainer"));
    var a = jQuery.jCookie("deskbg");
    if (a == "false" || a == false) {
        a = "skin/bg/bg.jpg"
    }
    $("body").css({
        backgroundImage: "url(" + a + ")"
    });
    var c;
    c = $.rightClickMenu({
        width: 120,
        items: [{
            text: "刷新桌面",
            click: itemclick,
            iconClass: "icon_reload",
            menuId: "1"
        }, {
            line: true
        }, {
            text: "背景设置",
            click: itemclick,
            iconClass: "icon_img",
            menuId: "2"
        }, {
            text: "图标设置",
            click: itemclick,
            iconClass: "icon_view",
            children: [{
                text: "大图标",
                click: itemclick,
                menuId: "3-1"
            }, {
                text: "小图标",
                click: itemclick,
                menuId: "3-2"
            }]
        }, {
            line: true
        }, {
            text: "锁定屏幕",
            click: itemclick,
            iconClass: "icon_lock",
            menuId: 0,
            menuId: "4"
        }, {
            text: "注销系统",
            click: itemclick,
            iconClass: "icon_exit",
            menuId: 0,
            menuId: "5"
        }]
    });
    $("body").bind("contextmenu", function (d) {
        c.show({
            top: d.pageY,
            left: d.pageX
        });
        return false
    });
    var b = {
        list: ["智能提示选项示例1", "智能提示选项示例2", "智能提示选项示例3", "智能提示选项示例4"]
    };
    $("#searchInput").AutoComplete({
        data: b,
        inputWidth: 165,
        boxWidth: 210,
        topDeff: 12,
        onItemSelected: function (d) {
            $("#searchPanel").hide();
            top.Dialog.alert("此处为查询结果处理。")
        }
    })
});

function getIconData() {
    return iconData
}

function resetIconData(a, b) {
    iconData = {};
    iconData.list = a;
    iconData.dock = b;
    createDeskIcon(iconData)
}

function resizeHandler() {
    var b = document.documentElement.clientWidth;
    var c = $("#mydock").find("li").length;
    var d;
    if (c < 4) {
        d = 56 + 56 + 270
    } else {
        d = 56 + 56 + c * 90
    }
    $("#mydock").css({
        left: (b - d) / 2
    });
    var a = 200;
    $("#iconnav").css({
        left: (b - a) / 2
    });
    $("#searchPanel").css({
        left: (b - $("#searchPanel").width()) / 2
    })
}

function itemclick(b, a) {
    top.Dialog.alert("菜单项：" + b.text)
}

function itemclick(b, a) {
    if (b.menuId == "4") {
        var c = new top.Dialog();
        c.Title = "系统锁屏";
        c.ID = "a1";
        c.URL = "include/lock.html";
        c.Width = 350;
        c.Height = 150;
        c.ShowCloseButton = false;
        c.ShowCancelButton = false;
        c.ShowOkButton = false;
        c.AllowChangeIndex = false;
        c.ButtonAlign = "center";
        c.show();
        c.addButton("btn1", "注销系统", function () {
            window.location = "login.html"
        });
        c.addButton("btn2", "确定解锁", function () {
            top.document.getElementById("_DialogFrame_a1").contentWindow.validateForm()
        })
    } else {
        if (b.menuId == "1") {
            window.location.reload()
        } else {
            if (b.menuId == "2") {
                top.Dialog.open({
                    URL: "include/skin.html",
                    Title: "更换背景",
                    Modal: false,
                    ResizeResetPosition: false,
                    ShowMinButton: true,
                    Width: 720,
                    Height: 460
                })
            } else {
                if (b.menuId == "3-1") {
                    $(".nav_icon_h_item").removeClass("nav_icon_h_item_small");
                    $(".subTitle").css("paddingTop", "35px")
                } else {
                    if (b.menuId == "3-2") {
                        $(".nav_icon_h_item").addClass("nav_icon_h_item_small");
                        $(".subTitle").css("paddingTop", "15px")
                    } else {
                        if (b.menuId == "5") {
                            top.Dialog.confirm("确定要退出系统吗", function () {
                                top.window.location = "../tabdesk/login.html"
                            })
                        }
                    }
                }
            }
        }
    }
}

function changeStyle(a) {
    $("body").css({
        backgroundImage: "url(" + a + ")"
    });
    jQuery.jCookie("deskbg", a)
}

function createDeskIcon(b) {
    var a = $("#iconnavCon");
    a.empty();
    $("#mydock").find("ul").empty();
    $("body").find(".screen").remove();
    $.each(b.list, function (c, f) {
        var d = $('<div class="screen"></div>');
        $("body").append(d);
        d.hide();
        var h = $("<li></li>");
        var g = $("<a></a>");
        if (c == 0) {
            g.addClass("current");
            d.show()
        }
        g.text(c + 1);
        h.append(g);
        a.append(h);
        var e = c;
        if (f.group) {
            $.each(f.group, function (k, j) {
                var m = k;
                if (j.children.length > 0) {
                    var i = $('<div class="subTitle"><div class="subTitleCon"></div></div>');
                    i.find(".subTitleCon").text(j.name);
                    var l = $('<div class="iconContent"></div>');
                    d.append(i);
                    d.append(l);
                    l.attr("id", j.id);
                    $.each(j.children, function (p, o) {
                        var n = $('<div class="nav_icon_h_item "><a><div class="nav_icon_h_item_img"><img/></div><div class="nav_icon_h_item_text" style="-moz-user-select:none;"></div></a></div>');
                        var s = n.find("a");
                        s.click(function () {
                            if (o.link) {
                                var t = "tab";
                                if (o.linkType) {
                                    t = o.linkType
                                }
                                openContentWindow(o.link, o.name, o.id, t, o.smallIcon)
                            }
                        });
                        if (o.icon) {
                            n.find("img").attr("src", o.icon)
                        }
                        if (o.id) {
                            n.attr("id", o.id)
                        }
                        if (o.smallIcon) {
                            n.attr("smallIcon", o.smallIcon)
                        }
                        if (o.linkType) {
                            n.attr("linkType", o.linkType)
                        }
                        if (o.link) {
                            n.attr("link", o.link)
                        }
                        n.find(".nav_icon_h_item_text").text(o.name);
                        n.find(".nav_icon_h_item_text").attr("title", o.name);
                        l.append(n);
                        var r = n.find(".nav_icon_h_item_text");
                        n.find("img")[0].ondragstart = function () {
                            return false
                        };
                        var q = r.dragDrop({
                            revert: true,
                            receive: "#mydock",
                            proxy: function () {
                                var t = $("<img style='position:absolute;'/>");
                                t.attr("width", 64);
                                t.attr("src", n.find("img").attr("src"));
                                t.appendTo("body");
                                return t
                            },
                            proxyY: -30
                        });
                        q.bind("StartDrag", function () {
                            this.cursor = "url(../../libs/images/formEle/cursor_wrong.cur),auto"
                        });
                        q.bind("DragEnter", function (w, u, v) {
                            var t = $(w).find("img").length;
                            if (t > 9) {
                                this.cursor = "url(../../libs/images/formEle/cursor_wrong.cur),auto"
                            } else {
                                this.cursor = "url(../../libs/images/formEle/cursor_right.cur),auto"
                            }
                        });
                        q.bind("DragLeave", function (v, t, u) {
                            this.cursor = "url(../../libs/images/formEle/cursor_wrong.cur),auto"
                        });
                        q.bind("Drop", function (y, t, B) {
                            var x = $(y).find("img").length;
                            if (x < 10) {
                                var A = $('<li><a href="javascript:;" keepDefaultStyle="true"><div class="nav_icon_h_item_img"><img/></div><div class="nav_icon_h_item_text" style="-moz-user-select:none;"></div></a></li>');
                                var v = n.find("img").attr("src");
                                A.find("img").attr("src", v);
                                A.find(".nav_icon_h_item_text").text(r.text());
                                $(y).find("ul").append(A);
                                t.hide();
                                n.remove();
                                resizeHandler();
                                var u = {};
                                iconData.dock.push(u);
                                u.id = n.attr("id");
                                u.name = r.text();
                                u.link = n.attr("link");
                                u.icon = v;
                                u.smallIcon = n.attr("smallIcon");
                                if (n.attr("linkType")) {
                                    u.linkType = n.attr("linkType")
                                }
                                var C = iconData.list[e]["group"][m]["children"];
                                for (var z = 0; z < C.length; z++) {
                                    if (C[z]["id"] == u.id) {
                                        C.splice(z, 1);
                                        continue
                                    }
                                }
                                var w = A.find("a");
                                w.click(function () {
                                    var D = "tab";
                                    if (u.link) {
                                        var D = "tab";
                                        if (u.linkType) {
                                            D = u.linkType
                                        }
                                        openContentWindow(u.link, u.name, u.id, D, u.smallIcon)
                                    }
                                })
                            }
                        })
                    });
                    l.append($('<div class="clear"></div>'))
                }
            })
        }
    });
    a.append($('<div class="clear"></div>'));
    a.find("a").each(function (c) {
        $(this).click(function () {
            a.find("a").removeClass("current");
            $(this).addClass("current");
            $(".screen").hide();
            $(".screen").eq(c).fadeIn(500);
            currentScreenIdx = c
        })
    });
    $.each(b.dock, function (d, e) {
        var c = $('<li><a><div class="nav_icon_h_item_img"><img/></div><div class="nav_icon_h_item_text" style="-moz-user-select:none;"></div></a></li>');
        var f = c.find("a");
        f.click(function () {
            if (e.link) {
                var g = "tab";
                if (e.linkType) {
                    g = e.linkType
                }
                openContentWindow(e.link, e.name, e.id, g, e.smallIcon)
            }
        });
        if (e.icon) {
            c.find("img").attr("src", e.icon)
        }
        if (e.name) {
            c.find(".nav_icon_h_item_text").text(e.name)
        }
        if (e.id) {
            c.attr("id", e.id)
        }
        if (e.smallIcon) {
            c.attr("smallIcon", e.smallIcon)
        }
        if (e.linkType) {
            c.attr("linkType", e.linkType)
        }
        if (e.link) {
            c.attr("link", e.link)
        }
        c.find("img")[0].ondragstart = function () {
            return false
        };
        $("#mydock").find("ul").append(c)
    })
}

function createDeskIconList(b) {
    $iconList = $('<div style="padding:0 100px 0 10px;"><table width="100%"><tr></tr></table></div>');
    var a = $iconList.find("tr");
    $.each(iconData.list, function (c, e) {
        var f = $('<td class="ver01"></td>');
        var d = $('<div class="screen"></div>');
        if (e.group) {
            $.each(e.group, function (h, g) {
                $.each(g.children, function (k, j) {
                    var i = $('<div class="nav_icon_list"><a href="javascript:;"><div class="nav_icon_list_img"><img/></div><div class="nav_icon_list_text"></div><div class="clear"></div></a></div>');
                    var l = i.find("a");
                    l.click(function () {
                        if (j.link) {
                            var m = "popup";
                            if (j.linkType) {
                                m = j.linkType
                            }
                            openContentWindow(j.link, j.name, j.id, m, j.smallIcon);
                            $container.hide();
                            $container.empty();
                            $iconList = null
                        }
                    });
                    if (j.icon) {
                        i.find("img").attr("src", j.icon)
                    }
                    i.find(".nav_icon_list_text").text(j.name);
                    f.append(i);
                    i.hover(function () {
                        $(this).addClass("nav_icon_list_over")
                    }, function () {
                        $(this).removeClass("nav_icon_list_over")
                    })
                });
                f.append($('<div class="clear"></div>'))
            })
        }
        a.append(f)
    })
}

function showAllIcon() {
    try {
        createDeskIconList(iconData);
        $container.append($iconList);
        var a = $('<a href="javascript:;" class="backBtn">button</a>');
        $container.prepend(a);
        $container.show();
        a.click(function () {
            $container.hide();
            $container.empty();
            $iconList = null
        })
    } catch (b) {
        alert("IE6不支持此功能。")
    }
}

function showSearchPanel() {
    if ($("#searchPanel")[0].style.display == "none") {
        $("#searchPanel").show();
        $("#searchInput").val("")
    } else {
        $("#searchPanel").hide()
    }
}

function searchHandler() {
    $("#searchPanel").hide();
    top.Dialog.alert("此处为查询结果处理。")
}

function openContentWindow(e, b, c, a, d) {
    if (a == "tab") {
        top.tabAddHandler(c, b, e)
    } else {
        var f = new top.Dialog();
        f.URL = e;
        f.Title = b;
        f.ID = c;
        f.MinToTask = true;
        f.Width = 600;
        f.Height = 400;
        f.ShowMinButton = true;
        f.ShowMaxButton = true;
        f.IconSrc = d;
        f.show()
    }
}
var appSotreDiag;

function openAppStore() {
    top.tabAddHandler("appstore", "应用商店", "appstore.html")
}

function closeAppStore() {
    appSotreDiag.close()
}
var appSotreDiagTree;

function openTreeWindow(d, a, f, b, c) {
    var e = {
        Link: "",
        Name: "",
        Id: "",
        Icon: "",
        SmallIcon: ""
    };
    e.Link = d;
    e.Name = a;
    e.Id = f;
    e.Icon = b;
    e.SmallIcon = c;
    appSotreDiagTree = new top.Dialog();
    appSotreDiagTree.Width = 400;
    appSotreDiagTree.Height = 300;
    appSotreDiagTree.Title = "选择分组";
    appSotreDiagTree.URL = "include/appstoreTree.html";
    appSotreDiagTree.ParamsObj = e;
    appSotreDiagTree.show()
}

function closeTreeWindow() {
    appSotreDiag.close();
    appSotreDiagTree.close()
}

function addAppStoreIcon(b, c, a) {
    var d = appSotreDiagTree.ParamsObj;
    addIconHandler(b, c, a, d.Link, d.Name, d.Id, d.Icon, d.SmallIcon)
}

function addIconHandler(i, g, a, b, h, f, c, j) {
    if (i != currentScreenIdx) {
        $("#iconnav").find("a").removeClass("current");
        $("#iconnav").find("a").eq(i).addClass("current");
        $(".screen").hide();
        $(".screen").eq(i).fadeIn(500);
        currentScreenIdx = i
    }
    var e = $('<div class="nav_icon_h_item "><a><div class="nav_icon_h_item_img"><img/></div><div class="nav_icon_h_item_text"></div></a></div>');
    var d = e.find("a");
    d.click(function () {
        openContentWindow(b, h, f, a, j)
    });
    e.find("img").attr("src", c);
    e.find(".nav_icon_h_item_text").text(h);
    e.find(".nav_icon_h_item_text").attr("title", h);
    $("#" + g).find(".clear").before(e)
}

function changeDockPosition(a) {
    $("#mydock").css("bottom", a)
};