import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private OptionalInt age;
    protected String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return this.city != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return city;
    }

    public void setAge(OptionalInt age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.city = address;
    }

    public void happyBirthday() {
        if (age != null) age = OptionalInt.of(age.getAsInt() + 1);
        else System.out.println("Для празднования Дня Рождения необходимо знать возраст.");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (age == null ? false : age.getAsInt()) +
                ", city='" + city + '\'' +
                '}';
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.surname = this.surname;
        child.setAge(0);
        child.address = this.city;
        return child;
    }
}

