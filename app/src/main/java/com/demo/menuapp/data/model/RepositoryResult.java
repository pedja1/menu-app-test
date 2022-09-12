package com.demo.menuapp.data.model;

public class RepositoryResult<T> {
    private T data;
    private String error;

    public RepositoryResult(T data) {
        this.data = data;
    }

    public RepositoryResult(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
