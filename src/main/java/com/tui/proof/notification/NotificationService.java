package com.tui.proof.notification;

import com.tui.proof.order.Order;

public interface NotificationService {
  void notifyOfNewOrder(Order order);

  void notifyOfUpdatedOrder(Order order);
}
