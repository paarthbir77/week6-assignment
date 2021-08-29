package com.greatlearning.designpattern3;
import java.sql.SQLException;

import com.greatlearning.designpattern3.GBPConvertor;
import com.greatlearning.designpattern3.DollarConvertor;

public class Main {
	
	public static void main( String[] args ){
		GBPConvertor gbp = new GBPConvertor();
		System.out.println(gbp.convertToINR(500));
		DollarConvertor usd = new DollarConvertor();
		System.out.println(usd.convertToINR(700));
	}
}