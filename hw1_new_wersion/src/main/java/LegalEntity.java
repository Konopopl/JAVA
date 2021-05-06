import java.util.HashMap;

public class LegalEntity extends Client {
    private String clientType;
    private String name;
    private int inn;
    private boolean isSanctioned;

    public LegalEntity(HashMap<String,String> fieldsHashMap) throws Exception {
        this.clientType = fieldsHashMap.get("clientType");
        this.name = fieldsHashMap.get("name");
        this.inn = Integer.parseInt(fieldsHashMap.get("inn"));
        this.isSanctioned = Boolean.parseBoolean(fieldsHashMap.get("isSanctioned"));
        ExeptionIndividual(fieldsHashMap);
    }

    void ExeptionIndividual(HashMap<String,String> fieldsHashMap) throws Exception {
        if(fieldsHashMap.get("clientType")==null){  throw new IllegalArgumentException("Error clientType");}
        if(fieldsHashMap.get("name")==null){ throw new IllegalArgumentException("Error name");}
        if(fieldsHashMap.get("inn")==null){ throw new IllegalArgumentException("Error inn");}
        if(fieldsHashMap.get("isSanctioned")==null){ throw new IllegalArgumentException("Error isSanctioned");}
    }

    public String getClientType() {
        return clientType;
    }

    public String getName() {
        return name;
    }

    public int getInn() {
        return inn;
    }
    public boolean getIsSanctioned() {
        return isSanctioned;
    }
    @Override
    public String toString(){
        return "LegalEntity {" +
                "clientType:"+clientType+
                ",name:"+name +
                ",inn:"+ inn+
                ",isSanctioned:"+isSanctioned+
                '}';
    }
}
