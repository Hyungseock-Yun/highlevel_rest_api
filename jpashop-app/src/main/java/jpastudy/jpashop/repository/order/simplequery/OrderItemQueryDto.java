package jpastudy.jpashop.repository.order.simplequery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderItemQueryDto {

  @JsonIgnore
  private Long orderId; //주문번호

  private String itemName;//상품명

  private int orderPrice; //주문가격

  private int count; //주문수량

}
