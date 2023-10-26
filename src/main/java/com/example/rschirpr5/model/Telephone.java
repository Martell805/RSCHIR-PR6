package com.example.rschirpr5.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "telephones")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private Integer accumulatorVolume;
    private Integer seller;
    private String type;
    private Integer cost;
    private String name;
}
