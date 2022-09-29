package com.notebook.dataservice.exception;

public class EntityNotFoundException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        private String errMsg;

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        public EntityNotFoundException(String errMsg) {
            this.errMsg = errMsg;
        }
}
