package com.valtech.training.day2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.valtech.training.day2.Arithmetic;
import com.valtech.training.day2.ArithmeticImpl;
import com.valtech.training.day2.DivideByZeroException;


@DisplayName("Aithmetic Test is being done here")
class ArithmeticTest {
	
	private Arithmetic arithmetic;// = new ArithmeticImpl();
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("before all......");
	}
	
	@AfterAll
	static void afterall() {
		System.out.println("after all........");
	}
	
	@BeforeEach
	void anything() {
		System.out.println("init......");
		arithmetic = new ArithmeticImpl();
		
	}

	//this is to clean up the test case
	@AfterEach
	void anything1() {
		System.out.println("Destroy......");
	}
	
	@Test @DisplayName("The addition check if +ve number,-ve number are added correctly")
	void testAdd() {
		assertEquals(5,arithmetic.add(2, 3));
		assertEquals(5,arithmetic.add(3, 2));
		assertEquals(5,arithmetic.add(5, 0));
		assertEquals(5,arithmetic.add(5, -0));
		assertEquals(-5,arithmetic.add(-2, -3));
		assertEquals(-5,arithmetic.add(-8, 3));
	}

	@Test
	void testSub() {
		
	}

	@Test
	void testMul() {
	}
	
	//buid an array/listy of args...pass it to stream then run simple
	static Stream<Arguments> addArgsGenerator() {
		return Stream.of(
				Arguments.of(1,2,3),
				Arguments.of(-1,-1,-3),
				Arguments.of(1,-2,-1),
				Arguments.of(-1,2,1)
				);
				
	}
	
	
	@ParameterizedTest(name = "Add with CSV {0} + {1} = {2}")
	@CsvFileSource(files = {"add.csv"})
	void testWithCSVFile(int a,int b,int c) {
		assertEquals(c, arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name = "Add with CSV {0} + {1} = {2}")
	@CsvSource(value = {"2,3,5","-2,3,1","5,-2,3","-1,-1,-2"})
	void testWithCSVParams(int a,int b,int c) {
		assertEquals(c, arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name = "Add with {0}")
	//allows you to pass args
	@ValueSource(strings = {"2,3,5","-2,3,1","5,-2,3","-1,-1,-2"}) //2 + 3 = 5 etc
	//allows to pass diff types of args ....ex array ..for evry elememnt in array the test hapens
	void testAddWithParams(String value) {
		String [] parts = value.split(",");
		List<Integer> values = Arrays.asList(parts).stream().map(it -> Integer.parseInt(it)).collect(Collectors.toList());
		assertEquals(values.get(2), arithmetic.add(values.get(0), values.get(1)));
	}
	
	
	
	
	
	@Test 
	void testDivByZero() {
		assertThrows(DivideByZeroException.class,() -> arithmetic.div(5,0));
		
	}

	@Test
	void testDiv() throws DivideByZeroException   {
	//	assertEquals(1.666, 5.0/3); this does not work because the float that shld be in output is 1.666
	//but here output u r getting is 1.6666666666666666 => not possible
//		assertEquals(1.666, 5.0/3,0.001);
		assertEquals(1, 5/3);
		assertEquals(2,arithmetic.div(4, 2));
		assertEquals(2,arithmetic.div(-6,-3));
		
		try {
			assertEquals(2, arithmetic.div(4, 0));
			fail("Should have throws ArithmeticException");
		}catch (DivideByZeroException ex) {
		}

	}

}



//sometimes we need to test for large number of values or dynamically get
