import java.util.HashMap;

public class Individual extends Client {
    private String clientType;
    private String name;
    private String surname;
    private int inn;
    private int age;

    public Individual(HashMap<String,String> fieldsHashMap) throws Exception {
        this.clientType = fieldsHashMap.get("clientType");
        this.name = fieldsHashMap.get("name");
        this.surname = fieldsHashMap.get("surname");
        this.inn = Integer.parseInt(fieldsHashMap.get("inn"));
        this.age = Integer.parseInt(fieldsHashMap.get("age"));
        ExeptionIndividual(fieldsHashMap) ;
    }

   void ExeptionIndividual(HashMap<String,String> fieldsHashMap) throws Exception {
       if(fieldsHashMap.get("clientType")==null){ throw new IllegalArgumentException("Error clientType");}
       if(fieldsHashMap.get("name")==null){ throw new IllegalArgumentException("Error name");}
       if(fieldsHashMap.get("surname")==null){ throw new IllegalArgumentException("Error surname");}
       if(fieldsHashMap.get("inn")==null){ throw new IllegalArgumentException("inn");}
       if(fieldsHashMap.get("age")==null){ throw new IllegalArgumentException("Error age");}
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

    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        return "Individual{" +
                "clientType:"+clientType+
                ",name:"+name +
                ",surname:"+ surname+
                ",inn:"+ inn+
                ",age:"+age+
                '}';
    }
}
