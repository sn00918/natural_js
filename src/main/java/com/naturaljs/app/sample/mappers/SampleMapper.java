package com.naturaljs.app.sample.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {

	public List<Map<String, Object>> getSampleList(Map<String, Object> vo);

	public List<Map<String, Object>> getSample(int key);

	public int insertSample(Map<String, Object> vo);

	public int updateSample(Map<String, Object> vo);

	public int deleteSample(int key);

}
