package srcTest;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import srcTest.HelloApplication.Greeter;
import srcTest.HelloApplication.HelloActable;
import srcTest.HelloApplication.HelloAction;
import srcTest.HelloApplication.HelloGreeter;

public class HelloActionIntegrationTest {
   HelloActable helloAction;
   Greeter helloGreeter;
   Appendable helloWriterMock;
   
   @Before
   public void setUp() {
      helloGreeter = new HelloGreeter("welcome", " says ");
      helloWriterMock = mock(Appendable.class);
      helloAction = new HelloAction(helloGreeter, helloWriterMock);
   }
   
   @Test
   public void testSayHello() throws Exception {
      when(helloWriterMock.append(any(String.class))).thenReturn(helloWriterMock);

      helloAction.sayHello("integrationTest", "universe");

      verify(helloWriterMock, times(2)).append(any(String.class));
      verify(helloWriterMock, times(1)).append(eq("integrationTest says "));
      verify(helloWriterMock, times(1)).append(eq("welcome universe"));
   }
}
