package com.ssi.utility;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
	
	
	public static List<String> getCityNames(){
		List<String> cities=new ArrayList<String>();
		cities.add("indore");
		cities.add("bhopal");
		cities.add("delhi");
		cities.add("mumbai");
		cities.add("pune");
		cities.add("nagpur");
		cities.add("jabalpur");
		cities.add("jaipur");
		return cities;
	}

	public static List<String> getStateNames(){
		List<String> states=new ArrayList<String>();
		states.add("mp");
		states.add("mh");
		states.add("rj");
		states.add("delhi");
		return states;
	}

	public static List<String> getVehicleBrands(){
		List<String> brands=new ArrayList<String>();
		brands.add("Tata");
		brands.add("Eicher");
		brands.add("Mazda");
		brands.add("Mahindra");
		return brands;
	}

	public static List<String> getVehicleTypes(){
		List<String> vtypes=new ArrayList<String>();
		vtypes.add("Mini-Truck");
		vtypes.add("Tanker");
		vtypes.add("Dumper");
		vtypes.add("Container");
		return vtypes;
	}

}
