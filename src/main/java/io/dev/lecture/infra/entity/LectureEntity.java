package io.dev.lecture.infra.entity;

import io.dev.lecture.domain.model.Lecture;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lecture")
@Getter
@NoArgsConstructor
public class LectureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;
    private String title;

    @OneToMany(mappedBy = "lecture")
    private List<ScheduleEntity> schedules = new ArrayList<>();

    public Lecture toLecture() {
        return new Lecture(id, title);
    }

}
