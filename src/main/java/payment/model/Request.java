package payment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Request {
    private String country;
    private Double priceBase;
    private String region;
    private String stateOrigin;
    private String stateSale;
}
