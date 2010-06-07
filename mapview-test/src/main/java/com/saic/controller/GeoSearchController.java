package com.saic.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saic.model.BatPerson;
import com.saic.model.BatPersons;
import com.saic.service.GeoSearchService;

/**
 * Spring controller used for ajax calls querying geospatial Bat info using the
 * 'GeoSearchService'.
 * 
 * @author studerw
 */
@Controller
@RequestMapping("/geosearch")
public class GeoSearchController {
    Logger log = Logger.getLogger(GeoSearchController.class);

    @Resource
    GeoSearchService geoSearchService;

    /**
     * @param shape
     *            WKT representation of a multipolygon for search Batted Persons
     * @param model
     *            container to store the model parameters
     * @return a json string formatted specifically for EXTJS 3.x JSON Reader of
     *         the BatGuids contained within the WKT polygon(s) passed in
     */
    @RequestMapping(value = "/wkt.json", method = RequestMethod.GET)
    public @ResponseBody
    Model searchByWKTWindowJson(@RequestParam("shape") String shape, Model model) {
        this.log.debug("Searching (returning JSON) using WKT: " + shape);
        List<BatPerson> batPersons = this.geoSearchService.searchGuidsByWKT(shape);
        model.addAttribute("results", batPersons.size());
        model.addAttribute("rows", batPersons);
        model.addAttribute("success", Boolean.TRUE);
        return model;
    }

    /**
     * @param shape
     *            WKT representation of a multipolygon for search Batted Persons
     * @return JAXB provided XML response as a BatPersons list of BatPerson
     *         objects that are contained within the WKT polygon(s)
     */
    @RequestMapping(value = "/wkt.xml", method = RequestMethod.GET)
    public @ResponseBody
    BatPersons searchByWKTWindowXml(@RequestParam("shape") String shape) {
        this.log.debug("Searching (returning XML) using WKT: " + shape);
        List<BatPerson> personSet = this.geoSearchService.searchGuidsByWKT(shape);
        BatPersons batPersons = new BatPersons();
        batPersons.getBatPersons().addAll(personSet);
        return batPersons;
    }
}
