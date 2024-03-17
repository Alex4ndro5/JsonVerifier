import org.alex4ndo5.Main;
import org.junit.Test;

import org.junit.Assert;

public class Tests {
    @Test
    public void testReadJson_ValidFile() {
        String jsonPath = "./src/main/resources/asterisk.json";
        Assert.assertNotNull(Main.readJsonToObject(jsonPath));
    }
    @Test()
    public void testReadJson_NullValueAsPath() {
        Assert.assertNull(Main.readJsonToObject(null));
    }
}
