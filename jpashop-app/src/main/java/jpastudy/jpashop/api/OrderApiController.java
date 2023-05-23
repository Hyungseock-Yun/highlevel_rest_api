package jpastudy.jpashop.api;

import jpastudy.jpashop.domain.Address;
import jpastudy.jpashop.domain.Order;
import jpastudy.jpashop.domain.OrderItem;
import jpastudy.jpashop.domain.OrderStatus;
import jpastudy.jpashop.domain.dto.OrderSearch;
import jpastudy.jpashop.repository.OrderRepository;
import jpastudy.jpashop.repository.OrderQueryRepository;
import jpastudy.jpashop.repository.order.simplequery.OrderItemQueryDto;
import jpastudy.jpashop.repository.order.simplequery.OrderQueryDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class OrderApiController {

  private final OrderRepository orderRepository;

  private final OrderQueryRepository orderQueryRepository;

  @GetMapping("/api/v1/orders")
  public List<Order> ordersV1() {
    List<Order> all = orderRepository.findAll(new OrderSearch());
    for (Order order : all) {
      order.getMember().getName(); //Lazy 강제 초기화
      order.getDelivery().getAddress(); //Lazy 강제 초기화
      List<OrderItem> orderItems = order.getOrderItems();
      orderItems.forEach(orderItem -> orderItem.getItem().getName()); //Lazy 강제초기화
    }
    return all;
  }

  @GetMapping("/api/v2/orders")
  public List<OrderDto> ordersV2() {
    List<Order> orders = orderRepository.findAll(new OrderSearch());
    List<OrderDto> result = orders.stream()
      .map(OrderDto::new)
      .collect(Collectors.toList());
    return result;
  }

  @GetMapping("/api/v3/orders")
  public List<OrderDto> ordersV3() {
    List<Order> orders = orderRepository.findAllWithItem();
    List<OrderDto> result = orders.stream()
      .map(OrderDto::new)
      .collect(Collectors.toList());
    return result;
  }

  @GetMapping("/api/v3.1/orders")
  public List<OrderDto> ordersV3_page(
    @RequestParam(value = "offset", defaultValue = "0") int offset,
    @RequestParam(value = "limit", defaultValue= "100") int limit) {
    List<Order> orders = orderRepository.findAllWithMemberDelivery(offset,limit);
    List<OrderDto> result = orders.stream()
      .map(OrderDto::new)
      .collect(Collectors.toList());
    return result;
  }

  @GetMapping("/api/v4/orders")
  public List<OrderQueryDto> ordersV4() {
    return orderQueryRepository.findOrderQueryDtos();
  }

  @GetMapping("/api/v5/orders")
  public List<OrderQueryDto> ordersV5() {
    return orderQueryRepository.findAllByDto_optimization();
  }

  @Data
  static class OrderDto {
    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;
    private List<OrderItemDto> orderItems;
    public OrderDto(Order order) {
      orderId = order.getId();
      name = order.getMember().getName();
      orderDate = order.getOrderDate();
      orderStatus = order.getStatus();
      address = order.getDelivery().getAddress();
      orderItems = order.getOrderItems().stream()
        .map(OrderItemDto::new)
        .collect(Collectors.toList());
    }
  } //static class OrderDto

  @Data
  static class OrderItemDto {
    private String itemName; //상품 명
    private int orderPrice; //주문 가격
    private int count; //주문 수량
    public OrderItemDto(OrderItem orderItem) {
      itemName = orderItem.getItem().getName();
      orderPrice = orderItem.getOrderPrice();
      count = orderItem.getCount();
    }
  } //static class OrderItemDto
}
