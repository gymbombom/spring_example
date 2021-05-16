package kr.co.example.test01.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface Test01Dao {
	public Map<String, Object> selectTest01();

}
