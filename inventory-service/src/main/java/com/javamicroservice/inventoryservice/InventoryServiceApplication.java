package com.javamicroservice.inventoryservice;

import com.javamicroservice.inventoryservice.model.Inventory;
import com.javamicroservice.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setQuantity(100);
			inventory.setSkuCode("deck_001");

			Inventory inventory1 = new Inventory();
			inventory1.setQuantity(0);
			inventory1.setSkuCode("iphone13_red_128");

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}
