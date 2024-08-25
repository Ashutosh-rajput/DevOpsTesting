package com.traning.testing.Service.ServiceImpl;

import com.traning.testing.DTO.UserDTO;
import com.traning.testing.Entity.UserInfo;
import com.traning.testing.Mapper.UserMapper;
import com.traning.testing.Repository.UserInfoRepo;
import com.traning.testing.Service.ServiceInterface.UserInfoInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserInfoImpl implements UserInfoInterface {

    @Autowired
    private UserInfoRepo userInfoRepo;

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<UserInfo> getAllUsers() {
        List<UserInfo> users=userInfoRepo.findAll();
        return users;
    }

    @Override
    public UserInfo getUserById(Long Id) {
//        Optional<UserInfo> userInfo=userInfoRepo.findById(Id);

        return userInfoRepo.findById(Id).orElse(null);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserInfo userInfo=userMapper.userDTouserInfo(userDTO);
        userInfoRepo.save(userInfo);
        UserDTO userDTO1=userMapper.userInfoTouserDTO(userInfo);

        return userDTO1;

    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long Id) {
//        UserInfo userInfo=userMapper.userDTouserInfo(userDTO);
        Optional<UserInfo> userInfo1=userInfoRepo.findById(Id);
        if(userInfo1.isPresent()){
            UserInfo updateduserInfo=userMapper.userDTouserInfo(userDTO);
            updateduserInfo.setId(userDTO.getId());
            updateduserInfo.setF_name(userDTO.getF_name());
            updateduserInfo.setL_name(userDTO.getL_name());
            updateduserInfo.setUsername(userDTO.getL_name());
            updateduserInfo.setPassword(userDTO.getPassword());
            userInfoRepo.save(updateduserInfo);
        }
        return userDTO;
    }

    @Override
    public UserDTO deleteUser(UserDTO userDTO) {
           userInfoRepo.deleteById(userDTO.getId());
        return userDTO;
    }

    @Override
    public UserDTO deleteUserById(Long Id) {
        userInfoRepo.deleteById(Id);
        return null;
    }

    @Override
    public String deleteAllUsers() {
        userInfoRepo.deleteAll();
        return "All user deleted SuccesFully.";
    }
}
