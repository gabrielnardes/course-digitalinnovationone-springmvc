package gabrielnardes.springwebmvc.model;

public class Jedi {
    private String name;
    private String lastname;

    public Jedi(String name, String lastName) {
        this.name = name;
        this.lastname = lastName;
    }

    public Jedi() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
