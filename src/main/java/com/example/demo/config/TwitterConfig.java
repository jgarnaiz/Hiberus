package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterConfig {

	@Bean
	public static Twitter getTwitterInstance() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("laoIjL7mlGOIvJiXml55vE0Bv")
				.setOAuthConsumerSecret("7NBG2WPrcPcesHDp4NeifLpveoWIYVFhH3HncOY6TPcYvqxevc")
				.setOAuthAccessToken(
						"AAAAAAAAAAAAAAAAAAAAAB3nQwEAAAAAHiVp32X3TKbRirLEKjMcVo9rGhs%3DBZkM12CYL7vH1w5456aBdsEAV9TTKLpKv07vK4z57Y4EsmBHsV")
				.setOAuthAccessTokenSecret("ymmds1T71YFEmfKYXpva6Trazbp6OFOV9X31COqikh44L");

		TwitterFactory tf = new TwitterFactory(cb.build());
		return tf.getInstance();
	}
}
