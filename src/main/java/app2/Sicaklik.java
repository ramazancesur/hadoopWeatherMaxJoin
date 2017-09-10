package app2;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import helper.FileOperations;
import helper.Helper;
import model.City;
import settings.EnumUtil;

public class Sicaklik {
	public static List<City> lstCity;

	public static void main(String[] args) throws Exception {
		List<City> lstCity = Helper.getInstance().getData("weather/cityList.json", City.class, EnumUtil.OKUMATIPI.RESOURCE);
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Runnable worker= new Writer( FileOperations.getWorkSpacePath( "hadoop/data"),lstCity);
		executor.execute(worker);
	}

}
