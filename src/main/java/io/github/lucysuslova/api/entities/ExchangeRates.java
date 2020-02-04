package io.github.lucysuslova.api.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ExchangeRates {

    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("bank")
    @Expose
    public String bank;
    @SerializedName("baseCurrency")
    @Expose
    public Integer baseCurrency;
    @SerializedName("baseCurrencyLit")
    @Expose
    public String baseCurrencyLit;
    @SerializedName("exchangeRate")
    @Expose
    public List<ExchangeRate> exchangeRate;
}
