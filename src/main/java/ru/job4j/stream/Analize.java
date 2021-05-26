package ru.job4j.stream;

import java.util.List;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        info.added = (int) current.stream().dropWhile(previous::contains).count();
        info.deleted = (int) previous.stream().filter(o -> !current.contains(o)).count();
        info.changed = (int) previous.stream().
                filter(current::contains).
                filter(o -> !o.getName().equals(current.get(current.indexOf(o)).getName())).
                count();
        return info;
    }

    public static class User {
        final private int id;
        final private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof User)) {
                return false;
            }
            User user = (User) o;
            return getId() == user.getId();
        }

        @Override
        public int hashCode() {
            return getId();
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }

    public static void main(String[] args) {
        List<User> previous = List.of(
                new User(1, "Ivan"),
                new User(2, "Nikolai"),
                new User(3, "Sergei")
        );
        List<User> current = List.of(
                new User(4, "Maxim"),
                new User(5, "Ivan")
        );
        Analize analize = new Analize();
        Info rsl = analize.diff(previous, current);
        System.out.println(rsl.added + " " +  rsl.changed
                + " " + rsl.deleted);
    }
}
