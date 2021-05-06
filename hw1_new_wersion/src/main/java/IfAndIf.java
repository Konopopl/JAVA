import java.util.HashMap;

class IfAndIf {

    public static Client IfHandler(HashMap<String,String> fieldsHashMap) throws Exception {

        if (fieldsHashMap.get("clientType").equals("LegalEntity")) {
            LegalEntity o = new LegalEntity(fieldsHashMap);
            return o;
        }
        if (fieldsHashMap.get("clientType").equals("Individual")) {
            Individual o = new Individual(fieldsHashMap);
            return o;
        }
        if (fieldsHashMap.get("clientType").equals("Holding")) {
            Holding o = new Holding(fieldsHashMap);
            return o;
        }
        else {
           throw new Exception("Error type");

         }
    }
}