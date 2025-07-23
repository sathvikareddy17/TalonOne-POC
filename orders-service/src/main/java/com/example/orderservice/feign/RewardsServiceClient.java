package com.example.orderservice.feign;

import com.example.orderservice.dto.DiscountResponseDTO;
import com.example.orderservice.dto.OrderRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "rewards-service", url = "${rewards-service.url}")
public interface RewardsServiceClient {
    @PostMapping("/rewards/discount")
    DiscountResponseDTO getDiscount(@RequestBody OrderRequestDTO orderRequestDTO);
}
