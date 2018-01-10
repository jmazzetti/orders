package orders.exception;

import org.springframework.http.HttpStatus;

public class OrderException extends Exception{
    private int errorCode;
    private String errorMessage;
    private HttpStatus httpStatus;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public OrderException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode.getId();
        this.errorMessage = errorCode.getMessage();
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public OrderException(ErrorCode errorCode, HttpStatus httpStatus) {
        super(errorCode.getMessage());
        this.errorCode = errorCode.getId();
        this.errorMessage = errorCode.getMessage();
        this.httpStatus = httpStatus;
    }
}
