package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

public interface BaseDictMapper {
	
	List<BaseDict> getDictListByTypeCode(String typeCode);
}
