
public class Analize {
	private static double xi,yi,xy,xx;
	private static double aParam, bParam;
	private static double lastApproximationProgress=0;
	private static double curApproximationProgress=0;
	private static boolean isBuyed=true;
	
	//TODO Класс для работы с анализом ситуации на бирже
	public static void getProgressDirection () {
		Double[] stack = Stack.getStack();	
		xi=0;
		yi=0;
		xy=0;
		xx=0;
		aParam=0;	
		bParam=0;
/*		for (int i =0; i < stack.length; i++) {
			System.out.println(stack[i].toString() + ";+++");
		}*/
		curApproximationProgress = lineApproximation(stack);
		System.out.println("curApproximationProgress-"+curApproximationProgress);
		System.out.println("lastApproximationProgress-"+lastApproximationProgress);
		if (curApproximationProgress*lastApproximationProgress<0) {
			if(isBuyed) {
				System.out.println("Seling");
				isBuyed=false;
			} else {
				System.out.println("Buying");
				isBuyed=true;
			}

		}
	}
	
	private static double lineApproximation(Double[] stack) {
		xi=0;
		yi=0;
		xy=0;
		xx=0;
		aParam=0;	
		bParam=0;
		int arrLength = stack.length - 0;
		xi = (1 + arrLength) / 2 * arrLength;
		for (int i =0; i < arrLength; i++) {
			yi += stack[i];
			xy += stack[i] * (i+1);
			xx += (i+1)*(i+1);
		}
		aParam = (xi*yi - arrLength*xy)/(xi*xi-arrLength*xx);
		bParam = (xi*xy-xx*yi)/(xi*xi-arrLength*xx); 
		System.out.println("xi-" + xi + " yi-" + yi + " xy-" + xy +" xx-" + xx + " aParam-" + aParam  + " bParam-" + bParam);
		return aParam;
	}
}
