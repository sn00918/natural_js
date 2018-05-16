package com.naturaljs.app.sample;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturaljs.app.sample.service.impl.SampleCodeServiceImpl;

@RestController
@RequestMapping("rest/sample/code")
public class CodeSampleRestController {

	@Resource(name = "sampleCodeService")
	SampleCodeServiceImpl sampleCodeService;

	@RequestMapping("getSampleCodeList.json")
	public List<Map<String, Object>> getSampleCodeList(@RequestBody Map<String, Object> vo) throws Exception {
		return sampleCodeService.getSampleCodeList(vo);
	}

}