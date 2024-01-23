package com.movie.mynetmovie.utils.io;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    
    private Status status;
	private LocalDateTime issueAt;
	private T payload;

    public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<T>(Status.Success, LocalDateTime.now(), data);
	}

	public static <T> ApiResponse<T> validationError(T data) {
		return new ApiResponse<T>(Status.ValidationError, LocalDateTime.now(), data);
	}

	public static <T> ApiResponse<T> businessError(T data) {
		return new ApiResponse<T>(Status.BusinessError, LocalDateTime.now(), data);
	}

	public static <T> ApiResponse<T> platformError(T data) {
		return new ApiResponse<T>(Status.PlatformError, LocalDateTime.now(), data);
	}

	public static <T> ApiResponse<T> securityError(T data) {
		return new ApiResponse<T>(Status.SecurityError, LocalDateTime.now(), data);
	}

	public static <T> ApiResponse<T> idNotFound(T data) {
		return new ApiResponse<T>(Status.NOT_FOUND, LocalDateTime.now(), data);
	}

    public enum Status {
		Success,
		ValidationError,
		BusinessError,
		SecurityError,
		PlatformError,
		NOT_FOUND,
		INTERNAL_SERVER_ERROR
	}

    public static <T> ApiResponse<T> error(Status status, T data) {
        return new ApiResponse<T>(status, LocalDateTime.now(), data);
    }

    public static <T> ApiResponse<T> fromHttpStatus(HttpStatus httpStatus, T data) {
        Status status;
        if (httpStatus.is2xxSuccessful()) {
            status = Status.Success;
        } else if (httpStatus.is4xxClientError()) {
            status = Status.ValidationError;
        } else if (httpStatus.is5xxServerError()) {
            status = Status.PlatformError;
        } else {
            status = Status.BusinessError;
        }
        return new ApiResponse<T>(status, LocalDateTime.now(), data);
    }
}

