package com.oyzl.demo.repository;

import com.oyzl.demo.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface UserDetailRepository extends JpaRepository<UserDetail, String> {

    List<UserDetail> findAllByUserName(@Param("userName") String userName);
}
