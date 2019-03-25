package com.rest.events;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
//BUILDER를 쓸때 자동으로 AllArgsConstuctor가 생성되지만 xArgsConstructor를 사용하면 자동으로 작동하지 않는것 같음
//그래서 이걸 안넣어 주면 컴파일 오류 발생
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Event {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollemntDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location;
    private int basePrice;
    private int maxPrice;
    private boolean limitOfEnrollemnt;
    private boolean offline;
    private boolean free;
    private EventStatus eventStatus;
}
