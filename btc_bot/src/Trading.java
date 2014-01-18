public class Trading {
	private static double currExchange = 0;
	public void initiateTrade() {
		
	}
	public static void Selling() throws NumberFormatException, Exception {
		currExchange = Double.parseDouble(Parser.getValue(HttpRequests.sendPost(GlobalSettings.currencyPair),"sell"));
		VirtualMoney.USD = VirtualMoney.BTC * currExchange;
		VirtualMoney.BTC = 0;
		VirtualMoney.lastPrice = currExchange;
	}
	public static void Buying() throws NumberFormatException, Exception {
		currExchange = Double.parseDouble(Parser.getValue(HttpRequests.sendPost(GlobalSettings.currencyPair),"buy"));
		VirtualMoney.BTC = VirtualMoney.USD * currExchange;
		VirtualMoney.USD = 0;
		VirtualMoney.lastPrice = currExchange;
	}
}
