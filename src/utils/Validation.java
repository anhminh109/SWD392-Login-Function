package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validation {

    private static final String PHONE_VALID = "^\\d{10,11}$";

    private static final String EMAIL_VALID =
            "^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    // check empty
    public static boolean isEmpty(String input) {

        return input == null || input.trim().isEmpty();
    }

    // check phone
    public static boolean isValidPhone(String phone) {

        return phone.matches(PHONE_VALID);
    }

    // check email
    public static boolean isValidEmail(String email) {

        return email.matches(EMAIL_VALID);
    }

    // check date
    public static boolean isValidDate(String date) {

        try {

            SimpleDateFormat format =
                    new SimpleDateFormat("dd/MM/yyyy");

            format.setLenient(false);

            format.parse(date);

            return true;

        } catch (ParseException e) {

            return false;
        }
    }
}