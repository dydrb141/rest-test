package com.rest.events;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {
    @Test
    public void buidler() {
        Event event = Event.builder()
                .name("Spring Rest Api")
                .description("Rest Api develmonet with srping")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
      /*  Event event = new Event();
        String event1 = "Event";
        String description = "Srping";

        event.setName(event1);
        event.setDescription(description);

        assertThat(event.getName()).isEqualTo(event1);
        assertThat(event.getDescription()).isEqualTo(description);*/
    }

}