package TestPlan;

import ProjectServer.ClassZ;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassZTest {
    private ClassZ test = new ClassZ();

    @Test
    public void test(){
        Assert.assertEquals(10, test.sum(5,5));
    }

    @Test
    public void test1(){
        Assert.assertEquals(11, test.sum(5,5));
    }
}
/**
 * https://habrahabr.ru/post/121234/
 * https://devcolibri.com/тестирование-с-помощью-testng-в-java/
 **/