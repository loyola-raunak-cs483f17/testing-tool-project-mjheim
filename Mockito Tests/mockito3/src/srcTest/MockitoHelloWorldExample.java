package srcTest;
 
import static srcTest.Foo.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class MockitoHelloWorldExample {

    private Foo foo;

    @Before
    public void setupMock() {      
        foo = mock(Foo.class);
        when(foo.greet()).thenReturn(HELLO_WORLD);
    }
    
    @Test
    public void fooGreets() {
        System.out.println("Foo greets: " + foo.greet());
        assertEquals(HELLO_WORLD, foo.greet());
    }

    @Test
    public void barGreets() {
        Bar bar = new Bar();
        assertEquals(HELLO_WORLD, bar.greet(foo));
    }
}

