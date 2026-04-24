package com.smartcampus.exception;

/**
 * Exception thrown when a room cannot be deleted because it still has sensors assigned.
 *
 * @author Pooja
 */
public class RoomNotEmptyException extends RuntimeException {

    public RoomNotEmptyException(String message) {
        super(message);
    }

}
