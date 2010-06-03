package com.saic.controller;

import java.util.Arrays;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import com.saic.model.BatPerson;
import com.saic.model.BatPersons;
import com.saic.service.GeoSearchService;

@Controller
@RequestMapping("/geosearch")
public class GeoSearchController {
    Logger log = Logger.getLogger(GeoSearchController.class);

    @Resource
    GeoSearchService geoSearchService;

    @Resource
    ApplicationContext appContext;

    @RequestMapping(value = "/wkt.json", method = RequestMethod.GET)
    public @ResponseBody
    Model searchByWKTWindowJson(@RequestParam("shape") String shape, Model model) {
        this.log.debug("Searching using WKT: " + shape);
        printContext();
        Set<BatPerson> batPersons = this.geoSearchService.searchGuidsByLocation(shape);
        model.addAttribute("results", batPersons.size());
        model.addAttribute("rows", batPersons);
        model.addAttribute("msg", "Here is the message from the GeoSearchController!");
        model.addAttribute("success", Boolean.TRUE);
        return model;
    }

    @RequestMapping(value = "/wkt.xml", method = RequestMethod.GET)
    public @ResponseBody
    BatPersons searchByWKTWindowXml(@RequestParam("shape") String shape, Model model) {
        this.log.debug("Searching using WKT: " + shape);
        printContext();
        Set<BatPerson> personSet = this.geoSearchService.searchGuidsByLocation(shape);
        BatPersons batPersons = new BatPersons();
        batPersons.getBatPersons().addAll(personSet);
        return batPersons;
    }

    private void printContext() {
        this.log.debug(this.appContext);
        AnnotationMethodHandlerAdapter amha = this.appContext.getBean("org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter#0",
                AnnotationMethodHandlerAdapter.class);
        this.log.debug(amha.toString());
        this.log.debug(Arrays.toString(amha.getMessageConverters()));
    }
}
