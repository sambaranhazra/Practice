package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        final BufferedReader in = new BufferedReader(
                new FileReader("C:\\Users\\samba\\IdeaProjects\\Practice\\test.txt"));
        String s;
        String s2 = "";
        while ((s = in.readLine()) != null)
            s2 += s + System.getProperty("line.separator");
        in.close();

        final String regex = "(?ms)^\\[[^]\r\n]+](?:(?!^\\[[^]\r\n]+]).)*";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        String sectionBlock = null;
        final Matcher regexMatcher = pattern.matcher(s2);
        int count = 0;
        if (regexMatcher.find()) {
            count = regexMatcher.groupCount();
            //for (int i = 0; i < count; i++) {
                System.out.println(regexMatcher.group());
            //}
        }

    }
}
