package com.tui.proof.notification;

import com.tui.proof.order.Order;
import java.text.MessageFormat;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class NotificationServiceImpl implements NotificationService {
  @Override
  public void notifyOfNewOrder(Order order) {
    log.info(MessageFormat.format("Order {0} placed", order));
  }

  @Override
  public void notifyOfUpdatedOrder(Order order) {
    log.info(MessageFormat.format("Order {0} updated", order));
  }
}
