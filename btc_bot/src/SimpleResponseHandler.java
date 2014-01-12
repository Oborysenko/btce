import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

public class SimpleResponseHandler implements ResponseHandler<String> {
	
	@Override
	public String handleResponse(HttpResponse response) throws IOException {
		int status = response.getStatusLine().getStatusCode();
		if (status >= 200 && status < 300) {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String responce = EntityUtils.toString(entity);
				return responce;
			}
	
			return null;
		} else {
			throw new ClientProtocolException("Unexpected response status: " + status);
		}
	}

}