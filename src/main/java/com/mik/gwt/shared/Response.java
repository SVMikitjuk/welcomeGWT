package com.mik.gwt.shared;

import java.io.Serializable;

/**
 * Created by mikitjuk on 19.01.16.
 */
public class Response implements Serializable {

    private static final long serialVersionUID = 5072296376487585068L;

    private ResponseStat stat;
    private String message;

    public Response() {
    }

    public Response(ResponseStat stat, String mess) {
        this.stat = stat;
        this.message = mess;
    }

    public ResponseStat getStat() {
        return stat;
    }

    public void setStat(ResponseStat stat) {
        this.stat = stat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        if (message != null ? !message.equals(response.message) : response.message != null) return false;
        if (stat != response.stat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stat != null ? stat.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
