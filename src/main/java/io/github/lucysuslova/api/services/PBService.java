package io.github.lucysuslova.api.services;

import io.github.lucysuslova.api.ServiceBuilder;
import io.github.lucysuslova.api.entities.ExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class PBService {

    @Autowired
    private ServiceBuilder serviceBuilder;

    private PBEndpoints pbEndpoints;

    @PostConstruct
    public void init() {
        pbEndpoints = serviceBuilder
                .build(PBEndpoints.class);
    }

    public ExchangeRates getExchangeRates (String date) throws IOException {
        return pbEndpoints.getExchangeRates(date).execute().body();
    }
}
