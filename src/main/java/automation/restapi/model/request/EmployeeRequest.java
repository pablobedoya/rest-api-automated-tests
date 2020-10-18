package automation.restapi.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeRequest {

	private String name;
	
	private Double salary;
	
	private Integer age;
	
}
