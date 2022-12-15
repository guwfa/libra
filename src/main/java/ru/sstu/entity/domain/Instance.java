package ru.sstu.entity.domain;

public class Instance {
    int instanceId;
    int bookId;
    int presence;
    int quantity;

    public Instance() {
    }

    public Instance(int instanceId, int bookId, int presence, int quantity) {
        this.instanceId = instanceId;
        this.bookId = bookId;
        this.presence = presence;
        this.quantity = quantity;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Instance{" +
                "instanceId=" + instanceId +
                ", bookId=" + bookId +
                ", presence=" + presence +
                ", quantity=" + quantity +
                '}';
    }

}
