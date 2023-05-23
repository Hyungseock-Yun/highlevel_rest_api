package jpastudy.jpashop.repository.order.simplequery;

import jpastudy.jpashop.domain.Address;
import jpastudy.jpashop.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class OrderSimpleQueryDto {

  private Long orderId;

  private String name;

  private LocalDateTime orderDate;

  private OrderStatus orderStatus;

  private Address address;

}
