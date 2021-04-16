package com.real.q3;

public class Car {
	
	private String make;
	private String model;
	private int passengerCapacity;
	private double onRoadPrice;
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}
	public double getOnRoadPrice() {
		return onRoadPrice;
	}
	public void setOnRoadPrice(double onRoadPrice) {
		this.onRoadPrice = onRoadPrice;
	}
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public Car(String make, String model, int passengerCapacity, double onRoadPrice) {
		super();
		this.make = make;
		this.model = model;
		this.passengerCapacity = passengerCapacity;
		this.onRoadPrice = onRoadPrice;
	}
	
	
	
	
	
}
