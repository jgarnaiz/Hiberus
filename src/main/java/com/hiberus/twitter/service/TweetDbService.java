package com.hiberus.twitter.service;

import java.util.List;

import com.hiberus.twitter.repository.model.TweetDb;

public interface TweetDbService {

	public List<TweetDb> getAllTweets();

	public void insertTweet(TweetDb tweet);

	public void insertTweetsList(List<TweetDb> tweets);

	public TweetDb getTweetById(int id);

	public TweetDb validateTweetById(TweetDb tweetDb);

	public List<TweetDb> getValidByUser(String user);

}
