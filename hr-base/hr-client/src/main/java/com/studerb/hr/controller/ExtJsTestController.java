package com.studerb.hr.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/extjs_test/*.htm")
public class ExtJsTestController {
    Logger logger = Logger.getLogger(ExtJsTestController.class);

    @RequestMapping(method = RequestMethod.GET)
    public void remoteHtml(Writer writer, HttpServletResponse response) throws IOException {
        this.logger.debug("remote_html: ajax remote for getting html");
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        writer.write("<h1>INserting</h1><p>Here is some stuff</p>");
    }

    @RequestMapping(method = RequestMethod.GET)
    public void htmlPanel() {
        this.logger.debug("Getting initial 'html_content' page");
    }
}
