package redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	@Autowired
	StringRedisTemplate redisTemplate;

	@Test
	public void test1() throws Exception {
		LOGGER.info("Sending message...");
		redisTemplate.convertAndSend("chat", "Hello from Redis!");
	}
}
