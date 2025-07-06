package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    private String id;
    private String title;
    private String name;
    private String fullName;
    private String address;
    private LocalDate dob;

    public CustomerEntity(String id, String title, String name, String address, LocalDate dob) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.fullName = title+" "+name;
        this.address = address;
        this.dob = dob;
    }

}
