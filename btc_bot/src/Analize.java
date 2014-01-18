
public class Analize {
	private static double xi,yi,xy,xx=0;
	private static double aParam, bParam=0;
	private static double lastApproximationProgress=0;
	private static double curApproximationProgress=0;
	private static boolean isBuyed=true;
	
	//TODO Класс для работы с анализом ситуации на бирже
	public static void getProgressDirection () throws NumberFormatException, Exception {
		boolean isNeedToAction;
		Double[] stack = Stack.getStack();	
		curApproximationProgress = lineApproximation(stack);
		System.out.println("curApproximationProgress-"+curApproximationProgress);
		System.out.println("lastApproximationProgress-"+lastApproximationProgress);
		if (curApproximationProgress*lastApproximationProgress<0) {
			
			if(Double.parseDouble(Parser.getValue(HttpRequests.sendPost(GlobalSettings.currencyPair),"buy"))<VirtualMoney.lastPrice&&!isBuyed) {
				Trading.Buying();
				isBuyed=true;
			}
			if(Double.parseDouble(Parser.getValue(HttpRequests.sendPost(GlobalSettings.currencyPair),"sell"))>VirtualMoney.lastPrice&&isBuyed) {
				Trading.Selling();
				isBuyed=false;
			}			
			
			/*
			if(isBuyed) {
				System.out.println("Seling");
				isBuyed=false;
				Trading.Selling();
			} else {
				System.out.println("Buying");
				isBuyed=true;
				Trading.Buying();
			}*/
			isNeedToAction = false;
		}
		lastApproximationProgress=curApproximationProgress;
	}
	
	private static double lineApproximation(Double[] stack) {
		xi=0;
		yi=0;
		xy=0;
		xx=0;
		aParam=0;	
		bParam=0;
		int arrLength = stack.length - 0;
//		xi = (1 + arrLength) / 2 * arrLength;
		for (int i = 0; i < arrLength; i++) {
			xi = xi + i+1;
			yi = yi + stack[i];
			xy = xy + stack[i] * (i+1);
			xx = xx + (i+1)*(i+1);
//			System.out.println("xxi-"+xx+"xii-"+xi);
		}
		aParam = (xi*yi - arrLength*xy)/(xi*xi-arrLength*xx);
		bParam = (xi*xy-xx*yi)/(xi*xi-arrLength*xx); 
		System.out.println("xi-" + xi + " yi-" + yi + " xy-" + xy +" xx-" + xx + " aParam-" + aParam  + " bParam-" + bParam);
		return aParam;
	}
}
