package com.packt.cardatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication {

	@Autowired
    private CarRepository carRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}
	
	@Bean 
	CommandLineRunner runner() {
		return args -> {
			
			Owner qjo = new Owner("Vinicius", "Campos");
			Owner qja = new Owner("Karina", "Campos");
			ownerRepository.save(qjo);
			ownerRepository.save(qja);
			
			carRepository.save(new Car(qjo, "Nissan", "Altima", "Red",
					"ADF-1121", 2017, 59000));
			carRepository.save(new Car(qja, "Nissan", "Leaf", "White",
					"SSJ-3002", 2014, 29000));
			carRepository.save(new Car(qjo, "Toyota", "Prius", "Silver", 
					"KKO-0212", 2014, 39000));
			List<Car> cars = carRepository.findNewCars(2010);
			for (Car c : cars) {
				System.out.println("model: " + c.getModel());
			}
		};
	}
	

}
