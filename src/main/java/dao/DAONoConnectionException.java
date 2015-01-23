package dao;

public class DAONoConnectionException extends Exception{
    public DAONoConnectionException(String message) {
        super(message);
    }
}
