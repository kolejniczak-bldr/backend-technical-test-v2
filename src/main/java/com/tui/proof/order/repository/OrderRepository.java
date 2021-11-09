package com.tui.proof.order.repository;

import com.tui.proof.order.Order;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
  List<Order> findAllByClient_FirstNameContainingIgnoreCaseOrClient_LastNameContainingIgnoreCase(
      String firstName, String lastName);

  default List<Order> searchAll(String searchTerm) {
    return findAllByClient_FirstNameContainingIgnoreCaseOrClient_LastNameContainingIgnoreCase(
        searchTerm, searchTerm);
  }
}
