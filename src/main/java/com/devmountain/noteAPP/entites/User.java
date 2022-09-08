package com.devmountain.noteAPP.entites;

import com.devmountain.noteAPP.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String userName;
    @Column
    private String  password;
    @OneToMany(mappedBy="user",fetch=FetchType.LAZY, cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Note> noteSet = new HashSet<>();
    public User(UserDto userDto){
        if(userDto.getUserName()!= null){
            this.userName = userDto.getUserName();
        }
        if(userDto.getPassword()!= null){
            this.password = userDto.getPassword();
        }

    }
}
