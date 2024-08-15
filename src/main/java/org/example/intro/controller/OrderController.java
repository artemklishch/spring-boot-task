package org.example.intro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.intro.dto.order.CreateOrderDto;
import org.example.intro.dto.order.OrderDto;
import org.example.intro.dto.order.OrderItemDto;
import org.example.intro.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Orders management", description = "Endpoints for orders management")
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Place the order", description = "Place the order")
    public OrderDto placeOrder(
            @RequestBody @Valid CreateOrderDto requestDto,
            Authentication authentication
    ) {
        return orderService.placeOrder(requestDto, authentication);
    }

    @Operation(summary = "Get orders", description = "Get orders")
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping
    public List<OrderDto> getOrders() {
        return null;
    }

    @Operation(summary = "Get the certain order", description = "Get the certain order by ID")
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/{orderId}/items")
    public List<OrderItemDto> getOrderItems(@PathVariable Long orderId) {
        return null;
    }

    @Operation(summary = "Get the certain order item", description = "Get the certain order item by IDs")
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("//{orderId}/items/{id}")
    public OrderItemDto getOrderItem(@PathVariable Long orderId, @PathVariable Long id) {
        return null;
    }
}
