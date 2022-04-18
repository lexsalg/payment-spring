package payment.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import payment.model.Price;
import payment.model.Request;
import payment.service.PaymentService;

@RestController
@RequestMapping("v1/price")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = RequestMethod.GET)
    @GetMapping("/")
    public @ResponseBody Price getCompliance(@RequestParam(required = true) String country, //
            @RequestParam(required = true) Double priceBase, //
            @RequestParam(required = true) String region, //
            @RequestParam(required = true) String stateOrigin, //
            @RequestParam(required = true) String stateSale) {

        Request request = Request.builder().country(country).priceBase(priceBase).region(region)
                .stateOrigin(stateOrigin).stateSale(stateSale).build();

        return this.service.calculatePrice(request);
    }

}
