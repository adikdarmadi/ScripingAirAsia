package com.scriping.master.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

import com.scriping.base.entity.StationList;
import com.scriping.master.service.BookingService;

@Controller
@RequestMapping("/master/booking")
@SessionAttributes(types = StationList.class, value = "stationList")
public class BookingController {
	
	@Autowired
    private BookingService bookingService;
	
	
	@RequestMapping("/booking_add")
	@ModelAttribute("stationList")
	public ModelAndView preadd(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("master.booking_add",bookingService.preadd());
	}
	
	@RequestMapping(value = "/get_stationList_list", 
			method = RequestMethod.GET, 
			headers="Accept=*/*")
	public @ResponseBody Map<String, Object> getCountryList(@RequestParam("page") String page,@RequestParam("rows") String rows,
			@RequestParam("sidx") String sidx,@RequestParam("sord") String sord,@RequestParam(required=false,value="searchTerm") String query) {
		
		return bookingService.getStationListJsonList(page, rows, sidx, sord, query);
	}
	
	@RequestMapping("/booking_search")
	public ModelAndView add(@RequestParam(required = false, value="hiddenAsal")String hiddenAsal,
			@RequestParam(required = false, value="hiddenTujuan")String hiddenTujuan,
			@RequestParam(required = false, value="depart")String depart,
			@RequestParam(required = false, value="adult")String adult,
			@RequestParam(required = false, value="kids")String kids,
			@RequestParam(required = false, value="infants")String infants) throws  IOException{
		
		return new ModelAndView("master.booking_add",bookingService.search(hiddenAsal,hiddenTujuan,depart,adult,kids,infants));
	}

}
