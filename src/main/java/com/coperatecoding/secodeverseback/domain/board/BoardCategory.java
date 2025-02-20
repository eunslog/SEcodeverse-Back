package com.coperatecoding.secodeverseback.domain.board;

import com.coperatecoding.secodeverseback.domain.User;
import com.coperatecoding.secodeverseback.domain.ctf.CTFCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board_category")
public class BoardCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    private String name;


    public static BoardCategory makeCategory(String name) {
        BoardCategory newCategory = new BoardCategory();
        newCategory.name  = name;
        return newCategory;
    }

    public void updateName(String name) {
        this.name = name;
    }

}
