package model;

public class HavaSicaklik {
	private Long weatherID;
	private String sehirAdi;
	private String aciklama;
	private float sicaklik;
	private float basinc;
	public Long getWeatherID() {
		return weatherID;
	}
	public void setWeatherID(Long weatherID) {
		this.weatherID = weatherID;
	}
	public String getSehirAdi() {
		return sehirAdi;
	}
	public void setSehirAdi(String sehirAdi) {
		this.sehirAdi = sehirAdi;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public float getSicaklik() {
		return sicaklik;
	}
	public void setSicaklik(float sicaklik) {
		this.sicaklik = sicaklik;
	}
	public float getBasinc() {
		return basinc;
	}
	public void setBasinc(float basinc) {
		this.basinc = basinc;
	}
	
	
	
}
