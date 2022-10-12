package com.example.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "kisi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "{id}")
@ToString
public class Human {

    @Id
    @SequenceGenerator(name = "seq_kisi", allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, name = "name")
    private String name;

    @Column(length = 100, name = "surname")
    private String surname;


    @OneToMany
    @JoinColumn(name = "kisi_adres_id")
    private List<Address> adresleri;
}
