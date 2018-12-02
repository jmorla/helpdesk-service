package com.oym.helpdesk.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jorge L. Morla
 * @version 1.0
 * @since 1.0
 *
 * The ResponseWrapper class is the Standard Response
 * */
public class ResponseWrapper<T, E extends ErrorDTO> {

    /**
     * data: The data to wrapped as list
     * */
    private List<T> data = new ArrayList<>(0);

    /**
     * error: The error wrapped as list
     * */
    private List<E> error = new ArrayList<>(0);


    private ResponseWrapper() {}

    @SuppressWarnings("unchecked")
    private ResponseWrapper(T t) {
        if(!(t instanceof List))
            this.data = Collections.singletonList(t);
        else
            this.data = (List<T>)t;
    }


    @SuppressWarnings("unchecked")
    private ResponseWrapper(E e) {
        if(!(e instanceof List))
            this.error = Collections.singletonList(e);
        else
            this.error = (List<E>)e;
    }


    public static <T, E extends ErrorDTO> ResponseWrapper<T, E> of() {

        return new ResponseWrapper<T, E>();
    }

    public static <T, E extends ErrorDTO> ResponseWrapper<T, E> of(T t) {

        return new ResponseWrapper<T, E>(t);
    }

    public static<T, E extends ErrorDTO> ResponseWrapper<T, E> ofError(E e) {

        return new ResponseWrapper<T, E>(e);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<E> getError() {
        return error;
    }

    public void setError(List<E> error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "data=" + data +
                ", error=" + error +
                '}';
    }
}
