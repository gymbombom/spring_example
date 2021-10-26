package kr.co.example.test01.service;

import java.util.List;
import java.util.Map;


public interface Test02Service {
	
	public List<Map<String, Object>> selectCateList();
	public List<Map<String, Object>> selectEqList();
	public List<Map<String, Object>> selectCompoList();
}
