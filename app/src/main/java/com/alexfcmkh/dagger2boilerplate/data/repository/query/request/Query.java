package com.alexfcmkh.dagger2boilerplate.data.repository.query.request;

public class Query {

    private final int id;

    public Query(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
