package com.example.TAsk.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Class")
@Entity
public class Class
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long classId;
    private String className;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Projects> projects;
}
