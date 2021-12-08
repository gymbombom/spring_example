package kr.co.example.ajax.dao;

import java.util.List;

public class AjaxVO {
	String korName;
	String engName;
	Integer age;
	String height;
	double weight;
	AjaxVO subAjaxVO;
	
	List<AjaxVO> ajaxVOList;
	
	
	public String getKorName() {
		return korName;
	}
	public void setKorName(String korName) {
		this.korName = korName;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public AjaxVO getSubAjaxVO() {
		return subAjaxVO;
	}
	public void setSubAjaxVO(AjaxVO subAjaxVo) {
		this.subAjaxVO = subAjaxVo;
	}
	public List<AjaxVO> getAjaxVOList() {
		return ajaxVOList;
	}
	public void setAjaxVOList(List<AjaxVO> ajaxVOList) {
		this.ajaxVOList = ajaxVOList;
	}
	
		
	
}
