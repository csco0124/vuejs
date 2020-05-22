package com.sp.app.bbs.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sp.app.bbs.dto.BbsDto;

public interface BbsDao {
	
	public List<HashMap<String, Object>> selectDbBbsListAsMap(BbsDto bbsDto) throws DataAccessException;
	
	public void insertDbBbsList(BbsDto bbsDto) throws DataAccessException;
}
