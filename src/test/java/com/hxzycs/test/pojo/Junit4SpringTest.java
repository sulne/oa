package com.hxzycs.test.pojo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //
@ContextConfiguration(locations = { "classpath:config/spring-context.xml" })
public abstract class Junit4SpringTest {
	@Test
	public abstract void test();

	@Before
	public abstract void before();

	@After
	public abstract void after();
}
