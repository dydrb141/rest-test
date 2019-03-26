package com.rest.events;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
//BUILDER를 쓸때 자동으로 AllArgsConstuctor가 생성되지만 xArgsConstructor를 사용하면 자동으로 작동하지 않는것 같음
//그래서 이걸 안넣어 주면 컴파일 오류 발생
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
public class Event {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location;
    private int basePrice;
    private int maxPrice;
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;
    @Enumerated(EnumType.STRING) //ODINAL은 이넘  순서에 따라 만들어 지기 때문에 순서가 변경되면 문제가 될 수 있어서 스트링을 사용하는게 좋다
    private EventStatus eventStatus = EventStatus.DRAFT;
}
