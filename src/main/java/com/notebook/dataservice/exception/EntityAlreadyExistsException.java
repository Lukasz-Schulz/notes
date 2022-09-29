package com.notebook.dataservice.exception;

public class EntityAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errMsg;
    private Object object;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public <T> EntityAlreadyExistsException(String errMsg, T object) {
        this.errMsg = errMsg;
        this.object = object;
    }
}