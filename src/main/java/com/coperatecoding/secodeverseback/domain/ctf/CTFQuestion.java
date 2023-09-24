package com.coperatecoding.secodeverseback.domain.ctf;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "ctf_question")
public class CTFQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @ManyToOne
    @JoinColumn(name = "league_pk")
    private CTFLeague league;

    @ManyToOne
    @JoinColumn(name = "category_pk")
    private CTFCategory category;

    @NotNull
    private String name;

    @NotNull
    private Integer score;

    @NotNull
    @Column(length = 99999)
    private String description;

    @NotNull
    private String answer;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CTFQuestionType type;

}
