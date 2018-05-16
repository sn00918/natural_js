package com.naturaljs.app.sample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naturaljs.app.sample.service.impl.SampleServiceImpl;
import com.naturaljs.comm.naturaljs.NaturalJSUtils;

@RestController
@RequestMapping(value = "rest/sample")
public class SampleRestController {

	@Resource(name = "sampleService")
	SampleServiceImpl sampleService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Map<String, Object>> getSampleList(@RequestParam(required = false) String q) throws Exception {
		return sampleService.getSampleList(NaturalJSUtils.convertQParamToMap(q));
	}

	@RequestMapping(value = "{key}", method = RequestMethod.GET)
	public List<Map<String, Object>> getSample(@PathVariable int key) {
		return sampleService.getSample(key);
	}

	@RequestMapping(method = RequestMethod.POST)
	public int insertSample(@RequestBody Map<String, Object> vo) {
		return sampleService.insertSample(vo);
	}

	@RequestMapping(value = "{key}", method = RequestMethod.PATCH)
	public int updateSample(@PathVariable int key, @RequestBody Map<String, Object> vo) {
		vo.put("key", key);
		return sampleService.updateSample(vo);
	}

	@RequestMapping(value = "{key}", method = RequestMethod.DELETE)
	public int deleteSample(@PathVariable int key) {
		return sampleService.deleteSample(key);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Map<String, Object> saveSample(@RequestBody List<Map<String, Object>> voList) {
		Iterator<Map<String, Object>> iter = voList.iterator();

		Map<String, Object> vo;
		int insert = 0;
		int update = 0;
		int delete = 0;
		while (iter.hasNext()) {
			vo = (Map<String, Object>) iter.next();
			if ("insert".equals((String) vo.get("rowStatus"))) {
				insert += sampleService.insertSample(vo);
			} else if ("update".equals((String) vo.get("rowStatus"))) {
				update += sampleService.updateSample(vo);
			} else if ("delete".equals((String) vo.get("rowStatus"))) {
				delete += sampleService.deleteSample((Integer) vo.get("key"));
			}
		}

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("insert", insert);
		resultMap.put("update", update);
		resultMap.put("delete", delete);

		return resultMap;
	}

}