package com.interoffice.shared.api;

public class ApiResponse<T> {
  private boolean success;
  private T data;
  private Error error;

  public ApiResponse(boolean success, T data, Error error) {
    this.success = success;
    this.data = data;
    this.error = error;
  }

  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(true, data, null);
  }

  public static <T> ApiResponse<T> fail(String code, String message) {
    return new ApiResponse<>(false, null, new Error(code, message));
  }

  public boolean isSuccess() {
    return success;
  }

  public T getData() {
    return data;
  }

  public Error getError() {
    return error;
  }

  static class Error {
    private String code;
    private String message;

    public Error(String code, String message) {
      this.code = code;
      this.message = message;
    }

    public String getCode() {
      return code;
    }

    public String getMessage() {
      return message;
    }
  }

}
