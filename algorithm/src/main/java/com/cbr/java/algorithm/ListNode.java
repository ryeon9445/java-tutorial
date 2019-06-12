package com.cbr.java.algorithm;

public class ListNode {

    public Object cargo;
    public ListNode next;

    public ListNode() {
        this.cargo = null;
        this.next = null;
    }

    public ListNode(Object cargo) {
        this.cargo = cargo;
        this.next = null;
    }

    public ListNode(Object cargo, ListNode next) {
        this.cargo = cargo;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode(" + cargo.toString() + ")";
    }
}