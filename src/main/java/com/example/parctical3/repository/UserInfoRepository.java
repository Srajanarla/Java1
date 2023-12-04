package com.example.parctical3.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.parctical3.entity.UserInfo;

public interface UserInfoRepository extends MongoRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);

}

