package com.hiberus.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.twitter.mapper.TweetMapper;
import com.hiberus.twitter.model.Tweet;
import com.hiberus.twitter.service.TwitterApiService;
import com.hiberus.twitter.service.impl.TweetDbServiceImpl;

@RestController
@RequestMapping("tweets")
public class Controller {

	@Autowired
	private TweetDbServiceImpl dbService;

	@Autowired
	private TwitterApiService apiService;

	@RequestMapping("/persist")
	@ResponseBody
	public void readTweets() throws Exception {
		dbService.insertTweetsList(TweetMapper.INSTANCE.tweetListToTweetDbList(apiService.getTweets()));
	}

	@RequestMapping("/readAll")
	@ResponseBody
	public ResponseEntity<List<Tweet>> getPeople() {
		return new ResponseEntity<List<Tweet>>(TweetMapper.INSTANCE.tweetDbListToTweetList(dbService.getAllTweets()),
				HttpStatus.OK);
	}

	@RequestMapping("/read/{id}")
	@ResponseBody
	public ResponseEntity<Tweet> readById(@PathVariable Integer id) throws Exception {
		return new ResponseEntity<Tweet>(TweetMapper.INSTANCE.tweetDbToTweet(dbService.getTweetById(id)),
				HttpStatus.OK);
	}

	@RequestMapping("/validate/{id}")
	@ResponseBody
	public void validateById(@PathVariable Integer id) throws Exception {
		dbService.validateTweetById(dbService.getTweetById(id));
	}

	@RequestMapping("/valid/{user}")
	@ResponseBody
	public ResponseEntity<List<Tweet>> validByUser(@PathVariable String user) throws Exception {
		return new ResponseEntity<List<Tweet>>(
				TweetMapper.INSTANCE.tweetDbListToTweetList(dbService.getValidByUser(user)), HttpStatus.OK);
	}

	@RequestMapping("/hashtags/{locationCode}")
	@ResponseBody
	public ResponseEntity<List<String>> hashtagsByLocationCode(@PathVariable Integer locationCode) throws Exception {
		return new ResponseEntity<List<String>>(apiService.getTrendsByLocation(locationCode), HttpStatus.OK);
	}
}
