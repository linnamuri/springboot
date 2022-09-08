package com.devmountain.noteAPP.dtos;

import com.devmountain.noteAPP.entites.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String userName;
    private  String password;
    private Set<NoteDto> noteDtoSet =new HashSet<>();
    public UserDto ( User user)
    {
      if(user.getId()!=null)
      {
          this.id = user.getId();
      }

        if(user.getUserName()!=null)
        {
            this.userName = user.getUserName();
        }

        if(user.getPassword()!=null)
        {
            this.password = user.getPassword();
        }
    }
}
