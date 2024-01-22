package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Account {
    private String id;
    private String pw;
    private int grade;
    private String gender;

}
