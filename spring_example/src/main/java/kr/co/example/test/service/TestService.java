package kr.co.example.test.service;

import java.util.List;
import java.util.Map;


public interface TestService {
	public Map<String, Object> selectTest01();
	
	public List<Map<String, Object>> selectCateList();
	public List<Map<String, Object>> selectEqList();
	public List<Map<String, Object>> selectCompoList();
}
