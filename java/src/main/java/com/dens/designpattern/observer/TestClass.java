package com.dens.designpattern.observer;

public class TestClass {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		weatherData.setMeasurements(100, 200, 30);
		CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(weatherData);
		ccd.update(weatherData, null);
	}
}
