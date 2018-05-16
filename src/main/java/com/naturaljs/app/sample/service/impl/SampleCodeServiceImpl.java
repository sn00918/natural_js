package com.naturaljs.app.sample.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturaljs.app.sample.mappers.SampleCodeMapper;

@Service("sampleCodeService")
public class SampleCodeServiceImpl {

	@Autowired
	private SampleCodeMapper sampleCodeMapper;

	public List<Map<String, Object>> getSampleCodeList(Map<String, Object> vo) throws Exception {
		return sampleCodeMapper.getSampleCodeList(vo);
	}

}