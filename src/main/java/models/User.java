package models;

public class User {
    String email; // ne pishem private chtobi dostup bil default. dostup vozmojen tolko vnutri package
    private String password;
    //right mouse cklick_generate+getters
    //right mouse cklick_generate+setters

    String name;
    String lastNAme;
    String phone;

    public String getPhone() {
        return phone;
    }

    public User withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastNAme() {
        return lastNAme;
    }

    //setters budut izmeniatsia i ne budut bolshe void --> public void setEmail(String email) {
// i obiazani vozvrashat + poetomu dobavliaem return samogo sebia
    //vmesto setEmail-->withEmail --> eto ne na chto ne vliayaet
    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    //getters ne budut izmeniatsia
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    //right click+generate+to string+2fields

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastNAme='" + lastNAme + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}




