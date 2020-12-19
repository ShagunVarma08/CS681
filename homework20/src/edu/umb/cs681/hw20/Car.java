package edu.umb.cs681.hw20;

import java.util.ArrayList;
import java.util.List;

public class Car {

	private String model, make;
	private int mileage, year;
	private float price;
	private int dominationCount;

	public Car(String make, String model, int mileage, int year, float price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return (int) price;
	}

	public int getDominationCount() {
		return this.dominationCount;
	}

	public void setDominationCount(List<Car> cars) {
		for (Car car : cars) {
			if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
					&& (car.getYear() <= this.getYear())) {
				this.dominationCount++;
			}
		}
		this.dominationCount--; 	
	}

	public static void main(String[] args) {
		
		List<Car> cars = new ArrayList<>();
		
		cars.add(new Car("Porche", "LUX7", 700, 2019, 7000000));
		cars.add(new Car("Bentley", "GT", 400, 2018, 120000));
		cars.add(new Car("Audi", "Q7", 300, 2017, 300000));
		cars.add(new Car("BMW", "S3", 200, 2019, 180000));
		cars.add(new Car("Ferrari", "SL550", 100, 2020, 450000));
		cars.add(new Car("Toyota", "RAV4", 20, 2018, 100000));

		cars.forEach((Car car) -> car.setDominationCount(cars));

		Integer Mileage = cars
							 .stream()
							 .parallel()
							 .map((Car car) -> car.getMileage())
							 .reduce(0, (result, carMileage) -> {
								 if (result == 0)				return carMileage;
								 else if (carMileage < result)	return carMileage;
								 else							return result;}	);

		System.out.println("Minimum Car Mileage\t: " + Mileage);

		Integer Price = cars
						   .stream()	
						   .parallel()
						   .map((Car car) -> car.getPrice())
						   .reduce(0, (result, carPrice) -> {
							   	if (result == 0)			return carPrice;
								else if (carPrice > result)	return carPrice;
								else						return result;}	);

		System.out.println("Maximum Car Price \t: " + Price);

		Integer Make = cars
						  .stream()
						  .parallel()
						  .map((Car car) -> car.getMake())
						  .reduce(0, (result, carMake) -> 	++result,
							      (finalResult, intermediateResult) -> finalResult);

		System.out.println("Count of Car Make\t: " + Make);
		
	}
}