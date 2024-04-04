package org.zendev.lib.serialize;

import java.io.*;

public class Serialization<T> {
    private String path;
    T object;

    public Serialization(String path, T object) {
        this.path = path;
        this.object = object;
    }

    public boolean isSerializable() {
        return object instanceof Serializable;
    }

    public boolean serialize() {
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public T deSerialize() {
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
