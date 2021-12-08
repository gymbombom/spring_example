package kr.co.example.test01.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface Test02Dao {
	public List<Map<String, Object>> selectCateList();
	public List<Map<String, Object>> selectEqList();
	public List<Map<String, Object>> selectCompoList();
}
