package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) {
		Gson gson = new Gson();
		BufferedReader br = null;
		int i = 1;
		try {
			br = new BufferedReader(new FileReader("dataEkspedisi.json"));
			Result result = gson.fromJson(br, Result.class);
			if (result != null) {
				for (Ekspedisi t : result.getEkspedisi()) {
					System.out.println("Product " + i);
					i++;
					System.out.println("Quantity    : " + t.getQuantity());
					System.out.println("Weight      : " + t.getWeight());
					System.out.println("Destination : " + t.getCity().getDestination());
					System.out.println("Service     : " + t.getServicePackage().getService());
					System.out.println("Value       : " + t.getServicePackage().getValue());
					System.out.println("Total       : " + t.getPriceItem());
					System.out.println();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
