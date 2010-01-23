Ext.onReady(function(){
  var p = new Ext.Panel({
    applyTo: 'html_panel',
    title: 'direct HTML Injection',
    width: 600,
    height: 400,
    autoLoad: {
      url: 'remoteHtml.htm'
    }
  });
});