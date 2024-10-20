package CalenderService.calender_artifact.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

public class HolidayResponse {

    @JsonProperty("skipDay")  // This ensures the key is "skipDay" in the JSON response
    private String skipDay;

    private boolean isActive;

    public HolidayResponse(String skipDay, boolean isActive) {
        this.skipDay = skipDay;
        this.isActive = isActive;
    }

    // Getters and setters
    public String getSkipDay() {
        return skipDay;
    }

    public void setSkipDay(String skipDay) {
        this.skipDay = skipDay;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}
