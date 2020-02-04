package io.github.lucysuslova.api.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ExchangeRate {

    @SerializedName("baseCurrency")
    @Expose
    public String baseCurrency;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("saleRateNB")
    @Expose
    public Float saleRateNB;
    @SerializedName("purchaseRateNB")
    @Expose
    public Float purchaseRateNB;
    @SerializedName("saleRate")
    @Expose
    public Float saleRate;
    @SerializedName("purchaseRate")
    @Expose
    public Float purchaseRate;

}
