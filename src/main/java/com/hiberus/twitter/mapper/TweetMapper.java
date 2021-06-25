package com.hiberus.twitter.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.hiberus.twitter.model.Tweet;
import com.hiberus.twitter.repository.model.TweetDb;

@Mapper
public interface TweetMapper {

	TweetMapper INSTANCE = Mappers.getMapper(TweetMapper.class);

	TweetDb tweetToTweetDb(Tweet tweet);

	List<TweetDb> tweetListToTweetDbList(List<Tweet> tweet);

	Tweet tweetDbToTweet(TweetDb tweet);

	List<Tweet> tweetDbListToTweetList(List<TweetDb> tweet);
}
