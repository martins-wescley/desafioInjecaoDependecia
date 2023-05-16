package com.devsuperior.services;

import com.devsuperior.entities.Order;
import org.springframework.stereotype.Service;
@Service
public class ShippingService {

    public double shipment(Order order){
        double valorFrete;
        if (order.getBasic() < 100.00) {
            valorFrete = 20.00;
        } else if (order.getBasic() >= 100.00 && order.getBasic() < 200.00) {
            valorFrete = 12.00;
        } else {
            valorFrete = 0.0;
        }
        return valorFrete;
    }
}
