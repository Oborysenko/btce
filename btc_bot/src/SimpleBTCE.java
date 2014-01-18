//The software described in this code has no warranty, it is provided “as is”.
//It is your responsibility to validate the behavior of the routines using the source code provided*/
//package ru.algotrade.btce;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

public class SimpleBTCE {
	
	public static void main(String[] args) throws NumberFormatException, Exception {
/*		HttpRequests request = new HttpRequests();
		JSONObject json = request.authenticatedHTTPRequest("getInfo", null);
		System.out.println(json);
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("count", "2");
		json = request.authenticatedHTTPRequest("TradeHistory", param);
		System.out.println(json);*/ 
		
		checkingTickers();
		fifo.getStack();
		System.out.println("Finish");

		Double[] stack = fifo.getStack();
		for (int i =0; i < stack.length; i++) {
			System.out.println(stack[i].toString() + ";");
		}
		Analize.getProgressDirection();
		System.out.println("Trade Finish: USD:" + VirtualMoney.USD + "BTC:" + VirtualMoney.BTC);
	}
	
	private static void checkingTickers() {
		HttpRequests request = new HttpRequests();
		fifo = new Stack();
		fifo.createNewStack();
		Double lastBuy = 0.0;
		String response;
		for (int i = 0; i<GlobalSettings.attemptNumberForTest; i++) {
			try {
				Thread.sleep(GlobalSettings.sleepTimeForNextRequest);
				response = request.sendPost(GlobalSettings.currencyPair);
				getValueFromResponse = Parser.getValue(response,"buy");
				if ((Math.round(Double.parseDouble(getValueFromResponse))-Double.parseDouble(getValueFromResponse)) == 0) {
					getValueFromResponse = getValueFromResponse + ".0";
				}

				if (!lastBuy.toString().equalsIgnoreCase(getValueFromResponse)) {
					lastBuy = Double.parseDouble(getValueFromResponse);
					fifo.addInStack(lastBuy);
					System.out.println(lastBuy);
					Analize.getProgressDirection();
				}
			} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}
	
	
	static String getValueFromResponse;
	static Stack fifo;
}

