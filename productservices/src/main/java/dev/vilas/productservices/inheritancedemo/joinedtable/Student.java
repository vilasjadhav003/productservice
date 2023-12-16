package dev.vilas.productservices.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "jt_student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {
    private double psp;
    private double attendance;
}
