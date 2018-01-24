package com.dy.poj1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line = null;
		while ((line = reader.readLine()) != null && line.length() > 0) {
			String input1 = line.substring(0, 6).replaceAll(" ", "");
			String input2 = line.substring(7, 9).replaceAll(" ", "");
			BigDecimal val = new BigDecimal(input1);
			BigDecimal result = new BigDecimal(1);
			int b = Integer.parseInt(input2);
			for (int i = 0; i < b; i++) {
				result = result.multiply(val);
			}
			if (result.compareTo(new BigDecimal(1)) == 1)
				System.out
						.println(result.toPlainString().replaceAll("0*$", ""));
			else
				System.out.println(result.toPlainString().substring(1)
						.replaceAll("0*$", ""));
		}
	}
}
