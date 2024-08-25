package com.traning.testing.Repository;

import com.traning.testing.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<UserInfo,Long> {


}
