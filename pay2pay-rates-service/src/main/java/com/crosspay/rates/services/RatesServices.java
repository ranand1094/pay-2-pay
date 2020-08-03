package com.crosspay.rates.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RestController;

import com.crosspay.rates.aop.EnableLog;
import com.crosspay.rates.entity.InterBankRates;
import com.crosspay.rates.model.GetRatesModel;
import com.crosspay.rates.model.RatesModel;
import com.crosspay.rates.model.UpdateIBRModel;
import com.crosspay.rates.repository.RatesRepository;

@RestController
public class RatesServices {

	@Autowired
	private RatesRepository ratesRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	InterBankRates ibrEntity = new InterBankRates();

	@EnableLog
	private RatesModel convertToDto(InterBankRates ibr) {
		RatesModel restModel = modelMapper.map(ibr, RatesModel.class);
		return restModel;
	}

	@EnableLog
	private InterBankRates convertToEntity(RatesModel restModel) {
		InterBankRates interBankRates = modelMapper.map(restModel, InterBankRates.class);
		return interBankRates;
	}
	
	@EnableLog
	public Map calculateRate(RatesModel rates) {
		Map rateResult = new HashMap<String,String>();
		
		InterBankRates payinCcyRate = ratesRepo.getOne(rates.getFromCcy());
		InterBankRates payoutCcyRate = ratesRepo.getOne(rates.getToCcy());
		
		Double payinRate = payinCcyRate.getRate();
		Double payoutRate = payoutCcyRate.getRate();
		Double exchangeRate = payoutRate/payinRate;
		Double amount = rates.getAmount();
		Double convertedAmount = amount * exchangeRate;
		
		rateResult.put("returnCode", "2000");
		rateResult.put("returnMsg", "Sucessfully processed the request");
		rateResult.put("convertionAmount", convertedAmount);
		rateResult.put("conversionRate", exchangeRate);

		
		return rateResult;
	}

	@EnableLog
 	@CachePut(value = "ibr",key = "#ibr.ccyCode")//, key = "#ibr.toString()")
	public Map addRate(UpdateIBRModel ibr) {
		// TODO Auto-generated method stub
		Map addIBRResult = new HashMap<String,String>();
		ibrEntity = modelMapper.map(ibr, InterBankRates.class);
		ratesRepo.save(ibrEntity);
		addIBRResult.put("rateList",Arrays.asList(ibr));
		addIBRResult.put("returnCode", "2000");
		addIBRResult.put("returnMsg", "Rates updated sucessfully");
		return addIBRResult;
	}

	@EnableLog
	@Cacheable(value = "ibrAll")	
	public GetRatesModel  getRates() {
		
		GetRatesModel ratesModel = new GetRatesModel();
		List<InterBankRates> ibrRates = ratesRepo.findAll();
		
		
 		Iterator ite =  ibrRates.iterator();
		ListIterator listit = ibrRates.listIterator();
		
 				
		if(ibrRates.isEmpty())
		{
			ratesModel.setReturnCode("4000");
			ratesModel.setReturnMsg("No Records available");
		}
		else
		{
			ratesModel.setRateList(ibrRates);
			ratesModel.setReturnCode("2000");
			ratesModel.setReturnMsg("Successfully processed request");
		}
		return ratesModel;
	}
	
	@EnableLog
	@Cacheable(value = "ibr")	
	public Map  getRates(String ccy) {
		
		List ibtList = new ArrayList<InterBankRates>();
		System.out.println(ccy);
		Map ratesModel = new HashMap<>();
		Optional<InterBankRates> ibrRates = ratesRepo.findById(ccy);
		InterBankRates payinCcyRate = ratesRepo.getOne(ccy);
		System.out.println(payinCcyRate.getRate());
		System.out.println(ibrRates.isPresent());
		if(ibrRates.isPresent())
		{
			InterBankRates ib = ibrRates.get();
			ibtList.add(ib);
			ratesModel.put("rateList",ibtList);
			//ratesModel.setReturnCode("2000");
			//ratesModel.setReturnMsg("Success");
			ratesModel.put("returnCode", "2000");
			ratesModel.put("returnMsg", "Request processed successfully");
		}
		return ratesModel;
	}

}
