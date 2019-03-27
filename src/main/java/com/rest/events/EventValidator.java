package com.rest.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Component
public class EventValidator {
    public void validate(EventDto eventDto, Errors erros) {
        if (eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() != 0) {
            erros.rejectValue("basePrice", "wrongValue", "BasePrice wrong");
            erros.rejectValue("maxPrice", "wrongValue", "maxPrice wrong");
        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();

        if (endEventDateTime.isBefore(eventDto.getBeginEventDateTime())
            || endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime())
            || endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())) {
            erros.rejectValue("endEventDateTime", "wrongValue", "beginDateTime  is wrong");

        }

    }
}
