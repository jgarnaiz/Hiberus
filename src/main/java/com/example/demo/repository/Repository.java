package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repository.model.TweetDb;

public interface Repository extends JpaRepository<TweetDb, Integer> {

}
