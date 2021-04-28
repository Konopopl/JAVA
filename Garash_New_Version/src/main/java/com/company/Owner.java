package main.java.com.company;

public class Owner {
    public final int id ;
    public final String name;
    public final String lastName;
    public final int age;

    public Owner() {
        id = 0;
        name = null;
        lastName = null;
        age = 0;
    }
    public Owner(int id, String name,String lastName , int age ) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "owner{" +
                "id=" + id +
                ",name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
