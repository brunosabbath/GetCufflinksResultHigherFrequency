package com.sbbi;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;

public class Test {

	public static void main(String[] args) {
		
		String s = "ENSBTAT00000065518.1:0-152";
		
		String query[] = s.split("\\.");
		System.out.println("porra");
		
		String n = "1.74407e08";
		
		//final Formatter out = f.format("%.3", "1.13744e+08");
		
		//System.out.println(String.format("%.3E",223.45654543434));
		
		double d = Double.parseDouble("1.45e+5");
		NumberFormat formatter = new DecimalFormat("###.#####");
		
		String f = formatter.format(d);
		Double p = Double.parseDouble(f);
		System.out.println(p);// output --> 0.00007
		
	}
	
}
