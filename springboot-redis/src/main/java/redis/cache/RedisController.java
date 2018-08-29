package redis.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController {
	/**
	 * @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中 unless
	 *            表示条件表达式成立的话不放入缓存
	 * @param username
	 * @return
	 */
	@RequestMapping("/getUser/{name}")
	@Cacheable(value = "user", key = "#username", unless = "#result eq null")
	@ResponseBody
	public User getUser(@PathVariable("name") String username) {
		// User user=userRepository.findByUserName("aa");
		User user = new User();
		user.setName(username);
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		return user;
	}

//	/**
//	    * @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
//	     * @param person
//	     * @return
//	     */
//	    @CachePut(value = "user", key = "#root.targetClass + #result.username", unless = "#person eq null")
//	    public Person savePerson(Person person) {
//	        return personRepo.savePerson(person);
//	    }
//	 
//	   /**
//	    * @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
//	     * @param username
//	     * @return
//	     */
//	    @CacheEvict(value = "user", key = "#root.targetClass + #username", condition = "#result eq true")
//	    public boolean removePersonByName(String username) {
//	        return personRepo.removePersonByName(username) > 0;
//	    }
//	 
//	    public boolean isExistPersonName(Person person) {
//	        return personRepo.existPersonName(person) > 0;
//	    }
//	}
}
