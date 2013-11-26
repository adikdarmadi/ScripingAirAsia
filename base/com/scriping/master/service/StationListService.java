package com.scriping.master.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.scriping.base.dao.StationListDAO;
import com.scriping.base.entity.StationList;
import com.scriping.common.util.ComboGridUtil;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;



@Component
@Transactional(rollbackFor = Exception.class)
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StationListService  {

	@Autowired
	private StationListDAO stationListDAO;

	public Map<String, Object> preadd() {
		List<StationList> listStationList = stationListDAO.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stationList", listStationList);

		return map;
	}

	@Transactional
	public void add(String stationListJson) throws org.json.simple.parser.ParseException {
		
		JSONParser parser = new JSONParser();
		List<StationList> listStationList = new ArrayList<StationList>();

		Object obj = parser.parse(stationListJson);

		JSONObject jsonObject = (JSONObject) obj;

		JSONArray jsonArray = (JSONArray) jsonObject.get("StationList");

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject explrObject = (JSONObject) jsonArray.get(i);
			StationList stl = new StationList();
			stl.setCode((String) explrObject.get("code"));
			stl.setCountryCode((String) explrObject.get("countryCode"));
			stl.setMacCode((String) explrObject.get("macCode"));
			stl.setName((String) explrObject.get("name"));
			stl.setProvinceStateCode((String) explrObject.get("provinceStateCode"));
			stl.setShortName((String) explrObject.get("shortName"));
			stl.setStationCategories((String) explrObject.get("stationCategories"));

			stationListDAO.insert(stl);
		}

	}
	
	@Transactional
	public void delete() throws org.json.simple.parser.ParseException {
		
		stationListDAO.deleteAll();

	}

	

}
