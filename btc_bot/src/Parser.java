
public class Parser {
	//TODO Unfinished method getValue(String response,String valueName)
	public static String getValue(String response,String valueName) {
		int posA = response.indexOf(valueName) + valueName.length()+2;
		int posB = response.indexOf(",",posA);
		return response.substring(posA, posB);
	}
}
