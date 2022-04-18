package payment.service.impl;

import payment.model.Price;
import payment.model.Request;
import payment.service.PaymentService;

public class PaymentServiceBrazilImpl implements PaymentService {

    @Override
    public Price calculatePrice(Request request) {

        Double tax = 0.20;
        if (request.getStateOrigin().equalsIgnoreCase(request.getStateSale())) {
            tax = 0.0;
        }

        Double price = request.getPriceBase() + request.getPriceBase() * tax;

        return new Price(request.getPriceBase() * tax, price);

    }
}
