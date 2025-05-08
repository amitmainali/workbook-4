package com.pluralsight;

public class NameFormatter {
    private NameFormatter() {

    }

    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        String result = lastName + ", ";

        if (!prefix.isEmpty()) {
            result += prefix + " ";
        }

        result += firstName;

        if (!middleName.isEmpty()) {
            result += " " + middleName;
        }

        if (!suffix.isEmpty()) {
            result += ", " + suffix;
        }


        return result;
    }

    public static String format(String fullName) {
        String suffix = "";
        String namePart = fullName;

        if (fullName.contains(", ")) {
            String[] split = fullName.split(",");
            namePart = split[0].trim();
            suffix = split[1].trim();
        }

        String[] parts = namePart.split(" ");
        String prefix = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";

        if (parts.length == 4) {
            prefix = parts[0];
            firstName = parts[1];
            middleName = parts[2];
            lastName = parts[3];
        }
        else if (parts.length == 3) {
            firstName = parts[0];
            middleName = parts[1];
            lastName = parts[2];
        }
        else if (parts.length == 2) {
            firstName = parts[0];
            lastName = parts[1];
        }

        return format(prefix, firstName, middleName, lastName, suffix);
    }
}
