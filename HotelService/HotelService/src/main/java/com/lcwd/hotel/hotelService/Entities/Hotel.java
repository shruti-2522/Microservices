package com.lcwd.hotel.hotelService.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="hotels")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {
    @Id
    private String id;
    private String name;
    private String location;
    private String about;

}