package com.javamicroservice.inventoryservice.service;

import com.javamicroservice.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCodce) {
        return inventoryRepository.findBySkuCode(skuCodce).isPresent();
    }
}
