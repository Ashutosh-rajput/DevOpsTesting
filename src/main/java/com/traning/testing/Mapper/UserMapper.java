package com.traning.testing.Mapper;

import com.traning.testing.DTO.UserDTO;
import com.traning.testing.Entity.UserInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserInfo userDTouserInfo(UserDTO userDTO){
        UserInfo userInfo=modelMapper.map(userDTO,UserInfo.class);
        return userInfo;
    }

    public UserDTO userInfoTouserDTO(UserInfo userInfo){
        UserDTO userDTO=modelMapper.map(userInfo,UserDTO.class);
        return userDTO;
    }


}
