package com.traning.testing.Service.ServiceInterface;

import com.traning.testing.DTO.UserDTO;
import com.traning.testing.Entity.UserInfo;

import java.util.List;

public interface UserInfoInterface {
    public List<UserInfo> getAllUsers();
    public UserInfo getUserById(Long Id);
    public UserDTO createUser(UserDTO userDTO);
    public UserDTO updateUser(UserDTO userDTO,Long Id);
//    public UserDTO deleteUser(Long Id);
    public UserDTO deleteUser(UserDTO userDTO);
    public UserDTO deleteUserById(Long Id);
    public String deleteAllUsers();




}
