package kr.co.example.test01.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.example.test01.dao.Test02Dao;
import kr.co.example.test01.service.Test01Service;
import kr.co.example.test01.service.Test02Service;

@Service
public class Test02ServiceImpl implements Test02Service{

	@Autowired
	Test02Dao test02Dao;

	public List<Map<String, Object>> selectCateList() {
		return test02Dao.selectCateList();
	}

	public List<Map<String, Object>> selectEqList() {
		return test02Dao.selectEqList();
	}

	public List<Map<String, Object>> selectCompoList() {
		return test02Dao.selectCompoList();
	}
	

}
