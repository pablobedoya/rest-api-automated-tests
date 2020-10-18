package automation.restapi.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData<T> {
	
	private T data;

	private String status;
	
	private String message;
	
	private int statusCode;
	
}
