package jpastudy.jpashop.repository.order.simplequery;


import jpastudy.jpashop.domain.Address;
import jpastudy.jpashop.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(of = "orderId")
//@AllArgsConstructor
@Data
public class OrderQueryDto {

  private Long orderId;

  private String name;

  private LocalDateTime orderDate;

  private OrderStatus orderStatus;

  private Address address;

  private List<OrderItemQueryDto> orderItems;

  public OrderQueryDto(Long orderId, String name, LocalDateTime orderDate,
                       OrderStatus orderStatus, Address address) {
    this.orderId = orderId;
    this.name = name;
    this.orderDate = orderDate;
    this.orderStatus = orderStatus;
    this.address = address;
  }

}
