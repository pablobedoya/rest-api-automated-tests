package automation.restapi.request;

import java.util.HashMap;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestData {

	private String url;

	@Builder.Default
	private Map<String, ?> headers = new HashMap<String, String>();

	@Builder.Default
	private Map<String, ?> pathParams = new HashMap<String, String>();

	@Builder.Default
	private Map<String, ?> queryParams = new HashMap<String, String>();

	@Builder.Default
	private String contentType = "*/*";

	private Object requestBody;

	private String path;

}
