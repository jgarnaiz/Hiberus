package com.hiberus.twitter.service;

import java.util.List;

import com.hiberus.twitter.model.Tweet;

public interface TwitterApiService {

	public List<Tweet> getTweets() throws Exception;

	public List<String> getTrendsByLocation(int code);

}
