package CalenderService.calender_artifact;

import CalenderService.calender_artifact.controller.CalendarHolidayDateController;
import CalenderService.calender_artifact.model.HolidayResponse;
import CalenderService.calender_artifact.service.CalendarHolidayDateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import java.util.List;
import static org.mockito.Mockito.when;

@WebFluxTest(controllers = CalendarHolidayDateController.class)
public class CalendarHolidayDateControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private CalendarHolidayDateService calendarHolidayDateService;

    @Test
    public void getActiveReportingDates_Success() {
        // Mock response data
        List<HolidayResponse> holidayResponses = List.of(
                new HolidayResponse("2023-12-25", true),
                new HolidayResponse("2024-01-01", true)
        );

        // Mock service behavior
      when(calendarHolidayDateService.getActiveReportingDates("2023-12-20"))
                .thenReturn(Flux.fromIterable(holidayResponses));

        // Perform the request
        webTestClient.get()
                .uri("/api/holidays?reportingDate=2023-12-20")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(HolidayResponse.class)
                .isEqualTo(holidayResponses);
    }

    @Test
    public void getActiveReportingDates_EmptyResponse() {
        // Mock service behavior
        when(calendarHolidayDateService.getActiveReportingDates("2024-02-01"))
                .thenReturn(Flux.empty());

        // Perform the request
        webTestClient.get()
                .uri("/api/holidays?reportingDate=2024-02-01")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(HolidayResponse.class)
                .hasSize(0);
    }

    @Test
    public void getActiveReportingDates_Exception() {
        // Mock service behavior
        when(calendarHolidayDateService.getActiveReportingDates("2023-12-20"))
                .thenThrow(new RuntimeException("Test exception"));

        // Perform the request
        webTestClient.get()
                .uri("/api/holidays?reportingDate=2023-12-20")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(HolidayResponse.class)
                .hasSize(0);
    }
}
