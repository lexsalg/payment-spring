package payment.service;

import payment.model.Price;
import payment.model.Request;

public interface PaymentService {

    Price calculatePrice(Request request);
}
