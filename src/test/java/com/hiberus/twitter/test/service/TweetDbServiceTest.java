package com.hiberus.twitter.test.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hiberus.twitter.repository.Repository;
import com.hiberus.twitter.repository.model.TweetDb;
import com.hiberus.twitter.service.TweetDbService;
import com.hiberus.twitter.service.impl.TweetDbServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TweetDbServiceTest {

	@Mock
	private Repository repository;

	private TweetDbService service;

	/**
	 * Before.
	 */
	@Before
	public void setUp() throws Exception {
		service = new TweetDbServiceImpl(repository);
	}

	/**
	 * test find all service.
	 */
	@Test
	public void test() throws Exception {

		// prepare
		List<TweetDb> list = new ArrayList<>();
		list.add(new TweetDb(1, "user", "text", "localizacion", true));
		Mockito.doReturn(list).when(repository).findAll();

		// act
		List<TweetDb> resp = service.getAllTweets();

		// assert
		Mockito.verify(repository, Mockito.times(1)).findAll();
		assertTrue(resp.size() == list.size());
		assertEquals("user", resp.get(0).getUsuario());

	}

}
