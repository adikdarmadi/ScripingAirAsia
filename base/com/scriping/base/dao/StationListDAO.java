package com.scriping.base.dao;

import java.util.List;

import com.scriping.base.entity.StationList;
import com.scriping.common.dao.DAO;

public interface StationListDAO extends DAO<StationList>{

	List<StationList> findAllStationList(String string, String sidx,String sord, String keyword);

	List<StationList> findAllStationListLimitOfset(String string, int rowStart,int rowEnd, String sidx, String sord, String keyword);

	
	
}
