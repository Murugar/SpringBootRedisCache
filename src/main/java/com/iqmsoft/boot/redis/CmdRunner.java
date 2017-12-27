package com.iqmsoft.boot.redis;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CmdRunner implements CommandLineRunner {

	private static Log logger = LogFactory.getLog(CmdRunner.class);
	
	@Autowired
	@Qualifier("cacheRedisTemplate")
	private RedisTemplate<String, String> template;
	
	@Autowired
	private CalcSvc service;
	
	private void caching() {
		logger.info("----> 1 " + this.service.calculate("value1"));
		logger.info("----> 2 " + this.service.calculate("value1"));
		logger.info("----> 3 " + this.service.calculate("value1"));
		logger.info("----> 4 " + this.service.calculate("value1"));
	}

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("Running a command client");
		caching();
		
	}

}