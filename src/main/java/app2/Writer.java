package app2;

import java.util.List;

import helper.FileOperations;
import helper.Helper;
import model.City;
import model.Forcast;
import model.ForecastDetail;
import model.Weather;
import settings.EnumUtil;
import settings.Settings;

/**
 * Created by ramazancesur on 10/09/2017.
 */
public class Writer extends Thread {

	private String fileLocation;
	FileOperations fileOperations = null;
	List<City> lstCity;

	public Writer(String fileLocation, List<City> lstCity) {
		this.fileLocation = fileLocation;
		this.fileOperations = new FileOperations();
		this.lstCity = lstCity;
	}

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		super.run();

		for (City city : lstCity) {
			System.out.println(city.getName());
			/*
			 *
			 * http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=
			 * 48f0766fd655dd5c945fc4b3c140268e
			 *
			 *
			 * http://api.openweathermap.org/data/2.5/forecast?id=524901&appid=
			 * 48f0766fd655dd5c945fc4b3c140268e
			 */

			String url = Settings.webWebUrl + "forecast?id=" + city.getId() + "&APPID=" + Settings.weatherApiKey;

			List<Forcast> lstForcast = Helper.getInstance().getData(url, Forcast.class, EnumUtil.OKUMATIPI.WEB);

			lstForcast.stream().filter(x -> x.getCod() != null).distinct().forEach(havaOngoru -> {
				String genel = havaOngoru.getCity().getId()+";"+ havaOngoru.getCity().getName() + ";" + havaOngoru.getCod() + ";"
						+ havaOngoru.getCity().getCountry() + ";" + havaOngoru.getCnt();

				fileOperations.writeFile(genel, this.fileLocation + "_HavaOnguru.txt");

				List<ForecastDetail> lstForecastDetailD = havaOngoru.getList();
				lstForecastDetailD.stream().distinct().filter(dty -> dty.getClouds() != null && dty.getDt() != null)
						.forEach(detail -> {
							String forecastDetay = havaOngoru.getCity().getId() +";" + detail.getMain().getTemp()
										+";"+ detail.getDt() + ";" + havaOngoru.getCity().getName() + ";"
									+ detail.getClouds().getAll();
							fileOperations.writeFile(forecastDetay, this.fileLocation + "_TahminDetay.txt");

							if (detail.getWeather().stream().distinct().findFirst().isPresent() == true) {

								Weather weather = detail.getWeather().stream().distinct().findFirst().get();
								String sicaklik = havaOngoru.getCity().getId()+";"+ weather.getId() + ";" + havaOngoru.getCity().getName() + ";"
										+  weather.getDescription() + ";" + detail.getMain().getTemp() + ";"
										+ detail.getMain().getPressure();

								fileOperations.writeFile(sicaklik, this.fileLocation + "_Sicaklik.txt");

							}

						});

			});

		}

	}

}
