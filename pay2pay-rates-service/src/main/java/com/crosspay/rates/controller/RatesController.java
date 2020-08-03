package com.crosspay.rates.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crosspay.rates.aop.EnableLog;
import com.crosspay.rates.entity.InterBankRates;
import com.crosspay.rates.model.GetRatesModel;
import com.crosspay.rates.model.RatesModel;
import com.crosspay.rates.model.UpdateIBRModel;
import com.crosspay.rates.services.RatesServices;

@RestController
@RequestMapping("/pay2pay/rate")
@EnableLog
@Validated
 public class RatesController {
	
	@Autowired
	private RatesServices rateServices;
	
	@PostMapping("/convert")
	public Map calculateExRate(@Valid @RequestBody RatesModel rates) {
		return rateServices.calculateRate(rates);
	}
	
	@PostMapping("/update")
	public Map add(@RequestBody UpdateIBRModel ibr) {
		return rateServices.addRate(ibr);
	}
	
	@GetMapping("/all")
	//@Cacheable(value = "ibr", key = "#ibr.ccyCode")
	public GetRatesModel getRates() {
		return rateServices.getRates();
	}
	

	@GetMapping("/all/{ccyCode}")
	public Map getRate(@PathVariable String ccyCode) {
		System.out.println(ccyCode);
		return rateServices.getRates(ccyCode);
	}
	
	@GetMapping("/clearCache")
	@CacheEvict(cacheNames = {"ibr","ibrall","ibradd"}  ,allEntries = true)
	public String cachedel() throws Exception {
		
		throw new Exception("ClearCacheException");
		
	}
	
}
