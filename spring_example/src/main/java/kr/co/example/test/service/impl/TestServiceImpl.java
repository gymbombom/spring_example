package kr.co.example.test.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.example.test.dao.TestDao;
import kr.co.example.test.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	TestDao testDao;
	
	public Map<String, Object> selectTest01() {
		return testDao.selectTest01();
	}
	
	public List<Map<String, Object>> selectCateList() {
		return testDao.selectCateList();
	}

	public List<Map<String, Object>> selectEqList() {
		return testDao.selectEqList();
	}

	public List<Map<String, Object>> selectCompoList() {
		return testDao.selectCompoList();
	}
}
