package ru.job4j.stream;

public class Employee {
    private String profession;
    private String name;
    private String surname;
    private byte age;
    private byte experience;
    private boolean married;
    private boolean children;

    @Override
    public String toString() {
        return "Employee{"
                + "profession='" + profession + '\''
                + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", experience=" + experience
                + ", married=" + married
                + ", children=" + children
                + '}';
    }

    static class Builder {
        private String profession;
        private String name;
        private String surname;
        private byte age;
        private byte experience;
        private boolean married;
        private boolean children;

        Builder buildProfession(String profession) {
            this.profession = profession;
            return this;
        }

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildExperience(byte experience) {
            this.experience = experience;
            return this;
        }

        Builder buildMarried(boolean married) {
            this.married = married;
            return this;
        }

        Builder buildChildren(boolean children) {
            this.children = children;
            return this;
        }

        Employee build() {
            Employee employee = new Employee();
            employee.profession = profession;
            employee.name = name;
            employee.surname = surname;
            employee.age = age;
            employee.experience = experience;
            employee.married = married;
            employee.children = children;
            return employee;
        }
    }

    public static void main(String[] args) {
        Employee employee = new Builder().buildProfession("Manager")
                .buildName("Ivan")
                .buildSurname("Sidorov")
                .buildAge((byte) 28)
                .buildExperience((byte) 5)
                .buildMarried(true)
                .buildChildren(false)
                .build();
        System.out.println(employee);
    }
}
