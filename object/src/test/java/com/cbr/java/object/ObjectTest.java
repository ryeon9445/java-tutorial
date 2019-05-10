package com.cbr.java.object;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ObjectTest {

    @Test
    public void testObjectEquals() {
        CustomObject object01 = new CustomObject();
        CustomObject object02 = new CustomObject();

        System.out.println("object01: " + object01);
        System.out.println("object02: " + object02);
        Assert.assertNotEquals(object01, object02);
    }

    @Test
    public void testObjectClone() {
        CustomObject customObject = new CustomObject();
        customObject.setValue("aaaa");
        customObject.setValues("bbbb");
        System.out.println(customObject.toString());

        CustomObject cloneObject = (CustomObject) customObject.clone();
        System.out.println(cloneObject.toString());

        Assert.assertEquals(customObject.toString(), cloneObject.toString());

        System.out.println(customObject);
        System.out.println(cloneObject);
        Assert.assertNotEquals(customObject, cloneObject);
    }

    class CustomObject implements Cloneable {

        private String value;
        private List<String> values = new ArrayList<>();

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<String> getValues() {
            return values;
        }

        public void setValues(String value) {
            values.add(value);
        }

        @Override
        public String toString() {
            return "CustomObject{" +
                    "value='" + value + '\'' +
                    ", values=" + values +
                    '}';
        }

        @Override
        public Object clone() {
            try {
                return (CustomObject) super.clone();
            } catch (CloneNotSupportedException ignore) {
            }
            return null;
        }
    }
}