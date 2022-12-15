package ru.sstu.entity.domain;

import java.util.Date;

public class SubcriptionCard {

    int SubcriptionCardId;
    int clientId;
    Date dateOfReceiving;
    Date planned_date;
    Date returnDate;
    int instanceId;

    public SubcriptionCard() {
    }

    public int getSubcriptionCardId() {
        return SubcriptionCardId;
    }

    public SubcriptionCard(int SubcriptionCardId, int clientId, int instanceId, Date dateOfReceiving, Date planned_date, Date returnDate) {
        this.SubcriptionCardId = SubcriptionCardId;
        this.clientId = clientId;
        this.instanceId = instanceId;
        this.dateOfReceiving = dateOfReceiving;
        this.planned_date = planned_date;
        this.returnDate = returnDate;
    }

    public int getClientId() {
        return clientId;
    }

    public Date getDateOfReceiving() {
        return dateOfReceiving;
    }

    public Date getPlanned_date() {
        return planned_date;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public int getInstanceId() {
        return instanceId;
    }

    @Override
    public String toString() {
        return "SubcriptionCard{" +
                "clientId=" + clientId +
                ", dateOfReceiving=" + dateOfReceiving +
                ", planned_date=" + planned_date +
                ", returnDate=" + returnDate +
                ", instanceId=" + instanceId +
                '}';
    }
}
