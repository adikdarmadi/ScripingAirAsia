package com.scriping.base.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import com.scriping.base.dao.StationListDAO;
import com.scriping.base.entity.StationList;
import com.scriping.common.dao.AbstractDAO;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Component
public class StationListDAOImpl extends AbstractDAO<StationList> implements StationListDAO{

	@Override
	protected Class<StationList> getDomainClass() {
		// TODO Auto-generated method stub
		return StationList.class;
	}

	@Override
	public List<StationList> findAllStationList(String name, String sidx,String sord, String keyword) {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		List<StationList> listStationList=new ArrayList<StationList>();
		try {

			Object obj = parser.parse(new FileReader("d:\\airport.json"));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray jsonArray = (JSONArray) jsonObject.get("StationList");
			
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject explrObject = (JSONObject) jsonArray.get(i);
				StationList stl=new StationList();
				stl.setCode((String) explrObject.get("code"));
				stl.setCountryCode((String) explrObject.get("countryCode"));
				stl.setMacCode((String) explrObject.get("macCode"));
				stl.setName((String) explrObject.get("name"));
				stl.setProvinceStateCode((String) explrObject.get("provinceStateCode"));
				stl.setShortName((String) explrObject.get("shortName"));
				stl.setStationCategories((String) explrObject.get("stationCategories"));
				listStationList.add(stl);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listStationList;
	}

	@Override
	public List<StationList> findAllStationListLimitOfset(String string,int rowStart, int rowEnd, String sidx, String sord, String keyword) {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		List<StationList> listStationList=new ArrayList<StationList>();
		try {

			Object obj = parser.parse(new FileReader("d:\\airport.json"));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray jsonArray = (JSONArray) jsonObject.get("StationList");
			
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject explrObject = (JSONObject) jsonArray.get(i);
				StationList stl=new StationList();
				stl.setCode((String) explrObject.get("code"));
				stl.setCountryCode((String) explrObject.get("countryCode"));
				stl.setMacCode((String) explrObject.get("macCode"));
				stl.setName((String) explrObject.get("name"));
				stl.setProvinceStateCode((String) explrObject.get("provinceStateCode"));
				stl.setShortName((String) explrObject.get("shortName"));
				stl.setStationCategories((String) explrObject.get("stationCategories"));
				listStationList.add(stl);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listStationList;
	}

}
