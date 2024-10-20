package CalenderService.calender_artifact;

import CalenderService.calender_artifact.model.HolidayResponse;
import CalenderService.calender_artifact.service.CalendarHolidayDateService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.mock;

public class CalendarHolidayDateServiceTest {
    @Test
    public void getActiveReportingDates_Success() {
        // Create a mock implementation of CalendarHolidayDateService
        CalendarHolidayDateService calendarHolidayDateService = mock(CalendarHolidayDateService.class);

        // Mock response data
        List<HolidayResponse> holidayResponses = List.of(
                new HolidayResponse("2023-12-25", true),
                new HolidayResponse("2024-01-01", true)
        );

        // Mock service behavior
        Mockito.when(calendarHolidayDateService.getActiveReportingDates("2023-12-25"))
                .thenReturn(Flux.fromIterable(holidayResponses));

        // Perform the test
        Flux<HolidayResponse> result = calendarHolidayDateService.getActiveReportingDates("2023-12-25");
        assert Objects.equals(result.collectList().block(), holidayResponses);
    }

    @Test
    public void getActiveReportingDates_EmptyResponse() {
        // Create a mock implementation of CalendarHolidayDateService
        CalendarHolidayDateService calendarHolidayDateService = Mockito.mock(CalendarHolidayDateService.class);

        // Mock service behavior
        Mockito.when(calendarHolidayDateService.getActiveReportingDates("2024-02-01"))
                .thenReturn(Flux.empty());

        // Perform the test
        Flux<HolidayResponse> result = calendarHolidayDateService.getActiveReportingDates("");
        assert Objects.requireNonNull(result.collectList().block()).isEmpty();
    }

    @Test
    public void getActiveReportingDates_Exception() {
        // Create a mock implementation of CalendarHolidayDateService
        CalendarHolidayDateService calendarHolidayDateService = Mockito.mock(CalendarHolidayDateService.class);

        // Mock service behavior
        Mockito.when(calendarHolidayDateService.getActiveReportingDates("2023-12-32"))
                .thenThrow(new RuntimeException("Test exception"));

        // Perform the test
        try {
            calendarHolidayDateService.getActiveReportingDates("2023-12-32").blockFirst();
            assert false; // Exception should be thrown
        } catch (RuntimeException e) {
            // Expected exception
        }
    }


}
