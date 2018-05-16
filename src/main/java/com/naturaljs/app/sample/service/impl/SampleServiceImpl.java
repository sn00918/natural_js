package com.naturaljs.app.sample.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturaljs.app.sample.mappers.SampleMapper;

@Service("sampleService")
public class SampleServiceImpl {

	@Autowired
	private SampleMapper sampleMapper;

	public List<Map<String, Object>> getSampleList(Map<String, Object> vo) throws Exception {
		return sampleMapper.getSampleList(vo);
	}

	public Map<String, Object> getSample(int key) {
		return sampleMapper.getSample(key);
	}

	public int insertSample(Map<String, Object> vo) {
		return sampleMapper.insertSample(vo);
	}

	public int updateSample(Map<String, Object> vo) {
		return sampleMapper.updateSample(vo);
	}

	public int deleteSample(int key) {
		return sampleMapper.deleteSample(key);
	}

}