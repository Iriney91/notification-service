package notificationService.model;

import java.util.Objects;

public class PushNotification {
    private String recipientId;

    public PushNotification(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PushNotification that = (PushNotification) o;
        return Objects.equals(recipientId, that.recipientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipientId);
    }

    @Override
    public String toString() {
        return "PushNotification{" +
                "recipientId='" + recipientId + '\'' +
                '}';
    }
}
