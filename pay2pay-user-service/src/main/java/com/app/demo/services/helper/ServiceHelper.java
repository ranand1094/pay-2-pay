package com.app.demo.services.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceHelper {

	@Autowired
	private ModelMapper modelMapper;
	
	public <F,T>T convert(F from, T to)
	{
		to = (T) modelMapper.map(from,to.getClass());
		return to;
	}
	
	public  <F,T> List <T> convert2List(F from,T to,List<F> fromList)
	{
		System.out.println(to.getClass());
		List<T> toList = new ArrayList<T>();
		toList = (List<T>) fromList.stream().map(t -> convert(from,to)).collect(Collectors.toList());
 		return toList;
	}
}
