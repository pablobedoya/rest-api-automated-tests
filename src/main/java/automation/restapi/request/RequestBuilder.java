package automation.restapi.request;

import automation.restapi.model.response.EmployeeResponse;
import automation.restapi.model.response.EmployeesResponse;
import automation.restapi.model.response.ResponseData;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.List;

public class RequestBuilder {

	public ResponseData<EmployeeResponse> createEmployee(RequestData requestData) {
		Response response = executePostRequest(requestData);
		
		ResponseData<EmployeeResponse> employeeResponse = new ResponseData<EmployeeResponse>();
		if (ContentType.JSON.matches(response.getContentType()))
			employeeResponse = response.as(new TypeRef<ResponseData<EmployeeResponse>>() {});
		
		employeeResponse.setStatusCode(response.getStatusCode());

		return employeeResponse;
	}

	public ResponseData<List<EmployeesResponse>> getEmployees(RequestData requestData) {
		Response response = executeGetRequest(requestData);

		ResponseData<List<EmployeesResponse>> employeesResponse = new ResponseData<List<EmployeesResponse>>();
		if (ContentType.JSON.matches(response.getContentType()))
			employeesResponse = response.as(new TypeRef<ResponseData<List<EmployeesResponse>>>() {});
		
		employeesResponse.setStatusCode(response.getStatusCode());

		return employeesResponse;
	}

	public ResponseData<EmployeeResponse> updateEmployee(RequestData requestData) {
		Response response = executePutRequest(requestData);

		ResponseData<EmployeeResponse> employeeResponse = new ResponseData<EmployeeResponse>();
		if (ContentType.JSON.matches(response.getContentType()))
			employeeResponse = response.as(new TypeRef<ResponseData<EmployeeResponse>>() {});
		
		employeeResponse.setStatusCode(response.getStatusCode());

		return employeeResponse;
	}

	public ResponseData<String> deleteEmployee(RequestData requestData) {
		Response response = executeDeleteRequest(requestData);

		ResponseData<String> deleteEmployeeResponse = new ResponseData<String>();
		if (ContentType.JSON.matches(response.getContentType()))
			deleteEmployeeResponse = response.as(new TypeRef<ResponseData<String>>() {});
		
		deleteEmployeeResponse.setStatusCode(response.getStatusCode());

		return deleteEmployeeResponse;
	}

	private Response executePostRequest(RequestData requestData) {
		return given()
					.baseUri(requestData.getUrl())
					.headers(requestData.getHeaders())
					.pathParams(requestData.getPathParams())
					.contentType(requestData.getContentType())
					.body(requestData.getRequestBody())
				.when()
					.post(requestData.getPath());
	}

	private Response executeGetRequest(RequestData requestData) {
		return given()
				.baseUri(requestData.getUrl())
				.headers(requestData.getHeaders())
				.pathParams(requestData.getPathParams())
				.queryParams(requestData.getQueryParams())
			.when()
				.get(requestData.getPath());
	}

	private Response executePutRequest(RequestData requestData) {
		return given()
				.baseUri(requestData.getUrl())
				.headers(requestData.getHeaders())
				.pathParams(requestData.getPathParams())
				.contentType(requestData.getContentType())
				.body(requestData.getRequestBody())
			.when()
				.put(requestData.getPath());
	}

	private Response executeDeleteRequest(RequestData requestData) {
		return given()
				.baseUri(requestData.getUrl())
				.headers(requestData.getHeaders())
				.pathParams(requestData.getPathParams())
			.when()
				.delete(requestData.getPath());
	}

}
