package com.iqmsoft.boot.redis;

import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CalcSvc {

	@Cacheable("slow")
	public String calculate(String arg) {
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException ex) {
		}
		return UUID.randomUUID().toString();
	}

}