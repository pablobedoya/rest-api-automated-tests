package automation.restapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import automation.restapi.model.request.EmployeeRequest;
import automation.restapi.model.response.EmployeeResponse;
import automation.restapi.model.response.EmployeesResponse;
import automation.restapi.model.response.ResponseData;
import automation.restapi.request.RequestBuilder;
import automation.restapi.request.RequestData;

public class EmployeeService {
	
	private static final String URL = "http://dummy.restapiexample.com";
	private static final String CONTENT_TYPE_JSON = "application/json";
	private static final String CREATE_EMPLOYEE_PATH = "/api/v1/create";
	private static final String GET_EMPLOYEES_PATH = "/api/v1/employees";
	private static final String UPDATE_EMPLOYEE_PATH = "/api/v1/update/{employeeId}";
	private static final String DELETE_EMPLOYEE_PATH = "/api/v1/delete/{employeeId}";
	
	private RequestBuilder requestBuilder = new RequestBuilder();
	private RequestData requestData;
	
	public ResponseData<EmployeeResponse> createEmployee(EmployeeRequest employeeRequest) {
		requestData = RequestData
				.builder()
				.url(URL)
				.contentType(CONTENT_TYPE_JSON)
				.requestBody(employeeRequest)
				.path(CREATE_EMPLOYEE_PATH)
				.build();
		
		return requestBuilder.createEmployee(requestData);
	}
	
	public ResponseData<List<EmployeesResponse>> getEmployees() {
		requestData = RequestData
				.builder()
				.url(URL)
				.path(GET_EMPLOYEES_PATH)
				.build();
		
		return requestBuilder.getEmployees(requestData);
	}
	
	public ResponseData<EmployeeResponse> updateEmployee(EmployeeRequest employeeRequest, int employeeId) {
		Map<String, Integer> pathParams = new HashMap<String, Integer>(); 
		pathParams.put("employeeId", employeeId); 
		
		requestData = RequestData
				.builder()
				.url(URL)
				.pathParams(pathParams)
				.contentType(CONTENT_TYPE_JSON)
				.requestBody(employeeRequest)
				.path(UPDATE_EMPLOYEE_PATH)
				.build();
		
		return requestBuilder.updateEmployee(requestData);
	}
	
	public ResponseData<String> deleteEmployee(int employeeId) {
		Map<String, Integer> pathParams = new HashMap<String, Integer>(); 
		pathParams.put("employeeId", employeeId); 
		
		requestData = RequestData
				.builder()
				.url(URL)
				.pathParams(pathParams)
				.path(DELETE_EMPLOYEE_PATH)
				.build();
		
		return requestBuilder.deleteEmployee(requestData);
	}

}
