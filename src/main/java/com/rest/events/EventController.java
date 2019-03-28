package com.rest.events;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Controller
@RequestMapping(value = "/api/events",  produces = MediaTypes.HAL_JSON_UTF8_VALUE)
public class EventController {
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;
    private final EventValidator eventValidator;


    public EventController(EventRepository eventRepository, ModelMapper modelMapper, EventValidator eventValidator) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
        this.eventValidator = eventValidator;
    }

    @PostMapping
    public ResponseEntity createEvent(@RequestBody @Valid EventDto eventDto, Errors erros) {
        if (erros.hasErrors()) {
            return ResponseEntity.badRequest().body(erros);

            //event도메인은 body에 담으면 json으로 변환 되지만 errors를 body에 담으면 왜 JSON으로 변환이 안될끼?
            //이벤트라는 도메인은 자바빈 스펙을 따르고 있고 내부적으로 objectMapper로 시리얼라이즈를 하는데 이때 BeanSerializer를 통해서 자바빈 스펙을 준수하고 있는 도메인을 시리얼라이즈 하여 JSON으로 만든다.
        }

        eventValidator.validate(eventDto, erros);

        if (erros.hasErrors()) {
            return ResponseEntity.badRequest().body(erros);
        }


        Event event = modelMapper.map(eventDto, Event.class);
        Event newEvent = this.eventRepository.save(event);
        URI createUri = linkTo(EventController.class).slash(newEvent.getId()).toUri();


        return ResponseEntity.created(createUri).body(event);
    }
}
