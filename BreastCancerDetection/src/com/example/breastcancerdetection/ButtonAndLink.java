package com.example.breastcancerdetection;


public class ButtonAndLink {

	private Integer id;
	private Class<?> link;
	
	public ButtonAndLink( Integer id, Class<?> link) {	
		this.id = id;
		this.link = link;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Class<?> getLink() {
		return link;
	}
	public void setLink(Class<?> link) {
		this.link = link;
	}

}
