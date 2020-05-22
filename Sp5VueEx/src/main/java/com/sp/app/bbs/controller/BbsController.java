package com.sp.app.bbs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.app.bbs.dto.BbsDto;
import com.sp.app.bbs.service.BbsService;

/**
 * 게시판
 * @author 김동건 (dgkim@bsgglobal.com)
 */
@Controller
public class BbsController {

	private static final Logger logger = LogManager.getLogger(BbsController.class);

	@Autowired
	private BbsService bbsServiceImpl;

	@Autowired
	Environment env;

	@Autowired
	Properties properties;

	@RequestMapping(value = "/selectDbBbsListAsMap.json")
	public @ResponseBody List<HashMap<String, Object>> selectDbBbsListAsMap(BbsDto bbsDto) {

		List<HashMap<String, Object>> mapList = null;
		try {
			mapList = bbsServiceImpl.selectDbBbsListAsMap(bbsDto);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapList;
	}
	
	@RequestMapping(value = "/insertDbBbsList.json")
	public @ResponseBody HashMap<String, Object> insertDbBbsList(BbsDto bbsDto) {

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			bbsServiceImpl.insertDbBbsList(bbsDto);
			resultMap.put("result", "S");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "E");
			resultMap.put("errorMsg", e.getMessage());
		}
		return resultMap;
	}
}
