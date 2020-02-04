package io.github.lucysuslova.api.interceptors;

import okhttp3.Interceptor;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class BasicHeadersInterceptor implements Interceptor {

    @NotNull
    @Override
    public okhttp3.Response intercept(@NotNull Chain chain) throws IOException {
        Request originalRequest = chain.request();

        Request.Builder builder = originalRequest.newBuilder()
                .addHeader("Accept", "application/json, text/plain, */*");

        Request newRequest = builder.build();

        return chain.proceed(newRequest);
    }
}
