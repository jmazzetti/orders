package orders.exception;

public enum ErrorCode {

    INTERNAL_SERVER_ERROR(0, "Internal server error.");


    private final int id;
    private final String message;

    ErrorCode(int id, String msg) {
        this.id = id;
        this.message = msg;
    }

    public int getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }
}
