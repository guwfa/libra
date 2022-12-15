package ru.sstu.entity.domain;

public class Client {

    int idClient ;
    String firstName;
    String secondName;
    String patronymic;
    String login;
    String accessLevel;
    String password;
    ROLE role;

    public Client(){
        this.role = ROLE.UNKNOWN;
    }

    public Client(int idClient, String firstName, String secondName, String patronymic, String login, String accessLevel, String password) {
        this.idClient = idClient;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.login = login;
        this.accessLevel = accessLevel;
        this.password = password;
        setRole(accessLevel);
    }
    public ROLE getRole() {
        return role;
    }

    public void setRole(String accessLevel) {
        this.role = (accessLevel.equals("2")) ? (ROLE.USER) : (ROLE.ADMIN);
    }

    public int getIdClient() {
        return idClient;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLogin() {
        return login;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", login='" + login + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public enum ROLE{
        USER,ADMIN, UNKNOWN
    }
}
