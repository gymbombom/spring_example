package kr.co.example.test01.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.example.test01.dao.Test01Dao;
import kr.co.example.test01.service.Test01Service;

@Service
public class Test01ServiceImpl implements Test01Service{

	@Autowired
	Test01Dao test01Dao;
	

	@Override
	public Map<String, Object> selectTest01() {
		return test01Dao.selectTest01();
	}

}
