package com.traning.testing.Config;

import com.traning.testing.DTO.UserDTO;
import com.traning.testing.Entity.UserInfo;
import com.traning.testing.Service.ServiceImpl.UserInfoImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfigs {
    @Bean
    public ModelMapper  modelMapper(){
        return new ModelMapper();
    };

    @Bean
    public UserInfoImpl userInfoImpl(){
        return new UserInfoImpl();
    }


}
