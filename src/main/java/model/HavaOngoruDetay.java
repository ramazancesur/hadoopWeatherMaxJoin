package model;

public class HavaOngoruDetay {
	private Long detayLongTime;
	private String sehirAdi;
	private String mainTemp;
	private String bulutDurumu;
	public Long getDetayLongTime() {
		return detayLongTime;
	}
	public void setDetayLongTime(Long detayLongTime) {
		this.detayLongTime = detayLongTime;
	}
	public String getSehirAdi() {
		return sehirAdi;
	}
	public void setSehirAdi(String sehirAdi) {
		this.sehirAdi = sehirAdi;
	}
	public String getMainTemp() {
		return mainTemp;
	}
	public void setMainTemp(String mainTemp) {
		this.mainTemp = mainTemp;
	}
	public String getBulutDurumu() {
		return bulutDurumu;
	}
	public void setBulutDurumu(String bulutDurumu) {
		this.bulutDurumu = bulutDurumu;
	}	
}
