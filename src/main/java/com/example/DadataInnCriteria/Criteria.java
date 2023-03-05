package com.example.DadataInnCriteria;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Criteria implements Comparable {

    private String name;
    private Data data;


    @JsonProperty("value")
    public String getName() {
        return this.name;
    }

    @JsonProperty("value")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("data")
    public Data getInn() {
        return data;
    }


    @JsonProperty("data")
    public void setInn(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return name + '\n' +
                data.getAddress() + '\n' +
                data.getInn() + '\n' +
                df.format(new Date(data.registrationDate));
    }
    @Override
    public int compareTo(Object o) {
        return Long.compare(this.data.registrationDate, ((Criteria) o).data.registrationDate);
    }


    public static class Data {
        public String inn;
        public long registrationDate;
        public String address;

        @JsonProperty("address")
        public String getAddress() {
            return address;
        }

        @JsonProperty("address")
        public void setAddress(Address address) {
            this.address = address.address;
        }

        @JsonProperty("inn")
        public String getInn() {
            return inn;
        }

        @JsonProperty("inn")
        public void setInn(String inn) {
            this.inn = inn;
        }


        @JsonProperty("state")
        public long getRegistrationDate() {
            return this.registrationDate;
        }

        @JsonProperty("state")
        public void setRegistrationDate(State state) {
            this.registrationDate = state.registrationDate;
        }
    }

    public static class State {
        public long registrationDate;

        @JsonProperty("registration_date")
        public long getRegistrationDate() {
            return registrationDate;
        }

        @JsonProperty("registration_date")
        public void setRegistrationDate(long value) {
            this.registrationDate=value;
        }
    }

    public static class Address {

        public String address;

        @JsonProperty("unrestricted_value")
        public String getAddress() {
            return address;
        }

        @JsonProperty("unrestricted_value")
        public void setAddress(String value) {
            this.address =value;
        }

    }
}
