package model;

import java.io.Serializable;
import java.util.List;

public class Forcast implements Serializable{
	private String cod;
	private float message;
	private int cnt;
	private City city;
	private List<ForecastDetail> list;
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public float getMessage() {
		return message;
	}
	public void setMessage(float message) {
		this.message = message;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<ForecastDetail> getList() {
		return list;
	}
	public void setList(List<ForecastDetail> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "Forcast [cod=" + cod + ", message=" + message + ", cnt=" + cnt + ", city=" + city + ", list=" + list
				+ "]";
	}
	
	
}