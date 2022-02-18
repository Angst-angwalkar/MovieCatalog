package io.evilsking.moviecatalogservice.models;

public class MovieCatalog {
	
	private String name;
	private String desc;
	private int rating;
	
	
	public MovieCatalog() {}
	
	public MovieCatalog(String name, String desc, int rating) {
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void getRating(int rating) {
		this.rating = rating;
	}

}
