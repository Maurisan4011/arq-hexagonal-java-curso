package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.adapter.out.persistence.order.JpaOrderRepository;
import com.example.hexagonal.domain.model.Order;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@Transactional
class JpaOrderRepositoryTest {

    @Inject
    JpaOrderRepository orderRepository;

    @Inject
    EntityManager entityManager;

    @Test
    void testSaveOrder() {
        Order order = new Order(null, "Test Order", LocalDateTime.now());
        orderRepository.save(order);
        entityManager.flush();
        entityManager.clear();

        Optional<Order> savedOrder = orderRepository.findById(order.getId());
        assertTrue(savedOrder.isPresent());
        assertEquals(order.getDescription(), savedOrder.get().getDescription());
    }



    @Test
    void testDeleteOrder() {
        Order order = new Order(null, "Test Order", LocalDateTime.now());
        orderRepository.save(order);
        entityManager.flush();
        entityManager.clear();

        orderRepository.deleteById(order.getId());
        entityManager.flush();
        entityManager.clear();

        Optional<Order> deletedOrder = orderRepository.findById(order.getId());
        assertTrue(deletedOrder.isEmpty());
    }
}