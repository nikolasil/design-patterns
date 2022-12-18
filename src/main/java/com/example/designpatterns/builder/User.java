package com.example.designpatterns.builder;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private List<Permission> permissions;

    private User() {
    }

    private User(UUID id, String firstName, String lastName, Integer age, String email, List<Permission> permissions) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.permissions = permissions;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    @Override
    public String toString() {
        return """
                User{id='%s', \
                firstName='%s', \
                lastName='%s', \
                age=%s, \
                email='%s', \
                permissions=%s\
                }'""".formatted(id, firstName, lastName, age, email, permissions);
    }

    public enum Permission {
        PERMISSION1, PERMISSION2, PERMISSION3
    }

    public static class Director {
        private final Builder builder;

        public Director() {
            this.builder = new Builder();
        }

        public Director(Builder builder) {
            this.builder = builder;
        }

        public Builder makeAdminUser() {
            this.builder.id(UUID.randomUUID());
            this.builder.permissions(Stream.of(Permission.values()).toList());
            return this.builder;
        }

        public Builder makeBasicUser() {
            this.builder.id(UUID.randomUUID());
            this.builder.permissions(List.of(Permission.PERMISSION1));
            return this.builder;
        }

        public Builder makeIntermediateUser() {
            this.builder.id(UUID.randomUUID());
            this.builder.permissions(List.of(Permission.PERMISSION2));
            return this.builder;
        }

        public static class Builder {
            private final User tempUser;

            public Builder() {
                this.tempUser = new User();
            }

            public Builder id(UUID id) {
                this.tempUser.id = id;
                return this;
            }

            public Builder firstName(String firstName) {
                this.tempUser.firstName = firstName;
                return this;
            }

            public Builder lastName(String lastName) {
                this.tempUser.lastName = lastName;
                return this;
            }

            public Builder age(int age) {
                this.tempUser.age = age;
                return this;
            }

            public Builder email(String email) {
                this.tempUser.email = email;
                return this;
            }

            public Builder permissions(List<Permission> permissions) {
                this.tempUser.permissions = permissions;
                return this;
            }

            private void validate() {
                Objects.requireNonNull(this.tempUser.id, "id must not be null");
                Objects.requireNonNull(this.tempUser.firstName, "firstName must not be null");
                Objects.requireNonNull(this.tempUser.lastName, "lastName must not be null");
            }

            public User build() {
                validate();

                return new User(
                        this.tempUser.id,
                        this.tempUser.firstName,
                        this.tempUser.lastName,
                        this.tempUser.age,
                        this.tempUser.email,
                        this.tempUser.permissions
                );
            }
        }
    }
}
