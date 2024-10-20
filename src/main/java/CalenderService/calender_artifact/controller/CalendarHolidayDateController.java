package CalenderService.calender_artifact.controller;

import CalenderService.calender_artifact.model.HolidayResponse;
import CalenderService.calender_artifact.service.CalendarHolidayDateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
public class CalendarHolidayDateController implements CalendarHolidayDateService {
    private final CalendarHolidayDateService service;

    @Override
    @GetMapping("/api/holidays")
    public Flux<HolidayResponse> getActiveReportingDates(@RequestParam(value = "reportingDate",
            required = false) String reportingDate) {
        try {
            return service.getActiveReportingDates(reportingDate);
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
            return Flux.empty();
        }
    }
}
