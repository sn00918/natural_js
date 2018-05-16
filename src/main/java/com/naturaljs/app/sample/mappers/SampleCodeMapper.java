package com.naturaljs.app.sample.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleCodeMapper {

	public List<Map<String, Object>> getSampleCodeList(Map<String, Object> vo);

}
