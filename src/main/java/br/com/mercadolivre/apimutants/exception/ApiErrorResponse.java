package br.com.mercadolivre.apimutants.exception;

public class ApiErrorResponse {
	
    private int status;
    private String error;
    private String message;

    public ApiErrorResponse(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiErrorResponse{" +
                "status=" + status +
                ", erro=" + error +
                ", message=" + message +
                '}';
    }

}
