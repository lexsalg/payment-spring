package payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import payment.model.PaymentType;
import payment.model.Price;
import payment.model.Request;
import payment.service.PaymentService;
import payment.service.StrategyFactory;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final StrategyFactory strategyFactory;

    @Autowired
    public PaymentServiceImpl(StrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    @Override
    public Price calculatePrice(Request request) {
        PaymentType paymentType = request.getCountry().equals("Peru") ? PaymentType.ES : PaymentType.PR;
        PaymentService strategy = strategyFactory.getStrategy(paymentType);
        return strategy.calculatePrice(request);
    }

}
