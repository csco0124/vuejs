package com.sp.app.bbs.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sp.app.bbs.dto.BbsDto;
import com.sp.app.bbs.dto.BbsFileContentsDto;

public interface BbsDao {
	
	public List<HashMap<String, Object>> selectDbBbsListAsMap(BbsDto bbsDto) throws DataAccessException;
	
	public void insertDbBbsList(BbsDto bbsDto) throws DataAccessException;
	
	public void insertDbBbsFileContents(BbsFileContentsDto bbsFileContentsDto) throws DataAccessException;
	
	public List<HashMap<String, Object>> selectDbBbsFileContentsList(BbsFileContentsDto bbsFileContentsDto) throws DataAccessException;
	
	public HashMap<String, Object> selectDbBbsFileContentsDetail(BbsFileContentsDto bbsFileContentsDto) throws DataAccessException;
}
