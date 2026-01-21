package com.lcwd.user.service.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name="user_mgmt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
        @Id
        private String userId;
        @Column(name="username" ,length = 20)
        private String name;
        private String email;
        private String about;
//        @Transient
//        private List<Rating> ratings=new ArrayList<>();
}
