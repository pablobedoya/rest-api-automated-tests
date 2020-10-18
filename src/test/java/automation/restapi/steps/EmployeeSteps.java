package automation.restapi.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.http.HttpStatus;

import automation.restapi.data.EmployeeDataUtil;
import automation.restapi.model.request.EmployeeRequest;
import automation.restapi.model.response.EmployeeResponse;
import automation.restapi.model.response.EmployeesResponse;
import automation.restapi.model.response.ResponseData;
import automation.restapi.service.EmployeeService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSteps {

	private EmployeeService employeeService = new EmployeeService();

	private EmployeeRequest employeeRequest;
	private ResponseData<EmployeeResponse> employeeResponse;
	private ResponseData<List<EmployeesResponse>> employeesResponse;
	private ResponseData<String> deleteEmployeeResponse;

	private static final String CREATE_EMPLOYEE_MESSAGE_SUCCESS = "Successfully! Record has been added.";
	private static final String GET_EMPLOYEES_MESSAGE_SUCCESS = "Successfully! All records has been fetched.";
	private static final String UPDATE_EMPLOYEE_SUCCESS_MESSAGE = "Successfully! Record has been updated.";
	private static final String DELETE_EMPLOYEE_SUCCESS_MESSAGE = "Successfully! Record has been deleted";
	private static final String REQUEST_STATUS = "success";
	
	@When("I execute a request to create an employee")
	public void i_execute_a_request_to_create_an_employee() {
		employeeRequest = EmployeeDataUtil.generateValidEmployee();
		employeeResponse = employeeService.createEmployee(employeeRequest);
	}

	@Then("should return that the employee has been successfully created")
	public void should_return_that_the_employee_has_been_successfully_created() {
		assertEquals(HttpStatus.SC_OK, employeeResponse.getStatusCode());
		assertThat(employeeResponse.getStatus(), equalTo(REQUEST_STATUS));
		assertThat(employeeResponse.getMessage(), equalTo(CREATE_EMPLOYEE_MESSAGE_SUCCESS));
	}

	@And("should return the created employee data")
	public void should_return_the_created_employee_data() {
		assertThat(employeeResponse.getData().getName(), equalTo(employeeRequest.getName()));
		assertThat(employeeResponse.getData().getSalary(), equalTo(employeeRequest.getSalary()));
		assertThat(employeeResponse.getData().getAge(), equalTo(employeeRequest.getAge()));
	}

	@When("I execute a request to search all employees")
	public void i_execute_a_request_to_search_all_employees() {
		employeesResponse = employeeService.getEmployees();
	}

	@Then("should return the list of all employees successfully")
	public void should_return_the_list_of_all_employees_successfully() {
		assertEquals(HttpStatus.SC_OK, employeesResponse.getStatusCode());
		assertThat(employeesResponse.getStatus(), equalTo(REQUEST_STATUS));
		assertThat(employeesResponse.getMessage(), equalTo(GET_EMPLOYEES_MESSAGE_SUCCESS));
	}

	@Given("I successfully created an employee")
	public void i_successfully_created_an_employee() {
		employeeRequest = EmployeeDataUtil.generateValidEmployee();
		employeeResponse = employeeService.createEmployee(employeeRequest);
		assertEquals(HttpStatus.SC_OK, employeeResponse.getStatusCode());
	}

	@When("I execute a request to update this employee")
	public void i_execute_a_request_to_update_this_employee() {
		employeeRequest = EmployeeDataUtil.generateValidEmployee();
		employeeResponse = employeeService.updateEmployee(employeeRequest, employeeResponse.getData().getId());
	}

	@Then("should return that the employee has been successfully updated")
	public void should_return_that_the_employee_has_been_successfully_updated() {
		assertEquals(HttpStatus.SC_OK, employeeResponse.getStatusCode());
		assertThat(employeeResponse.getStatus(), equalTo(REQUEST_STATUS));
		assertThat(employeeResponse.getMessage(), equalTo(UPDATE_EMPLOYEE_SUCCESS_MESSAGE));
	}

	@And("should return the updated employee data")
	public void should_return_the_updated_employee_data() {
		assertThat(employeeResponse.getData().getName(), equalTo(employeeRequest.getName()));
		assertThat(employeeResponse.getData().getSalary(), equalTo(employeeRequest.getSalary()));
		assertThat(employeeResponse.getData().getAge(), equalTo(employeeRequest.getAge()));
	}

	@When("I execute a request to remove this employee")
	public void i_execute_a_request_to_remove_this_employee() {
		deleteEmployeeResponse = employeeService.deleteEmployee(employeeResponse.getData().getId());
	}

	@Then("should return that the employee has been successfully deleted")
	public void should_return_that_the_employee_has_been_successfully_deleted() {
		assertEquals(HttpStatus.SC_OK, deleteEmployeeResponse.getStatusCode());
		assertThat(deleteEmployeeResponse.getStatus(), equalTo(REQUEST_STATUS));
		assertThat(deleteEmployeeResponse.getMessage(), equalTo(DELETE_EMPLOYEE_SUCCESS_MESSAGE));
	}
	
}
