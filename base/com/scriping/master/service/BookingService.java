
package com.scriping.master.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.scriping.base.dao.StationListDAO;
import com.scriping.base.dto.Result;
import com.scriping.base.entity.StationList;
import com.scriping.common.util.ComboGridUtil;




@Component
@Transactional(rollbackFor = Exception.class)
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BookingService {

	@Autowired
	private StationListDAO stationListDAO;
	
	public Map<String, Object> preadd()  {

		Map<String, Object> mapX = new HashMap<String, Object>();
		StationList p = new StationList();
		mapX.put("stationList", p);
		return mapX;
	}
	
	@Transactional
	public Map<String, Object> getStationListJsonList(String page, String rows,String sidx, String sord, String searchTerm) {
		Map<String, Object> map = new HashMap<String, Object>();

		String keyword = ComboGridUtil.checkKeyword(searchTerm);
		List<StationList> allStationList = stationListDAO.comboGridFind("name",sidx, sord, keyword);
		int totalRow = allStationList.size();
		int totalPages = 0;
		int limit = Integer.parseInt(rows);
		int pageRequested = Integer.parseInt(page);

		if (totalRow > 0) {
			totalPages = (int) Math.ceil((double) totalRow / (double) limit);
		} else {
			totalPages = 0;
		}

		if (pageRequested > totalPages)
			pageRequested = totalPages;
		int rowStart = pageRequested * limit - limit;
		int rowEnd = limit;

		List<Object> list = new ArrayList<Object>();
		if (totalPages != 0) {
			map.put("page", page);
			map.put("total", totalPages);
			map.put("records", totalRow);
			for (StationList k : stationListDAO.comboGridFindLimitOffset(
					"name", rowStart, rowEnd, sidx, sord, keyword)) {
				Map<String, Object> map2 = new HashMap<String, Object>();
				map2.put("code", k.getCode());
				map2.put("countryCode", k.getCountryCode());
				map2.put("macCode", k.getMacCode());
				map2.put("name", k.getName());
				map2.put("provinceStateCode", k.getProvinceStateCode());
				map2.put("shortName", k.getShortName());
				map2.put("stationCategories", k.getStationCategories());
				list.add(map2);
			}
			map.put("rows", list);

		} else {
			map.put("page", page);
			map.put("total", totalPages);
			map.put("records", totalRow);
			for (StationList k : allStationList) {
				Map<String, Object> map2 = new HashMap<String, Object>();
				map2.put("code", k.getCode());
				map2.put("countryCode", k.getCountryCode());
				map2.put("macCode", k.getMacCode());
				map2.put("name", k.getName());
				map2.put("provinceStateCode", k.getProvinceStateCode());
				map2.put("shortName", k.getShortName());
				map2.put("stationCategories", k.getStationCategories());
				list.add(map2);
			}
			map.put("rows", list);
		}

		return map;
	}
	
	
	@RemoteMethod
	public synchronized Map<String, Object> search(String asal,String tujuan, String depart, String adult, String kids,String infants) throws IOException{
			
			String year=depart.substring(0,4);
			String month=depart.substring(5,7);
			String day=depart.substring(8,10);
			Document doc=null;
			doc = Jsoup.connect("" +
					"http://booking.airasia.com/Select.aspx?__EVENTTARGET=" +
					"&__EVENTARGUMENT=" +
					"&__VIEWSTATE=%2FwEPDwUBMGQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFP0NvbnRyb2xHcm91cFNlbGVjdFZpZXckU3BlY2lhbE5lZWRzSW5wdXRTZWxlY3RWaWV3JENoZWNrQm94U1NSc2KF%2B3FBQndP4mQD4nrPT4PNXNaR" +
					"&pageToken=" +
					"&MemberLoginSelectView%24HFTimeZone=420" +
					"&ControlGroupAvailabilitySearchInputSelectView%24ButtonSubmit=Go" +
					"&ControlGroupAvailabilitySearchInputSelectView%24AvailabilitySearchInputSelectView%24RadioButtonMarketStructure=RoundTrip" +
					"&ControlGroupAvailabilitySearchInputSelectView_AvailabilitySearchInputSelectVieworiginStation1="+asal+"" +
					"&ControlGroupAvailabilitySearchInputSelectView%24AvailabilitySearchInputSelectView%24TextBoxMarketOrigin1="+asal+"" +
					"&ControlGroupAvailabilitySearchInputSelectView_AvailabilitySearchInputSelectViewdestinationStation1="+tujuan+"" +
					"&ControlGroupAvailabilitySearchInputSelectView%24AvailabilitySearchInputSelectView%24TextBoxMarketDestination1="+tujuan+"" +
					"&date_picker="+month+"%2F"+day+"%2F"+year+"" +
					"&date_picker=" +
					"&ControlGroupAvailabilitySearchInputSelectView%24AvailabilitySearchInputSelectView%24DropDownListMarketDay1="+day+"" +
					"&ControlGroupAvailabilitySearchInputSelectView%24AvailabilitySearchInputSelectView%24DropDownListMarketMonth1="+year+"-"+month+""  +
					"&date_picker="+month+"%2F"+day+"%2F"+year+"" +
					"&date_picker=" +
					"&ControlGroupAvailabilitySearchInputSelectView%24AvailabilitySearchInputSelectView%24DropDownListMarketDay2="+day+"" +
					"&ControlGroupAvailabilitySearchInputSelectView%24AvailabilitySearchInputSelectView%24DropDownListMarketMonth2="+year+"-"+month+""  +
					"&ControlGroupAvailabilitySearchInputSelectView%24AvailabilitySearchInputSelectView%24DropDownListPassengerType_ADT="+adult+"" +
					"&ControlGroupAvailabilitySearchInputSelectView%24AvailabilitySearchInputSelectView%24DropDownListPassengerType_CHD="+kids+"" +
					"&ControlGroupAvailabilitySearchInputSelectView%24AvailabilitySearchInputSelectView%24DropDownListPassengerType_INFANT="+infants+"" +
					"&ControlGroupAvailabilitySearchInputSelectView%24MultiCurrencyConversionViewSelectView%24DropDownListCurrency=default" +
					"&ControlGroupAvailabilitySearchInputSelectView%24AvailabilitySearchInputSelectView%24DropDownListSearchBy=columnView")
		  . data("query", "Java") .userAgent("Mozilla") .cookie("auth", "token").timeout(30000).get();
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<Result> resultList=new ArrayList<Result>();
			resultList.clear();
			for (Element table : doc.select("table[id=fareTable1_4]")) {
				for(Element tr :table.select("tr[class=rgRow]")){
					org.jsoup.select.Elements tds = tr.select("td:not([rowspan])");
					org.jsoup.select.Elements tds2 = tr.select("td.selectedAirlineCode");
					Result result=new Result();
					
					String jadwalBerangkat=tds2.get(0).text()+"                                 ";
					String subStrJadwalBerangkat=jadwalBerangkat.substring(14,25)+jadwalBerangkat.substring(40,51)+jadwalBerangkat.substring(52,61);
					result.setJadwalBerangkat(subStrJadwalBerangkat);
					result.setLowFare(tds.get(0).text());
					result.setHiFlyer(tds.get(1).text());
					resultList.add(result);
				}
			}
			
			
	

			map.put("depart", doc.select("div[class=dateMarketHead]").get(0).text()+"("+doc.select("span[class=tDate]").get(0).text()+")");
			map.put("resultList", resultList);
			
		return map;
	}
	
}
