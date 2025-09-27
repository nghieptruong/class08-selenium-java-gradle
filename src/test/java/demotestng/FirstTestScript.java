package demotestng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestScript {

    @Test
    public void testLogin() {
        System.out.println("testLogin executed");
        Assert.assertEquals(1, 1, "test login failed");
    }
}
