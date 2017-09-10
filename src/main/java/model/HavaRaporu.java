package model;

public class HavaRaporu {
	private String sehirBilgisi;
	private String ulkeBilgisi;
	private float sicaklik;
	private float basinc;
	private Long olcumZamani;
	private String dateStr;
	private String aciklama;

	public String getSehirBilgisi() {
		return sehirBilgisi;
	}

	public void setSehirBilgisi(String sehirBilgisi) {
		this.sehirBilgisi = sehirBilgisi;
	}

	public String getUlkeBilgisi() {
		return ulkeBilgisi;
	}

	public void setUlkeBilgisi(String ulkeBilgisi) {
		this.ulkeBilgisi = ulkeBilgisi;
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

	public Long getOlcumZamani() {
		return olcumZamani;
	}

	public void setOlcumZamani(Long olcumZamani) {
		this.olcumZamani = olcumZamani;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (sehirBilgisi != null) {
			builder.append(sehirBilgisi);
			builder.append(";");
		}
		if (aciklama != null)
			if (aciklama != null) {
				builder.append(aciklama);
				builder.append(";");
			}
		builder.append(sicaklik);
		builder.append(";");
		builder.append(basinc);
		builder.append(";");
		if (olcumZamani != null) {
			builder.append(olcumZamani);
			builder.append(";");
		}
		if (dateStr != null) {
			builder.append(dateStr);
		}
		return builder.toString();
	}

}