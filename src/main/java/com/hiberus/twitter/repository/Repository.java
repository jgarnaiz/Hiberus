package com.hiberus.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiberus.twitter.repository.model.TweetDb;

public interface Repository extends JpaRepository<TweetDb, Integer> {

}
