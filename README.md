# Serialization

Serialization in Java is the concept of representing an object's state as a byte stream. The byte stream has all the information about the object.

## Authors

- [@Mehdi Lavasani](https://github.com/zendevMehdi)


## Features

- Serialize objects and save it to file.
- Deserialize objects and read them from file, convert them to Objects.


## Installation

You can get jar from release section or create new project and add src folder to the project.


## Usage/Examples

```java
package org.zendev.lib.serialize;

import java.io.Serializable;

public class App {
    private static class Person implements Serializable {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void clear() {
            id = 0;
            name = "";
        }
    }

    public static void main(String[] args) {
        var person = new Person(101, "T800");
        Serialization<Person> serialization = new Serialization<>("Person.bin", person);

        if (serialization.isSerializable()) {
            System.out.println(serialization.serialize());
        } else {
            System.out.println("Serialization not supported");
        }

        person.clear();
        person = serialization.deSerialize();

        System.out.printf("Id: %d\n", person.id);
        System.out.printf("Name: %s\n", person.name);

    }
}

```
