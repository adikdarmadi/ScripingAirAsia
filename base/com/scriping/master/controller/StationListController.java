package com.scriping.master.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.scriping.base.entity.StationList;
import com.scriping.master.service.StationListService;

@Controller
@RequestMapping("/master/stationList")
@SessionAttributes(types = StationList.class, value = "stationList")
public class StationListController{
	
private String defaultUrlExtension = ".html";
	
	public final ModelAndView redirectTo(String url){
		return new ModelAndView(new RedirectView(url + defaultUrlExtension, true));
	}
	
	@Autowired
    private StationListService stationListService;
	
	@RequestMapping("/stationList_search")
    public ModelAndView search(){
		return new ModelAndView("master.stationList_search");
    }
	
	@RequestMapping("/stationList_add")
	@ModelAttribute("stationList")
	public ModelAndView preadd(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("master.stationList_add",stationListService.preadd());
	}
	
	@RequestMapping("/stationList_add_save")
	public ModelAndView add(@RequestParam(required = false, value="stationListJson")String stationListJson) throws  ParseException{
		stationListService.add(stationListJson);
		return redirectTo("/master/stationList/stationList_add");
		
	}
	
	@RequestMapping("/stationList_delete")
	public ModelAndView delete() throws  ParseException{
		stationListService.delete();
		return redirectTo("/master/stationList/stationList_add");
		
	}
	
	
	

}
