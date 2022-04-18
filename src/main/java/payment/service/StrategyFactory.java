package payment.service;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import payment.model.PaymentType;
import payment.service.impl.PaymentServiceBrazilImpl;
import payment.service.impl.PaymentServicePeruImpl;

@Component
public class StrategyFactory {

    private Map<PaymentType, PaymentService> strategies = new EnumMap<>(PaymentType.class);

    public StrategyFactory() {
        initStrategies();
    }

    public PaymentService getStrategy(PaymentType paymentType) {
        if (paymentType == null || !strategies.containsKey(paymentType)) {
            throw new IllegalArgumentException("Invalid " + paymentType);
        }
        return strategies.get(paymentType);
    }

    private void initStrategies() {
        strategies.put(PaymentType.ES, new PaymentServicePeruImpl());
        strategies.put(PaymentType.PR, new PaymentServiceBrazilImpl());
    }

}
