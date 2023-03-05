package com.example.DadataInnCriteria;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.LinkedList;

@JsonRootName("suggestions")
public class Response {

    LinkedList<com.example.DadataInnCriteria.Criteria> Criteria;

    @JsonProperty("suggestions")
    @JsonGetter
    public LinkedList<Criteria> getCriteria() {
        return Criteria;
    }
    public void setCriteria(LinkedList<Criteria> cards){
        this.Criteria =cards;
    }

    public void PrintSuggests(){
        for (Criteria card: this.Criteria) {
            System.out.println(card+"\n");
        }
    }
}
