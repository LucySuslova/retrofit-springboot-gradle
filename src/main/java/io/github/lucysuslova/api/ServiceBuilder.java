package io.github.lucysuslova.api;

import com.google.gson.GsonBuilder;
import io.github.lucysuslova.api.interceptors.BasicHeadersInterceptor;
import io.qameta.allure.okhttp3.AllureOkHttp3;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ServiceBuilder {


    @Value("${pb.baseUrl}")
    private String baseUrl;

    public <T> T build(Class<T> clazz) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS);
        for (Interceptor interceptor : provideInterceptors()) {
            okHttpClientBuilder.addInterceptor(interceptor);
        }
        return getRetrofit(okHttpClientBuilder).create(clazz);
    }

    private Retrofit getRetrofit(OkHttpClient.Builder okHttpClientBuilder) {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClientBuilder
                        .addInterceptor(loggingInterceptor)
                        .followRedirects(false)
                        .build())
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder()
                                .setLenient()
                                .create()))
                .build();
    }

    private List<Interceptor> provideInterceptors() {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new BasicHeadersInterceptor());
        interceptors.add(new AllureOkHttp3());
        return interceptors;
    }

}
