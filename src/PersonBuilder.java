import java.util.OptionalInt;

public class PersonBuilder {
    Person person;
    String name;
    String surname;
    OptionalInt age;
    String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) throw new IllegalStateException("Необходимо ввести имя");
        if (surname == null) throw new IllegalStateException("Необходимо ввести фамилию");
        if (age == null ? false : age.getAsInt() < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        person = new Person(name, surname);
        person.setAge(age);
        person.setAddress(address);
        return person;
    }
}
