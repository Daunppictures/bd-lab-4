package com.solodovnikov;

import com.solodovnikov.view.View;

import java.sql.SQLException;
import java.text.ParseException;

public class Application {
    public static void main(String[] args) throws SQLException, ParseException {
        new View().show();
    }
}
