package CalenderService.calender_artifact;

import CalenderService.calender_artifact.entity.CalendarHolidayDate;
import CalenderService.calender_artifact.model.HolidayResponse;
import CalenderService.calender_artifact.repository.CalendarHolidayDateRepository;
import CalenderService.calender_artifact.service.CalendarHolidayDateServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import reactor.core.publisher.Flux;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class CalendarHolidayDateServiceImplTest {
 /*   @Test
    public void getActiveReportingDates_ValidReportingDate_Success() {
        // Mock dependencies
        CalendarHolidayDateRepository mockRepository = mock(CalendarHolidayDateRepository.class);
        CalendarHolidayDateServiceImpl service = new CalendarHolidayDateServiceImpl(mockRepository);

        // Mock data
        LocalDate expectedDate = LocalDate.of(2024, 10, 21);
        List<CalendarHolidayDate> mockHolidays = Collections.singletonList(
                new CalendarHolidayDate(expectedDate, true)
        );
        Flux<CalendarHolidayDate> mockResult = Flux.fromIterable(mockHolidays);

        // Mock repository behavior
       when(mockRepository.findByReportingDate(expectedDate.toString()))
                .thenReturn(mockResult);

        // Capture argument
        ArgumentCaptor<String> reportingDateCaptor = ArgumentCaptor.forClass(String.class);

        // Perform the test
        TestSink<HolidayResponse> testSink = service.getActiveReportingDates("2024-10-21").test();

        // Verification
        verify(mockRepository).findByReportingDate(reportingDateCaptor.capture());
        assert reportingDateCaptor.getValue().equals(expectedDate.toString());
        testSink.expectNextMatches(response -> response.getDate().equals(expectedDate.toString()))
                .expectComplete()
                .verify();
    }

    @Test
    public void getActiveReportingDates_InvalidReportingDate_EmptyResponse() {
        // Mock dependencies
        CalendarHolidayDateRepository mockRepository = Mockito.mock(CalendarHolidayDateRepository.class);
        CalendarHolidayDateServiceImpl service = new CalendarHolidayDateServiceImpl(mockRepository);

        // Perform the test with invalid format
        TestSink<HolidayResponse> testSink = service.getActiveReportingDates("invalid-date").test();

        // Verification
        Mockito.verifyNoInteractions(mockRepository);
        testSink.expectComplete()
                .verify();
    }

    @Test
    public void getActiveReportingDates_NoReportingDate_Success() {
        // Mock dependencies
        CalendarHolidayDateRepository mockRepository = Mockito.mock(CalendarHolidayDateRepository.class);
        CalendarHolidayDateServiceImpl service = new CalendarHolidayDateServiceImpl(mockRepository);

        // Mock data
        LocalDate today = LocalDate.now();
        List<CalendarHolidayDate> mockHolidays = Collections.singletonList(
                new CalendarHolidayDate(today.plusDays(1), true)
        );
        Flux<CalendarHolidayDate> mockResult = Flux.fromIterable(mockHolidays);

        // Mock repository behavior
        Mockito.when(mockRepository.findByIsActiveTrueAndFutureDates(today))
                .thenReturn(mockResult);

        // Perform the test
        TestSink<HolidayResponse> testSink = service.getActiveReportingDates(null).test();

        // Verification
        Mockito.verify(mockRepository).findByIsActiveTrueAndFutureDates(today);
        testSink.expectComplete()
                .verify();
    }

    @Test
    public void getActiveReportingDates_RepositoryError_EmptyResponse() {
        // Mock dependencies
        CalendarHolidayDateRepository mockRepository = Mockito.mock(CalendarHolidayDateRepository.class);
        CalendarHolidayDateServiceImpl service = new CalendarHolidayDateServiceImpl(mockRepository);

        // Mock repository behavior
        Mockito.when(mockRepository.findByReportingDate(Mockito.anyString()))
                .thenReturn(Flux.error(new RuntimeException("Test exception")));

        // Perform the test
        TestSink<HolidayResponse> testSink = service.getActiveReportingDates("2024-10-21").test();

        // Verification
        testSink.expectError(RuntimeException.class)
                .verify();
    }*/
}
