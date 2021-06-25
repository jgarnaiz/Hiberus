package com.hiberus.twitter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.twitter.repository.Repository;
import com.hiberus.twitter.repository.model.TweetDb;
import com.hiberus.twitter.service.TweetDbService;

@Service
public class TweetDbServiceImpl implements TweetDbService {

	private Repository repository;

	@Autowired
	public TweetDbServiceImpl(Repository repository) {
		this.repository = repository;
	}

	/**
	 * recover all tweets.
	 */
	@Override
	public List<TweetDb> getAllTweets() {
		return repository.findAll();
	}

	/**
	 * insert a tweet.
	 */
	@Override
	public void insertTweet(TweetDb tweet) {
		repository.save(tweet);
	}

	/**
	 * insert tweet list.
	 */
	@Override
	public void insertTweetsList(List<TweetDb> tweets) {
		repository.saveAll(tweets);
	}

	/**
	 * get tweet by id.
	 */
	@Override
	public TweetDb getTweetById(int id) {
		return repository.findById(id).orElse(new TweetDb());
	}

	/**
	 * validate tweet.
	 */
	@Override
	public TweetDb validateTweetById(TweetDb tweetDb) {
		tweetDb.setValidacion(true);
		return repository.save(tweetDb);
	}

	/**
	 * get validated tweets for a user.
	 */
	@Override
	public List<TweetDb> getValidByUser(String user) {

		return repository.findTweetDbListByValidacionAndUsuario(true, user);
	}

}
