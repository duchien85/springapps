//Version: Ver11_B090416
MVMessages=new Array();
MVMessages["MAPVIEWER-05500"]="Oracle Maps client internal error.";
MVMessages["MAPVIEWER-05501"]="Map tile layer not found. Check map tile layer name and/or data source name.";
MVMessages["MAPVIEWER-05502"]="Cannot get map tile layer config information.";
MVMessages["MAPVIEWER-05503"]="FOI ID cannot be null.";
MVMessages["MAPVIEWER-05504"]="MapViewer server base URL is not defined.";
MVMessages["MAPVIEWER-05505"]="Wrong map center point specified. It should be an MVSdoGeometry point.";
MVMessages["MAPVIEWER-05506"]="Invalid zoom level.";
MVMessages["MAPVIEWER-05507"]="Map tile layer name cannot be null. ";
MVMessages["MAPVIEWER-05508"]="FOI Id is already used, please pick a new Id.";
MVMessages["MAPVIEWER-05509"]="Theme-based FOI layer name is used, please pick a new name.";
MVMessages["MAPVIEWER-05510"]="Cannot find theme-based FOI layer.";
MVMessages["MAPVIEWER-05511"]="Error occurred when sending request to MapViewer server.";
MVMessages["MAPVIEWER-05512"]="Not enough points have been drawn.";
MVMessages["MAPVIEWER-05513"]="Not a valid line or polygon type MVSdoGeometry.";
MVMessages["MAPVIEWER-05514"]="Must have a filtering geometry when in high-light only mode.";
MVMessages["MAPVIEWER-05515"]="Oracle Maps client notification.";
MVMessages["MAPVIEWER-05516"]="Synchronized remote call is not supported when using Oracle Maps' non-AJAX remoting.";
MVMessages["MAPVIEWER-05517"]="Request string is too long for Oracle Maps' non-AJAX remoting.";
MVMessages["MAPVIEWER-05518"]="Map tile layer hasn't been successfully added.";
MVMessages["MAPVIEWER-05519"]="One or more parameter is missing or invalid.";
MVMessages["MAPVIEWER-05520"]="Geometry SRID is null.";
MVMessages["MAPVIEWER-05521"]="Call back function cannot be null when browser's builtin XMLHttp/XMLHttpRequest is disabled.";
MVMessages["MAPVIEWER-05522"]="Client side coordinate system conversion not supported.";
MVMessages["MAPVIEWER-05523"]="Cannot process response from MapViewer server.";
MVMessages["MAPVIEWER-05524"]="Theme feature highlighting is disabled for this theme.";
MVMessages["MAPVIEWER-05525"]="Theme has not been added to a MVMapView instance.";
MVMessages["MAPVIEWER-05526"]="Map has not been initialized. Please try again later.";
MVMessages["MAPVIEWER-05527"]="Wrong parameter data type. ";
MVMessages["marqueeZoomHint"]="Click on the rectangle to zoom in!";
MVMessages["panNWInfoTip"]="Pan NorthWest";
MVMessages["panNInfoTip"]="Pan North";
MVMessages["panNEInfoTip"]="Pan NorthEast";
MVMessages["panWInfoTip"]="Pan West";
MVMessages["panEInfoTip"]="Pan East";
MVMessages["panSWInfoTip"]="Pan SouthWest";
MVMessages["panSInfoTip"]="Pan South";
MVMessages["panSEInfoTip"]="Pan SouthEast";
MVMessages["panCenterInfoTip"]="Home";
MVMessages["sliderBarInfoTip"]="Click to change zoom level";
MVMessages["sliderInfoTip"]="Drag to change zoom level";
MVMessages["zoomInInfoTip"]="Zoom in";
MVMessages["zoomOutInfoTip"]="Zoom out";
MVMessages["scaleBarInfoTip"]="Scale at the center of the map";
MVMessages["kilometers"]="km";
MVMessages["miles"]="mi";
MVMessages["meters"]="m";
MVMessages["feet"]="ft";
MVMessages["delete"]="Delete";
MVMessages["addPoint"]="Add Point";
MVMessages["finish"]="Finish";
MVMessages["clear"]="Clear";
MVMessages["totalDistance"]="Total Distance:"
MVMessages["km"]="KM"
MVMessages["m"]="M"
MVMessages["cm"]="CM"
MVMessages["mi"]="mi."
MVMessages["yd"]="yd."
MVMessages["ft"]="ft."
MVMessages["clearButton"]="Clear Button"
MVMessages["redlineTool"]="Redline Tool"
MVMessages["distanceTool"]="Distance Tool"
MVMessages["circleTool"]="Circle Tool"
MVMessages["retangleTool"]="Retangle Tool"
MVMessages["marqueeZoomTool"]="Marquee Zoom Tool"
function MVXMLHttpRequest()
{
this.onreadystatechange=null;
this._f449=0;
this.url=null;
this.status=0;
this.readyState=0;
this._f450=null;
this.responseText=null;
}
MVXMLHttpRequest._f451=new Array();
MVXMLHttpRequest._f452=0;
MVXMLHttpRequest._f453=Math.round(Math.random()*10000);
MVXMLHttpRequest.callBack=function(id,x0,x1)
{
while(MVXMLHttpRequest._f451.length>0)
{
var x2=MVXMLHttpRequest._f451[0];
if(!x2.onreadystatechange)
{
if(x2._f450)
{
document.body.removeChild(x2._f450);
x2._f450=null;
}
MVXMLHttpRequest._f451.shift();
}
else
 break;
}
var x3=0;
for(;x3<MVXMLHttpRequest._f451.length;x3++)
{
if(MVXMLHttpRequest._f451[x3]._f449==id)
{
var x2=MVXMLHttpRequest._f451[x3];
document.body.removeChild(x2._f450);
x2._f450=null;
if(x3==0)
MVXMLHttpRequest._f451.shift();
x2.status=200;
x2.readyState=4;
x2.responseText=x0;
if(x2.onreadystatechange&&!x1)
{
x2.onreadystatechange();
}
x2.onreadystatechange=null;
return ;
}
}
}
MVXMLHttpRequest.prototype.abort=function()
{
MVXMLHttpRequest.callBack(this._f449,null,true);
}
MVXMLHttpRequest.prototype.open=function(x4,x5,x6)
{
if(!x6)
MVi18n._f6("MVXMLHttpRequest.open","MAPVIEWER-05516");
else
 this.url=x5;
}
MVXMLHttpRequest.prototype.send=function(x7)
{
if(!this.url)
return ;
this._f449=MVXMLHttpRequest._f453+"_"+MVXMLHttpRequest._f452++;
var x8=this.url;
if(x8.indexOf("?")>0)
x8+="&";
else
 x8+="?";
x8+="callback_id="+this._f449;
x8+="&"+x7;
if(x8.length>_f10._f277)
{
MVi18n._f6("MVXMLHttpRequest.send","MAPVIEWER-05517");
return ;
}
var x9=document.createElement("script");
x9.src=x8;
x9.type='text/javascript';
x9.charset='utf-8';
this._f450=x9;
MVXMLHttpRequest._f451.push(this);
document.body.appendChild(x9);
if(MVMapView.debug)
MVi18n.alert("MVXMLHttpRequest. URL:"+x8);
}
MVXMLHttpRequest.prototype.setRequestHeader=function(x10)
{
}
function MVUtil(){}
MVUtil._f645=0;
MVUtil._f293=function(x0,x1,x2,x3,x4,x5,x6,x7,x8)
{
var x9=(x7-x1)*x5/(x3-x1)-x0._f140;
var x10=(x4-x8)*x6/(x4-x2)-x0._f141;
var x11=MVSdoGeometry.createPoint(x9,x10);
return x11.sdo_point;
}
MVUtil._f157=function(x12,x13,x14,x15,x16,x17,x18,x19,x20)
{
var x21=(x19-x13)*x17/(x15-x13)-x12._f140;
var x22=(x16-x20)*x18/(x16-x14)-x12._f141;
return [x21,x22];
}
MVUtil._f83=function(x23)
{
var x24=x23.style.left;
if(x24.indexOf("px")>0)
x24=x24.substring(0,x24.length-2);
return parseInt(""+x24);
}
MVUtil._f84=function(x25)
{
var x26=x25.style.top;
if(x26.indexOf("px")>0)
x26=x26.substring(0,x26.length-2);
return parseInt(""+x26);
}
MVUtil.getZIndex=function(x27)
{
var x28=x27.style.zIndex;
if(!x28)
return 0;
return parseInt(""+x28);
}
MVUtil._f73=function(x29,x30,x31)
{
if(_f10._f362==2)
{
x29.style.pixelLeft=x30;
x29.style.pixelTop=x31;
}
else
 {
x29.style.left=MVUtil._f31(x30);
x29.style.top=MVUtil._f31(x31);
}
}
MVUtil._f629=function(x32,x33,x34,x35,x36,x37,x38)
{
x32.style.left=MVUtil._f31(x33);
x32.style.top=MVUtil._f31(x34);
x32.style.width=MVUtil._f31(x35);
x32.style.height=MVUtil._f31(x36);
if(x37)
x32.style.zIndex=x37;
if(x38)
x32.style.fontSize=MVUtil._f31(x38);
}
MVUtil._f592=function(x39)
{
x39.style.position="absolute";
x39.unselectable="on";
x39.onselectstart=MVUtil._f646;
x39.style.fontFamily="Arial, sans serif";
x39.style.MozUserSelect="none";
x39.align="left";
}
MVUtil._f646=function()
{
return false;
}
MVUtil._f164=function(x40,x41)
{
try
{
if(x41.indexOf(".")>-1)
{
x41="url(\""+x41+"\"),auto";
}
x40.style.cursor=x41;
}
catch(_exception)
{
if(x41=="pointer")
{
MVUtil._f164(x40,"hand");
}
}
}
MVUtil._f497=function(x42)
{
var x43={"x":0,"y":0};
var x44=x42;
while(x42)
{
x43.x+=x42.offsetLeft;
x43.y+=x42.offsetTop;
x42=x42.offsetParent;
}
x42=x44;
while(x42&&x42.tagName!="BODY")
{
x43.x-=x42.scrollLeft;
x43.y-=x42.scrollTop;
x42=x42.parentNode;
}
return x43;
}
function _f285(x0,x1,x2,x3,x4,x5,x6)
{
var x7=null;
if(x6&&_f10._f68())
{
x7=document.createElement("div");
x7.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+
x0+"', sizingMethod='scale');";
}
else
 {
x7=document.createElement("img");
x7.src=x0;
}
if(x1&&x2)
{
x7.style.width=MVUtil._f31(x1);
x7.style.height=MVUtil._f31(x2);
x7.width=x1;
x7.height=x2;
}
if(x4||(x3||(x4==0||x3==0)))
{
x7.style.position="absolute";
x7.style.left=MVUtil._f31(x3);
x7.style.top=MVUtil._f31(x4);
}
if(x5||x5==0)
{
x7.style.zIndex=x5;
}
if(_f10._f69=="IF"){
x7.unselectable="on";
x7.onselectstart=MVUtil._f646;}
else{
x7.style.MozUserSelect="none";
}
if(_f10._f69=="IF")
{
x7.galleryImg="no"}
x7.style.border="0";
x7.style.padding="0";
x7.style.margin="0";
x7.oncontextmenu=MVUtil._f646;
return x7;
}
MVUtil._f647=function(x45,x46)
{
if(x46)
{
var x47=null;
if(x46.type!=undefined)
x47=x45._f224(x46);
else
 x47=x46;
var x48=MVSdoGeometry.createPoint(x47.left,x47.top);
return x48.sdo_point;
}
else
 {
var x47=x45._f224(window.event);
var x48=MVSdoGeometry.createPoint(x47.left,x47.top);
return x48.sdo_point;
}
}
MVUtil.getMouseLocation=function(x49,x50)
{
var x51=MVUtil._f647(x49,x50);
var x52=x51.x-x49._f108()/2;
var x53=x52/x49._f75+x49._f94;
x52=x51.y-x49._f109()/2;
var x54=((-1.0)*x52)/x49._f77+x49._f95;
var x55=MVSdoGeometry.createPoint(x53,x54);
return x55;
}
MVUtil._f175=function(x56)
{
x56=(x56)?x56:((window.event)?event:null);
var x57=0;
var x58=0;
if(x56.pageX)
{
x57=x56.pageX;
x58=x56.pageY;
}
else if(x56.clientX)
{
x57=x56.clientX+document.body.scrollLeft-document.body.clientLeft;
x58=x56.clientY+document.body.scrollTop-document.body.clientTop;
if(document.body.parentElement&&document.body.parentElement.clientLeft)
{
var x59=document.body.parentElement;
x57+=x59.scrollLeft-x59.clientLeft;
x58+=x59.scrollTop-x59.clientTop;
}
}
return MVSdoGeometry.createPoint(x57,x58).sdo_point;
}
MVUtil.keepInCSBoundary=function(x60,x61)
{
var x62=x60.msi._f158-x60.msi._f159;
while(x61<x60.msi._f159)
{
x61=x61+x62;
}
while(x61>x60.msi._f158)
{
x61-=x62;
}
return x61;
}
MVUtil.keepOrdinatesInCSBoundary=function(x63,x64)
{
var x65=new Array();
for(var x66=0;x66<x64.length;)
{
x65.push(MVUtil.keepInCSBoundary(x63,parseFloat(x64[x66++])));
x65.push(x64[x66++]);
}
return x65;
}
MVUtil._f648=0;
MVUtil._f649=function(x67)
{
var x68=document.createElement("div");
x68.style.zIndex=1000;
x68.style.width=200;
x68.style.backgroundColor="#ffffff";
x68.style.position="absolute";
x68.style.left=0;
x68.style.top=((MVUtil._f648++)*20)%550;
x68.innerHTML=x67;
document.body.appendChild(x68);
}
MVUtil.getXMLHttpRequest=function(x69)
{
if(!x69)
return new MVXMLHttpRequest();
else
 {
if(window.ActiveXObject)
{
var x70=null;
try
{
x70=new ActiveXObject("Microsoft.XMLHTTP");
}
catch(e)
{
x70=new ActiveXObject("Msxml2.XMLHTTP");
}
return x70;
}
else
 return new XMLHttpRequest();
}
}
MVUtil._f174=function(x71)
{
if(x71)
{
if(_f10._f69=="IF")
x71.cancelBubble=true;
else if(x71.stopPropagation)
x71.stopPropagation();
if(x71.preventDefault)
x71.preventDefault();
else
 x71.returnValue=false;
}
}
MVUtil._f31=function(x72)
{
return Math.round(x72)+"px";
}
MVUtil._f650=function(x73,x74)
{
var x75=0;
var x76=-1;
while((x76=x73.indexOf(x74,x76+1))!=-1)
{
x75++;
}
return x75;
}
MVUtil._f651=function(x77)
{
var x78=x77.indexOf('<');
if(x78==-1)
return "";
var x79=x77.indexOf(' ',x78+1);
if(x79==-1)
return "";
return '</'+MVUtil._f231(x77.substring(x78+1,x79))+'>';
}
MVUtil._f231=function(x80)
{
return x80.replace(/(^[\s]*)|([\s]*$)/g,"");
}
MVUtil._f652=function(x81,x82)
{
return x81.substring(0,x82.length)==x82;
}
MVUtil._f5=function(x83,x84)
{
return x83.substring(x83.length-x84.length,x83.length)==x84;
}
MVUtil._f653=function(x85,x86)
{
return x86+x85+MVUtil._f651(x86);
}
MVUtil._f48=function(x87,x88,x89)
{
var x90;
x90=x87.indexOf(x88);
if(x90>-1)
{
var x91=x87.substring(0,x90);
var x92=x87.substring(x90+x88.length,x87.length);
x87=x91+x89+MVUtil._f48(x92,x88,x89);
}
return x87;
}
MVUtil._f45=function(x93)
{
if(x93.indexOf(".")>=0)
return x93.substring(0,x93.indexOf("."));
else
 return x93;
}
MVUtil._f44=function(x94)
{
if(x94.indexOf(".")>=0)
return x94.substring(x94.indexOf(".")+1,x94.length);
else
 return x94;
}
MVUtil.objArray=new Array();
MVUtil._f191=new Array();
MVUtil._f654=new Array();
MVUtil._f163=function(x95)
{
if(_f10._f69!="IF")
return;
var x96=MVUtil._f191.length;
if(x95._f655)
{
x96=(x95._f655);
}
else
 x95._f655=-1;
if((x95._f655)==-1&&(MVUtil._f654.length)>0)
x96=MVUtil._f654.pop();
x95._f655=x96;
MVUtil._f191[x96]=x95;
}
MVUtil.MVUnload=function()
{
if(typeof(MVUtil._f191)!="undefined"&&(MVUtil._f191!=null))
{
for(var x97=0;MVUtil._f191&&x97<MVUtil._f191.length;x97++)
{
if(MVUtil._f191[x97])
{
MVUtil._f133(MVUtil._f191[x97]);
MVUtil._f191[x97]=null;
}
}
}
while(MVUtil.objArray.length>0)
{
var x98=MVUtil.objArray.pop();
x98.destroy();
}
}
window.onunload=function()
{
MVUtil.MVUnload();
}
MVUtil._f105=function(x99,x100)
{
if(_f10._f69!="IF")
{
return function()
{
return x100.apply(x99,arguments);
}
}
if(!(MVUtil._f656))
{
MVUtil._f656=new Array();
MVUtil._f657=new Array();
MVUtil._f658=new Array();
}
if(!(MVUtil._f659))
{
MVUtil._f659=new Array();
MVUtil._f660=new Array();
MVUtil._f661=new Array();
}
try
{
var x101=(MVUtil._f656.length);
if(x99._f655)
{
x101=(x99._f655);
}
else
 x99._f655=-1;
if((x99._f655)==-1&&(MVUtil._f658.length)>0)
x101=MVUtil._f658.pop();
MVUtil._f656[x101]=x99;
MVUtil._f656[x101]._f655=x101;
if(!(MVUtil._f657[x101]))
MVUtil._f657[x101]=new Array();
var x102=(MVUtil._f657[x101].length);
MVUtil._f657[x101][x102]=x100;
x99=null;
x100=null;
return function()
{
return MVUtil._f657[x101][x102].apply(MVUtil._f656[x101],arguments);
}
}
catch(e)
{
var x101=(MVUtil._f659.length);
if((MVUtil._f661.length)>0)
x101=MVUtil._f661.pop();
MVUtil._f659[x101]=x99;
MVUtil._f660[x101]=x100;
x99=null;
x100=null;
return function()
{
return MVUtil._f660[x101].apply(MVUtil._f659[x101],arguments);
}
}
}
MVUtil._f307=function(x103)
{
if(_f10._f69=="IF")
{
if(x103._f655)
{
var x104=(x103._f655);
for(var x105=(MVUtil._f657[x104].length);x105>0;--x105)
{
MVUtil._f657[x104][x105-1]=null;
MVUtil._f657[x104].pop();
}
MVUtil._f657[x104]=null;
x103._f655=null;
x103=null;
MVUtil._f656[x104]=null;
MVUtil._f658.push(x104);
}
}
}
MVUtil.gc=function()
{
if(_f10._f69=="IF"&&MVUtil._f659)
{
var x106=0;
if(MVUtil._f662)
x106=(MVUtil._f662);
if((MVUtil._f659.length)<x106)
return;
for(var x107=0;x107<(MVUtil._f659.length);++x107)
{
if((MVUtil._f659[x107])&&(MVUtil._f659[x107].readyState)&&(MVUtil._f659[x107].readyState)==4)
{
MVUtil._f659[x107]=null;
MVUtil._f660[x107]=null;
MVUtil._f661.push(x107);
}
}
}
}
MVUtil._f663=function(x108,x109)
{
if(_f10._f69!="IF")
return;
if(x108=="time")
{
if(MVUtil._f664)
{
clearInterval(MVUtil._f664);
MVUtil._f664=setInterval(MVUtil.gc,x109);
}
else
 MVUtil._f664=setInterval(MVUtil.gc,x109);
}
if(x108=="totalNum")
{
MVUtil._f662=x109;
}
}
MVUtil._f270=function(x110)
{
if(x110!=null)
{
delete x110;
}
}
MVUtil._f146=function(x111)
{
if(_f10._f69=="NS")
{
x111.style.MozUserSelect="none";
}
else if(_f10._f69=="SF")
{
x111.style.KhtmlUserSelect="none";
}
else if(_f10._f69=="IF")
{
x111.unselectable="on";
}
else
 {
return false;
}
return true;
}
MVUtil._f665=function(x112)
{
if(_f10._f69=="NS")
{
x112.style.MozUserSelect="";
}
else if(_f10._f69=="SF")
{
x112.style.KhtmlUserSelect="";
}
else if(_f10._f69=="IF")
{
x112.unselectable="off";
}
else
 {
return false;
}
return true;
}
MVUtil._f8=function(x113)
{
if(!x113)
return null;
var x114=x113.indexOf("://");
if(x114>0)
{
x114+=3;
var x115=x113.indexOf("/",x114);
if(x115>0)
return x113.substring(x114,x115);
else
 return x113.substring(x114);
}
else
 return null;
}
MVUtil._f666=0;
MVUtil._f667=0;
MVUtil._f668=0;
MVUtil._f128=function(x116)
{
if(!x116)
return ;
var x117=x116.childNodes;
if(x117!=null)
{
while(x117.length>0)
{
MVUtil._f133(x117[0]);
x116.removeChild(x117[0]);
}
}
}
MVUtil._f133=function(x118)
{
if(!x118)
return ;
var x119=x118.childNodes;
if(x119!=null)
{
while(x119.length>0)
{
MVUtil._f133(x119[0]);
x118.removeChild(x119[0]);
}
}
MVUtil._f621(x118);
}
MVUtil._f621=function(x120)
{
if(!x120)
return ;
try
{
if(x120.onload)
x120.onload=null;
if(x120.onmouseover)
x120.onmouseover=null;
if(x120.onmouseout)
x120.onmouseout=null;
if(x120.onmousedown)
x120.onmousedown=null;
if(x120.onmouseup)
x120.onmouseup=null;
if(x120.oncontextmenu)
x120.oncontextmenu=null;
if(x120.ondblclick)
x120.ondblclick=null;
if(x120.onclick)
x120.onclick=null;
if(x120.onkeyup)
x120.onkeyup=null;
if(x120.onkeydown)
x120.onkeydown=null;
if(x120.onkeypressed)
x120.onkeypressed=null;
if(_f10._f69=="IF")
{
if(x120.style&&x120.style.filter)
x120.style.filter=null;
if(x120._f655)
{
MVUtil._f654.push(x120._f655)
MVUtil._f191[x120._f655]=null;
}
}
}catch(error)
{
MVi18n._f6("MVUtil.clearListeners","MAPVIEWER-05500",x120.nodeName+","+x120.nodeType+"\n"+error);
}
}
MVUtil._f91=MVUtil._f133;
MVUtil._f669=function(x121)
{
var x122=document.createElement("table");
var x123=document.createElement("tr");
var x124=document.createElement("td");
x124.innerHTML=x121;
x123.appendChild(x124);
x122.appendChild(x123);
return x122;
}
MVUtil.getEvent=function(x125)
{
return x125?x125:((window.event)?event:null);
}
MVUtil.isIE7=function()
{
if(navigator.userAgent&&navigator.userAgent.indexOf("MSIE 7")>=0)
return true;
else
 return false;
}
MVUtil.getNumber=function(x126)
{
var x127=0;
if(typeof(x126)=="string")
{
if(x126.indexOf("px")>0)
x126=x126.substring(0,x126.length-2);
if(x126.indexOf(".")>0)
x127=parseFloat(x126);
else
 x127=parseInt(x126);
if(isNaN(x127))
x127=0;
return x127;
}
else if(typeof(x126)=="number")
x127=x126;
return x127;
}
MVUtil.trapEvent=function(x128)
{
x128=(x128)?x128:((window.event)?event:null);
if(_f10._f69=="IF")
x128.cancelBubble=true;
else if(x128.stopPropagation)
x128.stopPropagation();
}
MVUtil._f171=function(x129,x130)
{
var x131=(_f10._f68()&&x130)?
document.createElement('div'):document.createElement('img');
if(_f10._f68()&&x130)
{
if(x129)
x131.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+
x129+"', sizingMethod='image');";
}
else
 {
x131.src=x129;
}
if(_f10._f69=="IF"&&!x130)
{
x131.galleryImg="no"}
return x131;
}
MVUtil.attachEvent=function(x132,x133,x134)
{
if(_f10._f69=="IF")
{
x133="on"+x133;
x132.attachEvent(x133,x134);
}
else
 {
x132.addEventListener(x133,x134,"false");
}
}
MVUtil.detachEvent=function(x135,x136,x137)
{
if(_f10._f69=="IF")
{
x136="on"+x136;
x135.detachEvent(x136,x137);
}
else
 {
x135.removeEventListener(x136,x137,"false");
}
}
MVUtil.mouseLeftKeyPressed=function(x138)
{
if(_f10._f69=="IF")
return x138.button==1;
else
 return x138.which==1;
}
MVUtil.mouseRightKeyPressed=function(x139)
{
if(_f10._f69=="IF")
return x139.button==2;
else
 return x139.which==3;
}
MVUtil.formatNum=function(x140)
{
if(x140>=1000)
{
x140=new Number(x140);
x140=x140.toLocaleString();
if(x140.indexOf(".00")>0)
{
x140=x140.substring(0,x140.indexOf(".00"));
}
}
return x140;
}
MVUtil.getEventSource=function(x141)
{
if(_f10._f69=="IF")
{
return x141.srcElement;
}
else
 {
return x141.target;
}
}
MVUtil.unique_array=function(x142)
{
var x143=x142;
var x144;
for(var x145=0;x145<x142.length;x145++)
{
for(var x146=0;x146<x142.length;x146++)
{
x144=x142[x145];
if((x145+x146+1)<x142.length&&x144==x142[x145+x146+1])x143.splice(x145+x146+1,1);}
}
return x143;
}
MVUtil.runListeners=function(x147,x148,x149)
{
if(x147)
{
for(each in x147[x148])
{
if(x149!=undefined)
(x147[x148][each]).apply(x147[x148][each],x149);
else
 (x147[x148][each]).apply(x147[x148][each]);
}
}
}
MVUtil.detachEventListener=function(x150,x151,x152)
{
var x153=x150[x151];
if(x153)
{
for(var x154=0;x154<x153.length;x154++)
{
if(x152==x153[x154])
{
x153.splice(x154,1);
}
}
}
}
MVUtil.attachEventListener=function(x155,x156,x157)
{
x155[x156]?
x155[x156].push(x157):x155[x156]=[x157];
x155[x156]=MVUtil.unique_array(x155[x156]);
}
MVUtil.getMVIndFOIsControlAndFOI=function(x158)
{
var x159=x158.ifctl;
while(!x159&&x158.parentNode){x158=x158.parentNode;
x159=x158.ifctl;
}
if(x158.parentNode&&x159)
var x160=x159._f263(x158.orgid?x158.orgid:x158.id);
if(x160&&x160.origFOI)
x160=x160.origFOI;
return {ifctl:x159,foi:x160};
}
MVUtil.transOrdinatesOnWarpAroungMap=function(x161,x162)
{
var x163=x161.msi._f158-x161.msi._f159;
var x164=x163/2;
var x165=x161.msi._f159+x164;
var x166=new Array();
if(x162.length<4)
return x162;
var x167=x162[0];
var x168;
x166.push(x167);
x166.push(x162[1]);
for(var x169=2;x169<x162.length;x169++)
{
x168=x162[x169];
if(Math.abs(x168-x167)>x164)
{
if((x168-x167)<0)
x168+=x163;
else
 x168-=x163;
}
x167=x168;
x166.push(x168);
x166.push(x162[++x169]);
}
return x166;
}
MVUtil.transLongitudeOnWarpAroungMap=function(x170,x171,x172)
{
var x173=x170.msi._f158-x170.msi._f159;
var x174=x173/2;
var x175=x170.msi._f159+x174;
while(Math.abs(x172-x171)>x174)
{
if((x172-x171)<0)
{
x172+=x173;
}
else
 {
x172-=x173;
}
}
return x172;
}
MVUtil.crossDateLine=function(x176,x177)
{
var x178=x176.msi._f158-x176.msi._f159;
var x179=x178/2;
var x180=x176.msi._f159+x179;
if(x177.length<4)
return false;
var x181=x177[0];
var x182;
for(var x183=2;x183<x177.length;x183+=2)
{
x182=x177[x183];
if(Math.abs(x182-x181)>x179)
{
return true
}
else if(x181>x176.msi._f159&&x181<x176.msi._f158
&&(x182>x176.msi._f158||x182<x176.msi._f159)){
return true;
}
x181=x182;
}
return false;
}
MVUtil.duplicateCrossDateLineOrds=function(x184,x185,x186)
{
var x187=x184.msi._f158-x184.msi._f159;
var x188=x187/2;
var x189=x184.msi._f159+x188;
var x190=new Array();
var x191=false;
if(x186[0]<x184.msi._f158&&x186[2]>x184.msi._f158)
x191=true;
for(var x192=0;x192<x185.length;x192++)
{
x=x185[x192];
if(x191)
x190.push(parseFloat(x)-x187);
else
 x190.push(parseFloat(x)+x187);
x190.push(x185[++x192]);
}
return x190;
}
MVUtil.cloneObject=function(x193)
{
var x194={};
for(property in x193)x194[property]=x193[property];
return x194;
}
MVUtil.calAreaCodeFromCenter=function(x195,x196)
{
var x197=null;
if(x195.wraparound)
{
var x198=x195.msi._f158-x195.msi._f159;
var x199=x195._f250.centerArea;;
var x200=x195._f226();
var x201=x195._f250.maparea[x199].n;
var x202=x195.msi._f159+x198*x201;
var x203=x195.msi._f158+x198*x201;
var x204=x196-x200;
var x205=0;
while(Math.abs(x204)>x198/2)
{
if(x204<0)
{
x196=x196+x198;
x205--;
}
else
 {
x196=x196-x198;
x205++;
}
x204=x196-x200;
}
if(x196<x202)
x197=x199-1+x205;
else if(x196>x203)
x197=x199+1+x205;
else
 x197=x199+x205;
}
return x197;
}
MVUtil.isNumber=function(x206)
{
if(x206!=null&&typeof x206=="number")
return true;
else
 return false;
}
MVUtil.isNumberArray=function(x207)
{
if(!x207)
return true;
if(typeof x207=="object")
if(x207.length==0||MVUtil.isNumber(x207[0]))
return true;
return false;
}
function _f363()
{
}
_f363._f364=6372795;
_f363._f365=function(x0,x1,x2)
{
var x0=_f363._f366(x0);
var x3=x0.x;
var x4=x0.y;
var x5=x1/_f363._f364;
var x6=Math.asin(Math.sin(x4)*Math.cos(x5)+Math.cos(x4)*Math.sin(x5)*Math.cos(x2));
var x7=x3+Math.atan2(Math.sin(x2)*Math.sin(x5)*Math.cos(x4),Math.cos(x5)-Math.sin(x4)*Math.sin(x6));
return _f363._f367(new MVSdoPointType(x7,x6,0));
}
_f363._f366=function(x8)
{
var x9=x8.x;
var x10=x8.y;
while(x9<-180)x9+=360;
while(x9>180)x9-=360;
x9=x9*Math.PI/180;
x10=x10*Math.PI/180;
return new MVSdoPointType(x9,x10,0);
}
_f363._f367=function(x11)
{
var x12=x11.x;
var x13=x11.y;
x13=x13*180/Math.PI;
x12=x12*180/Math.PI;
return new MVSdoPointType(x12,x13,0);
}
_f363._f368=function(x14,x15)
{
x14=_f363._f366(x14);
x15=_f363._f366(x15);
var x16=x15.x-x14.x;
var x17=x15.y-x14.y;
var x18=Math.sin(x17/2);
var x19=Math.sin(x16/2);
var x20=x18*x18+Math.cos(x14.y)*Math.cos(x15.y)*x19*x19;
var x21=2*Math.atan2(Math.sqrt(x20),Math.sqrt(1-x20));
return x21*_f363._f364;
}
_f363._f369=function(x22)
{
var x23=0;
for(i=0;i<x22.length-2;i+=2)
{
x23+=_f363._f368(new MVSdoPointType(x22[i],x22[i+1]),new MVSdoPointType(x22[i+2],x22[i+3]));
}
return x23;
}
_f363.getSphericalArea=function(x24)
{
var x25=q.length/2;
var x26,x27,x28;
var x29;
var x30,x31,x32;
var x33;
var x34;
var x35=0.;
var x36;
var x37=0.;
for(x31=0,x30=x25-1,x32=1,dP=q+2;x31<x25;++x31,++x30,++x32,dP+=3)
{
x30%=x25;
x32%=x25;
var x38=MVGeoUtil.get3DVector(q[2*x31],q[2*x31+1]);
var x39=MVGeoUtil.get3DVector(q[2*x30],q[2*x30+1]);
var x40=MVGeoUtil.get3DVector(q[2*x32],q[2*x32+1]);
x37+=x38.z;
x26=MVGeoUtil.mdsphcp(x38,x38);
x29=MVGeoUtil.MAGNITUDE(x26);
x27=MVGeoUtil.mdsphcp(x38,x40);
x29*=MVGeoUtil.MAGNITUDE(x27);
x36=MVGeoUtil.DOTPRODUCT(x26,x27)/x29;
if(x36>1.)x36=1.;
if(x36<-1.)x36=-1.;
x33=Math.acos(x36);
x28=MVGeoUtil.mdsphcp(x26,x27);
if(Math.abs(x28.x)<1.e-9*x29&&Math.abs(x28.y)<1.e-9*x29&&
Math.abs(x28.z)<1.e-9*x29)
{
if(x36>0.)
x35-=Math.PI;
}
else
 {
if(MVGeoUtil.DOTPRODUCT(x28,x38)<0.)
x35+=x33-Math.PI;
else
 x35+=Math.PI-x33;
}
}
x37/=x25*1.0;
if(x35<0.)x35+=2.*Math.PI;
else x35-=2.*Math.PI;
}
_f363.mdsphcp=function(x41,x42)
{
var x43={"x":0,"y":0,"z":0};
if((x41.x==x42.x)&&(x41.y==x42.y)&&(x41.z==x42.z))
{
x43.x=x43.y=x43.z=0.0;
}
else
 {
x43.x=x41.y*x42.z-x41.z*x42.y;
x43.y=x41.z*x42.x-x41.x*x42.z;
x43.z=x41.x*x42.y-x41.y*x42.x;
}
return x43;
}
_f363.get3DVector=function(x44,x45)
{
var x46={"x":x44,"y":x45};
var x47=_f363._f366(x46);
x47.z=Math.sin(x47.y);
return x47;
}
_f363.MAGNITUDE=function(x48)
{
return Math.sqrt(x48.x*x48.x+x48.y*x48.y+x48.z*x48.z);
}
_f363.DOTPRODUCT=function(x49,x50)
{
return x49.x*x50.x+x49.y*x50.y+x49.z*x50.z;
}
function _f10(){}
_f10._f362=document.all?(document.getElementById?2:1):(document.layers?3:0);
_f10._f525=navigator.userAgent.toLowerCase();
_f10._f526=null;
_f10._f527=null;
_f10._f510=new Array(30);
_f10._f528=new Array(30);
_f10._f529=new Array(30);
_f10._f296="MVInfoWindowStyle1";
_f10._f530=null;
_f10._f531=new Array(30);
_f10._f456=function()
{
return _f10._f530;
}
_f10._f532=function(x0)
{
if(!_f10._f530)
_f10._f530=x0;
}
_f10._f489=function(x1)
{
_f10._f526=_f10._f525.indexOf(x1)+1;
_f10._f527=x1;
return _f10._f526;
}
if(_f10._f489('safari'))
_f10._f69="SF";
else if(_f10._f489('opera'))
_f10._f69="OS";
else if(_f10._f489('msie'))
_f10._f69="IF";
else if(!_f10._f489('compatible'))
{
_f10._f69="NS";
_f10._f533=_f10._f525.substring(8,11);}
else _f10._f69="unknown";
if(!_f10._f533)
_f10._f533=_f10._f525.substring(_f10._f526+_f10._f527.length,
_f10._f526+_f10._f527.length+3);
_f10._f534=0;
if(_f10._f533)
{
var i=_f10._f533.indexOf(".");
if(i>=0)
_f10._f534=parseInt(_f10._f533.substring(0,i));
else
 _f10._f534=parseInt(_f10._f533);
}
_f10._f68=function()
{
return _f10._f69=="IF"&&_f10._f534<7;
}
_f10._f529["SQ_MM"]=.000001;
_f10._f529["SQ_KILOMETER"]=1000000;
_f10._f529["SQ_CENTIMETER"]=.0001;
_f10._f529["SQ_MILLIMETER"]=.000001;
_f10._f529["SQ_CH"]=404.6856;
_f10._f529["SQ_FT"]=.09290304;
_f10._f529["SQ_IN"]=.00064516;
_f10._f529["SQ_LI"]=.04046856;
_f10._f529["SQ_CHAIN"]=404.6856;
_f10._f529["SQ_FOOT"]=.09290304;
_f10._f529["SQ_INCH"]=.00064516;
_f10._f529["SQ_LINK"]=.04046856;
_f10._f529["SQ_MILE"]=2589988;
_f10._f529["SQ_ROD"]=25.29285;
_f10._f529["SQ_SURVEY_FOOT"]=.09290341;
_f10._f529["SQ_YARD"]=.8361274;
_f10._f529["ACRE"]=4046.856;
_f10._f529["HECTARE"]=10000;
_f10._f529["PERCH"]=25.29285;
_f10._f529["ROOD"]=1011.714;
_f10._f529["M"]=1;
_f10._f529["METER"]=1;
_f10._f529["KM"]=1000;
_f10._f529["KILOMETER"]=1000;
_f10._f529["CM"]=.01;
_f10._f529["CENTIMETER"]=.01;
_f10._f529["MM"]=.001;
_f10._f529["MILLIMETER"]=.001;
_f10._f529["MILE"]=1609.344;
_f10._f529["NAUT_MILE"]=1852;
_f10._f529["SURVEY_FOOT"]=.3048006096012;
_f10._f529["FOOT"]=.3048;
_f10._f529["INCH"]=.0254;
_f10._f529["YARD"]=.9144;
_f10._f529["CHAIN"]=20.1168;
_f10._f529["ROD"]=5.0292;
_f10._f529["LINK"]=.201166195;
_f10._f529["MOD_USFT"]=.304812253;
_f10._f529["CL_FT"]=.304797265;
_f10._f529["IND_FT"]=.304799518;
_f10._f529["LINK_BEN"]=.201167651;
_f10._f529["LINK_SRS"]=.201167651;
_f10._f529["CHN_BEN"]=20.1167825;
_f10._f529["CHN_SRS"]=20.1167651;
_f10._f529["IND_YARD"]=.914398554;
_f10._f529["SRS_YARD"]=.914398415;
_f10._f529["FATHOM"]=1.8288;
_f10._f529["SQ_M"]=1;
_f10._f529["SQ_METER"]=1;
_f10._f529["SQ_KM"]=1000000;
_f10._f529["SQ_CM"]=.0001;
_f10._f459=function(x2)
{
if(x2)
x2=x2.toUpperCase();
else
 return 0;
if(_f10._f529[x2])
return _f10._f529[x2];
else
 return 0;
}
_f10._f535=function(x3,x4)
{
x3=x3.toUpperCase();
_f10._f510[x3]=x4;
if(x4.coordSys.srid)
_f10._f528[x4.coordSys.srid]=x4.coordSys;
}
_f10._f457=function(x5)
{
if(x5&&_f10._f528[x5])
return _f10._f528[x5];
else
 return null;
}
_f10._f537=function(basemap,callBack)
{
if(basemap._f411==null||basemap._f107==null||MVUtil._f231(basemap._f107)=="")
{
basemap._f107="null";
_f10._f510[basemap._f107]=null;return;
}
basemap._f107=basemap._f107.toUpperCase();
if(_f10._f510[basemap._f107])
{
if(_f10._f510[basemap._f107].transparent)
basemap._f414=true;
if(callBack)
callBack(_f10._f510[basemap._f107]);
return _f10._f510[basemap._f107];
}
var conStr=basemap._f503.indexOf("?")>=0?"&":"?";
var formatStr;
var _f538=basemap._f503+conStr+"xml_request=<?xml+version=\"1.0\"+standalone=\"yes\"?>"
+"<map_cache_admin_request><get_client_config+map_cache_names=\""+basemap._f107
+"\"+format=\"JSON\"/></map_cache_admin_request>";
var request=null;
var localDomain=(MVUtil._f8(basemap._f411)==MVUtil._f8(_f10._f118()));
var xmlHttp=localDomain||MVMapView._f7;
var configLoaded=function()
{
try
{
var resp=xmlHttp?request.responseText:this.responseText;
eval("var result="+resp);
if(result.length==0)
{
MVi18n._f6("MVGlobalVariables.getMapCacheConfig","MAPVIEWER-05501",basemap._f107);
_f10._f510[basemap._f107]=null;result=null;
return;
}
if(result[0].transparent)
basemap._f414=true;
_f10._f535(basemap._f107,result[0]);
result=null;
}
catch(e)
{
MVi18n._f6("MVGlobalVariables.getMapCacheConfig","MAPVIEWER-05523",
basemap._f107+":"+request.responseText);
return ;
}
if(callBack)
callBack(_f10._f510[basemap._f107]);
}
try
{
request=MVUtil.getXMLHttpRequest(xmlHttp);
if(!xmlHttp)
request.onreadystatechange=configLoaded;
request.open("GET",_f538,!xmlHttp);
request.send("");
}catch(e)
{
MVi18n._f6("MVGlobalVariables.getMapCacheConfig","MAPVIEWER-05511",e);
return ;
}
if(xmlHttp)
{
if(request.status==200)
{
configLoaded();
}
else
 {
_f10._f510[basemap._f107]=null;MVi18n._f6("MVGlobalVariables.getMapCacheConfig","MAPVIEWER-05511",
basemap._f107+":"+request.responseText);
}
}
request=null;
}
_f10._f300=180;
_f10._f301=100;
_f10._f539=14;
_f10._f540=112;
_f10._f541=14;
_f10._f542=14;
_f10._f543=14;
_f10._f544=14;
_f10._f545=14;
_f10._f546=14;
_f10._f547=14;
_f10._f548=14;
_f10._f378=600;
_f10._f379=600;
_f10._f380=30;
_f10._f381=16;
_f10._f382=600;
_f10._f383=1;
_f10._f384=1;
_f10._f385=600;
_f10._f386=1;
_f10._f387=10;
_f10._f487=true;
_f10._f142="/fsmc/images/";
_f10._f549="/fsmc/images/";
_f10._f308=0;
_f10._f350=null;
_f10._f550="bulls-eye.png";
_f10._f551=38;
_f10._f552=38;
_f10._f357=5;
_f10._f356="-redline-point-marker";
_f10._f359="-redline-line-style";
_f10._f360="-redline-area-style";
_f10._f483=0;
_f10._f553=0;
_f10._f277=2000;
_f10._f554=null;
_f10._f9=null;
_f10._f454=function()
{
if(!_f10._f554)
_f10._f554=document.location.protocol+"//"+document.location.host+"/mapviewer/foi";
return _f10._f554;
}
_f10._f118=function()
{
if(!_f10._f9)
_f10._f9=document.location.protocol+"//"+document.location.host+"/mapviewer";
return _f10._f9;
}
_f10._f555="/mapviewer/proxy";
_f10._f556=null;
_f10._f11=function()
{
if(!_f10._f556)
_f10._f556=document.location.protocol+"//"+document.location.host+"/"+_f10._f555;
return _f10._f556;
}
if(document.getElementsByTagName("html")[0].getAttribute("xmlns")=="http://www.w3.org/1999/xhtml")
_f10._f557=true;
else
 _f10._f557=false;
_f10._f407=function(x6,x7,x8)
{
var x9=_f10._f531[x6];
if(!x9)
x9=_f10._f531[x6]=new Array();
x9[x7]=x8;
}
_f10._f458=function(x10,x11)
{
var x12=_f10._f531[x10];
if(x12)
return x12[x11];
else
 return null;
}
_f10._f558=0;
_f10._f559=false;
function _f508(x0)
{
this._f509=x0;
this.mapConfig=_f10._f510[x0];
this._f159=this._f54();
this._f276=this._f55();
this._f158=this._f56();
this._f275=this._f57();
this._f511=this._f56()-this._f54();
this._f512=this._f57()-this._f55();
this.zoomCount=_f10._f510[this._f509].zoomLevels.length;
}
_f508.prototype._f513=function()
{
return this._f509;
}
_f508.prototype._f413=function(x0)
{
return _f10._f510[x0].format;
}
_f508.prototype._f514=function()
{
return this._f511;
}
_f508.prototype._f515=function()
{
return this._f512;
}
_f508.prototype._f54=function()
{
return _f10._f510[this._f509].coordSys.minX;
}
_f508.prototype._f55=function()
{
return _f10._f510[this._f509].coordSys.minY;
}
_f508.prototype._f56=function()
{
return _f10._f510[this._f509].coordSys.maxX;
}
_f508.prototype._f57=function()
{
return _f10._f510[this._f509].coordSys.maxY;
}
_f508.prototype._f432=function()
{
return _f10._f510[this._f509].mapCache;
}
_f508.prototype.getSrid=function()
{
return _f10._f510[this._f509].coordSys.srid;
}
_f508.prototype._f516=function()
{
return _f10._f510[this._f509].coordSys.type;
}
_f508.prototype._f517=function()
{
return _f10._f510[this._f509].coordSys.distConvFactor;
}
_f508.prototype.getMaxZoomLevel=function()
{
return _f10._f510[this._f509].zoomLevels.length;
}
_f508.prototype._f518=function(x1)
{
return _f10._f510[this._f509].zoomLevels[x1].tileWidth;
}
_f508.prototype._f519=function(x2)
{
return _f10._f510[this._f509].zoomLevels[x2].tileHeight;
}
_f508.prototype._f520=function(x3)
{
return _f10._f510[this._f509].zoomLevels[x3].tileImageWidth;
}
_f508.prototype._f521=function(x4)
{
return _f10._f510[this._f509].zoomLevels[x4].tileImageHeight;
}
_f508.prototype._f522=function(x5)
{
return _f10._f510[this._f509].zoomLevels[x5]._f523;
}
_f508.prototype._f524=function(x6,x7,x8,x9)
{
this._f159=x6;
this._f276=x7;
this._f158=x8;
this._f275=x9;
}
function MVEvent(){}
MVEvent.START="start";
MVEvent.FINISH="finish";
MVEvent.DRAG="drag";
MVEvent.NEW_SHAPE_POINT="new_shape_point";
MVEvent.MODIFY="modify";
MVEvent.MOUSE_CLICK="mouse_click";
MVEvent.MOUSE_RIGHT_CLICK="mouse_right_click";
MVEvent.MOUSE_OVER="mouse_over";
MVEvent.MOUSE_OUT="mouse_out";
MVEvent.COLLAPSE="collapse";
MVEvent.AFTER_COLLAPSE="after_collapse";
MVEvent.RESTORE="restore";
MVEvent.AFTER_RESTORE="after_restore";
MVEvent.DRAG_START="drag_start";
MVEvent.DRAG_END="drag_end";
MVEvent.RECENTER="recenter";
MVEvent.ZOOM_LEVEL_CHANGE="zoom_level_change";
MVEvent.BEFORE_ZOOM_LEVEL_CHANGE="before_zoom_level_change";
MVEvent.MOUSE_DOUBLE_CLICK="mouse_double_click";
MVEvent.INITIALIZE="initialize";
MVEvent.MOUSE_MOVE="mouse_move";
MVEvent.CLEAR="clear"
MVEvent.BEFORE_REFRESH="before_refresh";
MVEvent.AFTER_REFRESH="after_refresh";
MVEvent.BUTTON_DOWN="button_down";
MVEvent.BUTTON_UP="button_up";
function _f370(x0,x1,x2,x3)
{
this._f371=x0.zoomLevels[x3].tileWidth;
this._f372=x0.zoomLevels[x3].tileHeight;this._f373=Math.floor((x1-x0.coordSys.minX)/this._f371);
this._f374=Math.floor((x2-x0.coordSys.minY)/this._f372);
this._f375=x3;
this.minX=this._f373*this._f371+x0.coordSys.minX;
this.minY=this._f374*this._f372+x0.coordSys.minY;}
_f370.prototype._f376=function(x0,x1)
{
this._f373=this._f373+x0;
this._f374=this._f374+x1;
}
function MVMapTileLayer(x0,x1)
{
this._f107=x0;
this._f411="";
this._f503="";
if(x1&&x1!="")
{
this._f411=x1;
this._f503=x1;
if(MVUtil._f5(x1,'/'))
{
this._f411=x1.substring(0,x1.length-1);
this._f503=x1.substring(0,x1.length-1);
}
}
this.parent="";
this._f414=false;
this.visible=true;
this._f412="PNG";
this.minVisibleLevel=null;
this.maxVisibleLevel=null;
this._f439=null;
this.layerControl=null;
}
MVMapTileLayer.prototype.getType=function()
{
return "MVMapTileLayer";
}
MVMapTileLayer.prototype.setTransparent=function(x0)
{
this._f414=x0;
}
MVMapTileLayer.prototype.setVisible=function(x1)
{
this.visible=x1;
if(this.parent)
{
if(this.layerControl)
this.layerControl.setVisible(x1);
else if(this.isExtAPITileLayer())
{
if(this.layerDiv)
{
if(x1)
{
this.layerDiv.style.visibility="visible";
var x2=this.parent.getCenter();
this.parent._f504(this,x2.getPointX(),x2.getPointY(),this.parent._f20);
}
else
 this.layerDiv.style.visibility="hidden";
}
}
}
}
MVMapTileLayer.prototype.isVisible=function()
{
return this.visible;
}
MVMapTileLayer.prototype.setVisibleZoomLevelRange=function(x3,x4)
{
this.minVisibleLevel=x3;
this.maxVisibleLevel=x4;
}
MVMapTileLayer.prototype.refresh=function(x5)
{
if(!x5)
this._f439=Math.round(Math.random()*10000000000);
if(this.parent)
{
if(this.layerControl)
{
if(this.layerControl.zoomControl)
this.layerControl.zoomControl.removeCloneTiles();
this.layerControl._f434(this.parent._f108(),this.parent._f109(),
this.parent._f94,this.parent._f95);
}
}
}
MVMapTileLayer.prototype._f432=function()
{
return this._f107;
}
MVMapTileLayer.prototype.clone=function()
{
var x6=new MVMapTileLayer(this._f107,this._f411);
x6._f414=this._f414;
x6._f412=this._f412;
x6.minVisibleLevel=this.minVisibleLevel;
x6.minVisibleLevel=this.maxVisibleLevel;
return x6;
}
MVMapTileLayer.prototype.destroy=function()
{
if(this.layerControl)
this.layerControl.destroy();
else if(this.layerDiv)
{
MVUtil._f133(this.layerDiv);
this.layerDiv.parentNode.removeChild(this.layerDiv);
this.layerDiv=null;
if(this._f223)
this._f223();
}
}
MVMapTileLayer.prototype._f437=function()
{
if(this.layerControl)
this.layerControl._f437();
}
MVMapTileLayer.prototype.isExtAPITileLayer=function()
{
return this.getType()=="MVExternalAPIMapTileLayer";
}
MVBaseMap=MVMapTileLayer;
function MVCustomMapTileLayer(x0,x1)
{
var x2=x0.dataSource?x0.dataSource+"."+x0.mapTileLayer:x0.mapTileLayer;
MVMapView.addMapTileLayerDefinition(x0);
this.layerDefinition=x0;
this._f195=MVMapTileLayer;
this._f195(x2);
this.tileURLProvider=x1;
}
MVCustomMapTileLayer.prototype=new MVMapTileLayer;
MVCustomMapTileLayer.prototype.getType=function()
{
return "MVCustomMapTileLayer";
}
MVCustomMapTileLayer.prototype.clone=function()
{
return new MVCustomMapTileLayer(this.layerDefinition,this.tileURLProvider);
}
function _f408(x0,x1)
{
this.basemap=x1;
this.mapConfig=x1.config;
this.visible=true;
this._f409;
this._f410;
this._f411="";
if(x1._f411)
{
this._f411=x1._f411;
}
else
 {
MVi18n._f6("MVMapTilesControl.constructor","MAPVIEWER-05504");
return ;
}
this.parent=x0;
this._f107=x1._f107;
this._f412=this.parent.msi._f413(this._f107);
this._f414=x1._f414;
this._f415;
this._f416;
this._f417;
this._f418;
this._f419;
this._f420;
this.tileWidth;
this.tileHeight;
this._f421=true;
this._f422=[];
this._f423=0;
this._f424=0;
this._f425;
this._f426;
this._f27;
this._f28;
this._f427=null;
this._f428=document.createElement("div");
this._f428.style.position="absolute";
this.zIndex=x1.zIndex;this.parent.div.appendChild(this._f428);
this._f429=x0._f430.src;
this.visible=x1.isVisible();
this.minVisibleLevel=x1.minVisibleLevel;
this.maxVisibleLevel=x1.maxVisibleLevel;
this.zoomControl=new MVZoomControl(x0,this);
this.tileNumInCSBoun=null;
this.coverPixel=null;
}
_f408.prototype._f431=function()
{
return this._f411;
}
_f408.prototype._f432=function()
{
return this._f107;
}
_f408.prototype._f433=function()
{
return this._f428;
}
_f408.prototype.setVisible=function(x0)
{
this.visible=x0;
if(!this.visible)
this._f428.style.visibility="hidden";
else
 {
this._f428.style.visibility="visible";
if(this.parent._f92)
this._f434(this.parent._f108(),this.parent._f109(),this.parent._f94,this.parent._f95);
}
}
_f408.prototype.isVisible=function()
{
return this.visible;
}
_f408.prototype._f435=function(x1,x2)
{
if(this.parent.wraparound)
{
if(x2<0||x2>=(this.mapConfig.coordSys.maxY-this.mapConfig.coordSys.minY)/this._f427._f372)
return this._f429;
else if(x1<0)
{
while(true)
{
x1=parseInt(Math.ceil((this.mapConfig.coordSys.maxX-this.mapConfig.coordSys.minX)/this._f427._f371))+x1;
if(x1>=0)
break;
}
}
else if(x1>=(this.mapConfig.coordSys.maxX-this.mapConfig.coordSys.minX)/this._f427._f371)
{
while(true)
{
x1=x1-parseInt(Math.ceil((this.mapConfig.coordSys.maxX-this.mapConfig.coordSys.minX)/this._f427._f371));
if(x1<(this.mapConfig.coordSys.maxX-this.mapConfig.coordSys.minX)/this._f427._f371)
break;
}
}
}
else if(x1<0||x1>=(this.mapConfig.coordSys.maxX-this.mapConfig.coordSys.minX)/this._f427._f371||
x2<0||x2>=(this.mapConfig.coordSys.maxY-this.mapConfig.coordSys.minY)/this._f427._f372)
return this._f429;
var x3=this._f427._f375;
if(this.basemap.tileURLProvider)
{
var x4=this.basemap.tileURLProvider(
this.mapConfig.coordSys.minX+x1*this._f427._f371,
this.mapConfig.coordSys.minY+x2*this._f427._f372,
this._f427._f371,this._f427._f372,x3);
if(!x4)
return this._f429;
else
 return x4;
}
else
 return String(this._f411+"?request=gettile&format="+this._f412+"&zoomlevel="+x3+"&mapcache="+this._f107+"&mx="+x1+"&my="+x2);
}
_f408.prototype._f434=function(x5,x6,x7,x8)
{
if(!this.visible)
return ;
if(this.minVisibleLevel!=null&&this.minVisibleLevel>this.parent._f20)
{
this._f428.style.visibility="hidden";
return ;
}
if(this.maxVisibleLevel!=null&&this.maxVisibleLevel<this.parent._f20)
{
this._f428.style.visibility="hidden";
return ;
}
this.tileWidth=this.mapConfig.zoomLevels[this.parent._f20].tileImageWidth;
this.tileHeight=this.mapConfig.zoomLevels[this.parent._f20].tileImageHeight;
this._f415=x7;this._f416=x8;
this._f409=Math.ceil(this.tileWidth/2);
this._f410=Math.ceil(this.tileHeight/2);
this._f425=x5;this._f426=x6;
this._f27=x7;this._f28=x8;
this._f419=Math.ceil((x5+this._f409*2)/this.tileWidth);
this._f427=null;
this._f427=new _f370(this.mapConfig,x7,x8,this.parent._f20);
this.tileNumInCSBoun=Math.ceil((this.mapConfig.coordSys.maxX-this.mapConfig.coordSys.minX)/this._f427._f371);
this.parent._f75=this.tileWidth/this._f427._f371;this.parent._f77=this.tileHeight/this._f427._f372;
this.coverPixel=(this._f427._f371*this.tileNumInCSBoun-(this.mapConfig.coordSys.maxX-this.mapConfig.coordSys.minX))*this.parent._f75;
if(this.parent.wraparound)
{
var x9=(this._f419/this.tileNumInCSBoun)*this.coverPixel;
var x10=(this.tileWidth/2);
this._f419=this._f419+Math.ceil(x9/x10)+1;
}
this._f420=Math.ceil((x6+this._f410*2)/this.tileHeight);
this._f423=0;this._f424=0;
this.origParLeft=this.parent._f140;this.origParTop=this.parent._f141;
this._f436();
var x11=Math.floor(this._f419/2);
var x12=Math.floor(this._f420/2);
var x13=this._f425/2.0-(x7-this._f427.minX)*this.parent._f75;
var x14=this._f426/2.0+(x8-this._f427.minY)*this.parent._f77-this.tileHeight;
while(true)
{
var x15=x13-x11*this.tileWidth;
if(x15>0)
{
x11++;
continue;
}
var x16=x14-x12*this.tileHeight;
if(x16>0)
{
x12++;
continue;
}
var x17=x13+(this._f419-x11)*this.tileWidth-this._f425;
if(x17<0)
{
x11--;
continue;
}
var x18=x14+(this._f420-x12)*this.tileHeight-this._f426;
if(x18<0)
{
x12--;
continue;
}
var x19=x17+x15,x20=x18+x16;
if(x19>this.tileWidth)
{
x11++
continue;
}
else if(x19<(-1)*this.tileWidth)
{
x11--;
continue;
}
if(x20>this.tileHeight)
{
x12++;
continue;
}
if(x20<(-1)*this.tileHeight)
{
x12--;
continue;
}
break;
}
this._f417=x13-x11*this.tileWidth-this.parent._f140;
this._f418=x14-x12*this.tileHeight-this.parent._f141;
MVUtil._f73(this._f428,this._f417,this._f418);
this._f171(x11,x12,
this.tileWidth,this.tileHeight,
x11*this.tileWidth,x12*this.tileHeight);
this._f427._f376(-1,1);
var x21=Math.max(x11,this._f419-x11);
var x22=Math.max(x12,this._f420-x12);
for(_f194=1;_f194<=Math.max(x21,x22);_f194++)
{
for(xx=x11-_f194,yy=x12-_f194;
xx<=x11+_f194;xx++)
{
if(!(xx<0||xx>=this._f419||yy<0||yy>=this._f420))
{
this._f171(xx,yy,
this.tileWidth,this.tileHeight,
xx*this.tileWidth,yy*this.tileHeight);
}
this._f427._f376(1,0);
}
this._f427._f376(-(_f194*2+1),-1);
for(xx=x11-_f194,yy=x12-_f194+1;
yy<=x12+_f194-1;yy++)
{
if(!(xx<0||xx>=this._f419||yy<0||yy>=this._f420))
{
this._f171(xx,yy,
this.tileWidth,this.tileHeight,
xx*this.tileWidth,yy*this.tileHeight);
}
this._f427._f376(0,-1);
}
for(xx=x11-_f194,yy=x12+_f194;
xx<=x11+_f194;xx++)
{
if(!(xx<0||xx>=this._f419||yy<0||yy>=this._f420))
{
this._f171(xx,yy,
this.tileWidth,this.tileHeight,
xx*this.tileWidth,yy*this.tileHeight);
}
this._f427._f376(1,0);
}
this._f427._f376(-1,1);
for(xx=x11+_f194,yy=x12+_f194-1;
yy>=x12-_f194+1;yy--)
{
if(!(xx<0||xx>=this._f419||yy<0||yy>=this._f420))
{
this._f171(xx,yy,
this.tileWidth,this.tileHeight,
xx*this.tileWidth,yy*this.tileHeight);
}
this._f427._f376(0,1);
}
this._f427._f376(-(_f194*2+1),1);
}
this._f427._f376(_f194,-(_f194));
this._f427._f376(-x11+Math.floor(this._f419/2),
x12-Math.floor(this._f420/2));
}
_f408.prototype._f437=function()
{
if(!this.visible)
return ;
if(this.minVisibleLevel!=null&&this.minVisibleLevel>this.parent._f20)
{
this._f428.style.visibility="hidden";
return;
}
if(this.maxVisibleLevel!=null&&this.maxVisibleLevel<this.parent._f20)
{
this._f428.style.visibility="hidden";
return;
}
var x23=this.parent._f140+this._f423+this._f417;
var x24=this.parent._f141+this._f424+this._f418;
var x25=0,x26=0;
while(true)
{
var x27=x23-x25*this.tileWidth;
if(x27>0)
{
x25++;
continue;
}
var x28=x24-x26*this.tileHeight;
if(x28>0)
{
x26++;
continue;
}
var x29=x23+(this._f419-x25)*this.tileWidth-this._f425;
if(x29<0)
{
x25--;
continue;
}
var x30=x24+(this._f420-x26)*this.tileHeight-this._f426;
if(x30<0)
{
x26--;
continue;
}
var x31=x29+x27,x32=x30+x28;
if(x31>this.tileWidth)
{
x25++
continue;
}
else if(x31<(-1)*this.tileWidth)
{
x25--;
continue;
}
if(x32>this.tileHeight)
{
x26++;
continue;
}
if(x32<(-1)*this.tileHeight)
{
x26--;
continue;
}
break;
}
if(x25==0&&x26==0)
return ;
var x33=Math.floor(this._f419/2);
var x34=Math.floor(this._f420/2);
var x35=this._f427._f373-x33;
var x36=this._f427._f374+x34;
var x37;
if(x25!=0)
{
for(x37=0;(x25>0?x37<x25:x37>x25);(x25>0?x37++:x37--))
{
var x38;
var x39;
var x40;
if(x25>0)
x39=this._f423-(x37+1)*this.tileWidth;
else
 x39=this._f423+(this._f419-x37)*this.tileWidth;
if(x25>0)
{
x38=this._f422[this._f422.length-1];
this._f422.pop();
for(var x41=0;x41<x38.length;x41++)
{
this._f438(x38[x41],null);
if(x26==0||
(x26>0&&x41<x38.length-x26)||
(x26<0&&x41>=-x26))
{
this._f438(x38[x41],this._f435(x35-x37-1,x36-x41));
}if(this.parent.wraparound)
{
x38[x41].style.zIndex=x35-x37-1;
x40=this._f422[0][x41].style.zIndex;
if(x40%this.tileNumInCSBoun==0)
x38[x41].style.left=MVUtil._f31(parseInt(this._f422[0][x41].style.left)-this.tileWidth+this.coverPixel);
else
 x38[x41].style.left=MVUtil._f31(parseInt(this._f422[0][x41].style.left)-this.tileWidth);
}
else
 x38[x41].style.left=MVUtil._f31(x39);
}
this._f422.unshift(x38);
}
else
 {
x38=this._f422[0];
this._f422.shift();
for(var x41=0;x41<x38.length;x41++)
{
this._f438(x38[x41],null);
if(x26==0||
(x26>0&&x41<x38.length-x26)||
(x26<0&&x41>=-x26))
{
this._f438(x38[x41],this._f435(x35+this._f419-x37,x36-x41));
}
if(this.parent.wraparound)
{
x38[x41].style.zIndex=x35+this._f419-x37;
x40=this._f422[this._f422.length-1][x41].style.zIndex;
if(x40%this.tileNumInCSBoun==(this.tileNumInCSBoun-1)||x40%this.tileNumInCSBoun==-1)
x38[x41].style.left=MVUtil._f31(parseInt(this._f422[this._f422.length-1][x41].style.left)+this.tileWidth-this.coverPixel);
else
 x38[x41].style.left=MVUtil._f31(parseInt(this._f422[this._f422.length-1][x41].style.left)+this.tileWidth);
}
else
 x38[x41].style.left=MVUtil._f31(x39);
}
this._f422.push(x38);
}
}
}
if(x26!=0)
{
var x42;
for(x42=0;(x26>0?x42<x26:x42>x26);(x26>0?x42++:x42--))
{
var x43;
if(x26>0)
x43=this._f424-(x42+1)*this.tileHeight;
else
 x43=this._f424+(this._f420-x42)*this.tileHeight;
for(x37=0;x37<this._f422.length;x37++)
{
var x38=this._f422[x37];
var x44;
if(x26>0)
{
x44=x38[x38.length-1];
this._f438(x44,null);
x38.pop();
x38.unshift(x44);
x44.style.top=MVUtil._f31(x43);
this._f438(x44,this._f435(x35-x25+x37,x36+x42+1));
}
else
 {
x44=x38[0];
this._f438(x44,null);
x38.shift();
x38.push(x44);
x44.style.top=MVUtil._f31(x43);
this._f438(x44,this._f435(x35-x25+x37,x36-this._f420+x42));
}
}
}
}
if(this.parent.wraparound)
this._f423=parseInt(this._f422[0][0].style.left);
else
 this._f423=this._f423-x25*this.tileWidth;
this._f424=this._f424-x26*this.tileHeight;
this._f427._f376(-x25,x26);
}
_f408.prototype._f171=function(x45,x46,x47,x48,x49,x50)
{
var x51=this._f435(this._f427._f373,this._f427._f374);
var x52=this._f422[x45][x46];
if(x52==null)
{
x52=(_f10._f68()&&this._f414)?
document.createElement('div'):document.createElement('img');
this._f428.appendChild(x52);
this._f422[x45][x46]=x52;
}
_f10.c=0;
if(_f10._f69=="IF"&&!this._f414)
{
x52.galleryImg="no"}
else
 {
x52.style.MozUserSelect="none";
}
MVUtil._f146(x52);
x52.style.position="absolute";
if(this.parent.wraparound)
{
x52.style.zIndex=this._f427._f373;
if(this._f427._f373<0)
{
x52.style.left=MVUtil._f31(x49-this.coverPixel*Math.floor(x52.style.zIndex/this.tileNumInCSBoun));
}
else if(this._f427._f373>=(this.mapConfig.coordSys.maxX-this.mapConfig.coordSys.minX)/this._f427._f371)
{
x52.style.left=MVUtil._f31(x49-this.coverPixel*Math.floor(x52.style.zIndex/this.tileNumInCSBoun));
}
else
 {
x52.style.left=MVUtil._f31(x49);
}
}
else
 x52.style.left=MVUtil._f31(x49);
x52.style.top=MVUtil._f31(x50);
if(_f10._f69=="IF")
{
x52.style.width=MVUtil._f31(x47);
x52.style.height=MVUtil._f31(x48);
}
if((this.zoomControl)&&(this.zoomControl.zooming))
x52.style.display='none';
var x53=this;
x52.imgLoadFinished=false;
x52.onload=function()
{
x52.imgLoadFinished=true;
x52.onload=null;
x52.style.display='';
};
this._f438(x52,x51);
return x52;
}
_f408.prototype._f436=function()
{
if(!(this._f428.zooming))
{
this._f428.parentNode.removeChild(this._f428);
MVUtil._f91(this._f428);
}
this._f428=document.createElement("div");
this._f428.style.position="absolute";
this.parent.div.appendChild(this._f428);
this._f428.style.zIndex=this.zIndex;
this._f422=new Array();
for(var x54=0;x54<this._f419;x54++)
{
var x55=new Array();
for(var x56=0;x56<this._f420;x56++)
{
var x57;
if(_f10._f68())
{
x57=MVUtil._f171(null,this._f414);
}
else
 {
x57=MVUtil._f171(this._f429,this._f414);
}
this._f428.appendChild(x57);
x55.push(x57);
}
this._f422.push(x55);
}
}
_f408.prototype.destroy=function()
{
while(this._f422.length>0)
{
var x58=this._f422.pop();
while(x58.length>0)
{
if(_f10._f68()&&this._f414)
{
MVUtil._f91(x58.pop());
}
else
 {
var x59=x58.pop();
if(x59!=null)
{
this._f428.removeChild(x59);
delete x59;
}
}}}
this._f428.parentNode.removeChild(this._f428);
this._f428=null;
this.zIndex=null;
}
_f408.prototype.getXMLForPrint=function()
{
var x60="<map_cache_theme map_cache_name=\""+this._f107+"\" snap_to_cache_scale=\"true\" ";
if(this._f411!="")
{
var x61=this._f411.substring(0,this._f411.lastIndexOf("/"));
if(x61.indexOf(this.parent._f4)<0)
{
x61+="/";
x60+="mapviewer_url=\""+x61+"\"";
}
}
return x60+"/>";
}
_f408.prototype._f438=function(x62,x63)
{
if(x63)
{
x62.imgSrc=x63;
if(this.basemap._f439)
{
x63=x63+"&reload="+this.basemap._f439;
}
}
if(_f10._f68()&&this._f414)
{
if(x63)
x62.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+
x63+"', sizingMethod='image');";
else
 x62.style.filter="";
}
else
 {
if(x63)
x62.src=x63;
else
 x62.src=this._f429;
}
}
_f408.prototype._f440=function()
{
for(var x64=0;x64<this._f419;x64++)
for(var x65=0;x65<this._f420;x65++)
{
var x66=this._f422[x64][x65];
this._f438(x66,x66.imgSrc);
}
}
_f408.zIndexCount=1;
function MVArrayParameter(x0,x1,x2)
{
this.array=x0;
this.elementType=x1;
if(x2==undefined||!x2)
{
if(x1==MVArrayParameter.STRING_ARRAY)
x2='MV_STRINGLIST';
else
 x2='MV_NUMBERLIST';
}
this.sqlType=x2;
}
function ArrayParameter(x0,x1,x2)
{
this.array=x0;
this.elementType=x1;
this.sqlType=x2;
}
MVArrayParameter.STRING_ARRAY='sarray';
MVArrayParameter.NUMBER_ARRAY='narray';
function MVThemeBasedFOI(x0,x1,x2)
{
if(!x1)
{
MVi18n._f6("MVThemeBasedFOI.constructor","MAPVIEWER-05519","theme");
return ;
}
this.name=x0;
this.parent=null;
this._f3=x2;
this._f58=-1;
this._f59=100;
this._f186=true;
this.minX=0;
this.minY=0;
this.maxX=0;
this.maxY=0;
this._f97=new Array();
this._f96=null;
this._f134=null;
this._f179=null;
this._f182=null;
this._f183=null;
this._f188=null;
this._f154=null;
this._f42=null;
this._f50=2;
this._f51=2;
this._f160=true;
this._f180=true;
this._f72=true;
this._f43=null;
this._f841=null;
this._f124=null;
this._f303=null;
this._f104=null;
this._f70=-1;
this._f103=-1;
this._f795=false;
this._f796=false;
this._f111=new Array();
this._f110=null;
this._f798=true;
this.visible=true;
this._f173=true;
this.cursorStyle="pointer";
this._f101=false;
this._f102=null;
this._f71=true;
this.renderLabels=false;
this._f184=false;
this._f112=true;
this._f304=true;
this._f305=null;
this._f246=null;
this._f40=false;
if(x1!=null)
{
this._f42=x1;
if(x1.indexOf("</jdbc_query>")>=0)
this._f40=true;
}
this._f121=null;
this._f12=null;
this._f138=0;
this._f139=0;
this._f187=false;
this._f190=0;
this._f169=new Array();
this._f168=new Object();
this._f100=null;
this._f129=null;
this.queryParameterArray=null;
this._f66=null;
this.bgColor=null;
this._f113=false;
this._f114=-1;
this._f115=-1;
this._f116=false;
this._f117="N";
this.reuseIENode=false;
}
MVThemeBasedFOI.prototype.setLayoutCustomizer=function(x0)
{
this._f154=x0;
this.reuseIENode=false;
}
MVThemeBasedFOI.prototype.enableHighlight=function(x1)
{
if(!x1)
this.deHighlight();
this._f187=x1;
}
MVThemeBasedFOI.prototype.setHighlightMode=function(x2)
{
switch(x2)
{
case "single":
this._f190=-1;
break;
case "multiple":
this._f190=0;
break;
default:
MVi18n._f6("MVThemeBasedFOI.setHighlightMode","MAPVIEWER-05519","mode");
}
}
MVThemeBasedFOI.prototype.setHighlightStyle=function(x3)
{
var x4=false;
if(x3!=null)
{
if(typeof(x3)=="object"&&x3.getXMLString!=null)
this._f100=encodeURIComponent(x3.getXMLString());
else if(typeof(x3)=="string")
this._f100=encodeURIComponent(x3);
else
 x4=true;
}
else
 x4=true;
if(x4)
MVi18n._f6("MVThemeBasedFOI.setHighlightStyle","MAPVIEWER-05519","highliteStyle");
this.reuseIENode=false;
}
MVThemeBasedFOI.prototype.setHighlightMarkerImage=function(x5,x6,x7)
{
this._f129=null;
var x8=true;
if(!x5||typeof(x5)!="string")
x8=false;
if(x8&&(!x6||isNaN(x6)))
x8=false;
if(x8&&(!x7||isNaN(x7)))
x8=false;
if(x8)
this._f129=new _f842(x5,x6,x7);
else
 MVi18n._f6("MVThemeBasedFOI.setHighlightMarkerImage","MAPVIEWER-05519");
this.reuseIENode=false;
}
MVThemeBasedFOI.prototype.highlight=function(x9)
{
if(!this._f187)
{
MVi18n._f6("MVThemeBasedFOI.highlight","MAPVIEWER-05524");
return;
}
var x10=false;
if(x9==null)
{
x10=true;
}
else if(typeof(x9)!="object"||(len=x9.length)==null||x9.length<1)
{
MVi18n._f6("MVThemeBasedFOI.highlight","MAPVIEWER-05519","foiIdArray");
return;
}
var x11=this._f169;
var x12=this._f168;
var x13=this._f124.foiarray;
var x14=x13.length;
for(var x15=0;x15<x14;++x15)
{
var x16=x13[x15];
var x17=x10;
if(x16!=null&&x16.id!=null&&x12[x16.nodeId]==null)
{
if(!x17)
{
for(var x18=0;x18<x9.length;x18++)
if(x16.id==x9[x18])
{
x17=true;
break;
}
}
if(x16.nodeId!=null&&x17)
{
x12[x16.nodeId]=x11.length;
x11.push(x16);
x16._f153=true;
this._f12.highlightFOI(this._f12,x16);
}
}
}
}
MVThemeBasedFOI.prototype.deHighlight=function(x19)
{
if(!this._f187)
{
MVi18n._f6("MVThemeBasedFOI.deHighlight","MAPVIEWER-05524");
return;
}
var x20=this._f169;
var x21=this._f168;
var x22=x20.length;
if(x22<1)
return;
var x23=null;
if(x19!=null&&(typeof(x19)!="object"||(x23=x19.length)==null))
{
MVi18n._f6("MVThemeBasedFOI.deHighlight","MAPVIEWER-05519","foiIdArray");
return;
}
if(x19!=null&&x23<1)
return;
var x24=false;
if(x19==null){
x24=true;
}
for(var x25=x20.length;x25>=0;x25--)
{
var x26=x20[x25];
var x27=x24;
if(x26!=null&&x26.id!=null)
{
if(!x27)
{
for(var x28=0;x28<x19.length;x28++)
if(x26.id==x19[x28])
{
x27=true;
break;
}
}
if(x27)
{
x21[x26.nodeId]=null;
x20[x25]=null;
x20.pop();
x26._f153=false;
this._f12.deHighlightFOI(this._f12,x26);
}
}
}
}
MVThemeBasedFOI.prototype.getHighlightedFOIData=function()
{
var x29=new Array();
if(this._f169!=null)
{
for(var x30=0;x30<this._f169.length;x30++)
if(this._f169[x30]!=null)
x29.push(this._f169[x30]);
}
return x29;
}
MVThemeBasedFOI.prototype.setQueryParameters=function()
{
if(arguments.length<=0)
return ;
this._f43="&paramnum="+arguments.length;
this.queryParameterArray=new Array(arguments.length);
for(var x31=0;x31<arguments.length;x31++)
{
if(typeof arguments[x31]=="object")
{
this._f43+=this.setObjectQueryParameters(arguments[x31],x31+1);
if(arguments[x31].gtype!=undefined)
this.queryParameterArray[x31]={type:"geometry",value:arguments[x31]};
else
 {
var x32=arguments[x31].elementType==MVArrayParameter.STRING_ARRAY?"String":"double";
this.queryParameterArray[x31]={elemtype:x32,value:arguments[x31].array,type:arguments[x31].sqlType};
}
}
else
 {
this._f43+="&param"+(x31+1)+"="+encodeURIComponent(arguments[x31]);
this.queryParameterArray[x31]={value:arguments[x31]};
}
}
return this._f43;
}
MVThemeBasedFOI.prototype.setObjectQueryParameters=function(x33,x34)
{
if(!x33)
return "";
if(x33.gtype!=undefined)
return "&param"+x34+"="+encodeURI(x33)+"&paramtype"+x34+"=geometry";
else
 {
var x35="";
if(x33.array)
{
if(x33.array.substring!=undefined)
x35=x33.array;
else
 {
this.escapeQuote(x33.array);
for(var x36=0;x36<x33.array.length;x36++)
{
if(x36>0)
x35+=",";
x35+="\""+x33.array[x36]+"\"";
}
}
}
return "&param"+x34+"="+encodeURIComponent(x35)+"&paramtype"+x34+"="+x33.elementType+
"&sqltype"+x34+"="+x33.sqlType;
}
}
MVThemeBasedFOI.prototype.getQueryParameters=function()
{
return this._f43;
}
MVThemeBasedFOI.prototype.setMinVisibleZoomLevel=function(x37)
{
this._f58=x37;
}
MVThemeBasedFOI.prototype.setMaxVisibleZoomLevel=function(x38)
{
this._f59=x38;
}
MVThemeBasedFOI.prototype.setBringToTopOnMouseOver=function(x39)
{
this._f186=x39;
}
MVThemeBasedFOI.prototype.setMaxWholeImageLevel=function(x40)
{
this._f70=x40;
this._f113=false;
}
MVThemeBasedFOI.prototype.setMinClickableZoomLevel=function(x41)
{
this._f103=x41;
}
MVThemeBasedFOI.prototype.enableInfoTip=function(x42)
{
this._f160=x42;
}
MVThemeBasedFOI.prototype.enableInfoWindow=function(x43)
{
this._f180=x43;
}
MVThemeBasedFOI.prototype.enableInfoWindowForMouseOver=function(x44)
{
this._f184=x44;
}
MVThemeBasedFOI.prototype.enableInfoWindow=function(x45)
{
this._f180=x45;
}
MVThemeBasedFOI.prototype.setClickable=function(x46)
{
this._f72=x46;
if(this._f12)
{
this._f12._f123();
if(this._f12._f33)
{
if(x46&&this.isVisible())
this._f12._f33.style.visibility="visible";
else if(!x46)
this._f12._f33.style.visibility="hidden";
}
}
}
MVThemeBasedFOI.prototype.addEventListener=function(x47,x48)
{
this.setEventListener(x47,x48);
}
MVThemeBasedFOI.prototype.setEventListener=function(x49,x50)
{
if(x49==MVEvent.BEFORE_REFRESH)
{
this._f96=x50;
}
else if(x49==MVEvent.AFTER_REFRESH)
{
this._f134=x50;
}
else if(x49==MVEvent.MOUSE_CLICK)
{
this._f179=x50;
}
else if(x49==MVEvent.MOUSE_RIGHT_CLICK)
{
this._f182=x50;
}
else if(x49==MVEvent.MOUSE_OVER)
{
this._f183=x50;
}
else if(x49==MVEvent.MOUSE_OUT)
{
this._f188=x50;
}
}
MVThemeBasedFOI.prototype.attachEventListener=function(x51,x52)
{
MVUtil.attachEventListener(this._f97,x51,x52)
}
MVThemeBasedFOI.prototype.detachEventListener=function(x53,x54)
{
MVUtil.detachEventListener(this._f97,x53,x54);
}
MVThemeBasedFOI.prototype.setQueryWindowMultiplier=function(x55)
{
this._f50=x55;
this._f51=x55;
}
MVThemeBasedFOI.prototype.getQueryWindow=function()
{
if(!this.parent)
{
MVi18n._f6("MVThemeBasedFOI.getQueryWindow","MAPVIEWER-05525",this.name);
return ;
}
var x56=MVSdoGeometry.createRectangle(this.minX,this.minY,this.maxX,this.maxY,this.parent.srid);
return x56;
}
MVThemeBasedFOI.prototype.getLayerMBR=MVThemeBasedFOI.prototype.getQueryWindow;
MVThemeBasedFOI.prototype.getMBR=function()
{
if(this._f121)
return MVSdoGeometry.createRectangle(this._f121[0],this._f121[1],this._f121[2],this._f121[3],this.parent.srid);
else
 return null;
}
MVThemeBasedFOI.prototype.setMarkerImage=function(x57,x58,x59)
{
if(x57)
this._f841=new _f842(x57,x58,x59);
else
 this._f841=null;
this.reuseIENode=false;
}
MVThemeBasedFOI.prototype.getThemeName=function()
{
return this._f42;
}
function _f842(x0,x1,x2)
{
this._f130=x0;
this.width=x1;
this.height=x2;
}
MVThemeBasedFOI.prototype.getFOIMarker=function()
{
return this._f841;
}
MVThemeBasedFOI.prototype.setVisible=function(x60)
{
this.visible=x60;
if(this.parent&&this.parent._f79)
this.parent._f79._f292();
if(this._f12)
this._f12.setVisible(this.parent,x60);
}
MVThemeBasedFOI.prototype.setInfoWindowStyle=function(x61,x62)
{
this._f303=x61;
this._f246=x62;
}
MVThemeBasedFOI.prototype.isVisible=function()
{
if(this._f12)
{
return this._f12.isVisible();
}
else
 return this.visible;
}
MVThemeBasedFOI.prototype.refresh=function(x63)
{
if(!this.parent)
{
MVi18n._f6("MVThemeBasedFOI.refresh","MAPVIEWER-05525",this.name);
return ;
}
this.parent._f125();
if(this._f12)
{
var x64=this._f12;
var x65=this.parent._f792(x64);
if(x63)
x63=true;
else
 x63=false;
x64._f78(this.parent,x65[0],x65[1],x65[2],x65[3],true,x63,!x63);
}
}
MVThemeBasedFOI.prototype.getFOIData=function()
{
if(this._f124==null||this._f124.foiarray==null)
{
return null;
}
else
 return this._f124.foiarray;
}
MVThemeBasedFOI.prototype.setNSDP=function(x66)
{
this._f104=x66;
}
MVThemeBasedFOI.prototype.setBoundingTheme=function(x67,x68)
{
this._f795=x67;
if(x68)
this._f796=true;
else
 this._f796=false;
}
MVThemeBasedFOI.prototype.zoomToTheme=function()
{
if(!this.parent)
{
MVi18n._f6("MVThemeBasedFOI.zoomToTheme","MAPVIEWER-05525",this.name);
return ;
}
this.refresh(true);
}
MVThemeBasedFOI.prototype.centerToTheme=function()
{
if(!this.parent)
{
MVi18n._f6("MVThemeBasedFOI.centerToTheme","MAPVIEWER-05525",this.name);
return ;
}
this.parent._f125();
if(this._f12)
{
var x69=this._f12;
var x70=this.parent._f792(x69);
x69._f78(this.parent,x70[0],x70[1],x70[2],x70[3],true,true,false,false,true);
}
}
MVThemeBasedFOI.prototype.addStyle=function(x71)
{
var x72=this._f111.concat(x71);
this._f111=null;
this._f111=x72;
}
MVThemeBasedFOI.prototype.deleteStyle=function(x73)
{
var x74=-1;
for(var x75=0;x75<this._f111.length;x75++)
{
var x76=this._f111[x75];
if(x76!=null&&x76==x73)
{
x74=x75;
break;
}
}
if(x74<0)
return;
var x77=0;
var x78=new Array(this._f111.length-1);
for(var x75=0;x75<this._f111.length;x75++)
{
if(x75!=x74)
{
x78[x77]=this._f111[x75];
x77++;
}
}
this._f111=null;
this._f111=x78;
}
MVThemeBasedFOI.prototype.deleteAllStyles=function()
{
for(var x79=0;x79<this._f111.length;x79++)
this._f111[x79]=null;
this._f111=new Array();
}
MVThemeBasedFOI.prototype.setRenderingStyle=function(x80)
{
this._f110=x80;
this.reuseIENode=false;
}
MVThemeBasedFOI.prototype.setAutoRefresh=function(x81)
{
this._f798=x81;
}
MVThemeBasedFOI.prototype.enableEventPropagation=function(x82)
{
this._f173=x82;
}
MVThemeBasedFOI.prototype.setMouseCursorStyle=function(x83)
{
this.cursorStyle=x83;
if(this._f12)
{
MVUtil._f164(this._f12.div,x83);
if(this._f124&&this._f124.foiarray&&this._f12._f165)
{
for(var x84=0;x84<this._f124.foiarray.length;x84++)
{
if(this._f124.foiarray[x84]&&this._f124.foiarray[x84].areaNode)
{
var x85=this._f124.foiarray[x84].areaNode;
if(x85 instanceof Array)
{
for(var x86=0;x86<x85.length;x86++)
MVUtil._f164(this._f124.foiarray[x84].areaNode[x86],x83);
}
else
 MVUtil._f164(this._f124.foiarray[x84].areaNode,x83);
}
}
}
}
}
MVThemeBasedFOI.prototype.setHighlightOnly=function(x87)
{
this._f101=x87;
}
MVThemeBasedFOI.prototype.setFilteringGeom=function(x88)
{
this._f102=x88;
}
MVThemeBasedFOI.prototype.getFilteringGeom=function()
{
return this._f102;
}
MVThemeBasedFOI.prototype.enableImageRendering=function(x89)
{
this._f71=x89;
}
MVThemeBasedFOI.prototype.enableLabels=function(x90)
{
this.renderLabels=x90;
}
MVThemeBasedFOI.prototype.enableImageCaching=function(x91)
{
this._f112=x91;
}
MVThemeBasedFOI.prototype.getLayerName=function()
{
return this.name;
}
MVThemeBasedFOI.prototype.setInfoWindowTitle=function(x92)
{
this._f305=x92;
}
MVThemeBasedFOI.prototype.setScreenOffset=function(x93,x94)
{
if(x93==undefined||isNaN(x93))
x93=0;
if(x94==undefined||isNaN(x94))
x94=0;
this._f138=parseInt(x93);
this._f139=parseInt(x94);
}
MVThemeBasedFOI.prototype.setNameAsInfoWindowTitle=function(x95)
{
this._f304=x95;
}
MVThemeBasedFOI.prototype.setImageFormat=function(x96,x97)
{
if(x96)
{
this._f66=x96.toUpperCase();
if(this._f66=="PNG8"&&x97)
this.bgColor=x97;
}
this.reuseIENode=false;
}
MVThemeBasedFOI.prototype.enableAutoWholeImage=function(x98,x99,x100)
{
if(x99!=undefined)
this._f114=x99;
if(x100!=undefined)
this._f115=x100;
this._f113=x98;
}
MVThemeBasedFOI.prototype.abort=function()
{
if(this._f12)
this._f12.abort();
}
MVThemeBasedFOI.prototype.enableMarkerSequence=function(x101,x102)
{
this._f116=x101;
if(x101)
{
if(x102)
this._f117=x102;
}
}
MVThemeBasedFOI.prototype.escapeQuote=function(x103)
{
if(x103&&x103.length>0&&x103.indexOf==undefined)
{
for(var x104=0;x104<x103.length;x104++)
{
if(x103[x104]&&x103[x104].length!=undefined)
x103[x104]=MVUtil._f48(x103[x104],"\"","\\\"");
}
}
}
MVThemeBasedFOI.prototype.getAllStyles=function()
{
return this._f111;
}
MVThemeBasedFOI.prototype.getStyleByName=function(x105)
{
if(x105==null||x105=="")
return;
for(var x106=0;x106<this._f111.length;x106++)
{
var x107=this._f111[x106];
if(x107!=null&&x107.name==x105)
{
return x107;
break;
}
}
}
MVThemeBasedFOI.prototype.isWholeImage=function()
{
if(this._f12)
return this._f12.isWholeImage();
else
 return false;
}
function _f0(x0,x1)
{
this.parent=x0;
this._f2=false;
if(!x1._f3)
{
if(this.parent._f4)
{
if(MVUtil._f5(this.parent._f4,'/'))
x1._f3=this.parent._f4+'foi';
else
 x1._f3=this.parent._f4+'/foi';
}
else
 {
MVi18n._f6("MVThemeBasedFOIControl.constructor","MAPVIEWER-05504");
return ;
}
}
if(MVMapView._f7&&MVUtil._f8(x1._f3)!=MVUtil._f8(this.parent._f9))
x1._f3=_f10._f11()+"?rtarget="+x1._f3;
x1._f12=this;
this._f1=x1;
this._f13=0;
this._f14=0;
this.width=0;
this.height=0;
this.minX=0;
this.minY=0;
this.maxX=0;
this.maxY=0;
this._f15=0;
this._f16=0;
this._f17=0;
this._f18=0;
this._f19=true;
this._f20=0;
this._f21=true;
this._f22=false;
this._f23=0;
this._f24=0;
this._f25=0;
this._f26=0;
this._f27=0;
this._f28=0;
this._f29=false;
this._f30=1;this.div=document.createElement("div");
this.div.style.position="absolute";
this.div.style.left=MVUtil._f31(0);
this.div.style.top=MVUtil._f31(0);
this._f32=0;
if(!x1.visible)
this.div.style.visibility="hidden";
this.parent.div.appendChild(this.div);
this._f33=null;
this._f34=null;
this._f35=false;
this.themeId=null;
this.abortionSupported=true;
this._f36();
this._f37=true;
this._f38=false;
this.t1=0;
this.t2=0;
this.t3=0
this.mouseL1=MVSdoGeometry.createPoint(0,0);
this.mouseL2=this.mouseL1;
}
_f0.prototype._f39=function()
{
if(this._f1._f40)
return this._f41(this._f1._f42);
else if(this._f1._f43==null)
return "<theme name=\""+MVUtil._f44(this._f1._f42)+
"\" render_labels=\""+this._f1.renderLabels+"\" datasource=\""+
MVUtil._f45(this._f1._f42)+"\""+
this._f46()+
this._f47()+"/>";
else
 {
var x0="<theme name=\""+MVUtil._f44(this._f1._f42)+
"\" render_labels=\""+this._f1.renderLabels+"\" datasource=\""+
MVUtil._f45(this._f1._f42)+"\""+
this._f46()+
this._f47()+">\n"+
"  <binding_parameters>\n";
for(var x1=0;x1<this._f1.queryParameterArray.length;x1++)
{
var x2=this._f1.queryParameterArray[x1];
x0+="<parameter ";
if(x2.type==undefined)
x0+="value=\""+x2.value+"\">";
else
 {
x0+="type=\""+x2.type+"\" ";
if(x2.type=="geometry")
{
x0+=">"+x2.value.toGML();
}
else {
x0+="elemtype=\""+x2.elemtype+"\" ";
if(!x2.value)
x0+=">";
else
 {
if(x2.value.substring!=undefined)
{
var x3=x2.value;
if(x2.elemtype=="String")
{
var x4=x2.value.split(",");
finalvalue="";
for(var x5=0;x5<x4.length;x5++)
{
if(x5>0)
finalvalue+=",";
var x6=x4[x5].indexOf("\"");
var x7=x4[x5].lastIndexOf("\"");
finalvalue+=x4[x5].substring(x6+1,x7);
}
x3=finalvalue;
}
x0+="value=\""+MVUtil._f48(x3,"\"","&quot;")+"\">";
}
else
 {
x0+=">";
for(var x5=0;x5<x2.value.length;x5++)
x0+="<elem>"+x2.value[x5]+"</elem>";
}
}
}
}
x0+="</parameter>";
}
x0+="  </binding_parameters>\n";
x0+="</theme>";
return x0;
}
}
_f0.prototype.setSize=function(x8,x9)
{
this.width=x8;
this.height=x9;
}
_f0.prototype._f49=function(x10,x11)
{
if(!this._f2)
{
if(this._f1._f50==1&&this._f1._f51==1)
{
this._f13=this.width;
this._f14=this.height;
}
else
 {
this._f13=x10;
this._f14=x11;
}
}
}
_f0.prototype._f52=function()
{
return this._f29;
}
_f0.prototype._f53=function()
{
return this.request;
}
_f0.prototype._f54=function()
{
return this.minX;
}
_f0.prototype._f55=function()
{
return this.minY;
}
_f0.prototype._f56=function()
{
return this.maxX;
}
_f0.prototype._f57=function()
{
return this.maxY;
}
_f0.prototype.isVisible=function()
{
if(this._f20<this._f1._f58||this._f20>this._f1._f59)
return false;
else
 return !(this.div.style.visibility=='hidden');
}
_f0.prototype._f60=function()
{
return this.div;
}
_f0.prototype.getThemeBasedFOI=function()
{
return this._f1;
}
_f0.prototype._f61=function()
{
return this._f25;
}
_f0.prototype._f62=function()
{
return this._f26;
}
_f0.prototype._f63=function(x12)
{
this._f25=x12;
}
_f0.prototype._f64=function(x13)
{
this._f26=x13;
}
_f0.prototype._f65=function()
{
return this._f1._f66?this._f1._f66:this.parent._f67;
}
_f0.prototype._f68=function()
{
return _f10._f69=="IF"&&this._f65()=="PNG24";
}
_f0.prototype.isWholeImage=function()
{
return this._f1._f70>=this._f20||this._f35;
}
_f0.prototype.setVisible=function(x14,x15)
{
if(x15)
{
if(!this.isVisible())
{
if(this._f22)
{
if((!this._f68()&&this._f1.getFOIData()!=null&&
this._f1.getFOIData()[0].gtype%10!=1)||
this.isWholeImage()||!this._f1._f71)
{
if(this._f1._f72&&this._f33)
this._f33.style.visibility="visible";
}
}
this.div.style.visibility="visible";
if(!this._f21)
{
MVUtil._f73(this.div,Math.ceil((this.minX-this.parent._f74)*this.parent._f75),
-Math.ceil((this.maxY-this.parent._f76)*this.parent._f77));
this._f78(this.parent,this.minX,this.minY,this.maxX,this.maxY,true);
}
}
}
else
 {
if(this._f22)
{
if((!this._f68()&&this._f1.getFOIData()!=null&&
this._f1.getFOIData()[0].gtype%10!=1)||
this.isWholeImage()||!this._f1._f71)
{
if(this._f33)
this._f33.style.visibility="hidden";
if(this.parent._f79._f80.length>0)
{
for(var x16=0;x16<this.parent._f81.childNodes.length;x16++)
{
if(this.parent._f79._f80[0].nid==this.parent._f81.childNodes[x16].id)
{
this.parent._f79.deleteInfoWindow(this.parent._f79._f80[0]);
break;
}
}
}
}
else if(this.parent._f79._f80.length>0)
{
for(var x17=0;x17<this.div.childNodes.length;x17++)
{
if(this.parent._f79._f80[0].nid==this.div.childNodes[x17].id)
{
this.parent._f79.deleteInfoWindow(this.parent._f79._f80[0]);
break;
}
}
}
}
this.div.style.visibility="hidden";
this._f29=false;
this.parent._f82();
}
}
_f0.prototype._f83=function()
{
if(this._f29)
return this._f23;
else
 return MVUtil._f83(this.div);
}
_f0.prototype._f84=function()
{
if(this._f29)
return this._f24;
else
 return MVUtil._f84(this.div);
}
_f0.prototype._f85=function(x18)
{
if(this._f29)
this._f23=x18;
}
_f0.prototype._f86=function(x19)
{
if(this._f29)
this._f24=x19;
}
_f0.prototype._f87=function()
{
return this.width;
}
_f0.prototype._f88=function()
{
return this.height;
}
_f0.prototype._f89=function()
{
this._f90();
while(this.div.childNodes.length>0)
{
var x20=this.div.childNodes[0];
this.div.removeChild(x20);
if(this.parent._f79._f80.length>0)
if(this.parent._f79._f80[0].nid==x20.id)
{
this.parent._f79.deleteInfoWindow(this.parent._f79._f80[0]);
}
MVUtil._f91(x20);
}
}
_f0.prototype._f90=function(x21)
{
this.clearAllStarted=true;
var x22=null;
if(this.div.parentNode)
{
x22=this.div.parentNode;
x22.removeChild(this.div);
}
while(this.div.childNodes.length>0)
{
var x23=this.div.childNodes[0];
this.div.removeChild(x23);
while(x23.childNodes.length>0)
{
var x24=x23.childNodes[0];
x23.removeChild(x24);
MVUtil._f91(x24);
}
MVUtil._f91(x23);
}
this.wholeImage=null;
if(this._f30!=1&&!x21)
{
this.clearTransImageLayer();
}
if(x22)
x22.appendChild(this.div);
this.clearAllStarted=false;
}
_f0.prototype.clearTransImageLayer=function()
{
if(this._f33&&this._f33.parentNode)
{
this._f33.parentNode.removeChild(this._f33);
MVUtil._f91(this._f33);
}
this._f33=null;
this._f34=null;
}
_f0.prototype.getImageParameters=function()
{
var x25="";
var x26=this._f65();
if(x26=="PNG8")
x25+="&format="+x26;
if(this._f1.bgColor)
x25+="&bgcolor="+this._f1.bgColor;
return x25;
}
_f0.prototype._f78=function(x27,x28,x29,x30,x31,x32,
x33,x34,x35,x36)
{
this._f38=false;
this._f35=false;
var x37=this;
var x38=function()
{
if(!x37.themeId&&x37.abortionSupported)
{
setTimeout(x38,50);
return ;
}
if(!x36)
x36=false;
if(!x35&&!x27._f92)
{
var x39=[x27,x28,x29,x30,x31,x32,x33,x34,x36];
var x40=x37._f78;
var x41={obj:x37,func:"refreshFOIs",params:x39};
x27._f93.push(x41);
return ;
}
x37._f29=true;
if(!x37._f2)
{
x37._f1.minX=x37.minX=x28;
x37._f1.minY=x37.minY=x29;
x37._f1.maxX=x37.maxX=x30;
x37._f1.maxY=x37.maxY=x31;
}
x37._f23=Math.ceil((x37.minX-x37.parent._f74)*x37.parent._f75);
x37._f24=-Math.ceil((x37.maxY-x37.parent._f76)*x37.parent._f77);
MVUtil._f73(x37.div,x37._f23,x37._f24);
x37.div.style.display='none';
x37._f27=x37.parent._f94;
x37._f28=x37.parent._f95;
if(x37._f1._f96)
{
x37._f1._f96();
}
if(x37._f1)
MVUtil.runListeners(x37._f1._f97,MVEvent.BEFORE_REFRESH);
x37._f19=x32;
x37._f20=x37.parent._f20;
x37._f98();
x37.around=x37.parent.wrapAroundLayer(x37._f87());
if(!x37._f1.visible||
!x33&&(x37._f20<x37._f1._f58||x37._f20>x37._f1._f59))
{
x37._f21=false;
x37._f2=false;
x37._f90();
return;
}
x37._f21=true;
if(x37._f2)
{
x37._f99();
return ;
}
x37.adjustBBox(x33);
if(x37.adjustedRealWidth<=0||x37.adjustedRealHeight<=0)
return;
var x42="request=getfoi&version=1.0"+x37.getImageParameters()+
"&theme="+encodeURIComponent(x37._f1._f42)+"&bbox="+
x37._f15+":"+x37._f16+":"+
x37._f17+":"+x37._f18+
"&width="+x37.adjustedRealWidth+"&height="+x37.adjustedRealHeight;
if(x37.adjustedMinX2)
x42+="&bbox2="+x37.adjustedMinX2+":"+x37._f16+":"+
x37.adjustedMaxX2+":"+x37._f18;
if(x37._f1._f100!=null)
x42+="&hilitestyle="+x37._f1._f100;
if(x37._f1._f101==true){
if(!x37._f1._f102)
{
MVi18n._f6("MVThemeBasedFOIControl.refreshFOIs","MAPVIEWER-05514");
return;
}
x37._f1.setQueryParameters(x37._f1._f102);
x42+="&hilite=yes";
}
if(x37._f1.getQueryParameters())
{
x42+=x37._f1.getQueryParameters();
}
if(x37._f1.getFOIMarker()||
!x37._f1._f71)
{
x42+="&renderimg=no";
}
if(x37._f1._f103<=x37._f20)
{
x42+="&clickable=yes";
}
else
 {
x42+="&clickable=no";
}
if(!x37._f68()||
x37._f1._f70>=x37._f20||
!x37._f1._f71)
{
x42+="&area=yes";
}
else
 {
x42+="&area=no";
}
x42+="&dstsrid="+x37.parent.srid;
if(x37._f1._f104!=null)
{
x42+="&nsdp="+encodeURIComponent(x37._f1._f104.getFlatString());
}
if(x37._f1._f70>=x37._f20)
x42+="&wholeimage=yes";
if(x37._f1.renderLabels)
x42+="&renderlabels=yes";
x37.startLoad=MVUtil._f105(this,function()
{
x37._f99();
});
if(x33){
var x43=x37.parent._f106()
if(x43)
x42+="&mapcache="+encodeURI(x43._f107);
else
 x42+="&mapcache="+encodeURI(x37.parent.msi.mapConfig.mapTileLayer);
x42+="&boundingtheme=yes"+
"&mapwinwidth="+x37.parent._f108()+
"&mapwinheight="+x37.parent._f109()+
"&wholeimagelevel="+x37._f1._f70;
if(x36)
x42+="&recenteronly=yes";
}
if(x37._f1._f110!=null)
{
x42+="&trs="+encodeURIComponent(x37._f1._f110);
}
var x44=x37._f1._f111;
if(x44.length>0)
{
x42+="&tempstyles=";
var x45="<styles>";
for(var x46=0;x46<x44.length;x46++)
{
x45+=x44[x46].getXMLString();
}
x45+="</styles>";
x42+=encodeURIComponent(x45);
}
if(!x37._f1._f112||x34)
x42+="&refresh="+Math.round(Math.random()*100000);
if(x37._f1._f112&&x37._f1._f70<x37._f20)
x42+="&cachefoi=yes";
if(x37.abortionSupported)
x42+="&tid="+x37.themeId;
if(!x37._f1._f113)
x42+="&aw=no";
if(x37._f1._f114>0)
x42+="&mw="+x37._f1._f114;
if(x37._f1._f115>0)
x42+="&mu="+x37._f1._f115;
if(x37._f1._f116)
{
x42+="&sq=y";
x42+="&st="+x37._f1._f117;
}
var x47=(x37._f1._f3.indexOf(_f10._f11())<0&&
MVUtil._f8(x37._f1._f3)==MVUtil._f8(_f10._f118()));
var x48=x47||MVMapView._f7;
if(MVMapView._f119)
x37.t1=new Date();
if(MVMapView.debug)
MVi18n.alert("Sending Theme Based FOI request. URL:"+x37._f1._f3+" Parameters:"+x42);
try
{
x37.parent.setLoadingIconVisible(true);
if(x37.request)
{
x37.request.onreadystatechange=null;
x37.request.abort();
x37.request=null;
}
}
catch(e)
{
}
try
{
x37.request=MVUtil.getXMLHttpRequest(x48);
x37.request.onreadystatechange=x37.startLoad;
x37.request.open("POST",x37._f1._f3,true);
x37.request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
x37.request.send(x42);
}
catch(e)
{
MVi18n._f6("MVThemeBasedFOIControl.refreshFOIs","MAPVIEWER-05511",e);
x37._f29=false;
x37.parent._f82();
return ;
}
}
x38();
}
_f0.prototype.clearAllParallelly=function(){
this._f90();
}
_f0.prototype.getElementByIdInDiv=function(id){
var x49=[];
var x50=document.getElementById(id);
if(!x50)return x50;
while(x50&&((x50.parentNode!=this.div)||(x50.id!=id))){
x49.push({i:x50.id,e:x50});
x50.id='';
x50=document.getElementById(id);
}
for(j=0,jj=x49.length;j<jj;j++)x49[j].e.id=x49[j].i;
x49=null;
return x50;
}
_f0.prototype._f99=function()
{
if(!this.request)
return ;
if(this.request.readyState==4||this._f2)
{
if(this.request.status==200||this._f2)
{
if(this._f38)
{
this._f29=false;
this.parent._f82();
return ;
}
var oldFois=new Object();
var removeAllNodesFirst=false;
if(this.parent.wraparound&&!this.isWholeImage())
{
removeAllNodesFirst=true;
}
else if(this._f1.getFOIData())
{
for(var i=0;i<this._f1.getFOIData().length;i++)
{
var foi=this._f1.getFOIData()[i];
if(oldFois['_'+foi.nodeId])
{
oldFois=new Object();
removeAllNodesFirst=true;
break;
}
else
 {
oldFois['_'+foi.nodeId]=foi;
oldFois['_'+foi.nodeId].shown=false;
}
}
}
var result=null;
if(MVMapView._f119)
this.t2=new Date();
if(!this._f2)
{
try
{
eval("result="+this.request.responseText);
if(MVMapView._f119)
{
this.t3=new Date();
MVi18n.alert("Time taken to fetch "+this._f1.name+":"+(this.t2-this.t1)+".\n"+
"Time taken to load the FOI data:"+(this.t3-this.t2)+".");
}
}
catch(e)
{
MVi18n._f6("MVThemeBasedFOIControl.foiLoaded","MAPVIEWER-05523",this.request.responseText);
this._f29=false;
this.parent._f82();
return ;
}
this.boundingThemeResult=result;
}
else
 result=this.boundingThemeResult;
if(MVMapView._f120&&this._f37&&this._f1._f71&&
!this._f1._f113&&!this.isWholeImage()&&result.foiarray.length>50)
{
var maxFOINum=0;
if(result.foiarray[0].gtype%10==1)
maxFOINum=750;
else
 maxFOINum=200;
if(result.foiarray.length>maxFOINum)
{
var answer=confirm("You are showing too many FOIs for theme "+this._f1.name+" at the current level.\n"+
"It might take a long time to render these FOIs. You might want to consider rendering\n"+
"these FOIs as a whole image by invoking methods MVThemeBasedFOI.enableAutoWholeImage\n"+
"or MVThemeBasedFOI.setMaxWholeImageLevel.\n\n"+
"Do you want to continue to render the FOIs and ignore this message from now on?\n\n"+
"   Note: You can permanently disable warnings like this by invoking method\n"+
"   MVMapView.enableCodingHints(false).");
if(!answer)
{
this._f29=false;
this.parent._f82();
return ;
}
else
 this._f37=false;
}
}
if(this._f1)
this._f1._f121=result.themeMBR;
else
 return ;
if(result.isWholeImg)
this._f35=true;
else
 this._f35=false;
if(result.minx!=undefined&&!this._f2)
{
this._f2=true;
var tcx=(result.minx+result.maxx)/2;
var tcy=(result.miny+result.maxy)/2;
var _f20=this._f20;
if(result.adjlevel!=undefined)
_f20=result.adjlevel;
if(_f20<0||
_f20>=0&&this._f20<this._f1._f103&&
_f20>=this._f1._f103)
{
this._f2=false;
this.parent.zoomToRectangle(
MVSdoGeometry.createRectangle(result.minx,result.miny,result.maxx,result.maxy,this.parent.srid));
return ;
}
else
 {
this._f1.minX=this.minX=this._f15=result.minx;
this._f1.minY=this.minY=this._f16=result.miny;
this._f1.maxX=this.maxX=this._f17=result.maxx;
this._f1.maxY=this.maxY=this._f18=result.maxy;
this.parent.setCenterAndZoomLevel(MVSdoGeometry.createPoint(tcx,tcy,this.parent.srid),_f20);
return ;
}
}
this._f122=true;
this._f2=false;
if(!this.div)
return ;
this._f123();
if(MVMapView._f119)
this.t1=new Date();
if(result.foiarray.length>=1)
{
this._f1._f124=result;
this.parent._f125();
if(this.isWholeImage()||!this._f1._f71||
(!this._f68()&&result.foiarray[0].gtype%10!=1))
{
this._f30=2;
if(this._f1._f103<=this._f20)
{
this._f126(result);
}
else{
this.clearTransImageLayer();
}
}
else
 {
this.clearTransImageLayer();
this._f30=1;
}
if(this.wholeImage!=null)
{
if(this.wholeImage instanceof Array)
{
for(var i=0;i<this.wholeImage.length;i++)
{
this.div.removeChild(this.wholeImage[i]);
MVUtil._f91(this.wholeImage[i]);
}
}
else
 {
this.div.removeChild(this.wholeImage);
MVUtil._f91(this.wholeImage);
}
this.wholeImage=null;
}
if(this.isWholeImage()&&this._f1._f71)
{
this._f127(result.foiarray[0].imgurl);
}
if(!this.isWholeImage()||
this._f1._f103<=this._f20&&result.foiarray.length>0)
{
var divParent=this.div.parentNode;
divParent.removeChild(this.div);
if(removeAllNodesFirst&&!this.isWholeImage())
MVUtil._f128(this.div);
for(var i=0;i<result.foiarray.length;i++)
{
if(this._f38)
{
this._f29=false;
this.parent._f82();
return ;
}
result.foiarray[i].hiliteImgPref=result.hiliteImgPref;
result.foiarray[i].hiliteMW=result.hiliteMW;
result.foiarray[i].hiliteMH=result.hiliteMH;
result.foiarray[i].attrnames=result.attrnames;
if(this._f30==1&&!this._f68()&&result.foiarray[i].gtype%10!=1)
{
this._f30=3;
this._f126(result);
}
if(this._f30==1&&this._f1._f129)
{
result.foiarray[i].hiliteImgPref=this._f1._f129._f130;
result.foiarray[i].hiliteMW=this._f1._f129.width;
result.foiarray[i].hiliteMH=this._f1._f129.height;
}
var cfoi=result.foiarray[i];
if(cfoi.scid!=undefined)
cfoi.nodeId=cfoi.id+"_scid_"+cfoi.scid;
else
 cfoi.nodeId=cfoi.id;
var ofoi=oldFois['_'+cfoi.nodeId];
var flag=false;
if(ofoi)
{
flag=_f10._f69=="IF"?this._f1.reuseIENode:true;
}
if(this.parent.wraparound)
{
this._f131(cfoi);
}
if(flag){
ofoi.shown=true;
this._f132(cfoi,ofoi);
}
else
 {
this._f132(cfoi);
}
}
divParent.appendChild(this.div);
for(var key in oldFois)
{
foi=oldFois[key];
if(foi.shown==false)
{
var node=this.getElementByIdInDiv(foi.nodeId);
if(node)
{
MVUtil._f133(node);
}
if(node)
node.parentNode.removeChild(node);
}
}
}
else
 {
for(key in oldFois)
{
foi=oldFois[key];
var node=this.getElementByIdInDiv(foi.nodeId);
if(node)
{
MVUtil._f133(node);
}
if(node)
{
node.parentNode.removeChild(node);
}
}
}
this.makeFOIsVisiable();
this._f22=true;
}
else
 {
this._f1._f124=null;
this._f90();
}
if(MVMapView._f119)
{
this.t2=new Date();
MVi18n.alert("Time taken to render "+this._f1.name+":"+(this.t2-this.t1)+".\n"+
"wholeImage:"+this.isWholeImage()+", clickable:"+(this._f1._f103<=this._f20));
}
this.addTransparentLayer();
this._f29=false;
this.parent._f82();
if(this._f1._f134)
{
this._f1._f134();
}
if(this._f1)
MVUtil.runListeners(this._f1._f97,MVEvent.AFTER_REFRESH);
this.request=null;
this._f1.reuseIENode=true;
}
}
}
_f0.prototype.makeFOIsVisiable=function(){
var x51=true;
for(var x52=0;x52<this.parent._f135.length;x52++)
{
if(this.parent._f135[x52].layerControl&&
!this.parent._f135[x52].layerControl.zoomControl.hasZoomFinished())
{
x51=false;
break;
}
}
if(x51)
{
this.div.style.display='';
}
else
 {
var x53=this;
setTimeout(function(){x53.makeFOIsVisiable.apply(x53)},70);
}
}
_f0.prototype._f126=function(x54)
{
this.clearTransImageLayer();
this._f33=document.createElement("div");
var x55=this.adjustedRealWidth;
var x56=this.adjustedRealHeight;
if(this.around)
{
x55=this._f13;
}
MVUtil._f73(this.parent._f81,0,0);
if(this._f1.visible&&this._f1._f72)
this._f33.style.visibility="visible";
else
 this._f33.style.visibility="hidden";
this._f33.style.position="absolute";
this._f33.id=this._f1.name;
var x57=(this._f15-this.minX)*this.parent._f75;
if(this.around)
{
var x58=this.minX;
this.htmlMapXoffset=(this._f15-x58)*this.parent._f75;
x57=0;
}
else
 this.htmlMapXoffset=0;
var x59=(this.maxY-this._f18)*this.parent._f77;
var x60=(this.parent._f94-this._f27)*this.parent._f75;
var x61=(this.parent._f95-this._f28)*this.parent._f77;
MVUtil._f73(this._f33,this._f23-this.parent._f140-x60+x57,
this._f24-this.parent._f141+x61+x59);
this._f33.style.zIndex=this.div.style.zIndex;
var x62=_f10._f142+"transparent.gif";
if(this._f1._f103>this._f20)
return ;
if(_f10._f69=="IF"&&
(!this._f68()||this.isWholeImage()||
!this._f1._f71))
{
var x63=document.createElement("div");
x63.style.zIndex="127";
var x64=document.createElement("img");
x64.width=MVUtil._f31(x55)
x64.height=MVUtil._f31(x56);
x64.style.width=MVUtil._f31(x55);
x64.style.height=MVUtil._f31(x56);
x64.style.border=0;
x64.src=_f10._f142+"transparent.gif";
x64.setAttribute("usemap","#polygonMap"+this.parent._f145+"_"+this._f32,0);
x63.style.position="absolute";
MVUtil._f73(x63,0,0);
x63.appendChild(x64);
MVUtil._f146(x64);
this._f33.appendChild(x63);
}
else
 {
this._f147=document.createElement("img");
this._f147.src=x62;
this._f147.setAttribute("usemap","#polygonMap"+this.parent._f145+"_"+this._f32);
this._f147.width=x55;
this._f147.height=x56;
this._f147.style.width=MVUtil._f31(x55);
this._f147.style.height=MVUtil._f31(x56);
this._f147.style.border=0;
MVUtil._f146(this._f147);
this._f33.appendChild(this._f147);
}
this._f34=document.createElement("map");
this._f34.setAttribute("name","polygonMap"+this.parent._f145+"_"+this._f32);
this._f34.setAttribute("id","polygonMap"+this.parent._f145+"_"+this._f32);
this._f33.setAttribute("theme",this._f1.name);
if(_f10._f69=="SF")
{
this._f32++;
}
this._f33.appendChild(this._f34);
}
_f0.prototype.addTransparentLayer=function()
{
if(this._f33)
{
this.parent._f81.style.zIndex=Math.max(MVUtil.getZIndex(this.div)+1,MVUtil.getZIndex(this.parent._f81));
this.parent._f81.appendChild(this._f33);
}
}
var _f148=0;
_f0.prototype.setTimeout=function(_f149,_f150)
{
var Ie="tempVar"+_f148;
_f148++;
eval(Ie+" = this;");
var oi=_f149.replace(/\\/g,"\\\\");
oi=oi.replace(/\"/g,'\\"');
return window.setTimeout(Ie+'._setTimeoutDispatcher("'+oi+'");'+Ie+" = null;",_f150);
}
_f0.prototype._setTimeoutDispatcher=function(func)
{
eval(func);
}
_f0.prototype._f151=function(x65)
{
this._f152=0;
this.result=x65;
this.startDisplayGroupFoi();
}
_f0.prototype.startDisplayGroupFoi=function()
{
for(var x66=0;x66<180;x66++)
{
if(this._f152<this.result.foiarray.length)
{
this.result.foiarray[this._f152].attrnames=this.result.attrnames;
this._f132(this.result.foiarray[this._f152]);
this._f152++;
}
else
 {
return;
}
}
this.setTimeout("this.startDisplayGroupFoi()",2);
}
_f0.prototype._f132=function(x67,x68)
{
if(!(this._f1._f71)&&(x68)&&(x68.node))
{
node=x68.node;
x67._f153=x68._f153;
x68.shown=false;
}
if(this.isWholeImage()||x67.imgurl||x67.area||
this._f1.getFOIMarker()||!this._f1._f71)
{
x67.imgurl4Hilite=null;
x67.highlightImageWidth=x67.hiliteMW;
x67.highlightImageHeight=x67.hiliteMH;
x67.pngType4Hilite=true;
x67.normalPngType4Hilite=false;
x67.hilitePngType4Hilite=false;
x67.recalSizePos4Hilite=false;
if(this._f30==1&&this._f1._f129)
x67.imgurl4Hilite=x67.hiliteImgPref;
if(this._f30==1&&this._f1.getFOIMarker())
{
x67.width=this._f1.getFOIMarker().width;
x67.height=this._f1.getFOIMarker().height;
}
if(x67.highlightImageWidth&&x67.highlightImageHeight
&&(x67.width)&&(x67.height)
&&((x67.width!=x67.highlightImageWidth)
||(x67.height!=x67.highlightImageHeight)))
{
x67.recalSizePos4Hilite=true;
}
if(!x67.recalSizePos4Hilite&&x68&&x68.node&&
(x68.highlightImageWidth!=x67.highlightImageWidth
||x68.highlightImageHeight!=x67.highlightImageHeight))
{
x67.recalSizePos4Hilite=true;
}
var x69=this;
var x70=null;
if(!this.isWholeImage()&&this._f1._f71&&!(!x67.imgurl&&x67.scid))
{
if(!(x67.imgurl4Hilite)&&x67.imgurl&&x67.hiliteImgPref)
{
var x71=x67.imgurl.lastIndexOf("/");
if(x71!=-1)
{
x67.imgurl4Hilite=x67.imgurl.substring(0,(x71+1))+x67.hiliteImgPref+x67.imgurl.substr((x71+1));
}
}
if(this._f1.getFOIMarker())
{
x67.imgurl=this._f1.getFOIMarker()._f130;
}
var x72=x67.imgurl.toLowerCase().indexOf('.png')==-1?false:true;
x67.normalPngType4Hilite=x72;
if(x67.imgurl4Hilite)
x67.hilitePngType4Hilite=x67.imgurl4Hilite.toLowerCase().indexOf('.png')==-1?false:true;
x67.pngType4Hilite=(x67.normalPngType4Hilite)?true:(x67.hilitePngType4Hilite);
if((x68)&&(x68.node))
{
x70=x68.node;
x67._f153=x68._f153;
}
else
 {
if((this._f68()&&x67.pngType4Hilite)||
(x69._f1._f154&&x67.gtype%10==1)||x69._f1._f154)
x70=document.createElement('div');
else
 x70=document.createElement('img');
}
x67.node=x70;
x70.className="noprint";
MVUtil._f146(x70);
x70.style.position="absolute";
if(_f10._f69=="IF"&&!x69._f1._f154)
{
x70.style.width=MVUtil._f31(x67.width);
x70.style.height=MVUtil._f31(x67.height);
}
if(x67.nodeId&&x67.nodeId!=null)
x70.id=x67.nodeId;
x70._f155=x67.x;
x70._f156=x67.y;
var x73=(this.parent._f94-this._f27)*this.parent._f75;
var x74=(this.parent._f95-this._f28)*this.parent._f77;
var x75;
if(x67.wr&&x67.wr.length>0)
x75=MVUtil._f157(this.parent,this.minX,this.minY,this.maxX,this.maxY,
this._f13,this._f14,x67.x+x67.wr[0]*(this.parent.msi._f158-this.parent.msi._f159),
x67.y);
else
 x75=MVUtil._f157(this.parent,this.minX,this.minY,this.maxX,this.maxY,
this._f13,this._f14,x67.x,x67.y);
x75[0]-=x73;
x75[1]+=x74;
x75[0]+=this._f1._f138;
x75[1]+=this._f1._f139;
if(_f10._f69=="IF")
{
x75[1]++;}
else
 {
}
if(x67.height%2==0)
x75[1]--;
x67.loc=x75;
if(x67.gtype%10==1)
MVUtil._f73(x70,Math.ceil(x75[0]-x67.width/2.0),Math.ceil(x75[1]-x67.height/2.0));
else
 MVUtil._f73(x70,x75[0],x75[1]);
x70.style.zIndex=160;
}
else
 {
if(!this.isWholeImage()&&this._f1._f71&&
(!x67.imgurl&&x67.scid)&&this.shouldNotUseHTMLMap(x67))
return ;
}
if(x70){
x70.tbf=x69;
x70.foi=x67;
}
var x76="";
if(x67.name&&x67.name!="null")
x76=x67.name;
if((_f10._f69=="IF"||_f10._f69=="NS")
&&x69._f1._f160&&x67.name&&x67.name!="null"&&x70)
{
x70.title=x76;
}
if(x67.name)
x67.name=MVUtil._f48(x67.name," ","&nbsp;");
if(x70&&this.shouldNotUseHTMLMap(x67))
{
this.div.appendChild(x70);
if(!x69._f1._f154)
{
if(this._f68()&&x67.pngType4Hilite)
{
if(x72)
x70.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+
x67.imgurl+"', sizingMethod='image');";
else
 x70.innerHTML="<img src=\""+encodeURIComponent(x67.imgurl)+"\"/>";
}
else
 x70.src=x67.imgurl;
if(!x69._f1._f154)
{
x70.setAttribute("id",x67.nodeId);
x70.setAttribute("border",0);
}
}
if(x69._f1._f154)
{
x69._f1._f154(x67);
if(x67.xoffset==undefined||isNaN(x67.xoffset))
x67.xoffset=0;
else
 x67.xoffset=parseInt(x67.xoffset);
if(x67.yoffset==undefined||isNaN(x67.yoffset))
x67.yoffset=0;
else
 x67.yoffset=parseInt(x67.yoffset);
this._f161(x67,x68,x70);
}
this._f162(x70,x67);
MVUtil._f163(x70);
}
else {
var x77=x76;
var x78=Math.floor((x67.x-this.minX)*this.parent._f75+0.5);
var x79=Math.floor((this.maxY-x67.y)*this.parent._f77+0.5);
var x80="";
if(this._f1._f103<=this._f20)
{
var x81=null;
if((x68)&&(x68.areaNode))
{
x67._f153=x68._f153;
}
x81=document.createElement("area");
x81.tbf=x69;
x81.foi=x67;
x81.node=x70;
MVUtil._f164(x81,this._f1.cursorStyle);
x67.areaNode=x81;
this._f165=true;
x81.setAttribute("border",0);
if(_f10._f69!="OS")
{
if((_f10._f69=="IF"||_f10._f69=="NS")
&&x69._f1._f160&&x67.name&&x67.name!="null")
{
x81.setAttribute("title",x77);
}
x81.setAttribute("href","javascript:void(0)");
}
if(x67.gtype%10==1)
{
var x75;
if(x67.wr&&x67.wr.length>0)
x75=MVUtil._f157(this.parent,this.minX,this._f16,this.maxX,this._f18,
this._f13,this.adjustedRealHeight,x67.x+x67.wr[0]*(this.parent.msi._f158-this.parent.msi._f159),
x67.y);
else
 x75=MVUtil._f157(this.parent,this._f15,this._f16,
this._f17,this._f18,
this.adjustedRealWidth,this.adjustedRealHeight,
x67.x,x67.y);
var x82=0;
x75[0]+=this.parent._f140+this._f1._f138-x82;
x75[1]+=this.parent._f141+this._f1._f139;
x81.setAttribute("shape","rect");
var x83=parseInt(x67.width);
var x84=parseInt(x67.height);
x83=x83<10?10:x83;
x84=x84<10?10:x84;
x83=x83/2;
x84=x84/2;
var x85=(x75[0]-x83)+","+(x75[1]-x84)+","+
(x75[0]+x83)+","+(x75[1]+x84);
x81.setAttribute("coords",x85);
}
else
 {
var x86="";
if(typeof(x67.area)=='undefined'||x67.area==null||x67.area=='')
x86="-1000,-1000";
else
 {
x86=x67.area;
if(x69._f1._f154&&!this.isWholeImage())
{
x69._f1._f154(x67);
}
if(x67.xoffset==undefined||isNaN(x67.xoffset))
x67.xoffset=0;
else
 x67.xoffset=parseInt(x67.xoffset);
if(x67.yoffset==undefined||isNaN(x67.yoffset))
x67.yoffset=0;
else
 x67.yoffset=parseInt(x67.yoffset);
var x87=this.htmlMapXoffset+x67.xoffset+this._f1._f138;
if(x67.wr&&x67.wr.length>0)
x87+=x67.wr[0]*(this.parent.msi._f158-this.parent.msi._f159)*this.parent._f75;
var x88=x67.yoffset+this._f1._f139;
x86=this._f166(x86,x87,x88);
}
x81.setAttribute("shape","poly");
x81.setAttribute("coords",x86);
}
this._f162(x81,x67);
MVUtil._f163(x81);
this._f34.appendChild(x81);
}
else
 {
if(x67.areaNode)
x67.areaNode=null;
}
if(x70)
{
MVUtil._f73(x70,x75[0],x75[1]);
x70.style.position="absolute";
x70.style.width=MVUtil._f31(x67.width);
x70.style.height=MVUtil._f31(x67.height);
x70.id=x67.nodeId;
if(x69._f1._f154)
this._f161(x67,x68,x70);
else
 x70.src=x67.imgurl;
x70.style.zIndex=125;
this.div.appendChild(x70);
}
}
this._f167(x70,x67);
if(x70!=null&&x70.id!=null)
{
var x71=null;
if((x71=x69._f1._f168[x70.id])!=null)
{
x69._f1._f169[x71]=x67;
x67._f153=false;
this.highlightFOI(x69,x67,x70);
}
}
}
}
_f0.prototype.destroy=function()
{
this._f89();
if(this.request)
{
this.request.onreadystatechange=function(){};
this.request.abort();
this.request=null;
}
if(this._f1._f124&&this._f1._f124.foiarray)
{
while(this._f1._f124.foiarray.length>0)
{
var x89=this._f1._f124.foiarray.pop();
if(x89.node)
x89.node=null;
if(x89.areaNode)
x89.areaNode=null;
}
}
this._f1._f124=null;
this._f1=null;
if(this.parent)
{
if(this.parent.div&&this.div)
{
try{this.parent.div.removeChild(this.div);}catch(error){}
}
this.div=null;
this.parent._f82();
this.parent=null;
}
this._f34=null;
this._f33=null;
this._f147=null;
}
_f0.prototype.adjustBBox=function(x90)
{
var x91=false;
var x92=this.parent.msi.mapConfig.coordSys;
if(this.parent.wraparound&&!x90)
{
if(this.maparea.length>=3)
{
this._f15=x92.minX;
this._f17=x92.maxX;
}
else if(this.maparea.length==2)
{
var x93=x92.maxX-x92.minX;
if(this.parent.maptype!="PROJECTED")
{
this._f15=this.maparea[0].minx;
if(this.maparea[0].minx<this.maparea[1].maxx)
this._f17=this.maparea[0].minx+x93;
else
 this._f17=this.maparea[1].maxx+x93;
}
else
 {
this._f15=this.maparea[0].minx;
this._f17=this.maparea[0].maxx;
if(this.maparea[1].maxx<this.maparea[0].minx)
{
this.adjustedMinX2=this.maparea[1].minx;
this.adjustedMaxX2=this.maparea[1].maxx;
}
else if(this.maparea[1].minx<this.maparea[0].minx)
{
this.adjustedMinX2=this.maparea[1].minx;
this.adjustedMaxX2=this.maparea[0].minx;
}
}
}
else
 {
this._f15=this.maparea[0].minx;
this._f17=this.maparea[0].maxx;
}
x91=true;
}
else
 {
if(!x90&&this.minX<x92.minX)
{
this._f15=x92.minX;
x91=true;
}
else
 this._f15=this.minX;
if(!x90&&this.maxX>x92.maxX)
{
this._f17=x92.maxX;
x91=true;
}
else
 this._f17=this.maxX;
}
if(!x90&&this.minY<x92.minY)
{
this._f16=x92.minY;
x91=true;
}
else
 this._f16=this.minY;
if(!x90&&this.maxY>x92.maxY)
{
this._f18=x92.maxY;
x91=true;
}
else
 this._f18=this.maxY;
if(this.adjustedMinX2)
this.adjustedRealWidth=Math.round(this._f13*
(this._f17-this._f15+this.adjustedMaxX2-this.adjustedMinX2)/(this.maxX-this.minX));
else
 this.adjustedRealWidth=Math.round(this._f13*
(this._f17-this._f15)/(this.maxX-this.minX));
this.adjustedRealHeight=Math.round(this._f14*
(this._f18-this._f16)/(this.maxY-this.minY));
}
_f0.prototype._f41=function(x94)
{
if(!x94)
return x94;
if(x94.indexOf("<themes>")>=0)
x94=x94.substring(x94.indexOf("<themes>")+8,x94.indexOf("</themes>"));
if(this._f1._f110)
{
var x95=x94.indexOf(" render_style");
if(x95>0)
{
var x96="\"";
var x97=x94.indexOf(x96,x95);
var x98=x94.indexOf("'",x95);
if(x97<0||x98<x97)
{
x96="'";
x97=x98;
}
var x99=x94.indexOf(x96,x97+1);
x94=x94.substring(0,x95)+x94.substring(x99+1);
}
else
 x95=x94.indexOf("<jdbc_query")+11;
return x94.substring(0,x95)
+" render_style=\""+this._f1._f110+"\""
+x94.substring(x95);
}
else
 return x94;
}
_f0.prototype._f127=function(x100)
{
var x101=-(this._f18-this.parent._f170)*this.parent._f77;
x101=x101-MVUtil._f84(this.div)+this._f1._f139;
var x102=this;
var x103=function(x104)
{
var x105=null;
if(x102._f68())
x105=MVUtil._f171(x100,true);
else
 {
x105=document.createElement('img');
x105.src=x100;
}
x105.style.width=MVUtil._f31(x102.adjustedRealWidth);
x105.style.height=MVUtil._f31(x102.adjustedRealHeight);
x105.style.position="absolute";
MVUtil._f73(x105,x104,x101);
x102.div.appendChild(x105);
return x105;
}
this._f90(true);
if(!this.parent.wraparound)
{
var x106=(this._f15-this.parent._f172)*this.parent._f75;
x106=x106-MVUtil._f83(this.div)+this._f1._f138;
this.wholeImage=x103(x106);
}
else{
var x107=this.parent.msi.mapConfig.coordSys;
var x108=x107.maxX-x107.minX;
var x109=this.maparea.length;
if(x109>=3)
{
this.wholeImage=new Array();
for(var x110=0;x110<x109;x110++)
{
var x106=(this.maparea[x110].minx+this.maparea[x110].n*x108-(this.maparea[x110].minx-this._f15)-this.parent._f172)*this.parent._f75;
x106=x106-MVUtil._f83(this.div)+this._f1._f138;
var x111=x103(x106);
this.wholeImage.push(x111);
}
}
else if(x109==2)
{
if(this.parent.maptype!="PROJECTED")
{
var x106=(this.maparea[0].minx+this.maparea[0].n*x108-this.parent._f172)*this.parent._f75;
x106=x106-MVUtil._f83(this.div)+this._f1._f138;
var x111=x103(x106);
if(this.maparea[0].minx<this.maparea[1].maxx)
{
this.wholeImage=new Array(x111);
var x112=(this.maparea[0].minx+(this.maparea[0].n+1)*x108-this.parent._f172)*this.parent._f75;
x112=x112-MVUtil._f83(this.div)+this._f1._f138;
var x111=x103(x112);
this.wholeImage.push(x111);
}
else
 {
this.wholeImage=x111;
}
}
else
 {
var x106=(this._f15-this.parent._f172)*this.parent._f75;
x106=x106-MVUtil._f83(this.div)+this._f1._f138;
this.wholeImage=x103(x106);
}
}
else
 {
var x106=(this.maparea[0].minx+this.maparea[0].n*x108-this.parent._f172)*this.parent._f75;
x106=x106-MVUtil._f83(this.div)+this._f1._f138;
this.wholeImage=x103(x106);
}
}
}
_f0.prototype._f36=function(x113)
{
var x114="request=getthemeid";
var x115=(this._f1._f3.indexOf(_f10._f11())<0&&
MVUtil._f8(this._f1._f3)==MVUtil._f8(_f10._f118()));
var x116=x115||MVMapView._f7;
var x117=null;
var x118=this;
var x119=function()
{
if(x117.readyState==4&&x117.status==200)
{
x118.themeId=x117.responseText;
if(x118.themeId.lastIndexOf("\n")==x118.themeId.length-1)
x118.themeId=x118.themeId.substr(0,x118.themeId.length-1);
if(x118.themeId&&x118.themeId.indexOf("MAPVIEWER-06011")>=0)
{
x118.abortionSupported=false;
}
if(x113)
x113();
x117=null;
}
}
try
{
x117=MVUtil.getXMLHttpRequest(x116);
x117.onreadystatechange=x119;
x117.open("POST",this._f1._f3,true);
x117.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
x117.send(x114);
}
catch(e)
{
MVi18n._f6("MVThemeBasedFOIControl.getThemeId","MAPVIEWER-05511",e);
}
}
_f0.prototype.abort=function()
{
if(!this.abortionSupported)
return ;
var x120="request=abort&tid="+this.themeId;
var x121=(this._f1._f3.indexOf(_f10._f11())<0&&
MVUtil._f8(this._f1._f3)==MVUtil._f8(_f10._f118()));
var x122=x121||MVMapView._f7;
var x123=null;
var x124=this;
this._f38=true;
try
{
x123=MVUtil.getXMLHttpRequest(x122);
x123.open("POST",this._f1._f3,true);
x123.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
x123.send(x120);
x123=null;
}
catch(e)
{
MVi18n._f6("MVThemeBasedFOIControl.abort","MAPVIEWER-05511",e);
}
}
_f0.prototype._f123=function()
{
if(this._f1._f103<=this._f20&&this._f1._f72)
MVUtil._f164(this.div,this._f1.cursorStyle);
else
 MVUtil._f164(this.div,"default");
}
_f0.prototype._f161=function(x125,x126,x127)
{
if(x126!=null&&x126.layoutListenerDiv!=null){
x127.removeChild(x126.layoutListenerDiv);
MVUtil._f91(x126.layoutListenerDiv);
}
var x128=document.createElement("div");
x128.style.position="absolute";
var x129=this;
var x130=x125.xoffset+x129._f1._f138;
var x131=x125.yoffset+x129._f1._f139;
x128.style.left=MVUtil._f31(x130);
x128.style.top=MVUtil._f31(x131);
x128.style.padding=MVUtil._f31(0);
x128.innerHTML=""+x125.html+"";
x127.appendChild(x128);
x125.layoutListenerDiv=x128;
}
_f0.prototype.stopPropagation=function(x132)
{
x132=(x132)?x132:((window.event)?event:null);
var x133=MVUtil.getEventSource(x132);
var x134=x133.tbf;
while(!x134&&x133.parentNode){x133=x133.parentNode;
x134=x133.tbf;
}
if(x132&&!x134._f1._f173)
{
if(_f10._f69=="IF")
x132.cancelBubble=true;
else if(x132.stopPropagation)
x132.stopPropagation();
}
}
_f0.prototype._f174=function(x135)
{
x135=(x135)?x135:((window.event)?event:null);
var x136=MVUtil.getEventSource(x135);
var x137=x136.tbf;
while(!x137&&x136.parentNode){x136=x136.parentNode;
x137=x136.tbf;
}
if(!x137||!x137._f1||x135&&!x137._f1._f173)
{
MVUtil._f174(x135);
}
}
_f0.prototype.getMouseDownLocation=function(x138)
{
x138=(x138)?x138:((window.event)?event:null);
var x139=MVUtil.getEventSource(x138);
var x140=x139.tbf;
while(!x140&&x139.parentNode){x139=x139.parentNode;
x140=x139.tbf;
}
if(!x140)
return;
var x141=x139.foi;
x140.mouseL1=MVUtil._f175(x138);
x140._f174(x138);
}
_f0.prototype.tFoiMouseUp=function(x142)
{
x142=(x142)?x142:((window.event)?event:null);
var x143=MVUtil.getEventSource(x142);
var x144=x143.tbf;
while(!x144&&x143.parentNode){x143=x143.parentNode;
x144=x143.tbf;
}
if(!x144)
return;
var x145=x143.foi;
if(!x144._f1._f72||x144.parent._f176)
return ;
x144.mouseL2=MVUtil._f175(x142);
if(x142.button==2)
{
if(!x144.shouldNotUseHTMLMap(x145)&&_f10._f69=='IF')
x144.tFoiRightClick(x142);
return;
}
if(x144.mouseL1.x==x144.mouseL2.x&&x144.mouseL1.y==x144.mouseL2.y)
{
x144.parent._f177();
if(x144.parent.getBrowserType()=="NS")
{
x144.parent._f178=null;
}
var x146=MVUtil.getMouseLocation(x144.parent,x142);
if(x144._f1._f179||x144._f1._f97[MVEvent.MOUSE_CLICK])
{
var x147=MVSdoGeometry.createPoint(x146.sdo_point.x,x146.sdo_point.y,x144.parent.srid);
if(x144._f1._f179)
x144._f1._f179(x147,x145,MVUtil.getEvent(x142));
if(x144._f1)
MVUtil.runListeners(x144._f1._f97,MVEvent.MOUSE_CLICK,[x147,x145,MVUtil.getEvent(x142)]);
}
else
 {
if(x145.attrs!=null)
{
if(x145.attrs.length>=1&&x144._f1._f180)
{
x144.parent._f79._f181(x145.attrs,x145.attrnames,x145.id,
x145.name,x146.sdo_point.x,x146.sdo_point.y,null,null,
x144._f1,300);
}
}
}
if(!x144._f1)
{
x144._f174(x142);
return ;
}
var x148=x143;
if(!x144.shouldNotUseHTMLMap(x145))
{
x148=x143.node;
}
x144.mouseUpHighLight(x144,x145,x148);
}
}
_f0.prototype.tFoiRightClick=function(x149)
{
x149=(x149)?x149:((window.event)?event:null);
var x150=MVUtil.getEventSource(x149);
var x151=x150.tbf;
while(!x151&&x150.parentNode){x150=x150.parentNode;
x151=x150.tbf;
}
if(!x151)
return;
var x152=x150.foi;
if(!x151._f1._f72)
return ;
var x153=MVUtil.getMouseLocation(x151.parent,x149);
var x154=MVSdoGeometry.createPoint(x153.sdo_point.x,x153.sdo_point.y,x151.parent.srid);
if(x151._f1._f182)
{
x151._f1._f182(x154,x152,MVUtil.getEvent(x149));
}
if(x151._f1)
MVUtil.runListeners(x151._f1._f97,MVEvent.MOUSE_RIGHT_CLICK,[x154,x152,MVUtil.getEvent(x149)]);
x151._f174(x149);
};
_f0.prototype.tFoiMouseOver=function(x155)
{
x155=(x155)?x155:((window.event)?event:null);
var x156=MVUtil.getEventSource(x155);
var x157=x156.tbf;
var x158=0;
while(!x157&&x156.parentNode){x156=x156.parentNode;
x157=x156.tbf;
x158++;
}
if(!x157)
return;
var x159=x156.foi;
var x160=x156;
if(!x157.shouldNotUseHTMLMap(x159)){
x160=x156.node;
if(!x157._f1._f72)
return ;
}
var x161=MVUtil.getMouseLocation(x157.parent,x155);
var x162=MVSdoGeometry.createPoint(x161.sdo_point.x,x161.sdo_point.y,x157.parent.srid);
if(x157._f1._f183)
{
x157._f1._f183(x162,x159,MVUtil.getEvent(x155));
}
if(x157._f1)
MVUtil.runListeners(x157._f1._f97,MVEvent.MOUSE_OVER,[x162,x159,MVUtil.getEvent(x155)]);
if(x157._f1._f184&&
!(x157.parent._f79._f185()&&!x157.parent._f79.mouseOver))
{
if(x159.attrs!=null)
{
if(x159.attrs.length>=1&&x157._f1._f180)
{
x157.parent._f79._f181(x159.attrs,x159.attrnames,x159.id,
x159.name,x161.sdo_point.x,x161.sdo_point.y,null,null,
x157._f1,300,true);
}
}
}
if(x157.shouldNotUseHTMLMap(x159)&&x157._f1._f186)
{
x156.style.zIndex=161;
}
if(!x156.title&&x159.name&&x159.name!="null"&&x157._f1._f160)
{
x157.parent._f79.showTextTip(x159.name,x161.sdo_point.x,x161.sdo_point.y);
}
if(x157._f1.enableMouseOverHighlightMode&&x157._f1._f187)
{
if(x160&&x159.imgurl4Hilite)
x157.highlightFOI(x157,x159,x160);
else if(x159.scid)
{
var x159=x157.getMainFOI(x159);
if(x159)
x157.highlightFOI(x157,x159,x159.node);
}
}
};
_f0.prototype.tFoiMouseOut=function(x163)
{
x163=(x163)?x163:((window.event)?event:null);
var x164=MVUtil.getEventSource(x163);
var x165=x164.tbf;
while(!x165&&x164.parentNode){x164=x164.parentNode;
x165=x164.tbf;
}
if(!x165)
return;
var x166=x164.foi;
var x167=x164;
if(!x165.shouldNotUseHTMLMap(x166)){
x167=x164.node;
if(!x165._f1._f72)
return ;
}
var x168=MVUtil.getMouseLocation(x165.parent,x163);
var x169=MVSdoGeometry.createPoint(x168.sdo_point.x,x168.sdo_point.y,x165.parent.srid);
if(x165._f1._f188)
{
x165._f1._f188(x169,x166,MVUtil.getEvent(x163));
}
if(x165._f1)
MVUtil.runListeners(x165._f1._f97,MVEvent.MOUSE_OUT,[x169,x166,MVUtil.getEvent(x163)]);
if(x165._f1._f184&&
!(x165.parent._f79._f185()&&!x165.parent._f79.mouseOver))
{
if(x166.attrs!=null)
{
if(x166.attrs.length>=1&&x165._f1._f180)
{
x165.parent.removeInfoWindow();
}
}
}
if(x165.shouldNotUseHTMLMap(x166))
{
x164.style.zIndex=160;
}
x165.parent._f79._f189();
if(x165._f1.enableMouseOverHighlightMode&&x165._f1._f187)
{
if(x167&&x166.imgurl4Hilite!=null&&!(x166._f153))
x165.deHighlightFOI(x165,x166,x167);
else if(x166.scid)
{
var x166=x165.getMainFOI(x166);
if(x166&&!(x166._f153))
x165.deHighlightFOI(x165,x166,x166.node);
}
}
};
_f0.prototype.shouldNotUseHTMLMap=function(x170)
{
return ((this._f68()||x170.gtype%10==1)&&this._f1._f71&&!this.isWholeImage())
}
_f0.prototype.mouseUpHighLight=function(x171,x172,x173)
{
if(x171._f1._f187&&!x171._f1._f154)
{
if(x172.imgurl4Hilite!=null)
{
var x174=x171._f1._f169.length;
var x175=x171._f1._f190;
var x176=false;
if(x174>0)
{var x177=x171._f1._f169;
var x178=x171._f1._f168;
var x179=null;
var x180=null;
if(x172.id!=null&&x178[x172.id]!=null)
{
x176=true;
}
if(x175==-1||x174<=x175){
var x181=x171._f1._f124.foiarray;
var x182=0;
for(var x183=0;x183<x181.length;x183++)
{
var x184=x181[x183];
var x185=x184.id;
if(x184.scid!=undefined)
x185=x184.id+"_scid_"+x184.scid;
if(x178[x185]==null)
continue;
else
 {
x179=x177[x178[x185]];
x179._f153=false;x171.deHighlightFOI(x171,x179);x182++;
}
if(x182==x174)
break;
}
x171._f1._f169=new Array();
x171._f1._f168=new Object();
x174=0;
}
else if(x175>0)
{
for(var x183=1;x183<=x175;++x183)
{
x179=x177[x174-x183];
x179._f153=false;if(x179!=null&&x179.nodeId!=null)
{
x178[x179.nodeId]=null;
if(x179.imgurl==null)
continue;
x171.deHighlightFOI(x171,x179);
}
}
x171._f1._f169=x177.slice(0,(0-x175));
x174-=x175;
}
}
if(!x176)
{
if(x172.nodeId!=null)
{
var x186=x171._f1._f168[x172.nodeId];
x172._f153=true;if(x186!=null)
x171._f1._f169[x186]=null;
x171._f1._f168[x172.nodeId]=x174;
x171._f1._f169[x174++]=x172;
}
x171.highlightFOI(x171,x172);
}
else if(x175==0)
{
if(x172.nodeId!=null)
{
var x186=x171._f1._f168[x172.nodeId];
x186._f153=false;if(x186!=null)
x171._f1._f169[x186]=null;
x171._f1._f168[x172.nodeId]=null;
}
x171.deHighlightFOI(x171,x172);
}
}
else if(x172.scid)
{
var x172=x171.getMainFOI(x172);
if(x172)
x171.mouseUpHighLight(x171,x172,x172.node);
}
}
}
_f0.prototype.deHighlightFOI=function(x187,x188)
{
if(!x188.highlight)
return;
var x189=x188.node;
x188.highlight=false;
var x190=function(x191)
{
if(x187.shouldNotUseHTMLMap(x188))
{
if(x188!=null&&x188.imgurl!=null)
{
if(x187._f68()&&x188.pngType4Hilite)
{
if(x188.normalPngType4Hilite)
{
x191.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+
x188.imgurl+"', sizingMethod='image');";
x191.src=x188.imgurl;
x191.innerHTML="";
}
else
 {
x191.onmouseover=null;
x191.onmouseout=null;
x191.style.filter=null;
x191.src=null;
x191.innerHTML="<img src=\""+encodeURIComponent(x188.imgurl)+"\"/>";
var x192=function(){
x191.onmouseover=x187.tFoiMouseOver;
x191.onmouseout=x187.tFoiMouseOut;
}
window.setTimeout(x192,50);
}
}
else
 x191.src=x188.imgurl;
if(x188.recalSizePos4Hilite&&(x188.gtype%10==1))
{
var x193=Math.ceil(MVUtil._f83(x191)+(x188.highlightImageWidth-x188.width)/2.0);
var x194=Math.ceil(MVUtil._f84(x191)+(x188.highlightImageHeight-x188.height)/2.0);
MVUtil._f73(x191,x193,x194);
x191.style.width=MVUtil._f31(x188.width);
x191.style.height=MVUtil._f31(x188.height);
}
}
}
else
 {
if(x188!=null&&x188.imgurl!=null)
{
if(x187._f68()&&_f191.pngType4Hilite)
{
x191.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+
x188.imgurl+"', sizingMethod='image');";
}
x191.src=x188.imgurl;
}
}
}
if(x189 instanceof Array)
{
for(var x195=0;x195<x189.length;x195++)
x190(x189[x195]);
}
else
 x190(x189);
}
_f0.prototype.highlightFOI=function(x196,x197)
{
if(x197.highlight)
return;
var x198=x197.node;
x197.highlight=true;
var x199=function(x200)
{
if(x196.shouldNotUseHTMLMap(x197)&&x197.imgurl4Hilite)
{
if(x196._f68()&&x197.pngType4Hilite)
{
if(x197.hilitePngType4Hilite)
{
x200.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+
x197.imgurl4Hilite+"', sizingMethod='image');";
x200.src=x197.imgurl4Hilite;
x200.innerHTML="";
}
else
 {
x200.onmouseout=null;
x200.onmouseover=null;
x200.style.filter=null;
x200.src=null;
x200.innerHTML="<img src=\""+encodeURIComponent(x197.imgurl4Hilite)+"\"/>";
var x201=function(){
x200.onmouseout=x196.tFoiMouseOut;
x200.onmouseover=x196.tFoiMouseOver;
}
window.setTimeout(x201,10);
}
}
else
 {
x200.src=x197.imgurl4Hilite;
}
if(x197.recalSizePos4Hilite&&(x197.gtype%10==1))
{
var x202=Math.ceil(MVUtil._f83(x200)-(x197.highlightImageWidth-x197.width)/2.0);
var x203=Math.ceil(MVUtil._f84(x200)-(x197.highlightImageHeight-x197.height)/2.0);
MVUtil._f73(x200,x202,x203);
x200.style.width=MVUtil._f31(x197.highlightImageWidth);
x200.style.height=MVUtil._f31(x197.highlightImageHeight);
}
}
else if(x200!=null&&(x197.imgurl4Hilite))
{
if(x196._f68()&&x197.pngType4Hilite)
{
x200.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+
x197.imgurl4Hilite+"', sizingMethod='image');";
}
x200.src=x197.imgurl4Hilite;
}
}
if(x198 instanceof Array)
{
for(var x204=0;x204<x198.length;x204++)
x199(x198[x204]);
}
else if(x198)
x199(x198);
}
_f0.prototype._f98=function()
{
this.maparea=new Array();
var x205=this.minX;
var x206=this.maxX;
if(this.parent.msi!=null)
{
var x207=this.parent.msi._f159;
var x208=this.parent.msi._f158;
var x209=x208-x207;
var x210=0;
if(x205<x207)
{
x210=Math.ceil((x207-x205)/x209);
x205+=x209*x210;
x206+=x209*x210;
x210=0-x210;
}
else if(x205>=x208)
{
x210=Math.ceil((x205-x208)/x209);
x205-=x209*x210;
if(x205==x208)
{
x210++;
x205=x207;
}
x206-=x209*x210;
}
if(x206<=x208&&x205!=x206){
this.maparea.push({minx:x205,maxx:x206,n:x210});
}
else{
this.maparea.push({minx:x205,maxx:x208,n:x210});
x206-=x209;
x210++;
while(x206>x208)
{
this.maparea.push({minx:x207,maxx:x208,n:x210});
x206-=x209;
x210++;
}
this.maparea.push({minx:x207,maxx:x206,n:x210});
}
}
}
_f0.prototype._f167=function(x211,x212,x213)
{
var x214=this;
if(x212.areaNode)
{
var x215=x212.areaNode;
var x216=x215.getAttribute("coords");
var x217=x215.getAttribute("shape");
if(x212.wr&&x212.wr.length>1)
{
if(!x213)
{
x213=1;
}
if(x213==1)
{
x212.areaNode=new Array(x215);
}
for(var x218=x213;x218<x212.wr.length;x218++)
{
var x219=x215.cloneNode(true);
MVUtil._f164(x219,this._f1.cursorStyle);
var x220=x218*(this.parent.msi._f158-this.parent.msi._f159)*this.parent._f75;
var x221=this._f166(x216,x220,0);
if(_f10._f69=='IF')x219.setAttribute("shape",x217);
x219.setAttribute("coords",x221);
var x222=x219.getAttribute("coords");
if(x211)
x219.node=x211;
this._f162(x219,x212);
MVUtil._f163(x219);
this._f34.appendChild(x219);
x212.areaNode.push(x219);
}
}
}
if(!x211)
return;
var x223=parseInt(x211.style.left);
if(x212.wr&&x212.wr.length>1)
{
var x224=false;
if(!x213)
{
x213=1;
}
if(x213==1)
{
x212.node=new Array(x211);
}
for(var x218=x213;x218<x212.wr.length;x218++)
{
var x225=x211.cloneNode(true);
x225.id=x225.id+"clone"+x218;
x225.style.left=x223+x218*(this.parent.msi._f158-this.parent.msi._f159)*this.parent._f75;
if(x212._f192)
this._f193.appendChild(x225);
else
 this.div.appendChild(x225);
x225.orgid=x211.id;
this._f162(x225,x212);
MVUtil._f163(x211);
x212.node.push(x225);
}
}
}
_f0.prototype._f162=function(x226,x227)
{
var x228=this;
x226.tbf=x228;
x226.foi=x227;
x226.onmouseover=x228.tFoiMouseOver;
x226.onmouseout=x228.tFoiMouseOut;
if(this._f1._f103<=this._f20)
{
x226.onmousedown=x228.getMouseDownLocation;
x226.onmouseup=x228.tFoiMouseUp;
if(_f10._f69=='IF'&&!x228.shouldNotUseHTMLMap(x227))
x226.oncontextmenu=function(){return false;};
else
 x226.oncontextmenu=x228.tFoiRightClick;
x226.ondblclick=x228._f174;
x226.onclick=x228.stopPropagation;
x226.onkeyup=x228.stopPropagation;
}
else
 {
x226.onmousedown=null;
x226.onmouseup=null;
if(_f10._f69=='IF'&&!x228.shouldNotUseHTMLMap(x227))
x226.oncontextmenu=function(){return false;};
else
 x226.oncontextmenu=null;
x226.ondblclick=null;
x226.onclick=null;
x226.onkeyup=null;
}
}
_f0.prototype._f131=function(x229)
{
x229.wr=new Array();
var x230=0;
var x231=this.parent.msi._f159;
var x232=this.parent.msi._f158;
var x233=x232-x231;
var x234=this.parent.msi._f159+x233/2;
var x235=x229.x+x229.width;
var x236=x229.x;
var x237=false;
if(x236<=x231||x235>=x232)
{
x229.wr.push(this.maparea[0].n);
if(x236<x234&&x235<x234)
{
x235=x229.x+x233;
x236=x229.x+x229.width;
}
else if(x236>x234&&x235>x234)
{
x235=x229.x;
x236=x229.x+x229.width-x233;
}
for(var x238=1;x238<this.maparea.length;x238++)
{
if(this.maparea[x238].maxx>x236)
x229.wr.push(this.maparea[x238].n);
}
}
else
 {
for(var x238=0;x238<this.maparea.length;x238++)
{
if((x236>this.maparea[x238].minx&&x236<this.maparea[x238].maxx)||(x235>this.maparea[x238].minx&&x235<this.maparea[x238].maxx))
x229.wr.push(this.maparea[x238].n);
}
}
}
_f0.prototype._f166=function(x239,x240,x241)
{
if(x240!=0||x241!=0)
{
var x242="";
var x243=x239.split(" ");
for(var x244=0;x244<x243.length;x244++)
{
var x245=x243[x244].split(",");
for(var x246=0;x246<x245.length;){
x245[x246]=parseInt(x245[x246++])+x240;
x245[x246]=parseInt(x245[x246++])+x241;
}
x242+=x245.toString()+" ";
}
if(x242.length>0)
x242=x242.substring(0,x242.length-1);
return x242;
}
else
 return x239;
}
_f0.prototype._f47=function()
{
if(this._f1._f116)
return " marker_sequence=\""+this._f1._f117+"\"";
else
 return "";
}
_f0.prototype._f46=function()
{
if(this._f1._f110)
return " render_style=\""+this._f1._f110+"\"";
else
 return "";
}
_f0.prototype.getMainFOI=function(x247)
{
for(var x248=0;x248<this._f1._f124.foiarray.length;x248++)
{
if(!this._f1._f124.foiarray[x248].scid&&this._f1._f124.foiarray[x248].id==x247.id){
return this._f1._f124.foiarray[x248];
}
}
return null
}
function _f289(x0,x1,x2)
{
this.minX;
this.minY;
this.maxX;
this.maxY;
this.width=x0._f108();
this.height=x0._f109();
this.parent=x0;
this._f290=null;
this.div=document.createElement("div");
this.div.style.position="absolute";
this.div.style.zIndex="3000";
this.parent._f291.appendChild(this.div);
this._f160=document.createElement("div");
this._f160.style.position="absolute";
this._f160.style.backgroundColor="#FFFFDF";
this._f160.style.border="inset black 1px";
this._f160.style.visibility="hidden";
this._f160.style.zIndex="1200";
this.parent.div.appendChild(this._f160);
MVUtil._f73(this._f160,0,0);
this._f80=new Array(0);
this._f173=false;
this.mouseOver=false;
}
_f289.prototype.enableEventPropagation=function(x0)
{
this._f173=x0;
}
_f289.prototype._f292=function()
{}
_f289.prototype._f189=function()
{
this._f160.style.visibility='hidden';
}
_f289.prototype.refresh=function(x1,x2,x3,x4,x5,x6)
{
MVUtil._f73(this.div,0,0);
this.minX=x1;
this.minY=x2;
this.maxX=x3;
this.maxY=x4;
this.width=x5;
this.height=x6;
var x7=0;
for(;x7<this._f80.length;x7++)
{
var x8=MVUtil._f293(this.parent,this.minX,this.minY,this.maxX,this.maxY,
this.width,this.height,this._f80[x7].winX,this._f80[x7].winY);
this._f80[x7].style.visibility="hidden";
MVUtil._f73(this._f80[x7],x8.x,x8.y);
if(this._f80[x7].winX>=this.parent._f74&&this._f80[x7].winX<=this.parent._f288&&
this._f80[x7].winY>=this.parent._f294&&this._f80[x7].winY<=this.parent._f76)
this._f80[x7].style.visibility="visible";
}
}
_f289.prototype._f60=function()
{
return this.div;
}
_f289.prototype.showTextTip=function(x9,x10,x11)
{
this._f160.innerHTML=x9;
if(_f10._f69=="NS"&&navigator.userAgent.toLowerCase().indexOf("netscape")>0)
{
var x12=MVUtil._f48(x9.toLowerCase(),"&nbsp;"," ").length;
this._f160.style.width=MVUtil._f31(x12*8+8);
}
var x13=MVUtil._f293(this.parent,this.minX,this.minY,this.maxX,this.maxY,
this.width,this.height,x10,x11);
MVUtil._f73(this._f160,x13.x+10,x13.y+5);
this._f160.style.visibility="visible";
}
_f289.prototype._f185=function()
{
return this._f80.length>0;
}
_f289.prototype._f238=function(id,x14,x15,x16,x17,x18,x19,x20,x21,x22,x23,x24)
{
if(MVInfoWindowStyle1._f295)
{
clearTimeout(MVInfoWindowStyle1._f295);
MVInfoWindowStyle1._f295=null;
}
if(x20==null||x20=="")
{
x20=_f10._f296;
}
if(x22)
this.mouseOver=true;
else
 this.mouseOver=false;
this._f189();
var x25=this.parent;
if(x16==null||x16.length==0)
return ;
if(!x17)
x17=0;
else if(x17<0)
x17=0;
else if(x17>x16.length-1)
x17=x16.length-1;
var x26=0;
for(;x26<this._f80.length;x26++)
{
if(id&&this._f80[x26].nid==id){
this.deleteInfoWindow(this._f80[x26]);
return ;
}
}
if(this._f80.length>0)
this.deleteInfoWindow(this._f80[0]);
var x27=document.createElement("div");
var x28=this;
var x29=function(x30)
{
x30=(x30)?x30:((window.event)?event:null);
var x31=!x28._f173;
if(x30&&!x28._f173)
{
if(_f10._f69=="IF")
x30.cancelBubble=true;
else if(x30.stopPropagation)
x30.stopPropagation();
}
}
var x32=function(x33)
{
x25._f298=true;
x29(x33);
}
var x34=function(x35)
{
x25._f298=false;
x29(x35);
}
x27.id="mvinfodiv";
x27.onmousedown=MVUtil._f105(x27,x29);
x27.onmouseup=MVUtil._f105(x27,x29);
x27.onmouseover=MVUtil._f105(x27,x32);
x27.onmouseout=MVUtil._f105(x27,x34);
x27.ondblclick=MVUtil._f105(x27,x29);
x27.onclick=MVUtil._f105(x27,x29);
x27.onkeyup=MVUtil._f105(x27,x29);
if(_f10._f69=="OS")
x27.onkeypress=MVUtil._f105(x27,x29);
else
 x27.onkeydown=MVUtil._f105(x27,x29);
var x36=MVUtil._f293(this.parent,this.minX,this.minY,this.maxX,this.maxY,
this.width,this.height,x14,x15);
x27.style.position="absolute";
x27.style.visibility="hidden";
this.div.appendChild(x27);
if(x20!="MVInfoWindowStyle1")
{
var x37=document.createElement("div");
if(x18)
x37.style.width=x18;
if(x19)
x37.style.height=x19;
x37.innerHTML=x16[0].getContent();
x27.appendChild(x37);
var x38=document.getElementById("mvinfotable_"+this.parent._f145);
var x39=document.getElementById("mvinfotable1_"+this.parent._f145);
var x40=0,x41=0;
if(x38!=null&&x39!=null)
{
if(x38.offsetWidth<=x39.offsetWidth)
x40=x39.offsetWidth+45;
else
 x40=x38.offsetWidth+45;
x18=x40;
}
if(x40>x18)
x18=x40;
if(x38!=null&&x39!=null)
{
x38.style.width=x18+"px";
if(x38.offsetHeight<=x39.offsetHeight)
x41=x39.offsetHeight+40;
else
 x41=x38.offsetHeight+40;
}
if(x41>x19)
x19=x41;
x27.removeChild(x37);
}
this._f290=null;
this._f290=new _f299(x27,0,0,x16,x17,x18,x19,x20,x25,x22,this,x36,x23);
this._f80.push(x27);
x27.nid=id;
x27.winX=x14;
x27.winY=x15;
MVUtil._f73(x27,x36.x,x36.y);
x27.style.visibility="visible";
x27.style.zIndex="1200";
if(!x22)
{
var x42=0;var x43=0;
if(x20==_f10._f296)
{
var x38=document.getElementById("infowindow3table_"+this.parent._f145);
if(x38!=null)
{
x18=x38.offsetWidth;
x38.style.width=MVUtil._f31(x18);
x19=x38.offsetHeight;
x42=MVUtil._f83(x38);
x43=MVUtil._f84(x38);
}
}
if(x24&&x20=="MVInfoWindowStyle1")
return ;
var x44=x18;
var x45=x19;
var x46=this.parent._f140+x36.x+x42;
var x47=this.parent._f141+x36.y+x43;
var x48=0;
var x49=0;
if(x46<0)
{
if(this.parent._f140+x36.x<x46)
x48=this.parent._f140+x36.x-10;
else
 x48=x46;
}
else if(this.parent._f140+x36.x<0)
x48=this.parent._f140+x36.x-10;
else if(x46+x44>this.width)
{
if(this.parent._f140+x36.x>x46+x44)
x48=this.parent._f140+x36.x-this.width+10;
else
 x48=x46+x44-this.width;
}
else if(this.parent._f140+x36.x>this.width)
x48=this.parent._f140+x36.x-this.width+10;
if(x47<0)
{
if(this.parent._f141+x36.y<x47)
x49=this.parent._f141+x36.y-10;
else
 x49=x47;
}
else if(this.parent._f141+x36.y<0)
x49=this.parent._f141+x36.y-10;
else if(x47+x45>this.height)
{
if(this.parent._f141+x36.y>this.height)
x49=this.parent._f141+x36.y-this.height+10;
else
 x49=x47+x45-this.height;
}
else if(this.parent._f141+x36.y>this.height)
x49=this.parent._f141+x36.y-this.height+10;
if(x21)
this.setTimeout("this.parent.smoothScroll("+x48+","+x49+")",x21);
else
 this.parent.smoothScroll(x48,x49);
}
}
_f289.prototype._f287=function(x50,x51,x52,x53,x54,x55,x56,x57,x58,x59)
{
if(x50.length==0)
return;
if(x55&&x56)
{
this._f238(x50,x51,x52,x53,x54,x55,x56,x57,null,null,x59,true);
}
else
 this._f238(x50,x51,x52,x53,x54,_f10._f300,_f10._f301,x57,null,null,x59,true);
}
_f289.prototype._f302=function(x60,x61,x62,x63,x64,x65,x66)
{
var x67=new Array(4);
if(!x61)
x61="null";
x61=MVUtil._f48(x61," &nbsp;","  ");
var x68=0;
var x69=0;
var x70="";
var x71=12;
if(x61!="null")
{
if(x65)
x67[3]=x61;
else
 {
x68=x61.length;
x69++;
x70="<tr><td>"+this.replaceWhiteSpace(x61)+"</td></tr>";
}
}
x70="<table id='mvinfotable_"+this.parent._f145+"'>"+x70;
if(x62==null||x62.length==0){
x67[0]=x70;
if(x66=="MVInfoWindowStyle1")
{
x67[1]=0;
x67[2]=0;
}
else
 {
x67[1]=x61.length*x71+36;
x67[2]=27+30;
}
return x67;
}
var x72=0;
var x73=0;
x69+=x62.length;
x70+="<tr><td><table id='mvinfotable1_"+this.parent._f145+"'>";
for(var x74=0;x74<x62.length;x74++)
{
var x75="#bbbbbb";
if(x74%2==0)
x75="#dddddd";
if(x63!=null&&x63[x74]!=null&&x63[x74].length>x72)
x72=x63[x74].length;
if(x62[x74]==null)
x62[x74]="";
if(x62[x74].length>x73)
x73=x62[x74].length;
var x76=this.replaceWhiteSpace(MVUtil._f231(x62[x74]));
x70=x70+"<tr bgcolor="+x75+">";
if(x63!=null)
{
var x77="";
if(x63[x74]==null)
x77="&nbsp;";
else
 x77=this.replaceWhiteSpace(MVUtil._f231(x63[x74]))+":";
x70=x70+"<td>"+x77+"</td>";
}
x70=x70+"<td align=left>"+x76+"</td></tr>";
}
var x78;
if(x68>(x72+x73))
x78=(x68+1)*x71+40;
else
 x78=(x72+x73+1)*x71+40;
x67[0]=x70+"</table></td></tr></table>";
if(x66=="MVInfoWindowStyle1")
{
x67[1]=0;
x67[2]=0;
}
else
 {
x67[1]=x78;
x67[2]=x69*11+80;
}
return x67;
}
_f289.prototype._f181=function(x79,x80,x81,x82,x83,x84,
x85,x86,x87,x88,
x89)
{
var x90=x87._f42;
var x91=x87._f303?x87._f303:_f10._f296;
var x92=x87._f304;
var x93=x87._f305;
var x94=x87._f246;
if(x81.length==0&&x82.length==0)
return ;
if(x85&&x86)
{
var x95=new MVInfoWindowTab(x93,x79);
var x96=new Array(x95);
this._f238(x81,x83,x84,x95,0,x85,x86,x91,x88,x89,x94,true);
}
else
 {
var x97=this._f302(x81,x82,x79,x80,x90,x91=="MVInfoWindowStyle1"&&x92,x91);
var x95=new MVInfoWindowTab(x93?x93:x97[3],x97[0]);
var x96=new Array(x95);
if(x97[1]>0&&x97[2]>0||x91=="MVInfoWindowStyle1")
{
this._f238(x81,x83,x84,x96,0,x97[1],x97[2],x91,x88,x89,x94,true);
}
else
 this._f238(x81,x83,x84,x96,0,_f10._f300,
_f10._f301,x91,x88,x89,x94,true);
}
}
_f289.prototype._f306=function(x98,x99,x100,x101,x102,x103,x104,x105)
{
var x106=new MVInfoWindowTab(x104,x98);
var x107=new Array(x106);
this._f238("",x99,x100,x107,0,x101,x102,x103,null,null,x105);
}
_f289.prototype.deleteInfoWindow=function(x108)
{
if(MVInfoWindowStyle1._f295)
{
clearTimeout(MVInfoWindowStyle1._f295);
MVInfoWindowStyle1._f295=null;
}
var x109=0;
for(x109=0;x109<this._f80.length;x109++)
{
if(this._f80[x109]==x108){
this._f80.splice(x109,1);
}
}
MVUtil._f307(x108);
MVUtil._f133(x108);
this.div.removeChild(x108);
this.parent._f298=false;
}
_f289.prototype.setTimeout=function(_f149,_f150)
{
var Ie="tempVar"+_f265;
_f265++;
eval(Ie+" = this;");
var oi=_f149.replace(/\\/g,"\\\\");
oi=oi.replace(/\"/g,'\\"');
return window.setTimeout(Ie+'._setTimeoutDispatcher("'+oi+'");'+Ie+" = null;",_f150);
}
_f289.prototype._setTimeoutDispatcher=function(func)
{
eval(func);
}
_f289.prototype.scrollInfoLayer=function()
{
for(var x110=0;x110<this._f80.length;x110++)
{
if(this._f80[x110].winX<this.parent._f74||this._f80[x110].winX>this.parent._f288||
this._f80[x110].winY<this.parent._f294||this._f80[x110].winY>this.parent._f76)
this._f80[x110].style.visibility="hidden";
else
 this._f80[x110].style.visibility="visible";
}
}
_f289.prototype.replaceWhiteSpace=function(x111)
{
x111=x111.replace(" ","&nbsp;");
return MVUtil._f48(x111,"  "," &nbsp;");
}
_f289.prototype.destroy=function()
{
MVUtil._f133(this.div);
MVUtil._f133(this._f160);
this._f160=null;
this.div=null;
if(this._f80&&this._f80.length>0)
this._f80.pop();
}
_f289.prototype.showTabbedHtmlWindow=function(x112,x113,x114,x115,x116,x117,x118,x119)
{
this._f238(null,x113,x114,x118,x119,x115,x116,null,null,null,x117);
}
function MVFOI(x0,x1,x2,x3,x4,x5)
{
if(!x0||x0.length==0)
{
MVi18n._f6("MVFOI.constructor","MAPVIEWER-05503");
return null;
}
this.parent="";
this.id=MVUtil._f231(x0);
this._f232=x1;
this.gtype=x1.getGType();
this.style=x2;
this._f3=x3;
this._f130="";
this._f233=null;
this.html="";
this._f234="";
this._f235="";
this.area="";
this._f236=null;
this._f237=new Array(4);
this._f160=null;
this.width=0;
this.height=0;
this._f72=true;
this.visible=true;
this._f92=false;
this._f192=false;
this._f238=true;
this._f239=true;
this._f179=null;
this._f182=null;
this._f183=null;
this._f188=null;
this._f97=new Array();
this._f186=true;
this._f240=0;
this._f241=0;
this._f173=true;
this.cursorStyle=null;
this._f242=null;
this._f243=null;
this.node=null;
if(this.gtype%10==1)
{
if(!x4)
this.width=10;
else if(x4>0)
this.width=x4;
if(!x5)
this.height=10;
else if(x5>0)
this.height=x5;
}
this._f244=null;
this._f245=null;
this._f246=null;
this._f247=100;
this._f248=100;
this._f66=null;
this.bgColor=null;
this.isHTMLFOI=null;
this.origgeom=null;
this.wr=null;
this.origFOI=null;
this.cloneFOI=null;
this.areacode=null;
}
MVFOI.prototype.setHTMLElement=function(x0,x1,x2)
{
this.html=x0;
if(x1)
this._f234=x1;
if(x2)
this._f235=x2;
}
MVFOI.createMarkerFOI=function(id,x3,x4,x5,x6)
{
return new MVFOI(id,x3,"",x4,x5,x6);
}
MVFOI.createHTMLFOI=function(id,x7,x8,x9,x10)
{
var x11=new MVFOI(id,x7,"","",0,0);
x11.setHTMLElement(x8,x9,x10);
x11.isHTMLFOI=true;
return x11;
}
MVFOI.prototype.addEventListener=function(x12,x13)
{
this.setEventListener(x12,x13);
}
MVFOI.prototype.setEventListener=function(x14,x15)
{
if(x14==MVEvent.MOUSE_CLICK)
{
this._f179=x15;
}
else if(x14==MVEvent.MOUSE_RIGHT_CLICK)
{
this._f182=x15;
}
else if(x14==MVEvent.MOUSE_OVER)
{
this._f183=x15;
}
else if(x14==MVEvent.MOUSE_OUT)
{
this._f188=x15;
}
if(this._f92)
{
this._f242._f249(this);
}
}
MVFOI.prototype.attachEventListener=function(x16,x17)
{
MVUtil.attachEventListener(this._f97,x16,x17)
if(this._f92)
{
this._f242._f249(this);
}
}
MVFOI.prototype.detachEventListener=function(x18,x19)
{
MVUtil.detachEventListener(this._f97,x18,x19);
}
MVFOI.prototype.setBringToTopOnMouseOver=function(x20)
{
this._f186=x20;
}
MVFOI.prototype.setTopFlag=function(x21)
{
this._f192=x21;
}
MVFOI.prototype.enableInfoWindow=function(x22)
{
this._f238=x22;
}
MVFOI.prototype.enableInfoTip=function(x23)
{
this._f239=x23;
}
MVFOI.prototype.setFOIOrds=function(x24)
{
this._f236=MVUtil._f231(x24).toUpperCase();
}
MVFOI.prototype.setFOIGtype=function(x25)
{
this.gtype=x25;
}
MVFOI.prototype.setVisible=function(x26)
{
this.visible=x26;
if(this.parent)
this.parent._f250._f251(this,x26);
}
MVFOI.prototype.isVisible=function()
{
return this.visible;
}
MVFOI.prototype.getId=function()
{
return this.id;
}
MVFOI.prototype.setClickable=function(x27)
{
this._f72=x27;
}
MVFOI.prototype.setInfoTip=function(x28)
{
if(x28)
this._f72=true;
this._f160=x28;
}
MVFOI.prototype.setInfoWindow=function(x29,x30,x31,x32,x33,x34)
{
this._f233=x29;
this._f240=x30;
this._f241=x31;
this._f244=x32;
this._f245=x33;
this._f246=x34;
}
MVFOI.prototype.enableEventPropagation=function(x35)
{
this._f173=x35;
}
MVFOI.prototype.setZIndex=function(x36)
{
this._f247=x36;
if(this.node)
this.node.zIndex=x36;
}
MVFOI.prototype.setImageFormat=function(x37,x38)
{
if(x37)
{
this._f66=x37.toUpperCase();
if(this._f66=="PNG8"&&x38)
this.bgColor=x38;
}
}
MVFOI.prototype.getMBR=function()
{
var x39=new Array(4);
if(this.gtype%10==3&&this.elemInfo[2]==4)
{
x39[0]=parseFloat(this._f236[4]);
x39[1]=parseFloat(this._f236[3])-
Math.abs((parseFloat(this._f236[0])-parseFloat(this._f236[4])));
x39[2]=parseFloat(this._f236[0]);
x39[3]=parseFloat(this._f236[3]);
}
else
 {
x39[0]=parseFloat(this._f236[0]);
x39[1]=parseFloat(this._f236[1]);
x39[2]=parseFloat(this._f236[0]);
x39[3]=parseFloat(this._f236[1]);
for(var x40=2;x40<this._f236.length;x40=x40+2)
{
if(parseFloat(this._f236[x40])<x39[0])x39[0]=parseFloat(this._f236[x40]);
if(parseFloat(this._f236[x40])>x39[2])x39[2]=parseFloat(this._f236[x40]);
if(parseFloat(this._f236[x40+1])<x39[1])x39[1]=parseFloat(this._f236[x40+1]);
if(parseFloat(this._f236[x40+1])>x39[3])x39[3]=parseFloat(this._f236[x40+1]);
}
}
return x39;
}
MVFOI.prototype._f252=function(x41){
var x42=x41;
var x43="";
var x44=x42.length;
for(var x45=this.elemInfo.length;x45>0;x45=x45-3)
{
var x46=0;
if(this.elemInfo[x45-2]%10==3&&this.elemInfo[x45-1]==3){
for(var x47=0;x47<this.elemInfo[x45-3]-1;x47++)
x46=x42.indexOf(",",x46)+1;
var x48=x46;var x49=x46;if(x45==this.elemInfo.length){
x48=x42.length;
for(var x50=0;x50<2;x50++)
x49=x42.indexOf(",",x49)+1;
x49--;
}
else
 {
for(var x51=0;x51<4;x51++)
{
x48=x42.indexOf(",",x48)+1;
if(x51==1)
x49=x48;
}
x48--;
x49--;
}
x43=x42.substring(x46,x48);
var x52=new Array(4);
var x53=1;
var x54=1;
for(var x55=0;x55<4;x55++){
x54=x43.indexOf(",",x53);
if(x55==3)x54=x43.length;
if(x55==0)x53--;
x52[x55]=x43.substring(x53,x54);
x53=x54+1;
}
var x56=x52[0]+","+x52[3];
var x57=x52[2]+","+x52[1];
this.elemInfo[x45-1]=1;
if(x45==this.elemInfo.length){
x42=x42+","+x57;
}
else
 {
this.elemInfo[x45-3+3]=this.elemInfo[x45-3+3]*1+4;
x42=x42.substring(0,x48)+","+x57+","+
x42.substring(x48+1,x42.length);
}
x42=x42.substring(0,x49)+","+x56+","+
x42.substring(x49+1,x42.length);
}
}
return x42;
}
MVFOI.prototype._f253=function(x58){
var x59=x58[0]+","+x58[1];
var x60="";
for(var x61=this.elemInfo.length;x61>0;x61=x61-3)
{
var x62=this.elemInfo[x61-3]-1;var x63=this.elemInfo[x61]-1;if(x61==this.elemInfo.length)
{
x63=x58.length;}
var x64=x58[x62]+","+x58[x62+1];
var x65="";
var x66=x63-1;
for(var x67=x62;x67<=x66;x67++)
{
x65+=x58[x67]+",";
}
var x68=false;
if(x58[x62]!=x58[x63-1]||x58[x62+1]!=x58[x63])
{
x65+=x64;
x68=true;
}
if(this.elemInfo.length==3)
{
return x65;
}
if(x61==3){
x60=x65+","+x60;
}
else
 {
if(x68)
x65+=","+x59;
else
 x65+=x59;
if(x61==this.elemInfo.length)
{
x60=x65;
}
else
 {
x60=x65+","+x60;
}
}
}
return x60;
}
MVFOI.prototype._f254=function(x69)
{
var x70=new Array(this._f236.length);
var x71=new Array(this._f237[0],this._f237[1],this._f237[2],this._f237[3]);if(x71[0]<x69._f250.minX)x71[0]=x69._f250.minX;
if(x71[1]<x69._f250.minY)x71[1]=x69._f250.minY;
if(x71[3]>x69._f250.maxY)x71[3]=x69._f250.maxY;
var x72=x71[3]-x71[1];
for(var x73=0;x73<this._f236.length;x73++)
{
if(x73%2==0)
{
x70[x73]=Math.floor((this._f236[x73]-x71[0])*x69._f75+0.5);
}
else
 x70[x73]=Math.floor((x72-(this._f236[x73]-x71[1]))*x69._f77+0.5);
}
x71=null;
return x70;
}
function _f255(x0,x1)
{
var x2=new Array(x1[0],x1[1],x1[2],x1[3]);if(x2[0]<x0._f250.minX)x2[0]=x0._f250.minX;
if(x2[1]<x0._f250.minY)x2[1]=x0._f250.minY;
if(x2[3]>x0._f250.maxY)x2[3]=x0._f250.maxY;
var x3=(x1[2]+x1[0])/2;
var x4=(x1[3]+x1[1])/2
var x5=(x1[2]-x1[0])/2;
var x6=x2[3]-x2[1];
var x7;
var x8="";
var x9=2*Math.PI;
for(var x10=0;x10<90;x10++)
{
if(x10%2==0){
x7=Math.floor((x3+x5*Math.cos((x9*x10)/90)-x2[0])*
x0._f75+0.5);
}
else
 {
x7=Math.floor((x6-(x4+x5*Math.sin((x9*x10)/90)-
x2[1]))*x0._f77+0.5);
}
if(x10==0)x8+=x7;
else
 x8+=","+x7;
}
x2=null;
return x8;
}
MVFOI.prototype._f256=function(x74)
{
if(this.area==null||this.area=="")
{
this.area="";
if(this.gtype%10==3&&this.elemInfo[2]==4)
{
this.area=_f255(x74,this._f237);
}
else if(this.gtype%10==3||this.gtype%10==7)
{
var x75=this._f254(x74);
this.area=this._f253(x75);
}
}
}
MVFOI.prototype.animateToNewLocation=function(x76,x77)
{
var x78=this;
var x79=function(x80)
{
if(x80)
x76=x80;
if(x77==null)
x77=100;
x78.parent._f250.foiToNewLocation(x78,x76,x77);
}
if(!x76.srid)
x76.srid=this.parent.getSrid();
if(x76.srid&&(x76.srid!=this._f232.srid))
x76=this.parent.transformGeom(x76,this._f232.srid,null,x79);
else
 x79();
}
MVFOI.prototype.stopAnimation=function()
{
if(this.move_id!=null){
clearTimeout(this.move_id);
this.move_id=null;
var x81=this;
}
}
MVFOI.prototype.setMouseCursorStyle=function(x82)
{
this.cursorStyle=x82;
if(this._f257)
{
if(this._f257 instanceof Array)
{
for(var x83=0;x83<this._f257.length;x83++)
{
MVUtil._f164(this._f257[x83],x82);
}
}
else
 MVUtil._f164(this._f257,x82);
}
if(this.cloneFOI)
this.cloneFOI.setMouseCursorStyle(x82);
}
MVFOI.prototype.getGeometry=function()
{
if(this.origgeom)
return this.origgeom;
return this._f232;
}
MVFOI.prototype.setRenderingStyle=function(x84,x85,x86)
{
this.style=x84;
if(typeof x85!='undefined')
{
if(x85)
this.width=x85;
else
 this.width=0;
}
if(typeof x86!='undefined')
{
if(x86)
this.height=x86;
else
 this.height=0;
}
}
MVFOI.prototype.setWidth=function(x87)
{
if(!x87)
x87=0;
this.width=x87;
}
MVFOI.prototype.setHeight=function(x88)
{
if(!x88)
x88=0;
this.height=x88;
}
MVFOI.prototype.updateImageURL=function(x89,x90,x91)
{
this._f130=x89;
var x92=0;
var x93=0;
if(x90)
{
x92=this.width-x90;
this.width=x90;
}
if(x91)
{
x93=this.height-x91;
this.height=x91;
}
var x94=function(x95,x96,x97,x98,x99,x100)
{
if(x95)
{
var x101=MVUtil._f83(x95)+x96/2;
var x102=MVUtil._f84(x95)+x97/2;
if(x100)
{
x100.src=x89;
MVUtil._f73(x95,x101,x102);
}
else if(x95.src)
{
x95.src=x89;
MVUtil._f73(x95,x101,x102);
}
else if(x95.style.filter)
{
var x103=MVUtil._f48(x89,"(","%28");
x103=MVUtil._f48(x103,")","%29");
x95.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+
x103+"', sizingMethod='image');";
MVUtil._f73(x95,x101,x102);
}
else
 {
x98._f258(x99.id);
x98._f259(x99);
}
}
}
if(this.node instanceof Array)
{
for(var x104=0;x104<this.node.length;x104++)
{
var x105
if(this._f243)
x105=this._f243[x104];
x94(this.node[x104],x92,x93,this._f242,this,x105);
}
}
else if(this.node)
x94(this.node,x92,x93,this._f242,this,this._f243);
}
MVFOI.prototype.updateGeometry=function(x106)
{
var x107=this._f232;
this._f232=x106;
if(this._f92)
{
var x108=this;
var x109=function(x110)
{
if(x110)
x108._f232=x110;
if(x108._f232.getGType()==1&&x107.getGType()==1){
var x111;
x108.x=x108._f232.getPointX();
x108.x=MVUtil.keepInCSBoundary(x108.parent,x108.x);
x108.y=x108._f232.getPointY();
x108._f236=x108._f232.getFirstPoint();
x108._f236=MVUtil.keepOrdinatesInCSBoundary(x108._f242.parent,x108._f236);
x108._f232.sdo_ordinates=x108._f236;
if(x108._f236.length>0)
x108._f232.sdo_point.x=x108._f236[0];
var x112=(x108._f242.parent._f94-x108._f242._f27)*x108._f242.parent._f75;
var x113=(x108._f242.parent._f95-x108._f242._f28)*x108._f242.parent._f77;
if(x108._f242.around)
{
var x114=x108.wr;
var x115=0;
var x116=x108._f242.parent.msi._f159;
var x117=x108._f242.parent.msi._f158;
var x118=x117-x116;
x108.wr=new Array();
if(x108.areacode!=null){
var x115=x108._f242.maparea[0].n;
x115+=x108.areacode;
x108.wr.push(x115)
}
else
 for(var x119=0;x119<x108._f242.maparea.length;x119++){
if(x108.x>x108._f242.maparea[x119].minx&&x108.x<x108._f242.maparea[x119].maxx)
{
x108.wr.push(x108._f242.maparea[x119].n);
}
}
var x120=x114==null?0:x114.length;
var x121=x120<x108.wr.length?x120:x108.wr.length;
for(var x119=0;x119<x121;x119++)
{
x111=MVUtil._f157(x108._f242.parent,x108._f242.minX,x108._f242.minY,
x108._f242.maxX,x108._f242.maxY,
x108._f242.width,x108._f242.height,
x108.x+x108.wr[x119]*(x117-x116),x108.y);
x111[0]-=x112;
x111[1]+=x113;
if(x108.node instanceof Array)
MVUtil._f73(x108.node[x119],x111[0]-x108.width/2,x111[1]-x108.height/2);
else if(x108.node)
MVUtil._f73(x108.node,x111[0]-x108.width/2,x111[1]-x108.height/2);
}
if(x120<x108.wr.length)
{
x108._f242._f167(x108.node,x108,x108._f242,x120);
}
else
 {
for(var x119=x120-1;x119>=x108.wr.length;x119--)
{
x108.node[x119].parentNode.removeChild(x108.node[x119]);
MVUtil._f91(x108.node[x119]);
x108.node.pop();
x108._f243.pop();
x108._f257.pop();
}
}
}
else
 {
x111=MVUtil._f157(x108._f242.parent,x108._f242.minX,x108._f242.minY,
x108._f242.maxX,x108._f242.maxY,
x108._f242.width,x108._f242.height,
x108.x,x108.y);
x111[0]-=x112;
x111[1]+=x113;
MVUtil._f73(x108.node,x111[0]-x108.width/2,x111[1]-x108.height/2);
}
}
else
 {
x108._f242._f258(x108.id);
x108.gtype=x108._f232.getGType()
x108._f242._f259(x108);
}
}
if(!this._f232.srid)
this._f232.srid=this.parent.getSrid();
if(this._f232.srid!=this.parent.getSrid())
{
this.parent.transformGeom(this._f232,this.parent.srid,null,x109);
}
else
 x109();
}
}
MVFOI.prototype.reDraw=function()
{
if(this._f92)
{
this._f242._f258(this.id);
this._f242._f259(this);
}
}
MVFOI.prototype._f260=function()
{
if(this._f179||(this._f97[MVEvent.MOUSE_CLICK]!=null&&this._f97[MVEvent.MOUSE_CLICK].length!=0)||this._f182||(this._f97[MVEvent.MOUSE_RIGHT_CLICK]!=null&&this._f97[MVEvent.MOUSE_RIGHT_CLICK].length!=0)||
this._f183||(this._f97[MVEvent.MOUSE_OVER]!=null&&this._f97[MVEvent.MOUSE_OVER].length!=0)||this._f188||(this._f97[MVEvent.MOUSE_OVER]!=null&&this._f97[MVEvent.MOUSE_OUT].length!=0)||
this._f233||this._f160||this.cursorStyle)
return true;
else
 return false;
}
MVFOI.prototype.destroy=function()
{
this.node=null;
this._f257=null;
this._f243=null;
}
function _f261(x0)
{
this._f262=[];
this.parent=x0;
var x1=null;
this.minX=0;
this.minY=0;
this.maxX=0;
this.maxY=0;
this._f23=0;
this._f24=0;
this._f52=false;
this.div=document.createElement("div");
this.width=0;
this.height=0;
this.count=0;
this._f27=this.parent._f94;
this._f28=this.parent._f95;
this._f96=null;
this._f97=new Array();
this.div.style.position="absolute";
this.div.style.zIndex=120;
this._f193=document.createElement("div");
this._f193.style.position="absolute";
this._f193.style.zIndex=180;
this.move_id=null;
this.time=20;
if(this.parent.div.appendChild)
{
this.parent.div.appendChild(this.div);
this.parent.div.appendChild(this._f193);
}
else
 {
document.body.appendChild(this.div);
document.body.appendChild(this._f193);
}
this.mouseL1=MVSdoGeometry.createPoint(0,0);
this.mouseL2=this.mouseL1;
this.maparea=null;
this.around=false;
}
_f261.prototype.foiToNewLocation=function(x122,x123,x124)
{
if(x124)
x122.time=x124;
else
 x122.time=this.time;
var x125=new Array();
var x126=new Array();
if(x123.getFirstPoint()){
x125.push(x123.getPointX());
x126.push(x123.getPointY());
}
else
 {
var x127=x123.getDimensions();
for(var x128=0;x128<=x123.getOrdinates().length-x127;x128=x128+x127)
{
x125.push(x123.getOrdinates()[x128]);
x126.push(x123.getOrdinates()[x128+1]);
}
}
var x129=0;
if(x125.length<=x129||x126.length<=x129)
return;
if(x122.move_id)
{
clearTimeout(x122.move_id);
x122.move_id=null;
}
x122.startX=x122.x;
x122.startY=x122.y;
x122.move_xarray=x125;
x122.move_yarray=x126;
x122.move_seq=x129;
x122.move_id=this.setTimeout("this.moveFoi(\""+x122.id+"\")",x122.time);
}
_f261.prototype.moveFoi=function(id)
{
var x130=this._f263(id);
var x131=x130.node;
if(x131 instanceof Array)
x131=x131[0];
var x132=parseInt(x131.style.left);
var x133=parseInt(x131.style.top);
var x134=x130.move_seq;
var x135=x130.move_xarray;
var x136=x130.move_yarray;
var x137=x135[x134];
if(x130.tx&&x130.tx.length>0)
x137+=x130.wr[0]*(this.parent.msi._f158-this.parent.msi._f159);
var x138=0;
x137=MVUtil.transLongitudeOnWarpAroungMap(this.parent,x130.x,x137);
if(this.around)
{
x138=x130.wr[0]*(this.parent.msi._f158-this.parent.msi._f159);
}
var x139=MVUtil._f157(this.parent,this.minX,this.minY,this.maxX,this.maxY,
this.width,this.height,x137+x138,x136[x134]);
var x140=(this.parent._f94-this._f27)*this.parent._f75;
var x141=(this.parent._f95-this._f28)*this.parent._f77;
x139[0]=Math.round(x139[0]-x140-x130.width/2);
x139[1]=Math.round(x139[1]+x141-x130.height/2);
var x142=x139[0]-x132;
var x143=x139[1]-x133;
var x144=Math.sqrt(x142*x142+x143*x143);
var x145=40;
if(x145>x144)
{
x131.style.left=MVUtil._f31(x139[0]);
x131.style.top=MVUtil._f31(x139[1]);
if(x130.node instanceof Array)
{
for(var x146=1;x146<x130.node.length;x146++)
{
x130.node[x146].style.left=MVUtil._f31(parseInt(x130.node[x146].style.left)+x142);
x130.node[x146].style.top=MVUtil._f31(parseInt(x130.node[x146].style.top)+x143);
}
}
clearTimeout(x130.move_id);
x130.move_id=null;
x130._f232.sdo_point.x=x135[x134];
x130._f232.sdo_point.y=x136[x134];
x130.x=x135[x134];
x130.y=x136[x134];
x134++;
if(x135.length<=x134||x136.length<=x134)
{
return;
}
if(x135.length>1)
x130.startX=x135[x134-1];
if(x136.length>1)
x130.startY=x136[x134-1];
x130.move_seq=x134;
x130.move_id=this.setTimeout("this.moveFoi(\""+id+"\")",x130.time);
}
else
 {
var x147=Math.round(x145*x142/x144);
var x148=Math.round(x145*x143/x144);
var x149=parseInt(x131.style.left)+x147;
var x150=parseInt(x131.style.top)+x148;
x131.style.left=MVUtil._f31(x149);
x131.style.top=MVUtil._f31(x150);
if(x130.node instanceof Array)
{
for(var x146=1;x146<x130.node.length;x146++)
{
x130.node[x146].style.left=MVUtil._f31(parseInt(x130.node[x146].style.left)+x147);
x130.node[x146].style.top=MVUtil._f31(parseInt(x130.node[x146].style.top)+x148);
}
}
x130.x=(x137-x130.x)/x142*x147+x130.x;
x130.y=(x137-x130.startY)*(x130.x-x130.startX)/(x137-x130.startX)+x130.startY;
if(this.around)
{
var x151=MVUtil.keepInCSBoundary(this.parent,x130.x);
var x152;
if(x151>x130.x)
x152=-1;
else if(x151<x130.x)
x152=1;
if(x152)
{
x130.x=x151;
if(x130.wr)
for(var x146=0;x146<x130.wr.length;x146++)
x130.wr[x146]+=x152;
}
}
else
 {
var x153=this.parent.msi._f158-this.parent.msi._f159;
if(x130.x<this.parent.msi._f159)
{
x130.x+=x153;
x131.style.left=MVUtil._f31(x149+x153*this.parent._f75);
}
else if(x130.x>this.parent.msi._f158)
{
x130.x-=x153;
x131.style.left=MVUtil._f31(x149-x153*this.parent._f75);
}
}
x130._f232.sdo_point.x=x130.x;
x130._f232.sdo_point.y=x130.y;
x130.move_id=this.setTimeout("this.moveFoi(\""+id+"\")",x130.time);
}
}
_f261.prototype.setTimeout=function(_f149,_f150)
{
var Ie="tempVar"+_f265;
_f265++;
eval(Ie+" = this;");
var oi=_f149.replace(/\\/g,"\\\\");
oi=oi.replace(/\"/g,'\\"');
return window.setTimeout(Ie+'._setTimeoutDispatcher("'+oi+'");'+Ie+" = null;",_f150);
}
_f261.prototype._setTimeoutDispatcher=function(func)
{
eval(func);
}
_f261.prototype.setSize=function(x154,x155)
{
this.width=x154;
this.height=x155;
}
_f261.prototype._f251=function(x156,x157)
{
var x158=x156.id;
for(var x159=0;x159<this._f262.length;x159++)
{
if(this._f262[x159].id==x158)
{
this._f262[x159].visible=x157;
if(!x157&&this.parent._f79._f80.length>0)
if(this.parent._f79._f80[0].nid==x158)
{
this.parent._f79.deleteInfoWindow(this.parent._f79._f80[0]);
}
}
}
var x160=x156.node
if(!x160&&x157&&(!x156.cloneFOI||!x156.cloneFOI.node))
{
if(this.parent._f266)
{
this.parent._f250._f267(x156,true);
}
return ;
}
if(x160 instanceof Array)
{
for(var x161=0;x161<x160.length;x161++)
{
if(x157)
x160[x161].style.visibility="visible";
else
 x160[x161].style.visibility="hidden";
}
}
else
 {
if(x160){
if(x157)
x160.style.visibility="visible";
else
 x160.style.visibility="hidden";
}
if(x156.cloneFOI&&x156.cloneFOI.node)
{
if(x157)
x156.cloneFOI.node.style.visibility="visible";
else
 x156.cloneFOI.node.style.visibility="hidden";
}
}
}
_f261.prototype._f52=function()
{
return this._f52;
}
_f261.prototype._f83=function()
{
if(this._f52)
return this._f23;
else
 return MVUtil._f83(this.div);
}
_f261.prototype._f84=function()
{
if(this._f52)
return this._f24;
else
 return MVUtil._f84(this.div);
}
_f261.prototype._f87=function()
{
return this.width;
}
_f261.prototype._f88=function()
{
return this.height;
}
_f261.prototype._f54=function()
{
return this.minX;
}
_f261.prototype._f55=function()
{
return this.minY;
}
_f261.prototype._f56=function()
{
return this.maxX;
}
_f261.prototype._f57=function()
{
return this.maxY;
}
_f261.prototype._f60=function()
{
return this.div;
}
_f261.prototype.getTopContainer=function()
{
return this._f193;
}
_f261.prototype._f268=function(x162)
{
this._f96=x162;
}
_f261.prototype._f269=function(x163)
{
for(var x164=0;x164<this.div.childNodes.length;x164++)
{
if(x163==(this.div.childNodes[x164]).id)
{
var x165=this.div.childNodes[x164];
this.div.removeChild(x165);
MVUtil._f91(x165);
return;
}
}
for(var x164=0;x164<this._f193.childNodes.length;x164++)
{
if(x163==(this._f193.childNodes[x164]).id)
{
var x165=this._f193.childNodes[x164];
this._f193.removeChild(x165);
MVUtil._f91(x165);
return;
}
}
}
_f261.prototype._f89=function()
{
var x166=this._f262.length;
for(var x167=0;x167<x166;x167++)
{
var x168=this._f262.pop();
MVUtil._f270(x168);
if(this.parent._f79._f80.length>0)
if(this.parent._f79._f80[0].nid==x168.id)
{
this.parent._f79.deleteInfoWindow(this.parent._f79._f80[0]);
}
}
MVUtil._f133(this.div);
MVUtil._f133(this._f193);
}
_f261.prototype._f258=function(x169)
{
var x170=null;
for(var x171=0;x171<this._f262.length;x171++)
{
if(this._f262[x171].id==x169)
{
x170=this._f262[x171];
if(x170.cloneFOI)
{
this._f258(x170.cloneFOI.id);
x170.cloneFOI.origFOI=null;
x170.cloneFOI._f242=null;
x170.cloneFOI=null;
}
if(this.parent._f79._f80.length>0)
if(this.parent._f79._f80[0].nid==x169)
{
this.parent._f79.deleteInfoWindow(this.parent._f79._f80[0]);
}
this._f262[x171]=this._f262[this._f262.length-1];
MVUtil._f270(this._f262.pop());
break;
}
}
if(x170)
{
if(x170.move_id!=null){
clearTimeout(x170.move_id);
x170.move_id=null;
}
if(x170.node)
{
var x172=x170.node
if(x172 instanceof Array)
{
for(var x173=0;x173<x172.length;x173++)
{
x172[x173].parentNode.removeChild(x172[x173]);
MVUtil._f91(x172[x173]);
}
}
else if(x170.node.parentNode)
{
x172.parentNode.removeChild(x172);
MVUtil._f91(x172);
}
}
x170.destroy();
for(var x174=0;x174<this._f193.childNodes.length;x174++)
{
if(this._f193.childNodes[x174].id==x169)
{
var x175=this._f193.childNodes[x174];
this._f193.removeChild(x175);
MVUtil._f91(x175);
x175=null;
break;
}
}
}
return x170;
}
_f261.prototype._f263=function(x176)
{
for(var x177=0;x177<this._f262.length;x177++)
{
if(x176==this._f262[x177].id)
{
return this._f262[x177];
}
}
return null;
}
_f261.prototype._f259=function(x178)
{
this._f262.push(x178);
if(this.parent._f266&&(x178.visible==true))
{
this._f267(x178,true);
}
}
_f261.prototype._f271=function(x179)
{
var x180=x179._f237[0];
var x181=x179._f237[1];
var x182=x179._f237[2];
var x183=x179._f237[3];
var x184=(this.minX==0?x180:this.minX);
var x185=(this.minY==0?x181:this.minY);
var x186=(this.maxX==0?x182:this.maxX);
var x187=(this.maxY==0?x183:this.maxY);
var x188=x180<x184?x184:x180;
var x189=x181<x185?x185:x181;
var x190=x182<x186?x182:x186;
var x191=x183<x187?x183:x187;
var x192;
if(this.around)
x192=Math.abs(x182-x180);
else
 x192=Math.abs(x190-x188);
var x193=Math.abs(x191-x189);
var x194={"x":x188,"y":x191,"width":x192,"height":x193}
return x194;
}
_f261.prototype._f267=function(x195,x196)
{
if(!x195._f232.srid)
x195._f232.srid=this.parent.getSrid();
var x197=this;
var x198=false;
var x199=function(x200)
{
if(x200)
x195._f232=x200;
if(x195.gtype%10==1)
{
x195._f236=x195._f232.getFirstPoint();
x195._f236=MVUtil.keepOrdinatesInCSBoundary(x197.parent,x195._f236);
x195._f232.sdo_ordinates=x195._f236;
if(x195._f236.length>0)
x195._f232.sdo_point.x=x195._f236[0];
}
else
 {
x195.elemInfo=x195._f232.sdo_elem_info.toString().split(",");
var x201=x195._f232.sdo_ordinates;
if(!x195.origFOI)
{
x201=MVUtil.keepOrdinatesInCSBoundary(x197.parent,x201);
if(x197.parent.wraparound)
{
x195.origgeom=x195._f232.clone();
x195._f232.sdo_ordinates=x201;
var x202=x195._f232.getOrdinatesOfElements();
x201=new Array();
for(var x203=0;x203<x202.length;x203++)
x201=x201.concat(MVUtil.transOrdinatesOnWarpAroungMap(x197.parent,x202[x203]));
x195._f232.sdo_ordinates=x201;
}
else if(!x197.parent.wraparound&&MVUtil.crossDateLine(x197.parent,x201))
{
x195.origgeom=x195._f232.clone();
var x202=x195._f232.getOrdinatesOfElements();
x201=new Array();
for(var x203=0;x203<x202.length;x203++)
x201=x201.concat(MVUtil.transOrdinatesOnWarpAroungMap(x197.parent,x202[x203]));
x195._f232.sdo_ordinates=x201;
x198=true;
}
}
x201=x201.toString();
while(x201.indexOf(" ")!=-1)
{
x201=MVUtil._f48(x201," ","");
}
for(var x204=0;x204<x195.elemInfo.length;x204+=3){
if(x195.elemInfo[x204+2]*1==3){
x201=x195._f252(x201);
break;
}
}
x195._f236=x201.split(",");
}
x195._f237=x195.getMBR();
if(x198&&x195._f236.length>0&&!x195.cloneFOI)
{
var x205=x195._f232.clone();
x205.sdo_ordinates=MVUtil.duplicateCrossDateLineOrds(x197.parent,x195._f236,x195._f237);
var x206=MVUtil.cloneObject(x195);
x206.id="-CL"+x195.id;
x206._f232=x205;
x206.origFOI=x195;
x195.cloneFOI=x206;
x197._f259(x206);
}
x195.x=x195._f237[0];
x195.y=x195._f237[3];
if(x195.gtype%10!=1)
{
x195.width=x195._f237[2]-x195._f237[0];
x195.height=x195._f237[3]-x195._f237[1];
}
x197._f272(x195,x196);
}
if(x195._f232.srid&&(x195._f232.srid!=this.parent.srid))
this.parent.transformGeom(x195._f232,this.parent.srid,null,x199);
else
 x199();
}
_f261.prototype._f272=function(foi,check)
{
var styleStr=null;
if(foi.style)
{
if(foi.style.getXMLString)
styleStr=foi.style.getXMLString();
else
 styleStr=foi.style;
}
if(foi.gtype%10==1)
{
if(styleStr)
foi._f130=foi._f3+"?request=getpoiimage&version=1.0"+
"&poistyle="+encodeURIComponent(styleStr)+
"&width="+foi.width+"&height="+foi.height+
this.getImageParameters(foi);
if(this.around||foi.wr)
{
foi.wr=new Array();
if(foi.areacode==null)
{
var n=0;
var bbminx=this.parent.msi._f159;
var bbmaxx=this.parent.msi._f158;
for(var i=0;i<this.maparea.length;i++){
if(foi.x>this.maparea[i].minx&&foi.x<this.maparea[i].maxx){
foi.wr.push(this.maparea[i].n);
}
}
}
else{
var n=this.maparea[0].n;
n+=foi.areacode;
foi.wr.push(n)
}
}
else
 foi.wr=null;
this._f273(foi);
return;
}
if(_f10._f69=="IF")
styleStr=encodeURIComponent(styleStr);
var _f274=foi._f232.toString();
var url;
var reqParas;
if(this.around||foi.wr)
this._f131(foi);
else
 foi.wr=null;
var reqMinX=this.minX;
var reqMaxX=this.maxX;
if(foi.wr&&foi.wr.length>0)
{
var coverWidth=this.parent.msi._f158-this.parent.msi._f159;
var tOrds=foi._f232.sdo_ordinates;
var crossdl=MVUtil.crossDateLine(this.parent,tOrds);
var middle=this.parent.msi._f159+coverWidth/2;
if(crossdl){
if((this.maparea.length>1||(this.maparea.length==1&&foi._f237[2]<this.maparea[0].minx))
&&foi.x<middle&&foi.x<this.parent.msi._f159){
foi.wr[0]++;
}
else if((this.maparea.length==1&&foi._f237[0]>this.maparea[0].maxx)
&&(foi.x>middle||foi._f237[2]>middle))
{
foi.wr[0]--;
}
if(foi.width>(this.maxX-this.minX)){
reqMinX=this.minX-foi.wr[0]*coverWidth;
reqMaxX=this.maxX-foi.wr[0]*coverWidth;
if(reqMinX>foi.x)
foi.x=reqMinX;
}else{
reqMinX=foi._f237[0];
reqMaxX=foi._f237[2];
}
}else if(!crossdl&&foi.width>(this.maxX-this.minX)){
reqMinX=this.minX-foi.wr[0]*coverWidth;
reqMaxX=this.maxX-foi.wr[0]*coverWidth;
if(reqMinX>foi.x)
foi.x=reqMinX;
}else{
reqMinX=foi._f237[0];
reqMaxX=foi._f237[2];
}
}
else
 {
if(this.maxX>this.parent.msi._f158)
reqMaxX=this.parent.msi._f158;
if(this.minX<this.parent.msi._f159)
reqMinX=this.parent.msi._f159;
if(foi._f237[2]>this.parent.msi._f158)
foi._f237[2]=this.parent.msi._f158;
if(foi._f237[0]<this.parent.msi._f159)
{
foi._f237[0]=this.parent.msi._f159;
foi.x=foi._f237[0];
}
}
var reqMinY=this.minY;
var reqMaxY=this.maxY;
if(this.maxY>this.parent.msi._f275)
reqMaxY=this.parent.msi._f275;
if(this.minY<this.parent.msi._f276)
reqMinY=this.parent.msi._f276;
if(foi._f237[1]<this.parent.msi._f276)
foi._f237[1]=this.parent.msi._f276;
if(foi._f237[3]>this.parent.msi._f275)
{
foi._f237[3]=this.parent.msi._f275;
foi.y=foi._f237[3];
}
reqParas="&version=1.0"+"&figstyle="+encodeURIComponent(styleStr)+
"&ratx="+this.parent._f75+"&raty="+
this.parent._f77+'&bbox='+
reqMinX+':'+reqMinY+':'+reqMaxX+':'+reqMaxY+
this.getImageParameters(foi);
url=foi._f3+"?request=getfigimage"+reqParas+"&figord="+_f274;
if(url.length<_f10._f277&&
(!foi._f260()||this._f68(foi))){
foi._f130=url;
this._f273(foi);
return;
}
try
{
var _f278=this;
var localDomain=(MVUtil._f8(foi._f3)==MVUtil._f8(_f10._f118()));
var xmlHttp=localDomain||MVMapView._f7;
var _f279=MVUtil.getXMLHttpRequest(xmlHttp);
if(MVMapView._f7&&!localDomain)
foi._f3=_f10._f11()+"?rtarget="+foi._f3;
_f279.open("POST",foi._f3,true);
_f279.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
_f279.onreadystatechange=MVUtil._f105(_f279,function()
{
try
{
if(this.readyState!=4){
return;
}
if(this.status==200)
{
if(this.responseText.indexOf("imgurl")>=0)
{
var res=null;
eval("res="+this.responseText);
foi._f130=res.imgurl;
if(res.area&&res.area!="")
foi.area=res.area;
if(check)
{
if(foi._f192)
for(var td=0;td<_f278._f193.childNodes.length;td++)
{
if(_f278._f193.childNodes[td].id==foi.id)
{
_f278._f193.removeChild(_f278._f193.childNodes[td]);
break;
}
}
else
 for(var td=0;td<_f278.div.childNodes.length;td++)
{
if(_f278.div.childNodes[td].id==foi.id)
{
_f278.div.removeChild(_f278.div.childNodes[td]);
break;
}
}
}
_f278._f273(foi);
}
}
}
catch(e)
{
MVi18n._f6("MVIndFOIsControl.postAddAndDisplayIndFOI","MAPVIEWER-05500",e);
}
});
_f279.send("request=getfig"+reqParas+"&figord="+_f274);
}
catch(ex)
{
MVi18n._f6("MVIndFOIsControl.postAddAndDisplayIndFOI","MAPVIEWER-05511",ex);
}
}
_f261.prototype._f280=function()
{
return this._f262;
}
_f261.prototype._f281=function(x207,x208,x209,x210)
{
this._f52=true;
this.parent._f125();
this.minX=x207;
this.minY=x208;
this.maxX=x209;
this.maxY=x210;
this._f27=this.parent._f94;
this._f28=this.parent._f95;
this._f23=Math.ceil((this.minX-this.parent._f74)*this.parent._f75);
this._f24=-Math.ceil((this.maxY-this.parent._f76)*this.parent._f77);
MVUtil._f73(this.div,this._f23,this._f24);
MVUtil._f73(this._f193,this._f23,this._f24);
MVUtil._f133(this.div);
MVUtil._f133(this._f193);
this._f98();
this.around=this.parent.wrapAroundLayer(this._f87());
if(this._f96)
this._f96;
MVUtil.runListeners(this._f97,"refreshFOI");
MVUtil._f133(this.div);
MVUtil._f133(this._f193);
for(var x211=0;x211<this._f262.length;x211++)
{
var x212=this._f262[x211];
x212.node=null;
if(x212.move_id!=null){
clearTimeout(x212.move_id);
}
this._f267(x212,true);
}
}
_f261.prototype._f249=function(x213)
{
var x214=this;
if(x213._f72)
{
var x215=function(x216)
{
if(x213._f130&&x213.gtype%10!=1&&!x214._f68(x213))
{
var x217="0,0";
if(x213.area.length>0)
x217=x213.area;
x216.setAttribute("shape","poly");
x216.setAttribute("coords",x217);
if((x213._f179||(x213._f97[MVEvent.MOUSE_CLICK]!=null&&x213._f97[MVEvent.MOUSE_CLICK].length!=0)||((x213._f238&&x213._f233)))
&&_f10._f69!="OS")
{
x216.setAttribute("href","javascript:void(0)");
}
}
if(x213._f179||(x213._f97[MVEvent.MOUSE_CLICK]!=null&&x213._f97[MVEvent.MOUSE_CLICK].length!=0)||(x213._f238&&x213._f233))
{
MVUtil._f164(x213._f257,"pointer");
}
x216.onmousedown=x214.getMouseDownLocation;
x216.onmouseup=x214.IndMouseUp;
x216.oncontextmenu=x214.IndRightClick;
}
if(x213._f257 instanceof Array)
{
for(var x218=0;x218<x213._f257.length;x218++)
x215(x213._f257[x218]);
}
else
 x215(x213._f257)
}
if(x213.cursorStyle)
{
if(x213._f257 instanceof Array)
{
for(var x218=0;x218<x213._f72.length;x218++)
MVUtil._f164(x213._f257[x218],x213.cursorStyle);
}
else
 MVUtil._f164(x213._f257,x213.cursorStyle);
}
}
_f261.prototype._f273=function(x219)
{
x219._f92=true;
x219._f242=this;
var x220;
if(x219.wr&&x219.wr.length>0)
x220=MVUtil._f157(this.parent,this.minX,this.minY,this.maxX,this.maxY,
this.width,this.height,x219.x+x219.wr[0]*(this.parent.msi._f158-this.parent.msi._f159),
x219.y);
else
 x220=MVUtil._f157(this.parent,this.minX,this.minY,this.maxX,this.maxY,
this.width,this.height,x219.x,x219.y);
var x221=(this.parent._f94-this._f27)*this.parent._f75;
var x222=(this.parent._f95-this._f28)*this.parent._f77;
var x223;
var x224=MVUtil._f5(x219._f130.toLowerCase(),'png');
if(!(_f10._f69=='IF'&&(x219.style!=""||x224))&&!x219.html)
{
if(x219.gtype%10==1)
x223=document.createElement('img');
else
 x223=document.createElement('div');
}
else
 x223=document.createElement('div');
if(x219.visible)
x223.style.visibility="visible";
else
 x223.style.visibility="hidden";
x223.style.position="absolute";
var x225=false;
for(var x226=0;x226<this.parent._f135.length;x226++)
{
if(this.parent._f135[x226].layerControl&&this.parent._f135[x226].layerControl.zoomControl&&
!this.parent._f135[x226].layerControl.zoomControl.hasZoomFinished())
{
x225=true;
x223.style.display='none';
break;
}
}
x223.ifctl=this;
var x227=x219._f173;
x219._f257=x223;
if(x219._f130)
{
x223.className="noprint";
if(!x219.visible)
x223.style.visibility="hidden";
if(x219.id&&x219.id!=null)
x223.id=x219.id;
x223._f155=x219.x;
x223._f156=x219.y;
x223.style.zIndex=x219._f247;
if(x219._f192)
this._f193.appendChild(x223);
else
 this.div.appendChild(x223);
if(x219.gtype%10!=1)
{
this.displayPolygonIndFOI(x223,x220,x221,x222,x219);
}
else
 {
this.displayPointIndFOI(x223,x220,x221,x222,x219);
}
}
else if(x219.gtype%10==1)
{
x223.style.zIndex=x219._f247;
this.displayHTMLIndFOI(x223,x220,x221,x222,x219);
}
x219.node=x223;
var x228=this;
this._f167(x223,x219,x228);
if(x219.move_id!=null)
{
var x229=MVUtil._f157(this.parent,this.minX,this.minY,this.maxX,this.maxY,
this.width,this.height,x219.move_xarray[x219.move_seq],x219.move_yarray[x219.move_seq]);
var x230=Math.round(x229[0]-x219.width/2);
var x231=Math.round(x229[1]-x219.height/2);
x219.move_id=this.setTimeout("this.moveFoi(\""+x219.id+"\")",x219.time);
}
}
_f261.prototype._f39=function()
{
var x232="";
for(var x233=0;x233<this._f262.length-1;x233++)
{
for(var x234=1;x234<this._f262.length;x234++)
{
if(this._f262[x233]._f192&&!this._f262[x234]._f192)
{
var x235=this._f262[x233];
this._f262[x233]=this._f262[x234];
this._f262[x234]=x235;
}
}
}
for(var x233=0;x233<this._f262.length;x233++)
{
if(this._f262[x233].style&&this._f262[x233].visible)
{
var x236=this._f262[x233].style.name==null?
MVUtil._f44(this._f262[x233].style):
this._f262[x233].style.name;
x232+=this._f283(this._f262[x233]._f232,x236);
}
}
return x232;
}
_f261.prototype._f283=function(x237,x238)
{
var x239=x237.toGML();
if(x238.getXMLString)
x238=x238.name;
var x240="<geoFeature render_style=\""+x238+"\"><geometricProperty>"+x239+"</geometricProperty></geoFeature>"
return x240;
}
_f261.prototype.destroy=function()
{
this._f89();
this._f262=null;
this.div=null;
this._f193=null;
}
_f261.prototype._f65=function(x241)
{
return x241._f66?x241._f66:this.parent._f67;
}
_f261.prototype._f68=function(x242)
{
return _f10._f69=="IF"&&this._f65(x242)=="PNG24";
}
_f261.prototype.getImageParameters=function(x243)
{
var x244="";
var x245=this._f65(x243);
if(x245=="PNG8")
x244+="&format="+x245;
if(x243.bgColor)
x244+="&bgcolor="+x243.bgColor;
return x244;
}
_f261.prototype.displayHTMLIndFOI=function(x246,x247,x248,x249,x250)
{
var x251=x246.ifctl;
x246.id=x250.id;
x246.style.width=MVUtil._f31(x250.width);
x246.style.height=MVUtil._f31(x250.height);
x247[0]-=x248;
x247[1]+=x249;
MVUtil._f73(x246,x247[0]-x250.width/2,x247[1]-x250.height/2);
this._f193.appendChild(x246);
x246.onkeyup=x251.IndStopPropagation;
if(_f10._f69=="OS")
x246.onkeypress=x251.IndStopPropagation;
else
 {
x246.onkeydown=x251.IndStopPropagation;
x246.oncontextmenu=x251.IndStopPropagation;
}
if(_f10._f69=="IF")
x246.onselectstart=x251.IndStopPropagation;
if(x250._f160&&x250._f239&&_f10._f69!="OS")
{
x246.title=x250._f160;
}
this.setIndFOIListners(x250,x246);
if(x250.html)
{
var x252=document.createElement("div");
x252.style.position="absolute";
var x253=x250._f234;
var x254=x250._f235;
x252.style.left=MVUtil._f31(x253);
x252.style.top=MVUtil._f31(x254);
x252.style.padding=MVUtil._f31(0);
x250.foiDiv=x252;
x252.innerHTML=x250.html;
x246.appendChild(x252);
}
}
_f261.prototype.displayPolygonIndFOI=function(x255,x256,x257,x258,x259,x260)
{
var x261=this;
var x262=this._f271(x259);
x255.style.width=MVUtil._f31(Math.round(x262.width*this.parent._f75+0.5));
x255.style.height=MVUtil._f31(Math.round(x262.height*this.parent._f77+0.5));
var x263;
var x264;
var x265=x259._f237;
if(x259.wr&&x259.wr.length>0)
{
var x266=this.parent.msi._f158-this.parent.msi._f159;
x265[0]+=x259.wr[0]*x266;
x265[2]+=x259.wr[0]*x266;
}
if((x265[0]>this.maxX||x265[2]<this.minX||
x265[1]>this.maxY||x265[3]<this.minY)&&!this.around)
{
return;
}
if(this.parent.wraparound)
x263=x256[0];
else if(x256[0]>-this.parent._f140&&x256[0]<-this.parent._f140+this.width)
{
x263=x256[0];
}
else if(x256[0]<-this.parent._f140)
{
x263=-this.parent._f140;
}
else {
return;
}
if(x256[1]>-this.parent._f141&&x256[1]<-this.parent._f141+this.height)
{
x264=x256[1];
}
else if(x256[1]<-this.parent._f141)
{
x264=-this.parent._f141;
}
else {
return;
}
x263=Math.floor(x263+0.5);
x264=Math.floor(x264+0.5);
x263-=x257;
x264+=x258;
MVUtil._f73(x255,x263,x264);
if(this._f68(x259))
{
var x267=MVUtil._f48(x259._f130,"(","%28");
x267=MVUtil._f48(x267,")","%29");
x255.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+
x267+"', sizingMethod='image');";
if(x259._f160&&x259._f239)
{
x255.setAttribute("title",x259._f160);
}
this.setIndFOIListners(x259,x255);
x255.onkeyup=x261.IndStopPropagation;
if(_f10._f69=="OS")
x255.onkeypress=x261.IndStopPropagation;
else
 x255.onkeydown=x261.IndStopPropagation;
}
else
 {
var x268=_f285(x259._f130,0,0,0,0,10);
x255.appendChild(x268);
x259.node=x255;
if(!x259._f260())
return ;
x259._f256(x261.parent);
var x269=document.createElement("map");var x270=document.createElement("area");
x269.setAttribute("name","f"+x259.id);
x269.setAttribute("id","f"+x259.id);
x270.setAttribute("border",0);
if(x259._f160&&x259._f239)
{
if(_f10._f69!="OS")
x270.setAttribute("title",x259._f160);
}
x259._f257=x270;
var x271="0,0";
if(x259._f72&&x259._f260())
{
if(x259.area.length>0)
x271=x259.area;
if((x259._f179||(x259._f97[MVEvent.MOUSE_CLICK]!=null&&x259._f97[MVEvent.MOUSE_CLICK].length!=0)||((x259._f238&&x259._f233)))
&&_f10._f69!="OS")
x270.setAttribute("href","javascript:void(0)");
}
x270.setAttribute("shape","poly");
x270.setAttribute("coords",x271);
this.setIndFOIListners(x259,x270);
x268.setAttribute("usemap","#f"+x259.id,0);
x255.style.border=0;
x255.appendChild(x269);
x269.appendChild(x270);
}
}
_f261.prototype.displayPointIndFOI=function(x272,x273,x274,x275,x276)
{
var x277=this;
x273[0]-=x274;
x273[1]+=x275;
MVUtil._f73(x272,x273[0]-x276.width/2,x273[1]-x276.height/2);
var x278=MVUtil._f5(x276._f130.toLowerCase(),'png');
var x279=function(x280,x281)
{
var x282=document.createElement("div");
x282.style.position="absolute";
var x283=x280._f234;
var x284=x280._f235;
x282.style.left=MVUtil._f31(x283);
x282.style.top=MVUtil._f31(x284);
x282.style.padding=MVUtil._f31(0);
x280.foiDiv=x282;
x282.innerHTML=x280.html;
x281.appendChild(x282);
}
if((_f10._f69=='IF')&&
(x276.style!=""||x278))
{
if(!x276.width)
x272.style.width=MVUtil._f31(100);
else
 x272.style.width=MVUtil._f31(x276.width);
if(!x276.height)
x272.style.height=MVUtil._f31(100);
else
 x272.style.height=MVUtil._f31(x276.height);
var x285=MVUtil._f48(x276._f130,"(","%28");
x285=MVUtil._f48(x285,")","%29");
if(x276._f160&&x276._f239&&_f10._f69!="OS")
{
x272.setAttribute("title",x276._f160);
}
x272.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+
x285+"', sizingMethod='image');";
if(x276.html)
{
x279(x276,x272);
}
this.setIndFOIListners(x276,x272);
}
else
 {
if(x276._f160&&x276._f239&&_f10._f69!="OS")
{
x272.setAttribute("title",x276._f160);
}
if(x276.html)
{
var x286=document.createElement("img");
x276._f243=x286;
x286.style.position="relative";
x286.style.left=MVUtil._f31(0);
x286.style.top=MVUtil._f31(0);
x286.setAttribute("id",x276.id);
x286.src=x276._f130;
x286.setAttribute("border",0);
x286.foi=x272.foi;
x286.ifctl=x272.ifctl;
x272.appendChild(x286);
x279(x276,x272);
x277.setIndFOIListners(x276,x276._f243);
}
else
 {
x272.src=x276._f130;
x272.setAttribute("border",0);
x277.setIndFOIListners(x276,x272);
}
}
}
_f261.prototype.IndStopPropagation=function(x287)
{
x287=(x287)?x287:((window.event)?event:null);
var x288=MVUtil.getEventSource(x287);
var x289=MVUtil.getMVIndFOIsControlAndFOI(x288);
var x290=x289.ifctl;
if(!x290)
return;
var x291=x289.foi;
if(x287&&x291&&!x291._f173)
{
if(_f10._f69=="IF")
x287.cancelBubble=true;
else if(x287.stopPropagation)
x287.stopPropagation();
}
}
_f261.prototype.IndStopEvent=function(x292)
{
x292=(x292)?x292:((window.event)?event:null);
var x293=MVUtil.getEventSource(x292);
var x294=MVUtil.getMVIndFOIsControlAndFOI(x293);
var x295=x294.ifctl;
if(!x295)
return;
var x296=x294.foi;
if(x292&&x296&&!x296._f173)
{
MVUtil._f174(x292);
}
}
_f261.prototype.getMouseDownLocation=function(x297)
{
x297=(x297)?x297:((window.event)?event:null);
var x298=MVUtil.getEventSource(x297);
var x299=MVUtil.getMVIndFOIsControlAndFOI(x298);
var x300=x299.ifctl;
if(!x300)
return;
var x301=x299.foi;
x300.mouseL1=MVUtil._f175(x297);
x300.IndStopPropagation(x297);
}
_f261.prototype.IndMouseUp=function(x302)
{
x302=(x302)?x302:((window.event)?event:null);
var x303=MVUtil.getEventSource(x302);
var x304=MVUtil.getMVIndFOIsControlAndFOI(x303);
var x305=x304.ifctl;
if(!x305)
return;
var x306=x304.foi;
x305.mouseL2=MVUtil._f175(x302);
if(x305.mouseL1.x==x305.mouseL2.x&&x305.mouseL1.y==x305.mouseL2.y)
{
if(x302.button==2)
return;
if(!x306._f286&&x305.parent._f176)
return;
var x307=MVUtil.getMouseLocation(x305.parent,x302);
if(x306._f179||(x306._f97[MVEvent.MOUSE_CLICK]!=null&&x306._f97[MVEvent.MOUSE_CLICK].length!=0))
{
x305.parent._f177();
var x308=MVSdoGeometry.createPoint(x307.sdo_point.x,x307.sdo_point.y,x305.parent.srid);
if(x306._f179)
x306._f179(x308,x306,MVUtil.getEvent(x302));
MVUtil.runListeners(x306._f97,MVEvent.MOUSE_CLICK,[x308,x306,MVUtil.getEvent(x302)]);
}
else if(x306._f238&&x306._f233)
{
var x309=new MVInfoWindowTab(x306._f245,x306._f233);
var x310=new Array(x309);
if(x306._f240>0&&x306._f241>0)
x305.parent._f79._f287(x306.id,x307.sdo_point.x,x307.sdo_point.y,
x310,0,x306._f240,x306._f241,x306._f244,x306._f245);
else
 x305.parent._f79._f287(x306.id,x307.sdo_point.x,x307.sdo_point.y,
x310,0,null,null,x306._f244,x306._f245);
return;
}
}
x305.IndStopEvent(x302);
}
_f261.prototype.IndMouseOver=function(x311)
{
x311=(x311)?x311:((window.event)?event:null);
var x312=MVUtil.getEventSource(x311);
var x313=MVUtil.getMVIndFOIsControlAndFOI(x312);
var x314=x313.ifctl;
if(!x314)
return;
var x315=x313.foi;
var x316=MVUtil.getMouseLocation(x314.parent,x311);
var x317=MVSdoGeometry.createPoint(x316.sdo_point.x,x316.sdo_point.y,x314.parent.srid);
if(x315._f183)
{
x315._f183(x317,x315,MVUtil.getEvent(x311));
}
MVUtil.runListeners(x315._f97,MVEvent.MOUSE_OVER,[x317,x315,MVUtil.getEvent(x311)]);
if(x315._f186)
{
var x318=x315.node
if(x318 instanceof Array)
{
x315._f248=new Array();
for(var x319=0;x319<x318.length;x319++)
{
x315._f248.push(x318[x319].style.zIndex);
x318[x319].style.zIndex=1000;
}
}
else
 {
if(x318){
x315._f248=x315.node.style.zIndex;
x315.node.style.zIndex=1000;
}
if(x315.cloneFOI&&x315.cloneFOI.node)
{
x315.cloneFOI.node.style.zIndex=1000;
}
}
}
if(x315._f160&&x315._f239&&_f10._f69=="OS")
x314.parent._f79.showTextTip(x315._f160,x316.sdo_point.x,x316.sdo_point.y);
};
_f261.prototype.IndMouseOut=function(x320)
{
x320=(x320)?x320:((window.event)?event:null);
var x321=MVUtil.getEventSource(x320);
var x322=MVUtil.getMVIndFOIsControlAndFOI(x321);
var x323=x322.ifctl;
if(!x323)
return;
var x324=x322.foi;
var x325=MVUtil.getMouseLocation(x323.parent,x320);
var x326=MVSdoGeometry.createPoint(x325.sdo_point.x,x325.sdo_point.y,x323.parent.srid);
if(x324._f188)
{
x324._f188(x326,x324,MVUtil.getEvent(x320));
}
MVUtil.runListeners(x324._f97,MVEvent.MOUSE_OUT,[x326,x324,MVUtil.getEvent(x320)]);
if(x324._f186)
{
var x327=x324.node
if(x327 instanceof Array)
{
for(var x328=0;x328<x327.length;x328++)
{
x327[x328].style.zIndex=x324._f248[x328];
}
}
else
 {
if(x327)
x327.style.zIndex=x324._f248;
if(x324.cloneFOI&&x324.cloneFOI.node)
{
x324.cloneFOI.node.style.zIndex=x324._f248
}
}
}
if(x324._f160)
x323.parent._f79._f189();
};
_f261.prototype.IndRightClick=function(x329)
{
x329=(x329)?x329:((window.event)?event:null);
var x330=MVUtil.getEventSource(x329);
var x331=MVUtil.getMVIndFOIsControlAndFOI(x330);
var x332=x331.ifctl;
if(!x332)
return;
var x333=x331.foi;
if(x333._f182||(x333._f97[MVEvent.MOUSE_RIGHT_CLICK]!=null&&x333._f97[MVEvent.MOUSE_RIGHT_CLICK].length!=0))
{
var x334=MVUtil.getMouseLocation(x332.parent,x329);
var x335=MVSdoGeometry.createPoint(x334.sdo_point.x,x334.sdo_point.y,x332.parent.srid);
if(x333._f182)
x333._f182(x335,x333,MVUtil.getEvent(x329));
MVUtil.runListeners(x333._f97,MVEvent.MOUSE_RIGHT_CLICK,[x335,x333,MVUtil.getEvent(x329)]);
}
x332.IndStopEvent(x329);
}
_f261.prototype._f98=function()
{
this.maparea=new Array();
this.parent._f125();
var x336=(this._f87()-
this.parent._f108())*0.5/this.parent._f75;
var x337=this.parent._f74-x336;
var x338=this.parent._f288+x336;
if(this.parent.msi!=null)
{
var x339=this.parent.msi._f159;
var x340=this.parent.msi._f158;
var x341=x340-x339;
var x342=0;
if(x337<x339)
{
x342=Math.ceil((x339-x337)/x341);
x337+=x341*x342;
x338+=x341*x342;
x342=0-x342;
}
else if(x337>x340)
{
x342=Math.ceil((x337-x340)/x341);
x337-=x341*x342;
x338-=x341*x342;
}
if(x338<=x340){
this.maparea.push({minx:x337,maxx:x338,n:x342});
}
else{
this.maparea.push({minx:x337,maxx:x340,n:x342});
x338-=x341;
x342++;
while(x338>x340)
{
this.maparea.push({minx:x339,maxx:x340,n:x342});
x338-=x341;
x342++;
}
this.maparea.push({minx:x339,maxx:x338,n:x342});
}
}
var x343=this.maparea.length;
var x344=parseInt(x343/2);
if(x343>0&&x344==x343/2)
{
var x345=this.maparea[0].maxx-this.maparea[0].minx;
var x346=this.maparea[x343-1].maxx-this.maparea[x343-1].minx;
if(x345>x346)
this.centerArea=x343/2-1;
else
 this.centerArea=x343/2
}
else
 this.centerArea=Math.floor(x343/2);
}
_f261.prototype.setIndFOIListners=function(x347,x348)
{
if(x347.origFOI)
x347=x347.origFOI;
x348.onmouseover=this.IndMouseOver;
x348.onmouseout=this.IndMouseOut;
x348.ondblclick=this.IndStopEvent;
x348.onclick=this.IndStopEvent;
if(x347._f72&&x347._f260())
{
if((x347._f97[MVEvent.MOUSE_CLICK]!=null&&x347._f97[MVEvent.MOUSE_CLICK].length!=0)||x347._f179||((x347._f238&&x347._f233)))
MVUtil._f164(x348,"pointer")
x348.onmousedown=this.getMouseDownLocation;
x348.onmouseup=this.IndMouseUp;
x348.oncontextmenu=this.IndRightClick;
}
if(x347.cursorStyle)
MVUtil._f164(x348,x347.cursorStyle);
MVUtil._f163(x348);
}
_f261.prototype._f131=function(x349)
{
x349.wr=new Array();
if(x349.areacode!=null)
{
var x350=this.maparea[0].n;
x350+=x349.areacode;
x349.wr.push(x350)
return;
}
var x350=0;
var x351=this.parent.msi._f159;
var x352=this.parent.msi._f158;
var x353=x352-x351;
var x354=this.parent.msi._f159+x353/2;
var x355=x349._f237[2];
var x356=x349._f237[0];
var x357=false;
if(x356<x351||x355>x352)
{
x349.wr.push(this.maparea[0].n);
if(x356<x354&&x355<x354)
{
for(var x358=1;x358<this.maparea.length;x358++)
{
if(this.maparea[x358].maxx>(x356+x353))
x349.wr.push(this.maparea[x358].n);
}
}
else{
for(var x358=1;x358<this.maparea.length;x358++)
{
if(this.maparea[x358].maxx>x356)
x349.wr.push(this.maparea[x358].n);
}
}
}
else
 {
for(var x358=0;x358<this.maparea.length;x358++)
{
if((x356>this.maparea[x358].minx&&x356<this.maparea[x358].maxx)||(x355>this.maparea[x358].minx&&x355<this.maparea[x358].maxx)
||(x356<this.maparea[x358].minx&&x355>this.maparea[x358].maxx))
x349.wr.push(this.maparea[x358].n);
}
}
}
_f261.prototype._f167=function(x359,x360,x361,x362)
{
var x363=parseInt(x359.style.left);
if(x360.wr&&x360.wr.length>1)
{
var x364=false;
if(x360._f243)
{
x364=true;
}
if(!x362)
{
x362=1;
}
if(x362==1)
{
x360.node=new Array(x359);
x360._f257=new Array(x360._f257);
if(x364)
{
x360._f243=new Array(x360._f243);
}
}
for(var x365=x362;x365<x360.wr.length;x365++)
{
var x366=x359.cloneNode(true);
x366.id=x366.id+"clone"+x365;
x366.style.left=x363+x365*(this.parent.msi._f158-this.parent.msi._f159)*this.parent._f75;
if(x360._f192)
this._f193.appendChild(x366);
else
 this.div.appendChild(x366);
x366.ifctl=x361;
x366.orgid=x359.id;
if(x364&&x366.childNodes.length>0)
{
x360._f243.push(x366.childNodes[0]);
}
if(x360.gtype%10==1||this._f68(x360)||!x360.area)
{
this.setIndFOIListners(x360,x366);
x360._f257.push(x366);
}
else if(x366.childNodes.length>1)
{
var x367=x366.childNodes[0];
var x368=x366.childNodes[1];
this.setIndFOIListners(x360,x368);
x367.setAttribute("usemap","#f"+x360.id+"clone"+x365,0);
x368.setAttribute("name","f"+x360.id+"clone"+x365);
x368.setAttribute("id","f"+x360.id+"clone"+x365);
if(x368.childNodes.length>0)
{
x360._f257.push(x368.childNodes[0]);
}
}
x360.node.push(x366);
}
}
}
_f261.prototype.detachEventListener=function(x369,x370)
{
MVUtil.detachEventListener(this._f97,x369,x370);
}
_f261.prototype.attachEventListener=function(x371,x372)
{
MVUtil.attachEventListener(this._f97,x371,x372)
}
function MVRedlineTool(linestyle,areastyle,foiServerURL)
{
var _f308=eval(_f10._f308);
_f10._f308=(++_f308);
this.id=_f308;
this._f309=0;
this._f310=0;
this.parent="";
this._f3=foiServerURL;
this._f311=null;
this._f312=linestyle;
this._f313=areastyle;
this._f314=0;
this._f315=0;
this._f316=0;
this._f317=0;
this.mouseDownX=0;
this.mouseDownY=0;
this.pointdx=0;
this.pointdy=0;
this._f318=new Array();
this.state=0;
this._f153=0;
this._f319=0;
this._f320=0;
this._f321=null;
this._f322=5;
this._f323=5;
this._f324=false;
this._f325=false;
this._f326=null;
var _f327=this;
this._f97=new Array();
this._f328=null;
this._f329=null;
this._f330=new Array();
this._f331=new Array();
this.gtype=3;
this._f332=null;
this._f333=null;
this._f334=null;
this._f335=null;
this._f336=null;
this._f337=false;
this._f338="";
this._f339=null;
this._f340=true;
this.editingMode={deletePoint:true,dragPoint:true,deleteLine:true,dragLine:true};
this._f341=function(x0,x1,x2)
{
if(!_f327.editingMode)
return ;
var x3=x1.objType4RedLineTool;
switch(x3)
{
case -1:
if(!_f327.editingMode.deletePoint)
return ;
break;
case -2:
if(!_f327.editingMode.deleteLine)
return ;
break;
}
_f327._f332=x1;
var x4=x0.getPointX();
var x5=MVUtil.calAreaCodeFromCenter(_f327.parent,x4);
var x6=new MVMenu(_f327.parent,x0,x5);
_f327._f334=x6.menuFOIId;
switch(x3)
{
case -1:
x6.addMenuItem(MVi18n._f342("delete"),_f327._f343);
break;
case -2:
x0.sdo_ordinates[0]=x4;
x0.sdo_point.x=x4;
_f327._f333=x0;
x6.addMenuItem(MVi18n._f342("delete"),_f327._f344);
x6.addMenuItem(MVi18n._f342("addpoint"),_f327._f345);
break;
}
MVUtil._f174(x2);
}
this._f346=function(x7,x8,x9)
{
if(!_f327.editingMode)
{
MVUtil._f174(x9);
return ;
}
var x10=x8.objType4RedLineTool;
switch(x10)
{
case -1:
if(!_f327.editingMode.dragPoint)
return ;
break;
case -2:
if(!_f327.editingMode.dragLine)
return ;
break;
}
if(_f327._f320!=0&&_f327._f320!=1)
return;
_f327._f320=1;
_f327._f332=x8;
MVUtil._f174(x9);
}
this._f347=function(x11,x12,x13)
{
if(_f327._f320!=1)
return;
_f327._f320=0;
_f327._f332=null;
MVUtil._f174(x13);
}
this._f344=function()
{
var x14=_f327._f332;
if(!x14)
return;
var x15=x14.objType4RedLineTool;
if(x15==-2)
{
_f327.removeEdge(x14);
}
}
this._f343=function()
{
var x16=_f327._f332;
if(!x16)
return;
var x17=x16.objType4RedLineTool;
if(x17==-1)
{
_f327.removeVertex(x16);
}
}
this._f345=function()
{
var x18=_f327._f332;
if(!x18)
return;
var x19=x18.objType4RedLineTool;
if(x19==-2)
{
var x20=_f327._f348(x18);
if(x20[0])
{
var x21=_f327._f333;
var x22=null;
var x23=null;
if(x21)
{
x22=x21.getPointX();
x23=x21.getPointY();
}
if(x22&&x23)
_f327.addVertex(x20[1]+1,x22,x23);
}
}
}
this._f349=function(x24)
{
x24=(x24)?x24:((window.event)?event:null);
if(_f10._f69=="IF")
{
_f327.mouseDownX=x24.clientX+document.body.scrollLeft;
_f327.mouseDownY=x24.clientY+document.body.scrollTop;
}
else
 {
_f327.mouseDownX=x24.pageX;
_f327.mouseDownY=x24.pageY;
}
if(_f327._f320==1)
{
_f10._f350=_f327;
_f327._f320=2;
_f327.parent._f351(x24);
_f327._f314=_f327.parent._f352();
_f327._f315=_f327.parent._f353();
MVUtil._f174(x24);
return;
}
if((_f10._f350)!=_f327||
(x24!=null&&x24.button==2))
return;
MVUtil._f174(x24);
_f327._f153=1;
_f327._f319=1;
if(_f10._f69=="IF")
{
_f327._f316=x24.clientX+document.body.scrollLeft;
_f327._f317=x24.clientY+document.body.scrollTop;
}
else
 {
_f327._f316=x24.pageX;
_f327._f317=x24.pageY;
}
}
this.keepTwoPointsInHalfEarth=function(x25,x26,x27)
{
if(_f327.parent.wraparound)
{
if(_f327.parent._f250.maparea.length==1)
{
x26.areacode=_f327.parent._f250.centerArea;
return;
}
var x28=_f327.parent.msi._f158-_f327.parent.msi._f159;
var x29;
if(x27)
x29=x27.areacode;
else
 x29=_f327.parent._f250.centerArea;
var x30=MVUtil.keepInCSBoundary(_f327.parent,x26.getGeometry().getPointX());
var x31;
if(x27)
x31=MVUtil.keepInCSBoundary(_f327.parent,x27.getGeometry().getPointX());
else
 x31=MVUtil.keepInCSBoundary(_f327.parent,_f327.parent._f226());;
_f327._f318[x25*2]=x30;
x26.areacode=x29;
var x32=x30-x31;
while(Math.abs(x32)>x28/2)
{
if(x32<0)
{
x30=x30+x28;
x26.areacode=x29+1;
}
else
 {
x30=x30-x28;
x26.areacode=x29-1;
}
x32=x30-x31;
}
}
}
this.refreshRedline=function(x33)
{
var x34=function(x35,x36)
{
x35=MVUtil.keepInCSBoundary(_f327.parent,x35);
x36=MVUtil.keepInCSBoundary(_f327.parent,x36);
var x37=x36-x35;
if(x37>0)
x35=x35+(_f327.parent.msi._f158-_f327.parent.msi._f159);
else
 x36=x36+(_f327.parent.msi._f158-_f327.parent.msi._f159);
if(Math.abs(x36-x35)>Math.abs(x37))
return Math.abs(x37);
else
 return Math.abs(x36-x35);
}
if(_f327.parent.wraparound)
{
var x38=_f327._f330;
if(_f327.getStatus()==1)
{
if(x38.length!=0)
{
var x39=0;
var x40=Number.MAX_VALUE;
var x41=MVUtil.keepInCSBoundary(_f327.parent,_f327.parent._f226());
for(var x42=0;x42<x38.length;x42++)
{
var x43=Math.abs(MVUtil.keepInCSBoundary(_f327.parent,x38[x42].getGeometry().getPointX())-x41);
if(x40>x43)
{
x40=x43;
x39=x42;
}
}
_f327.keepTwoPointsInHalfEarth(x39,x38[x39],null);
if(x39>0)
{
for(var x42=x39-1;x42>=0;x42--)
{
_f327.keepTwoPointsInHalfEarth(x42,x38[x42],x38[x42+1]);
}
}
if(x39<x38.length)
{
for(var x42=x39+1;x42<x38.length;x42++)
{
_f327.keepTwoPointsInHalfEarth(x42,x38[x42],x38[x42-1]);
}
}
}
_f327.refreshLines(x33);
}
else if(_f327.getStatus()==2)
{
if(_f327.parent.getFOI("-RL2RL"+_f327.id))
{
var x44=_f327.parent.getFOI("-RL2RL"+_f327.id);
var x45=Number.MAX_VALUE;
var x46=0;
for(var x42=0;x42<x38.length;x42++)
{
var x43=x34(x38[x42].getGeometry().getPointX(),_f327.parent._f226());
if(x45>x43)
{
x45=x43;
x46=x42;
}
}
_f327.keepTwoPointsInHalfEarth(x46,x38[x46],null);
if(x46>0)
{
for(var x42=x46-1;x42>=0;x42--)
{
_f327.keepTwoPointsInHalfEarth(x42,x38[x42],x38[x42+1]);
}
}
if(x46<x38.length)
{
for(var x42=x46+1;x42<x38.length;x42++)
{
_f327.keepTwoPointsInHalfEarth(x42,x38[x42],x38[x42-1]);
}
}
var x47=new Array();
var x48=Number.MAX_VALUE;
for(var x42=0;x42<x38.length;x42++)
{
if(x38[x42].areacode<x48)
x48=x38[x42].areacode;
}
for(var x42=0;x42<x38.length;x42++)
{
if(x38[x42].areacode==x48)
x47.push([x42,x38[x42]]);
}
var x49=0;
var x50=Number.MAX_VALUE;
for(var x42=0;x42<x47.length;x42++)
{
var x51=(x47[x42])[1];
if(MVUtil.keepInCSBoundary(_f327.parent,x51.getGeometry().getPointX())<x50)
{
x50=MVUtil.keepInCSBoundary(_f327.parent,x51.getGeometry().getPointX());
x49=(x47[x42])[0];
}
}
x44.areacode=x38[x49].areacode;
}
}
}
}
this.refreshLines=function(x52)
{
var x53=_f327._f331;
var x54=_f327._f330;
if(x53.length!=0)
{
for(var x55=0;x55<x53.length;x55++)
{
x53[x55].areacode=(x54[x55].areacode<x54[x55+1].areacode)?x54[x55].areacode:x54[x55+1].areacode;
if(x52)
x53[x55].updateGeometry(MVSdoGeometry.createLineString(_f327._f318.slice(x55*2,(x55*2+4)),(_f327.parent.srid)));
}
}
}
this._f354=function(x56)
{
if(_f327._f320==3)
{
_f327.parent._f355();
}
_f327._f320=0;
x56=(x56)?x56:((window.event)?event:null);
if((_f10._f350)!=_f327||_f327._f319!=1||
(x56!=null&&x56.button==2))
{
if(_f327._f335)
{
_f327._f335();
_f327._f335=null;
}
return;
}
_f327._f319=0;
if(_f327._f153==1&&_f327.state==1)
{
MVUtil._f174(x56);
_f327.parent._f178=null;
_f327._f153=0;
_f327._f314=_f327.parent._f352();
_f327._f315=_f327.parent._f353();
if(_f327._f315>_f327.parent.msi._f275)
_f327._f315=_f327.parent.msi._f275;
else if(_f327._f315<_f327.parent.msi._f276)
_f327._f315=_f327.parent.msi._f276;
if(_f327.gtype==1)
{
while(_f327._f330.length>0)
{
var x57=_f327._f330.pop();
_f327.parent.removeFOI(x57);
}
while(_f327._f331.length>0)
{
var x57=_f327._f331.pop();
_f327.parent.removeFOI(x57);
}
_f327._f330=new Array();
_f327._f331=new Array();
_f327.parent.removeFOI("-RL2RL"+_f327.id);
_f327.parent.removeFOI("-RL10RL"+_f327.id);
_f327._f318=new Array();
}
if(_f327._f318!=null&&_f327._f318.length>=2
&&_f327._f314==_f327._f318[_f327._f318.length-2]
&&_f327._f315==_f327._f318[_f327._f318.length-1])
return;
var x58=null;
var x59="-RL8RL"+_f327.id+"_"+(++_f327._f309);
if(_f327._f321)
{
x58=new MVFOI(x59,
MVSdoGeometry.createPoint(_f327._f314,_f327._f315,_f327.parent.srid),"",
_f327._f321,_f327._f322,_f327._f323);
}
else
 {
if(!_f327._f311)
{
_f327._f311=new MVStyleMarker(_f10._f356,"vector");
_f327._f311.setStrokeColor("000000");
_f327._f311.setStrokeWidth(1.5);
_f327._f311.setFillColor("ff5555");
_f327._f311.setVectorShape("c:30");
}
x58=new MVFOI(x59,MVSdoGeometry.createPoint(_f327._f314,_f327._f315,_f327.parent.srid),
_f327._f311,null,12,12);
}
x58.enableInfoTip(false);
x58._f286=true;
x58.enableInfoWindow(false);
x58.objType4RedLineTool=-1;
x58.setEventListener(MVEvent.MOUSE_RIGHT_CLICK,_f327._f341);
x58.setEventListener(MVEvent.MOUSE_OVER,_f327._f346);
x58.setEventListener(MVEvent.MOUSE_OUT,_f327._f347);
x58.setMouseCursorStyle("pointer");
x58.setBringToTopOnMouseOver(false);
x58.setTopFlag(true);
if(_f327._f324&&_f327._f330.length==0)
{
x58.setEventListener(MVEvent.MOUSE_CLICK,function()
{
_f327._f320=0;
if(_f327._f318.length<=2)
return;
_f327._f318.push(_f327._f318[0]);
_f327._f318.push(_f327._f318[1]);
_f327.generate();
if(_f327._f329)
_f327._f329();
MVUtil.runListeners(_f327._f97,MVEvent.FINISH);
return ;
});
}
_f327._f330.push(x58);
_f327._f318.push(_f327._f314);
_f327._f318.push(_f327._f315);
if(_f327._f330.length==0)
_f327.keepTwoPointsInHalfEarth(0,x58,null);
else
 _f327.keepTwoPointsInHalfEarth(_f327._f330.length-1,x58,_f327._f330[_f327._f330.length-2]);
_f327.parent.addFOI(x58);
FOILineLen=(_f327._f318.length);
if(FOILineLen>=4)
{
var x60=new MVFOI(("-RL6RL"+_f327.id+"_"+(++_f327._f310)),
MVSdoGeometry.createLineString(_f327._f318.slice((FOILineLen-4)),
(_f327.parent.srid)),_f327._f312,_f327._f3);
x60.enableInfoTip(false);
x60.enableInfoWindow(false);
x60.objType4RedLineTool=-2;
x60.setEventListener(MVEvent.MOUSE_RIGHT_CLICK,_f327._f341);
x60.setEventListener(MVEvent.MOUSE_OVER,_f327._f346);
x60.setEventListener(MVEvent.MOUSE_OUT,_f327._f347);
x60.setMouseCursorStyle("pointer");
x60.setBringToTopOnMouseOver(false);
if(_f327._f330[_f327._f330.length-2].areacode<_f327._f330[_f327._f330.length-1].areacode)
x60.areacode=_f327._f330[_f327._f330.length-2].areacode;
else
 x60.areacode=_f327._f330[_f327._f330.length-1].areacode;
_f327.parent.addFOI(x60);
_f327._f331.push(x60);
}
if(_f327._f325&&FOILineLen>4)
{
var x61=new Array(FOILineLen+2);
for(var x62=0;x62<FOILineLen;x62++)
x61[x62]=_f327._f318[x62];
x61[FOILineLen]=_f327._f318[0];
x61[FOILineLen+1]=_f327._f318[1];
_f327._f326.updateGeometry(MVSdoGeometry.createPolygon(x61,_f327.parent.srid));
}
if(_f327._f339&&!_f327._f339.isVisible()&&_f327._f340)
_f327._f339.setVisible(true);
if(_f327._f328)
_f327._f328();
MVUtil.runListeners(_f327._f97,MVEvent.NEW_SHAPE_POINT);
}
}
this.mouse_move=function(x63)
{
x63=(x63)?x63:((window.event)?event:null);
if((_f327._f320==2)||(_f327._f320==3))
{
_f10._f350=_f327;
_f327.parent._f351(x63);
var x64=_f327._f332;
var x65=x64.objType4RedLineTool;
switch(x65)
{
case -1:
_f327.moveVertex(x64,(_f327.parent._f352()),(_f327.parent._f353()));
break;
case -2:
var x66=(_f327.parent._f352());
var x67=(_f327.parent._f353());
var x68=x66-(_f327._f314);
var x69=x67-(_f327._f315);
_f327._f314=x66;
_f327._f315=x67;
if(_f10._f69=="IF")
{
_f327.pointdx=x63.clientX+document.body.scrollLeft-_f327.mouseDownX;
_f327.pointdy=x63.clientY+document.body.scrollTop-_f327.mouseDownY;
}
else
 {
_f327.pointdx=x63.pageX-_f327.mouseDownX;
_f327.pointdy=x63.pageY-_f327.mouseDownY;
}
_f327.moveEdge(x64,x68,x69);
break;
}
MVUtil._f174(x63);
if(_f327._f320==2)
{
_f327._f320=3;
_f327.parent._f219.onmousemove=function(x70){};
if(_f327.parent._f219.attached!=true)
{
if(_f10._f69=="IF")
{
_f327.parent._f219.attachEvent("onmousemove",_f327.mouse_move);
_f327.parent._f219.attached=true;
}
else
 {
_f327.parent._f219.addEventListener("mousemove",_f327.mouse_move,false);
_f327.parent._f219.attached=true;
}
}
}
return;
}
if((_f10._f350)!=_f327||
(x63!=null&&x63.button==2))
return;
if(_f327._f319==1)
{
var x68=0;
var x69=0;
if(_f10._f69=="IF")
{
x68=x63.clientX+document.body.scrollLeft-_f327._f316;
x69=x63.clientY+document.body.scrollTop-_f327._f317;
}
else
 {
x68=x63.pageX-_f327._f316;
x69=x63.pageY-_f327._f317;
}
var x71=_f10._f357;
if((x68*x68+x69*x69)>(x71*x71))
_f327._f319=2;
}
}
this.getStatus=function()
{
return this.state;
}
this.init=function(x72)
{
if(!_f327._f339)
{
_f327._f339=new MVMapDecoration("<div id=\"redline_cpan_div_"+this.id+"\" style=\"padding:3px 2px 2px 3px; border:1px solid black;font-size:9pt;background-color:white;filter:alpha(opacity=80);-moz-opacity:.80;opacity:.80;"
+this._f338+"\"><a id=\"finishLink_"+this.id+"\" href=\"javascript:void(0);\"> "+MVi18n._f342("finish")+"</a> / <a id=\"clearLink_"
+this.id+"\" href=\"javascript:void(0);\">"+MVi18n._f342("clear")+" </a></div>",0.4,0.9);
_f327._f339.afterDisAction=_f327.redlineInfoLink;
_f327.parent.addMapDecoration(_f327._f339);
_f327._f339.setDraggable(true);
_f327._f339.setDraggable(true);
_f327._f339.setVisible(false);
}
switch(x72)
{
case 1:
this.gtype=x72;
break;
case 2:
this.gtype=x72;
break;
default:
this.gtype=x72=3;
}
if(!this._f311)
this.setRenderingStyle(MVRedlineTool.STYLE_POINT,null);
if(!this._f312)
this.setRenderingStyle(MVRedlineTool.STYLE_LINE,null);
if(!this._f313)
this.setRenderingStyle(MVRedlineTool.STYLE_AREA,null);
this.parent._f176=true;
if(this.state==0)
{
if(_f10._f69=="IF")
{
this.parent._f219.attachEvent("onmousedown",this._f349);
this.parent._f219.attachEvent("onmouseup",this._f354);
this.parent._f219.attachEvent("onmousemove",this.mouse_move);
}
else
 {
this.parent._f219.addEventListener("mousedown",this._f349,false);
this.parent._f219.addEventListener("mouseup",this._f354,false);
this.parent._f219.addEventListener("mousemove",this.mouse_move,false);
}
}
_f10._f350=this;
if(this._f325)
{
this._f326=new MVFOI("-RL10RL"+this.id,
MVSdoGeometry.createPolygon([0,0,0,0,0,0,0,0],this.parent.srid),
this._f313,
this._f3);
this._f326.enableInfoTip(false);
this._f326.enableInfoWindow(false);
this._f326.setClickable(false);
this.parent.addFOI(this._f326);
}
while(this._f330.length>0)
{
var x73=this._f330.pop();
this.parent.removeFOI(x73);
}
while(this._f331.length>0)
{
var x73=this._f331.pop();
this.parent.removeFOI(x73);
}
this._f330=new Array();
this._f331=new Array();
this.parent.removeFOI("-RL2RL"+this.id);
this.parent.removeFOI("-RL10RL"+this.id);
if(this._f334!=null)
this.parent.removeFOI(this._f334);
this._f318=new Array();
this.state=1;
this.parent._f250.attachEventListener("refreshFOI",this.refreshRedline);
}
this.setTextStyle=function(x74)
{
_f327._f338=x74;
}
this.setControlPanelVisible=function(x75)
{
this._f340=x75;
if(this._f339)
this._f339.setVisible(x75);
}
this.redlineInfoLink=function()
{
var x76=document.getElementById("finishLink_"+_f327.id);
var x77=document.getElementById("clearLink_"+_f327.id);
x76.onclick=function()
{
if(_f327.finishLinkClick)
{
_f327.finishLinkClick();
}
_f327.generate();
if(_f327.getStatus()!=2)
_f327.clear();
}
x77.onclick=function()
{
if(_f327.clearLinkClick)
{
_f327.clearLinkClick();
}
_f327.clear();
}
}
this.getInfoDecorationDiv=function()
{
return document.getElementById("redline_cpan_div_"+this.id);
}
this.generate=function()
{
var x78=this.gtype;
if(this.state==1)
{
if(x78==3&&this._f318.length<6)
{
MVi18n._f6("MVRedlineTool.generate","MAPVIEWER-05512");
return;
}
else if(x78==2&&this._f318.length<4)
{
MVi18n._f6("MVRedlineTool.generate","MAPVIEWER-05512");
return;
}
else if(x78==1&&this._f318.length<2)
{
MVi18n._f6("MVRedlineTool.generate","MAPVIEWER-05512");
return;
}
var x79=this;
var x80=function()
{
if(x79._f331.length>0)
{
if(!x79._f331[x79._f331.length-1].node)
{
setTimeout(x80,50);
return ;
}
}
var x81=null;
if(x79._f330&&x79._f330[0])
{
x81=x79._f330[0].areacode;
for(var x82=1;x82<x79._f330.length;x82++)
{
if(x79._f330[x82]&&(x79._f330[x82].areacode<x81))
x81=x79._f330[x82].areacode;
}
}
x79.state=2;
for(var x82=0;x82<x79._f330.length;x82++)
{
var x83=x79._f330[x82];
x79.parent.removeFOI(x83);
}
while(x79._f331.length>0)
{
var x83=x79._f331.pop();
x79.parent.removeFOI(x83);
}
x79._f331=new Array();
if(x79._f334!=null)
x79.parent.removeFOI(x79._f334);
x79.parent.removeFOI("-RL10RL"+x79.id);
var x84=x79._f318.length;
if(x78==3&&(x79._f318[0]!=x79._f318[x84-2]||x79._f318[1]!=x79._f318[x84-1]))
{
x79._f318.push(x79._f318[0]);
x79._f318.push(x79._f318[1]);
}
var x85=null;
switch(x78)
{
case 1:
if(x79._f321)
x85=new MVFOI("-RL2RL"+x79.id,MVSdoGeometry.createPoint(x79._f318[0],x79._f318[1],x79.parent.srid),"",x79._f321,x79._f322,x79._f323);
else
 x85=new MVFOI("-RL2RL"+x79.id,MVSdoGeometry.createPoint(x79._f318[0],x79._f318[1],x79.parent.srid),x79._f311,x79._f3);
break;
case 2:
x85=new MVFOI("-RL2RL"+x79.id,MVSdoGeometry.createLineString(x79._f318,x79.parent.srid),x79._f312,x79._f3);
break;
case 3:
x85=new MVFOI("-RL2RL"+x79.id,MVSdoGeometry.createPolygon(x79._f318,x79.parent.srid),x79._f313,x79._f3);
break;
}
x85.areacode=x81;
x85.enableInfoTip(false);
x85.enableInfoWindow(false);
x85.setClickable(false);
x85.setTopFlag(x79._f337);
x79.parent.addFOI(x85);
x79.parent._f176=false;
if(_f327._f329)
_f327._f329();
MVUtil.runListeners(_f327._f97,MVEvent.FINISH);
}
x80();
}
}
this.generateArea=this.generate;
this.clear=function()
{
if(!this.parent)
return ;
var x86=false;
while(this._f330.length>0)
{
var x87=this._f330.pop();
this.parent.removeFOI(x87);
x86=true;
}
while(this._f331.length>0)
{
var x87=this._f331.pop();
this.parent.removeFOI(x87);
x86=true;
}
if(this.parent.getFOI("-RL2RL"+this.id))
x86=true;
this.parent.removeFOI("-RL2RL"+this.id);
if(this.parent.getFOI("-RL10RL"+this.id))
x86=true;
this.parent.removeFOI("-RL10RL"+this.id);
if(this._f334!=null)
this.parent.removeFOI(this._f334);
if(_f10._f69=="IF")
{
this.parent._f219.detachEvent("onmousedown",this._f349);
this.parent._f219.detachEvent("onmouseup",this._f354);
this.parent._f219.detachEvent("onmousemove",this.mouse_move);
}
else
 {
this.parent._f219.removeEventListener("mousedown",this._f349,false);
this.parent._f219.removeEventListener("mouseup",this._f354,false);
this.parent._f219.removeEventListener("mousemove",this.mouse_move,false);
}
if(_f327._f339)
{
_f327._f339.setVisible(false);
var x88=_f327._f339.getContainerDiv();
for(var x89=0;x89<x88.childNodes.length;x89++)
{
if(x88.childNodes[x89].tagName=="IMG")
{
x88.childNodes[x89].style.visibility="hidden";
}
}
}
if(this.getStatus()==1||x86)
MVUtil.runListeners(_f327._f97,MVEvent.CLEAR);
this.state=0;
this.parent._f176=false;
this._f330=new Array();
this._f331=new Array();
this._f318=new Array();
}
this.setMarkerImage=function(x90,x91,x92)
{
this._f321=x90;
this._f322=x91;
this._f323=x92;
}
this.getPolygon=function()
{
var x93=this._f318.length;
if(x93>=6&&this._f318[0]==this._f318[x93-2]&&this._f318[1]==this._f318[x93-1])
{
var x94=MVSdoGeometry.createPolygon(this._f318,this.parent.srid);
return x94;
}
else
 return null;
}
this.getSdoGeometry=function()
{
var x95=this._f318.length;
var x96=null;
if(x95>=6&&this._f318[0]==this._f318[x95-2]&&this._f318[1]==this._f318[x95-1])
x96=MVSdoGeometry.createPolygon(this._f318,this.parent.srid);
else if(x95>=4)
x96=MVSdoGeometry.createLineString(this._f318,this.parent.srid);
else if(x95==2)
x96=MVSdoGeometry.createPoint(this._f318,this.parent.srid);
return x96;
}
this.getPolygonFOI=function()
{
if(this.gtype==3)
return this.parent.getFOI("-RL2RL"+this.id);
else
 return null;
}
this.getFOI=function()
{
return this.parent.getFOI("-RL2RL"+this.id);
}
this.getOrdinates=function()
{
return this._f318;
}
this.addEventListener=function(x97,x98)
{
this.setEventListener(x97,x98);
}
this.setEventListener=function(x99,x100)
{
if(x99==MVEvent.NEW_SHAPE_POINT||x99==MVEvent.MOUSE_CLICK)
this._f328=x100;
else if(x99=="on_finish"||x99==MVEvent.FINISH)
this._f329=x100;
else if(x99==MVEvent.MODIFY)
this._f336=x100;
}
this.attachEventListener=function(x101,x102)
{
MVUtil.attachEventListener(_f327._f97,x101,x102)
}
this.detachEventListener=function(x103,x104)
{
MVUtil.detachEventListener(_f327._f97,x103,x104);
}
}
MVRedlineTool.prototype.setAutoClose=function(x0)
{
this._f324=x0;
}
MVRedlineTool.prototype.setEditingMode=function(x1)
{
if(!x1)
this.editingMode={deletePoint:false,dragPoint:false,deleteLine:false,dragLine:false};
else
 this.editingMode=x1;
}
MVRedlineTool.prototype.getEditingMode=function()
{
return this.editingMode;
}
MVRedlineTool.prototype.setGeneratePolygonTop=function(x2)
{
this._f337=x2;
}
MVRedlineTool.prototype.setFillArea=function(x3)
{
this._f325=x3;
}
MVRedlineTool.prototype.getPointNumber=function()
{
return this._f330.length;
}
MVRedlineTool.prototype.getPointFOIs=function()
{
return this._f330;
}
MVRedlineTool.prototype.getLineFOIs=function()
{
return this._f331;
}
MVRedlineTool.prototype.setRenderingStyle=function(x4,x5)
{
if(x5&&!(typeof(x5)=="string"||(typeof(x5)=="object"
&&x5.getXMLString!=null)))
{
MVi18n._f6("MVRedlineTool.setRenderingStyle","MAPVIEWER-05519","objStyle");
}
else
 {
switch(x4)
{
case MVRedlineTool.STYLE_POINT:
if(!x5)
{
var x6=new MVStyleMarker(_f10._f356,"vector");
x6.setStrokeColor("000000");
x6.setStrokeWidth(1.5);
x6.setFillColor("ff5555");
x6.setVectorShape("c:30");
this._f311=x6;
}
else
 this._f311=x5;
break;
case MVRedlineTool.STYLE_LINE:
if(!x5)
{
var x7='<svg width="1in" height="1in"><desc/><g class="line" style="stroke-width:1.0">'+
'<line class="base" style="fill:#000066;stroke-width:1.0" dash="5.0,3.0"/></g></svg>';
var x8=new MVXMLStyle(_f10._f359,x7);
this._f312=x8;}
else
 this._f312=x5;
break;
case MVRedlineTool.STYLE_AREA:
if(!x5)
{
var x8=new MVStyleColor(_f10._f360,"FF0000","FF0000");
x8.setFillOpacity(100);
this._f313=x8;
}
else
 this._f313=x5;
break;
}
}
}
MVRedlineTool.prototype._f361=function(x9)
{
var x10=this._f330.length;
var x11=null;
var x12=null;
if(x9!=null)
{
if(isNaN(x9))
{
var x13=0;
for(;x13<x10;++x13)
{
if(this._f330[x13]==x9)
{
x11=x9;
x12=x13;
break;
}
}
}
else if(x9<x10&&x9>=0)
{
x11=this._f330[x9];
x12=x9;
}
else if(x9==x10)
{
x12=x9;
}
}
return [x11,x12];
}
MVRedlineTool.prototype._f348=function(x14)
{
var x15=this._f331.length;
var x16=null;
var x17=-1;
if(x14!=null)
{
if(isNaN(x14))
{
var x18=0;
for(;x18<x15;++x18)
{
if(this._f331[x18]==x14)
{
x16=x14;
x17=x18;
break;
}
}
}
else if(x14<x15&&x14>=0)
{
x16=this._f330[x14];
x17=x14;
}
}
return [x16,x17];
}
MVRedlineTool.prototype.removeVertex=function(x19)
{
var x20=this._f361(x19);
if(!x20||!x20[0])
return;
var x21=x20[0];
var x22=x20[1];
var x23=this._f330.length;
this._f330.splice(x22,1);
var x24=(x22*2);
this._f318.splice(x24,2);
this.parent.removeFOI(x21);
var x25=x22>0?true:false;
var x26=(x22<(x23-1))?true:false;
var x27=null;
if(x25&&x26)
{
x27=this._f331[x22-1];
if(!this.parent.wraparound)
{
x27.updateGeometry(MVSdoGeometry.createLineString(this._f318.slice((x24-2),(x24+2)),
(this.parent.srid)));
}
x27=this._f331[x22];
this.parent.removeFOI(x27);
this._f331.splice(x22,1);
}
else if(x25)
{
x27=this._f331[x22-1];
this.parent.removeFOI(x27);
this._f331.splice((x22-1),1);
}
else if(x26)
{
x27=this._f331[x22];
this.parent.removeFOI(x27);
this._f331.splice(x22,1);
}
if(this.parent.wraparound)
{
this.refreshRedline(true);
}
if(this._f336)
this._f336();
MVUtil.runListeners(this._f97,MVEvent.MODIFY);
}
MVRedlineTool.prototype.removeEdge=function(x28,x29)
{
var x30=this._f348(x28);
if(!x30||!x30[0])
return;
var x31=x30[0];
var x32=x30[1];
if(x29=="left")
this.removeVertex(x32);
else
 this.removeVertex(x32+1);
}
MVRedlineTool.prototype.moveVertex=function(x33,x34,x35)
{
var x36=this._f361(x33);
if(!x36||!x36[0])
return;
var x37=x36[0];
var x38=x36[1];
if(x35>this.parent.msi._f275)
x35=this.parent.msi._f275;
else if(x35<this.parent.msi._f276)
x35=this.parent.msi._f276;
x37.areacode=MVUtil.calAreaCodeFromCenter(this.parent,x34);
x37.updateGeometry(MVSdoGeometry.createPoint(x34,x35,(this.parent.srid)));
var x39=(x38*2);
this._f318[x39]=x34;
this._f318[x39+1]=x35;
var x40=this._f330.length;
var x41=x38>0?true:false;
var x42=(x38<(x40-1))?true:false;
var x43=null;
var x44=this;
this._f335=function()
{
x44.moveToNewEdge(x41,x42,x38,x39,x37,x34,x35);
if(x44._f336)
x44._f336();
MVUtil.runListeners(x44._f97,MVEvent.MODIFY);
};
}
MVRedlineTool.prototype.moveToNewEdge=function(x45,x46,x47,x48,x49,x50,x51)
{
if(this.parent.wraparound)
{
this.refreshRedline(true);
}
else
 {
if(x45)
{
var x52=this._f331[x47-1];
x52.updateGeometry(MVSdoGeometry.createLineString(this._f318.slice((x48-2),(x48+2)),
(this.parent.srid)));
}
if(x46)
{
var x52=this._f331[x47];
x52.updateGeometry(MVSdoGeometry.createLineString(this._f318.slice(x48,(x48+4)),
(this.parent.srid)));
}
}
}
MVRedlineTool.prototype.moveEdge=function(x53,x54,x55)
{
var x56=this._f348(x53);
if(!x56||!x56[0])
return;
var x57=x56[0];
var x58=x56[1];
var x59=(x58*2);
this._f318[x59]=this._f318[x59]+x54;
this._f318[x59+1]=this._f318[x59+1]+x55;
if(this._f318[x59+1]>this.parent.msi._f275)
this._f318[x59+1]=this.parent.msi._f275;
else if(this._f318[x59+1]<this.parent.msi._f276)
this._f318[x59+1]=this.parent.msi._f276;
this._f318[x59+2]=this._f318[x59+2]+x54;
this._f318[x59+3]=this._f318[x59+3]+x55;
if(this._f318[x59+3]>this.parent.msi._f275)
this._f318[x59+3]=this.parent.msi._f275;
else if(this._f318[x59+3]<this.parent.msi._f276)
this._f318[x59+3]=this.parent.msi._f276;
var x60=x57.node;
if(_f10._f362==2)
{
if(!(x53.mouseDownX))
{
x53.mouseDownX=x60.style.pixelLeft;
x53.mouseDownY=x60.style.pixelTop;
}
x60.style.pixelLeft=x53.mouseDownX+this.pointdx;
x60.style.pixelTop=x53.mouseDownY+this.pointdy;
}
else
 {
if(!(x53.mouseDownX))
{
x53.mouseDownX=MVUtil._f83(x60);
x53.mouseDownY=MVUtil._f84(x60);
}
x60.style.left=(x53.mouseDownX+this.pointdx)+'px';
x60.style.top=(x53.mouseDownY+this.pointdy)+'px';
}
var x61=this._f330.length;
var x62=x58>0?true:false;
var x63=(x58<(x61-2))?true:false;
var x64=null;
var x65=this;
this._f335=function()
{
x65.moveToNewEdge2(x62,x63,x58,x59,x57);
if(x65._f336)
x65._f336();
MVUtil.runListeners(x65._f97,MVEvent.MODIFY);
};
}
MVRedlineTool.prototype.moveToNewEdge2=function(x66,x67,x68,x69,x70){
this._f330[x68].areacode=MVUtil.calAreaCodeFromCenter(this.parent,this._f318[x69]);
this._f330[x68+1].areacode=MVUtil.calAreaCodeFromCenter(this.parent,this._f318[x69+2]);
this._f330[x68].updateGeometry(MVSdoGeometry.createPoint(this._f318[x69],this._f318[x69+1],
(this.parent.srid)));
this._f330[x68+1].updateGeometry(MVSdoGeometry.createPoint(this._f318[x69+2],this._f318[x69+3],
(this.parent.srid)));
if(this.parent.wraparound)
{
this.refreshRedline(true);
}
else
 {
x70.updateGeometry(MVSdoGeometry.createLineString(this._f318.slice(x69,(x69+4)),
(this.parent.srid)));
if(x66)
{
var x71=this._f331[x68-1];
x71.updateGeometry(MVSdoGeometry.createLineString(this._f318.slice((x69-2),(x69+2)),
(this.parent.srid)));
}
if(x67)
{
var x71=this._f331[x68+1];
x71.updateGeometry(MVSdoGeometry.createLineString(this._f318.slice(x69+2,(x69+6)),
(this.parent.srid)));
}
}
x70.mouseDownX=null;
x70.mouseDownY=null;
}
MVRedlineTool.prototype.addVertex=function(x72,x73,x74)
{
var x75=this._f361(x72);
if(!x75||!x75[1])
return;
var x76=x75[0];
var x77=x75[1];
if(x77==0)
return ;
var x78=this._f330.length;
var x79=null;
var x80="-RL8RL"+this.id+"_"+(++this._f309);
if(this._f321)
x79=new MVFOI(x80,MVSdoGeometry.createPoint(x73,x74,this.parent.srid),
"",this._f321,this._f322,this._f323);
else
 x79=new MVFOI(x80,MVSdoGeometry.createPoint(x73,x74,this.parent.srid),
this._f311);
x79.enableInfoTip(false);
x79._f286=true;
x79.enableInfoWindow(false);
x79.objType4RedLineTool=-1;
x79.setEventListener(MVEvent.MOUSE_RIGHT_CLICK,this._f341);
x79.setEventListener(MVEvent.MOUSE_OVER,this._f346);
x79.setEventListener(MVEvent.MOUSE_OUT,this._f347);
x79.setMouseCursorStyle("pointer");
x79.setBringToTopOnMouseOver(false);
x79.setTopFlag(true);
x79.areacode=MVUtil.calAreaCodeFromCenter(this.parent,x73);
this._f330.splice(x77,0,x79);
var x81=x77*2;
this._f318.splice(x81,0,x73,x74);
this.parent.addFOI(x79);
var x82=x77<x78?true:false;
var x83=null;
if(x82)
{
x83=this._f331[x77-1];
x83.updateGeometry(MVSdoGeometry.createLineString(this._f318.slice((x81-2),(x81+2)),
(this.parent.srid)));
x83=new MVFOI(("-RL6RL"+this.id+"_"+(++this._f310)),
MVSdoGeometry.createLineString(this._f318.slice(x81,(x81+4)),
(this.parent.srid)),this._f312,this._f3);
x83.enableInfoTip(false);
x83.enableInfoWindow(false);
x83.objType4RedLineTool=-2;
x83.setEventListener(MVEvent.MOUSE_RIGHT_CLICK,this._f341);
x83.setEventListener(MVEvent.MOUSE_OVER,this._f346);
x83.setEventListener(MVEvent.MOUSE_OUT,this._f347);
x83.setMouseCursorStyle("pointer");
x83.setBringToTopOnMouseOver(false);
x83.areacode=this._f330[x77].areacode;
this.parent.addFOI(x83);
this._f331.splice(x77,0,x83);
}
else
 {
x83=new MVFOI(("-RL6RL"+this.id+"_"+(++this._f310)),
MVSdoGeometry.createLineString(this._f318.slice(x81-2,(x81+2)),
(this.parent.srid)),this._f312,this._f3);
x83.enableInfoTip(false);
x83.enableInfoWindow(false);
x83.objType4RedLineTool=-2;
x83.setEventListener(MVEvent.MOUSE_RIGHT_CLICK,this._f341);
x83.setEventListener(MVEvent.MOUSE_OVER,this._f346);
x83.setEventListener(MVEvent.MOUSE_OUT,this._f347);
x83.setMouseCursorStyle("pointer");
x83.setBringToTopOnMouseOver(false);
x83.areacode=this._f330[x77].areacode;
this.parent.addFOI(x83);
this._f331.push(x83);
}
}
MVRedlineTool.STYLE_POINT="point";
MVRedlineTool.STYLE_LINE="line";
MVRedlineTool.STYLE_AREA="area";
function MVRectangleTool(rectStyle,_f470)
{
this.parent=null;
this._f618=document.createElement("div");
this.innerRectangleDiv=null;
this._f618.style.position="absolute";
this._f618.style.zIndex=5000;
this._f618.style.border="#FF0000 2px dashed";
this._f618.style.visibility="hidden";
this._f473=2;
this._f470=_f470;
this._f313=rectStyle;
this._f474=0;
this._f475=0;
this._f476=0;
this._f477=0;
this._f478=0;
this._f479=0;
this._f97=new Array();
this._f480=null;
this._f329=null;
this._f481=null;
this.mouseupHandler=null;
this._f358=null;
var _f553=eval(_f10._f553);
++_f553;
_f10._f553=_f553;
this.id=_f553;
this._f485=0;
this._f69="NS";
var rt=this;
this._f486=function(x0)
{
x0=(x0)?x0:((window.event)?event:null);
if(rt.parent._f487)
MVUtil._f174(x0);
};
this._f488=function()
{
if(this.netscape==null)
{
if(_f10._f489("netscape"))
this.netscape=true;
else
 this.netscape=false;
}
if(this.netscape)
{
window.addEventListener("keypress",this._f486,false);
}
}
this._f490=function()
{
if(this.netscape==null)
{
if(_f10._f489("netscape"))
this.netscape=true;
else
 this.netscape=false;
}
if(this.netscape)
window.removeEventListener("keypress",this._f486,false);
}
this.refreshRetangle=function()
{
var x1=rt.parent;
if(x1.wraparound)
{
if(rt.getStatus()==3)
{
var x2=rt.getRectangleFOI();
if(x2)
{
x2.areacode=rt.parent._f250.centerArea;
}
}
}
}
}
MVRectangleTool.prototype.setDivBorderStyle=function(x0,x1,x2)
{
var x3="#FF0000";
if(x0&&x0!="")
{
x3=x0;
}
var x4="1px";
if(x1)
{
x4=x1+"px";
this._f473=x1;
}
var x5="dashed";
if(x2!="")
x5=x2;
this._f618.style.border=x3+" "+x4+" "+x5;
}
MVRectangleTool.prototype.setDivFillColor=function(x6,x7)
{
if(!this.innerRectangleDiv)
{
this.innerRectangleDiv=document.createElement("div");
this.innerRectangleDiv.style.width="100%";
this.innerRectangleDiv.style.height="100%";
this._f618.appendChild(this.innerRectangleDiv);
}
if(x6&&x6!="")
{
if(this.innerRectangleDiv.style.setAttribute)
this.innerRectangleDiv.style.cssText+=";background-color:"+x6;
else
 this.innerRectangleDiv.style.backgroundColor=x6;
}
if(isNaN(x7)||x7<0||x7>1)
{
MVi18n._f6("MVRectangleTool.setDivFillColor","MAPVIEWER-05519","opacity");
return ;
}
else
 {
if(window.ActiveXObject)
{
this.innerRectangleDiv.style.filter="alpha(opacity="+(x7*100)+")";
}
else
 {
this.innerRectangleDiv.style.opacity=x7;
}
}
}
MVRectangleTool.prototype.setAreaStyle=function(x8)
{
this._f313=x8;
}
MVRectangleTool.prototype._f491=function()
{
this._f474=this.parent._f352();
this._f475=this.parent._f353();
}
MVRectangleTool.prototype._f492=function()
{
this._f476=this.parent._f352();
this._f477=this.parent._f353();
var x9=Math.abs(this._f476-this._f474);
var x10=this.parent.msi._f158-this.parent.msi._f159;
if(x9>x10)
{
if(this._f474<this._f476)
this._f476=this._f474+x10;
else
 this._f476=this._f474-x10;
}
}
MVRectangleTool.prototype._f619=function()
{
this._f618.style.width="0px";
this._f618.style.height="0px";
this._f618.style.clip="rect(0px, 0px, 0px, 0px)";
this._f618.style.visibility="hidden";
}
MVRectangleTool.prototype._f620=function()
{
if(this._f485!=3)
{
return;
}
var x11=(this._f474-this.parent._f226())*this.parent._f75+
(this.parent._f108()/2);
var x12=(this._f475-this.parent._f227())*(-this.parent._f77)+
(this.parent._f109()/2);
var x13=(this._f476-this.parent._f226())*this.parent._f75+
(this.parent._f108()/2);
var x14=(this._f477-this.parent._f227())*(-this.parent._f77)+
(this.parent._f109()/2);
var x15=Math.abs(x11-x13);
var x16=Math.abs(x12-x14);
x15=Math.round(x15);
x16=Math.round(x16);
var x17=(x11<x13?x11:x13);
var x18=(x12<x14?x12:x14);
x17=Math.round(x17);
x18=Math.round(x18);
this._f618.style.left=x17-1-MVUtil._f83(this.parent.div)+'px';
this._f618.style.top=x18-1-MVUtil._f84(this.parent.div)+'px';
if(x15>0)
x15++;
if(x16>0)
x16++;
if(this._f69=="NS")
{
if(x15==0)
x15=(2*this._f473);
if(x16==0)
x16=(2*this._f473);
this._f618.style.width=Math.abs(x15-(2*this._f473))+'px';
this._f618.style.height=Math.abs(x16-(2*this._f473))+'px';
this._f618.style.clip="rect(0px, "+(x15)+"px, "+
(x16)+"px, 0px)";
}
else
 {
this._f618.style.width=x15+'px';
this._f618.style.height=x16+'px';
this._f618.style.clip="rect(0px, "+(x15+(2*this._f473))+"px, "+
(x16+(2*this._f473))+"px, 0px)";
}
this._f618.style.visibility="visible";
}
MVRectangleTool.prototype.generateArea=function()
{
if(this._f485!=3)
return;
this.parent.removeFOI("MVRectangleTool"+this.id);
if(!this._f313)
return;
this._f619();
if(this._f474!=this._f476&&this._f475!=this._f477)
{
this.getRectangle();
var x19=new MVFOI("MVRectangleTool"+this.id,this._f358,this._f313,this._f470);
x19.areacode=MVUtil.calAreaCodeFromCenter(this.parent,this._f474<this._f476?this._f474:this._f476);
x19.setClickable(false);
x19.enableInfoTip(false);
this.parent.addFOI(x19);
}
else
 this._f358=null;
}
MVRectangleTool.prototype.init=function()
{
this.clear();
this._f485=1;
MVUtil._f621(this._f618);
var x20=this.parent;
var x21=x20._f219;
var x22=this;
this._f474=this._f475=this._f476=this._f477=0;
var x23;
this._f69=this.parent.getBrowserType();
var x24=function()
{
x20._f487=true;
var x25=x20._f226();
var x26=x20._f227();
if((x22._f478)!=x25||(x22._f479)!=x26)
{
if(x22._f485==2)
{
x22._f485=3;
}
x22._f476+=(x25-x22._f478);
x22._f477+=(x26-x22._f479);
x22._f478=x25;
x22._f479=x26;
x22._f620();
}
}
x21.onmousedown=MVUtil._f105(x21,function(x27)
{
x20.removeFOI("MVRectangleTool"+x22.id);
x22._f485=2;
x27=(x27)?x27:((window.event)?event:null);
var x28=x20._f224(x27);
x20.mouseDownLoc=x28;
x20._f496(x27);
x22._f491();
x22._f492();
x22._f618.style.visibility="hidden";
if(x22._f480!=null)
(x22._f480)();
MVUtil.runListeners(x22._f97,MVEvent.START);
x22._f478=x20._f226();
x22._f479=x20._f227();
var x29=5;
x23=setInterval(x24,x29);
x22._f488();
return false;
});
x21.onmousemove=MVUtil._f105(x21,function(x30)
{
if(x22._f485==2)
x22._f485=3;
if(x22._f485==3)
{
x30=(x30)?x30:((window.event)?event:null);
x20._f496(x30);
x22._f492();
x22._f620();
if(x22._f481)
x22._f481();
MVUtil.runListeners(x22._f97,MVEvent.DRAG);
}
return false;
});
var x31=MVUtil._f105(x21,function(x32)
{
if(x22._f485==0||x22._f485==1)
return false;
x32=(x32)?x32:((window.event)?event:null);
var x33=x20._f224(x32);
x20.mouseUpLoc=x33;
x20._f496(x32);
x22._f492();
x22.generateArea();
clearInterval(x23);
if(_f10._f69=="IF")
{
x21.detachEvent("onmouseup",x31);
}
else
 {
x21.removeEventListener("mouseup",x31,true);
}
x20._f355();
x22._f490();
if(x22._f329){
(x22._f329)();
}
MVUtil.runListeners(x22._f97,MVEvent.FINISH);
return false;
});
if(_f10._f69=="IF")
{
if(this.mouseupHandler)
x21.detachEvent("onmouseup",this.mouseupHandler);
x21.attachEvent("onmouseup",x31);
}
else
 {
if(this.mouseupHandler)
x21.removeEventListener("mouseup",this.mouseupHandler,true);
x21.addEventListener("mouseup",x31,true);
}
this.mouseupHandler=x31;
x21.onmouseout=MVUtil._f105(x21,function(x34)
{
if(x22._f485!=3)
return false;
if(x22._f69=="NS"||x22._f69=="OS")
{
x34=(x34)?x34:((window.event)?event:null);
var x35=x34.clientX;
var x36=x34.clientY;
var x37=x20._f108();
var x38=x20._f109();
var x39=MVUtil._f497(this);
var x40=x34.pageX-x39.x;
var x41=x34.pageY-x39.y;
if(x40<=0||x40>=x37||
x41<=0||x41>=x38||
x35<=0||x35>=document.body.clientWidth||
x36<=0||x36>=document.body.clientHeight)
{
return this.onmouseup(x34);
}
}
});
this.parent._f250.attachEventListener("refreshFOI",this.refreshRetangle);
}
MVRectangleTool.prototype.clear=function()
{
this._f619();
this.parent.removeFOI("MVRectangleTool"+this.id);
this._f485=0;
this.parent._f355();
}
MVRectangleTool.prototype.getRectangle=function()
{
if(this._f474!=this._f476&&this._f475!=this._f477)
{
var x42=this.parent.msi._f158-this.parent.msi._f159;
if((this._f476-this._f474)<x42/2)
{
this._f358=MVSdoGeometry.createRectangle(
this._f474,this._f475,this._f476,this._f477,this.parent.srid);
return this._f358;
}
else
 {
var x43=this._f474;
var x44=this._f475;
var x45=this._f476;
var x46=this._f477;
var x47=(x45-x43)/3;
var x48=(x45-x43)/3*2;
var x49=[x43,x44,x43,x46,x43+x47,x46,x43+x48,x46,x45,x46,x45,x44,x43+x48,x44,x43+x47,x44];
this._f358=MVSdoGeometry.createPolygon(x49,this.parent.srid);
return this._f358;
}
}
else
 return null;
}
MVRectangleTool.prototype.getRectangleFOI=function()
{
return this.parent.getFOI("MVRectangleTool"+this.id);
}
MVRectangleTool.prototype.getRectangleDIV=function()
{
return this._f618;
}
MVRectangleTool.prototype.addEventListener=function(x50,x51)
{
this.setEventListener(x50,x51);
}
MVRectangleTool.prototype.setEventListener=function(x52,x53)
{
if(x52=="on_start"||x52==MVEvent.START)
this._f480=x53;
else if(x52=="on_finish"||x52==MVEvent.FINISH)
this._f329=x53;
else if(x52=="on_drag"||x52==MVEvent.DRAG)
this._f481=x53;
}
MVRectangleTool.prototype.attachEventListener=function(x54,x55)
{
MVUtil.attachEventListener(this._f97,x54,x55)
}
MVRectangleTool.prototype.detachEventListener=function(x56,x57)
{
MVUtil.detachEventListener(this._f97,x56,x57);
}
MVRectangleTool.prototype.getStatus=function()
{
return this._f485;
}
MVRectangleTool.prototype.getWidth=function(x58)
{
if(!x58)
{
return Math.abs(this._f474-this._f476);
}
else
 {
return MVSdoGeometry.getDistance(this._f474,this._f475,
MVUtil.transLongitudeOnWarpAroungMap(this.parent,this._f474,this._f476),
this._f475,this.parent.srid,x58);
}
}
MVRectangleTool.prototype.getHeight=function(x59)
{
var x60=this._f475;
var x61=this._f477
if(x60>this.parent.msi._f275)
x60=this.parent.msi._f275;
else if(x60<this.parent.msi._f276)
x60=this.parent.msi._f276;
if(x61>this.parent.msi._f275)
x61=this.parent.msi._f275
else if(x61<this.parent.msi._f276)
x61=this.parent.msi._f276
if(!x59)
return Math.abs(x60-x61);
else
 return MVSdoGeometry.getDistance(this._f474,x60,this._f474,x61,this.parent.srid,x59);
}
MVRectangleTool.prototype.setDivStyle=function(x62)
{
var x63="#FF0000";
var x64=2;
var x65="dashed";
var x66="#555555";
var x67=0.3;
if(x62.borderColor!=undefined)
x63=x62.borderColor;
if(x62.borderWidth!=undefined)
x64=x62.borderWidth;
if(x62.borderDashed!=undefined)
{
if(!x62.borderDashed)
x65="solid";
}
if(x62.fillColor!=undefined)
x66=x62.fillColor;
if(x62.fillOpacity!=undefined)
x67=x62.fillOpacity;
this.setDivFillColor(x66,x67);
this.setDivBorderStyle(x63,x64,x65);
}
function MVCircleTool(circleStyle,_f470)
{
this.parent=null;
this._f471=document.createElement("div");
this._f471.style.position="absolute";
this._f471.style.visibility="hidden";
this._f471.style.zIndex=5000;
this._f472=new Object();
this._f472._f473=2;
this._f472.divHeight=2;
this._f472.zIndex=5001;
this._f472.backgroundColor="#FF0000";
this._f472.opacity=null;
this._f470=_f470;
this._f313=circleStyle;
this._f474=0;
this._f475=0;
this._f476=0;
this._f477=0;
this.stepPx=6;
this._f478=0;
this._f479=0;
this._f97=new Array();
this._f480=null;
this._f329=null;
this._f481=null;
this._f482=null;
this._f358=null;
var _f483=eval(_f10._f483);
_f10._f483=(++_f483);
this.id=_f483;
this._f484="MVCircleTool";
this._f485=0;
this.refresh=false;
var ct=this;
this._f486=function(x0)
{
x0=(x0)?x0:((window.event)?event:null);
if(ct.parent._f487)
MVUtil._f174(x0);
};
this._f488=function()
{
if(this.netscape==null)
{
if(_f10._f489("netscape"))
this.netscape=true;
else
 this.netscape=false;
}
if(this.netscape)
{
window.addEventListener("keypress",this._f486,false);
}
}
this._f490=function()
{
if(this.netscape==null)
{
if(_f10._f489("netscape"))
this.netscape=true;
else
 this.netscape=false;
}
if(this.netscape)
window.removeEventListener("keypress",this._f486,false);
}
this.refreshCircle=function()
{
var x1=ct.parent;
if(x1.wraparound)
{
if(ct.getStatus()==3)
{
var x2=ct.getCircleFOI();
if(x2)
{
x2.areacode=ct.parent._f250.centerArea;
}
}
}
}
}
MVCircleTool.prototype.setPlotDivSize=function(x0,x1)
{
if(x0!=null)
{
if(isNaN(x0))
{
MVi18n._f6("MVCircleTool.setPlotDivSize","MAPVIEWER-05519","width");
}
else
 {
x0=Math.round(x0);
this._f472._f473=x0;
}
}
if(x1!=null)
{
if(isNaN(x1))
{
MVi18n._f6("MVCircleTool.setPlotDivSize","MAPVIEWER-05519","height");
}
else
 {
x1=Math.round(x1);
this._f472.divHeight=x1;
}
}
}
MVCircleTool.prototype.setPlotDivFillColor=function(x2,x3)
{
if(x2!=null&&x2!="")
this._f472.backgroundColor=x2;
if(isNaN(x3)||x3<0||x3>1)
{
MVi18n._f6("MVCircleTool.setPlotDivFillColor","MAPVIEWER-05519","opacity");
}
else
 {
this._f472.opacity=x3;
}
}
MVCircleTool.prototype.setPlotDivZindex=function(x4)
{
if(x4!=null)
{
if(isNaN(x4))
{
MVi18n._f6("MVCircleTool.setPlotDivZindex","MAPVIEWER-05519","zindex");
}
else
 {
this._f472.zIndex=x4;
this._f471.style.zIndex=(x4-1);
}
}
}
MVCircleTool.prototype._f491=function()
{
this._f474=this.parent._f352();
this._f475=this.parent._f353();
}
MVCircleTool.prototype._f492=function()
{
this._f476=this.parent._f352();
this._f477=this.parent._f353();
}
MVCircleTool.prototype._f493=function()
{
if(this._f485!=3)
{
return;
}
var x5=this.parent._f75;
var x6=this.parent._f77;
var x7=Math.round((this._f474-this.parent._f226())*x5+(this.parent._f108()/2));
var x8=Math.round((this._f475-this.parent._f227())*(-x6)+(this.parent._f109()/2));
var x9=(this._f476-this._f474)*x5;
var x10=(this._f477-this._f475)*(-x6);
var x11=Math.round(Math.sqrt(x9*x9+x10*x10));
var x12=Math.floor(x5*(this.parent.msi._f158-this.parent.msi._f159)/2);
if(x11>x12)
{
x11=x12;
this._f482=Math.floor((this.parent.msi._f158-this.parent.msi._f159)/2);
}
else
 this._f482=x11/x5;
var x13=2*(x11+this._f472._f473);
var x14=2*(x11+this._f472.divHeight);
var x15=x7-x11-Math.round((this._f472._f473)/2);
var x16=x8-x11-Math.round((this._f472.divHeight)/2);
this._f471.style.left=x15+'px';
this._f471.style.top=x16+'px';
this._f471.style.width=x13+'px';
this._f471.style.height=x14+'px';
this._f471.style.clip="rect(0px, "+x14+"px, "+x13+"px, 0px)";
this._f471.style.visibility="visible";
var x17=(this._f484+this.id+"PlotsDiv");
var x18=document.getElementById(x17);
if(x18!=null)
this._f471.removeChild(x18);
x18=document.createElement("div");
x18.id=x17;
x18.style.position="absolute";
x18.style.left=0+'px';
x18.style.top=0+'px';
this._f471.appendChild(x18);
var x19=(this.stepPx)/x11;
x19=x19>1?1:x19;
var x20=Math.acos(x19);
var x21=Math.asin(x19);
var x22=x20<x21?x20:x21;
var x23=50;
if(x22==0)
x22=Math.PI/(2*x23);
var x24=Math.ceil(Math.PI/(2*x22));
for(var x25=0;x25<x24;++x25)
{
var x26=x25*x22;
x9=Math.round(x11*Math.cos(x26));
x10=Math.round(x11*Math.sin(x26));
this._f494((x11+x9),(x11+x10));
this._f494((x11+x9),(x11-x10));
this._f494((x11-x9),(x11+x10));
this._f494((x11-x9),(x11-x10));
}
}
MVCircleTool.prototype._f494=function(x27,x28)
{
var x29=(this._f484+this.id+"PlotsDiv");
var x30=document.getElementById(x29);
if(x30==null)
{
MVi18n._f6("MVCircleTool.plotPos","MAPVIEWER-05500","null plodsDiv found");
return;
}
var x31=document.createElement("DIV");
x31.style.position="absolute";
x31.style.zIndex=this._f472.zIndex;
if(this._f472.backgroundColor!=null)
x31.style.backgroundColor=this._f472.backgroundColor;
if((this._f472.opacity)!=null)
{
if(window.ActiveXObject)
{
x31.style.filter="alpha(opacity="+((this._f472.opacity)*100)+")";
}
else
 {
x31.style.opacity=this._f472.opacity;
}
}
x31.style.left=x27+"px";
x31.style.top=x28+"px";
x31.style.width=(this._f472._f473)+"px";
x31.style.height=(this._f472.divHeight)+"px";
x31.style.clip="rect(0px, "+(this._f472._f473)+"px, "+
(this._f472.divHeight)+"px, 0px)";
x30.appendChild(x31);
}
MVCircleTool.prototype.generateArea=function()
{
if(this._f485!=3)
{
return;
}
var x32=this._f484+this.id;
this.parent.removeFOI(x32);
var x33=this._f482;
this._f358=MVSdoGeometry.createCirclePolygon(this._f474,this._f475,x33,this.parent.srid);
if(!(this._f313))
return;
var x34=new MVFOI(x32,this._f358,this._f313,this._f470);
var x35=this._f474-x33;
x34.areacode=MVUtil.calAreaCodeFromCenter(this.parent,x35);
x34.setClickable(false);
x34.enableInfoTip(false);
this.parent.addFOI(x34);
}
MVCircleTool.prototype.init=function()
{
this.clear();
this._f485=1;
var x36=this.parent;
var x37=x36._f219;
var x38=this;
var x39;
var x40=function()
{
x36._f487=true;
var x41=x36._f226();
var x42=x36._f227();
if((x38._f478)!=x41||(x38._f479)!=x42||(x38.refresh))
{
x38.refresh=false;
if(x38._f485==2)
{
x38._f485=3;
}
x38._f476+=(x41-x38._f478);
x38._f477+=(x42-x38._f479);
x38._f478=x41;
x38._f479=x42;
x38._f493();
}
}
x37.onmousedown=MVUtil._f105(x37,function(x43)
{
x36.removeFOI(x38._f484+x38.id);
x38._f485=2;
x43=(x43)?x43:((window.event)?event:null);
x36._f496(x43);
x38._f491();
x38._f492();
x38._f471.style.visibility="hidden";
if(x38._f480!=null)
(x38._f480)();
MVUtil.runListeners(x38._f97,MVEvent.START);
x38._f478=x36._f226();
x38._f479=x36._f227();
var x44=5;
x39=setInterval(x40,x44);
x38._f488();
return false;
});
x37.onmousemove=MVUtil._f105(x37,function(x45)
{
if(x38._f485==2)
{
x38._f485=3;
}
if(x38._f485==3)
{
x45=(x45)?x45:((window.event)?event:null);
x36._f496(x45);
x38._f492();
x38.refresh=true;
if(x38._f481)
x38._f481();
MVUtil.runListeners(x38._f97,MVEvent.DRAG);
}
return false;
});
x37.onmouseup=MVUtil._f105(x37,function(x46)
{
x46=(x46)?x46:((window.event)?event:null);
x36._f496(x46);
x38._f492();
x38.generateArea();
var x47=document.getElementById(x38._f484+x38.id+"PlotsDiv");
if(x47!=null)
x38._f471.removeChild(x47);
x38._f471.style.width="0px";
x38._f471.style.height="0px";
x38._f471.style.clip="rect(0px, 0px, 0px, 0px)";
x38._f471.style.visibility="hidden";
clearInterval(x39);
x36._f355();
x38._f490();
if(x38._f329!=null)
(x38._f329)();
MVUtil.runListeners(x38._f97,MVEvent.FINISH);
return false;
});
x37.onmouseout=MVUtil._f105(x37,function(x48)
{
if(x38._f485!=3)
return false;
if(!(window.ActiveXObject))
{
x48=(x48)?x48:((window.event)?event:null);
var x49=x48.clientX;
var x50=x48.clientY;
var x51=x36._f108();
var x52=x36._f109();
var x53=MVUtil._f497(this);
var x54=x48.pageX-x53.x;
var x55=x48.pageY-x53.y;
if(x54<=0||x54>=x51||
x55<=0||x55>=x52||
x49<=0||x49>=document.body.clientWidth||
x50<=0||x50>=document.body.clientHeight)
{
return this.onmouseup(x48);
}
}
});
this.parent._f250.attachEventListener("refreshFOI",this.refreshCircle);
}
MVCircleTool.prototype.clear=function()
{
this.parent.removeFOI(this._f484+this.id);
this._f485=0;
this.parent._f355();
}
MVCircleTool.prototype.getCircle=function()
{
if(this._f485==3&&this._f482)
return MVSdoGeometry.createCircle(this._f474,this._f475,this._f482,this.parent.srid);
else if(this._f358!=null)
return (this._f358);
else
 return null;
}
MVCircleTool.prototype.getCirclePolygon=function()
{
if(this._f485==3&&this._f482)
return MVSdoGeometry.createCirclePolygon(this._f474,this._f475,this._f482,this.parent.srid);
else if(this._f358!=null)
return (this._f358);
else
 return null;
}
MVCircleTool.prototype.getRadius=function(x56)
{
if(!x56)
return this._f482;
else
 return MVSdoGeometry.getDistance(this._f474,this._f475,this._f474,this._f475+this._f482,this.parent.srid,x56);
}
MVCircleTool.prototype.getCenter=function()
{
return MVSdoGeometry.createPoint(this._f474,this._f475,this.parent.srid);
}
MVCircleTool.prototype.getCircleFOI=function()
{
return this.parent.getFOI(this._f484+this.id);
}
MVCircleTool.prototype.addEventListener=function(x57,x58)
{
this.setEventListener(x57,x58);
}
MVCircleTool.prototype.setEventListener=function(x59,x60)
{
if(x59=="on_start"||x59==MVEvent.START)
this._f480=x60;
else if(x59=="on_finish"||x59==MVEvent.FINISH)
this._f329=x60;
else if(x59=="on_drag"||x59==MVEvent.DRAG)
this._f481=x60;
}
MVCircleTool.prototype.attachEventListener=function(x61,x62)
{
MVUtil.attachEventListener(this._f97,x61,x62)
}
MVCircleTool.prototype.detachEventListener=function(x63,x64)
{
MVUtil.detachEventListener(this._f97,x63,x64);
}
MVCircleTool.prototype.getStatus=function()
{
return this._f485;
}
MVCircleTool.prototype.setAreaStyle=function(x65)
{
this._f313=x65;
}
function MVi18n()
{
}
MVi18n._f498=null;
MVi18n._f499=null;
MVi18n._f500=null;
MVi18n.URL=null;
MVi18n.language=null;
MVi18n.country=null;
MVi18n.fetched=false;
MVi18n.timeoutCount=0;
MVi18n.isFetched=function()
{
if(MVi18n.fetched)
return true;
MVi18n.timeoutCount++;
if(MVi18n.timeoutCount>10)
MVi18n.fetched=true;
return MVi18n.fetched;
}
MVi18n._f6=function(x0,x1,x2)
{
if(x2)
x2=" ("+x2+")";
else
 x2="";
MVi18n.alert("["+x0+"] "+MVi18n._f501(x1)+x2);
}
MVi18n._f501=function(x3)
{
if(MVMessages[x3])
return x3+": "+MVMessages[x3];
else
 return x3;
}
MVi18n._f342=function(x4)
{
if(MVMessages[x4])
return MVMessages[x4];
else
 return x4;
}
MVi18n._f502=function()
{
if(MVi18n.URL==null)
return;
var localDomain=(MVUtil._f8(MVi18n.URL)==MVUtil._f8(_f10._f118()));
var xmlHttp=localDomain||MVMapView._f7;
if(MVMapView._f7&&!localDomain)
MVi18n.URL=_f10._f11()+"?rtarget="+MVi18n.URL;
var url=null;
url=encodeURI(MVi18n.URL+"/mcserver");
try
{
var _f279=MVUtil.getXMLHttpRequest(xmlHttp);
_f279.open("POST",url,true);
_f279.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
_f279.onreadystatechange=MVUtil._f105(_f279,function()
{
try
{
if(this.readyState!=4)
return;
if(this.status==200)
text=this.responseText;
MVUtil.gc();
eval(text);
MVi18n.fetched=true;
}
catch(e)
{
MVi18n.fetched=true;
return ;
}
});
var params="request=getinfomsgs";
if(MVi18n.language)
params=params+"&language="+MVi18n.language;
if(MVi18n.country)
params=params+"&country="+MVi18n.country;
_f279.send(encodeURI(params));
}
catch(ex)
{
MVi18n._f6("MVi18n.fetchMessages","MAPVIEWER-05511",ex);
}
}
MVi18n.addBehavior=function(x5,x6,x7)
{
if(x5==null||(x5!="func"&&x5!="eval"))
{
MVi18n.alert("MethodType Error");
return;
}
if(!x6)
{
MVi18n.alert("MethodName Error");
return;
}
if(x7==null||((x7.toLowerCase())!="url"&&(x7.toLowerCase())!="text"))
{
MVi18n.alert("ArgType Error");
return;
}
MVi18n._f498=x5;
MVi18n._f499=x6;
MVi18n._f500=x7;
}
MVi18n.setURL=function(x8)
{
if(x8==null||x8=="")
{
MVi18n.alert("Parameter should not be null or empty. Error occurs in MVi18n.setURL(...)");
return;
}
MVi18n.URL=x8;
}
MVi18n.alert=function(x9)
{
if(MVi18n._f499)
{
var x10=MVi18n._f499;
x10(x9);
}
else
 alert(x9);
}
function MVMapView(x0,x1)
{
if(!x0)
{
MVi18n._f6("MVMapView.constructor","MAPVIEWER-05519","mapDiv");
return ;
}
MVUtil.objArray.push(this);
var x2=this;
if(!MVi18n._f499)
MVi18n.addBehavior("func",alert,"text");
this._f145=MVUtil._f645++;
this.center=null;
this.originalCenter=null;
this.reCenterTag=false;
this._f94=0;
this._f95=0;
this._f75=0;
this._f77=0;
this.tileWidth=0;
this.tileHeight=0;
this._f670=200;
this._f671=200;
this._f672=0;
this._f673=0;
this._f674=1;
this._f675=0;
this._f676=0;
this._f20=0;
this._f677=false;
this._f266=false;
this._f639=0;
this._f640=0;
this._f678=null;
this._f679=null;
this._f680=0.0;
this._f681=0.0;
this._f682=0.0;
this._f683=0.0;
this._f684=0.0;
this._f685=0.0;
this._f74=0.0;
this._f294=0.0;
this._f288=0.0;
this._f76=0.0;
this._f686=false;
this.msi=null;
this._f687=false;
this._f688=true;
this._f178=null;
this._f689=new Array();
this._f690=new Array();
this._f691=null;
this._f135=new Array();
this.mapLayerNumber=0;
this._f692=new Array();
this._f79=null;
this._f250=null;
this._f626=null;
this._f693=2;
this._f694=4;
this._f695=4;
this._f696=null;
this._f298=false;
this._f697=0;
this._f92=false;
this._f698=new Array();
this._f215=null;
this._f216=false;
this._f220=true;
this._f699=null;
this.srid=null;
this._f700=null;
this._f701=0;
this._f702=false;
this._f703="one_time";
this._f704=false;
this._f705=null;
this._f706=false;
this._f707=false;
this._f708=false;
this._f709=false;
this._f710=null;
this._f711=1;
this.centerMarkUrl=null;
this.centerMarkW=0;
this.centerMarkH=0;
this._f97=new Array();
var x3=String(document.location);
var x4=x3.indexOf("//");
this._f9=_f10._f118();
this._f712=this._f9;
this._f4=this._f9;
this._f213="default";
this._f212="move";
this._f713="default";
if(x1)
{
this._f712=x1;
this._f4=x1;
if(MVUtil._f5(x1,'/'))
{
this._f712=x1.substring(0,x1.length-1);
this._f4=x1.substring(0,x1.length-1);
}
if(MVUtil._f8(this._f9)!=MVUtil._f8(this._f712))
{
this._f712=_f10._f11()+"?rtarget="+this._f712;
}
}
_f10._f554=this._f4+"/foi";
_f10._f142=this._f4+_f10._f549;
MVi18n.setURL(this._f4);
if(x0==null)
return null;
MVUtil._f133(x0);
this.real_base_div=x0;
if(this.real_base_div.style.position!="absolute")
{
this.real_base_div.style.position="relative";
}
this._f219=document.createElement("div");
this.real_base_div.appendChild(this._f219);
this._f219.style.position="absolute";
this._f219.style.left=MVUtil._f31(0);
this._f219.style.top=MVUtil._f31(0);
this._f219.style.width="100%";
this._f219.style.height="100%";
MVUtil._f146(this._f219);
MVUtil._f146(this.real_base_div);
this._f219.style.overflow="hidden";
this._f430=document.createElement("img");
this._f430.src=_f10._f142+"transparent."+(_f10._f69=="IF"?"gif":"png");
this._f430.src+="?refresh="+(new Date()).getTime();
this._f430.style.position="absolute";
this._f430.style.left=MVUtil._f31(0);
this._f430.style.top=MVUtil._f31(0);
this._f430.onload=MVUtil._f105(this,function(){_f10._f559=true;});
this._f219.appendChild(this._f430);
this._f291=document.createElement("div");
this._f291.style.position="absolute";
this._f291.style.left=MVUtil._f31(0);
this._f291.style.top=MVUtil._f31(0);
this.real_base_div.appendChild(this._f291);
this.div=null;
var x5=this.getBrowserType();
this.toolBarContainer=null;
this._f714();
MVUtil._f146(this.div);
this._f715="";
this._f300=0;
this._f301=0;
this._f716();
this._f625=null;
this._f81=document.createElement("div");
MVUtil._f146(this._f81);
this._f81.style.position="absolute";
this._f81.style.zIndex=125;
this.div.appendChild(this._f81);
this._f717=null;
this._f718=null;
this._f564=null;
this._f719=null;
this._f720=null;
this._f721=null;
this._f722=new _f723();
this._f724=true;
this.draggingEnabled=true;
this._f725="zoomin";
this._f396=null;
this._f726=true;
this._f727=null;
this._f728=false;
this._f729=null;
this._f730=null;
this._f731=0;
this._f732=0;
this._f733=false;
this._f734=0;
this._f735=null;
this._f736=5;
this._f176=false;
this._f93=new Array();
this.infoTipDiv=null;
this._f172=0;
this._f170=0;
this._f737=null;
this._f738=null;
this._f739=null;
this._f740=null;
this._f741=null;
this._f742=null;
this._f743=null;
this._f744=null;
this._f487=false;
this._f530=null;
this._f67="PNG24";
this.foiBgColor=null;
this.zoomAnimationEnabled=true;
this._f745=false;
this.dragCoords=null;
this.wraparound=false;
this.maptype=null;
this._f746=true;
if(!MVi18n.isFetched())
MVi18n._f502();
return this;
}
MVMapView.prototype._f714=function()
{
if(_f10._f69=="IF"&&document.compatMode&&document.compatMode!="BackCompat")
{
document.body.style.height="100%";
}
if(this._f219.style.backgroundColor=="")
this._f219.style.backgroundColor="lightgrey";
this.div=document.createElement("div");
this.div.style.position="absolute";
if(_f10._f69=="IF"&&document.compatMode&&document.compatMode!="BackCompat")
{
this.div.style.width=MVUtil._f31(this._f108());
this.div.style.height=MVUtil._f31(this._f109());
}
else
 {
this.div.style.width="100%";
this.div.style.height="100%";
}
this.div.style.zIndex=80;
this.div.style.left=MVUtil._f31(0);
this.div.style.top=MVUtil._f31(0);
this._f291.style.left=MVUtil._f31(0);
this._f291.style.top=MVUtil._f31(0);
this._f140=0;
this._f141=0;
this._f417=this._f140;
this._f418=this._f141;
this._f747=0;
this._f748=0;
this._f219.appendChild(this.div);
var x0=document.createElement("table");
x0.style.zIndex=9999;
x0.style.height=MVUtil._f31(15);
x0.style.position="absolute";
x0.style.right=MVUtil._f31(0);
x0.style.bottom=MVUtil._f31(0);
x0.style.backgroundColor="white";
this._f219.appendChild(x0);
var x1=document.createElement("tbody");
x0.appendChild(x1);
this.toolBarContainer=document.createElement("tr");
x1.appendChild(this.toolBarContainer);
}
MVMapView.prototype._f749=function(x2,x3)
{
this._f747=x2-this._f140;
this._f748=x3-this._f141;
}
MVMapView.prototype._f196=function(x4,x5)
{
this.reCenterTag=true;
this._f140=x4-this._f747;
this._f141=x5-this._f748;
this._f417=MVUtil._f83(this.div);
this._f418=MVUtil._f84(this.div);
var x6=this._f750(this._f417,this._f140,this._f418,this._f141);
this._f140=x6.left;
this._f141=x6.top;
var x7=this._f94+(this._f417-this._f140)/this._f75;
var x8=this._f95-(this._f418-this._f141)/this._f77;
this._f751(this._f140-this._f417,this._f141-this._f418,
x7,x8);
var x9=this._f94;
var x10=this._f95;
this._f94=x7;
this._f95=x8;
if(x9!=this._f94||x10!=this._f95)
{
this._f686=true;
}
MVUtil._f73(this.div,this._f140,this._f141);
MVUtil._f73(this._f291,this._f140,this._f141);
}
MVMapView.prototype.addEventListener=function(x11,x12)
{
this.setEventListener(x11,x12);
}
MVMapView.prototype.setEventListener=function(x13,x14)
{
if(x13==MVEvent.RECENTER)
{
this._f719=x14;
}
else if(x13==MVEvent.MOUSE_CLICK)
{
this._f564=x14;
}
else if(x13==MVEvent.MOUSE_RIGHT_CLICK)
{
this._f720=x14;
}
else if(x13==MVEvent.ZOOM_LEVEL_CHANGE)
{
this._f717=x14;
}
else if(x13==MVEvent.BEFORE_ZOOM_LEVEL_CHANGE)
{
this._f718=x14;
}
else if(x13==MVEvent.MOUSE_DOUBLE_CLICK)
{
this._f396=x14;
}
else if(x13==MVEvent.INITIALIZE)
{
this.initializeListener=x14;
}
}
MVMapView.prototype.attachEventListener=function(x15,x16)
{
MVUtil.attachEventListener(this._f97,x15,x16)
}
MVMapView.prototype.detachEventListener=function(x17,x18)
{
MVUtil.detachEventListener(this._f97,x17,x18);
}
MVMapView.prototype.init=function()
{
MVUtil._f73(this.div,0,0);
MVUtil._f73(this._f291,0,0);
if(this._f79._f80.length>0)
this._f79.deleteInfoWindow(this._f79._f80[0]);
this._f140=0;
this._f141=0;
this._f417=this._f140;
this._f418=this._f141;
this._f747=0;
this._f748=0;
this.setZoomLevel(this._f20);
this._f752();
var x19=MVSdoGeometry.createPoint(this._f94,this._f95,this.srid);
x19=this._f753(x19);
this._f94=x19.getPointX();
this._f95=x19.getPointY();
this._f731=this._f108();
this._f732=this._f109();
if(this._f735)
clearTimeout(this._f735);
this.setLoadingIconVisible(true);
this._f639=this._f675+(this._f672/2*this.tileWidth);
this._f640=this._f676+(this._f673/2*this.tileHeight);
this._f754();
if(!this._f92)
{
if(this._f755())
return ;
}
if(this._f626&&!this._f626._f560&&!this._f626._f122)
this._f756(this._f626);
if(this.navigationPanel&&!this.navigationPanel._f122)
this.navigationPanel.init(this._f219,this);
for(var x20=0;x20<this._f135.length;x20++)
{
if(this._f135[x20].layerControl)
this._f135[x20].layerControl._f434(this._f108(),this._f109(),
this._f94,this._f95);
else
 {
this._f504(this._f135[x20],this._f94,this._f95,this._f20);
}
}
if(!this._f79)
this._f79=new _f289(this);
this._f125();
this._f172=this._f74;
this._f170=this._f76;
this.refreshThemeBasedFOIs(true);
this._f281();
this._f79.refresh(this._f74,this._f294,
this._f288,this._f76,
this._f108(),this._f109());
this._f266=true;
this._f677=true;
if(this._f710!=null)
for(var x20=0;x20<this._f710.length;x20++)
if(this._f710[x20]!=null&&!this._f710[x20]._f92)
{
var id="_md_"+this._f711
this._f710[x20].init(id,this,this._f219);
this._f711++;
this._f710[x20]._f92=true;
if(this._f710[x20].afterDisAction)
{
this._f710[x20].afterDisAction();
}
}
if(this._f215!=null&&this._f215._f204==null)
this._f215.init(this._f215._f202,this);
this._f82();
this._f735=this.setTimeout("this.checkSize()",400);
if(!this._f92)
{
this._f92=true;
if(this.initializeListener)
this.initializeListener();
MVUtil.runListeners(this._f97,MVEvent.INITIALIZE);
}
window.status=' ';
}
MVMapView.prototype.destroy=function()
{
while(this._f135&&this._f135.length>0)
{
var x21=this._f135.pop();
x21.destroy();
}
this._f135=null;
if(!this._f79)
{
this._f79.destroy();
this._f79=null;
}
while(this._f692&&this._f692.length>0)
{
var x22=this._f692.pop();
x22.destroy();
}
this._f692=null;
if(this._f250)
this._f250.destroy();
this._f250=null;
if(this._f710)
while(this._f710.length>0)
this._f710.pop();
this._f710=null;
if(this._f215)
{
this._f215.destroy();
this._f215=null;
}
MVUtil._f133(this._f219);
this._f430=null;
this._f219=null;
this._f291=null;
this._f81=null;
this.div=null;
}
MVMapView.prototype._f752=function()
{
this.tileWidth=this._f689[this._f20];
this.tileHeight=this._f690[this._f20];
this._f757();
}
MVMapView.prototype._f757=function()
{
this._f675=-this.tileWidth*this._f674;
this._f676=-this.tileHeight*this._f674;
var x23=this._f108()/this.tileWidth;
this._f672=parseInt(Math.ceil(x23/2)+1)*2+1;
x23=this._f109()/this.tileHeight;
this._f673=parseInt(Math.ceil(x23/2)+1)*2+1;
this._f639=this._f675+(this._f672/2*this.tileWidth);this._f640=this._f676+(this._f673/2*this.tileHeight);var x24=this.msi.mapConfig.zoomLevels[this._f20];
this._f75=x24.tileImageWidth/x24.tileWidth;this._f77=x24.tileImageHeight/x24.tileHeight;}
MVMapView.prototype._f754=function()
{
this._f679=new _f370(this.msi.mapConfig,this._f94,this._f95,this._f20);this._f678=new _f370(this.msi.mapConfig,this._f94,this._f95,this._f20);this._f678._f376(-(Math.ceil(this._f672/2)-1),+Math.ceil(this._f673/2)-1);
}
MVMapView.prototype._f125=function()
{
this._f682=this._f678.minX;
this._f683=(this._f678.minY+this._f678._f372);
this._f684=(this._f678.minX+(this._f678._f371*this._f672));
this._f685=(this._f678.minY-(this._f678._f372*(this._f673-1)));
this._f74=this._f758(this._f94);
this._f294=this._f759(this._f95);
this._f288=this._f760(this._f94);
this._f76=this._f761(this._f95);
}
MVMapView.prototype.display=function()
{
var x25=this;
var x26=function()
{
var x27=0;
if(!x25._f219)
return ;
if(x25._f219.offsetWidth)
x27=parseInt(x25._f219.offsetWidth+"");
else if(typeof(x25._f219.offsetWidth)=="undefined")
x27=x25._f108();
var x28=0;
if(x25._f219.offsetHeight)
x28=parseInt(x25._f219.offsetHeight+"");
else if(typeof(x25._f219.offsetHeight)=="undefined")
x28=x25._f109();
if(!MVi18n.isFetched()||x27<=0||x28<=0||!_f10._f559||!x25.msi)
{
setTimeout(x26,200);
return ;
}
var x29=function()
{
x25.init();
if(!x25._f709)
{
x25._f355();
x25._f709=true;
}
x25._f92=true;
while(x25._f93.length>0)
{
var x30=x25._f93.shift();
if(x30.func=="refreshFOIs")
x30.obj._f78(x30.params[0],x30.params[1],x30.params[2],x30.params[3],x30.params[4],x30.params[5],x30.params[6],x30.params[7],true,x30.params[8]);
else if(x30.func=="zoomToRectangle")
x30.obj.zoomToRectangle(x30.params[0],x30.params[1]);
}
}
x25._f762(x29);
}
x26();
}
MVMapView.prototype.setCenter=function(x31,x32)
{
this.reCenterTag=true;
this.center=x31;
if(this._f92)
this._f762(null,x32);
}
MVMapView.prototype._f762=function(x33,x34)
{
if(!this.center)
{
if(x33)
x33();
return ;
}
if(!this.msi)
{
MVi18n._f6("MVMapView.setCenter","MAPVIEWER-05518");
return ;
}
this.srid=this.msi.getSrid();
var x35=this.center;
if(!this.reCenterTag&&this.originalCenter!=null)
x35=this.originalCenter;
if(x35)
{
if(!x35.srid)
x35.srid=this.srid;
this.center=null;
if(!(x35.sdo_point))
{
MVi18n._f6("MVMapView.setCenter","MAPVIEWER-05505");
return ;
}
var x36=this;
var x37=function(x38)
{
if(x38)
x35=x38;
if(x36._f92)
x35=x36._f753(x35);
if(!x36._f92||(x36.mapLayerNumber<x36._f135.length))
{
x36.mapLayerNumber++;
x36._f94=x35.getPointX();
x36._f95=x35.getPointY();
x36._f763(x35.getPointX(),x35.getPointY());
}
else
 {
x36._f764=(x36._f94-x35.getPointX())*x36._f75;
x36._f765=(x36._f95-x35.getPointY())*x36._f77*(-1);
x36._f766=x36._f108();
x36._f767=x36._f109();
if(Math.abs(x36._f764)<=(x36._f766+x36._f670)&&Math.abs(x36._f765)<=(x36._f767+x36._f671))
{
x36._f264=Math.sqrt(x36._f764*x36._f764+x36._f765*x36._f765);
x36._f768=20;
x36._f769=x36._f264>((x36._f766+x36._f767)/4)?300:200;
x36._f770=0;
x36._f771=0;
x36._f772=0;
x36.smoothPan(x34);
}
else
 {
x36._f94=x35.getPointX();
x36._f95=x35.getPointY();
x36.display();
if(x36._f719)
{
x36._f719();
}
MVUtil.runListeners(x36._f97,MVEvent.RECENTER);
}
if(x36._f626)
{
x36._f626._f634(x36);
}
}
if(x33)
x33();
}
if(this.srid!=x35.srid)
{
this.reCenterTag=true;
x35=this.transformGeom(x35,this.srid,null,x37);
}
else
 x37();
}
else
 {
if(x33)
x33();
}
}
MVMapView.prototype.setCenterLon=function(x39)
{
this._f94=x39;
}
MVMapView.prototype.setCenterLat=function(x40)
{
this._f95=x40;
}
MVMapView.prototype.setCenterMark=function(x41,x42,x43)
{
if(this._f773!=undefined)
{
this._f219.removeChild(this._f773);
delete this._f773;
}
if(x41==null)
return ;
this.centerMarkUrl=x41;
this.centerMarkW=x42;
this.centerMarkH=x43;
var x44=document.createElement("img");x44.src=x41;
x44.style.zIndex=2000;
x44.style.position="absolute";
x44.style.width=MVUtil._f31(x42);
x44.style.height=MVUtil._f31(x43);
x44.style.left=MVUtil._f31((this._f108()-x42)/2);
x44.style.top=MVUtil._f31((this._f109()-x43)/2);
this._f219.appendChild(x44);
this._f773=x44;
}
MVMapView.prototype.setZoomLevel=function(x45)
{
if(isNaN(x45))
{
MVi18n._f6("MVMapView.setZoomLevel","MAPVIEWER-05506");
return;
}
if(!this._f92)
{
this._f20=x45;
return ;
}
if(x45<0)
x45=0;
else if(x45>this._f697)
x45=this._f697;
if(this._f92)
this.zoomTo(x45);
else
 {
this._f20=x45;
this._f752();
}
}
MVMapView.prototype.setHomeMap=function(x46,x47)
{
this._f700=x46;
if(x47)
this._f701=x47;
}
MVMapView.prototype.setMapBuffer=function(x48,x49)
{
this._f670=x48;
this._f671=x49;
}
MVMapView.prototype._f774=function(x50,x51)
{
var x52=false;
var x53=this;
var x54=function(x55)
{
if(x55)
{
x53._f94=x55.getPointX();
x53._f95=x55.getPointY();
x53.center=x55;
}
x53.msi=x50.msi;
x53.srid=x53.msi.getSrid();
x53.maptype=x53.msi.mapConfig.coordSys.type;
if(x53._f20>(x53.msi.zoomCount-1))
{
x53._f20=x53.msi.zoomCount-1;
}
for(var x56=0;x56<x53.msi.getMaxZoomLevel();x56++)
{
x53._f689[x56]=x53.msi._f520(x53._f20);
x53._f690[x56]=x53.msi._f521(x53._f20);
}
x53._f752();
x53._f697=x53.msi.getMaxZoomLevel()-1;
x53._f754();
x51(x52);
}
if(!x50.msi)
x50.msi=new _f508(x50._f107);
if(this.msi)
{
if(!x50.isVisible()||this.msi.getSrid()==x50.msi.getSrid())
{
x51(false);
return;
}
else
 {
x52=true;
var x57=MVSdoGeometry.createPoint(this._f94,this._f95,this.msi.getSrid());
if(!this.reCenterTag)
x57=this.originalCenter;
this.transformGeom(x57,x50.msi.getSrid(),null,x54);
}
}
else
 x54();
}
MVMapView.prototype.getMapBaseURL=function()
{
return this._f4;
}
MVMapView.prototype._f108=function()
{
var x58=0;
if(this._f219.style&&this._f219.style.width)
{
var x59=this._f219.style.width+"";
if(x59.indexOf("%")<0)
{
if(x59.indexOf("px")>0)
x58=parseInt(x59.substring(0,x59.indexOf("px")));
else
 x58=parseInt(x59);
if(x58)
return x58;
}
}
if(this._f219.offsetWidth)
x58=this._f219.offsetWidth;
else if(this._f219.width)
x58=parseInt(this._f219.width+"");
return x58;
}
MVMapView.prototype._f109=function()
{
var x60=0;
if(this._f219.style&&this._f219.style.height)
{
var x61=this._f219.style.height+"";
if(x61.indexOf("%")<0)
{
if(x61.indexOf("px")>0)
x60=parseInt(x61.substring(0,x61.indexOf("px")));
else
 x60=parseInt(x61);
if(x60)
return x60;
}
}
if(this._f219.offsetHeight)
x60=this._f219.offsetHeight;
else if(this._f219.width)
x60=parseInt(this._f219.width+"");
return x60;
}
MVMapView.prototype._f758=function(x62)
{
var x63=this._f108()/2;
return (0-x63)/this._f75+x62;
}
MVMapView.prototype._f759=function(x64)
{
var x65=this._f109()/2;
return -1.0*(x65-1)/this._f77+x64;
}
MVMapView.prototype._f760=function(x66)
{
var x67=this._f108()/2;
return (x67-1)/this._f75+x66;
}
MVMapView.prototype._f761=function(x68)
{
var x69=this._f109()/2;
return -1.0*(0-x69)/this._f77+x68;
}
MVMapView.prototype.getCenter=function()
{
var x70=MVSdoGeometry.createPoint(this._f94,this._f95,this.srid);
return x70;
}
MVMapView.prototype._f226=function()
{
return this._f94;
}
MVMapView.prototype._f227=function()
{
return this._f95;
}
MVMapView.prototype.getMapWindowBBox=function()
{
this._f125();
var x71=MVSdoGeometry.createRectangle(this._f74,this._f294,
this._f288,this._f76,this.srid);
return x71;
}
MVMapView.prototype.getMouseLocation=function()
{
var x72=MVSdoGeometry.createPoint(this._f680,this._f681,this.srid);
return x72;
}
MVMapView.prototype._f352=function()
{
return this._f680;
}
MVMapView.prototype._f353=function()
{
return this._f681;
}
MVMapView.prototype.getZoomLevel=function()
{
return this._f20;
}
MVMapView.prototype.getMaxZoomLevel=function()
{
if(!this.msi)
{
MVi18n._f6("MVMapView.getMaxZoomLevel","MAPVIEWER-05526");
return -1;
}
else
 return this.msi.getMaxZoomLevel();
}
MVMapView.prototype.enableMapBoundConstraint=function(x73)
{
return this._f746=x73;
}
MVMapView.prototype.getBaseDiv=function()
{
return this._f219;
}
MVMapView.prototype._f775=function()
{
return this.div;
}
MVMapView.prototype._f776=function()
{
return this._f679._f372;
}
MVMapView.prototype._f777=function()
{
return this._f679._f371;
}
MVMapView.prototype._f778=function()
{
return this.msi;
}
MVMapView.prototype._f779=function()
{
return this._f682;
}
MVMapView.prototype._f780=function()
{
return this._f683;
}
MVMapView.prototype._f781=function()
{
return this._f684;
}
MVMapView.prototype._f782=function()
{
return this._f685;
}
MVMapView.prototype.getScreenMinLon=function()
{
return this._f74;
}
MVMapView.prototype._f783=function()
{
return this._f294;
}
MVMapView.prototype._f784=function()
{
return this._f288;
}
MVMapView.prototype._f785=function()
{
return this._f76;
}
MVMapView.prototype._f786=function()
{
return this._f75;
}
MVMapView.prototype._f787=function()
{
return this._f77;
}
MVMapView.prototype.zoomIn=function(x74)
{
this.zoomTo(this._f20+1,x74);
}
MVMapView.prototype.zoomOut=function(x75)
{
this.zoomTo(this._f20-1,x75);
}
MVMapView.prototype.setZoomAnimationEnabled=function(x76)
{
this.zoomAnimationEnabled=x76;
}
MVMapView.prototype.zoomTo=function(x77,x78)
{
var x79=this._f20;
if(x77>=this._f697)
{
x77=this._f697;
}
else if(x77<0)
{
x77=0;
}
if(x77==this._f20&&!x78)
{
if(this.navigationPanel)
this.navigationPanel.updateSliderBar();
return false;
}
this._f588();
this._f20=x77;
if(this.navigationPanel)
this.navigationPanel.updateSliderBar();
this._f20=x77;
this._f752();
var x80=false;
var x81=MVSdoGeometry.createPoint(this._f94,this._f95,this.srid);
var x82=this;
var x83=function(x84)
{
if(x84)
x78=x84;
if(x78)
{
if(x78.getPointX()!=x82._f94||x78.getPointY()!=x82._f95)
{
x80=true;
}
x82._f94=x78.getPointX();
x82._f95=x78.getPointY();
}
if(x82._f718&&x79!=x82._f20)
x82._f718(x79,x82._f20);
if(x79!=x82._f20)
MVUtil.runListeners(x82._f97,MVEvent.BEFORE_ZOOM_LEVEL_CHANGE,[x79,x82._f20]);
if(x79!=x82._f20&&x82.zoomAnimationEnabled)
{
for(var x85=0;x85<x82._f135.length;x85++)
{
if(x82._f135[x85].layerControl)
x82._f135[x85].layerControl.zoomControl.showTiles(x79,x82._f20,x81,x78);
}
}
x82.display();
if(x82._f626)
{
x82._f626._f634(x82);
}
if(x80)
{
if(x82._f719)
x82._f719();
MVUtil.runListeners(x82._f97,MVEvent.RECENTER);
}
if(x82._f215)
{
x82._f215._f230(x79,x82._f20);
x82._f215._f229();
}
if(x79!=x82._f20)
{
if(x82._f717)
x82._f717(x79,x82._f20);
MVUtil.runListeners(x82._f97,MVEvent.ZOOM_LEVEL_CHANGE,[x79,x82._f20]);
}
}
if(x78)
{
this.reCenterTag=true;
this.srid=this.msi.getSrid();
if(!x78.srid)
x78.srid=this.srid;
if(!(x78.sdo_point))
{
MVi18n._f6("MVMapView.zoomTo","MAPVIEWER-05505");
return ;
}
if(x78.srid&&(this.srid!=x78.srid))
x78=this.transformGeom(x78,this.srid,null,x83);
else
 x83();
}
else
 x83();
return true;
}
MVMapView.prototype.zoomToAtLocation=function(x86,x87)
{
this.srid=this.msi.getSrid();
var x88=this;
var x89=function(x90)
{
if(x90)
x86=x90;
var x91=(x88._f94-x86.getPointX())*x88._f75;
var x92=(x88._f95-x86.getPointY())*x88._f77;
var x93=x88._f689[x87]/x88.msi._f518(x87);
var x94=x88._f690[x87]/x88.msi._f519(x87);
var x95=x91/x93+x86.getPointX();
var x96=x92/x94+x86.getPointY();
var x97=MVSdoGeometry.createPoint(x95,x96,x88.srid);
x88.zoomTo(x87,x97);
}
if(x86.srid&&(this.srid!=x86.srid))
x86=this.transformGeom(x86,this.srid,null,x89);
else
 x89();
}
MVMapView.prototype.setCenterAndZoomLevel=function(x98,x99)
{
if(!this._f92)
{
this.center=x98;
this._f20=x99;
return ;
}
this.srid=this.msi.getSrid();
if(!x98.srid)
x98.srid=this.srid;
var x100=this;
var x101=function(x102)
{
if(x102)
x98=x102;
if(x99==null)
{
x99=x100._f20;
}
if(!x100._f92)
{
x100.setCenter(x98);
x100.setZoomLevel(x99);
return ;
}
if(x99==x100._f20)
{
if(!x100._f677)
{
x100.zoomTo(x99,x98);
return;
}
else {
x100._f764=(x100._f94-x98.getPointX())*x100._f75
x100._f765=(x100._f95-x98.getPointY())*x100._f77*(-1);
x100._f766=x100._f108();
x100._f767=x100._f109();
if(Math.abs(x100._f764)<=(x100._f766+x100._f670)&&Math.abs(x100._f765)<=(x100._f767+x100._f671))
{
x100._f264=Math.sqrt(x100._f764*x100._f764+x100._f765*x100._f765);
x100._f768=20;
x100._f769=x100._f264>((x100._f766+x100._f767)/4)?300:200;
x100._f770=0;
x100._f771=0;
x100._f772=0;
x100.smoothPan();
return;
}
}
}
x100.zoomTo(x99,x98);
}
if(x98.srid&&(this.srid!=x98.srid))
x98=this.transformGeom(x98,this.srid,null,x101);
else
 x101();
}
MVMapView.prototype.addMapTileLayer=function(x103,x104)
{
if(x103.getType&&x103.getType()=="MVExternalAPIMapTileLayer")
this._f788(x103);
else
 {
if(x103._f107==undefined||
x103._f107==null||
MVUtil._f231(x103._f107)=="")
{
MVi18n._f6("MVMapView.addMapTileLayer","MAPVIEWER-05507");
return ;
}
if(!this._f530&&this.compareBaseURL(x103._f411))
{
var x105=x103._f107.split(".");
if(x105.length>=2)
{
_f10._f532(x105[0]);
this._f532(x105[0]);
}
}
x103.parent=this;
if(!x103._f411)
{
if(this._f4)
{
if(MVUtil._f5(this._f4,'/'))
x103._f411=this._f4+'mcserver';
else
 x103._f411=this._f4+'/mcserver';
}
else
 {
MVi18n._f6("MVMapView.addMapTileLayer","MAPVIEWER-05504");
return ;
}
}
if(MVMapView._f7&&MVUtil._f8(x103._f411)!=MVUtil._f8(this._f9))
x103._f503=_f10._f11()+"?rtarget="+x103._f411;
else
 x103._f503=x103._f411;
if(x103==null||!x103.getType)
{
MVi18n._f6("MVMapView.addMapTileLayer","MAPVIEWER-05519","mapTileLayer");
return;
}
}
var x106=this;
var x107=function()
{
if(!x103.zIndex)
x103.zIndex=x106._f135.length+1;
x106._f774(x103,AfterSetProvider);
function AfterSetProvider(x0)
{
x103.config=_f10._f510[x103._f107];
if(!x103.isExtAPITileLayer())
{
var x1=null;
x1=new _f408(x106,x103);
x103.layerControl=x1;
x106._f135.push(x103);
}
if(x106._f92)
{
if(!x0)
{
if(x103.isExtAPITileLayer())
{
var x2=function(x3)
{
x103.setCenterAndZoomLevel(x3.getPointX(),x3.getPointY(),x106._f20);
}
var x4=MVSdoGeometry.createPoint(x106._f94,x106._f95,x106.srid);
x106.transformGeom(x4,x103.srid,null,x2);
}
else
 x103.layerControl._f434(x106._f108(),x106._f109(),x106._f94,x106._f95);
}
else
 x106.display();
}
if(x104)
x104();
if(x106._f215&&x106._f215._f206&&x106._f215._f206._f135.length==0)
x106._f215.addOverviewMapTileLayer();
}
}
_f10._f537(x103,x107);
}
MVMapView.prototype.addBaseMapLayer=MVMapView.prototype.addMapTileLayer;
MVMapView.prototype.getMapTileLayerDefinition=function(x108,x109,x110)
{
if(!x110)
x110=null;
var x111=new MVMapTileLayer(x109,x110);
if(!x111._f411)
{
if(this._f4)
{
if(MVUtil._f5(this._f4,'/'))
x111._f411=this._f4+'mcserver';
else
 x111._f411=this._f4+'/mcserver';
}
else
 {
MVi18n._f6("MVMapView.getMapTileLayerDefinition","MAPVIEWER-05504");
return ;
}
}
if(MVMapView._f7&&MVUtil._f8(x111._f411)!=MVUtil._f8(this._f9))
x111._f503=_f10._f11()+"?rtarget="+x111._f411;
else
 x111._f503=x111._f411;
_f10._f537(x111,x108);
}
MVMapView.prototype.removeMapTileLayer=function(x112)
{
var x113=0;
for(;x113<this._f135.length;x113++)
{
if(this._f135[x113]==x112)
{
var x114=this._f135[x113];
this._f135[x113]=this._f135[this._f135.length-1];
x114.destroy();
this._f135.pop();
this.mapLayerNumber--;
if(this._f215)
{
this._f215._f206.removeMapTileLayer(x112);
}
return ;
}
}
}
MVMapView.prototype._f716=function()
{
if(!this._f79)
this._f79=new _f289(this);
this._f250=new _f261(this);
this._f250.setSize(Math.ceil(2*(this._f108())),
Math.ceil(2*(this._f109())));
MVUtil._f73(this._f250._f60(),
(this._f108()-this._f250._f87())/2,
(this._f109()-this._f250._f88())/2);
}
MVMapView.prototype.addGroupFOI=function(x115)
{
this._f152=0;
this._f789=x115;
this.startAddGroupFOI();
}
MVMapView.prototype.startAddGroupFOI=function()
{
for(var x116=0;x116<11000;x116++)
{
if(this._f152<this._f789.length)
{
this.addFOI(this._f789[this._f152]);
this._f152++;
}
else
 {
this._f789=null;
this._f790=null;
return;
}
}
this.setTimeout("this.startAddGroupFOI()",5);
}
MVMapView.prototype.addFOI=function(x117)
{
if(!this._f530&&this.compareBaseURL(x117._f3)&&x117.style&&x117.style.indexOf!=undefined)
{
var x118=x117.style.split(".");
if(x118.length>=2)
{
_f10._f532(x118[0]);
this._f532(x118[0]);
}
}
if(!x117||!x117.id)
return false;
if(x117.gtype%10==1)
x117._f192=true;
x117.parent=this;
if(x117.id!="")
{
var x119=x117.id.substr(0,3);
if(x119!="-RL")
{
for(var x120=0;x120<this._f250._f262.length;x120++)
{
if(this._f250._f262[x120].id==x117.id)
{
MVi18n._f6("MVMapView.addFOI","MAPVIEWER-05508","foi.id:"+x117.id);
return false;
}
}
}
}
if(x117.gtype%10==1&&!x117.style)
{
x117._f130=x117._f3;
}
if(!x117._f3&&!x117.isHTMLFOI)
x117._f3=_f10._f454();
this._f250._f259(x117);
return true;
}
MVMapView.prototype.getFOI=function(id)
{
return this._f250._f263(id);
}
MVMapView.prototype.removeFOI=function(x121)
{
if(!x121)
return ;
if(x121.id)
this._f250._f258(x121.id);
else
 this._f250._f258(x121);
}
MVMapView.prototype.getAllFOIs=function()
{
return this._f250._f280();
}
MVMapView.prototype._f281=function()
{
this._f125();
if(this._f250!=null)
{
var x122=(this._f250._f87()-
this._f108())*0.5/this._f75;
var x123=(this._f250._f88()-
this._f109())*0.5/this._f77;
MVUtil._f73(this._f250._f60(),
(this._f108()-this._f250._f87())/2,
(this._f109()-this._f250._f88())/2);
MVUtil._f73(this._f250.getTopContainer(),
(this._f108()-this._f250._f87())/2,
(this._f109()-this._f250._f88())/2);
this._f250._f281(this._f74-x122,
this._f294-x123,this._f288+x122,
this._f76+x123);
}
}
MVMapView.prototype.removeAllFOIs=function()
{
this._f250._f89();
}
MVMapView.prototype.addRedLineTool=function(x124)
{
if(x124==null)
{
MVi18n._f6("MVMapView.addRedLineTool","MAPVIEWER-05519","redlineTool");
return;
}
x124.parent=this;
if(!x124._f3)
x124._f3=_f10._f454();
}
MVMapView.prototype.addCircleTool=function(x125)
{
if(x125==null)
{
MVi18n._f6("MVMapView.addCircleTool","MAPVIEWER-05519","circleTool");
return;
}
this._f219.appendChild(x125._f471);
x125.parent=this;
if(!x125._f470)
x125._f470=_f10._f454();
}
MVMapView.prototype.addRectangleTool=function(x126)
{
if(x126==null)
{
MVi18n._f6("MVMapView.addRectangleTool","MAPVIEWER-05519","rectangleTool");
return;
}
this.div.appendChild(x126._f618);
x126.parent=this;
if(!x126._f470)
x126._f470=_f10._f454();
}
MVMapView.prototype.addDistanceTool=function(x127)
{
if(x127==null)
{
MVi18n._f6("MVMapView.addDistanceTool","MAPVIEWER-05519","distanceTool");
return;
}
x127.parent=this;
if(!x127._f3)
x127._f3=_f10._f454();
}
MVMapView.prototype.addToolBar=function(x128)
{
if(x128==null)
{
MVi18n._f6("MVMapView.addToolBar","MAPVIEWER-05519","toolBar");
return;
}
x128.mapviewer=this;
this.addMapDecoration(x128.toolBarDecoration);
x128._f617();
if(this._f92)
x128._f616();
else
 x128.toolBarDecoration.afterDisAction=x128._f616;
}
MVMapView.prototype.stopMarqueeZoom=function()
{
this._f704=false;
if(this._f705)
this._f705.clear();
}
MVMapView.prototype.startMarqueeZoom=function(x129,x130,x131)
{
if(!x129)
x129="one_time";
if(x131&&x131>0)
this._f736=x131;
this._f704=true;
this._f703=x129;
this.marqueeZoom(x130);
}
MVMapView.prototype.marqueeZoom=function(x132)
{
if(!this._f704)
return ;
this._f706=false;
this._f708=false;
var x133=this._f705;
if(!x133)
{
x133=new MVRectangleTool(null,null);
x133.setDivFillColor("#555555",0.3);
this.addRectangleTool(x133);
this._f705=x133;
}
if(x132)
x133.setDivStyle(x132);
x133.init();
var x134=MVUtil._f105(x133,function()
{
this.clear();
var x135=null;
if(this.parent.marqueeRectGeom)
x135=this.parent.marqueeRectGeom.getMBR();
if(x135&&
(this._f703=="prompt"||
Math.abs(x135[2]-x135[0])*this.parent._f75>=this.parent._f736&&
Math.abs(x135[3]-x135[1])*this.parent._f77>=this.parent._f736))
{
var x136=document.getElementById("mv_mrqzm_msg");
if(x136)
x136.parentNode.removeChild(x136);
this.parent.zoomToRectangle(this.parent.marqueeRectGeom);
}
if(this.parent._f703!="one_time")
{
this.parent.marqueeZoom();
}
});
var x137=MVUtil._f105(x133,function()
{
this.parent._f706=true;
this.parent.marqueeRectGeom=x133.getRectangle();
x134();
});
var x138=MVUtil._f105(x133,function()
{
this.parent.marqueeRectGeom=x133.getRectangle();
x134();
this._f704=false;
});
var x139=MVUtil._f105(x133,function(x140)
{
this.parent._f707=true;
x140=(x140)?x140:((window.event)?event:null);
MVUtil._f174(x140);
});
var x141=MVUtil._f105(x133,function(x142)
{
x142=(x142)?x142:((window.event)?event:null);
if(this.parent._f707)
{
MVUtil._f174(x142);
x134();
}
});
var x143=MVUtil._f105(x133,function()
{
this.parent._f706=true;
this.parent.marqueeRectGeom=x133.getRectangle();
if(!this.parent.marqueeRectGeom)
{
this.clear();
this.parent.marqueeZoom();
return ;
}
var x144=this.parent;
var x145=x133.getRectangleDIV();
MVUtil._f164(x145,"crosshair");
if(MVi18n._f342("marqueeZoomHint"))
{
x145.onmouseover=function(x146)
{
var x147=document.getElementById("mv_mrqzm_msg");
if(x147)
x147.parentNode.removeChild(x147);
x147=MVUtil._f669(MVi18n._f342("marqueeZoomHint"));
x147.id="mv_mrqzm_msg";
x147.style.border="1px solid #000000";
x147.style.backgroundColor="#FFFFCC";
x147.style.position="absolute";
var x148=MVUtil._f647(x144,x146);
x147.style.left=x148.x+"px";
x147.style.top=x148.y+"px";
x147.style.zIndex=9999;
x144._f219.appendChild(x147);
};
x145.onmouseout=function()
{
var x149=document.getElementById("mv_mrqzm_msg");
if(x149)
x149.parentNode.removeChild(x149);
};
}
this.parent._f707=false;
x145.onmousedown=x139;
x145.onmouseup=x141;
x145.onclick=function(x150)
{
MVUtil._f174(x150);
};
});
this._f707=false;
if(this._f703=="prompt")
x133.addEventListener("on_finish",x143);
else if(this._f703=="continuous")
x133.addEventListener("on_finish",x137);
else
 x133.addEventListener("on_finish",x138);
}
MVMapView.prototype.zoomToRectangle=function(x151)
{
if(!this._f92)
{
this._f791(this,"zoomToRectangle",x151);
return ;
}
var x152=this;
var x153=function(x154)
{
var x155=x154.getMBR();
var x156=Math.abs(x155[0]-x155[2]);
var x157=Math.abs(x155[1]-x155[3]);
var x158=x156*(x152._f75);
var x159=x157*(x152._f77);
var x160=x152._f108();
var x161=x152._f109();
var x162=x152._f20;
var x163=x162;
var x164=x152._f697;
if(x160<x158||x161<x159)
{
for(var x165=(x162-1);x165>=0;--x165)
{
x163=x165;
var x166=(x152._f689[x165]/x152.msi._f518(x165))*x156;
var x167=(x152._f690[x165]/x152.msi._f519(x165))*x157;
if(x166<=x160&&x167<=x161)
break;
}
}
else if(x160>x158&&x161>x159)
{
for(var x165=(x162+1);x165<=x164;++x165)
{
var x166=(x152._f689[x165]/x152.msi._f518(x165))*x156;
var x167=(x152._f690[x165]/x152.msi._f519(x165))*x157;
if(x166<=x160&&x167<=x161)
x163=x165;
else
 break;
}
}
var x168=(x155[0]+x155[2])/2;
var x169=(x155[1]+x155[3])/2;
var x170=MVSdoGeometry.createPoint(x168,x169,x152.srid);
x152.zoomTo(x163,x170);
}
if(!x151.srid)
x151.srid=this.srid;
if(x151.srid&&this.srid!=x151.srid)
this.transformGeom(x151,this.srid,null,x153);
else
 x153(x151);
}
MVMapView.prototype._f792=function(x171)
{
var x172=(x171._f87()-this._f108())*0.5/this._f75;
var x173=(x171._f88()-this._f109())*0.5/this._f77;
var x174=new Array();
if(x171._f1._f50==1&&x171._f1._f51==1)
{
x174[0]=this._f74;
x174[1]=this._f294;
x174[2]=this._f288;
x174[3]=this._f76;
}
else
 {
var x175=this._f793(this._f74-x172,this._f294-x173);
var x176=this._f794(this._f288+x172,this._f76+x173);
x174[0]=x175.x;
x174[1]=x175.y;
x174[2]=x176.x;
x174[3]=x176.y;
}
var x177=Math.floor((x174[2]-x174[0])*this._f75+0.5);
var x178=Math.floor((x174[3]-x174[1])*this._f77+0.5);
x171._f49(x177,x178);
return x174;
}
MVMapView.prototype._f755=function()
{
this._f125();
var x179=0;
for(x179=0;x179<this._f692.length;x179++)
{
var x180=this._f692[x179];
if(x180._f1._f795)
{
x180.clearTransImageLayer();
var x181=this._f792(x180);
x180._f78(this,x181[0],x181[1],x181[2],x181[3],true,true,null,true,x180._f1._f796);
return true;
}
}
return false;
}
MVMapView.prototype._f756=function(x182,x183)
{
var x184=this;
var x185=function(x186)
{
x186.style.position="absolute";
if(x184._f693==1||x184._f693==3)
x186.style.right=MVUtil._f31(x184._f694);
else
 x186.style.left=MVUtil._f31(x184._f694);
if(x184._f693==2||x184._f693==3)
x186.style.bottom=MVUtil._f31(x184._f695);
else
 x186.style.top=MVUtil._f31(x184._f695);
}
x182._f624(this,x183,x185);
}
MVMapView.prototype.addThemeBasedFOI=function(x187)
{
if(!this._f530&&this.compareBaseURL(x187._f3)&&
x187._f42.indexOf("<jdbc_query")<0)
{
var x188=x187._f42.split(".");
if(x188.length>=2)
{
_f10._f532(x188[0]);
this._f532(x188[0]);
}
}
if(this._f728)
{
this._f797(x187);
return ;
}
if(!x187)
{
MVi18n._f6("MVMapView.addThemeBasedFOI","MAPVIEWER-05519","themeBasedFOI");
return ;
}
if(!this._f79)
this._f79=new _f289(this);
for(var x189=0;x189<this._f692.length;x189++)
{
if(MVUtil._f231(this._f692[x189]._f1.name)==MVUtil._f231(x187.name))
{
MVi18n._f6("MVMapView.addThemeBasedFOI","MAPVIEWER-05509",MVUtil._f231(x187.name));
return;
}
}
x187.parent=this;
var x190=new _f0(this,x187);
if(this._f692.length<100)
{
x190.div.style.zIndex=this._f692.length*2+130;
x190._f32=this._f692.length;
}
else
 {
x190.div.style.zIndex=100*2+130;
x190._f32=100;
}
x190.setSize(parseInt(x187._f50*(this._f108())),
parseInt(x187._f51*(this._f109())));
this._f692[this._f692.length]=x190;
if(this._f92)
{
var x191=this._f792(x190);
MVUtil._f73(x190._f60(),Math.ceil((x191[0]-this._f74)*this._f75),
-Math.ceil((x191[3]-this._f76)*this._f77));
if(x187._f795)
x190._f78(this,x191[0],x191[1],
x191[2],x191[3],false,true,false,false,x187._f796);
else
 x190._f78(this,x191[0],x191[1],
x191[2],x191[3],false,false);
}
}
MVMapView.prototype.getThemeIndex=function(x192)
{
for(var x193=0;x193<this._f692.length;x193++)
{
if(MVUtil._f231(this._f692[x193]._f1.name)==MVUtil._f231(x192.name))
{
return x193+1;
}
}
MVi18n._f6("MVMapView.getThemeIndex","MAPVIEWER-05510",MVUtil._f231(x192.name));
}
MVMapView.prototype.getOrigThemeIndex=function(x194)
{
for(var x195=0;x195<this._f692.length;x195++)
{
if(MVUtil._f231(this._f692[x195]._f1.name)==MVUtil._f231(x194.name))
{
return this._f692[x195]._f32;
}
}
MVi18n._f6("MVMapView.getOrigThemeIndex","MAPVIEWER-05510",MVUtil._f231(x194.name));
}
MVMapView.prototype.setThemeIndex=function(x196,x197)
{
if(x197>100)
x197=100;
if(x197<1)
x197=1;
for(var x198=0;x198<this._f692.length;x198++)
{
if(MVUtil._f231(this._f692[x198]._f1.name)==MVUtil._f231(x196.name))
{
while(x198+1<this._f692.length&&x198+1<x197)
{
var x199=this._f692[x198];
this._f692[x198]=this._f692[x198+1];
this._f692[x198+1]=x199;
x198++;
}
while(x198+1>x197)
{
var x199=this._f692[x198];
this._f692[x198]=this._f692[x198-1];
this._f692[x198-1]=x199;
x198--;
}
break;
}
}
for(var x200=0;x200<this._f692.length;x200++)
{
this._f692[x200].div.style.zIndex=x200*2+130;
if(this._f692[x200]._f33)
this._f692[x200]._f33.style.zIndex=x200*2+130+1;
if(this._f692[x200]._f33&&this._f692[x200]._f30!=1&&
this._f692[x200]._f1._f103<=this._f20)
this._f81.style.zIndex=x200*2+130+1;
}
}
MVMapView.prototype.setToOrigThemeIndex=function(x201)
{
for(var x202=0;x202<this._f692.length;x202++)
{
if(MVUtil._f231(this._f692[x202]._f1.name)==MVUtil._f231(x201.name))
{
this._f692[x202].div.style.zIndex=this._f692[x202]._f32*2+130;
if(this._f692[x202]._f30==2&&_f10._f69!="IF"&&
this._f692[x202]._f33)
{
this._f692[x202]._f33.style.zIndex=this._f692[x202]._f32*2+130+1;
}
}
}
}
MVMapView.prototype.getThemeBasedFOI=function(x203)
{
for(var x204=0;x204<this._f692.length;x204++)
{
if(this._f692[x204].getThemeBasedFOI().name==x203)
{
return this._f692[x204].getThemeBasedFOI();
}
}
return null;
}
MVMapView.prototype.enableInfoWindowEventPropagation=function(x205)
{
if(!this._f79)
this._f79=new _f289(this);
this._f79.enableEventPropagation(x205);
}
MVMapView.prototype.refreshThemeBasedFOIs=function(x206)
{
if(this._f79)
this._f79._f292();
this._f125();
var x207=0;
for(x207=0;x207<this._f692.length;x207++)
{
var x208=this._f692[x207];
if(x208._f30!=1)
{
x208.clearTransImageLayer();
}
var x209=this._f792(x208);
var x210=x208._f1.getFOIData();
if(x210!=null)
{
if(!x208._f2&&
!x208._f1._f798&&x210[0].gtype%10==1&&
x208._f1._f70<this._f20){
x208._f90();
x208.div.style.display='none';
x208._f1.minX=x208.minX=x209[0];
x208._f1.minY=x208.minY=x209[1];
x208._f1.maxX=x208.maxX=x209[2];
x208._f1.maxY=x208.maxY=x209[3];
x208._f20=this._f20;
var x211=Math.ceil((x208.minX-this._f74)*this._f75);
var x212=-Math.ceil((x208.maxY-this._f76)*this._f77);
MVUtil._f73(x208._f60(),x211,x212);
x208._f27=this._f94;
x208._f28=this._f95;
for(var x213=0;x213<x210.length;x213++)
{
x208._f132(x210[x213]);
}
x208.makeFOIsVisiable();
x208._f2=false;
x208._f29=false;
continue;
}
}
x208._f78(this,x209[0],x209[1],x209[2],x209[3],x206,false,null,true);
}
}
MVMapView.prototype._f793=function(x214,x215)
{
var x216={"x":0,"y":0};
var x217=Math.floor((x214-this.msi._f54())/this.msi._f518(this._f20));
var x218=Math.floor((x215-this.msi._f55())/this.msi._f519(this._f20));
x216.x=this.msi._f54()+x217*this.msi._f518(this._f20);
x216.y=this.msi._f55()+x218*this.msi._f519(this._f20);
return x216;
}
MVMapView.prototype._f794=function(x219,x220)
{
var x221={"x":0,"y":0};
var x222=Math.floor((x219-this.msi._f54())/this.msi._f518(this._f20));
var x223=Math.floor((x220-this.msi._f55())/this.msi._f519(this._f20));
x221.x=this.msi._f54()+(x222+1)*this.msi._f518(this._f20);
x221.y=this.msi._f55()+(x223+1)*this.msi._f519(this._f20);
return x221;
}
MVMapView.prototype._f799=function()
{
if(this._f92)
{
for(var x224=0;x224<this._f692.length;x224++)
this._f692[x224].setVisible(false,false);
this.refreshThemeBasedFOIs(false);
}
while(this._f692.length>0)
{
this._f692[this._f692.length-1].destroy();
this._f692[this._f692.length-1]=null;
this._f692.pop();
}
while(this._f81.childNodes.length>0)
{
this._f81.removeChild(this._f81.childNodes[0]);
}
}
MVMapView.prototype.removeThemeBasedFOI=function(x225)
{
if(!x225)
return ;
for(var x226=0;x226<this._f692.length;x226++)
{
if(x225==this._f692[x226].getThemeBasedFOI())
{
this._f692[x226].destroy();
this._f692[x226]=this._f692[this._f692.length-1];
this._f692[this._f692.length-1]=null;
this._f692.pop();
break;
}
}
for(var x227=0;x227<this._f81.childNodes.length;x227++)
{
if(this._f81.childNodes[x227].id==x225.name)
{
this._f81.removeChild(this._f81.childNodes[x227]);
x227--;
}
}
for(var x228=0;x228<this._f692.length;x228++)
{
this._f692[x228].div.style.zIndex=x228*2+130;
if(this._f692[x228]._f33&&this._f692[x228]._f30!=1&&
this._f692[x228]._f1._f103<=this._f20)
{
this._f692[x228]._f33.style.zIndex=x228*2+130+1;
this._f81.style.zIndex=x228*2+130+1;
}
}
}
MVMapView.prototype._f800=function()
{
if(this._f79)
this._f79._f292();
this._f125();
var x229=0;
var x230=false;
for(x229=0;x229<this._f692.length;x229++)
{
var x231=this._f692[x229];
if((
this._f74<x231._f54()||
this._f294<x231._f55()||
this._f288>x231._f56()||
this._f76>x231._f57())&&x231._f1._f798)
{
if(x231._f30!=1)
{
x231.clearTransImageLayer();
}
var x232=this._f792(x231);
x231._f78(this,x232[0],x232[1],x232[2],x232[3],true,false);
}
else if(x231._f2)
{
x231._f78(this,0,0,0,0,true,false);
}
}
if(this._f74<this._f250.minX||
this._f294<this._f250.minY||
this._f288>this._f250.maxX||
this._f76>this._f250.maxY)
{
var x233=(this._f250._f87()-this._f108())*0.5/this._f75;
var x234=(this._f250._f88()-this._f109())*0.5/this._f77;
this._f250._f281(this._f74-x233,
this._f294-x234,
this._f288+x233,
this._f76+x234);
}
else if(this.wraparound){
var x233=(this._f250._f87()-this._f108())*0.5/this._f75;
var x235=x233-(this._f74-this._f250.minX);
var x236=x233-(this._f250.maxX-this._f288);
var x237=x235>0?x235:x236;
var x238=(this.msi._f158-this.msi._f159)/4;
if(x237>x238)
{
var x234=(this._f250._f88()-this._f109())*0.5/this._f77;
this._f250._f281(this._f74-x233,
this._f294-x234,
this._f288+x233,
this._f76+x234);
}
}
if(!x230)
{
this._f79.refresh(this._f74,this._f294,this._f288,
this._f76,this._f108(),this._f109());
x230=true;
}
}
MVMapView.prototype.getAllThemeBasedFOIs=function()
{
return this._f692;
}
MVMapView.prototype.setDefaultInfoWindowStyle=function(x239,x240)
{
_f10._f296=x239;
if(x239=="MVInfoWindowStyle1")
MVInfoWindowStyle1._f801=x240;
}
MVMapView.prototype.displayInfoWindow=function(x241,x242,x243,x244,x245,x246,x247)
{
if(this.infoWindowTimeout)
{
clearTimeout(this.infoWindowTimeout);
this.infoWindowTimeout=null;
}
var x248=this;
var x249=function(x250)
{
if(x250)
x241=x250;
x248._f79._f306(x242,x241.sdo_point.x,x241.sdo_point.y,x243,x244,x245,x246,x247);
}
var x251=function()
{
if(x248._f92)
{
if(!x241.srid)
x241.srid=x248.srid;
if(x241.srid&&(x248.srid!=x241.srid))
center=x248.transformGeom(x241,x248.srid,null,x249);
else
 x249();
}
else
 x248.infoWindowTimeout=setTimeout(x251,200);
}
x251();
}
MVMapView.prototype.displayTabbedInfoWindow=function(x252,x253,x254,x255,x256,x257)
{
if(this.infoWindowTimeout)
{
clearTimeout(this.infoWindowTimeout);
this.infoWindowTimeout=null;
}
var x258=this;
var x259=function(x260)
{
if(x260)
x252=x260;
x258._f79.showTabbedHtmlWindow(null,x252.sdo_point.x,x252.sdo_point.y,x255,x256,x257,x253,x254);
}
var x261=function()
{
if(x258._f92)
{
if(!x252.srid)
x252.srid=x258.srid;
if(x252.srid&&(x258.srid!=x252.srid))
center=x258.transformGeom(x252,x258.srid,null,x259);
else
 x259();
}
else
 x258.infoWindowTimeout=setTimeout(x261,200);
}
x261();
}
MVMapView.prototype.setInfoWindow=function(x262,x263,x264)
{
this._f715=x262;
this._f300=x263;
this._f301=x264;
}
MVMapView.prototype._f802=function(x265,x266)
{
_f10._f300=x265;
_f10._f301=x266;
}
MVMapView.prototype.removeInfoWindow=function()
{
if(this._f79._f80.length>0)
this._f79.deleteInfoWindow(this._f79._f80[0]);
}
MVMapView.prototype.addCSTransformFunction=function(x267,x268,x269)
{
_f10._f407(x268,x269,x267);
}
MVMapView.prototype.transformGeom=function(geometry,_f404,_f411,callBack,dataSource)
{
if(!geometry.srid)
{
if(!this.srid)
{
MVi18n._f6("MVMapView.transformGeom","MAPVIEWER-05520");
return ;
}
geometry.srid=this.srid;
}
if(geometry.srid==_f404)
{
if(callBack)
{
callBack(geometry);
return ;
}
else
 return geometry;
}
var clientTrans=_f10._f458(geometry.srid,_f404);
if(clientTrans)
{
var _f232=null;
if(geometry.getGType()==1)
{
var result=clientTrans(geometry.getPointX(),geometry.getPointY());
_f232=MVSdoGeometry.createPoint(result.x,result.y,_f404);
}
else if((geometry.gtype%10==2||geometry.gtype%10==3)&&
geometry.sdo_elem_info.length==3&&geometry.sdo_elem_info[0]==1&&
(geometry.sdo_elem_info[1]==2||geometry.sdo_elem_info[1]==1003||geometry.sdo_elem_info[1]==2003)&&
geometry.sdo_elem_info[2]==1)
{
var ordinates=MVMapView._f460(clientTrans,geometry.sdo_ordinates);
_f232=new MVSdoGeometry(geometry.gtype,_f404,geometry.sdo_elem_info,ordinates);
}
if(_f232)
{
if(callBack)
{
callBack(_f232);
return ;
}
else
 return _f232;
}
}
if(_f411)
{}
else if(this._f4)
{
if(MVUtil._f5(this._f4,'/'))
{
_f411=this._f4+'mcserver';
}
else
 {
_f411=this._f4+'/mcserver';
}
}
else
 {
MVi18n._f6("MVMapView.transformGeom","MAPVIEWER-05504");
return ;
}
var localDomain=(MVUtil._f8(_f411)==MVUtil._f8(this._f9));
var xmlHttp=localDomain||MVMapView._f7;
if(!xmlHttp&&!callBack)
{
MVi18n._f6("MVMapView.transformGeom","MAPVIEWER-05521");
return null;
}
var request=null;
var _f461;
var _f462;
var _f803;
if(dataSource)
_f803=dataSource;
else
 _f803=this._f530;
_f462=MVUtil._f48(geometry.toString(),"null","");
if(geometry.getGType()==1)
{
_f462=MVUtil._f48(_f462,"SdoPointType","");
}
else
 {
}
_f462=MVUtil._f48(_f462," ","");
if(MVMapView._f7&&!localDomain)
_f411=_f10._f11()+"?rtarget="+_f411+"&";
else
 _f411=_f411+"?";
var _f804=_f411+"request=cstransform&dstsrid="+
_f404+"&geometry="+_f462+"&datasource="+_f803;
var request=null;
var transformed=MVUtil._f105(this,function()
{
if(request.readyState==4)
{
if(request.status==200)
{
try
{
var resp=request.responseText;
eval("var result="+resp);
_f461=result;
if(result.length==0)
{
result=null;
return;
}
var _f232=null;
if(_f461.SDO_GTYPE==1)
{
_f232=MVSdoGeometry.createPoint(_f461.SDO_POINT.X,_f461.SDO_POINT.Y,_f461.SDO_SRID);
}
else
 {
_f232=new MVSdoGeometry(2000+_f461.SDO_GTYPE,_f461.SDO_SRID,_f461.SDO_ELEM_INFO,_f461.SDO_ORDINATES,null)
}
result=null;
}
catch(e)
{
MVi18n._f6("MVMapView.transformGeom","MAPVIEWER-05523",request.responseText);
return ;
}
if(callBack)
callBack(_f232);
if(xmlHttp)
return _f232;
}
}
});
try
{
request=MVUtil.getXMLHttpRequest(xmlHttp);
if(callBack||!xmlHttp)
request.onreadystatechange=transformed;
request.open("GET",encodeURI(_f804),callBack||!xmlHttp);
request.send("");
}catch(e)
{
MVi18n._f6("MVMapView.transformGeom","MAPVIEWER-05511",e);
return ;
}
if(!callBack&&xmlHttp)
{
if(request.status==200)
{
return transformed();
}
}
}
MVMapView.prototype.getSrid=function()
{
return this.srid;
}
MVMapView.prototype._f805=function()
{
MVUtil._f164(document.body,"wait");
MVUtil._f164(this._f219,"wait");
}
MVMapView.prototype._f806=function()
{
MVUtil._f164(document.body,"");
MVUtil._f164(this._f219,this._f213);
}
MVMapView.prototype.getMapTileLayer=function(x270)
{
var x271=x270.split(".");
if(x271.length<2){
return "";
}
else
 return x271[1];
}
MVMapView.prototype.getMapImageURL=function(x272,x273,x274,x275)
{
var x276=this.getMapAsXML(x273,x274,x275);
var x277=(this._f4==this._f712);
var x278=x277||MVMapView._f7;
var x279="";
if(MVMapView._f7&&!x277)
x279=this._f712;
else
 x279=this._f4;
if(MVUtil._f5(x279,'/'))
x279=x279+'omserver';
else
 x279=x279+'/omserver';
var x280=MVUtil.getXMLHttpRequest(x278);
x280.open("POST",x279,true);
x280.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
x280.send("xml_request="+encodeURIComponent(x276));
x280.onreadystatechange=function()
{
if(x280.readyState==4)
{
if(x280.status==200)
{
var x281=x280.responseText;
var x282=x281.indexOf("url=\"");
if(x282<0)
{
MVi18n._f6("MVMapView.getMapImageURL","MAPVIEWER-05519",x281);
return ;
}
var x283=x281.substring(x282+5,x281.indexOf("\"",x282+5));
x272(x283);
}
}
}
}
MVMapView.prototype.getMapAsXML=function(x284,x285,x286)
{
if(!x285)
x285=this._f108();
if(!x286)
x286=this._f109();
var x287="<?xml version=\"1.0\" standalone=\"yes\"?>"
x287=x287+"<map_request datasource=\""+this._f530+"\" format=\""+x284+"\" width=\""+
x285+"\" height=\""+x286+"\" antialiase=\"true\" "+
(this.getSrid()?"srid=\""+this.getSrid()+"\"":"")+">";
var x288=parseInt(this._f109())/this._f77;
var x289=this.getCenter();
x287=x287+"<center size=\""+x288+"\"><geoFeature><geometricProperty typeName=\"center\"><Point><coordinates>"+x289.sdo_point.x+","+x289.sdo_point.y+"</coordinates></Point></geometricProperty></geoFeature></center>";
x287=x287+"<themes>";
for(i=0;i<this._f135.length;i++)
{
if(this._f135[i].isVisible()&&this._f135[i].layerControl)
x287=x287+"<theme name=\"cached_basemap"+i+"\">"+this._f135[i].layerControl.getXMLForPrint()+"</theme>";
}
var x290="";
var x291="";
var x292="";
for(var x293=0;x293<this._f692.length;x293++)
{
if(this._f692[x293].isVisible())
{
x290+=this._f692[x293]._f39();
if(this._f692[x293]._f1._f104!=null)
x292+=this._f692[x293]._f1._f104.getXML(this._f692[x293]._f1);
var x294=this._f692[x293]._f1._f111;
if(x294.length>0)
{
for(var x295=0;x295<x294.length;x295++)
{
x291+=x294[x295].getXMLString();
}
}
}
}
for(var x293=0;x293<this._f250._f262.length;x293++)
{
if(this._f250._f262[x293].style&&
this._f250._f262[x293].style.getXMLString&&
this._f250._f262[x293].visible)
x291+=this._f250._f262[x293].style.getXMLString();
}
x287=x287+x290+"</themes>";
if(x291!="")
x287+=" <styles>"+x291+"</styles>";
if(x292!="")
x287+=x292;
x287=x287+this._f250._f39();
x287=x287+"</map_request>";
return x287;
}
MVMapView.prototype._f39=function()
{
return this.getMapAsXML("GIF_URL");
}
MVMapView.prototype._f588=function()
{
this.real_base_div.className=null;
this._f807=null;
if(this._f625)
while(this._f625.childNodes.length>0)
{
var x296=this._f625.childNodes[0];
if(x296.src)
{
}
x296.onload=null;
this._f625.removeChild(x296);
MVUtil._f91(x296);
}
}
MVMapView.prototype._f808=function()
{
this.real_base_div.className=("noprint");
}
MVMapView.prototype.print=function(x297)
{
var x298=this;
if(x297.style.position!="absolute")
x297.style.position="relative";
x297.style.width=MVUtil._f31(this._f108());
x297.style.height=MVUtil._f31(this._f109());
if(!this._f809)
{
this._f805();
this._f588();
var x299=this._f39();
var x300=(this._f4==this._f712);
var x301=x300||MVMapView._f7;
var x302="";
if(MVMapView._f7&&!x300)
x302=this._f712;
else
 x302=this._f4;
if(MVUtil._f5(x302,'/'))
x302=x302+'omserver';
else
 x302=x302+'/omserver';
_f279=MVUtil.getXMLHttpRequest(x301);
_f279.open("POST",x302,true);
_f279.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
_f279.send("xml_request="+encodeURIComponent(x299));
_f279.onreadystatechange=function()
{
if(_f279.readyState==4)
{
if(_f279.status==200)
{
x298._f625=x297;
var x303=document.createElement("img");
var x304=_f279.responseText;
var x305=x304.indexOf("url=\"");
if(x305<0)
{
MVi18n._f6("MVMapView.print","MAPVIEWER-05519",x304);
return ;
}
x303.src=x304.substring(x305+5,x304.indexOf("\"",x305+5));x303.style.position="absolute";
x303.style.left=MVUtil._f31(0);
x303.style.top=MVUtil._f31(0);
x298._f625.appendChild(x303);
x303.onload=MVUtil._f105(x303,function()
{
x298._f808();
if(x298._f710!=null)
for(var x306=0;x306<x298._f710.length;x306++)
{
if(x298._f710[x306]._f563&&x298._f710[x306].visible&&!x298._f710[x306].collapsed)
x298._f625.appendChild(x298._f710[x306]._f595());
}
x298._f810(true);
if(x298._f626)
{
x298._f696=new MVScaleBar(x298._f626._f398);
x298._f756(x298._f696,x298._f625)
}
x298._f806();
window.print();
x298._f809=false;
})
x298._f807=x303;
}
}
}
}
}
MVMapView.prototype._f810=function(x307)
{
var x308=document.createElement("span");
x308.className="copyright";
x308.style.zIndex=1999;
if(typeof x307=="string")
{
x308.innerHTML=" "+x307+" ";
this._f625.appendChild(x308);
}
else if(this._f811!=undefined)
{
x308.innerHTML=" "+this._f811.innerHTML+" ";
this._f625.appendChild(x308);
}
}
MVMapView.prototype.setMouseWheelZoomEnabled=function(x309)
{
this._f702=x309;
if(this._f92)
this._f355();
}
MVMapView.prototype._f355=function()
{
var x310=this;
var x311=this.getBrowserType();
this.real_base_div.tabIndex=0;
this.real_base_div.onfocus=MVUtil._f105(this._f219,function()
{
x310._f487=true;
});
this.real_base_div.onblur=MVUtil._f105(this._f219,function()
{
x310._f487=false;
});
this._f219.onmouseover=MVUtil._f105(this._f219,function()
{
x310._f487=true;
});
this._f219.onmouseout=MVUtil._f105(this._f219,function(x312)
{
x312=(x312)?x312:((window.event)?event:null);
var x313=x312.clientX;
var x314=x312.clientY;
var x315=x310._f108();
var x316=x310._f109();
var x317=x310._f224(x312);
if(x317.left<=0||x317.left>=x315||
x317.top<=0||x317.top>=x316||
x313<=1||x313>=document.body.clientWidth||
x314<=1||x314>=document.body.clientHeight)
{
x310._f812(x312);
x310._f487=false;
if(x310._f722.contains(37))x310._f722.remove(37);
if(x310._f722.contains(38))x310._f722.remove(38);
if(x310._f722.contains(39))x310._f722.remove(39);
if(x310._f722.contains(40))x310._f722.remove(40);
}
});
this.div.onclick=MVUtil._f105(this.div,function(x318)
{
if(x310.mouseDownLoc&&x310.mouseUpLoc&&
(Math.abs(x310.mouseDownLoc.left-x310.mouseUpLoc.left)>1||
Math.abs(x310.mouseUpLoc.top-x310.mouseUpLoc.top)>1))
return ;
if(x310._f564)
{
x310._f564(MVUtil.getEvent(x318));
}
MVUtil.runListeners(x310._f97,MVEvent.MOUSE_CLICK,[MVUtil.getEvent(x318)]);
});
if(!this._f740)
MVUtil.detachEvent(document.body,"mousedown",this._f740);
this._f740=MVUtil._f105(document.body,function()
{
x310._f487=false;
});
MVUtil.attachEvent(document.body,"mousedown",this._f740);
if(x311=="IF")
{
this._f219.onselectstart=MVUtil._f105(this._f219,function()
{
if(x310._f298)
return true;
else
 return false;
});
this._f219.oncontextmenu=MVUtil._f105(this._f219,function(x319)
{
x310._f496(window.event);
if(x310._f720)
{
x310._f720(MVUtil.getEvent(x319));
}
MVUtil.runListeners(x310._f97,MVEvent.MOUSE_RIGHT_CLICK,[MVUtil.getEvent(x319)]);
if(x310._f298)
return true;
else
 return false;
});
if(this._f702)
this._f219.onmousewheel=MVUtil._f105(this._f219,function()
{
return x310._f813(window.event);
});
else
 this._f219.onmousewheel=null;
this._f219.onmousedown=MVUtil._f105(this._f219,function()
{
MVUtil._f174(window.event);
return x310._f351(window.event);
});
this._f219.onmousemove=MVUtil._f105(this._f219,function()
{
return x310._f814(window.event);
});
this._f219.onmouseup=MVUtil._f105(this._f219,function()
{
x310._f487=true;
return x310._f812(window.event);
});
this.div.ondblclick=MVUtil._f105(this.div,function()
{
return x310._f815(window.event);
});
document.body.attachEvent('onmouseup',MVUtil._f105(document.body,function()
{
return x310._f812(window.event);
}));
if(!this._f216)
{
if(!this._f743)
MVUtil.detachEvent(document.body,"keydown",this._f743);
this._f743=MVUtil._f105(document.body,function()
{
return x310._f816(window.event);
});
MVUtil.attachEvent(document.body,"keydown",this._f743);
if(!this._f744)
MVUtil.detachEvent(document.body,"keyup",this._f744);
this._f744=MVUtil._f105(document.body,function()
{
return x310._f817(window.event);
});
MVUtil.attachEvent(document.body,"keyup",this._f744);
var x320=function()
{
x310._f818(window.event);
return false;
}
var x321=function()
{
if(MVUtil._f667==document.body.offsetWidth)
{
MVUtil._f666=0;
x320();
}
else
 {
MVUtil._f668=window.setTimeout(x321,100);
}
}
if(!this._f737)
MVUtil.detachEvent(window,"resize",this._f737);
this._f737=MVUtil._f105(window,function(x322)
{
if(Math.abs(x310._f731-x310._f108())<=3||
Math.abs(x310._f732-x310._f109())<=3)
{
return ;
}
MVUtil._f666++;
MVUtil._f667=document.body.offsetWidth;
if(MVUtil._f666>1)
{
if(MVUtil._f668)
window.clearTimeout(MVUtil._f668);
MVUtil._f668=window.setTimeout(x321,100);
}
});
MVUtil.attachEvent(window,"resize",this._f737);
}
}
else if(x311=="NS")
{
this._f219.oncontextmenu=function(x323)
{
x310._f496(x323);
if(x310._f720)
{
x310._f720(MVUtil.getEvent(x323));
}
MVUtil.runListeners(x310._f97,MVEvent.MOUSE_RIGHT_CLICK,[MVUtil.getEvent(x323)]);
if(x310._f298)
return true;
else
 return false;
};
this._f219.onmousedown=function(x324)
{
x324.stopPropagation();
return x310._f351(x324);
};
this._f219.onmousemove=function(x325)
{
return x310._f814(x325);
};
this._f219.onmouseup=function(x326)
{
x310._f487=true;
return x310._f812(x326);
};
var x327=function(x328)
{
x328.preventDefault();
if(x310._f702)
{
if(x328.detail<0)x310.zoomIn();
else x310.zoomOut();
}
}
if(this._f702)
{
this._f219.addEventListener("DOMMouseScroll",x327,false);
}
else
 this._f219.removeEventListener("DOMMouseScroll",x327,false);
this.div.ondblclick=function(x329)
{
return x310._f815(x329);
};
if(!this._f738)
MVUtil.detachEvent(window.document,"mouseup",this._f738);
this._f738=function(x330)
{
return x310._f812(x330);
};
MVUtil.attachEvent(window.document,"mouseup",this._f738);
if(!this._f216)
{
if(!this._f741)
MVUtil.detachEvent(window.document,"keydown",this._f741);
this._f741=function(x331)
{
return x310._f816(x331);
};
MVUtil.attachEvent(window.document,"keydown",this._f741);
if(!this._f742)
MVUtil.detachEvent(window.document,"keyup",this._f742);
this._f742=function(x332)
{
return x310._f817(x332);
};
MVUtil.attachEvent(window.document,"keyup",this._f742);
if(!this._f737)
MVUtil.detachEvent(window,"resize",this._f737);
this._f737=function(x333)
{
if(Math.abs(x310._f731-x310._f108())<=3||
Math.abs(x310._f732-x310._f109())<=3)
{
return ;
}
x310._f818(x333);
return false;
};
MVUtil.attachEvent(window,"resize",this._f737);
}
}
else if(x311=="SF")
{
this._f219.oncontextmenu=function(x334)
{
x310._f496(x334);
if(x310._f720)
{
x310._f720(MVUtil.getEvent(x334));
}
MVUtil.runListeners(x310._f97,MVEvent.MOUSE_RIGHT_CLICK,[MVUtil.getEvent(x334)]);
if(x310._f298)
return true;
else
 return false;
};
this._f219.onmousedown=function(x335)
{
x335.stopPropagation();
return x310._f351(x335);
};
this._f219.onmousemove=function(x336)
{
return x310._f814(x336);
};
this._f219.onmouseup=function(x337)
{
x310._f487=true;
return x310._f812(x337);
};
var x338=function(x339)
{
x339.preventDefault();
if(x339.detail>0||x339.wheelDelta<0)
x310.zoomOut();
else
 x310.zoomIn();
}
if(this._f702)
this._f219.onmousewheel=x338;
else
 this._f219.onmousewheel=null;
this.div.ondblclick=function(x340)
{
return x310._f815(x340);
};
if(!this._f738)
MVUtil.detachEvent(window.document,"mouseup",this._f738);
this._f738=function(x341)
{
return x310._f812(x341);
};
MVUtil.attachEvent(window.document,"mouseup",this._f738);
if(!this._f216)
{
if(!this._f741)
MVUtil.detachEvent(window.document,"keydown",this._f741);
this._f741=function(x342)
{
return x310._f816(x342);
};
MVUtil.attachEvent(window.document,"keydown",this._f741);
if(!this._f742)
MVUtil.detachEvent(window.document,"keyup",this._f742);
this._f742=function(x343)
{
return x310._f817(x343);
};
MVUtil.attachEvent(window.document,"keyup",this._f742);
if(!this._f737)
MVUtil.detachEvent(window,"resize",this._f737);
this._f737=function(x344)
{
if(Math.abs(x310._f731-x310._f108())<=3||
Math.abs(x310._f732-x310._f109())<=3)
{
return ;
}
x310._f818(x344);
return false;
};
MVUtil.attachEvent(window,"resize",this._f737);
}
}
if(x311=="OS")
{
this._f219.onmousedown=function()
{
window.event.stopPropagation();
return x310._f351(window.event);
};
this._f219.onmousemove=function()
{
return x310._f814(window.event);
};
this._f219.onmouseup=function()
{
x310._f487=true;
return x310._f812(window.event);
};
this.div.ondblclick=function()
{
return x310._f815(window.event);
};
if(!this._f738)
MVUtil.detachEvent(window.document,"mouseup",this._f738);
this._f738=function(x345)
{
return x310._f812(window.event);
};
MVUtil.attachEvent(window.document,"mouseup",this._f738);
if(!this._f216)
{
if(!this._f737)
MVUtil.detachEvent(window,"resize",this._f737);
this._f737=function(x346)
{
if(Math.abs(x310._f731-x310._f108())<=3||
Math.abs(x310._f732-x310._f109())<=3)
{
return ;
}
x310._f818(window.event);
return false;
};
MVUtil.attachEvent(window,"resize",this._f737);
}
this._f219.onkeypress=function()
{
return x310._f816(window.event);
};
this._f219.onkeyup=function()
{
return x310._f817(window.event);
};
}
}
MVMapView.prototype._f813=function(x347)
{
if(x347.wheelDelta>0)this.zoomIn();
else this.zoomOut();
return false;
}
MVMapView.prototype._f818=function(x348)
{
this._f733=false;
this._f20=this.getZoomLevel();
if(this._f20>this._f697)
{
this._f20=this._f697;
return ;
}
MVUtil._f73(this.div,0,0);
MVUtil._f73(this._f291,0,0);
this._f140=0;
this._f141=0;
this._f417=this._f140;
this._f418=this._f141;
this._f747=0;
this._f748=0;
this.setZoomLevel(this._f20);
if(this._f773)
{
if(this.centerMarkUrl)
this.setCenterMark(this.centerMarkUrl,this.centerMarkW,this.centerMarkH);
else
 this.setCenterMark(_f10._f142+"center.gif",20,20);
}
if(this.navigationPanel)
this.navigationPanel.init();
for(lc=0;lc<this._f692.length;lc++)
{
this._f692[lc].setSize(
parseInt(this._f692[lc]._f1._f50*(this._f108())),
parseInt(this._f692[lc]._f1._f51*(this._f109())));
}
this._f250.setSize(Math.ceil(2*(this._f108())),
Math.ceil(2*(this._f109())));
this.display();
if(this._f626)
{
this._f626._f634(this);
}
if(this._f215)
{
this._f215._f206._f818();
this._f215._f222();
}
if(this._f710!=null)
for(var x349=0;x349<this._f710.length;x349++)
{
this._f710[x349]._f594();
}
return false;
}
MVMapView.prototype.getBrowserType=function()
{
return _f10._f69;
}
MVMapView.prototype.enableKeyboardPanning=function(x350)
{
this._f724=x350;
}
MVMapView.prototype._f816=function(x351)
{
if(!this._f487||!this._f724)
return true;
if(this._f819==undefined||this.scroll_up==undefined||this._f820==undefined||this._f821==undefined)
{
this._f819=0;
this.scroll_up=0;
this._f820=0;
this._f821=0;
this._f822=0;
}
var x352=(this.getBrowserType()!="OS")?96:48;
if(!x351.shiftKey)
{
switch(x351.keyCode)
{
case 37:this._f819=1;this._f722.add(x351.keyCode);break;
case 38:this.scroll_up=1;this._f722.add(x351.keyCode);break;
case 39:this._f820=1;this._f722.add(x351.keyCode);break;
case 40:this._f821=1;this._f722.add(x351.keyCode);break;
case x352+1:this._f819=1;this._f821=1;
break;
case x352+2:this._f821=1;this._f722.add(x351.keyCode);
break;
case x352+3:this._f820=1;this._f821=1;
break;
case x352+4:this._f819=1;this._f722.add(x351.keyCode);
break;
case x352+5:break;
case x352+6:this._f820=1;this._f722.add(x351.keyCode);
break;
case x352+7:this._f819=1;this.scroll_up=1;
break;
case x352+8:this.scroll_up=1;this._f722.add(x351.keyCode);
break;
case x352+9:this.scroll_up=1;this._f820=1;
break;
default:return true;
}
this._f823();
return false;
}
else
 return true;
}
MVMapView.prototype._f817=function(x353)
{
if(!this._f487)return;
var x354=(this.getBrowserType()!="OS")?96:48;
if(x353.shiftKey)
{
switch(x353.keyCode)
{
case 37:this._f722.remove(x353.keyCode);
break;
case 38:this._f722.remove(x353.keyCode);break;
case 39:this._f722.remove(x353.keyCode);
break;
case 40:this._f722.remove(x353.keyCode);break;
default:return true;
}
}
else
 {
switch(x353.keyCode)
{
case 33:this.smoothScroll(0,-this._f109()/2);break;
case 34:this.smoothScroll(0,this._f109()/2);break;
case 35:this.smoothScroll(this._f108()/2,0);break;
case 36:this.smoothScroll(-this._f108()/2,0);break;
case 37:this._f722.remove(x353.keyCode);break;
case 38:this._f722.remove(x353.keyCode);
break;
case 39:this._f722.remove(x353.keyCode);
break;
case 40:this._f722.remove(x353.keyCode);break;
case x354+1:this._f819=0;
this._f821=0;
break;
case x354+2:this._f821=0;
this._f722.remove(x353.keyCode);
break;
case x354+3:this._f820=0;
this._f821=0;
break;
case x354+4:this._f819=0;
this._f722.remove(x353.keyCode);
break;
case x354+5:this._f819=0;
this.scroll_up=0;
this._f820=0;
this._f821=0;
break;
case x354+6:this._f820=0;
this._f722.remove(x353.keyCode);
break;
case x354+7:this._f819=0;
this.scroll_up=0;
break;
case x354+8:this.scroll_up=0;
this._f722.remove(x353.keyCode);
break;
case x354+9:this.scroll_up=0;
this._f722.remove(x353.keyCode);
this._f820=0;
break;
case 107:this.zoomIn();break;
case 187:this.zoomIn();break;
case 109:this.zoomOut();break;
case 189:this.zoomOut();break;
case 61:this.zoomIn();
break;
case 43:this.zoomIn();
break;
case 45:this.zoomOut();
break;
case 95:this.zoomOut();
break;
default:return true;
}
}return false;
}
MVMapView.prototype._f824=function(x355)
{
x355=(x355)?x355:((window.event)?event:null);
var x356=x355.clientX+document.body.scrollLeft-this._f219.offsetLeft;
return x356;
}
MVMapView.prototype._f825=function(x357)
{
x357=(x357)?x357:((window.event)?event:null);
var x358=x357.clientY+document.body.scrollTop-this._f219.offsetTop;
return x358;
}
MVMapView.prototype._f224=function(x359)
{
var x360={left:0,top:0};
absolutePosition=MVUtil._f497(this.real_base_div);
var x361=MVUtil._f175(x359);
x360.left=x361.x-absolutePosition.x;
x360.top=x361.y-absolutePosition.y;
return x360;
}
MVMapView.prototype._f351=function(x362)
{
x362=(x362)?x362:((window.event)?event:null);
var x363=this._f224(x362);
this.mouseDownLoc=x363;
if(this._f704&&this._f706)
{
this._f708=true;
}
if(this._f688==false)return;
if(!MVUtil.mouseLeftKeyPressed(x362))
{
return;
}
if((_f10._f69!="SF")&&(_f10._f69.indexOf("OS")!=0)&&
((_f10._f69=="IF"&&x362.button==4)||(_f10._f69!="IF"
&&x362.button==1)))
{
MVUtil._f174(x362);
return false;
}
for(var x364=0;x364<this._f692.length;x364++)
{
if(this._f692[x364]._f52())
{
MVUtil._f164(this._f219,"wait");
}
}
if((_f10._f69.indexOf("OS")==0)&&x362.button==2)
{
_f826();
}
if(this._f691!=null)
{
clearInterval(this._f691);
this._f691=null;
}
this._f178=this;
this._f749(x363.left,x363.top);
this.dragCoords=this._f224(x362);
this._f496(x362);
if(_f10._f362==2)x362.returnValue=false;
if(this._f687)this._f178=null;
this._f827();
this.divLeftOrig=MVUtil._f83(this.div);
this.mapWindowMinXOrig=this._f74;
this.mapWindowMaxYOrig=this._f288;
this.mapCenterXOrig=this._f94;
return false;
}
MVMapView.prototype._f827=function()
{
if(this.fetchingMapId)
{
clearTimeout(this.fetchingMapId);
}
this.fetchingMapId=this.setTimeout("this.fetching()",400);
}
MVMapView.prototype.fetching=function()
{
this._f125();
for(var x365=0;x365<this._f135.length;x365++)
this._f135[x365]._f437();
this._f827();
}
function _f826(x0)
{
x0=(x0)?x0:((window.event)?event:null);
MVUtil._f174(x0);
return false;
}
MVMapView.prototype._f177=function()
{
if(this._f591)
{
this._f591._f177();
}
if(this._f704&&this._f708)
{
this._f705.clear();
this.marqueeZoom();
}
this._f178=null;
MVUtil._f164(this._f219,this._f213);
this._f745=false;
if(this._f81.parentNode==null||(_f10._f69=="IF"&&this._f81.parentNode.tagName!="DIV"))
this.div.appendChild(this._f81);
}
MVMapView.prototype._f814=function(x366)
{
this._f496(MVUtil.getEvent(x366));
MVUtil.runListeners(this._f97,MVEvent.MOUSE_MOVE,[x366]);
if(this._f591)
{
var x367=MVUtil._f175(x366);
this._f591._f73(
this._f591.dragStartLeft+(x367.x-this._f591.dragStartMouseLoc.x),
this._f591.dragStartTop+(x367.y-this._f591.dragStartMouseLoc.y));
if(this._f591._f570)
this._f591._f570(this._f591.getPosition());
MVUtil.runListeners(this._f591._f97,MVEvent.DRAG,[this._f591.getPosition()]);
return ;
}
if(this._f688==false)return;
if(!this._f178||this._f687||!this.draggingEnabled)
return true;
if(!this._f745)
{
this._f745=true;
this.div.removeChild(this._f81);
}
else if(_f10._f69=="IF"&&x366.button!=1)
{
MVUtil._f164(this._f219,this._f213);
this._f812(x366);
return ;
}
this._f588();
var x368=this._f224(x366);
if(this._f713!=this._f212)
{
MVUtil._f164(this._f219,this._f212);
this._f713=this._f212;
}
if(this._f704&&this._f706&&this._f708)
this._f708=false;
this._f196(x368.left,x368.top);
this.dragCoords=x368;
if(this._f215)
{
this._f215._f228(this._f417-this._f140,this._f418-this._f141)
}
if(this._f721)
{
this._f721(this._f417-this._f140,this._f418-this._f141);
}
return false;
}
MVMapView.prototype._f812=function(x369)
{
x369=(x369)?x369:((window.event)?event:null);
this.mouseUpLoc=this.dragCoords;
if(this._f688==false)return;
MVUtil._f164(this._f219,this._f213);
this._f713=this._f213;
if(!this._f178&&!this._f687)return;
this._f177();
if(this.dragCoords)
{
this._f496(this.dragCoords);
this.dragCoords=null;
}
else
 {
this._f496(x369);
}
this._f125();
if(this._f686==true)
{
for(var x370=0;x370<this._f135.length;x370++)
this._f135[x370]._f437();
this._f800();
this._f686=false;
if(this._f215)
{
this._f215._f229();
}
if(this._f719)
{
this._f719();
}
MVUtil.runListeners(this._f97,MVEvent.RECENTER);
if(this._f626)
{
this._f626._f634(this);
}
}
if(this.fetchingMapId!=null)
{
clearTimeout(this.fetchingMapId);
}
this._f763(this._f94,this._f95,this._f20,true);
this._f588();
}
MVMapView.prototype.setDoubleClickAction=function(x371)
{
if(x371==null||(x371!='recenter'&&x371!='zoomin'))
{
MVi18n._f6("MVMapView.setDoubleClickAction","MAPVIEWER-05519","action");
return ;
}
this._f725=x371;
}
MVMapView.prototype._f815=function(x372)
{
x372=(x372)?x372:((window.event)?event:null);
if((this._f97[MVEvent.MOUSE_DOUBLE_CLICK]!=null&&this._f97[MVEvent.MOUSE_DOUBLE_CLICK].length!=0)||this._f396)
{
if(this._f396){
this._f396(MVUtil.getEvent(x372));
}
MVUtil.runListeners(this._f97,MVEvent.MOUSE_DOUBLE_CLICK,[MVUtil.getEvent(x372)]);
return true;
}
if(!this._f216&&this._f725=="zoomin")
{
this.zoomIn(this.getMouseLocation());
return true;
}
if(this._f687)
{
this._f178=null;
this._f219.style.cursor=this._f213;
return true;
}
this._f219.style.cursor=this._f213;
if(this._f691!=null)
{
clearInterval(this._f691);
this._f691=null;
}
var x373=this._f224(x372);
var x374=x373.left;
var x375=x373.top;
this._f764=this._f108()/2-x374;
this._f765=this._f109()/2-x375;
this._f264=Math.sqrt(this._f764*this._f764+this._f765*this._f765);
this._f768=20;
this._f766=this._f108();
this._f767=this._f109();
this._f769=this._f264>((this._f766+this._f767)/4)?300:200;
this._f770=0;
this._f771=0;
this._f772=0;
this.smoothPan();
}
MVMapView.prototype.pan=function(x376,x377)
{
this.smoothScroll(x376,x377);
}
MVMapView.prototype.smoothScroll=function(x378,x379)
{
if(x378==0&&x379==0)
{
return;
}
if(this._f687)
{
this._f178=null;
this._f219.style.cursor=this._f213;
return true;
}
this._f219.style.cursor=this._f213;
if(this._f691!=null)
{
clearTimeout(this._f691);
this._f691=null;
}
this._f764=x378*(-1);
this._f765=x379*(-1);
this._f264=Math.sqrt(x378*x378+x379*x379);
this._f768=10;
this._f766=this._f108();
this._f767=this._f109();
this._f769=this._f264>((this._f766+this._f767)/4)?300:200;
this._f770=0;
this._f771=0;
this._f772=0;
this.smoothPan();
}
MVMapView.prototype.smoothPan=function(x380)
{
if((!this.reCenterTag)&&this._f764==0&&this._f765==0)
return;
this._f770++;
var x381=x380?1:this._f770*this._f768/this._f769;
this.targetX=this._f764*(2*x381-x381*x381);
this.targetY=this._f765*(2*x381-x381*x381);
var x382=this._f766/2;
var x383=this._f767/2;
this._f749(x382,x383);
x382=Math.round(this.targetX-this._f771)+this._f766/2;
x383=Math.round(this.targetY-this._f772)+this._f767/2;
this._f196(x382,x383);
if(this._f215)
{
this._f215._f228(this._f417-this._f140,this._f418-this._f141)
}
if(this._f721)
{
this._f721(this._f417-this._f140,this._f418-this._f141);
}
this._f771=this.targetX;
this._f772=this.targetY;
this._f125();
for(i=0;i<this._f135.length;i++)
this._f135[i]._f437();
if(x381<1.0)
{
this._f691=this.setTimeout("this.smoothPan()",this._f768);
this._f728=true;
}
else
 {
clearTimeout(this._f691);
this._f691=null;
this._f800();
this._f686=false;
if(this._f215)
{
this._f215._f229();
}
if(this._f719)
{
this._f719();
}
MVUtil.runListeners(this._f97,MVEvent.RECENTER);
if(this._f626)
{
this._f626._f634(this);
}
this._f588();
this._f728=false;
return false;
}
}
MVMapView.prototype.smoothMove=function(x384,x385)
{
this.targetX=x384*(-1);
this.targetY=x385*(-1);
var x386=this._f108()/2;
var x387=this._f109()/2;
this._f749(x386,x387);
x386=Math.round(this.targetX+this._f108()/2);
x387=Math.round(this.targetY+this._f109()/2);
this._f196(x386,x387);
if(this._f721)
{
this._f721(this._f417-this._f140,this._f418-this._f141);
}
for(i=0;i<this._f135.length;i++)
this._f135[i]._f437();
}
var _f265=0;
MVMapView.prototype.setTimeout=function(_f149,_f150)
{
var Ie="tempVar"+_f265;
_f265++;
eval(Ie+" = this;");
var oi=_f149.replace(/\\/g,"\\\\");
oi=oi.replace(/\"/g,'\\"');
return window.setTimeout(Ie+'._setTimeoutDispatcher("'+oi+'");'+Ie+" = null;",_f150);
}
MVMapView.prototype._setTimeoutDispatcher=function(func)
{
eval(func);
}
MVMapView.prototype._f823=function(x388,x389)
{
if(!this._f691)
{
this._f691=this.setTimeout("this.arrowScroll()",5)
}
}
MVMapView.prototype.arrowScroll=function()
{
if(this._f687)
{
this._f178=null;
this._f219.style.cursor=this._f213;
return true;
}
this._f219.style.cursor=this._f213;
if(this._f691!=null)
{
clearTimeout(this._f691);
this._f691=null;
}
var x390=(this.getBrowserType()!="OS")?96:48;
if(this._f722.length>0)
{
var x391=((this._f722.contains(37)||this._f722.contains(x390+4))?1:0)+
((this._f722.contains(39)||this._f722.contains(x390+6))?-1:0);
var x392=((this._f722.contains(38)||this._f722.contains(x390+8))?1:0)+
((this._f722.contains(40)||this._f722.contains(x390+2))?-1:0);
this.moveOffsetX=(x391==1?15:0)+(x391==-1?-15:0);
this.moveOffsetY=(x392==1?15:0)+(x392==-1?-15:0);
this._f749(0,0);
this._f196(this.moveOffsetX,this.moveOffsetY);
if(this._f215)
{
this._f215._f228(this._f417-this._f140,this._f418-this._f141)
}
if(this._f721)
{
this._f721(this._f417-this._f140,this._f418-this._f141);
}
for(i=0;i<this._f135.length;i++)
this._f135[i]._f437();
this._f691=this.setTimeout("this.arrowScroll()",5)
}
else
 {
this._f588();
this._f691=null;
this._f125();
this._f800();
this._f686=false;
if(this._f215)
{
this._f215._f229();
}
if(this._f719)
{
this._f719();
}
MVUtil.runListeners(this._f97,MVEvent.RECENTER);
if(this._f626)
{
this._f626._f634(this);
}
}
}
MVMapView.prototype._f828=function(x393){
var x394=this._f224(x393);
var x395=x394.left;
var x396=x394.top;
if(((_f10._f69=="NS"))&&((x395<=0)||(x395>=
this._f108())||(x396<=0)||(x396>=
this._f109()))&&(this._f178))
{
this._f812();
}
}
MVMapView.prototype._f496=function(x397)
{
var x398=MVUtil.getMouseLocation(this,x397);
var x399=x398.sdo_point.x;
var x400=x398.sdo_point.y;
this._f680=x399;
this._f681=x400;
}
MVMapView.prototype._f829=function(x401)
{
this._f687=x401;
}
MVMapView.prototype.enableDragging=function(x402)
{
this.draggingEnabled=x402;
}
function _f723(x0)
{
this.length=0;
if(x0)
{
for(var x1=x0.length-1;x1>=0;--x1)
{
this.add(x0[x1]);
this.length++;
}
}
}
_f723.prototype.add=function(x403)
{
if(!this.contains(x403))
{
this["key"+x403]=1;
this.length++;
}
}
_f723.prototype.remove=function(x404)
{
if(this.exist(x404))
{
delete this["key"+x404];
this.length--;
}
}
_f723.prototype.contains=function(x405)
{
return this["key"+x405]==1;
}
_f723.prototype.exist=function(x406)
{
return this["key"+x406]==1||this["key"+x406]==2;
}
_f723.prototype.sleep=function()
{
for(prop in this)
{
if(typeof this[prop]!="function")
{
this[prop]=2;
}
}
}
_f723.prototype.wakeup=function()
{
for(prop in this)
{
if(typeof this[prop]!="function")
{
this[prop]=1;
}
}
}
MVMapView.prototype.addMapDecoration=function(x407)
{
if(this._f710==null)
this._f710=new Array();
this._f710.push(x407);
if(this._f92)
{
var id="_md_"+this._f711
x407.init(id,this,this._f219);
this._f711++;
x407._f92=true;
if(x407.afterDisAction)
{
x407.afterDisAction();
}
}
}
MVMapView.prototype.removeMapDecoration=function(x408)
{
if(x408==null||x408.id==null||this._f710==null)
{
return;
}
for(var x409=0;x409<this._f710.length;x409++)
if(this._f710[x409].id==x408.id)
{
if(this._f710[x409]._f563)
this._f588();
this._f710[x409]=this._f710[this._f710.length-1]
this._f710.pop();
x408._f223();
var x410=null;
if(x408._f562)
x410=x408._f586;
else
 x410=x408._f561;
x410.onclick=null;
x410.onmouseover=null;
x410.onmouseout=null;
this._f219.removeChild(x410);
MVUtil._f91(x410);
break;
}
}
MVMapView.prototype.addCopyRightNote=function(x411)
{
if(this._f811!=undefined)
{
this._f219.removeChild(this._f811);
delete this._f811;
}
var x412=document.createElement("SPAN");
x412.innerHTML=" "+x411+" ";
x412.style.zIndex=2000;
x412.style.position="absolute";
x412.style.right=MVUtil._f31(-1);
x412.style.bottom=MVUtil._f31(-1);
x412.style.fontSize=12;
x412.style.color="black";
x412.style.backgroundColor="";
this._f219.appendChild(x412);
this._f811=x412;
}
MVMapView.prototype.addOverviewMap=function(x413)
{
if(this._f215==null)
this._f215=x413;
else
 return;
if(this._f92)
this._f215.init(this._f215._f202,this);
}
function _f830(x0,x1,x2,x3,x4,x5)
{
this.div=document.createElement("img");
this.div.src=x1;
this.div.style.position="absolute";
this.div.style.zIndex=x4;
if(x5)
this.div.title=x5;
this.div.style.width=MVUtil._f31(x2);
this.div.style.height=MVUtil._f31(x3);
MVUtil._f146(this.div);
x0.appendChild(this.div);
return this.div;
}
MVMapView.prototype.addNavigationPanel=function(x414,x415,x416,x417,x418)
{
this.navigationPanel=new MVNavigationPanel(x415,x416,x417,x418);
if(!x414)
x414="WEST";
this.navigationPanel._f831=x414;
if(this._f92)
this.navigationPanel.init(this._f219,this);
}
MVMapView.prototype.addScaleBar=function(x419,x420,x421,x422)
{
if(this._f626)
return ;
this._f626=new MVScaleBar(x422);
this._f693=x419||this._f693;
this._f694=x420||this._f694;
this._f695=x421||this._f695;
if(this._f92)
this._f756(this._f626);
}
MVMapView.prototype.setMouseCursorStyle=function(x423,x424)
{
if(x424=="dragging")
this._f212=x423;
else if(x424=="default")
{
this._f213=x423;
MVUtil._f164(this._f219,x423);
}
}
MVMapView.prototype.enableLoadingIcon=function(x425)
{
this._f726=x425;
if(!x425)
this.setLoadingIconVisible(false);
}
MVMapView.prototype.setLoadingIconVisible=function(x426)
{
if(!this._f726)
x426=false;
if(!x426)
{
if(this._f727)
this._f727.style.visibility="hidden";
}
else
 {
if(!this._f727)
{
var x427=document.createElement("img");x427.src=_f10._f142+"loading.gif";
x427.style.zIndex=2001;
x427.style.position="absolute";
var x428=0,x429=0;
if(x427.width)
x428=x427.width;
if(x427.height)
x429=x427.height;
x427.style.left=MVUtil._f31((this._f108()-x428)/2);
x427.style.top=MVUtil._f31((this._f109()-x429)/2);
var x430=this;
x427.onload=function()
{
x427.style.left=MVUtil._f31((x430._f108()-x427.width)/2);
x427.style.top=MVUtil._f31((x430._f109()-x427.height)/2);
x427.onload=null;
};
this._f219.appendChild(x427);
this._f727=x427;
}
else
 {
this._f727.style.left=MVUtil._f31((this._f108()-this._f727.width)/2);
this._f727.style.top=MVUtil._f31((this._f109()-this._f727.height)/2);
this._f727.style.visibility="visible";
}
}
}
MVMapView.prototype.getMapCoordinates=function(x431)
{
return MVSdoGeometry.createPoint(x431.x/this._f75+this._f74,
this._f76-x431.y/this._f77,this.srid);
}
MVMapView.prototype.setDefaultFOIImageFormat=function(x432)
{
if(x432)
this._f67=x432.toUpperCase();
}
MVMapView.prototype._f82=function()
{
var x433=true;
for(var x434=0;x434<this._f692.length;x434++)
{
var x435=this._f692[x434];
if(x435.div&&x435.isVisible()&&x435._f29)
{
x433=false;
break;
}
}
if(x433)
this.setLoadingIconVisible(false);
}
MVMapView.prototype._f797=function(x436)
{
if(!this._f729)
this._f729=new Array();
this._f729.push(x436);
var x437=this;
var x438=function()
{
if(x437._f728)
return ;
clearInterval(x437._f730);
x437._f730=null;
while(x437._f729.length>0)
{
x437.addThemeBasedFOI(x437._f729.shift());
}
}
if(!this._f730)
this._f730=setInterval(x438,50);
}
MVMapView.prototype._f532=function(x439)
{
if(!this._f530)
this._f530=x439;
}
MVMapView.prototype.compareBaseURL=function(x440)
{
if(x440&&x440!=""&&x440.indexOf(this._f4)<0)
return false;
else
 return true;
}
MVMapView.prototype.checkSize=function()
{
clearTimeout(this._f735);
if(!this._f219)
return ;
if(Math.abs(this._f731-this._f108())>3||
Math.abs(this._f732-this._f109())>3)
{
this._f733=true;
this._f734=0.4;
this._f731=this._f108();
this._f732=this._f109();
}
else
 this._f734+=0.4;
if(this._f734>0.4&&this._f733)
{
this._f818();
this._f733=false;
this._f734=0;
}
this._f735=this.setTimeout("this.checkSize()",300);
}
MVMapView.prototype._f157=function(x441,x442)
{
return {x:(x441-this._f94)*this._f75+this._f108()/2,
y:(this._f95-x442)*this._f77+this._f109()/2};
}
MVMapView.prototype.showInfoTip=function(x443,x444)
{
if(this.infoTipDiv)
this.infoTipDiv.parentNode.removeChild(this.infoTipDiv);
this.infoTipDiv=MVUtil._f669(x443);
this.infoTipDiv.id="mv_mrqzm_msg";
this.infoTipDiv.style.border="1px solid #000000";
this.infoTipDiv.style.backgroundColor="#FFFFCC";
this.infoTipDiv.style.position="absolute";
var x445=MVUtil._f647(this,x444);
this.infoTipDiv.style.left=x445.x+"px";
this.infoTipDiv.style.top=x445.y+"px";
this.infoTipDiv.style.zIndex=9999;
this._f219.appendChild(this.infoTipDiv);
};
MVMapView.prototype._f189=function()
{
if(this.infoTipDiv)
{
this.infoTipDiv.parentNode.removeChild(this.infoTipDiv);
this.infoTipDiv=null;
}
};
MVMapView.prototype._f791=function()
{
if(arguments.length<2)
return ;
var x446=new Array();
for(var x447=2;x447<arguments.length;x447++)
x446[x447-2]=arguments[x447];
var x448={obj:arguments[0],func:arguments[1],params:x446};
this._f93.push(x448);
}
MVMapView.addMapTileLayerDefinition=function(x449)
{
var x450=x449.dataSource?x449.dataSource+"."+x449.mapTileLayer:x449.mapTileLayer;
if(x449)
_f10._f535(x450,x449)
}
MVMapView._f7=false;
MVMapView.enableXMLHTTP=function(x451)
{
MVMapView._f7=x451;
}
MVMapView.setProxyPath=function(x452)
{
_f10._f555=x452;
}
MVMapView.setErrorHandler=function(x453)
{
MVi18n.addBehavior("func",x453,"text");
}
MVMapView._f120=true;
MVMapView.enableCodingHints=function(x454)
{
MVMapView._f120=x454;
}
MVMapView._f119=false;
MVMapView.enableTiming=function(x455)
{
MVMapView._f119=x455;
}
MVMapView.debug=false;
MVMapView.enableDebugMode=function(x456)
{
MVMapView.debug=x456;
}
MVMapView._f460=function(x457,x458)
{
var x459=new Array(x458.length);
for(var x460=0;x460<x458.length;x460+=2)
{
var x461=x457(x458[x460],x458[x460+1]);
x459[x460]=x461.x;
x459[x460+1]=x461.y;
}
return x459;
}
MVMapView.prototype.getPixelsPerXUnit=function()
{
var x462=this.msi.mapConfig.zoomLevels[this._f20].tileImageWidth;
var x463=this.msi.mapConfig.zoomLevels[this._f20].tileWidth;
return x462/x463;
}
MVMapView.prototype.getPixelsPerYUnit=function()
{
var x464=this.msi.mapConfig.zoomLevels[this._f20].tileImageHeight;
var x465=this.msi.mapConfig.zoomLevels[this._f20].tileHeight;
return x464/x465;
}
MVMapView.prototype.wrapAroundLayer=function(x466)
{
if(!x466)
return false;
if(this.wraparound)
{
this._f125();
var x467=(x466-
this._f108())*0.5/this._f75;
var x468=this._f74-x467;
var x469=this._f288+x467;
var x470=this.msi._f159;
var x471=this.msi._f158;
var x472=x471-x470;
var x473=0;
if(x468<x470)
{
x473=Math.ceil((x470-x468)/x472);
x468+=x472*x473;
x469+=x472*x473;
x473=0-x473;
}
else if(x468>x471)
{
x473=Math.ceil((x468-x471)/x472);
x468-=x472*x473;
x469-=x472*x473;
}
if(x469>x471)
return true;
}
return false
}
MVMapView.prototype.enableMapWrapAround=function(x474)
{
this.wraparound=x474;
}
MVMapView._f832=0;
MVMapView.prototype._f788=function(x475,x476)
{
if(!x475)
return ;
this._f135.push(x475);
var x477=document.createElement("div");
this._f219.appendChild(x477);
if(!x475.visible)
x477.style.visibility="hidden";
x477.style.zIndex=this._f135.length;
x477.style.position="absolute";
x477.style.zIndex=1;
x477.style.left=MVUtil._f31(0);
x477.style.top=MVUtil._f31(0);
x477.style.width="100%";
x477.style.height="100%";
var x478=document.createElement("img");
x478.src=_f10._f142+"transparent."+(_f10._f69=="IF"?"gif":"png");
x478.style.position="absolute";
x478.style.zIndex=9999;
x478.style.left=MVUtil._f31(0);
x478.style.top=MVUtil._f31(0);
x478.style.width="100%";
x478.style.height="100%";
x477.appendChild(x478);
var x479=this;
x477.ondblclick=function(x480)
{
return x479._f815(x480);
};
var x481=document.createElement("div");
x475.layerDiv=x481;
x481.id="mvexttl_"+MVMapView._f832++;
x481.style.position="absolute";
x481.style.left=MVUtil._f31(0);
x481.style.top=MVUtil._f31(0);
x481.style.width="100%";
x481.style.height="100%";
x477.appendChild(x481);
if(this._f92)
{
x475.setCenterAndZoomLevel(this._f94,this._f95,this._f20);
x475.init(x481);
}
x475.parent=this;
MVMapView.addMapTileLayerDefinition(x475.tileLayerDefinition);
}
MVMapView.prototype._f751=function(x482,x483,x484,x485)
{
for(var x486=0;x486<this._f135.length;x486++)
{
var x487=this._f135[x486];
if(x487.isExtAPITileLayer()&&x487.isVisible())
{
if(x487._f196)
x487._f196(x482,x483);
else
 {
var x488=function(x489)
{
x487.setCenter(x489.getPointX(),x489.getPointY());
}
var x490=MVSdoGeometry.createPoint(x484,x485,this.srid);
this.transformGeom(x490,x487.srid,null,x488);
}
}
}
}
MVMapView.prototype._f504=function(x491,x492,x493,x494,x495)
{
if(!x491.isVisible()&&!x495)
return ;
var x496=function(x497)
{
if(x495)
{
x491._f27=x497.getPointX();
x491._f28=x497.getPointY();
if(x494!=undefined&&x494!=null)
x491._f20=x494;
}
else
 {
if(x491.map)
{
if(x494!=undefined&&x494!=null)
{
x491.resize();
x491.setCenterAndZoomLevel(x497.getPointX(),x497.getPointY(),x494);
}
else
 {
x491.setCenter(x497.getPointX(),x497.getPointY());
}
}
else
 {
x491._f27=x497.getPointX();
x491._f28=x497.getPointY();
if(x494!=undefined&&x494!=null)
x491._f20=x494;
x491.init(x491.layerDiv);
}
}
}
var x498=MVSdoGeometry.createPoint(x492,x493,this.srid);
this.transformGeom(x498,x491.srid,null,x496);
}
MVMapView.prototype._f763=function(x499,x500,x501,x502)
{
for(var x503=0;x503<this._f135.length;x503++)
{
var x504=this._f135[x503];
if(x504.isExtAPITileLayer())
this._f504(x504,x499,x500,x501,x502);
}
}
MVMapView.prototype._f217=function()
{
if(this._f135.length>0)
return this._f135[0];
else
 return null;
}
MVMapView.prototype._f750=function(x505,x506,x507,x508)
{
var x509,x510;
if(this.wraparound||this._f216||!this._f746)
return {left:x506,top:x508};
if(x505==x506)
x509=x506;
else
 {
var x511=(x505-x506)/this._f75;
var x512=(x505<x506);
var x513=this.msi.mapConfig.coordSys.minX;
var x514=this.msi.mapConfig.coordSys.maxX;
var x515=(this.msi.mapConfig.coordSys.minX+this.msi.mapConfig.coordSys.maxX)/2;
var x516=this.msi.mapConfig.coordSys.maxX-this.msi.mapConfig.coordSys.minX;
var x517=this._f288-this._f74;
var x518=this._f94+x511;
var x519=x518-x517/2;
var x520=x518+x517/2;
if(x512)
{
if(x519<x513)
{
if(x517>x516)
{
if(x518<x515)
x518=x515;
}
else
 {
if(this._f74<x513)
x518=this._f94;
else
 x518=x518-(x519-x513);
}
}
}
else
 {
if(x520>x514)
{
if(x517>x516)
{
if(x518>x515)
x518=x515;
}
else
 {
if(this._f288>x514)
x518=this._f94;
else
 x518=x518-(x520-x514);
}
}
}
x511=x518-this._f94;
x509=x505-x511*this._f75;
}
if(x507==x508)
x510=x508;
else
 {
var x521=(x507-x508)/this._f77;
var x522=(x507<x508);
var x523=this.msi.mapConfig.coordSys.minY;
var x524=this.msi.mapConfig.coordSys.maxY;
var x525=(this.msi.mapConfig.coordSys.minY+this.msi.mapConfig.coordSys.maxY)/2;
var x526=this.msi.mapConfig.coordSys.maxY-this.msi.mapConfig.coordSys.minY;
var x527=this._f76-this._f294;
var x528=this._f95-x521;
var x529=x528-x527/2;
var x530=x528+x527/2;
if(!x522)
{
if(x529<x523)
{
if(x527>x526)
{
if(x528<x525)
x528=x525;
}
else
 {
if(this._f294<x523)
x528=this._f95;
else
 x528=x528-(x529-x523);
}
}
}
else
 {
if(x530>x524)
{
if(x527>x526)
{
if(x528>x525)
x528=x525;
}
else
 {
if(this._f76>x524)
x528=this._f95;
else
 x528=x528-(x530-x524);
}
}
}
x521=x528-this._f95;
x510=x507+x521*this._f77;
}
return {left:Math.round(x509),top:Math.round(x510)};
}
MVMapView.prototype._f753=function(x531)
{
if(this.wraparound||this._f216||!this._f746)
return x531;
if(this.originalCenter==null)
this.originalCenter=x531;
if(this.reCenterTag)
this.originalCenter=x531;
else
 x531=this.originalCenter;
this.reCenterTag=false;
var x532=this.msi.mapConfig.coordSys.minX;
var x533=this.msi.mapConfig.coordSys.maxX;
var x534=(this.msi.mapConfig.coordSys.minX+this.msi.mapConfig.coordSys.maxX)/2;
var x535=this.msi.mapConfig.coordSys.maxX-this.msi.mapConfig.coordSys.minX;
var x536=this._f108()/this._f75;
var x537=x531.getPointX();
var x538=x537-x536/2;
var x539=x537+x536/2;
if(x536>x535)
x537=x534;
else
 {
if(x538<x532)
x537=x532+x536/2;
else if(x539>x533)
x537=x533-x536/2;
}
var x540=this.msi.mapConfig.coordSys.minY;
var x541=this.msi.mapConfig.coordSys.maxY;
var x542=(this.msi.mapConfig.coordSys.minY+this.msi.mapConfig.coordSys.maxY)/2;
var x543=this.msi.mapConfig.coordSys.maxY-this.msi.mapConfig.coordSys.minY;
var x544=this._f109()/this._f77;
var x545=x531.getPointY();
var x546=x545-x544/2;
var x547=x545+x544/2;
if(x544>x543)
x545=x542;
else
 {
if(x546<x540)
x545=x540+x544/2;
else if(x547>x541)
x545=x541-x544/2;
}
return MVSdoGeometry.createPoint(x537,x545,this.srid);
}
MVMapView.prototype._f106=function()
{
for(var x548=0;x548<this._f135.length;x548++)
{
if(this._f135[x548].layerControl)
return this._f135[x548].layerControl;
}
return null;
}
function _f299(_f441,x,y,tabs,index,_width,_height,style,_f297,mouseOver,parent,screenLoc,parameters)
{
if(_width==null||_width<0)_width=0;
if(_height==null||_height<0)_height=0;
this._f297=_f297;
if(style!="MVInfoWindowStyle1")
{
if(!_width)
_width=_f10._f300;
if(!_height)
_height=_f10._f301;
eval(style+".init()");
this._f442=eval(style+".createWindow("+x+","+y+","+_width+","+_height+","+parent.parent._f145+")");
_f441.appendChild(this._f442);
}
var close=function(){
if(MVInfoWindowStyle1._f295)
{
clearTimeout(MVInfoWindowStyle1._f295);
MVInfoWindowStyle1._f295=null;
}
MVInfoWindowStyle1.clear();
_f297._f79.deleteInfoWindow(_f441);
}
if(style=="MVInfoWindowStyle1")
{
var _f442=this._f442;
var drawInfoWindow=function()
{
if(MVInfoWindowStyle1.sizeChanged(parent.parent._f145))
{
MVUtil._f128(_f441);
MVInfoWindowStyle1.init(parameters);
_f442=MVInfoWindowStyle1.createWindow(x,y,_width,_height,tabs.length,parent.parent._f145);
MVInfoWindowStyle1.setTitleStyle(tabs,index);
_f441.appendChild(_f442);
MVInfoWindowStyle1.addContent(_f441,tabs);
var x0=document.getElementById("infowindow3table_"+parent.parent._f145);
MVInfoWindowStyle1.getWindowSize(_width,_height,parent.parent._f145);
MVInfoWindowStyle1.removeInActiveTabs(index,parent.parent._f145);
if(x0)
{
if(!isNaN(screenLoc.x))
{
var x1=x0.offsetWidth;var x2=x0.offsetHeight;
var x3=parent.parent._f140;var x4=parent.parent._f141;
var x5=parent.width;var x6=parent.height;
var x7=screenLoc.x;var x8=screenLoc.y;
var x9=true;var x10=true;
if(x3+x7>x5/2)
x9=false;
if(x4+x8<x6/2)
x10=false;
var x11=false;
if(x10)
{
if(x4+x8-MVInfoWindowStyle1._f443-x2>=0)
x8=x8-MVInfoWindowStyle1._f443-x2;
else
 {
x8=-x4+MVInfoWindowStyle1._f443;
x11=true;
}
}
else
 {
if(x4+x8+MVInfoWindowStyle1._f443+x2<=x6)
x8=x8+MVInfoWindowStyle1._f443;
else
 {
x8=x6-x4-MVInfoWindowStyle1._f443-x2;
x11=true;
}
}
if(x9)
{
if(x3+x7+MVInfoWindowStyle1._f443+x1<=x5||x11)
x7=x7+MVInfoWindowStyle1._f443;
else
 x7=x5-x3-MVInfoWindowStyle1._f443-x1;
}
else
 {
if(x3+x7-MVInfoWindowStyle1._f443-x1>=0||x11)
x7=x7-MVInfoWindowStyle1._f443-x1;
else
 x7=-x3+MVInfoWindowStyle1._f443;
}
x0.style.left=MVUtil._f31(x7-screenLoc.x);
x0.style.top=MVUtil._f31(x8-screenLoc.y);
if(!mouseOver)
{
MVInfoWindowStyle1.addCloseButton(close);
MVInfoWindowStyle1._f444(_f441,parent.parent._f145);
}
}
else
 {
if(!mouseOver)
{
MVInfoWindowStyle1.addCloseButton(close);
MVInfoWindowStyle1._f444(_f441,parent.parent._f145);
}
}
}
}
MVInfoWindowStyle1._f295=setTimeout(drawInfoWindow,500);
}
drawInfoWindow();
this._f442=_f442;
}
else
 {
div=this._f445(tabs[0].getContent(),_width);
eval(style+".addContent(div)");
if(!mouseOver)
{
eval(style+".addCloseButton(close)");
}
}
}
_f299.prototype._f445=function(x0,x1)
{
var x2=window.document.createElement("DIV");
x2.className="infowindow";
x2.style.position="absolute";
x2.style.zIndex=3;
x2.innerHTML="<table width="+x1+"px><tr><td > "+x0+"</td></tr></table>";
MVUtil._f164(x2,"auto");
return x2;
}
_f299.prototype._f446=function(){
_f297._f79.deleteInfoWindow(_f180);
}
_f299.prototype._f447=function()
{
if(this._f442){
this._f442.style.display="none";
}
}
_f299.prototype._f448=function()
{
this._f442.style.display="";
this._f442.style.visibility="visible";
}
_f299.prototype.isVisible=function()
{
return this._f442&&this._f442.style.display!="none";
}
function MVSdoGeometry(x0,x1,x2,x3,x4)
{
if(!x0)
MVi18n._f6("MVSdoGeometry.constructor","MAPVIEWER-05519","gtype");
if(x2!=undefined&&x2!=null&&!MVUtil.isNumberArray(x2))
MVi18n._f6("MVSdoGeometry.constructor","MAPVIEWER-05527","sdo_elem_info");
if(x3!=undefined&&x3!=null&&!MVUtil.isNumberArray(x3))
MVi18n._f6("MVSdoGeometry.constructor","MAPVIEWER-05527","sdo_ordinates");
if(x4!=undefined&&x4!=null&&!(x4 instanceof MVSdoPointType))
MVi18n._f6("MVSdoGeometry.constructor","MAPVIEWER-05527","sdo_point");
this.gtype=x0;
this.srid=x1;
if(x4)
{
this.sdo_point=x4;
}
else
 this.sdo_point=null;
this.sdo_elem_info=x2;
this.sdo_ordinates=x3;
this.mbr=null;
}
MVSdoGeometry.prototype.clone=function()
{
return new MVSdoGeometry(this.gtype,this.srid,this.sdo_elem_info,this.sdo_ordinates,this.sdo_point);
}
MVSdoGeometry.prototype.equals=function(x0)
{
if(x0==null)return false;
if(this.gtype!=x0.gtype)return false;
if(this.srid!=x0.srid)return false;
if(!this.array_equals(this.getPoint(),x0.getPoint()))return false;
if(!this.array_equals(this.sdo_elem_info,x0.sdo_elem_info))return false;
if(!this.array_equals(this.sdo_ordinates,x0.sdo_ordinates))return false;
return true;
}
MVSdoGeometry.prototype.getDimensions=function()
{
return parseInt(this.gtype/1000);
}
MVSdoGeometry.prototype.getFirstPoint=function()
{
if(!this.isPoint())return null;
var x1=[];
if(this.sdo_point!=null)
{
x1[0]=this.sdo_point.x;
x1[1]=this.sdo_point.y;
if(this.getDimensions()>2)x1[2]=this.sdo_point.z;
}
else
 {
for(var x2=0;x2<this.getDimensions();x2++)
x1[x2]=this.sdo_ordinates[x2];
}
return x1;
}
MVSdoGeometry.prototype.getLabelPoint=function()
{
if(this.sdo_point==null)return null;
return [this.sdo_point.x,this.sdo_point.y];
}
MVSdoGeometry.prototype.getLastPoint=function()
{
if(!this.isPoint())return null;
var x3=[];
if(this.sdo_point!=null)
{
x3[0]=this.sdo_point.x;
x3[1]=this.sdo_point.y;
if(this.getDimensions()>2)x3[2]=this.sdo_point.z;
}
else
 {
var x4=this.sdo_ordinates.length-this.getDimensions();
for(var x5=0;x5<this.getDimensions();x5++)
x3[x5]=this.sdo_ordinates[x4+x5];
}
return x3;
}
MVSdoGeometry.prototype.getMBR=function()
{
if(!this.mbr)
{
if(this.isPoint())
this.mbr=new Array(this.getPointX(),this.getPointY(),this.getPointX(),this.getPointY());
else
 {
if(this.sdo_ordinates)
{
var x6;var x7;var x8;var x9;
for(var x10=0;x10<this.sdo_ordinates.length;x10+=2)
{
if(!x6)
{
x6=this.sdo_ordinates[x10];
x8=x6;
x7=this.sdo_ordinates[x10+1];
x9=x7;
}
else
 {
if(this.sdo_ordinates[x10]<x6)
x6=this.sdo_ordinates[x10];
else if(this.sdo_ordinates[x10]>x8)
x8=this.sdo_ordinates[x10];
if(this.sdo_ordinates[x10+1]<x7)
x7=this.sdo_ordinates[x10+1];
else if(this.sdo_ordinates[x10+1]>x9)
x9=this.sdo_ordinates[x10+1];
}
}
this.mbr=new Array(x6,x7,x8,x9);
}
}
}
return this.mbr;
}
MVSdoGeometry.prototype.getNumPoints=function()
{
if(this.isPoint())return 1;
else return this.sdo_ordinates.length/this.getDimensions();
}
MVSdoGeometry.prototype.getOrdinates=function()
{
if(this.getGType()==1&&this.sdo_point)
return [this.sdo_point.x,this.sdo_point.y];
else
 return this.sdo_ordinates;
}
MVSdoGeometry.prototype.getOrdinatesOfElements=function()
{
var x11=[];
var x12=[];
if(this.sdo_elem_info.length==3)
{
x11[0]=this.sdo_ordinates;
}
else
 {
for(var x13=0;x13<(this.sdo_elem_info.length-3)/3;x13++)
{
var x14=this.sdo_elem_info[3*x13]-1;
var x15=this.sdo_elem_info[3*(x13+1)]-this.sdo_elem_info[3*x13];
for(var x16=0;x16<x15;x16++)
{
x12[x16]=this.sdo_ordinates[x14+x16];
}
x11[x13]=x12;
x12=[];
}
for(var x16=this.sdo_elem_info[this.sdo_elem_info.length-3]-1;x16<this.sdo_ordinates.length;x16++)
{
x12[x16-this.sdo_elem_info[this.sdo_elem_info.length-3]+1]=this.sdo_ordinates[x16];
}
x11[x13]=x12;
}
return x11;
}
MVSdoGeometry.prototype.getPoint=function()
{
if(!this.isPoint())return null;
return this.getFirstPoint();
}
MVSdoGeometry.prototype.getGType=function()
{
return parseInt(this.gtype%10);
}
MVSdoGeometry.prototype.setSrid=function(x17)
{
this.srid=x17;
}
MVSdoGeometry.prototype.isPoint=function()
{
return this.getGType()==1;
}
MVSdoGeometry.prototype.isCircle=function()
{
return this.sdo_elem_info&&this.sdo_elem_info.length==3&&
this.sdo_elem_info[0]==1&&this.sdo_elem_info[1]==1003&&this.sdo_elem_info[2]==4;
}
MVSdoGeometry.prototype.getPointX=function()
{
if(!this.isPoint())return null;
return this.getFirstPoint()[0];
}
MVSdoGeometry.prototype.getPointY=function()
{
if(!this.isPoint())return null;
return this.getFirstPoint()[1];
}
MVSdoGeometry.prototype.toString=function()
{
var x18="SdoGeometry(";
x18+=this.gtype+",";
x18+=this.srid+",";
x18+=this.sdo_point+",";
if(!this.isPoint()&&this.sdo_elem_info!=null)
x18+="("+this.sdo_elem_info+"),";
else
 x18+=",";
if(!this.isPoint()&&this.sdo_ordinates!=null)
x18+="("+this.sdo_ordinates+"))";
else
 x18+=")";
return x18;
}
MVSdoGeometry.prototype.array_equals=function(x19,x20)
{
if(x19==null&&x20==null)return true;
if(x19==null||x20==null)return false;
if(x19.length!=x20.length)return false;
for(var x21=0;x21<x19.length;x21++)
{
if(x19[x21]!=x20[x21])return false;
}
return true;
}
MVSdoGeometry.createPoint=function(x22,x23,x24)
{
if(!MVUtil.isNumber(x22))
{
MVi18n._f6("MVSdoGeometry.createPoint","MAPVIEWER-05527","x");
return null;
}
if(!MVUtil.isNumber(x23))
{
MVi18n._f6("MVSdoGeometry.createPoint","MAPVIEWER-05527","y");
return null;
}
return new MVSdoGeometry(2001,x24,null,null,new MVSdoPointType(x22,x23,null));
}
MVSdoGeometry.createLineString=function(x25,x26)
{
if(!MVUtil.isNumberArray(x25))
{
MVi18n._f6("MVSdoGeometry.createLineString","MAPVIEWER-05527","ordinatesArray");
return null;
}
return new MVSdoGeometry(2002,x26,[1,2,1],x25,null);
}
MVSdoGeometry.createPolygon=function(x27,x28)
{
if(!MVUtil.isNumberArray(x27))
{
MVi18n._f6("MVSdoGeometry.createPolygon","MAPVIEWER-05527","ordinatesArray");
return null;
}
if(x27.length<=2)
return null;
if(x27[0]!=x27[x27.length-2]&&
x27[1]!=x27[x27.length-1])
{
x27.push(x27[0]);
x27.push(x27[1]);
}
return new MVSdoGeometry(2003,x28,[1,1003,1],x27,null);
}
MVSdoGeometry.createRectangle=function(x29,x30,x31,x32,x33)
{
if(!MVUtil.isNumber(x29))
{
MVi18n._f6("MVSdoGeometry.createRectangle","MAPVIEWER-05527","minX");
return null;
}
if(!MVUtil.isNumber(x31))
{
MVi18n._f6("MVSdoGeometry.createRectangle","MAPVIEWER-05527","maxX");
return null;
}
if(!MVUtil.isNumber(x30))
{
MVi18n._f6("MVSdoGeometry.createRectangle","MAPVIEWER-05527","minY");
return null;
}
if(!MVUtil.isNumber(x32))
{
MVi18n._f6("MVSdoGeometry.createRectangle","MAPVIEWER-05527","maxY");
return null;
}
var x34;
if(x29>x31)
{
x34=x31;
x31=x29;
x29=x34;
}
if(x30>x32)
{
x34=x32;
x32=x30;
x30=x34;
}
return new MVSdoGeometry(2003,x33,[1,1003,1],[x29,x30,x29,x32,x31,x32,x31,x30,x29,x30],null);
}
MVSdoGeometry.createRectangleByGCD=function(x35,x36,x37,x38,x39)
{
if(!MVUtil.isNumber(x35))
{
MVi18n._f6("MVSdoGeometry.createRectangleByGCD","MAPVIEWER-05527","minLon");
return null;
}
if(!MVUtil.isNumber(x36))
{
MVi18n._f6("MVSdoGeometry.createRectangleByGCD","MAPVIEWER-05527","minLat");
return null;
}
if(!MVUtil.isNumber(x37))
{
MVi18n._f6("MVSdoGeometry.createRectangleByGCD","MAPVIEWER-05527","width");
return null;
}
if(!MVUtil.isNumber(x38))
{
MVi18n._f6("MVSdoGeometry.createRectangleByGCD","MAPVIEWER-05527","height");
return null;
}
if(!x39)
x39=8307;
var x40=_f363._f365(new MVSdoPointType(x35,x36,0),x38,0);
var x41=_f363._f365(new MVSdoPointType(x35,x36,0),x37,Math.PI/2);
var x42=x35;var x43=x36;var x44=x41.x;var x45=x40.y;
return new MVSdoGeometry(2003,x39,[1,1003,1],[x42,x43,x42,x45,x44,x45,x44,x43,x42,x43],null);
}
MVSdoGeometry.createCircle=function(x46,x47,x48,x49)
{
if(!MVUtil.isNumber(x46))
{
MVi18n._f6("MVSdoGeometry.createCircle","MAPVIEWER-05527","cx");
return null;
}
if(!MVUtil.isNumber(x47))
{
MVi18n._f6("MVSdoGeometry.createCircle","MAPVIEWER-05527","cy");
return null;
}
if(!MVUtil.isNumber(x48))
{
MVi18n._f6("MVSdoGeometry.createCircle","MAPVIEWER-05527","radius");
return null;
}
return new MVSdoGeometry(2003,x49,[1,1003,4],[x46+x48,x47,x46,x47+x48,x46-x48,x47],null);
}
MVSdoGeometry.createCirclePolygon=function(x50,x51,x52,x53)
{
if(!MVUtil.isNumber(x50))
{
MVi18n._f6("MVSdoGeometry.createCirclePolygon","MAPVIEWER-05527","cx");
return null;
}
if(!MVUtil.isNumber(x51))
{
MVi18n._f6("MVSdoGeometry.createCirclePolygon","MAPVIEWER-05527","cy");
return null;
}
if(!MVUtil.isNumber(x52))
{
MVi18n._f6("MVSdoGeometry.createCirclePolygon","MAPVIEWER-05527","radius");
return null;
}
if(!x53)
x53=8307;
var x54=new Array();
for(i=0;i<36;i++)
{
var x55=i*Math.PI/18;
x54[i*2]=x50+x52*Math.cos(x55);
x54[i*2+1]=x51+x52*Math.sin(x55);
}
x54[72]=x54[0];
x54[73]=x54[1];
return new MVSdoGeometry(2003,x53,[1,1003,1],x54,null);
}
MVSdoGeometry.createGeodeticCirclePolygon=function(x56,x57,x58,x59)
{
if(!MVUtil.isNumber(x56))
{
MVi18n._f6("MVSdoGeometry.createGeodeticCirclePolygon","MAPVIEWER-05527","longitude");
return null;
}
if(!MVUtil.isNumber(x57))
{
MVi18n._f6("MVSdoGeometry.createGeodeticCirclePolygon","MAPVIEWER-05527","latitude");
return null;
}
if(!MVUtil.isNumber(x58))
{
MVi18n._f6("MVSdoGeometry.createGeodeticCirclePolygon","MAPVIEWER-05527","radius");
return null;
}
if(!x59)
x59=8307;
var x60=new Array();
for(i=0;i<36;i++)
{
var x61=_f363._f365(new MVSdoPointType(x56,x57,0),x58,i*Math.PI/18);
x60[i*2]=x61.x;
x60[i*2+1]=x61.y;
}
x60[72]=x60[0];
x60[73]=x60[1];
return new MVSdoGeometry(2003,x59,[1,1003,1],x60,null);
}
MVSdoGeometry.createPointAtBearing=function(x62,x63,x64,x65,x66)
{
if(!MVUtil.isNumber(x62))
{
MVi18n._f6("MVSdoGeometry.createPointAtBearing","MAPVIEWER-05527","longitude");
return null;
}
if(!MVUtil.isNumber(x63))
{
MVi18n._f6("MVSdoGeometry.createPointAtBearing","MAPVIEWER-05527","latitude");
return null;
}
if(!MVUtil.isNumber(x64))
{
MVi18n._f6("MVSdoGeometry.createPointAtBearing","MAPVIEWER-05527","bearing");
return null;
}
if(!MVUtil.isNumber(x65))
{
MVi18n._f6("MVSdoGeometry.createPointAtBearing","MAPVIEWER-05527","distance");
return null;
}
if(!x66)
x66=8307;
var x67=_f363._f365(new MVSdoPointType(x62,x63,0),x65,x64);
return MVSdoGeometry.createPoint(x67.x,x67.y,x66);
}
MVSdoGeometry.prototype.getRequestURL=function(x68)
{
var x69=String(document.location);
if(!x68)
x68=_f10._f454();
var x70="";
if(MVMapView._f7&&MVUtil._f8(x69)!=MVUtil._f8(x68))
x70=_f10._f11()+"?rtarget="+x68+"&";
else
 x70=x68+"?";
return x70;
}
MVSdoGeometry.prototype.getLength=function(unit,_f398,foiURL,callBack,dataSource)
{
if(!dataSource)
dataSource=_f10._f456();
if(!this.srid)
{
var len=MVSdoGeometry.calcLength(this.sdo_ordinates);
if(callBack)
callBack(len);
return len;
}
var srs=_f10._f457(this.srid);
var clientTransFunc=null;
if(_f398)
clientTransFunc=_f10._f458(this.srid,8307);
if(!_f398||this.srid==8307||this.srid==8265||
_f398&&clientTransFunc)
{
if((srs||this.srid==8307||this.srid==8265||_f398&&clientTransFunc)&&
(this.gtype%10==2||this.gtype%10==3)&&
this.sdo_elem_info.length==3&&this.sdo_elem_info[0]==1&&
(this.sdo_elem_info[1]==2||this.sdo_elem_info[1]==1003||this.sdo_elem_info[1]==2003)&&
this.sdo_elem_info[2]==1)
{
var convFactor=0;
if(!unit||unit=="")
convFactor=1;
else
 {
convFactor=_f10._f459(unit);
if(srs&&srs.distConvFactor&&!_f398)
convFactor=convFactor/srs.distConvFactor;
}
var ordinates=this.sdo_ordinates;
if(clientTransFunc)
ordinates=MVMapView._f460(clientTransFunc,ordinates);
if(convFactor)
{
var len=0;
if(srs&&srs.type!='GEODETIC'&&!_f398)
len=MVSdoGeometry.calcLength(ordinates)/convFactor;
else
 len=_f363._f369(ordinates)/convFactor;
if(callBack)
callBack(len);
return len;
}
}
}
var request=null;
var _f461;
var _f462=MVUtil._f48(this.toString(),"null","");
if(this.gtype%10!=2&&this.gtype%10!=6&&this.gtype%10!=3&&this.gtype%10!=7)
{
MVi18n._f6("MVSdoGeometry.getLength","MAPVIEWER-05513");
return 0;
}
else
 {
_f462=MVUtil._f48(_f462," ","");
}
var _f455=this.getRequestURL(foiURL);
var localDomain=(_f455.indexOf(_f10._f11())<0&&
MVUtil._f8(_f455)==MVUtil._f8(_f10._f118()));
var xmlHttp=localDomain||MVMapView._f7;
if(!xmlHttp&&!callBack)
{
MVi18n._f6("MVSdoGeometry.getLength","MAPVIEWER-05521");
return -1;
}
_f455+="request=getlength&version=1.1&figord="+_f462+"";
if(unit)
{
_f455=_f455+"&unit="+unit;
}
if(_f398)
{
var trans=(_f398==true)?"yes":"no";
_f455=_f455+"&togeodetic="+trans;
}
if(dataSource)
_f455=_f455+"&datasource="+dataSource;
var request=null;
var respLoaded=function()
{
if(request.readyState==4)
{
if(request.status==200)
{
var resp=xmlHttp?request.responseText:this.responseText;
try
{
eval("var result="+resp);
_f461=result;
if(result.length==0)
{
result=null;
return;
}
result=null;
}
catch(e)
{
MVi18n._f6("MVSdoGeometry.getLength","MAPVIEWER-05523",resp+"\n"+e);
return ;
}
if(callBack)
callBack(_f461);
if(xmlHttp)
return _f461;
}
}
};
try
{
request=MVUtil.getXMLHttpRequest(xmlHttp);
if(callBack||!xmlHttp)
request.onreadystatechange=respLoaded;
request.open("POST",encodeURI(_f455),callBack||!xmlHttp);
request.send("");
}catch(e)
{
MVi18n._f6("MVSdoGeometry.getLength","MAPVIEWER-05511",e);
}
if(!callBack&&xmlHttp)
{
if(request.status==200)
{
return respLoaded();
}
}
}
MVSdoGeometry.prototype.getArea=function(unit,_f398,foiURL,callBack,dataSource)
{
if(!dataSource)
dataSource=_f10._f456();
var request=null;
var _f461;
var _f462=MVUtil._f48(this.toString(),"null","");
if(this.gtype%10!=3&&this.gtype%10!=7)
{
MVi18n._f6("MVSdoGeometry.getArea","MAPVIEWER-05513");
return 0;
}
else
 {
_f462=MVUtil._f48(_f462," ","");
}
var _f455=this.getRequestURL(foiURL);
var localDomain=(_f455.indexOf(_f10._f11())<0&&
MVUtil._f8(_f455)==MVUtil._f8(_f10._f118()));
var xmlHttp=localDomain||MVMapView._f7;
if(!xmlHttp&&!callBack)
{
MVi18n._f6("MVSdoGeometry.getArea","MAPVIEWER-05521")
return -1;
}
_f455+="request=getarea&version=1.1&figord="+_f462+"";
if(unit)
{
_f455=_f455+"&unit="+unit;
}
if(_f398)
{
var trans=(_f398==true)?"yes":"no";
_f455=_f455+"&togeodetic="+trans;
}
if(dataSource)
_f455=_f455+"&datasource="+dataSource;
var request=null;
var respLoaded=function()
{
if(request.readyState==4)
{
if(request.status==200)
{
var resp=xmlHttp?request.responseText:this.responseText;
try
{
eval("var result="+resp);
_f461=result;
if(result.length==0)
{
result=null;
return;
}
result=null;
}
catch(e)
{
MVi18n._f6("MVSdoGeometry.getArea","MAPVIEWER-05523",resp+"\n"+e);
}
if(callBack)
callBack(_f461);
if(xmlHttp)
return _f461;
}
}
};
try
{
request=MVUtil.getXMLHttpRequest(xmlHttp);
if(callBack||!xmlHttp)
request.onreadystatechange=respLoaded;
request.open("POST",encodeURI(_f455),callBack||!xmlHttp);
request.send("");
}catch(e)
{
MVi18n._f6("MVSdoGeometry.getArea","MAPVIEWER-05511",e);
}
if(!callBack&&xmlHttp)
{
if(request.status==200)
{
return respLoaded();
}
}
}
MVSdoGeometry.prototype.densify=function()
{
var x71=this.getGType();
if(x71<=1||x71==5)
return this;
var x72=_f10._f457(this.srid);
if(this.srid!=8307&&this.srid!=8265&&(!x72||x72.type!='GEODETIC'))
return this;
if(!this.sdo_elem_info||this.sdo_elem_info.length<3||!this.sdo_ordinates)
return this;
var x73=this.sdo_point?this.sdo_point.clone():null;
var x74=this.sdo_elem_info.slice();
var x75=this.sdo_ordinates;
var x76=this.getComponents(x74,x75);
if(x76==null||x76.length<=0)
return null;
var x77=null;
for(var x78=0;x78<x76.length;x78++)
{
var x79=this.densifyComponent(x76[x78].elem_info,x76[x78].ordinates);
if(x78==0)
x77=x79.ordinates;
else
 {
x74[x78*3]=x77.length+1;
x77=x77.concat(x79.ordinates);
}
}
return new MVSdoGeometry(this.gtype,this.srid,x74,x77,x73);
}
MVSdoGeometry.prototype.getComponents=function(x80,x81)
{
if(!x80||x80.length<3||!x81)
return {elem_info:x80,sdo_ordinates:x81};
var x82=new Array();
var x83=0;
for(var x84=0;x84<x80.length/3;x84++)
{
var x85=x81.length;
if(x84+1<x80.length/3)
x85=x80[(x84+1)*3]-1;
var x86=null;
if(x80[x84*3+1]%10==3&&x80[x84*3+2]==3)
{
x80[x84*3+2]=1;
var x86=new Array();
x86.push(x81[x83+0]);
x86.push(x81[x83+1]);
x86.push(x81[x83+0]);
x86.push(x81[x83+3]);
x86.push(x81[x83+2]);
x86.push(x81[x83+3]);
x86.push(x81[x83+2]);
x86.push(x81[x83+1]);
x86.push(x81[x83+0]);
x86.push(x81[x83+1]);
}
else
 x86=x81.slice(x83,x85);
var x87={elem_info:x80.slice(x84*3,x84*3+3),
ordinates:x86};
x82.push(x87);
x83=x85;
}
return x82;
}
MVSdoGeometry.prototype.densifyComponent=function(x88,x89)
{
var x90=x88[1]%10;
var x91={elem_info:x88,ordinates:x89};
switch(x90)
{
case 0:
case 1:
break;
case 2:case 3:if(x88[2]==1)x91={elem_info:x88,ordinates:this.densifyOrdinates(x89)};
break;
default:
break;
}
return x91;
}
MVSdoGeometry.prototype.densifyOrdinates=function(x92)
{
if(!x92||x92.length<4)
return x92;
var x93=new Array();
for(var x94=0;x94<x92.length-2;x94+=2)
{
var x95=x92[x94];
var x96=x92[x94+1];
var x97=x92[x94+2];
var x98=x92[x94+3];
var x99=x97-x95;
var x100=x98-x96;
var x101=Math.ceil(Math.abs(x99));
x99=x99*1.0/x101;
x100=x100*1.0/x101;
x93.push(x95);
x93.push(x96);
for(var x102=0;x102<x101-1;x102++)
{
x95+=x99;
x96+=x100;
x93.push(x95);
x93.push(x96);
}
}
x93.push(x92[x92.length-2]);
x93.push(x92[x92.length-1]);
return x93;
}
MVSdoGeometry.prototype.toGML=function()
{
var x103=this.getGType();
var x104=""
switch(x103%10)
{
case 1:
x104=this._f463(this.getOrdinates());
break;
case 2:
x104=this._f464(this.getOrdinates());
break;
case 3:
if(this.sdo_elem_info[2]==4)
x104=this._f465(this.getOrdinates());
else
 x104=this._f466(this.getOrdinates());
break;
case 4:
break;
case 5:
x104=this._f463(this.getOrdinates());
break;
case 6:
x104=this._f467();
break;
case 7:
x104=this._f468();
break;
}
return x104;
}
MVSdoGeometry.prototype._f463=function(x105)
{
var x106=MVSdoGeometry._f469(x105);
var x107="<Point srsName=\"SDO:"+this.srid+"\" ><coordinates>";
x107=x107+x106+"</coordinates></Point>";
return x107;
}
MVSdoGeometry.prototype._f464=function(x108)
{
var x109=MVSdoGeometry._f469(x108);
var x110="<LineString srsName=\"SDO:"+this.srid+"\" ><coordinates>";
x110=x110+x109+"</coordinates></LineString>"
return x110;
}
MVSdoGeometry.prototype._f466=function(x111)
{
var x112=MVSdoGeometry._f469(x111);
var x113="<Polygon srsName=\"SDO:"+this.srid+"\" ><outerBoundaryIs><LinearRing><coordinates>";
x113=x113+x112+"</coordinates></LinearRing></outerBoundaryIs></Polygon>"
return x113;
}
MVSdoGeometry.prototype._f468=function()
{
var x114=this.getOrdinatesOfElements();
var x115="<MULTIPOLYGON srsName=\"SDO:"+this.srid+"\" >";
for(var x116=0;x116<x114.length;x116++)
{
x115=x115+"<polygonMember>";
x115=x115+this._f466(x114[x116]);
x115=x115+"</polygonMember>";
}
x115=x115+"</MULTIPOLYGON>";
return x115;
}
MVSdoGeometry.prototype._f467=function()
{
var x117=this.getOrdinatesOfElements();
var x118="<MultiLineString srsName=\"SDO:"+this.srid+"\" >";
for(var x119=0;x119<x117.length;x119++)
{
x118=x118+"<lineStringMember>";
x118=x118+this._f464(x117[x119]);
x118=x118+"</lineStringMember>";
}
x118=x118+"</MultiLineString>";
return x118;
}
MVSdoGeometry.prototype._f465=function(x120)
{
var x121=parseFloat(x120[2]);
var x122=parseFloat(x120[1]);
var x123=parseFloat(x120[0])-parseFloat(x120[2]);
var x124="";
var x125=2*Math.PI;
var x126=x121+x123*Math.cos((x125*0)/120);
for(var x127=1;x127<120;x127++)
{
if(x127%2==0)
{
x124=x121+x123*Math.cos((x125*x127)/120);
x126+=" "+x124;
}
else
 {
x124=x122+x123*Math.sin((x125*x127)/120);
x126+=","+x124;
}
}
var x128="<Polygon srsName=\"SDO:"+this.srid+"\" ><outerBoundaryIs><LinearRing><coordinates>";
x128+=x126+"</coordinates></LinearRing></outerBoundaryIs></Polygon>";
return x128;
}
MVSdoGeometry._f469=function(x129)
{
var x130=0;
var x131="";
for(;x130<x129.length;x130+=2)
{
if(x130>0)
x131+=" ";
x131+=x129[x130+0]+","+x129[x130+1];
}
return x131;
}
MVSdoGeometry.getDistance=function(x132,x133,x134,x135,x136,x137,x138,x139,x140)
{
if(!MVUtil.isNumber(x132))
{
MVi18n._f6("MVSdoGeometry.getDistance","MAPVIEWER-05527","x1");
return null;
}
if(!MVUtil.isNumber(x133))
{
MVi18n._f6("MVSdoGeometry.getDistance","MAPVIEWER-05527","y1");
return null;
}
if(!MVUtil.isNumber(x134))
{
MVi18n._f6("MVSdoGeometry.getDistance","MAPVIEWER-05527","x2");
return null;
}
if(!MVUtil.isNumber(x135))
{
MVi18n._f6("MVSdoGeometry.getDistance","MAPVIEWER-05527","y2");
return null;
}
var x141=new Array(x132,x133,x134,x135);
var x142=MVSdoGeometry.createLineString(x141,x136);
return x142.getLength(x137,x138,x139,x140);
}
MVSdoGeometry.calcLength=function(x143)
{
var x144=0,x145=2;
if(x143&&x143.length>3)
{
for(;x145<x143.length;x145+=2)
{
var x146=x143[x145]-x143[x145-2];
var x147=x143[x145+1]-x143[x145-1];
x144+=Math.sqrt(x146*x146+x147*x147);
}
return x144;
}
else
 return 0;
}
MVSdoGeometry.calcPolygonArea=function(x148,x149)
{
if(x148&&x148.length>=4)
{
var x150=0;
var x151=x148.length/2;
var x152;
for(x152=1;x152+1<x151;x152++)
{
var x153=x148[x152*2]-x148[0];
var x154=x148[x152*2+1]-x148[1];
var x155=x148[x152*2+2]-x148[0];
var x156=x148[x152*2+3]-x148[1];
var x157=x153*x156-x155*x154;
x150+=x157;
}
return Math.abs(x157/2.0);
}
else
 return 0;
}
function MVSdoPointType(x0,x1,x2)
{
if(!MVUtil.isNumber(x0))
MVi18n._f6("MVSdoPointType.constructor","MAPVIEWER-05527","x");
if(!MVUtil.isNumber(x1))
MVi18n._f6("MVSdoPointType.constructor","MAPVIEWER-05527","y");
this.x=x0;
this.y=x1;
this.z=x2;
}
MVSdoPointType.prototype.toString=function()
{
var x158="SdoPointType( ";
x158+=this.x+", ";
x158+=this.y+", ";
x158+=this.z+" )";
return x158;
}
MVSdoPointType.prototype.clone=function()
{
var x159=new MVSdoPointType(this.x,this.y,this.z);
}
function MVOverviewMap(x0,x1,x2)
{
if(x0&&!x0.style)
{
if(x1)
x2=x1;
x1=x0;
}
this.type="MVOverviewMap";
this._f203=true;
this._f202=x0?x0:null;
this._f204=null;
this._f205=x1;
this._f206=null;
this.overviewMapTileLayer=x2;
this._f207=false;
this._f208=0;
this._f209=0;
this.coords=null;
this._f210=false;
this._f211=false;
this.borderStyle="2px solid red";
this.backgroundColor="red";
this._f212=null;
this._f213=null;
this._f214=null;
}
MVOverviewMap.prototype.init=function(x0,x1)
{
x1._f215=this;
if(x0)
this._f202=x0;
this._f202._f216=true;
this._f204=x1;
var x2=this._f204.getZoomLevel()-this._f205;
if(x2<0)
x2=0;
this._f206=new MVMapView(this._f202,this._f204._f4);
if(x1.wraparound)
this._f206.wraparound=true;
this._f206.enableLoadingIcon(false);
if(this._f213)
this._f206.setMouseCursorStyle(this._f213,"default");
if(this._f212)
this._f206.setMouseCursorStyle(this._f212,"dragging");
if(this.overviewMapTileLayer==null)
{
this.overviewMapTileLayer=this._f204._f217().clone();
}
this._f218=document.createElement("div");
this._f206._f219.appendChild(this._f218);
this._f218.style.zIndex=10000;
var x3=this;
var x4=function(x5,x6)
{
if(!x3._f211)
{
x3._f218.style.left=(parseInt(x3._f218.style.left)-x5)+"px";
x3._f218.style.top=(parseInt(x3._f218.style.top)-x6)+"px";
}
}
var x7=function(x8,x9)
{
var x10=x8-x9;
if(x9>x8&&x3._f204._f220)
{
x3._f206._f220=false;
x3._f204.setZoomLevel(MVOverviewMap._f221(x3._f204.getZoomLevel()-x10));
x3._f222();
}
else if(x9<x8&&x3._f204._f220)
{
x3._f206._f220=false;
if(x3._f204.getZoomLevel()-x8==x3._f205){
x3._f204.setZoomLevel(MVOverviewMap._f221(x3._f204.getZoomLevel()-x10));
}
else{
x3._f204.setZoomLevel(MVOverviewMap._f221(x8-x10+x3._f205));
}
x3._f222();
}
x3._f204._f220=true;
}
var x11=function()
{
if(!x3._f211)
{
x3._f210=true;
x3._f204.setCenter(x3._f206.getCenter());
x3._f222();
}
x3._f211=false;
}
this._f206.setEventListener(MVEvent.RECENTER,x11);
this._f206.addEventListener(MVEvent.ZOOM_LEVEL_CHANGE,x7);
var x12=function()
{
var x13=x3._f204.getCenter();
x3._f206.setCenter(x13);
x3._f206.setZoomLevel(MVOverviewMap._f221(x2));
x3._f206._f216=true;
function setRectangle()
{
x3._f222();
}
x3._f206.setEventListener(MVEvent.INITIALIZE,setRectangle);
x3._f206.display();
}
var x14=this.overviewMapTileLayer;
if(x14.getType&&x14.getType()=='MVExternalAPIMapTileLayer')
{
if(x14.hideCopyRights)
x14.initializeListener=function(){x14.hideCopyRights();};
}
this._f206.addMapTileLayer(this.overviewMapTileLayer,x12);
}
MVOverviewMap.prototype.addOverviewMapTileLayer=function()
{
this.overviewMapTileLayer=this._f204._f217().clone();
this._f206.addMapTileLayer(this.overviewMapTileLayer);
}
MVOverviewMap.prototype._f223=function()
{
this.destroy();
}
MVOverviewMap.prototype.destroy=function()
{
if(this._f204)
this._f204._f215=null;
if(this._f206)
this._f206.destroy();
MVUtil._f133(this._f202);
this._f206=null;
}
MVOverviewMap.prototype._f222=function()
{
var x15=this._f204.getMapWindowBBox();
var x16=this._f206.getMapWindowBBox();
var x17=this;
var x18=function(x19)
{
var x20=x19.getMBR();
var x21=x16.getMBR();
x17.xRatio=(x20[2]-x20[0])/(x21[2]-x21[0]);
x17.yRatio=(x20[3]-x20[1])/(x21[3]-x21[1]);
var x22=x17.xRatio*x17._f206._f108();
var x23=x17.yRatio*x17._f206._f109();
x17._f218.style.position="absolute";
x17._f218.style.overflow="hidden";
x17._f218.style.zIndex=10000
x17._f218.style.left=((x17._f206._f108()-x22)/2)+"px";
x17._f218.style.top=((x17._f206._f109()-x23)/2)+"px";
x17._f218.style.width=x22+"px";
x17._f218.style.height=x23+"px";
x17._f218.style.border=x17.borderStyle;
if(_f10._f69=='NS')
x17._f218.innerHTML="<div  style='width: "+x22+"px; height: "+x23
+"px;opacity: 0.3;background-color:"+x17.backgroundColor+";'></div>";
else if(_f10._f69=='SF')
x17._f218.innerHTML="<div  style='width: "+x22+"px; height: "+x23
+"px;opacity: 0.3;background-color:"+x17.backgroundColor+";'></div>";
else if(_f10._f69=='IF')
x17._f218.innerHTML="<div  style='width: "+x22+"px; height: "+x23
+"px;filter:alpha(opacity=30);background-color:"+x17.backgroundColor+";'></div>";
if(x22>x17._f206._f108()||x23>x17._f206._f109())
x17._f218.style.visibility="hidden";
else
 x17._f218.style.visibility=x17._f206._f219.style.visibility;
x17._f218.onmousedown=MVUtil._f105(x17._f218,function(x24){
var x25=x17._f204.getCenter();
x24=(x24)?x24:((window.event)?event:null);
if(x24.button==2)
{
return;
}
x17.coords=x17._f206._f224(x24)
x17._f207=true;
MVUtil._f174(x24);
x17._f208=0;
x17._f209=0;
})
x17._f218.onmouseup=MVUtil._f105(x17._f218,function(x26)
{
if(x17._f207)
{
x26=(x26)?x26:((window.event)?event:null);
x17._f207=false;
x26.cancelBubble=true;
x17._f218._f225();
}
})
x17._f218._f225=MVUtil._f105(x17._f218,function()
{
x17._f207=false;
var x27=parseInt(this.style.left)+parseInt(this.style.width)/2;
var x28=parseInt(this.style.top)+parseInt(this.style.height)/2;
var x29=x17._f206;
var x30=x27-x29._f108()/2;
x30=x30/x29._f75;
var x31=x28-x29._f109()/2;
x31=x31/x29._f77;
var x32=x17._f206._f226()+x30;
var x33=x17._f206._f227()-x31;
var x34=MVSdoGeometry.createPoint(x32,x33,x17._f206.srid);
x17._f206.setCenter(x34);
})
if(!x17._f214)
MVUtil.detachEvent(window.document,"mouseup",x17._f214);
x17._f214=MVUtil._f105(window.document,function(x35)
{
if(x17._f207){
x17._f207=false;
x17._f218._f225();
}
});
MVUtil.attachEvent(window.document,"mouseup",x17._f214);
x17._f218.onmousemove=MVUtil._f105(x17._f218,function(x36)
{
x36=(x36)?x36:((window.event)?event:null);
if(x17._f207)
{
var x37=x17._f206._f224(x36);
x=x37.left-x17.coords.left;
y=x37.top-x17.coords.top;
x17.coords=x37;
this.style.left=(parseInt(this.style.left)+x)+"px";
this.style.top=(parseInt(this.style.top)+y)+"px";
x36.cancelBubble=true;
}
})
}
if(x15.srid!=x16.srid)
{
this._f204.transformGeom(x15,x16.srid,null,x18);
}
else
 x18(x15);
}
MVOverviewMap.prototype._f228=function(x38,x39)
{
if(this.xRatio==undefined)
return ;
var x40=Math.round(this.xRatio*x38);
var x41=Math.round(this.yRatio*x39);
if(x40>=0)
x40=Math.floor(x40);
else
 x40=Math.ceil(x40);
if(x41>=0)
x41=Math.floor(x41);
else
 x41=Math.ceil(x41);
if(!this._f210)
{
this._f211=true;
this._f218.style.left=(parseInt(this._f218.style.left)+x40)+"px";
this._f218.style.top=(parseInt(this._f218.style.top)+x41)+"px";
}
}
MVOverviewMap.prototype._f229=function()
{
if(!this._f210)
{
this._f211=true;
this._f206.setCenter(this._f204.getCenter());
this._f222();
}
this._f210=false;
}
MVOverviewMap.prototype._f230=function(x42,x43,x44)
{
var x45=x42-x43;
if(x43>=x42&&this._f206._f220)
{
this._f204._f220=false;
if(x42-this._f206.getZoomLevel()==this._f205){
if(x44)
this._f206.setCenterAndZoomLevel(x44,MVOverviewMap._f221(this._f206.getZoomLevel()-x45));
else
 this._f206.setZoomLevel(MVOverviewMap._f221(this._f206.getZoomLevel()-x45));
}
else {
if(x44)
this._f206.setCenterAndZoomLevel(x44,MVOverviewMap._f221(x42-x45-this._f205));
else
 this._f206.setZoomLevel(MVOverviewMap._f221(x42-x45-this._f205));
}
this._f222();
}
else if(x43<x42&&this._f206._f220)
{
this._f204._f220=false;
if(x44)
this._f206.setCenterAndZoomLevel(x44,MVOverviewMap._f221(this._f206.getZoomLevel()-x45));
else
 this._f206.setZoomLevel(MVOverviewMap._f221(this._f206.getZoomLevel()-x45));
this._f222();
}
this._f206._f220=true;
}
MVOverviewMap.prototype.setRectangleStyle=function(x46,x47)
{
this.borderStyle=x46;
this.backgroundColor=x47;
}
MVOverviewMap.prototype.setMouseCursorStyle=function(x48,x49)
{
if(x49=="dragging")
this._f212=x48;
else if(x49=="default")
{
this._f213=x48;
MVUtil._f164(this._f219,x48);
}
}
MVOverviewMap._f221=function(x50)
{
if(!x50||x50<0)
return 0;
else
 return x50;
}
function MVInfoWindowStyle1()
{
}
MVInfoWindowStyle1._f801=null;
MVInfoWindowStyle1.closeButtonImgURL=null;
MVInfoWindowStyle1._f853=function(x0)
{
if(x0&&x0.closeButtonImageURL)
{
if(!this._f854||
this._f854!=x0.closeButtonImageURL)
{
this.closeButtonWidth=null;
this.closeButtonHeight=null;
}
this._f854=x0.closeButtonImageURL;
if(x0.closeButtonWidth)
this.closeButtonWidth=x0.closeButtonWidth;
if(x0.closeButtonHeight)
this.closeButtonHeight=x0.closeButtonHeight;
}
else
 {
if(!this._f854||
this._f854!=MVInfoWindowStyle1.closeButtonImgURL)
{
this.closeButtonWidth=null;
this.closeButtonHeight=null;
}
this._f854=MVInfoWindowStyle1.closeButtonImgURL;
this.closeButtonWidth=14;
this.closeButtonHeight=14;
}
if(x0&&x0.bodyStyle)
this._f855=x0.bodyStyle;
else
 this._f855="border:1px;border-color:#8794A3;background-color:#FFFFFF";
if(x0&&x0.titleBarStyle)
this._f856=x0.titleBarStyle;
else
 this._f856="background-color:#CFDCEB;font-weight:bold";
if(x0&&x0.coneStyle)
{
this._f857=x0.coneStyle;
var x1=x0.coneStyle.split(/;|:/);
if(x1)
{
for(i=0;i<x1.length;i++)
if(x1[i].indexOf("opacity")>=0&&i<x1.length)
{
this._f858=parseInt(x1[i+1]);
break;
}
}
}
else
 {
this._f857="background-color:#99CC33;opacity:30";
this._f858=30;
}
if(x0&&x0.offset)
MVInfoWindowStyle1._f443=x0.offset;
else
 MVInfoWindowStyle1._f443=20;
if(x0&&x0.activeTab)
this.style_activeTab=x0.activeTab;
else
 this.style_activeTab="background-color:#FFFFFF;font-weight:bold";
if(x0&&x0.inactiveTab)
this.style_inactiveTab=x0.inactiveTab;
else
 this.style_inactiveTab="background-color:#CFDCEB;font-weight:bold";
if(x0&&x0.tabBorder)
this.style_tabBorder=x0.tabBorder;
else
 this.style_tabBorder="1px solid #8794A3";
}
MVInfoWindowStyle1.init=function(x2)
{
if(!MVInfoWindowStyle1.closeButtonImgURL)
MVInfoWindowStyle1.closeButtonImgURL=_f10._f142+"infoicons/closeDialog_n.png";
if(x2)
MVInfoWindowStyle1._f853(x2);
else
 MVInfoWindowStyle1._f853(MVInfoWindowStyle1._f801);
MVInfoWindowStyle1._f300=null;
MVInfoWindowStyle1._f301=null;
MVInfoWindowStyle1._f295=null;
this._f859=null;
this._f860=null;
this.x=null;
this.y=null;
this._f861="";
this._f862=null;
this._f863=null;
}
MVInfoWindowStyle1.createWindow=function(x3,x4,x5,x6,x7,x8)
{
this.x=x3;
this.y=x4;
var x9=document.createElement("div");
var x10=document.createElement("table");
x10.id="infowindow3table_"+x8;
x10.style.cssText=this._f855;
x10.style.borderStyle="solid";
x10.style.cellSpacing="0px";
x10.style.borderSpacing="0px";
if(_f10._f69=='IF')
x10.style.borderCollapse="collapse";
x10.style.padding="0px";
if(!x10.style.width||x10.style.width==""||
x10.style.width=="0"||x10.style.width=="0px")
{
if(x5)
x10.style.width=MVUtil._f31(x5);
else
 x10.style.width=MVUtil._f31(_f10._f300);
}
if(!x10.style.height||x10.style.height==""||
x10.style.height=="0"||x10.style.height=="0px")
{
if(x6)
x10.style.height=MVUtil._f31(x6);
else
 x10.style.height=MVUtil._f31(_f10._f301);
}
var x11=document.createElement("tbody");
x10.appendChild(x11);
var x12=document.createElement("tr");
x12.style.border="0px";
x12.style.padding="0px";
x12.style.height=MVUtil._f31(10);
x11.appendChild(x12);
this._f863=new Array();
var x13=this;
var x14=function(){
MVInfoWindowStyle1.pauseRedraw=true;
var x15=this.number;
var x16=x13._f863.length;
if(x15==x13.active)
return;
var x17=document.getElementById("infowindow3table_"+x8)
var x18=x17.childNodes[0];
if(x18.childNodes.length>1)
x18.removeChild(x18.childNodes[1]);
x18.appendChild(x13._f860[x15]);
x13._f863[x13.active].style.cssText=x13.style_inactiveTab;
x13._f863[x13.active].style.height=MVUtil._f31(10);x13._f863[x13.active].style.width=((100-10)/x16)+"%";
x13._f863[x13.active].style.borderBottom=x13.style_tabBorder;
x13._f863[x13.active].style.cursor="pointer";
if(x13.active+1==x13._f863.length)
x13._f863[x13.active].style.borderRight="none";
else
 x13._f863[x13.active].style.borderRight=x13.style_tabBorder;
x13._f863[x15].style.cssText=x13.style_activeTab;
x13._f863[x15].style.height=MVUtil._f31(10);x13._f863[x15].style.width=((100-10)/x16)+"%";
x13._f863[x15].style.borderBottom="none";
x13._f863[x15].style.borderRight=x13.style_tabBorder;
x13._f863[x15].style.cursor="default";
if(x15+1==x13._f863.length){
x13._f863[x15].style.borderRight=x13.style_tabBorder;
}
x13.active=x15;
MVInfoWindowStyle1.pauseRedraw=false;
MVInfoWindowStyle1._f300=x17.offsetWidth;MVInfoWindowStyle1._f301=x17.offsetHeight;x17.style.height=x17.offsetHeight}
for(var x19=0;x19<x7;x19++){
var x20=document.createElement("TD");
x20.align="center";
x20.number=x19;
this._f863.push(x20);
x12.appendChild(x20);
x20.onclick=MVUtil._f105(x20,x14);
}
var x21=document.createElement("TD");
x21.style.width="10%";
x21.align="right";
x21.vAlign="top";
x21.style.padding="2px";
x12.appendChild(x21);
this._f862=x21;
this._f860=new Array();
for(var x19=0;x19<x7;x19++){var x22=document.createElement("tr");
x12.style.border="0px";
x12.style.padding="0px";
x11.appendChild(x22);
var x23=document.createElement("td");
x23.colSpan=x7+1;
x23.style.padding="10px";
x22.appendChild(x23);
this._f860.push(x22);
}
x10.style.left=MVUtil._f31(x3-MVInfoWindowStyle1._f443);
x10.style.top=MVUtil._f31(x4+MVInfoWindowStyle1._f443);
x10.style.position='absolute';
x10.style.zIndex=200;
return x10;
}
MVInfoWindowStyle1.addCloseButton=function(x24)
{
var x25=document.createElement("img");
x25.src=this._f854;
x25.style.cursor='pointer';
if(this.closeButtonWidth)
{
x25.width=this.closeButtonWidth;
x25.style.width=this.closeButtonWidth;
}
if(this.closeButtonHeight)
{
x25.height=this.closeButtonHeight;
x25.style.height=this.closeButtonHeight;
}
if(!this.closeButtonWidth&&!this.closeButtonHeight)
x25.onload=MVInfoWindowStyle1.setCloseButtonSize;
x25.onclick=x24;
this._f862.appendChild(x25);
}
MVInfoWindowStyle1.addContent=function(x26,x27)
{
for(var x28=0;x28<x27.length;x28++){
this._f860[x28].childNodes[0].innerHTML=x27[x28].getContent();
var x29=x27[x28].getTitle();
if(!x29)
x29="&nbsp;";
this._f863[x28].innerHTML=x29;
}
}
MVInfoWindowStyle1.setTitleStyle=function(x30,x31)
{
var x32=this._f863[0].parentNode;
var x33=this._f863.length;
if(x33>1){
x32.style.cssText=this._f856;
x32.style.border="0px none";
x32.style.padding="0px";
x32.style.height=MVUtil._f31(10);
for(var x34=0;x34<x33;x34++){
if(x34==x31){
this._f863[x34].style.cssText=this.style_activeTab;
}
else{
this._f863[x34].style.cssText=this.style_inactiveTab;
this._f863[x34].style.borderBottom=this.style_tabBorder;
this._f863[x34].style.cursor="pointer";
}
this._f863[x34].style.height=MVUtil._f31(10);this._f863[x34].style.width=((100-10)/x33)+"%";
if(x34+1!=x33||x34==x31){
this._f863[x34].style.borderRight=this.style_tabBorder;
}
}
this._f862.style.borderBottom=this.style_tabBorder;
this._f862.style.borderTop="none";
}
else if(x30[0].getTitle()){
x32.style.cssText=this._f856;
x32.style.border="0px none";
x32.style.padding="0px";
x32.style.height=MVUtil._f31(10);
}
}
MVInfoWindowStyle1._f444=function(x35,x36)
{
MVInfoWindowStyle1._f864(x35,this.x,this.y,x36);
}
MVInfoWindowStyle1._f864=function(x37,x38,x39,x40)
{
var x41=document.getElementById("infowindow3table_"+x40);
var x42=x41.style.zIndex-1;
var x43=x41.offsetLeft;
var x44=x41.offsetTop;
x43-=x38;
x44-=x39;
var x45=1;
var x46=1;
var x47=x41.offsetWidth;
var x48=x41.offsetHeight;
MVInfoWindowStyle1._f300=x47;
MVInfoWindowStyle1._f301=x48;
var x49=0;
var x50=50;
var x51=260;
var x52=340;
var x53=50;if(this._f859)
{
MVUtil._f133(this._f859);
this._f859.parentNode.removeChild(this._f859);
}
var x54=document.createElement("DIV");
x54.id=x41.id+'cones';
x54.style.position='absolute';
x54.style.left=x38+'px';
x54.style.top=x39+'px';
x54.style.border='0px solid #000000';
x54.style.zIndex=x42;
this._f859=x54;
x37.appendChild(x54);
zcounter=0;
var x55=x53;this._f861=Math.round((this._f858/x53)*7);
var x56=Math.abs(x43/x53);
var x57=Math.abs(x44/x53);
var x58=Math.abs(x56/x57);
var x59=0;
for(var x60=0;x60<x53;x60++)
{
var x61=((x43*1.0/x53)*x60);var x62=((x44*1.0/x53)*x60);x51=x45+Math.abs(((x47-x45)/x53*x60));x52=x46+Math.abs(((x48-x46)/x53*x60));
var x63=document.createElement("DIV");
x63.id=x41.id+'D'+x60;
x63.style.cssText=this._f857;
x63.style.position='absolute';
MVUtil._f629(x63,x61,x62,x51,x52);
x63.style.border='0px solid black';
x63.style.fontSize="1px";
x63.style.lineHeight=0;
x54.appendChild(x63);
MVInfoWindowStyle1._f865(x63);
x63.style.zIndex=zcounter;
zcounter++;
x59++;
x55-=x60;
}
coneDone=true;
}
MVInfoWindowStyle1._f865=function(x64)
{
if(_f10._f69=="IF"){
x64.style.opacity=0.05;
x64.style.filter='alpha(opacity = '+this._f861+')';
}else if(_f10._f69=="SF"){
var x65=this._f861/100;
x64.style.opacity=x65;
}else{
var x65=this._f861/100;
x64.style.MozOpacity=x65;
}
}
MVInfoWindowStyle1.sizeChanged=function(x66)
{
var x67=document.getElementById("infowindow3table_"+x66);
if(MVInfoWindowStyle1.pauseRedraw||(x67&&
MVInfoWindowStyle1._f300&&
Math.abs(MVInfoWindowStyle1._f300-x67.offsetWidth)<5&&
MVInfoWindowStyle1._f301&&
Math.abs(MVInfoWindowStyle1._f301-x67.offsetHeight)<5))
return false;
else
 return true;
}
MVInfoWindowStyle1.getWindowSize=function(x68,x69,x70)
{
var x71=document.getElementById("infowindow3table_"+x70);
if(x71)
{
var x72=x71.offsetWidth;
if(x72>(x68?x68:_f10._f300))
x71.style.width=MVUtil._f31(x72);
var x73=0;
var x74=this._f860[0].offsetHeight;
for(var x75=1;x75<this._f860.length;x75++){
if(this._f860[x73].offsetHeight<this._f860[x75].offsetHeight)
x73=x75;
x74+=this._f860[x75].offsetHeight;
}
var x76=x71.offsetHeight-x74+this._f860[x73].offsetHeight;
if(x76>(x69?x69:_f10._f301))
x71.style.height=MVUtil._f31(x76);
}
}
MVInfoWindowStyle1.setCloseButtonSize=function()
{
if(this.closeButtonWidth||!this._f862||!this._f862.firstChild)
return ;
this.closeButtonWidth=this._f862.firstChild.offsetWidth;
this.closeButtonHeight=this._f862.firstChild.offsetHeight;
}
MVInfoWindowStyle1.clear=function()
{
if(this._f859)
MVUtil._f133(this._f859);
this._f859=null;
if(this._f860)
MVUtil._f133(this._f860);
this._f860=null;
if(this._f862)
MVUtil._f133(this._f862);
this._f862=null;
if(this._f863)
MVUtil._f133(this._f863);
this._f863=null;
}
MVInfoWindowStyle1.removeInActiveTabs=function(x77,x78)
{
var x79=document.getElementById("infowindow3table_"+x78);
var x80=this._f860.length;
if(x80>1){
for(var x81=0;x81<x80;x81++)
if(x81!=x77)
this._f860[x81].parentNode.removeChild(this._f860[x81]);
}
this.active=x77;
}
function MVInfoWindowStyle2()
{
}
MVInfoWindowStyle2.init=function()
{
this.window=null;
this._f377=null;
this.iw=_f10._f142+"/infoicons/";
this.iw_arrow=this.iw+"arrow_circle.gif";
this.iw_h=this.iw+"h.gif";
this.iw_v=this.iw+"v.gif";
this.iw_c=this.iw+"iw_c.gif";
this.iw_c1=this.iw+"iw_n.gif";
this.iw_c2=this.iw+"iw_s.gif";
this.iw_nw=this.iw+"tl.gif";
this.iw_sw=this.iw+"bl.gif";
this.iw_ne=this.iw+"tr.gif";
this.iw_se=this.iw+"br.gif";
this.closeImg=this.iw+"close_circle.gif";
this.cornerwidth=25;
this.cornerheight=25;
this.arrowwidth=41;
this.arrowheight=40;
this.arrowendheight=20;
}
MVInfoWindowStyle2.createWindow=function(x0,x1,x2,x3)
{
this.window=new Object();
this.window.arrow=_f285(this.iw_arrow,this.arrowwidth+2,this.arrowheight,1,7,0);
this.window.e=_f285(this.iw_v,1,x3+1-this.cornerheight*2,x2+this.arrowwidth,this.cornerheight,0);
this.window.w=_f285(this.iw_v,1,x3-this.cornerheight*2-20,this.arrowwidth,this.arrowendheight+this.cornerheight,0);
this.window.wu=_f285(this.iw_nw,this.cornerwidth,this.cornerheight,this.arrowwidth,0,0);
this.window.wd=_f285(this.iw_sw,this.cornerwidth,25,this.arrowwidth,x3+1-this.cornerheight,0);
this.window.eu=_f285(this.iw_ne,this.cornerwidth,this.cornerheight,x2+this.arrowwidth+1-this.cornerwidth,0,0);
this.window.ed=_f285(this.iw_se,this.cornerwidth,25,x2+this.arrowwidth+1-this.cornerwidth,x3+1-this.cornerheight,0);
this.window.c=_f285(this.iw_c,x2-1,x3+1-this.cornerheight*2,this.arrowwidth+1,this.cornerheight,0);
this.window.cu=_f285(this.iw_c1,x2+1-this.cornerwidth*2,this.cornerheight,this.arrowwidth+this.cornerwidth,0,0);
this.window.cd=_f285(this.iw_c2,x2+1-this.cornerwidth*2,25,this.arrowwidth+this.cornerwidth,x3-this.cornerheight+1,0);
this._f377=window.document.createElement("div");
this._f377.style.position="relative";
this._f377.style.left=MVUtil._f31(x0-1);
this._f377.style.top=MVUtil._f31(x1+2);
this._f377.appendChild(this.window.e);
this._f377.appendChild(this.window.wu);
this._f377.appendChild(this.window.w);
this._f377.appendChild(this.window.cu);
this._f377.appendChild(this.window.c);
this._f377.appendChild(this.window.cd);
this._f377.appendChild(this.window.wd);
this._f377.appendChild(this.window.ed);
this._f377.appendChild(this.window.eu);
this._f377.appendChild(this.window.arrow);
this.width=x2;
return this._f377;
}
MVInfoWindowStyle2.addCloseButton=function(x4)
{
this.closeButton=_f285(this.closeImg,16,16,this.width+10,10,4);
this.closeButton.style.position="absolute";
this.closeButton.onclick=MVUtil._f105(this.closeButton,
function(){x4();});
MVUtil._f164(this.closeButton,"pointer");
this._f377.appendChild(this.closeButton);
}
MVInfoWindowStyle2.addContent=function(x5)
{
x5.style.left=MVUtil._f31(55);
x5.style.top=MVUtil._f31(17);
this._f377.appendChild(x5);
}
MVInfoWindowStyle2.getWindow=function()
{
return this._f377;
}
function MVInfoWindowStyle3()
{
}
MVInfoWindowStyle3.init=function()
{
this.window=null;
this._f377=null;
this.iw=_f10._f142+"/infoicons/";
this.iw_arrow=this.iw+"arrow.gif";
this.iw_h=this.iw+"hline.gif";
this.iw_v=this.iw+"vline.gif";
this.iw_c=this.iw+"iw_c.gif";
this.closeImg=this.iw+"close.gif";
this._f378=600;
this._f379=600;
this._f380=30;
this._f381=16;
this._f382=600;
this._f383=1;
this._f384=1;
this._f385=600;
this._f386=1;
this._f387=10;
}
MVInfoWindowStyle3.createWindow=function(x0,x1,x2,x3)
{
this.window=new Object();
this.window.arrow=_f285(this.iw_arrow,this._f380,this._f381,1,this._f387,0);
this.window.n=_f285(this.iw_h,x2+1,1,this._f380+1,0,0);
this.window.s=_f285(this.iw_h,x2+1,1,this._f380+1,x3+1,0);
this.window.e=_f285(this.iw_v,1,x3+1,x2+this._f380+1,1,0);
this.window.wu=_f285(this.iw_v,1,this._f387,this._f380,0,0);
this.window.wd=_f285(this.iw_v,1,x3-this._f381-this._f387+2,this._f380+1,this._f381+this._f387,0);
this.window.c=_f285(this.iw_c,x2,x3,this._f380+1,1,0);
this._f377=window.document.createElement("div");
this._f377=window.document.createElement("div");
this._f377.style.position="relative";
this._f377.style.left=MVUtil._f31(x0);
this._f377.style.top=MVUtil._f31(x1);
this._f377.appendChild(this.window.n);
this._f377.appendChild(this.window.s);
this._f377.appendChild(this.window.e);
this._f377.appendChild(this.window.wu);
this._f377.appendChild(this.window.c);
this._f377.appendChild(this.window.wd);
this._f377.appendChild(this.window.arrow);
this.width=x2;
return this._f377;
}
MVInfoWindowStyle3.addCloseButton=function(x4)
{
this.closeButton=_f285(this.closeImg,15,15,this.width-1,10,4);
this.closeButton.style.position="absolute";
MVUtil._f164(this.closeButton,"pointer");
this._f377.appendChild(this.closeButton);
this.closeButton.onclick=MVUtil._f105(this.closeButton,
function(){x4();});
}
MVInfoWindowStyle3.addContent=function(x5)
{
x5.style.left=MVUtil._f31(50);
x5.style.top=MVUtil._f31(25);
this._f377.appendChild(x5);
}
function MVNSDP(x0)
{
this.nsdp_id=x0;
this.nsdp_theme=null;
this.nsdp_keycol=null;
this.nsdp_rendersty=null;
this.nsdp_labelsty=null;
this.nsdp_params=null;
this.nsdp_timeout=20;
this.nsdp_smfo=true;
}
MVNSDP.prototype.setTheme=function(x0)
{
this.nsdp_theme=x0;
}
MVNSDP.prototype.setKeyColumn=function(x1)
{
this.nsdp_keycol=x1;
}
MVNSDP.prototype.setRenderStyle=function(x2)
{
this.nsdp_rendersty=x2;
}
MVNSDP.prototype.setLabelStyle=function(x3)
{
this.nsdp_labelsty=x3;
}
MVNSDP.prototype.setShowMatchedFeatureOnly=function(x4)
{
this.nsdp_smfo=x4;
}
MVNSDP.prototype.setParameters=function(x5)
{
this.nsdp_params=x5;
}
MVNSDP.prototype.setTimeout=function(x6)
{
this.nsdp_timeout=x6;
}
MVNSDP.prototype.getFlatString=function()
{
var x7="{";
x7+="\"nsdp_id\":"+"\""+this.nsdp_id+"\",";
x7+="\"nsdp_theme\":"+"\""+this.nsdp_theme+"\",";
x7+="\"nsdp_keycol\":"+"\""+this.nsdp_keycol+"\",";
if(this.nsdp_smfo!=null&&this.nsdp_smfo==false)
x7+="\"nsdp_smfo\":"+"\""+this.nsdp_smfo+"\",";
if(this.nsdp_rendersty!=null)
x7+="\"nsdp_rendersty\":"+"\""+this.nsdp_rendersty+"\",";
if(this.nsdp_labelsty!=null)
x7+="\"nsdp_labelsty\":"+"\""+this.nsdp_labelsty+"\",";
x7+="\"nsdp_timeout\":"+"\""+this.nsdp_timeout+"\"";
if(this.nsdp_params==null)
{
return x7+="}";
}
x7+=",\"nsdp_params\":[";
var x8=0;
for(p in this.nsdp_params)
{
x7+="{"+"\""+p+"\":"+"\""+this.nsdp_params[p]+"\"},";
x8++;
}
if(x8>0)
x7=x7.substr(0,x7.length-1);
x7+="]}";
return x7;
}
MVNSDP.prototype.getXML=function(x9)
{
var x10="<ns_data_provider provider_id=\""+this.nsdp_id+"\" ";
x10+="time_out=\""+this.nsdp_timeout+"\">";
x10+="<for_theme name=\""+this.nsdp_theme+"\"/>";
var x11=null;
if(this.nsdp_rendersty!=null)
x11=this.nsdp_rendersty;
else if(x9&&x9._f110!=null)
x11=x9._f110;
if(x11)
x10+="<custom_rendering_style name=\""+x11+"\"/>";
x10+="<join spatial_key_column=\""+this.nsdp_keycol+"\"/>";
if(this.nsdp_smfo!=null&&this.nsdp_smfo==false)
x10+="<display_unmatched_features>true</display_unmatched_features>";
if(this.nsdp_params!=null)
{
x10+="<parameters>";
for(p in this.nsdp_params)
{
var x12=null;
if(p=="xml")
x12=this.nsdp_params[p].replace(/</g,"&lt;");
else
 x12=this.nsdp_params[p];
x10+="<parameter name=\""+p+"\" value=\""+x12+"\"/>";
}
x10+="</parameters>";
}
x10+="</ns_data_provider>";
return x10;
}
function MVXMLStyle(x0,x1)
{
this.name=x0;
this.xmlDef=x1;
}
MVXMLStyle.prototype.getXMLString=function()
{
var x0='<style name="'+this.name+'">'+
this.xmlDef+
'</style>';
return x0;
}
function MVStyleColor(x0,x1,x2)
{
this.name=x0;
this.type="color";
this.description=null;
if(x1==null)
this.fill=null;
else if(x1.charAt(0)=='#')
this.fill=x1.substring(1,x1.length);
else
 this.fill=x1;
this.fill_opacity=255;
if(x2==null)
this.stroke=null;
else if(x2.charAt(0)=='#')
this.stroke=x2.substring(1,x2.length);
else
 this.stroke=x2;
this.stroke_opacity=255;
this.stroke_width=1;
}
MVStyleColor.prototype.setStroke=function(x0)
{
if(x0==null)
this.stroke=null;
else if(x0.charAt(0)=='#')
this.stroke=x0.substring(1,x0.length);
else
 this.stroke=x0;
}
MVStyleColor.prototype.setStrokeOpacity=function(x1)
{
this.stroke_opacity=x1;
}
MVStyleColor.prototype.setFill=function(x2)
{
if(x2==null)
this.fill=null;
else if(x2.charAt(0)=='#')
this.fill=x2.substring(1,x2.length);
else
 this.fill=x2;
}
MVStyleColor.prototype.setFillOpacity=function(x3)
{
this.fill_opacity=x3;
}
MVStyleColor.prototype.setDescription=function(x4)
{
this.description=x4;
}
MVStyleColor.prototype.setStrokeWidth=function(x5)
{
this.stroke_width=x5;
}
MVStyleColor.prototype.getXMLString=function()
{
var x6=(this.stroke==null)?"":"stroke:0x"+this.stroke+";";
var x7=(this.fill==null)?"":"fill:0x"+this.fill+";";
var x8=this.stroke_opacity<255?"stroke-opacity:"+this.stroke_opacity+";":"";
var x9=this.fill_opacity<255?"fill-opacity:"+this.fill_opacity+";":"";
var x10=this.stroke_width!=1?"stroke-width:"+this.stroke_width:"";
var x11='<style name="'+this.name+'">'+
'<svg width="1in" height="1in">'+
'<g class="color" style="'+x6+x8+x7+x9+x10+'">'+
'</g></svg></style>';
return x11;
}
function MVStyleMarker(x0,x1)
{
this.name=x0;
if(x1==null)
this.type="image";
else
 this.type=x1.toLowerCase();
this.description=null;
this.fill=null;
this.fill_opacity=255;
this.stroke=null;
this.stroke_opacity=255;
this.stroke_width=1;
this.imageUrl=null;
this.vector=null;
this.width=16;
this.height=16;
}
MVStyleMarker.prototype.setName=function(x0)
{
if(x0!=null)
this.name=x0;
}
MVStyleMarker.prototype.setSize=function(x1,x2)
{
if(x1!=null)
this.width=x1;
if(x2!=null)
this.height=x2;
}
MVStyleMarker.prototype.setImageUrl=function(x3)
{
if(x3==null)
this.imageUrl=null;
else
 this.imageUrl=x3;
}
MVStyleMarker.prototype.setStrokeColor=function(x4,x5)
{
if(x4==null)
this.stroke=null;
else if(x4.charAt(0)=='#')
this.stroke=x4.substring(1,x4.length);
else
 this.stroke=x4;
this.stroke_opacity=x5;
}
MVStyleMarker.prototype.setFillColor=function(x6,x7)
{
if(x6==null)
this.fill=null;
else if(x6.charAt(0)=='#')
this.fill=x6.substring(1,x6.length);
else
 this.fill=x6;
if(x7!=null)
this.fill_opacity=x7;
}
MVStyleMarker.prototype.setDescription=function(x8)
{
this.description=x8;
}
MVStyleMarker.prototype.setStrokeWidth=function(x9)
{
this.stroke_width=x9;
}
MVStyleMarker.prototype.setVectorShape=function(x10)
{
if(x10==null)
this.vector=null;
else
 this.vector=x10;
}
MVStyleMarker.prototype.getXMLString=function()
{
var x11="width:"+this.width+";height:"+this.height+";";
var x12=(this.stroke==null)?"":"stroke:0x"+this.stroke+";";
var x13=(this.fill==null)?"":"fill:0x"+this.fill+";";
var x14=this.stroke_opacity<255?"stroke-opacity:"+this.stroke_opacity+";":"";
var x15=this.fill_opacity<255?"fill-opacity:"+this.fill_opacity+";":"";
var x16=this.stroke_width!=1?"stroke-width:"+this.stroke_width:"";
var x17="";
if(this.type=="image")
{
x17='  <image_marker url="'+this.imageUrl+'" />';
}
else if(this.type=="vector")
{
if(this.vector.charAt(0)=='c'||this.vector.charAt(0)=='C')
{
x17='  <circle cx="0" cy="0" r="1"/>';
}
else
 {
x17='  <polyline points="'+this.vector+'"/>';
}
}
var x18='<style name="'+this.name+'">'+
'<svg width="1in" height="1in">'+
'<g class="marker" style="'+x11+x12+x14+x13+x15+x16+'">'+
x17+
'</g></svg></style>';
return x18;
}
function MVBucketSeries(x0)
{
this._f506=null;
this._f507=new Array();
this._f505=x0;
if(x0!="SCHEME_CUSTOM"&&x0!="SCHEME_EQUAL_INTERVAL")
this._f505="SCHEME_CUSTOM";
}
MVBucketSeries.prototype.setBuckets=function(x0)
{
this._f507=x0;
}
MVBucketSeries.prototype.getBuckets=function()
{
return this._f507;
}
MVBucketSeries.prototype.getScheme=function()
{
return _f505;
}
MVBucketSeries.prototype.setDefaultRenderingStyle=function(x1)
{
this._f506=x1;
}
MVBucketSeries.prototype.getXMLString=function()
{
var x2=(this._f506==null)?"":' default_style="'+this._f506+'" ';
var x3="<Buckets"+x2+">";
for(var x4=0;x4<this._f507.length;x4++)
{
var x5=this._f507[x4];
if(x5!=null)
x3+=x5.getXMLString();
}
x3+="</Buckets>";
return x3;
}
function MVBucketStyle(x0,x1)
{
this.name=x0;
this._f507=x1;
}
MVBucketStyle.prototype.getXMLString=function()
{
var x0='<style name="'+this.name+'"><AdvancedStyle><BucketStyle>';
x0+=this._f507.getXMLString()+"</BucketStyle></AdvancedStyle></style>";
return x0;
}
function MVNumericRangedBucket(x0,x1,x2,x3)
{
this.low=x0;
this.high=x1;
this.renderingStyle=x2;
this.label=x3;
}
MVNumericRangedBucket.prototype.getXMLString=function()
{
var x0=(this.label==null)?"":'label="'+this.label+'" ';
var x1="<RangedBucket "+x0;
var x2=(this.low==null)?"":'low="'+this.low+'" ';
var x3=(this.high==null)?"":'high="'+this.high+'" ';
var x4=(this.renderingStyle==null)?"":'style="'+this.renderingStyle+'" ';
x1+=x2+x3+x4;
x1+="/>";
return x1;
}
function MVMapDecoration(x0,x1,x2,x3,x4,x5,x6)
{
this.mapControl=null;
this.html=null;
if(x0)
{
if(x0._f203)
{
x0._f560=true;
this.mapControl=x0;
}
else if(x0.substr)
this.html=x0;
}
if(typeof(x1)=="number")
this.left=x1;
else
 {
this.left=1;
if(!x5&&x3)
x5=-x3;
}
if(typeof(x2)=="number")
this.top=x2;
else
 {
this.top=1;
if(!x6&&x4)
x6=-x4;
}
this.width=x3;
this.height=x4;
this._f561=document.createElement("div");
this._f561.id=null;
this._f561.isMapDecoration=true;
this.parent=null;
this._f562=false;
this._f563=false
this._f97=new Array();
this._f564=null;
this._f565=null;
this._f566=null;
this._f567=null;
this.afterCollapseListener=null;
this._f568=null;
this.afterRestoreListener=null;
this._f569=null;
this._f570=null;
this._f571=null;
this.id=null;
this.visible=true;
this._f138=0;
this._f139=0;
this._f572=(_f10._f69=="IF")?18:16;
this._f573=0;
this._f574=0;
this._f575=40;
this._f576=0;
this._f577=null;
this.icon=null;
this._f578=null;
this._f173=false;
this._f579=false;
this._f580=null;
this._f581=null;
this._f582=null;
this.buffer=(_f10._f69=="IF")?5:7;
this.collapsed=false;
this._f418=0;
this._f417=0;
this.setOffset(x5,x6);
this._f583=null;
this._f584=false;
this.cursorStyle=null;
}
MVMapDecoration.prototype.setOffset=function(x0,x1)
{
if(!x0)
x0=0;
if(!x1)
x1=0;
this._f138=x0;
this._f139=x1;
}
MVMapDecoration.prototype.setPosition=function(x2,x3,x4,x5)
{
if(!x4)
x4=0;
if(!x5)
x5=0;
this._f138=x4;
this._f139=x5;
if(typeof(x2)=="number")
this.left=x2;
else
 {
this.left=1;
if(!x4&&this.width)
x4=-this.width;
}
if(typeof(x3)=="number")
this.top=x3;
else
 {
this.top=1;
if(!x5&&this.height)
x5=-this.height;
}
if(!this.parent)
return ;
if(this._f562)
{
if(!this.collapsed)
this._f585(this._f586);
}
else
 this._f585(this._f561);
}
MVMapDecoration.prototype.setPrintable=function(x6)
{
this._f563=x6;
}
MVMapDecoration.prototype.setCollapsible=function(x7,x8)
{
this._f562=x7;
this._f579=x8;
}
MVMapDecoration.prototype.setTitleBar=function(x9,x10,x11)
{
if(x9)
this._f580=x9;
if(x10)
this._f581=x10;
if(!x11&&x9)
x11=x9;
this._f582=x11;
}
MVMapDecoration.prototype.setVisible=function(x12)
{
this.visible=x12;
if(this.parent!=null&&this.parent._f92)
this._f587();
if(this.parent!=null&&this._f563)
this.parent._f588();
}
MVMapDecoration.prototype.isVisible=function()
{
return this.visible;
}
MVMapDecoration.prototype.addEventListener=function(x13,x14)
{
this.setEventListener(x13,x14);
}
MVMapDecoration.prototype.setEventListener=function(x15,x16)
{
if(x15==MVEvent.MOUSE_CLICK)
this._f564=x16;
else if(x15==MVEvent.MOUSE_OVER)
this._f565=x16;
else if(x15==MVEvent.MOUSE_OUT)
this._f566=x16;
else if(x15==MVEvent.COLLAPSE)
this._f567=x16;
else if(x15==MVEvent.AFTER_COLLAPSE)
this.afterCollapseListener=x16;
else if(x15==MVEvent.RESTORE)
this._f568=x16;
else if(x15==MVEvent.AFTER_RESTORE)
this.afterRestoreListener=x16;
else if(x15==MVEvent.DRAG_START)
this._f569=x16;
else if(x15==MVEvent.DRAG)
this._f570=x16;
else if(x15==MVEvent.DRAG_END)
this._f571=x16;
}
MVMapDecoration.prototype.attachEventListener=function(x17,x18)
{
MVUtil.attachEventListener(this._f97,x17,x18)
}
MVMapDecoration.prototype.detachEventListener=function(x19,x20)
{
MVUtil.detachEventListener(this._f97,x19,x20);
}
MVMapDecoration.prototype.getContainerDiv=function()
{
return this._f561;
}
MVMapDecoration.prototype.enableEventPropagation=function(x21)
{
this._f173=x21;
}
MVMapDecoration.prototype.isCollapsed=function()
{
return this.collapsed;
}
MVMapDecoration.prototype.collapse=function()
{
if(this.collapsed)
return ;
this._f561.style.visibility="hidden";
MVUtil._f73(this._f586,
this.parent._f108()-this._f572-this.buffer,
this.parent._f109()-this._f572-this.buffer);
this._f589=false;
if(this._f578)
clearTimeout(this._f578);
this._f578=null;
this.collapsed=true;
this._f586.style.visibility="hidden";
this._f590();
if(this.afterCollapseListener)
this.afterCollapseListener();
MVUtil.runListeners(this._f97,MVEvent.COLLAPSE);
}
MVMapDecoration.prototype.setMouseCursorStyle=function(x22)
{
this.cursorStyle=x22;
if(this.contentDiv)
MVUtil._f164(this.contentDiv,x22);
else if(this._f561)
MVUtil._f164(this._f561,x22);
}
MVMapDecoration.prototype.isDraggable=function()
{
return this._f584;
}
MVMapDecoration.prototype.setDraggable=function(x23)
{
this._f584=x23;
if(this.parent&&this==this.parent._f591)
this._f177();
if(this.parent)
{
var x24=this._f561;
if(this._f562)
x24=this._f577;
if(this._f584)
MVUtil._f164(x24,"move");
else
 MVUtil._f164(x24,"default");
}
}
MVMapDecoration.prototype.getPosition=function()
{
var x25=this._f586;
if(!this._f562)
x25=this._f561;
var x26=this.collapsed?this._f417:MVUtil._f83(x25);
var x27=this.collapsed?this._f418:MVUtil._f84(x25);
return {x:x26,y:x27};
}
MVMapDecoration.prototype._f585=function(x28,x29)
{
var x30=(this.top==1)?this._f138-this.buffer/2:this._f138;
var x31=(this.top==1)?this._f139-this.buffer/2:this._f139;
this._f418=this.parent._f109()*this.top+x31;
this._f417=this.parent._f108()*this.left+x30;
if(!x29)
{
x28.style.top=MVUtil._f31(this._f418);
x28.style.left=MVUtil._f31(this._f417);
}
this._f576=this._f575*(this.parent._f109()-this._f418)/(this.parent._f108()-this._f417);
this._f573=Math.ceil(this._f575*this.width/(this.parent._f108()-this._f417));
this._f574=Math.ceil(this._f575*this.height/(this.parent._f108()-this._f417));
}
MVMapDecoration.prototype.init=function(id,x32,x33)
{
this.id=id;
this.parent=x32;
this._f561.id=this.id;
this._f561.style.zIndex=2000;
this._f561.style.position="absolute";
if(this._f562)
{
this._f586=document.createElement("div");
this._f586.style.position="absolute";
this._f586.style.zIndex=2000;
this._f586.style.width=(this.width+this.buffer)+"px";
this._f586.style.height=(this.height+this.buffer)+"px";
this._f586.style.backgroundColor="white";
x33.appendChild(this._f586);
this.realContdiv=document.createElement("div");
this.realContdiv.style.position="absolute";
this.realContdiv.style.zIndex=2000;
this.realContdiv.style.left="3px";
this.realContdiv.style.top="3px";
this.realContdiv.style.width=this.width+"px";
this.realContdiv.style.height=this.height+"px";
this.realContdiv.style.border="1px solid #636661";
this.realContdiv.style.backgroundColor="white";
this._f586.appendChild(this.realContdiv);
var x34=document.createElement("div");
x34.style.position="absolute";
x34.style.left=MVUtil._f31(0);
x34.style.top=MVUtil._f31(0);
x34.style.width="100%";
x34.style.height=this._f572+2+"px";
x34.style.overflow="hidden";
this._f577=document.createElement("div");
this._f577.style.position="absolute";
this._f577.style.left=MVUtil._f31(-1);
this._f577.style.top=MVUtil._f31(-1);
this._f577.style.width="110%";
this._f577.style.height=this._f572+"px";
this._f577.style.border="1px solid #636661";
if(this._f582)
this._f577.title=this._f582;
x34.appendChild(this._f577);
this.realContdiv.appendChild(x34);
this.titleBg=document.createElement("img");
this.titleBg.style.width="100%";
this.titleBg.style.height="100%";
this.titleBg.src=_f10._f142+"title_bg.png";
this._f577.appendChild(this.titleBg);
var x35=this;
var x36=document.createElement("img");
this.icon=x36;
x36.style.position="absolute";
x36.style.left=MVUtil._f31(2);
x36.style.top=MVUtil._f31(1);
x36.style.height=MVUtil._f31(this._f572-3);
x36.style.width=MVUtil._f31(this._f572-3);
this._f577.appendChild(x36);
this._f577.onmousedown=function(x37)
{
if(x35._f584)
{
x35.parent._f591=x35;
x35.dragStartMouseLoc=MVUtil._f175(x37);
x35.dragStartLeft=MVUtil._f83(x35._f586);
x35.dragStartTop=MVUtil._f84(x35._f586);
MVUtil._f164(x35._f577,"move");
if(x35._f569)
x35._f569(x35.getPosition());
MVUtil.runListeners(x35._f97,MVEvent.AFTER_RESTORE,[x35.getPosition()]);
}
MVUtil._f174(x37);
}
if(this._f584)
MVUtil._f164(this._f577,"move");
MVUtil._f164(x36,"pointer");
this.setIconImageListeners(false);
if(this._f580)
{
var x38=document.createElement("div");
x38.style.position="absolute";
x38.style.left=MVUtil._f31(this._f572);
x38.style.top=MVUtil._f31(-1);
x38.style.width=MVUtil._f31(this.width-2*this._f572);
x38.style.height=MVUtil._f31(this._f572);
x38.style.fontSize=MVUtil._f31(this._f572-(_f10._f69=="IF"?3:2));
this._f577.appendChild(x38);
x38.innerHTML="<center>"+this._f580+"</center>";
}
this._f561.style.left=MVUtil._f31(0);
this._f561.style.top=this._f572+((_f10._f69=="IF")?-1:1)+"px";
this._f561.style.border=MVUtil._f31(0);
if(_f10._f69=="NS"||_f10._f69=="IF")
{
this._f561.style.width=this.width-2+"px"
this._f561.style.height=(this.height-this._f572-1)+"px";
}
else
 {
this._f561.style.width=this.width-2+"px"
this._f561.style.height=(this.height-this._f572-2)+"px";
}
if(this.html)
this._f561.innerHTML=this.html;
this.realContdiv.appendChild(this._f561);
this._f589=true;
this.n=(this.height-this._f572)/this._f574+1;
this._f162(this.realContdiv);
this._f585(this._f586);
if(this._f579)
this.collapse();
}
else
 {
x33.appendChild(this._f561);
if(this.html)
this._f561.innerHTML=this.html;
this._f585(this._f561);
if(this.width)
this._f561.style.width=MVUtil._f31(this.width);
if(this.height)
this._f561.style.height=MVUtil._f31(this.height);
this._f162(this._f561);
var x35=this;
var x39=document.createElement("img");
x39.src=_f10._f142+"pan.png";
MVUtil._f592(x39);
x39.style.zIndex=9999;
x39.style.left=MVUtil._f31(0);
x39.style.top=MVUtil._f31(-20);
x39.style.visibility="hidden";
if(_f10._f69=="NS")
{
x39.onmousedown=function(x40)
{
if(x35._f584)
{
x35.parent._f591=x35;
x35.dragStartMouseLoc=MVUtil._f175(x40);
x35.dragStartLeft=MVUtil._f83(x35._f561);
x35.dragStartTop=MVUtil._f84(x35._f561);
if(x35._f569)
x35._f569(x35.getPosition());
MVUtil.runListeners(x35._f97,MVEvent.AFTER_RESTORE,[x35.getPosition()]);
MVUtil._f174(x40);
}
}
}
this._f561.appendChild(x39);
var x41=this._f561.onmouseover;
this._f561.onmouseover=function(x42)
{
if(x41)
x41(x42);
if(x35._f584)
x39.style.visibility="visible";
}
var x43=this._f561.onmouseout;
this._f561.onmouseout=function(x44)
{
if(x43)
x43(x44);
if(x35.parent._f591!=x35)
x39.style.visibility="hidden";
}
if(this._f584)
MVUtil._f164(this._f561,"move");
else
 MVUtil._f164(this._f561,"default");
this._f561.onmousedown=function(x45)
{
if(x35._f584)
{
x35.parent._f591=x35;
x35.dragStartMouseLoc=MVUtil._f175(x45);
x35.dragStartLeft=MVUtil._f83(x35._f561);
x35.dragStartTop=MVUtil._f84(x35._f561);
if(x35._f569)
x35._f569(x35.getPosition());
MVUtil.runListeners(x35._f97,MVEvent.AFTER_RESTORE,[x35.getPosition()]);
MVUtil.trapEvent(x45);
}
else if(!x35._f173)
MVUtil.trapEvent(x45);
}
}
if(this.mapControl)
{
if(this.mapControl.setMouseCursorStyle&&this.cursorStyle)
this.mapControl.setMouseCursorStyle(this.cursorStyle,"default");
this.mapControl.init(this._f561,x32);
this.mapControl._f560=true;
}
if(!this._f579)
this._f587();
}
MVMapDecoration.prototype._f162=function(x46)
{
var x47=this;
var x48=function(x49)
{
if(!x47._f173)
MVUtil.trapEvent(x49);
}
x46.onclick=function(x50)
{
x48(x50);
if(x47._f564)
{
x47.parent._f177();
x47._f564();
}
if(x47._f97[MVEvent.MOUSE_CLICK]!=null&&x47._f97[MVEvent.MOUSE_CLICK].length!=0)
{
x47.parent._f177();
MVUtil.runListeners(x47._f97,MVEvent.MOUSE_CLICK);
}
}
x46.onmouseover=function(x51)
{
x48(x51);
if(x47._f565)
x47._f565(x51);
MVUtil.runListeners(x47._f97,MVEvent.MOUSE_OVER,[x51]);
};
x46.onmouseout=function(x52)
{
x48(x52);
if(x47._f566)
x47._f566(x52);
MVUtil.runListeners(x47._f97,MVEvent.MOUSE_OUT,[x52]);
}
x46.ondblclick=x48;
x46.onmousedown=x48;
x46.onmouseup=function(x53)
{
x48(x53);
if(x47._f584)
x47._f177();
}
x46.onkeyup=x48
if(_f10._f69=="OS")
x46.onkeypress=x48;
else
 x46.onkeydown=x48;
if(_f10._f69=="IF")
{
x46.oncontextmenu=x48;
x46.onselectstart=x48;
}
}
MVMapDecoration.prototype.setIconImageListeners=function(x54)
{
var x55;
if(this._f581)
x55=this._f581;
else if(x54)
x55=_f10._f142+"button_restore.gif";
else
 x55=_f10._f142+"button_minimize.gif";
var x56=null;
if(x54)
x56=this._f583;
else
 x56=this.icon;
x56.src=x55;
if(x54)
{
x56.style.height=MVUtil._f31(this._f572-3);
x56.style.width=MVUtil._f31(this._f572-3);
x56.parentNode.onmouseover=MVUtil._f105(x56.parentNode,function()
{
x56.parentNode.style.backgroundImage="url("+_f10._f142+"title_bg_over.png"+")";
x56.src=_f10._f142+"button_restore.gif";
});
x56.parentNode.onmouseout=MVUtil._f105(x56.parentNode,function()
{
x56.parentNode.style.backgroundImage="url("+_f10._f142+"title_bg.png"+")";
x56.src=x55;
});
var x57=this;
x56.parentNode.onclick=MVUtil._f105(x56.parentNode,function(x58)
{
MVUtil._f174(x58);
x56.parentNode.parentNode.removeChild(x56.parentNode);
MVUtil._f133(x56.parentNode);
x57._f583=null;
x57._f586.style.visibility="visible";
x57._f593();
});
}
else
 {
var x59=this.titleBg;
x56.parentNode.onmouseover=MVUtil._f105(x56.parentNode,function()
{
x59.src=_f10._f142+"title_bg_over.png";
if(x54)
x56.src=_f10._f142+"button_restore.gif";
else
 x56.src=_f10._f142+"button_minimize.gif";
});
x56.parentNode.onmouseout=MVUtil._f105(x56.parentNode,function()
{
x59.src=_f10._f142+"title_bg.png";
x56.src=x55;
});
var x57=this;
x56.onclick=MVUtil._f105(x56,function()
{
x57._f593();
});
}
}
MVMapDecoration.prototype._f223=function()
{
if(this.mapControl)
this.mapControl._f223();
if(this._f583)
{
this._f583.parentNode.parentNode.removeChild(this._f583.parentNode);
MVUtil._f133(this._f583.parentNode);
this._f583=null;
}
this.parent=null;
}
MVMapDecoration.prototype._f594=function()
{
this.setPosition(this.left,this.top,this._f138,this._f139);
}
MVMapDecoration.prototype._f595=function()
{
var x60=document.createElement("div");
x60.innerHTML=this.html;
x60.style.zIndex=2000;
x60.style.position="absolute";
if(this.collasible)
{
this._f596.style.right=MVUtil._f31(0);
this._f596.style.bottom=MVUtil._f31(0);
this._f596.style.width=MVUtil._f31(width);
this._f596.style.height=MVUtil._f31(height-this._f572);
this._f596.style.border="1px solid black";
this._f596.style.backgroundColor="white";
}
else{
this._f585(x60);
if(this.width)
x60.style.width=this.width;
if(this.height)
x60.style.height=this.height;
return x60;
}
}
MVMapDecoration.prototype._setTimeoutDispatcher=function(func)
{
eval(func);
}
MVMapDecoration.prototype._f587=function()
{
if(this.visible)
this._f561.style.visibility="visible";
else
 this._f561.style.visibility="hidden";
if(this._f562)
{
if(this.visible&&!this.collapsed)
this._f586.style.visibility="visible";
else
 this._f586.style.visibility="hidden";
if(!this.collapsed&&this.parent._f215&&this.parent._f215._f204&&
this._f561._f216&&this.parent)
{
this.parent._f215._f222();
}
if(this._f583&&!this.visible)
{
this._f583.parentNode.parentNode.removeChild(this._f583.parentNode);
MVUtil._f133(this._f583.parentNode);
this._f583=null;
}
else if(this.visible&&this.collapsed)
this._f590();
}
}
MVMapDecoration.prototype._f593=function()
{
if(this._f578!=null&&this._f578!="")
return;
var x61=15;
if(this._f589)
{
if(this._f567)
this._f567();
MVUtil.runListeners(this._f97,MVEvent.COLLAPSE);
this._f578=this.setTimeout("this.scrollElement(-1)",10);
}
else
 {
if(this._f568)
this._f568();
MVUtil.runListeners(this._f97,MVEvent.RESTORE);
this._f585(this._f586,true);
this._f578=this.setTimeout("this.scrollElement(1)",10);
}
}
MVMapDecoration.prototype._f590=function()
{
this._f583=document.createElement("img");
var x62=document.createElement("td");
x62.style.border="1px Solid #636661";
x62.style.backgroundImage="url("+_f10._f142+"title_bg.png"+")";
x62.appendChild(this._f583);
if(this._f582)
x62.title=this._f582;
MVUtil._f164(x62,"pointer");
this.parent.toolBarContainer.appendChild(x62);
this.setIconImageListeners(true);
}
MVMapDecoration.prototype.scrollElement=function(x63)
{
var x64=parseInt(this._f586.style.height);
var x65=parseInt(this._f561.style.height);
var x66=parseInt(this._f586.style.width);
var x67=parseInt(this._f561.style.width);
var x68=MVUtil._f84(this._f586);
var x69=MVUtil._f83(this._f586);
if(x63<0)
{
if(x65>1)
{
if(x65>this._f574)
{
if(x68<this.parent._f109())
{
MVUtil._f73(this._f586,x69+this._f575,x68+this._f576);
this._f578=this.setTimeout("this.scrollElement(-1)",20);
}
else
 this.collapse();
}
else
 this.collapse();
}
else
 this.collapse();
}
if(x63>0)
{
x65+=this._f574;
x67+=this._f573;
x64+=this._f574;
x66+=this._f573;
x68-=this._f576;
x69-=this._f575;
var x70=false;
if(this._f418<x68)
MVUtil._f73(this._f586,x69,x68);
else
 x70=true;
if(x70)
{
this._f589=true;
clearTimeout(this._f578);
this._f578=null;
this.setIconImageListeners(false);
MVUtil._f73(this._f586,this._f417,this._f418);
this.collapsed=false;
this._f561.style.visibility="visible";
if(this._f561._f216&&this.parent)
{
var x71=this.parent.getCenter();
this.parent._f215._f211=true;
this.parent._f215._f206.setCenter(x71,true);
this.parent._f215._f206.display();
this.parent._f215._f222();
}
if(this.afterRestoreListener)
this.afterRestoreListener();
MVUtil.runListeners(this._f97,MVEvent.AFTER_RESTORE);
}
else
 {
this._f578=this.setTimeout("this.scrollElement(1)",20);
}
}
}
MVMapDecoration.prototype.setTimeout=function(_f149,_f150)
{
var Ie="tempVar"+_f265;
_f265++;
eval(Ie+" = this;");
var oi=_f149.replace(/\\/g,"\\\\");
oi=oi.replace(/\"/g,'\\"');
return window.setTimeout(Ie+'._setTimeoutDispatcher("'+oi+'");'+Ie+" = null;",_f150);
}
MVMapDecoration.prototype._f177=function()
{
var x72=this._f586;
if(!this._f562)
x72=this._f561;
this.left=(MVUtil._f83(x72)-this._f138)/this.parent._f108();
this.top=(MVUtil._f84(x72)-this._f139)/this.parent._f109();
this.parent._f591=null;
if(this._f571)
this._f571(this.getPosition());
MVUtil.runListeners(this._f97,MVEvent.DRAG,[this.getPosition()]);
}
MVMapDecoration.prototype._f73=function(x73,x74)
{
var x75=this._f586;
if(!this._f562)
x75=this._f561;
MVUtil._f73(x75,x73,x74);
}
function MVBarInfo(x0,x1)
{
this.name=x0;
this.color=null;
if(x1)
{
if(x1.charAt(0)=='#')
this.color=x1.substring(1,x1.length);
else
 this.color=x1;
}
this.color_opacity=255;
}
function MVBarChartStyle(x0,x1,x2,x3)
{
this.name=x0;
this.width=x1;
this.height=x2;
this.bars=x3;
this.minValue=null;
this.maxValue=null;
this.shareScale=true;
this.showXAxis=false;
}
MVBarChartStyle.prototype.setMinValue=function(x0)
{
this.minValue=x0;
}
MVBarChartStyle.prototype.setMaxValue=function(x1)
{
this.maxValue=x1;
}
MVBarChartStyle.prototype.setShareScale=function(x2)
{
this.shareScale=x2;
}
MVBarChartStyle.prototype.setShowXAxis=function(x3)
{
this.showXAxis=x3;
}
MVBarChartStyle.prototype.getXMLString=function()
{
var x4=
'<style name="'+this.name+'">'+
'<AdvancedStyle><BarChartStyle'+
' width="'+this.width+'" height="'+this.height+'"';
if(this.shareScale==true)
{
x4=x4+' share_scale="true"';
}
if(this.maxValue&&this.minValue)
{
x4=x4+' min_value="'+this.minValue+'" max_value="'+this.maxValue+'"';
}
if(this.showXAxis)
{
x4=x4+' show_x_axis="true"';
}
x4=x4+'>';
if(this.bars!=null)
{
for(var x5=0;x5<this.bars.length;x5++)
{
var x6=this.bars[x5];
x4=x4+' <Bar name="'+x6.name+'"';
if(x6.color!=null)
x4=x4+' color="#'+x6.color+'"';
x4=x4+' />';
}
}
x4+=' </BarChartStyle></AdvancedStyle></style>';
return x4;
}
function MVPieSlice(x0,x1)
{
this.name=x0;
this.color=null;
if(x1)
{
if(x1.charAt(0)=='#')
this.color=x1.substring(1,x1.length);
else
 this.color=x1;
}
this.color_opacity=255;
}
MVPieSlice.prototype.setColorOpacity=function(x0)
{
this.color_opacity=x0;
}
function MVPieChartStyle(x0,x1,x2)
{
this.name=x0;
this._f194=x1;
this.slices=x2;
}
MVPieChartStyle.prototype.getXMLString=function()
{
var x1='<style name="'+this.name+'">'+
'<AdvancedStyle><PieChartStyle '+
'pieradius="'+this._f194+'">';
if(this.slices!=null)
{
for(var x2=0;x2<this.slices.length;x2++)
{
var x3=this.slices[x2];
if(x3!=null)
{
x1=x1+' <PieSlice name="'+x3.name+'"';
if(x3.color!=null)
x1=x1+' color="#'+x3.color+'" />';
}
}
}
x1=x1+' </PieChartStyle></AdvancedStyle></style>';
return x1;
}
function MVCollectionBucket(x0,x1,x2,x3)
{
if(x2==null)
this.type="string";
else
 this.type=x2;
if(x3==null)
this.delimiter=",";
else
 this.delimiter=x3;
this.renderingStyle=x0;
this.label=x1;
this.items=null;
}
MVCollectionBucket.prototype.setItems=function(x0)
{
if(x0==null)
this.items=null;
this.items=x0;
}
MVCollectionBucket.prototype.getXMLString=function()
{
var x1=(this.label==null)?"":'label="'+this.label+'" ';
var x2="<CollectionBucket "+x1;
var x3=(this.type==null)?"":'type="'+this.type+'" ';
var x4=(this.delimiter==null)?"":'delimiter="'+this.delimiter+'" ';
var x5=(this.renderingStyle==null)?"":'style="'+this.renderingStyle+'" ';
x2+=x3+x4+x5+">"+this.items+"</CollectionBucket>";
return x2;
}
function MVScaleBar(x0,x1)
{
this.type="MVScaleBar";
this._f203=true;
this._f622=x1?x1:125;
this._f398=x0;
this._f560=false;
this.topBarHeight=10;
this.topBarLeftImg=_f10._f142+"scale/"+"bar_light_left.png";
this.topBarLeftImgWidth=5;
this.topBarBodyImg=_f10._f142+"scale/"+"bar_light_bg.png";
this.topBarRightImg=_f10._f142+"scale/"+"bar_light_right.png";
this.topBarRightImgWidth=6;
this.bottomBarHeight=10;
this.bottomBarLeftImg=_f10._f142+"scale/"+"bar_dark_left.png";
this.bottomBarLeftImgWidth=5;
this.bottomBarBodyImg=_f10._f142+"scale/"+"bar_dark_bg.png";
this.bottomBarRightImg=_f10._f142+"scale/"+"bar_dark_right.png";
this.bottomBarRightImgWidth=6;
this.textSize=11;
this._f623=null;
this._f122=false;
}
MVScaleBar.prototype.init=function(x0,x1)
{
this.div=x0;
this._f624(x1);
}
MVScaleBar.prototype._f624=function(x2,x3,x4)
{
if(!x3)
x2._f626=this;
this._f623=x2;
if(!this.div)
{
this.div=document.createElement("div");
this.div.style.zIndex=2000;
if(x3)
x3.appendChild(this.div);
else
 x2._f219.appendChild(this.div);
}
this._f627=document.createElement("div");
this._f628=document.createElement("div");
MVUtil._f592(this.div);
MVUtil._f592(this._f627);
MVUtil._f592(this._f628);
this.div.style.height=MVUtil._f31(40);
this.div.style.width=MVUtil._f31(125);
this.div.style.fontSize=MVUtil._f31(5);
var x5=this;
var x6=function(x7)
{
var x8=x7.fpsLength;
var x9=x7.metricLength;
var x10=Math.max(x8,x9);
var x11=3;
MVUtil._f629(x5._f627,8,0,x10,x11,10,11);
x5._f630(x5._f627,x7.fpsText);
var x12=x11+x5.textSize;
x5.topBar=x5._f631(x8,x5.topBarHeight,3,x12,x5.topBarLeftImg,x5.topBarLeftImgWidth,x5.topBarBodyImg,x5.topBarRightImg,x5.topBarRightImgWidth);
x5.bottomBar=x5._f631(x9,x5.bottomBarHeight,3,x12+x5.topBarHeight,x5.bottomBarLeftImg,x5.bottomBarLeftImgWidth,x5.bottomBarBodyImg,x5.bottomBarRightImg,x5.bottomBarRightImgWidth);
MVUtil._f629(x5._f628,8,x12+x5.topBarHeight+x5.bottomBarHeight-4,x10,0,10,11);
x5._f630(x5._f628,x7.metricText);
x5.div.appendChild(x5._f627);
x5.div.appendChild(x5._f628);
x5.div.title=MVi18n._f342("scaleBarInfoTip");
x5._f632();
x5._f122=true;
if(x4)
x4(x5.div);
}
this._f633(x2,this._f622,x6);
}
MVScaleBar.prototype._f631=function(x13,x14,x15,x16,x17,x18,x19,x20,x21)
{
var x22=document.createElement("div");
x22.style.position="absolute";
MVUtil._f73(x22,x15,x16);
x22.appendChild(new _f285(x17,x18,x14,0,0,8,true));
var x23=new _f285(x19,x13-x18-x21,x14,x18,0,8,true);
x22.appendChild(x23);
x22.appendChild(new _f285(x20,x21,x14,x13-x21,0,8,true));
this.div.appendChild(x22);
return x22;
}
MVScaleBar.prototype._f632=function()
{
if(!this.div)
return ;
var x24="black";
this._f627.style.color=x24;
this._f628.style.color=x24;
}
MVScaleBar.prototype._f634=function(x25)
{
if(!this.div||!this._f122)
return ;
var x26=this;
var x27=function(x28)
{
var x29=Math.max(x28.fpsLength,x28.metricLength);
x26._f630(x26._f627,x28.fpsText);
x26._f630(x26._f628,x28.metricText);
x26.width=x29+4;
x26.topBar.childNodes[1].style.width=MVUtil._f31(x28.fpsLength-x26.topBarLeftImgWidth-x26.topBarRightImgWidth);
x26.topBar.childNodes[2].style.left=MVUtil._f31(x28.fpsLength-x26.topBarRightImgWidth);
x26.bottomBar.childNodes[1].style.width=MVUtil._f31(x28.metricLength-x26.bottomBarLeftImgWidth-x26.bottomBarRightImgWidth);
x26.bottomBar.childNodes[2].style.left=MVUtil._f31(x28.metricLength-x26.bottomBarRightImgWidth);
x26._f628.style.width=MVUtil._f31(x28.metricLength+2);
x26._f627.style.width=MVUtil._f31(x28.fpsLength+2);
}
this._f633(x25,this._f622,x27);
}
MVScaleBar.prototype._f633=function(x30,x31,x32)
{
var x33;
var x34;
var x35;
var x36;
var x37;
var x38;
var x39=x30.msi._f517();
var x40=x30.msi._f516();
var x41=this;
var x42=function()
{
x36=x41._f635(x35);
if(x36>=1000)
{
var x43=x41._f635(x35/1000);
var x44=x35/1000;
x38=Math.round(x41._f622*x43/x44);
x37=MVUtil.formatNum(x43)+" "+MVi18n._f342("kilometers");
}
else
 {
x38=Math.round(x41._f622*x36/x35);
x37=MVUtil.formatNum(x36)+" "+MVi18n._f342("meters");
}
var x45=x35/1609.344;
var x46=x35*3.28084;
var x47;
var x48;
if(x45>=1)
{
var x49=x41._f635(x45);
x47=Math.round(x41._f622*x49/x45);
x48=MVUtil.formatNum(x49)+" "+MVi18n._f342("miles");
}
else
 {
var x50=x41._f635(x46);
x47=Math.round(x41._f622*x50/x46);
x48=MVUtil.formatNum(x50)+" "+MVi18n._f342("feet");
}
return new _f636(x47,x38,x48,x37);
}
if(x40=='GEODETIC')
{
var x51=function(x52)
{
x34=x52;
var x53=6378137.0;
var x54=0.9966471893352525;
var x55=0.0033528106647474805;
x35=MVScaleBar._f637(x33,x34,x53,x54,x55);
x32(x42());
}
var x56=function(x57)
{
x33=x57;
MVScaleBar._f638(x30._f639+x31/2,x30._f640,x30,x51);
}
MVScaleBar._f638(x30._f639-x31/2,x30._f640,x30,x56);
return ;
}
else if(x40=='PROJECTED')
{
if(this._f398==true)
{
var x58=x31/2;
var x59=x30._f94-x58/x30._f75;
var x60=x58/x30._f75+x30._f94;
var x61=x30._f95;
var x62=MVSdoGeometry.createLineString([x59,x61,x60,x61],x30.srid);
var x63=function(x64)
{
x35=x64;
x32(x42());
}
x35=x62.getLength("meter",true,x30._f4+'/foi',x63);
return ;
}
else
 {
x35=x39*x31/x30._f75;
}
}
else if(x40=='LOCAL'||(x40=='UNDEFINED'&&x39!=0))
{
x35=x39*x31/x30._f75;
}
else if(x40=='UNDEFINED'&&x39==0)
{
x35=x31/x30._f75;
_f10._f641='';
_f10._f642='';
_f10._f643='';
_f10._f644='';
}
x32(x42());
}
MVScaleBar.prototype._f635=function(x65)
{
var x66=x65;
if(x66>1)
{
var x67=0;
while(x66>=10){x66=x66/10;x67=x67+1;}
if(x66>=5){x66=5;}
else if(x66>=2){x66=2;}
else {x66=1;}
while(x67>0){x66=x66*10;x67=x67-1;}
}
return x66;
}
MVScaleBar.prototype._f630=function(x68,x69)
{
x68.style.font="Bold 11px Tahoma";
if(x68.innerHTML!=x69)
{
x68.innerHTML=x69;
}
}
MVScaleBar.prototype._f223=function()
{
this._f623._f626=null;
}
MVScaleBar._f638=function(x70,x71,x72,x73)
{
var x74=MVSdoGeometry.createPoint(0,0,x72.srid);
x74.sdo_point.x=(x70-x72._f639)/x72._f75+x72._f94;
x74.sdo_point.y=x72._f95-(x71-x72._f640)/x72._f77;
var x75=function(x76)
{
if(x76)
x74=x76;
while(x74.sdo_point.x<-180)x74.sdo_point.x+=360;
while(x74.sdo_point.x>180)x74.sdo_point.x-=360;
x74.sdo_point.x=(x74.sdo_point.x)*Math.PI/180;
x74.sdo_point.y=(x74.sdo_point.y)*Math.PI/180;
x73(x74.sdo_point);
}
if(x74.srid&&x74.srid!=8307)
x74=x72.transformGeom(x74,8307,null,x75);
else
 x75();
}
MVScaleBar._f637=function(x77,x78,x79,x80,x81)
{
var x82;var x83;var x84;var x85;var x86;var x87;var x88;var x89;var x90;var x91;
var x92;var x93;var x94;var x95;var x96;
var x97;var x98;var x99;var x100;var x101;var x102;
var x103=Math.PI/2.0;
if(x103-Math.abs(x77.y)<1.e-10)
x95=x77.y;
else
 x95=Math.atan(x80*Math.tan(x77.y));
if(x103-Math.abs(x78.y)<1.e-10)
x96=x78.y;
else
 x96=Math.atan(x80*Math.tan(x78.y));
x83=(x95+x96)/2.0;
x84=(x95-x96)/2.0;
x82=Math.abs(x77.x-x78.x);
if(x82>Math.PI)
x82=2.0*Math.PI-x82;
x82/=2.0;
if(x82<5.e-8&&Math.abs(x84)<5.e-8)
return 0.0;
else if((x103-x82<5.e-8&&Math.abs(x83)<5.e-8)||
x103-Math.abs(x84)<5.e-8)
return -1.0;
x97=Math.sin(x83);
x98=Math.cos(x83);
x99=Math.sin(x84);
x100=Math.cos(x84);
x101=Math.sin(x82);
x85=x99*x99+x101*x101*(x100*x100-x97*x97);
x86=Math.acos(1.0-2.0*x85);
x102=Math.sin(x86);
x87=2.0*(1.0-2.0*x85);
x88=2.0*x97*x97*x100*x100/(1.0-x85);
x89=2.0*x99*x99*x98*x98/x85;
x90=x88+x89;
x91=x88-x89;
x92=x86/x102;
x93=4.0*x92*x92;
x94=x93*x87;
var x104=(x94+(x92-(x94-x87)/2.0)*x90);
return x79*x102*(x92-x81*(x92*x90-x91)/4.0+x81*x81*
(x90*x104-x91*(2.0*x93+x87*x91)+x93*x90*x91)/64.0);
}
function _f636(x0,x1,x2,x3)
{
this.fpsLength=x0;
this.metricLength=x1;
this.fpsText=x2;
this.metricText=x3;
}
function MVNavigationPanel(x0,x1,x2,x3)
{
this.type="MVNavigationPanel";
this._f203=true;
if(x0==undefined||
x0!=0&&x0!=4&&x0!=8)
x0=8;
this._f843=x0;
this._f844=x1;
this._f845=x2;
this.zoomLevelBars=x3;
this._f846=null;
this._f831=null;
this._f623=null;
this.containerDiv=null;
this._f122=false;
this.infoTipDivs=new Object();
this.infoTipTexts=null;
this.infoTipTextStyle=null;
var x4=this;
this.hideInfoTimeOut;
this.showInfoTip=function()
{
clearTimeout(x4.hideInfoTimeOut);
for(div in x4.infoTipDivs){
x4.infoTipDivs[div].style.visibility="";
}
}
this._f189=function()
{
x4.hideInfoTimeOut=setTimeout(x4.doHideInfoTip,500);
}
this.doHideInfoTip=function()
{
for(div in x4.infoTipDivs)
{
x4.infoTipDivs[div].style.visibility="hidden";
}
}
}
MVNavigationPanel.prototype.setZoomLevelInfoTips=function(x0,x1)
{
this.infoTipTexts=x0;
this.infoTipTextStyle=x1;
}
MVNavigationPanel.prototype.setNavPosition=function(x2)
{
this._f831=x2;
}
MVNavigationPanel.prototype.init=function(x3,x4)
{
if(x3)
this.containerDiv=x3;
if(this._f846)
{
if(this._f846.parentNode)
this._f846.parentNode.removeChild(this._f846);
MVUtil._f133(this._f846);
}
this._f846=document.createElement('div');
this._f846.style.position='absolute';
this._f846.className="noprint";
this.containerDiv.appendChild(this._f846);
if(x4)
{
this._f623=x4;
x4.navigationPanel=this;
}
if(this._f831)
{
if(this._f831.toLowerCase()=="east")
{
if(this._f843==8)
this._f846.style.left=MVUtil._f31(this._f623._f108()-80);
else if(this._f843==4)
this._f846.style.left=MVUtil._f31(this._f623._f108()-80);
else if(this._f843==0)
this._f846.style.left=MVUtil._f31(this._f623._f108()-50);
}
else
 {
if(this._f843==8)
this._f846.style.left=MVUtil._f31(10);
else if(this._f843==8)
this._f846.style.left=MVUtil._f31(10);
else if(this._f843==0)
this._f846.style.left=MVUtil._f31(30);
}
this._f846.style.top=MVUtil._f31(10);
}
else
 {
this._f846.style.left=MVUtil._f31(0);
this._f846.style.top=MVUtil._f31(0);
}
this._f846.style.zIndex=2000;
MVUtil._f164(this._f846,"pointer");
this._f543=0;
this._f544=0;
var x4=this._f623;
var x5=function(x6)
{
if(x4._f704&&x4._f708)
{
x4._f705.clear();
x4.marqueeZoom();
}
x6=(x6)?x6:((window.event)?event:null);
MVUtil._f174(x6);
}
if(this._f843!=false)
{
this._f847();
}
this._f539=0;
this._f540=0;
if(this._f844!=false)
{
this._f539=_f10._f539;
this._f540=_f10._f540;
}
this._f547=0;
this._f548=0;
if(this._f845!=false)
{
this._f547=_f10._f547;
this._f548=_f10._f548;
var x7=new _f830(this._f846,src=_f10._f142+"navicons/zoomin.gif",
this._f547,this._f548,2000,MVi18n._f342("zoomInInfoTip"));
var x8=this._f843>0?(this._f543*3-this._f547)/2+1:0;
var x9=this._f843>0?this._f544*3+3:0;
MVUtil._f73(x7,x8,x9);
x7.onmousedown=MVUtil._f105(x7,function(x10)
{
x10=(x10)?x10:((window.event)?event:null);
MVUtil._f174(x10);
if(x4._f704&&x4._f706)
x4._f708=true;
x4.zoomIn();
});
x7.onmouseup=MVUtil._f105(x7,function(x11)
{
x5(x11);
});
x7.onmouseover=this.showInfoTip;
x7.onmouseout=this._f189;
var x12=new _f830(this._f846,_f10._f142+"navicons/zoomout.gif",
this._f547,this._f548,2000,MVi18n._f342("zoomOutInfoTip"));
MVUtil._f73(x12,x8,x9+this._f548+this._f540+1);
x12.onmousedown=MVUtil._f105(x12,function(x13)
{
x13=(x13)?x13:((window.event)?event:null);
MVUtil._f174(x13);
if(x4._f704&&x4._f706)
x4._f708=true;
x4.zoomOut();
});
x12.onmouseup=MVUtil._f105(x12,function(x14)
{
x5(x14);
});
x12.onmouseover=this.showInfoTip;
x12.onmouseout=this._f189;
}
if(this._f844!=false)
{
this._f848=new MVZoomBarAndPin(this);
}
this._f122=true;
}
MVNavigationPanel.prototype._f847=function()
{
this._f543=_f10._f543;
this._f544=_f10._f544;
var x15=this._f623;
var x16=function(x17)
{
if(x15._f704&&x15._f708)
{
x15._f705.clear();
x15.marqueeZoom();
}
x17=(x17)?x17:((window.event)?event:null);
MVUtil._f174(x17);
}
var x18=new _f830(this._f846,_f10._f142+"navicons/north.gif",
this._f543,this._f544,2000,MVi18n._f342("panNInfoTip"));
MVUtil._f73(x18,this._f543+1,0);
x18.onmousedown=MVUtil._f105(x18,function(x19)
{
if(x15._f704&&x15._f706)
x15._f708=true;
x15.smoothScroll(0,(x15._f108()+x15._f109())*(-0.25));
x19=(x19)?x19:((window.event)?event:null);
MVUtil._f174(x19);
});
x18.onmouseup=MVUtil._f105(x18,function(x20)
{
x16(x20);
});
var x21=new _f830(this._f846,_f10._f142+"navicons/west.gif",
this._f543,this._f544,2000,MVi18n._f342("panWInfoTip"));
MVUtil._f73(x21,0,this._f544+1);
x21.onmousedown=MVUtil._f105(x21,function(x22)
{
if(x15._f704&&x15._f706)
x15._f708=true;
x15.smoothScroll((x15._f108()+x15._f109())*(-0.25),0);
x22=(x22)?x22:((window.event)?event:null);
MVUtil._f174(x22);
});
x21.onmouseup=MVUtil._f105(x21,function(x23)
{
x16(x23);
});
var x24=new _f830(this._f846,_f10._f142+"navicons/east.gif",
this._f543,this._f544,2000,MVi18n._f342("panEInfoTip"));
MVUtil._f73(x24,this._f543*2+2,this._f544+1);
x24.onmousedown=MVUtil._f105(x24,function(x25)
{
if(x15._f704&&x15._f706)
x15._f708=true;
x15.smoothScroll((x15._f108()+x15._f109())*(0.25),0);
x25=(x25)?x25:((window.event)?event:null);
MVUtil._f174(x25);
});
x24.onmouseup=MVUtil._f105(x24,function(x26)
{
x16(x26);
});
var x27=new _f830(this._f846,_f10._f142+"navicons/south.gif",
this._f543,this._f544,2000,MVi18n._f342("panSInfoTip"));
MVUtil._f73(x27,this._f543+1,this._f544*2+2);
x27.onmousedown=MVUtil._f105(x27,function(x28)
{
if(x15._f704&&x15._f706)
x15._f708=true;
x15.smoothScroll(0,(x15._f108()+x15._f109())*(0.25));
x28=(x28)?x28:((window.event)?event:null);
MVUtil._f174(x28);
});
x27.onmouseup=MVUtil._f105(x27,function(x29)
{
x16(x29);
});
if(this._f843==4)
return ;
var x30=new _f830(this._f846,_f10._f142+"navicons/nw.gif",
this._f543,this._f544,200,MVi18n._f342("panNWInfoTip"));
MVUtil._f73(x30,0,0);
x30.onmousedown=MVUtil._f105(x30,function(x31)
{
if(x15._f704&&x15._f706)
x15._f708=true;
x15.smoothScroll((x15._f108()+x15._f109())*(-0.18),(x15._f108()+x15._f109())*(-0.18));
x31=(x31)?x31:((window.event)?event:null);
MVUtil._f174(x31);
});
x30.onmouseup=MVUtil._f105(x30,function(x32)
{
x16(x32);
});
var x33=new _f830(this._f846,_f10._f142+"navicons/ne.gif",
this._f543,this._f544,2000,MVi18n._f342("panNEInfoTip"));
MVUtil._f73(x33,this._f543*2+2,0);
x33.onmousedown=MVUtil._f105(x33,function(x34)
{
if(x15._f704&&x15._f706)
x15._f708=true;
x15.smoothScroll((x15._f108()+x15._f109())*(0.18),(x15._f108()+x15._f109())*(-0.18));
x34=(x34)?x34:((window.event)?event:null);
MVUtil._f174(x34);
});
x33.onmouseup=MVUtil._f105(x33,function(x35)
{
x16(x35);
});
var x36=new _f830(this._f846,_f10._f142+"navicons/sw.gif",
this._f543,this._f544,2000,MVi18n._f342("panSWInfoTip"));
MVUtil._f73(x36,0,this._f544*2+2);
x36.onmousedown=MVUtil._f105(x36,function(x37)
{
if(x15._f704&&x15._f706)
x15._f708=true;
x15.smoothScroll((x15._f108()+x15._f109())*(-0.18),(x15._f108()+x15._f109())*(0.18));
x37=(x37)?x37:((window.event)?event:null);
MVUtil._f174(x37);
});
x36.onmouseup=MVUtil._f105(x36,function(x38)
{
x16(x38);
});
var x39=new _f830(this._f846,_f10._f142+"navicons/se.gif",
this._f543,this._f544,2000,MVi18n._f342("panSEInfoTip"));
MVUtil._f73(x39,this._f543*2+2,this._f544*2+2);
x39.onmousedown=MVUtil._f105(x39,function(x40)
{
if(x15._f704&&x15._f706)
x15._f708=true;
x15.smoothScroll((x15._f108()+x15._f109())*(0.18),(x15._f108()+x15._f109())*(0.18));
x40=(x40)?x40:((window.event)?event:null);
MVUtil._f174(x40);
});
x39.onmouseup=MVUtil._f105(x39,function(x41)
{
x16(x41);
});
if(x15._f700){
var x42=new _f830(this._f846,_f10._f142+"navicons/center.gif",
this._f543,this._f544,2000,MVi18n._f342("panCenterInfoTip"));
MVUtil._f73(x42,this._f543+1,this._f544+1);
x42.onmousedown=MVUtil._f105(x42,function(x43)
{
if(x15._f704&&x15._f706)
x15._f708=true;
x15.setCenterAndZoomLevel(x15._f700,x15._f701);
x43=(x43)?x43:((window.event)?event:null);
MVUtil._f174(x43);
});
x42.onmouseup=MVUtil._f105(x42,function(x44)
{
x16(x44);
});
}
}
MVNavigationPanel.prototype.updateSliderBar=function()
{
if(!this._f122)
return ;
if(this._f848&&this._f848._f849)
this._f848._f849.style.top=
MVUtil._f31(this._f544*3+3+this._f548+
(this._f540-_f10._f542)*
(this._f623._f697-this._f623._f20)/this._f623._f697);
}
MVNavigationPanel.prototype._f223=function()
{
this._f623.navigationPanel=null;
}
function MVZoomBarAndPin(x0)
{
var x1=x0;
this.div=document.createElement("div");
var x2=x1._f843>0?(x1._f543*3-x1._f539)/2+1:0;
var x3=x1._f843>0?x1._f544*3+3+x1._f548:x1._f548;
this._f850=new _f830(this.div,_f10._f142+"navicons/zoombar.gif",
x1._f539,x1._f540,2000,MVi18n._f342("sliderBarInfoTip"));
this._f850.onmouseover=x0.showInfoTip;
this._f850.onmouseout=x0._f189;
MVUtil._f73(this._f850,x2,x3);
if(x0.zoomLevelBars!=false)
{
for(var x4=0;x4<=x1._f623._f697;x4++)
{
var x5=x1._f539-4;
var x6=new _f830(this.div,_f10._f142+"navicons/zoomBarHoriz.gif",
x5,10,1999);
MVUtil._f73(x6,x2+2,x3+2+x4*(x1._f540-14)/x1._f623._f697);
for(tipLevel in x0.infoTipTexts)
{
if(parseInt(tipLevel)==(x1._f623._f697-x4))
{
this.infoDiv=document.createElement("div");
this.infoDiv.style.height=16;
this.infoDiv.style.position="absolute";
this.infoDiv.style.opacity=0.6;
this.infoDiv.style.filter="alpha(opacity = 60)";
this.infoDivTable=document.createElement("Table");
this.infoDivTable.cellSpacing=0;
this.infoDivTable.cellPadding=0;
this.infoDivTable.style.border=0;
this.infoDivRow=this.infoDivTable.insertRow(0);
this.infoDivLeft=this.infoDivRow.insertCell(0);
this.infoDivCenter=this.infoDivRow.insertCell(1);
this.infoDivCenter.style.background="url("+_f10._f142+"navicons/tip_center.gif"+") repeat-x";
this.infoDivRight=this.infoDivRow.insertCell(2);
this.infoDivCenter.innerHTML=x0.infoTipTexts[tipLevel];
this.infoDivCenter.style.fontSize="12px";
this.infoDivCenter.style.fontWeight="bold";
this.infoDivCenter.style.fontFamily="Verdana,Tahoma";
this.infoDivCenter.style.cssText=this.infoDivCenter.style.cssText+"; "+x0.infoTipTextStyle;
this.infoDiv.appendChild(this.infoDivTable);
if(x1._f831&&x1._f831.toLowerCase()=="east")
{
this.infoDivLeft.innerHTML='<img border="0" src="'+_f10._f142+'navicons/tip_east_end.gif"/>';
this.infoDivRight.innerHTML='<img border="0" src="'+_f10._f142+'navicons/tip_east_start.gif"/>';
this.infoDivCenter.style.textAlign="left";
this.infoDivCenter.style.align="left";
this.infoDivCenter.style.direction="RTL"
if(_f10._f362==2)
{
this.infoDiv.style.pixelRight=x2-22;
this.infoDiv.style.pixelTop=x3+x4*(x1._f540-16)/x1._f623._f697;
}
else
 {
this.infoDiv.style.right=MVUtil._f31(x2-22);
this.infoDiv.style.top=MVUtil._f31(x3+x4*(x1._f540-16)/x1._f623._f697);
}
}
else
 {
this.infoDivLeft.innerHTML='<img border="0" src="'+_f10._f142+'navicons/tip_start.gif"/>';
this.infoDivRight.innerHTML='<img border="0" src="'+_f10._f142+'navicons/tip_end.gif"/>';
this.infoDivCenter.style.textAlign="right";
this.infoDivCenter.style.align="right";
MVUtil._f73(this.infoDiv,x2+16,x3+x4*(x1._f540-16)/x1._f623._f697);
}
this.infoDiv.style.visibility="hidden";
this.infoDiv._f20=x1._f623._f697-x4;
this.div.appendChild(this.infoDiv);
x0.infoTipDivs["div"+x4]=this.infoDiv;
var x7=function(x8)
{
clearTimeout(x0.hideInfoTimeOut);
this.style.opacity=0.9;
this.style.filter="alpha(opacity = 90)";
}
var x9=function(x10)
{
this.style.opacity=0.6;
this.style.filter="alpha(opacity = 60)";
x0.hideInfoTimeOut=setTimeout(x0.doHideInfoTip,500);
}
var x11=function(x12)
{
x0._f623.zoomTo(this._f20)
x12=(x12)?x12:((window.event)?event:null);
MVUtil._f174(x12);
}
this.infoDiv.onmouseover=MVUtil._f105(this.infoDiv,x7);
this.infoDiv.onmouseout=MVUtil._f105(this.infoDiv,x9);
this.infoDiv.onmousedown=MVUtil._f105(this.infoDiv,x11);
}
}
}
}
this._f849=new _f830(this.div,_f10._f142+"navicons/slider.gif",_f10._f541,
_f10._f542,2002);
this._f849.onmouseover=x0.showInfoTip;
this._f849.onmouseout=x0._f189;
MVUtil._f73(this._f849,x2,x3+
(x1._f540-_f10._f542)*
(x1._f623._f697-x1._f623._f20)/x1._f623._f697);
x1._f846.appendChild(this.div);
this._f851=Math.floor(_f10._f542/2);
var x13=0;
var x14=0;
var x15=function(x16)
{
x1._f623._f688=false;
x16=(x16)?x16:((window.event)?event:null);
var x17=x1._f623._f224(x16);
var x18=x17.top-x1._f848._f851;var x19=x1._f544*3+3+x1._f548;
if(x18<=x19)
x18=x19;
else if(x18>=x19+x1._f540-_f10._f542)
x18=x19+x1._f540-_f10._f542;
var x20=(x1._f540-_f10._f542);
x20=x20/x1._f623._f697;
var x21=Math.floor((x18-x19)/x20);
x18=x21*x20+x19;
var x22=x1._f623._f697-x21;
x1._f623.zoomTo(x22);
MVUtil._f174(x16);
if(x1._f623._f704&&x1._f623._f706)
{
x1._f623._f708=true;
x1._f623._f705.clear();
}
x1._f848._f849.style.top=MVUtil._f31(x18);
}
var x23=function(x24)
{
x24=(x24)?x24:((window.event)?event:null);
x1._f623._f688=false;
if(!x1._f848._f852)return;
var x25=x1._f623._f224(x24);
var x26=x25.top-x13+x14;
if(x26<=x1._f544*3+3+x1._f548)
x26=x1._f544*3+3+x1._f548;
else if(x26>=x1._f544*3+3+x1._f548+
x1._f540-_f10._f542)
x26=x1._f544*3+3+x1._f548+
x1._f540-_f10._f542;
x1._f848._f849.style.top=MVUtil._f31(x26);
MVUtil._f174(x24);
}
var x27=function(x28)
{
if(!x1._f848._f852)
return ;
x28=(x28)?x28:((window.event)?event:null);
x1._f623._f688=true;
x1._f848._f852=false;
var x29=x1._f623._f224(x28);
var x30=MVUtil._f84(x1._f848._f849);
var x31=x1._f544*3+3+x1._f548;
var x32=(x1._f540-_f10._f542);
x32=x32/x1._f623._f697;
var x33=Math.round((x30-x31)/x32);
x30=x33*x32+x31;
var x34=x1._f623._f697-x33;
x1._f623.zoomTo(x34);
x1._f848._f849.style.top=MVUtil._f31(x30);
x1._f623.zoomTo(x34);
MVUtil._f174(x28);
if(x1._f623._f704&&x1._f623._f708)
x1._f623.marqueeZoom();
}
var x35=function(x36)
{
x36=(x36)?x36:((window.event)?event:null);
x1._f623._f688=true;
if(x1._f848._f852)
{
x27(x36);
}
return false;
}
var x37=function(x38)
{
x38=(x38)?x38:((window.event)?event:null);
var x39=x1._f623._f224(x38);
x13=x39.top;
x14=MVUtil._f84(x1._f848._f849);
x1._f848._f852=true;
MVUtil._f174(x38);
}
this.div.onmousedown=MVUtil._f105(this.div,x15);
this.div.onmouseup=MVUtil._f105(this.div,x27);
this.div.onmousemove=MVUtil._f105(this.div,x23);
this.div.onmouseout=MVUtil._f105(this.div,x35);
this._f849.onmousedown=MVUtil._f105(this._f849,x37);
this._f852=false;
}
function _f400()
{
}
_f400._f401=[
{srid:54004,params:[0,0,1,0,0]},
{srid:8307,params:[6378137,298.257223563]}
];
_f400._f402=function(x0,x1,x2,x3)
{
var x4=_f400._f405(x3);
var x5=_f400._f405(x2);
if(!x4||!x5)
{
MVi18n._f6("MVCSTransformMercator.geodeticToMercator","MAPVIEWER-05522",x2+"->"+x3);
return null;
}
var x6=_f363._f366({x:x0,y:x1});
x0=x6.x;
x1=x6.y;
var x7=x4[3];
var x8=x4[4];
var x9=x4[2];
var x10=x4[1];
var x11=x5[0];
var x12=1/x5[1];
var x13=Math.sqrt(2*x12-x12*x12);
var x14=x7+x11*x9*(x0-x10);
var x15=Math.sin(x1);
var x16=Math.tan(Math.PI/4+x1/2);
var x17=(1-x13*x15)/(1+x13*x15);
var x18=x13/2;
var x19=Math.pow(x17,x18);
var x20=x8+x11*x9*Math.log(x16*x19);
return {x:x14,y:x20};
}
_f400._f406=function(x21,x22,x23,x24)
{
var x25=_f400._f405(x23);
var x26=_f400._f405(x24);
if(!x25||!x26)
{
MVi18n._f6("MVCSTransformMercator.mercatorToGeodetic","MAPVIEWER-05522",x23+"->"+x24);
return null;
}
var x27=x25[3];
var x28=x25[4];
var x29=x25[2];
var x30=x25[1];
var x31=x26[0];
var x32=1/x26[1];
var x33=Math.sqrt(2*x32-x32*x32);
var x34=x22;
var x35=x21;
var x36=Math.E;
var x37=Math.pow(x36,((x28-x34)/(x31*x29)));
var x38=Math.PI/2-2*Math.atan2(x37,1.0);
var x39=Math.pow(x33,4.0);
var x40=Math.pow(x33,6.0);
var x41=Math.pow(x33,8.0);
var x42=x33*x33/2;
var x43=5*x39/24;
var x44=x40/12;
var x45=13*x41/360;
var x46=Math.sin(2*x38);
var x47=7*x39/48;
var x48=29*x40/240;
var x49=811*x41/11520;
var x50=Math.sin(2*x38);
var x51=7*x40/120;
var x52=81*x41/1120;
var x53=Math.sin(6*x38);
var x54=4279*x41/161280;
var x55=Math.sin(8*x38);
var x56=x38+(x42+x43+x44+x45)*x46+(x47+x48+x49)*x50+(x51+x52)*x53+x54*x55;
var x57=((x35-x27)/(x31*x29))+x30;
return _f363._f367({x:x57,y:x56});
}
_f400._f405=function(x58)
{
for(var x59=0;x59<_f400._f401.length;x59++)
{
if(_f400._f401[x59].srid==x58)
return _f400._f401[x59].params;
}
return null;
}
_f10._f407(54004,8307,function(x60,x61){
return _f400._f406(x60,x61,54004,8307);
});
_f10._f407(8307,54004,function(x62,x63){
return _f400._f402(x62,x63,8307,54004);
});
function MVZoomControl(x0,x1)
{
this.mapview=x0;
this.ldiff=0;
this.tdiff=0;
this.movedLeft=0;
this.movedTop=0;
this._f428=x1;
this._f422=null;
this.tileLayerDiv=null;
this.zoomStep=0.1
this.interval=40;
this.zooming=false;
this.oldTilesLoaded=false;
this.timeouts=new Array();
}
MVZoomControl.prototype.computeTilesOffset=function()
{
var x0=this._f428._f422[0][0];
this.ldiff=-x0.parentNode.offsetLeft
this.tdiff=-x0.parentNode.offsetTop;
this.movedLeft=-x0.parentNode.parentNode.offsetLeft;
this.movedTop=-x0.parentNode.parentNode.offsetTop;
}
MVZoomControl.prototype.getScreenCor=function(x1,x2,x3)
{
var x4=this.getPPXByZoomLevel(x3);
var x5=this.getPPYByZoomLevel(x3);
var x6=x1-this.mapview._f108()/2;
var x7=x2-this.mapview._f109()/2;
return {x:x6/x4+this.mapview._f94,
y:this.mapview._f95-x7/x5};
}
MVZoomControl.prototype._f157=function(x8,x9,x10)
{
var x11=this.getPPXByZoomLevel(x10);
var x12=this.getPPYByZoomLevel(x10);
return {x:(x8-this.mapview._f94)*x11+this.mapview._f108()/2,
y:(this.mapview._f95-x9)*x12+this.mapview._f109()/2};
}
MVZoomControl.prototype.getPPXByZoomLevel=function(x13)
{
var x14=this.mapview.msi.mapConfig.zoomLevels[x13].tileImageWidth;
var x15=this.mapview.msi.mapConfig.zoomLevels[x13].tileWidth;
var x16=x14/x15;
return x16;
}
MVZoomControl.prototype.getPPYByZoomLevel=function(x17){
var x18=this.mapview.msi.mapConfig.zoomLevels[x17].tileImageHeight;
var x19=this.mapview.msi.mapConfig.zoomLevels[x17].tileHeight;
var x20=x18/x19;
return x20;
}
MVZoomControl.prototype.initZoomInfo=function(x21,x22,x23)
{
var x24=this.getPPXByZoomLevel(x21);
var x25=this.getPPYByZoomLevel(x21);
var x26=this.getPPXByZoomLevel(x22);
var x27=this.getPPYByZoomLevel(x22);
var x28=this.mapview.msi.mapConfig.zoomLevels[x21].tileImageWidth;
var x29=this.mapview.msi.mapConfig.zoomLevels[x21].tileImageWidth;
var x30=this.mapview.msi.mapConfig.zoomLevels[x21].tileImageWidth*x26/x24;
var x31=this.mapview.msi.mapConfig.zoomLevels[x21].tileImageHeight*x27/x25;
var x32=MVUtil._f83(x23)-this.movedLeft;
var x33=MVUtil._f84(x23)-this.movedTop;
var x34=this.getScreenCor(x32-this.ldiff+this.movedLeft,x33-this.tdiff+this.movedTop,x21);
var x35=this._f157(x34.x,x34.y,x22);
var x36=x35.x+this.ldiff-this.movedLeft*x26/x24;
var x37=x35.y+this.tdiff-this.movedTop*x26/x24;
x23.oldZoomInfo=new Object();
x23.oldZoomInfo.lstart=x32;
x23.oldZoomInfo.tstart=x33;
x23.oldZoomInfo.lend=x36;
x23.oldZoomInfo.tend=x37;
x23.oldZoomInfo.fw=x28;
x23.oldZoomInfo.fh=x29;
x23.oldZoomInfo.tiw=x30;
x23.oldZoomInfo.tih=x31;
}
MVZoomControl.prototype.zoomToFactor=function(x38,x39)
{
if(x39>1)
{
return;
}
var x40=x38.oldZoomInfo;
var x41=(x40.lend-x40.lstart)*x39+x40.lstart;
var x42=(x40.tend-x40.tstart)*x39+x40.tstart;
var x43=(x40.tiw-x40.fw)*x39+x40.fw;
var x44=(x40.tih-x40.fh)*x39+x40.fh;
MVUtil._f73(x38,x41,x42);
x38.style.width=(x43+1)+'px';
x38.style.height=(x44+1)+'px';
}
MVZoomControl.prototype.copyTiles=function()
{
if(this.tileLayerDiv&&this.tileLayerDiv.parentNode)
{
this.tileLayerDiv.parentNode.removeChild(this.tileLayerDiv);
MVUtil._f91(this.tileLayerDiv);
}
this.tileLayerDiv=this._f428._f428;
this.tileLayerDiv.zooming=true;
this._f422=this._f428._f422;
this.tileLayerDiv.style.zIndex=200+this._f428.zIndex;
return;
}
MVZoomControl.prototype.zoomToNewCenter=function(x45,x46,x47)
{
if((x45)&&(x46)&&(x45.getPointX()!=x46.getPointX()||x45.getPointY()!=x46.getPointY()))
{
var x48=this._f157(x45.getPointX(),x45.getPointY(),x47);
var x49=this._f157(x46.getPointX(),x46.getPointY(),x47);
var x50=x49.x-x48.x;
var x51=x49.y-x48.y;
var x52=this.mapview.div;
if(_f10._f362==2)
{
x52.style.pixelLeft=x52.style.pixelLeft-x50;
x52.style.pixelTop=x52.style.pixelTop-x51;
}
else
 {
x52.style.left=(MVUtil._f83(x52)-x50)+'px';
x52.style.top=(MVUtil._f84(x52)-x51)+'px';
}
}
}
MVZoomControl.prototype.clearLastZoom=function(){
for(var x53=0;x53<this._f428._f422.length;x53++)
{
for(var x54=0;x54<this._f428._f422[x53].length;x54++)
{
if(!this.hasTileLoaded(this._f428._f422[x53][x54]))
{
var x55=_f10._f142+"transparent."+(_f10._f69=="IF"?"gif":"png");
this._f428._f422[x53][x54].src=x55;
this._f428._f422[x53][x54].imgLoadFinished=true;
}
}
}
for(var x53=0;x53<this.timeouts.length;x53++)
{
clearTimeout(this.timeouts[x53]);
}
this.timeouts=new Array();
}
MVZoomControl.prototype.showTiles=function(x56,x57,x58,x59)
{
if(!this._f428.isVisible()||this._f428._f422==''||Math.abs(x56-x57)>1||this._f428._f414)
{
this.reset();
return;
}
this._f428.setVisible(false);
this._f428._f428.style.visibility="visible";
this.zooming=true;
this.zoomToNewCenter(x58,x59,x56);
this.computeTilesOffset()
this.copyTiles();
this.clearLastZoom();
for(var x60=0;x60<this._f422.length;x60++)
{
for(var x61=0;x61<this._f422[x60].length;x61++)
{
this.initZoomInfo(x56,x57,this._f422[x60][x61]);
this.runZoom(this,x60,x61);
}
}
}
MVZoomControl.prototype.reset=function()
{
this.ldiff=0;
this.tdiff=0;
this.movedLeft=0;
this.movedTop=0;
if(this.tileLayerDiv&&this.tileLayerDiv.parentNode)
{
this.tileLayerDiv.parentNode.removeChild(this.tileLayerDiv);
MVUtil._f91(this.tileLayerDiv);
}
this._f422=null;
this.tileLayerDiv=null;
this.zoomStep=0.2
this.interval=100;
this.zooming=false;
this.oldTilesLoaded=false;
for(var x62=0;x62<this.timeouts.length;x62++)
{
clearTimeout(this.timeouts[x62]);
}
this.timeouts=new Array();
if(this._f428.basemap.isVisible())
this._f428.setVisible(true);
}
MVZoomControl.prototype.runZoom=function(x63,x64,x65,x66)
{
x66=(x66)?x66:x63.zoomStep;
var x67=x63._f422[x64][x65];
x63.zoomToFactor(x67,x66);
if(x66>=1)
{
x67.oldZoomInfo=null;
x67.zoomFinished=true;
if(this.hasZoomFinished())
{
this.startClear();
}
return;
}
else
 {
var x68=setTimeout(function(){x63.runZoom.call(x63,x63,x64,x65,x66+x63.zoomStep);},x63.interval);
this.timeouts.push(x68);
}
}
MVZoomControl.prototype.hasZoomFinished=function()
{
if(!(this._f422))
{
return true;
}
for(var x69=0;x69<this._f422.length;x69++)
{
for(var x70=0;x70<this._f422[x69].length;x70++)
{
if(!this._f422[x69][x70].zoomFinished)
{
return false;
}
}
}
return true;
}
MVZoomControl.prototype.hasTilesLoadFinished=function()
{
for(var x71=0;x71<this._f428._f422.length;x71++)
{
for(var x72=0;x72<this._f428._f422[x71].length;x72++)
{
if(!this.hasTileLoaded(this._f428._f422[x71][x72]))
{
return false;
}
}
}
return true;
}
MVZoomControl.prototype.hasTileLoaded=function(x73)
{
if(x73.src==this.mapview._f430.src)
return true;
if(_f10._f362==2){
return x73.imgLoadFinished;
}
else {
return (x73.offsetWidth==this._f428.tileWidth);
}
}
MVZoomControl.prototype.startClear=function()
{
this._f428.setVisible(true);
for(var x74=0;x74<this.mapview._f250._f262.length;x74++)
{
var x75=this.mapview._f250._f262[x74].node;
if(x75 instanceof Array)
{
for(var x76=0;x76<x75.length;x76++)
x75[x76].style.display='';
}
else if(x75!=null)
x75.style.display='';
}
if(_f10._f362==2){
for(var x74=0;x74<this._f428._f422.length;x74++)
{
for(var x76=0;x76<this._f428._f422[x74].length;x76++)
{
this._f428._f422[x74][x76].style.display='';
}
}
}
this.tileLayerDiv.style.zIndex=this._f428.zIndex;;
this.clearCloneTiles();
}
MVZoomControl.prototype.clearCloneTiles=function()
{
if(this.hasTilesLoadFinished())
{
for(var x77=0;x77<this._f428._f422.length;x77++)
{
for(var x78=0;x78<this._f428._f422[x77].length;x78++)
{
this._f428._f422[x77][x78].style.display='';
}
}
this.removeCloneTiles();
}
else
 {
var x79=this;
var x80=setTimeout(function(){x79.clearCloneTiles()},70);
this.timeouts.push(x80);
}
}
MVZoomControl.prototype.removeCloneTiles=function()
{
if(this.tileLayerDiv)
{
this.tileLayerDiv.parentNode.removeChild(this.tileLayerDiv);
MVUtil._f91(this.tileLayerDiv);
this.tileLayerDiv=null;
}
this.zooming=false;
}
function _f833()
{
}
_f833._f402=function(x0,x1,x2)
{
var x3=_f363._f366({x:x0,y:x1});
x0=x3.x;
x1=x3.y;
var x4=Math.sin(x1);
var x5=Math.log((1+x4)/(1-x4));
var x6=x2*x0;
var x7=x5*x2/2;
return {x:x6,y:x7};
}
_f833._f406=function(x8,x9,x10)
{
var x11=x8/x10;
var x12=x9*2/x10;
var x13=Math.pow(Math.E,x12);
var x14=(x13-1)/(x13+1);
var x15=Math.asin(x14);
return _f363._f367({x:x11,y:x15});
}
_f10._f407(3785,8307,function(x16,x17){
return _f833._f406(x16,x17,6378137);
});
_f10._f407(8307,3785,function(x18,x19){
return _f833._f402(x18,x19,6378137);
});
_f10._f407(53004,8307,function(x20,x21){
return _f833._f406(x20,x21,6371000);
});
_f10._f407(8307,53004,function(x22,x23){
return _f833._f402(x22,x23,6371000);
});
_f10._f407(53004,54004,function(x24,x25){
var x26=_f833._f406(x24,x25,6371000);
return _f400._f402(x26.x,x26.y,8307,54004);
});
_f10._f407(54004,53004,function(x27,x28){
var x29=_f400._f406(x27,x28,54004,8307);
return _f833._f402(x29.x,x29.y,6371000);
});
function MVButtonGroup()
{
this._f197=new Object();
this.toolBar=null;
var x0=this;
this.add=function(x1)
{
x0._f197[x1._f198]=x1;
x1.group=x0;
x1._f199=x0._f200;
if(this.toolBar)
this.toolBar.addButton(x1);
}
this.addSeparator=function(x2)
{
var x3=new MVToolButton(x2,MVToolButton.SEPARATOR);
this.add(x3);
}
this._f200=function(x4)
{
if(x0._f197)
{
for(var x5 in x0._f197)
{
x0._f197[x5]._f201(x4);
}
}
}
}
function MVDistanceTool(x0,x1)
{
var x2=this;
this._f389=true;
this._f390=true;
this._f388=x0;
this._f3=x1;
this._f329=null;
this._f391=null;
this._f336=null;
this._f97=new Array();
this.srid=null;
this._f392=null;
this._f393=new MVRedlineTool(null,null,x1);
this._f393.setGeneratePolygonTop(false);
this.init=function()
{
x2.parent.addRedLineTool(x2._f393);
x2.srid=x2.parent.srid;
if(x2._f393.getStatus()!=0)
{
x2.clear();
}
x2._f393.finishLinkClick=x2.finish;
x2._f393.clearLinkClick=x2.clear;
x2._f393.init(2);
x2._f393._f320=-1;
x2._f393.setEventListener(MVEvent.NEW_SHAPE_POINT,x2._f394);
x2._f393.setEventListener(MVEvent.MODIFY,x2._f395);
if(x2._f390)
{
x2._f392=x2.parent._f396;
x2.parent.setEventListener(MVEvent.MOUSE_DOUBLE_CLICK,x2.finish);
}
}
this.setEventListener=function(x3,x4)
{
if(x3==MVEvent.NEW_SHAPE_POINT)
x2._f391=x4;
else if(x3==MVEvent.FINISH)
x2._f329=x4;
else if(x3==MVEvent.MODIFY)
x2._f336=x4;
}
this.attachEventListener=function(x5,x6)
{
MVUtil.attachEventListener(x2._f97,x5,x6)
}
this.detachEventListener=function(x7,x8)
{
MVUtil.detachEventListener(x2._f97,x7,x8);
}
this.setRenderingStyle=function(x9,x10)
{
this._f393.setRenderingStyle(x9,x10);
}
this.setTextStyle=function(x11)
{
x2._f393.setTextStyle(x11);
}
this.getOrdinates=function()
{
return x2._f393.getOrdinates();
}
this.getStatus=function()
{
return x2._f393.getStatus();
}
this.finish=function(x12)
{
if(x2._f393!=null)
{
if(x2._f393.getOrdinates().length>0)
{
x2._f393.generateArea();
if(x2._f329)
x2._f329();
MVUtil.runListeners(x2._f97,MVEvent.FINISH);
}
}
x2.parent._f396=x2._f392;
}
this.clear=function()
{
if(x2._f393!=null)
{
if(x2._f393.getOrdinates().length>0&&
x2._f393.getStatus()==1)
{
if(x2._f329)
x2._f329();
MVUtil.runListeners(x2._f97,MVEvent.FINISH);
}
x2._f393.clear();
var x13=document.getElementById("distance_info_div_"+x2._f393.id);
if(x13)
x13.innerHTML="";
}
}
this._f394=function()
{
if(x2._f389)
{
if(x2._f393==null)
return;
var x14=x2._f393.getOrdinates();
if(x14==null||x14.length<4)
{
if(x2._f391)
x2._f391();
MVUtil.runListeners(x2._f97,MVEvent.NEW_SHAPE_POINT);
return;
}
var x15=MVSdoGeometry.createLineString(x14,x2.srid);
var x16;
if(x2._f388==MVDistanceTool.METRIC)
x16=parseInt(x15.getLength("meter",true,x2._f3));
else
 x16=parseInt(x15.getLength("Yard",true,x2._f3));
var x17=MVi18n._f342("totalDistance")+x2._f397(x16);
var x18=document.getElementById("distance_info_div_"+x2._f393.id);
if(!x18)
{
x18=document.createElement("div");
x18.id="distance_info_div_"+x2._f393.id;
x2._f393.getInfoDecorationDiv().appendChild(x18);
}
x18.innerHTML=x17;
}
if(x2._f391)
x2._f391();
MVUtil.runListeners(x2._f97,MVEvent.NEW_SHAPE_POINT);
}
this.getDistance=function(x19,x20,x21)
{
if(x2._f393==null)
return 0;
var x22=x2._f393.getOrdinates();
if(x22==null||x22.length<4)
return 0;
var x23=x22.length;
var x24=new Array(4);
for(var x25=0;x25<4;x25++)
x24[x25]=x22[x23+x25-4];
var x26=MVSdoGeometry.createLineString(x24,x2.srid);
return parseInt(x26.getLength(x19,x20,x21));
}
this._f399=function(x27,x28,x29)
{
if(x2._f393==null)
return 0;
var x30=x2._f393.getOrdinates();
if(x30==null||x30.length<4)
return 0;
var x31=MVSdoGeometry.createLineString(x30,x2.srid);
return parseInt(x31.getLength(x27,x28,x29));
}
this._f397=function(x32)
{
if(x2._f388==MVDistanceTool.METRIC)
{
if(x32>1000)
{
var x33=Math.round(x32/10);
return MVUtil.formatNum(x33/100)+MVi18n._f342("km");
}
else if(x32>1)
return MVUtil.formatNum(x32)+MVi18n._f342("m");
else
 return MVUtil.formatNum(x32*10)+MVi18n._f342("cm");
}
else
 {
if(x32>1760)
{
var x33=Math.round((x32/1760)*100);
return MVUtil.formatNum(x33/100)+MVi18n._f342("mi");
}
else if(x32>1)
return MVUtil.formatNum(x32)+MVi18n._f342("yd");
else
 return MVUtil.formatNum(x32*3)+MVi18n._f342("ft");
}
}
this._f395=function()
{
if(x2._f389)
x2._f394();
else
 {
if(x2._f336)
x2._f336();
MVUtil.runListeners(x2._f97,MVEvent.MODIFY);
}
}
}
MVDistanceTool.METRIC=0;
MVDistanceTool.IMPERIAL=1;
function MVInfoWindowTab(x0,x1)
{
this.title=x0;
this.content=x1;
}
MVInfoWindowTab.prototype.getTitle=function()
{
return this.title;
}
MVInfoWindowTab.prototype.getContent=function()
{
return this.content;
}
function MVMenu(x0,x1,x2)
{
this.mapview=x0;
this.menuTableId="mvmenu_table_0";
this.menuTableBodyId="mvmenu_table_body_0";
this.menuFOIId="mvmenu_0";
x0.removeFOI(this.menuFOIId);
var x3="<table id='"+this.menuTableId+"' cellpadding=1 cellspacing=0 style='width:1px'><tr>"+
"<td style='border-width:1px;border-style:solid;border-color:black;background-color:white'>"+
"<table><tbody id='"+this.menuTableBodyId+"'></tbody></table>"+
"</td>"+
"</tr></table>"
var x4=MVFOI.createHTMLFOI(this.menuFOIId,x1,x3,0,0);
if(x2)
x4.areacode=x2;
x4.setInfoTip(null);
x4.setInfoWindow(null,0,0);
x4.setTopFlag(true);
x0.addFOI(x4);
var x5=this.menuFOIId;
var x6=function()
{
x0.removeFOI(x5);
}
x0.addEventListener(MVEvent.MOUSE_CLICK,x6);
}
MVMenu.count=0;
MVMenu.prototype.addMenuItem=function(x0,x1)
{
var x2=document.getElementById(this.menuTableBodyId);
var x3=document.getElementById(this.menuTableId).style.width;var x4=parseInt(x3.substr(0,x3.length-2));
if(x4<(x0.length*12))
document.getElementById(this.menuTableId).style.width=(x0.length*12)+"px";
var x5=document.createElement('tr');
x2.appendChild(x5);
x5.style.fontFamily="Arial, Helvetica, Geneva, sans-serif";
x5.style.fontSize="12px";
x5.style.cursor="pointer";
x5.align='left';
var x6=document.createElement("td");
x6.innerHTML=x0;
x5.appendChild(x6);
x5.onmouseover=function()
{
this.style.backgroundColor="#336699";
this.style.color="#ffffff";
}
x5.onmouseout=function()
{
this.style.backgroundColor="transparent";
this.style.color="#000000";
}
if(x1)
{
var x2=this;
x5.onmousedown=function(x7)
{
MVUtil._f174(x7);
x2.removeRightClickMenu();
x1();
}
}
}
MVMenu.prototype.removeRightClickMenu=function()
{
this.mapview.removeFOI(this.menuFOIId);
}
function MVToolBar(x0,x1,x2)
{
if(x2==MVToolBar.VERTICAL)
this.Direction=x2;
else
 this.Direction=MVToolBar.HORIZONTAL;
this._f597=x0;
this._f598=x1;
this.mapviewer=null;
this.toolBarDecoration=null;
this._f599;
this._f600=new Object();
var x3=this;
var x4=null;
this.visible=true;
this._f601=new MVToolButton(x0+"_bt_clear",MVToolButton.COMMAND,_f10._f142+"tbicons/clear.gif",_f10._f142+"tbicons/p_clear.gif");
this._f602=new MVToolButton(x0+"_bt_redline",MVToolButton.TOGGLE,_f10._f142+"tbicons/redline.gif",_f10._f142+"tbicons/p_redline.gif");
this._f603=new MVToolButton(x0+"_bt_distance",MVToolButton.TOGGLE,_f10._f142+"tbicons/distance.gif",_f10._f142+"tbicons/p_distance.gif");
this._f604=new MVToolButton(x0+"_bt_circle",MVToolButton.TOGGLE,_f10._f142+"tbicons/circle.gif",_f10._f142+"tbicons/p_circle.gif");
this._f605=new MVToolButton(x0+"_bt_rectangle",MVToolButton.TOGGLE,_f10._f142+"tbicons/rectangle.gif",_f10._f142+"tbicons/p_rectangle.gif");
this._f606=new MVToolButton(x0+"_bt_zoom",MVToolButton.TOGGLE,_f10._f142+"tbicons/zoom.gif",_f10._f142+"tbicons/p_zoom.gif");
this._f607=new MVButtonGroup();
this._f608=new Array();
this.setPosition=function(x5,x6,x7,x8)
{
x3.toolBarDecoration.setPosition(x5,x6);
}
this.setVisible=function(x9)
{
if(x3.visible!=x9)
{
x3.toolBarDecoration.setVisible(x9);
x3.visible=x9;
}
}
this.isVisible=function()
{
return this.visible;
}
this.getBuiltInTool=function(x10)
{
if(x3._f598[MVToolBar.BUILTIN_ALL]==true||x3._f598[x10]==true)
{
var x11=null;
switch(x10)
{
case MVToolBar.BUILTIN_CIRCLE:
x11=x3._f604;
break;
case MVToolBar.BUILTIN_RECTANGLE:
x11=x3._f605;
break;
case MVToolBar.BUILTIN_REDLINE:
x11=x3._f602;
break;
case MVToolBar.BUILTIN_DISTANCE:
x11=x3._f603;
break;
case MVToolBar.BUILTIN_MARQUEE_ZOOM:
x11=x3._f606;
break;
}
if(x11)
return x11.tool;
else
 return null;
}
else
 return null;
}
this.addButton=function(x12)
{
var x13=null;
var x14=null;
if(x12._f609==MVToolButton.SEPARATOR)
{
if(x3.Direction==MVToolBar.HORIZONTAL)
x12._f610.setAttribute("src",_f10._f142+"tbicons/bk_v.png");
else
 x12._f610.setAttribute("src",_f10._f142+"tbicons/bk_h.png");
}
if(x3.Direction==MVToolBar.HORIZONTAL)
{
if(x4.childNodes.length==0)
{
x13=x4.insertRow(0);
}
else
 {
x13=x4.firstChild.firstChild;
}
x14=x13.insertCell(x13.childNodes.length);
x14.id="_td_"+x12._f198
}
else
 {
if(x4.childNodes.length==0)
x13=x4.insertRow(0);
else
 x13=x4.insertRow(x4.firstChild.childNodes.length);
x13.id="_tr_"+x12._f198;
x14=x13.insertCell(0);
}
x12._f611=x3;
x14.appendChild(x12._f612);
x3._f600[x12._f198]=x12;
x12._f611=x3;
}
this.addSeparator=function(x15)
{
var x16=new MVToolButton(x15,MVToolButton.SEPARATOR);
x3.addButton(x16);
}
this.getButton=function(x17)
{
return x3._f600[x17];
}
this.removeButton=function(x18)
{
if(!x18)
return ;
delete x3._f600[x18._f198];
if(x18.group)
{
delete x18.group._f197[x18._f198];
x18.group=null;
}
if(x3.Direction==MVToolBar.HORIZONTAL)
{
if(x4.childNodes.length==0)
{
return;
}
else
 {
oTR=x4.firstChild.firstChild;
for(var x19=0;x19<oTR.childNodes.length;x19++)
{
if(oTR.childNodes[x19].id=="_td_"+x18._f198)
{
oTR.deleteCell(x19);
}
}
}
}
else
 {
if(x4.childNodes.length==0)
{
return;
}
else
 {
for(var x19=0;x19<x4.firstChild.childNodes.length;x19++)
{
if(x4.firstChild.childNodes[x19].id=="_tr_"+x18._f198)
{
x4.firstChild.deleteRow(x19);
}
}
}
}
}
this.getBuiltInButtonGroup=function()
{
return this._f607;
}
this.addButtonGroup=function(x20)
{
if(x20)
{
x20.toolBar=this;
this._f608.push(x20);
for(var x21 in x20._f197)
{
this.addButton(x20._f197[x21]);
}
}
}
this.removeButtonGroup=function(x22)
{
if(x22)
{
for(var x23=0;x23<this._f608.length;x23++)
{
if(this._f608[x23]==x22)
{
this._f608.splice(x23,1);
for(var x24 in x22._f197)
{
this.removeButton(x22._f197[x24]);
}
return ;
}
}
}
}
this.init=function()
{
x3.toolBarDecoration=new MVMapDecoration("<div id=\"div_"+x3._f597+"\" style=\"background: white;\"></div>",0.35,0.05);
x3.toolBarDecoration.setVisible(x3.visible);
x3.toolBarDecoration.setDraggable(true);
x4=document.createElement("Table");
x4.id="tb_"+x3._f597;
x4.style.backgroundColor="rgb(242, 237, 242)";
x4.cellSpacing=1;
x4.cellPadding=1;
x4.style.border="1px solid #7F9DB9";
x3._f613();
}
this._f613=function()
{
x3._f601.setToolTip(MVi18n._f342("clearButton"));
x3._f602.setToolTip(MVi18n._f342("redlineTool"));
x3._f603.setToolTip(MVi18n._f342("distanceTool"));
x3._f604.setToolTip(MVi18n._f342("circleTool"));
x3._f605.setToolTip(MVi18n._f342("retangleTool"));
x3._f606.setToolTip(MVi18n._f342("marqueeZoomTool"));
x3._f601.attachEventListener(MVEvent.BUTTON_DOWN,x3._f614);
x3._f602.attachEventListener(MVEvent.BUTTON_DOWN,x3._f614);
x3._f603.attachEventListener(MVEvent.BUTTON_DOWN,x3._f614);
x3._f604.attachEventListener(MVEvent.BUTTON_DOWN,x3._f614);
x3._f605.attachEventListener(MVEvent.BUTTON_DOWN,x3._f614);
x3._f606.attachEventListener(MVEvent.BUTTON_DOWN,x3._f614);
x3._f602.attachEventListener(MVEvent.BUTTON_UP,x3._f615);
x3._f603.attachEventListener(MVEvent.BUTTON_UP,x3._f615);
x3._f604.attachEventListener(MVEvent.BUTTON_UP,x3._f615);
x3._f605.attachEventListener(MVEvent.BUTTON_UP,x3._f615);
x3._f606.attachEventListener(MVEvent.BUTTON_UP,x3._f615);
x3._f607.add(x3._f601);
x3._f607.add(x3._f602);
x3._f607.add(x3._f603);
x3._f607.add(x3._f604);
x3._f607.add(x3._f605);
x3._f607.add(x3._f606);
var x25=new MVCircleTool();
var x26=new MVStyleColor("_bt_circle_area_color",null,"FF0000");
x25.setAreaStyle(x26);
x3._f604.tool=x25;
var x27=new MVRectangleTool();
var x26=new MVStyleColor("_bt_rectangle_area_color",null,"FF0000");
x27.setAreaStyle(x26);
x3._f605.tool=x27;
var x28=new MVRedlineTool();
x3._f602.tool=x28;
var x29=new MVDistanceTool(MVDistanceTool.IMPERIAL);
var x30=new MVStyleMarker("_bt_distance_point","vector");
x30.setStrokeColor("ff0000");
x30.setFillColor("00FF00");
x30.setVectorShape("c:30");
x29.setRenderingStyle(MVRedlineTool.STYLE_POINT,x30);
var x31='<svg width="1in" height="1in"><desc/><g class="line" style="stroke-width:1.0">'+
'<line class="base" style="fill:#ff0000;stroke-width:1.0" /></g></svg>';
var x32=new MVXMLStyle("_bt_distance_line",x31);
x29.setRenderingStyle(MVRedlineTool.STYLE_LINE,x32);
x3._f603.tool=x29;
}
this._f616=function()
{
x3._f599=document.getElementById("div_"+x3._f597);
x3._f599.appendChild(x4);
}
this._f617=function()
{
if(x3._f598)
{
var x33=[false,false,false,false,false,false];
for(var x34=0;x34<x3._f598.length;x34++)
{
x33[x3._f598[x34]]=true;
}
if(x33[MVToolBar.BUILTIN_ALL]==true)
{
x33=[true,true,true,true,true,true];
}
x3._f598=x33;
for(var x34=0;x34<x33.length;x34++)
{
if(x33[x34])
{
x3.addButton(x3._f601);
break;
}
}
for(var x34=1;x34<x33.length;x34++)
{
if(x33[x34]==true)
{
x3.addSeparator("sp_builtIn_"+x34);
if(x34==MVToolBar.BUILTIN_CIRCLE)
{
x3.addButton(x3._f604);
x3.mapviewer.addCircleTool(x3._f604.tool);
}
else if(x34==MVToolBar.BUILTIN_RECTANGLE)
{
x3.addButton(x3._f605);
x3.mapviewer.addRectangleTool(x3._f605.tool);
}
else if(x34==MVToolBar.BUILTIN_REDLINE)
{
x3.addButton(x3._f602);
x3.mapviewer.addRedLineTool(x3._f602.tool);
}
else if(x34==MVToolBar.BUILTIN_DISTANCE)
{
x3.addButton(x3._f603);
x3.mapviewer.addDistanceTool(x3._f603.tool);
}
else if(x34==MVToolBar.BUILTIN_MARQUEE_ZOOM)
{
x3.addButton(x3._f606);
}
}
}
}
}
this._f614=function(x35)
{
var x36=function(x37)
{
for(var x38 in x3._f600)
{
if(x3._f600[x38].tool)
{
var x39=x3._f600[x38]._f198;
if(x39.indexOf(x37)!=-1)
{
x3._f600[x38]._f201();
}
}
}
}
var x40=function()
{
x36("redline");
}
var x41=function()
{
x36("distance");
}
var x42=function()
{
x36("circle");
}
var x43=function()
{
x36("rectangle");
}
var x44=function()
{
x36("redline");
x3.getButton(x35).tool.clear();
}
if(x35==x0+"_bt_clear")
{
for(var x45 in x3._f600)
{
if(x3._f600[x45].tool)
{
var x46=x3._f600[x45]._f198;
if((x46==x0+"_bt_redline"||x46==x0+"_bt_distance"||
x46==x0+"_bt_circle"||x46==x0+"_bt_rectangle")&&
x3._f600[x45].tool.parent!=null)
x3._f600[x45].tool.clear();
}
}
}
else if(x35==x0+"_bt_redline")
{
if(x3.getButton(x35).tool)
{
var x47=x3.getButton(x35).tool;
x47.setControlPanelVisible(true);
if(!x47.parent)
{
x3.mapviewer.addRedLineTool(x47);
x47.finishLinkClick=x40;
x47.clearLinkClick=x44;
}
x47.init();
}
}
else if(x35==x0+"_bt_distance")
{
var x48;
if(x3.getButton(x35).tool)
{
x48=x3.getButton(x35).tool;
if(!x48.parent)
{
x3.mapviewer.addDistanceTool(x48);
x48.attachEventListener(MVEvent.FINISH,x41);
}
x48.init();
}
}
else if(x35==x0+"_bt_circle")
{
var x49;
if(x3.getButton(x35).tool)
{
x49=x3.getButton(x35).tool;
if(!x49.parent)
{
x3.mapviewer.addCircleTool(x49);
x49.attachEventListener(MVEvent.FINISH,x42);
}
x49.init();
}
}
else if(x35==x0+"_bt_rectangle")
{
var x50;
if(x3.getButton(x35).tool)
{
x50=x3.getButton(x35).tool;
if(!x50.parent)
{
x3.mapviewer.addRectangleTool(x50);
x50.attachEventListener(MVEvent.FINISH,x43);
}
x50.init();
}
}
else if(x35==x0+"_bt_zoom")
{
var x51=new Object();
x51.borderColor="#0000FF";
x51.borderWidth=2;
x51.borderDashed=false;
x51.fillColor="#FF0000";
x51.fillOpacity=0.5;
x3.mapviewer.stopMarqueeZoom();
x3.mapviewer.startMarqueeZoom("continuous",x51);
}
}
this._f615=function(x52)
{
if(x52==x0+"_bt_redline")
{
if(x3.getButton(x52).tool)
{
if(x3.getButton(x52).tool.getStatus()!=2)
x3.getButton(x52).tool.clear();
else
 x3.getButton(x52).tool.setControlPanelVisible(false);
}
}
if(x52==x0+"_bt_distance")
{
if(x3.getButton(x52).tool)
{
x3.getButton(x52).tool.clear();
}
}
if(x52==x0+"_bt_rectangle")
{
if(x3.getButton(x52).tool)
{
if(!x3.getButton(x52).tool.getRectangle())
x3.getButton(x52).tool.clear();
}
}
if(x52==x0+"_bt_circle")
{
if(x3.getButton(x52).tool)
{
if(x3.getButton(x52).tool.getStatus()!=3)
x3.getButton(x52).tool.clear();
}
}
else if(x52==x0+"_bt_zoom")
{
x3.mapviewer.stopMarqueeZoom();
}
}
x3.init();
}
MVToolBar.VERTICAL=0;
MVToolBar.HORIZONTAL=1;
MVToolBar.BUILTIN_ALL=0;
MVToolBar.BUILTIN_CIRCLE=1;
MVToolBar.BUILTIN_RECTANGLE=2;
MVToolBar.BUILTIN_REDLINE=3;
MVToolBar.BUILTIN_DISTANCE=4;
MVToolBar.BUILTIN_MARQUEE_ZOOM=5;
function MVToolButton(x0,x1,x2,x3)
{
this._f198=x0;
this._f609=x1;
this._f834=x2;
this._f835=x3;
this._f836=MVToolButton.UP;
this._f611=null;
this._f97=new Array();
this._f837=null;
this._f838=null;
this._f199=null;
this._f612=document.createElement("div");
this._f610=document.createElement("img");
this._f839=document.createElement("div");
var x4=this;
this.attachEventListener=function(x5,x6)
{
MVUtil.attachEventListener(x4._f97,x5,x6)
}
this.detachEventListener=function(x7,x8)
{
MVUtil.detachEventListener(x4._f97,x7,x8);
}
this.setToolTip=function(x9)
{
x4._f839.innerHTML=x9;
}
this._f840=function()
{
x4._f612.appendChild(x4._f610);
x4._f612.appendChild(x4._f839);
x4._f839.style.position="absolute";
x4._f839.style.display="none";
x4._f839.style.borderColor="black";
x4._f839.style.backgroundColor="#ffffe1";
x4._f839.style.borderWidth="1px";
x4._f839.style.borderStyle="solid";
x4._f839.style.fontSize="14px";
x4._f839.style.whiteSpace="nowrap";
x4._f839.style.padding="2px";
if(x4._f609!=MVToolButton.SEPARATOR)
{
x4._f610.setAttribute("src",x4._f834);
}
}
this._f610.onmouseover=function()
{
if(x4._f609!=MVToolButton.SEPARATOR)
{
MVUtil._f164(x4._f611._f599,"pointer");
if(x4._f839.innerHTML)
{
x4._f839.style.display="";
MVUtil._f73(x4._f839,x4._f612.parentNode.offsetLeft+5,x4._f612.parentNode.offsetTop+30);
}
}
else
 {
MVUtil._f164(x4._f611._f599,"default");
}
}
this._f610.onmouseout=function(x10)
{
if(x4._f836==MVToolButton.DOWN)
x4._f610.onmouseup(x10);
x4._f839.style.display="none";
}
this._f610.onmousedown=function(x11)
{
if(x4._f199)
x4._f199(x4._f198);
if(x4._f609==MVToolButton.COMMAND)
{
x4._f610.setAttribute("src",x4._f835);
x4._f836=MVToolButton.DOWN;
x11=(x11)?x11:((window.event)?event:null);
MVUtil._f174(x11);
if(x4._f837)
x4._f837(x4._f198);
MVUtil.runListeners(x4._f97,MVEvent.BUTTON_DOWN,[x4._f198]);
}
else if(x4._f609==MVToolButton.TOGGLE)
{
if(x4._f836==MVToolButton.UP)
{
x4._f610.setAttribute("src",x4._f835);
x4._f836=MVToolButton.DOWN;
x11=(x11)?x11:((window.event)?event:null);
MVUtil._f174(x11);
if(x4._f837)
x4._f837(x4._f198);
MVUtil.runListeners(x4._f97,MVEvent.BUTTON_DOWN,[x4._f198]);
}
else
 {
x4._f610.setAttribute("src",x4._f834);
x4._f836=MVToolButton.UP;
x11=(x11)?x11:((window.event)?event:null);
MVUtil._f174(x11);
if(x4._f838)
x4._f838(x4._f198);
MVUtil.runListeners(x4._f97,MVEvent.BUTTON_UP,[x4._f198]);
}
}
}
this._f610.onmouseup=function(x12)
{
if(x4._f609==MVToolButton.COMMAND&&x4._f836==MVToolButton.DOWN)
{
x4._f610.setAttribute("src",x4._f834);
if(x4._f838)
x4._f838(x4._f198);
MVUtil.runListeners(x4._f97,MVEvent.BUTTON_UP,[x4._f198]);
x4._f836=MVToolButton.UP;
}
}
this._f201=function(x13)
{
if(x4._f609==MVToolButton.TOGGLE&&x4._f198!=x13)
{
if(x4._f836==MVToolButton.DOWN)
{
x4._f610.setAttribute("src",x4._f834);
x4._f836=MVToolButton.UP;
MVUtil.runListeners(x4._f97,MVEvent.BUTTON_UP,[x4._f198]);
}
}
}
x4._f840();
}
MVToolButton.COMMAND=0;
MVToolButton.TOGGLE=1;
MVToolButton.SEPARATOR=2;
MVToolButton.UP=0;
MVToolButton.DOWN=1;



function MVGoogleTileLayer()
{

this.tileLayerDefinition=
{
"mapTileLayer":"MV3785_1_19",
"format":"PNG",
"coordSys":
{
"srid":3785,
"type":"PROJECTED",
"distConvFactor":1.0,
"minX":-2.0037508E7,"minY":-2.0037508E7,
"maxX":2.0037508E7,"maxY":2.0037508E7
},
"zoomLevels":
[
{"zoomLevel":1,"name":"","tileWidth":2.0037508E7,"tileHeight":2.0037508E7,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":2,"name":"","tileWidth":1.0018754E7,"tileHeight":1.0018754E7,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":3,"name":"","tileWidth":5009377.0,"tileHeight":5009377.0,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":4,"name":"","tileWidth":2504688.5,"tileHeight":2504688.5,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":5,"name":"","tileWidth":1252344.25,"tileHeight":1252344.25,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":6,"name":"","tileWidth":626172.125,"tileHeight":626172.125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":7,"name":"","tileWidth":313086.0625,"tileHeight":313086.0625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":8,"name":"","tileWidth":156543.03125,"tileHeight":156543.03125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":9,"name":"","tileWidth":78271.515625,"tileHeight":78271.515625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":10,"name":"","tileWidth":39135.7578125,"tileHeight":39135.7578125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":11,"name":"","tileWidth":19567.87890625,"tileHeight":19567.87890625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":12,"name":"","tileWidth":9783.939453125,"tileHeight":9783.939453125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":13,"name":"","tileWidth":4891.9697265625,"tileHeight":4891.9697265625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":14,"name":"","tileWidth":2445.98486328125,"tileHeight":2445.98486328125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":15,"name":"","tileWidth":1222.992431640625,"tileHeight":1222.992431640625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":16,"name":"","tileWidth":611.4962158203125,"tileHeight":611.4962158203125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":17,"name":"","tileWidth":305.74810791015625,"tileHeight":305.74810791015625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":18,"name":"","tileWidth":152.87405395507812,"tileHeight":152.87405395507812,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":19,"name":"","tileWidth":76.43702697753906,"tileHeight":76.43702697753906,"tileImageWidth":256,"tileImageHeight":256}
]
};

this.srid=8307;

this._f195=MVMapTileLayer;

this._f195(this.tileLayerDefinition.mapTileLayer);

this.mapType=null;

this._f27=null;

this._f28=null;

this._f20=null;

this.initializeListener=null;

this.map=null;
}

MVGoogleTileLayer.prototype=new MVMapTileLayer;

MVGoogleTileLayer.prototype.setMapType=function(x0)
{
this.mapType=x0;
if(this.map)
this.map.setMapType(x0);
}

MVGoogleTileLayer.prototype.getMapType=function()
{
return this.mapType;
}

MVGoogleTileLayer.prototype.getType=function()
{
return "MVExternalAPIMapTileLayer";
}

MVGoogleTileLayer.prototype.init=function(x1)
{
this.map=new GMap2(x1);
if(this.mapType)
this.map.setMapType(mapType);
if(this._f27!=null&&this._f28!=null&&this._f20!=null)
{
var x2=new GLatLng(this._f28,this._f27);
this.map.setCenter(x2,this._f20+1);
}
if(this.initializeListener)
this.initializeListener();
}

MVGoogleTileLayer.prototype.setCenterAndZoomLevel=function(x3,x4,x5)
{
this._f27=x3;
this._f28=x4;
this._f20=x5;
if(this.map)
{
this.map.setCenter(new GLatLng(x4,x3),x5+1);
}
}

MVGoogleTileLayer.prototype._f196=function(x6,x7)
{
this.map.getDragObject().moveBy(new GSize(x6,x7));
}

MVGoogleTileLayer.prototype.getCenter=function()
{
var x8=this.map.getCenter();
if(x8)
return MVSdoGeometry.createPoint(x8.lng(),x8._f315(),this.srid);
else
 return null;
}

MVGoogleTileLayer.prototype.setCenter=function(x9,x10)
{
this._f27=x9;
this._f28=x10;
if(this.map)
this.map.setCenter(new GLatLng(x10,x9));
}

MVGoogleTileLayer.prototype.resize=function()
{
if(this.map)
this.map.checkResize();
}



MVGoogleTileLayer.prototype.clone=function()
{
var x11=new MVGoogleTileLayer();
return x11;
}





function MVVirtualEarthTileLayer()
{

this.tileLayerDefinition=
{
"mapTileLayer":"MV3785_1_19",
"format":"PNG",
"coordSys":
{
"srid":3785,
"type":"PROJECTED",
"distConvFactor":1.0,
"minX":-2.0037508E7,"minY":-2.0037508E7,
"maxX":2.0037508E7,"maxY":2.0037508E7
},
"zoomLevels":
[
{"zoomLevel":0,"name":"","tileWidth":2.0037508E7,"tileHeight":2.0037508E7,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":1,"name":"","tileWidth":1.0018754E7,"tileHeight":1.0018754E7,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":2,"name":"","tileWidth":5009377.0,"tileHeight":5009377.0,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":3,"name":"","tileWidth":2504688.5,"tileHeight":2504688.5,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":4,"name":"","tileWidth":1252344.25,"tileHeight":1252344.25,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":5,"name":"","tileWidth":626172.125,"tileHeight":626172.125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":6,"name":"","tileWidth":313086.0625,"tileHeight":313086.0625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":7,"name":"","tileWidth":156543.03125,"tileHeight":156543.03125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":8,"name":"","tileWidth":78271.515625,"tileHeight":78271.515625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":9,"name":"","tileWidth":39135.7578125,"tileHeight":39135.7578125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":10,"name":"","tileWidth":19567.87890625,"tileHeight":19567.87890625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":11,"name":"","tileWidth":9783.939453125,"tileHeight":9783.939453125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":12,"name":"","tileWidth":4891.9697265625,"tileHeight":4891.9697265625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":13,"name":"","tileWidth":2445.98486328125,"tileHeight":2445.98486328125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":14,"name":"","tileWidth":1222.992431640625,"tileHeight":1222.992431640625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":15,"name":"","tileWidth":611.4962158203125,"tileHeight":611.4962158203125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":16,"name":"","tileWidth":305.74810791015625,"tileHeight":305.74810791015625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":17,"name":"","tileWidth":152.87405395507812,"tileHeight":152.87405395507812,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":18,"name":"","tileWidth":76.43702697753906,"tileHeight":76.43702697753906,"tileImageWidth":256,"tileImageHeight":256}
]
};

this.srid=8307;

this._f195=MVMapTileLayer;

this._f195(this.tileLayerDefinition.mapTileLayer);

this.mapType=VEMapStyle.Road;

this._f27=null;

this._f28=null;

this._f20=null;

this.initializeListener=null;

this.map=null;
}
MVVirtualEarthTileLayer.prototype=new MVMapTileLayer;

MVVirtualEarthTileLayer.prototype.setMapType=function(x0)
{
this.mapType=x0;
if(this.map)
this.map.SetMapStyle(x0);
}

MVVirtualEarthTileLayer.prototype.getMapType=function()
{
return this.mapType;
}

MVVirtualEarthTileLayer.prototype.getType=function()
{
return "MVExternalAPIMapTileLayer";
}

MVVirtualEarthTileLayer.prototype.init=function(x1)
{
this.map=new VEMap(x1.id);
var x2=null;
if(this._f27!=null&&this._f28!=null)
x2=new VELatLong(this._f28,this._f27);
this.map.LoadMap(x2,this._f20+1,this.mapType,true);
if(this.initializeListener)
this.initializeListener();
}

MVVirtualEarthTileLayer.prototype.setCenterAndZoomLevel=function(x3,x4,x5)
{
this._f27=x3;
this._f28=x4;
this._f20=x5;
if(this.map)
this.map.SetCenterAndZoom(new VELatLong(x4,x3),x5+1);
}

MVVirtualEarthTileLayer.prototype._f196=function(x6,x7)
{
this.map.vemapcontrol.PanMap(-x6,-x7);
}

MVVirtualEarthTileLayer.prototype.getCenter=function()
{
var x8=this.map.GetCenter();
return MVSdoGeometry.createPoint(x8.Longitude,x8.Latitude,this.srid);
}

MVVirtualEarthTileLayer.prototype.setCenter=function(x9,x10)
{
this._f27=x9;
this._f28=x10;
if(this.map)
this.map.SetCenter(new VELatLong(x10,x9));
}

MVVirtualEarthTileLayer.prototype.resize=function()
{
if(this.map&&this.layerDiv.parentNode.offsetWidth>0)
this.map.Resize(this.layerDiv.parentNode.offsetWidth,this.layerDiv.parentNode.offsetHeight);
}



MVVirtualEarthTileLayer.prototype.clone=function()
{
var x11=new MVVirtualEarthTileLayer();
return x11;
}



function MVYahooTileLayer()
{

this.tileLayerDefinition=
{
"mapTileLayer":"MV3785_1_17",
"format":"PNG",
"coordSys":
{
"srid":3785,
"type":"PROJECTED",
"distConvFactor":1.0,
"minX":-2.0037508E7,"minY":-2.0037508E7,
"maxX":2.0037508E7,"maxY":2.0037508E7
},
"zoomLevels":
[
{"zoomLevel":0,"name":"","tileWidth":2.0037508E7,"tileHeight":2.0037508E7,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":1,"name":"","tileWidth":1.0018754E7,"tileHeight":1.0018754E7,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":2,"name":"","tileWidth":5009377.0,"tileHeight":5009377.0,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":3,"name":"","tileWidth":2504688.5,"tileHeight":2504688.5,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":4,"name":"","tileWidth":1252344.25,"tileHeight":1252344.25,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":5,"name":"","tileWidth":626172.125,"tileHeight":626172.125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":6,"name":"","tileWidth":313086.0625,"tileHeight":313086.0625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":7,"name":"","tileWidth":156543.03125,"tileHeight":156543.03125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":8,"name":"","tileWidth":78271.515625,"tileHeight":78271.515625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":9,"name":"","tileWidth":39135.7578125,"tileHeight":39135.7578125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":10,"name":"","tileWidth":19567.87890625,"tileHeight":19567.87890625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":11,"name":"","tileWidth":9783.939453125,"tileHeight":9783.939453125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":12,"name":"","tileWidth":4891.9697265625,"tileHeight":4891.9697265625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":13,"name":"","tileWidth":2445.98486328125,"tileHeight":2445.98486328125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":14,"name":"","tileWidth":1222.992431640625,"tileHeight":1222.992431640625,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":15,"name":"","tileWidth":611.4962158203125,"tileHeight":611.4962158203125,"tileImageWidth":256,"tileImageHeight":256},
{"zoomLevel":16,"name":"","tileWidth":305.74810791015625,"tileHeight":305.74810791015625,"tileImageWidth":256,"tileImageHeight":256}
]
};

this.srid=8307;

this._f195=MVMapTileLayer;

this._f195(this.tileLayerDefinition.mapTileLayer);

this.mapType=YAHOO_MAP_REG;

this._f27=null;

this._f28=null;

this._f20=null;

this.initializeListener=null;

this.map=null;
}
MVYahooTileLayer.prototype=new MVMapTileLayer;

MVYahooTileLayer.prototype.setMapType=function(x0)
{
this.mapType=x0;
if(this.map)
this.map.setMapType(x0);
}

MVYahooTileLayer.prototype.getMapType=function()
{
return this.mapType;
}

MVYahooTileLayer.prototype.getType=function()
{
return "MVExternalAPIMapTileLayer";
}

MVYahooTileLayer.prototype.init=function(x1)
{
this.map=new YMap(x1);
var x2=null;
if(this._f27!=null&&this._f28!=null)
{
x2=new YGeoPoint(this._f28,this._f27);
this.map.drawZoomAndCenter(x2,17-this._f20);
}
if(this.initializeListener)
this.initializeListener();
}

MVYahooTileLayer.prototype.setCenterAndZoomLevel=function(x3,x4,x5)
{
this._f27=x3;
this._f28=x4;
this._f20=x5;
if(this.map)
this.map.panToLatLon(new YGeoPoint(x4,x3),17-this._f20);
}

MVYahooTileLayer.prototype.getCenter=function()
{
var x6=this.map.getCenterLatLon();
return MVSdoGeometry.createPoint(x6.Lon,x6.Lat,this.srid);
}

MVYahooTileLayer.prototype._f196=function(x7,x8)
{
this.map.moveByXY(new YCoordPoint(x7,x8));
}

MVYahooTileLayer.prototype.setCenter=function(x9,x10)
{
this._f27=x9;
this._f28=x10;
if(this.map)
this.map.panToLatLon(new YGeoPoint(x10,x9));
}

MVYahooTileLayer.prototype.resize=function()
{
var x11=new YGeoPoint(this._f28,this._f27);
this.map.drawZoomAndCenter(x11,17-this._f20);

}

MVYahooTileLayer.prototype.clone=function()
{
var x12=new MVYahooTileLayer();
return x12;
}
MVMapView.version = "Ver11_B090416";
