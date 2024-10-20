package CalenderService.calender_artifact.repository;


import CalenderService.calender_artifact.entity.CalendarHolidayDate;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface CalendarHolidayDateRepository extends ReactiveCrudRepository<CalendarHolidayDate, Long> {
    Flux<CalendarHolidayDate> findByReportingDate(String reportingDate);
    Flux<CalendarHolidayDate> findByIsActiveTrue(); // If want to return all active without comparing with current date

    @Query("SELECT * FROM calendar.calendar_holiday_dates WHERE is_active = true AND reporting_date >= :date")
    Flux<CalendarHolidayDate> findByIsActiveTrueAndFutureDates(LocalDate currentDate);
}
