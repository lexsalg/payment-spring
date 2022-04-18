package payment.service.impl;

import payment.model.Price;
import payment.model.Request;
import payment.service.PaymentService;

public class PaymentServicePeruImpl implements PaymentService {

    final String selva = "Selva";

    @Override
    public Price calculatePrice(Request request) {

        Double tax = 0.18;
        if (selva.equalsIgnoreCase(request.getRegion())) {
            tax = 0.0;
        }

        Double price = request.getPriceBase() + request.getPriceBase() * tax;

        return new Price(request.getPriceBase() * tax, price);
    }

}
