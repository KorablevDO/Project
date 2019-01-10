package library.instruments.TestNG;

import org.testng.annotations.Test;

public class AppTest {
    private App app = new App();

    @Test
    public void testSum(){
        String result = app.sum(5,5);
        System.out.println(result);
    }
}
