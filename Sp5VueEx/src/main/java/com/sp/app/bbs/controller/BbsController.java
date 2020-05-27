package com.sp.app.bbs.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sp.app.bbs.dto.BbsDto;
import com.sp.app.bbs.dto.BbsFileContentsDto;
import com.sp.app.bbs.service.BbsService;
import com.sp.app.common.util.CommonUtil;

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
	
	@RequestMapping(value = "/deleteDbBbsList.json")
	public @ResponseBody HashMap<String, Object> deleteDbBbsList(BbsDto bbsDto) {

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			bbsServiceImpl.deleteDbBbsList(bbsDto);
			resultMap.put("result", "S");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "E");
			resultMap.put("errorMsg", e.getMessage());
		}
		return resultMap;
	}
	
	
	@RequestMapping(value = "/editorUpload")
	public @ResponseBody HashMap<String, Object> editorUpload(Model model, @RequestParam("files") MultipartFile[] files, @RequestParam Map<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			BbsFileContentsDto bbsFileContentsDto = new BbsFileContentsDto();
			for (String key : map.keySet()) {
				System.out.println(String.format("키 : %s, 값 : %s", key, map.get(key)));
			}
			
			if(files.length > 0) {
				String filePath = CommonUtil.createFilePathFolder();
				int i = 0;
				for (MultipartFile file : files) {
					String fileName = "";
					String extension = "";
					String path = "";
					File convFile = null;
					if(file.getSize() > 0) {
						fileName = CommonUtil.getUUID();
						extension = FilenameUtils.getExtension(file.getOriginalFilename());
						convFile = new File(filePath.split("\\^\\^\\^")[0] + File.separator + fileName + "." + extension);
						path = properties.getProperty("common.fileLinkPath") + "/" + filePath.split("\\^\\^\\^")[1] + "/" + fileName + "." + extension;
						file.transferTo(convFile);
					}
					
					//다중파일업로드로 변경 필요
					if(i == 0) {
						bbsFileContentsDto.setFile1_name(file.getOriginalFilename());
						bbsFileContentsDto.setFile1_path(path);
					}else if(i == 1) {
						bbsFileContentsDto.setFile2_name(file.getOriginalFilename());
						bbsFileContentsDto.setFile2_path(path);
					}
					i++;
				}
			}
			
			bbsFileContentsDto.setContents(""+map.get("contents"));
			bbsServiceImpl.insertDbBbsFileContents(bbsFileContentsDto);
			resultMap.put("result", "S");			
		} catch (Exception e) {
			resultMap.put("result", "E");
			resultMap.put("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		return resultMap;
	}
	
	@RequestMapping(value = "/selectDbBbsFileListAsMap.json")
	public @ResponseBody List<HashMap<String, Object>> selectDbBbsFileListAsMap(BbsFileContentsDto bbsFileContentsDto) {

		List<HashMap<String, Object>> mapList = null;
		try {
			mapList = bbsServiceImpl.selectDbBbsFileContentsList(bbsFileContentsDto);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapList;
	}
	
	@RequestMapping(value = "/selectDbBbsFileDetailAsMap.json")
	public @ResponseBody HashMap<String, Object> selectDbBbsFileDetailAsMap(BbsFileContentsDto bbsFileContentsDto) {

		HashMap<String, Object> resultMap = null;
		try {
			resultMap = bbsServiceImpl.selectDbBbsFileContentsDetail(bbsFileContentsDto);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}
}
