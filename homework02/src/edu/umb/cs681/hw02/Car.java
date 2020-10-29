package edu.umb.cs681.hw02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

	public float getPrice() {
		return price;
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
		
		ArrayList<Car> cars = new ArrayList<>();
		
		cars.add(new Car("Porche", "LUX7", 700, 2019, 7000000));
		cars.add(new Car("Bentley", "GT", 400, 2018, 120000));
		cars.add(new Car("Audi", "Q7", 300, 2017, 300000));
		cars.add(new Car("BMW", "S3", 200, 2019, 180000));
		cars.add(new Car("Ferrari", "SL550", 100, 2020, 450000));
		cars.add(new Car("Toyota", "RAV4", 20, 2018, 100000));

		cars.forEach((Car car) -> car.setDominationCount(cars));

		List<Car> sortByPrice = cars
								.stream()
								.sorted(Comparator.comparing(Car::getPrice))
								.collect(Collectors.toList());
		List<Car> sortByYear = cars
								.stream()
								.sorted(Comparator.comparing(Car::getYear))
								.collect(Collectors.toList());
		List<Car> sortByMileage = cars
								.stream()
								.sorted(Comparator.comparing(Car::getMileage))
								.collect(Collectors.toList());
		List<Car> sortByDominationCount = cars
								.stream()
								.sorted(Comparator.comparing(Car::getDominationCount))
								.collect(Collectors.toList());

		System.out.println("\nSort by Price :\n");
		sortByPrice
			.forEach((Car car) -> System.out.println(car.getMake()  	+ "		"
												   + car.getModel() 	+ "		"
												   + car.getMileage() 	+ "		"
												   + car.getYear() 		+ "	:	"
												   + car.getPrice()));
		System.out.println("\nSort by Year :\n");
		sortByYear
			.forEach((Car car) -> System.out.println(car.getMake()  	+ "		"
												   + car.getModel() 	+ "		"
												   + car.getMileage() 	+ "		"
												   + car.getPrice() 		+ "	:	"
												   + car.getYear()));
		System.out.println("\nSort by Mileage :\n");
		sortByMileage
			.forEach((Car car) -> System.out.println(car.getMake()  	+ "		"
												   + car.getModel() 	+ "		"
												   + car.getPrice() 	+ "		"
												   + car.getYear() 		+ "	:	"
												   + car.getMileage()));

		System.out.println("\nSort by Domination Count :\n");
		sortByDominationCount
			.forEach((Car car) -> System.out.println(car.getMake()  	+ "		"
												   + car.getModel() 	+ "		"
												   + car.getMileage() 	+ "		"
												   + car.getYear() 	+ "		"
												   + car.getPrice() 		+ "	:	"
												   + car.getDominationCount()));
		
	}
}