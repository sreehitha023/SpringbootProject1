package com.example.TAsk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profile_db")
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long profile_id;
    public String profile_name;

    @OneToOne(mappedBy = "profile")
    private Student student;

}
