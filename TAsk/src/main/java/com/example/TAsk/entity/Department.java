package com.example.TAsk.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Department")
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long deptId;
    public String deptName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id",referencedColumnName = "dept_id")
    private List<Profile> profileList;
}
