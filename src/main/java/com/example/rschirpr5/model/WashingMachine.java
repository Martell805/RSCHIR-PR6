package com.example.rschirpr5.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "washing_machines")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WashingMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private Integer volume;
    private Integer seller;
    private String type;
    private Integer cost;
    private String name;
}
