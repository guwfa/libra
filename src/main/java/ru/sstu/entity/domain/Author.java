package ru.sstu.entity.domain;

public class Author {

    int idAuthor;
    String firstName;
    String secondName;
    String patronymic;

    public Author() {
    }

    public Author(int idAuthor, String firstName, String secondName, String patronymic) {
        this.idAuthor = idAuthor;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
    }

    public int getIdAuthor() {
        return idAuthor;
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

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}


