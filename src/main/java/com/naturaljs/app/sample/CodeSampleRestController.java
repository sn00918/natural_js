package com.naturaljs.app.sample;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naturaljs.app.sample.service.impl.SampleCodeServiceImpl;
import com.naturaljs.comm.naturaljs.NaturalJSUtils;

@RestController
@RequestMapping("rest/sample/code")
public class CodeSampleRestController {

	@Resource(name = "sampleCodeService")
	SampleCodeServiceImpl sampleCodeService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Map<String, Object>> getSampleCodeList(@RequestParam(required = false) String q) throws Exception {
		return sampleCodeService.getSampleCodeList(NaturalJSUtils.convertQParamToMap(q));
	}

}