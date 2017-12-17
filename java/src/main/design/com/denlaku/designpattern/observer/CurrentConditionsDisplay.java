package com.denlaku.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer {
	Observable observable;
	private float temperature;
	private float humidity;

	public CurrentConditionsDisplay(Observable o) {
		this.observable = o;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}

}
