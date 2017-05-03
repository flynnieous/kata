import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class SequenceForZero {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("1", fibonacci(2));
	}

	private String fibonacci(long n) {
		StringBuilder sb = new StringBuilder();
		Stream.iterate(new BigInteger[]{ BigInteger.ONE, BigInteger.ONE },
	               p->new BigInteger[]{ p[1], p[0].add(p[1]) })
	      .forEach(p->sb.append(p[0]));
		return sb.toString();
		}
}
