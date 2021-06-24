package com.hiberus.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.twitter.repository.model.TweetDb;
import com.hiberus.twitter.service.TweetService;

import twitter4j.Twitter;

@RestController
@RequestMapping("tweets")
public class Controller {

	@Autowired
	private TweetService service;

//	@Autowired
//	private Twitter twitter;

	@RequestMapping("/allTweets")
	@ResponseBody
	public ResponseEntity<List<TweetDb>> getPeople() {
		return new ResponseEntity<List<TweetDb>>(service.getAllTweets(), HttpStatus.OK);
	}

	@RequestMapping("/insertTweet")
	@ResponseBody
	public ResponseEntity<TweetDb> insertTweet() {
		return new ResponseEntity<TweetDb>(service.insertTweet(TweetDb.builder().id(1).usuario("jose").texto("tweet")
				.validacion(true).localizacion("Almazan").build()), HttpStatus.OK);
	}

	@RequestMapping("/readTweets")
	@ResponseBody
	public void readTweets() throws Exception {
		service.showHomeTimeline();
	}
}
