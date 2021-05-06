import java.io.IOException;
import java.util.HashMap;

public class GeneratorClient {
    public static Client GeneratorClientEnum(String fileLocation) throws Exception {
        HashMap<String,String> data=  Handler.handler(fileLocation);
        String clientType = data.get("clientType");
        Client client = ClientEnum.valueOf(clientType).createClient(fileLocation);
        return client;
    }
    public static Client GeneratorClientIf(String fileLocation) throws Exception {
        HashMap<String,String> data=  Handler.handler(fileLocation);
        String clientType = data.get("clientType");
        Client client = IfAndIf.IfHandler(data);
       return client;
    }
}
