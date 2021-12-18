package kr.co.example.test.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface TestDao {
	public Map<String, Object> selectTest01();
	
	public List<Map<String, Object>> selectCateList();
	public List<Map<String, Object>> selectEqList();
	public List<Map<String, Object>> selectCompoList();
}
