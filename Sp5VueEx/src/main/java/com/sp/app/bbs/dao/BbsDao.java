package com.sp.app.bbs.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface BbsDao {
	
	public List<HashMap<String, Object>> selectDbBbsListAsMap() throws DataAccessException;
}
