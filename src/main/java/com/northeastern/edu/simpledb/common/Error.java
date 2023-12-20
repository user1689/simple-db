package com.northeastern.edu.simpledb.common;

public class Error {

    // common
    public static final Exception FileNotExistsException = new RuntimeException("File does not exists!");
    public static final Exception FileCannotRWException = new RuntimeException("File cannot read or write!");

    // tm
    public static final Exception BadXIDFileException = new RuntimeException("Bad XID file!");

}