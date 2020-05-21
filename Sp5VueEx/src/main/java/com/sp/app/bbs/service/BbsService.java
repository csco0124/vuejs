package com.sp.app.bbs.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sp.app.bbs.dao.BbsDao;

@Service
public class BbsService {
	
	@Inject
	private BbsDao bbsDao;

	/*
	 * public List<HashMap<String, Object>> selectDbBbsListAsMap() throws Exception
	 * { return bbsDao.selectDbBbsListAsMap(); }
	 */
}
