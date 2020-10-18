package automation.restapi.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeesResponse {
	
	private Integer id;
	
	@JsonProperty("employee_name")
	private String employeeName;
	
	@JsonProperty("employee_salary")
	private Double employeeSalary;
	
	@JsonProperty("employee_age")
	private Integer employeeAge;
	
	@JsonProperty("profile_image")
	private String employeeImage;

}
