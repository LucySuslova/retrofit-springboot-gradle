package io.github.lucysuslova.api.services;

import io.github.lucysuslova.api.entities.ExchangeRates;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PBEndpoints {

    @GET("p24api/exchange_rates?json")
    Call<ExchangeRates> getExchangeRates(@Query("date") String date);
}
