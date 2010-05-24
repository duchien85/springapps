function showMap() {
    var baseURL = "http://192.168.9.11:8888/mapviewer";
    var mapCenterLon = -122.45;
    var mapCenterLat = 37.6706;
    var mpoint = MVSdoGeometry.createPoint(mapCenterLon,mapCenterLat,8307);
    var mapZoom = 5;

    var mapview = new MVMapView($("theMap"), baseURL);
    mapview.addBaseMapLayer(new MVBaseMap("mvdemo.demo_map"));
    mapview.setCenter(mpoint);
    mapview.setZoomLevel(mapZoom);
    mapview.addNavigationPanel("EAST");
    mapview.display();
}

document.observe("dom:loaded", function() {
  showMap();
});

