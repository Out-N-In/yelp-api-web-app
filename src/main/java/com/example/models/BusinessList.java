package com.example.models;

import java.util.List;

public class BusinessList {
    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    private List<Business> businesses;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Business b : businesses) {
            sb.append(b);
        }
        return sb.toString();
    }
}
