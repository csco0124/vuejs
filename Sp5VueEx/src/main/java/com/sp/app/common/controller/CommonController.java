package com.sp.app.common.controller;

import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sp.app.common.util.CommonUtil;


/**
 * @author dgkim@bsgglobal.com
 */
@Controller
public class CommonController {

	private static final Logger logger = LogManager.getLogger(CommonController.class);
	
	@Autowired
	Environment env;
		
	@RequestMapping(value = "/i18nProperties/{propertiesName}")
	public void i18nProperties(@PathVariable String propertiesName, HttpServletRequest req, HttpServletResponse res) throws Exception {
		OutputStream outputStream = res.getOutputStream();
		//Locale locale = RequestContextUtils.getLocale(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());	//�궗�슜�옄 �뼵�뼱
		Resource resource = new ClassPathResource("/properties/i18n/" + propertiesName + ".properties");
		InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream(), Charset.forName("UTF-8"));
		List<String> readLines = IOUtils.readLines(inputStreamReader);
		IOUtils.writeLines(readLines, null, outputStream, "UTF-8");
		inputStreamReader.close();
		outputStream.close();
	}
	
	@RequestMapping("/imageUpload.ajax")
	public @ResponseBody String imageUpload(Model model, @RequestParam("files") MultipartFile[] files) {
		try {
			if(files.length > 0) {
				String filePath = CommonUtil.createFilePathFolder();
				for (MultipartFile file : files) {
					System.out.println("file : " + file);
					if(file.getSize() > 0) {
						File convFile = new File(filePath + File.separator + file.getOriginalFilename());
						file.transferTo(convFile);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "aaa/aaa";
	}
}
