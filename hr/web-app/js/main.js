//YAHOO.util.Event.onDOMReady(init)


YAHOO.util.Event.onContentReady("productsandservices", function(){

    var oMenuBar_top = new YAHOO.widget.MenuBar("productsandservices", {
        autosubmenudisplay: true,
        hidedelay: 750,
        lazyload: true
    });
    oMenuBar_top.render();
});

YAHOO.util.Event.onContentReady("menuwithgroups", function(){
    var oMenu_groups = new YAHOO.widget.Menu("menuwithgroups", {
        position: "static",
		hidedelay: 750,
        lazyload: true
    });
    oMenu_groups.render();
});

YAHOO.util.Event.onContentReady("basicmenu", function(){
    var oMenu_basic = new YAHOO.widget.Menu("basicmenu", {
		position: "static",
		hidedelay: 750,
        lazyload: true
    });
    oMenu_basic.render();
	//basicmenu.show();
});

YAHOO.util.Event.onContentReady("menuwithgroups_title", function(){
	var oMenu_groups_title = new YAHOO.widget.Menu("menuwithgroups_title", { 
		position: "static",
		hidedelay: 750,
		lazyload: true
	});
	oMenu_groups_title.render();
	//oMenu_groups_title.show();
});
