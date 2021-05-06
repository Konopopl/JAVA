import java.util.HashMap;

public class Holding extends Client  {
    private String clientType;
    private String name;
    private String surname;
    private int inn;
    private String gender;

    public Holding(HashMap<String,String> fieldsHashMap) throws Exception {
        this.clientType = fieldsHashMap.get("clientType");
        this.name = fieldsHashMap.get("name");
        this.surname = fieldsHashMap.get("surname");
        this.inn = Integer.parseInt(fieldsHashMap.get("inn"));
        this.gender = fieldsHashMap.get("gender");
        ExeptionHolding(fieldsHashMap);
    }

    void ExeptionHolding(HashMap<String,String> fieldsHashMap) throws Exception {
        if(fieldsHashMap.get("clientType")==null){ throw new IllegalArgumentException("Error clientType");}
        if(fieldsHashMap.get("name")==null){ throw new IllegalArgumentException("Error name");}
        if(fieldsHashMap.get("surname")==null){ throw new IllegalArgumentException("Error surname");}
        if(fieldsHashMap.get("inn")==null){ throw new IllegalArgumentException("Error inn");}
        if(fieldsHashMap.get("gender")==null){ throw new IllegalArgumentException("Error gender");}
    }

    public String getClientType() {
        return clientType;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getInn() {
        return inn;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString(){
        return "Holding{"+
                "clientType:"+clientType+
                ",name:"+name +
                ",surname:"+ surname+
                ",inn:"+ inn+
                ",gender:"+gender+
                '}';
    }
}
