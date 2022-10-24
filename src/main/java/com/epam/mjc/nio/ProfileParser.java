package com.epam.mjc.nio;

import java.util.Arrays;
import java.util.List;

public class ProfileParser {

    private ProfileParser() {}

    public static Profile parse(List<String> lines) {
        Profile profile = new Profile();

        for (String line : lines) {
            String[] keyValue = line.split("\\s*:\\s*");

            switch (keyValue[0]) {
                case "Name":
                    profile.setName(keyValue[1]);
                    break;
                case "Age":
                    profile.setAge(Integer.parseInt(keyValue[1]));
                    break;
                case "Email":
                    profile.setEmail(keyValue[1]);
                    break;
                case "Phone":
                    profile.setPhone(Long.parseLong(keyValue[1]));
                    break;
                default:
                    throw new ProfileParseException("Unexpected parameter name: " + keyValue[0]);
            }
        }

        return profile;
    }

    public static Profile parse(String rawData) {
        List<String> lines = Arrays.asList(rawData.strip().split("\\r*\\n+"));
        return parse(lines);
    }

}
