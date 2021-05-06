import java.io.IOException;
import java.util.HashMap;

public enum ClientEnum {
    Individual{
        @Override
        public Client createClient(String fileLocation) throws Exception {

            return new Individual(Handler.handler(fileLocation));
        }
    },
    LegalEntity{
        @Override
        public Client createClient(String fileLocation) throws Exception {
            return new LegalEntity(Handler.handler(fileLocation));
        }
    },
    Holding{
        @Override
        public Client createClient(String fileLocation) throws Exception {
            return new Holding(Handler.handler(fileLocation));
        }
    };

    public abstract Client createClient(String fileLocation) throws Exception;
}
