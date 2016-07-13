import org.junit.*;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

import java.util.*;

public class PinTests {
	
	// Tests toString method
	@Test
	public void testAliveString(){
		Cell c = new Cell(true);
		assertTrue(c.toString().contains("X"));
	}
	
	@Test
	public void testSetAliveString(){
		Cell c = new Cell();
		c.setAlive(true);
		assertEquals(c.toString(), "X");
	}
	
	@Test
	public void testDeadString(){
		Cell c = new Cell(false);
		assertTrue(c.toString().contains("."));
	}
	
	@Test
	public void testSetDeadString(){
		Cell c = new Cell();
		c.setAlive(false);
		assertEquals(c.toString(), ".");
	}
	
	// Tests convertToInt Method
	// Using reflection (which I haven't used before!)
	
	// Min neighbors edge
	@Test
	public void testZeroInt(){
		MainPanel m = new MainPanel(15);
		Method convertToInt = MainPanel.class.getDeclaredMethod("convertToInt", int.class);
		convertToInt.setAccessible(true);
		assertEquals((int) convertToInt.invoke(m, 0), 0);
	}
	
	// Max neighbors edge
	@Test
	public void testEightInt(){
		MainPanel m = new MainPanel(15);
		Method convertToInt = MainPanel.class.getDeclaredMethod("convertToInt", int.class);
		convertToInt.setAccessible(true);
		assertEquals((int) convertToInt.invoke(m, 8), 8);
	}
	
	// Max neighbors +1 edge
	@Test
	public void testNineInt()){
		MainPanel mp = new MainPanel(15);
		Method convertToInt = MainPanel.class.getDeclaredMethod("convertToInt", int.class);
		convertToInt.setAccessible(true);
		assertEquals((int) convertToInt.invoke(mp, 9), 8);
	}
	
	// Test runContinuous method
	
	@Test
	public void testRunContR(){
		MainPanel m = new MainPanel(15);
		int origR = m._r;
		Method runContinuous = MainPanel.class.getDeclaredMethod("runContinuous",);
		runContinuous.setAccessible(true);
		mp.stop();
		assertEquals(m._r, origR);
	}
	
	// test evaluated values sleep to ensure continuous running
	
	@Test
	public void testRunCont(){
		MainPanel m = new MainPanel(15);
		Method runContinuous = MainPanel.class.getDeclaredMethod("runContinuous",);
		runContinuous.setAccessible(true);
		try {Thread.sleep(5);} 
		catch (InterruptedException iex) { fail();}
		mp.stop();
	}
	
	@Test
	public void testRunCont(){
		MainPanel m = new MainPanel(15);
		Method runContinuous = MainPanel.class.getDeclaredMethod("runContinuous",);
		runContinuous.setAccessible(true);
		try {Thread.sleep(0);} 
		catch (InterruptedException iex) { fail();}
		mp.stop();
	}
	
}
