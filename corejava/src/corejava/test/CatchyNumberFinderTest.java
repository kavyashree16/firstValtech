package corejava.test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;



class CatchyNumberFinderTest {

	@Test
	void testFindCatchyNumber() {
		List<String> numbers = Arrays.asList("77777","6666456","11112222");
		String expectedCatchyNumber = "77777";
		assertEquals(expectedCatchyNumber, corejava.CatchyNumberFinder.findCatchyNumber(numbers));
	}

	@Test
	void testCalculateCatchiness() {
		String number = "77777";
		int expectedCatchiness = 5;
		assertEquals(expectedCatchiness, corejava.CatchyNumberFinder.calculateCatchiness(number));

	}
}


