package com.hiberus.twitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiberus.twitter.repository.model.TweetDb;

public interface Repository extends JpaRepository<TweetDb, Integer> {

	public List<TweetDb> findTweetDbListByValidacionAndUsuario(Boolean validacion, String usuario);
}
