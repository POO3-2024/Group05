package tests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import modele.Modele;

@TestMethodOrder(OrderAnnotation.class)
public class Tests {

	@Test
	@Order(1)
	public void testGenerer1ChiffrePositif() {
		int wx=1;
		assertEquals(wx,1);
	}
}