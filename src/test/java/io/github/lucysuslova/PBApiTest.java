package io.github.lucysuslova;

import io.github.lucysuslova.api.entities.ExchangeRates;
import io.github.lucysuslova.api.services.PBService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("pb")
@DisplayName("Public PB api tests")
@SpringBootTest(classes = Application.class)
public class PBApiTest {

    @Autowired
    PBService pbService;

    @Test
    @DisplayName("Verify exchange rates")
    public void exchangeRatesTest() throws IOException {

        ExchangeRates rates = pbService.getExchangeRates(getFormattedCurrentDate());
        assertAll(() -> {
            assertEquals(rates.getDate(), getFormattedCurrentDate());
            assertEquals(rates.getBank(), "PB");
            });
    }

    private String getFormattedCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.now().format(formatter);
    }
}
