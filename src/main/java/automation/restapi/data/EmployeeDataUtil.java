package automation.restapi.data;

import com.github.javafaker.Faker;

import automation.restapi.model.request.EmployeeRequest;

public final class EmployeeDataUtil {

	private static Faker faker = new Faker();

	private EmployeeDataUtil() {
	}

	public static EmployeeRequest generateValidEmployee() {
		return EmployeeRequest.builder()
				.name(EmployeeDataUtil.generateValidName())
				.salary(EmployeeDataUtil.generateValidSalary())
				.age(EmployeeDataUtil.generateValidAge())
				.build();
	}

	public static String generateValidName() {
		return faker.name().fullName();
	}

	public static double generateValidSalary() {
		return faker.number().randomDouble(5, 0, Integer.MAX_VALUE);
	}

	public static int generateValidAge() {
		return faker.number().numberBetween(18, 75);
	}

}
