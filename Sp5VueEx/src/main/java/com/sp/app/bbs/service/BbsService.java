package com.sp.app.bbs.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sp.app.bbs.dao.BbsDao;
import com.sp.app.bbs.dto.BbsDto;
import com.sp.app.bbs.dto.BbsFileContentsDto;

@Service
public class BbsService {

	@Inject
	private BbsDao bbsDao;

	public List<HashMap<String, Object>> selectDbBbsListAsMap(BbsDto bbsDto) throws Exception {
		return bbsDao.selectDbBbsListAsMap(bbsDto);
	}
	
	public void insertDbBbsList(BbsDto bbsDto) throws Exception {
		bbsDao.insertDbBbsList(bbsDto);
	}

	public void deleteDbBbsList(BbsDto bbsDto) throws Exception {
		bbsDao.deleteDbBbsFileContents(bbsDto);
	}
	
	public void insertDbBbsFileContents(BbsFileContentsDto bbsFileContentsDto) throws Exception {
		bbsDao.insertDbBbsFileContents(bbsFileContentsDto);
	}
	
	public List<HashMap<String, Object>> selectDbBbsFileContentsList(BbsFileContentsDto bbsFileContentsDto) throws Exception {
		return bbsDao.selectDbBbsFileContentsList(bbsFileContentsDto);
	}
	
	public HashMap<String, Object> selectDbBbsFileContentsDetail(BbsFileContentsDto bbsFileContentsDto) throws Exception {
		return bbsDao.selectDbBbsFileContentsDetail(bbsFileContentsDto);
	}

}
