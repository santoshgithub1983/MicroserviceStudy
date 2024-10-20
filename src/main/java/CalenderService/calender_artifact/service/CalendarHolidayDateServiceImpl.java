package CalenderService.calender_artifact.service;

import CalenderService.calender_artifact.entity.CalendarHolidayDate;
import CalenderService.calender_artifact.model.HolidayResponse;
import CalenderService.calender_artifact.repository.CalendarHolidayDateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Service
@AllArgsConstructor
public class CalendarHolidayDateServiceImpl implements CalendarHolidayDateService {

    private final CalendarHolidayDateRepository repository;

    @Override
    public Flux<HolidayResponse> getActiveReportingDates(String reportingDate) {
        Flux<CalendarHolidayDate> dates;
        // If reportingDate is provided and valid, search by reportingDate
        if (reportingDate != null && !reportingDate.trim().isEmpty()) {
            try {
                LocalDate parsedDate = LocalDate.parse(reportingDate);  // Parse reportingDate to LocalDate
                dates = repository.findByReportingDate(String.valueOf(parsedDate));
            } catch (DateTimeParseException e) {
                // If parsing fails, return an empty Flux (invalid date format)
                System.err.println("Invalid date format: " + reportingDate);
                return Flux.empty();
            }
        } else {
            // If reportingDate is not provided, return all future holidays including today
            LocalDate today = LocalDate.now();  // Get today's date based on the system
            dates = repository.findByIsActiveTrueAndFutureDates(today);
        }
        // Map entity to response model
        return dates.map(date -> new HolidayResponse(date.getReportingDate().toString(), date.getIsActive()));
    }
}

