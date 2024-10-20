package CalenderService.calender_artifact.service;

import CalenderService.calender_artifact.model.HolidayResponse;
import reactor.core.publisher.Flux;

public interface CalendarHolidayDateService {

    Flux<HolidayResponse> getActiveReportingDates(String reportingDate);
}
