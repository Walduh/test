package util;

import core.SheetIntegration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DATA {


    public static List<List<String>> strukturen = new ArrayList<>();
    public static List<List<String>> bausteine = new ArrayList<>();

    public static void init() {

        List <String> bausteinInit1 = new ArrayList<>();
        List <String> bausteinInit2 = new ArrayList<>();

       bausteinInit1.add("schöne");
       bausteinInit2.add("Augen");

       DATA.bausteine.add(bausteinInit1);
       DATA.bausteine.add(bausteinInit2);

       List <String> struktureInit = new ArrayList<>();

       struktureInit.add("user");
       struktureInit.add("hat");
       struktureInit.add("*0");
       struktureInit.add("*1");
       struktureInit.add(".");

        DATA.strukturen.add(struktureInit);
        DATA.strukturen.add(struktureInit);

    }


    public static void updatelist(List<List<String>> targetlist, String x, String y, String z) throws IOException {
        int i = 0;
        while (i < 99) {

            if (SheetIntegration.read(x, y, z) != "") {
                targetlist.add(getcollumn(x, y, z));
                x = ALPHABET.incrementletter(x, 1);
            } else
                break;
        }
        System.out.print(targetlist);
    }

    public static List<String> getcollumn(String x, String y, String z) throws IOException {
        int i = 0;
        List<String> collumncontent = new ArrayList<>();

        while (i < 999) {
            String cellvalue = SheetIntegration.read(x, y, z);
            if (cellvalue == "")
                break;
            else {
                collumncontent.add(cellvalue);
                y = String.valueOf(1 + Integer.parseInt(y));
                i += 1;
            }
        }
        return collumncontent;
    }
    
    public static String structurparser(String user, List<String> targetstruct) {
        String message = "";
        String parsedpart;
        for (int i = 0; i < targetstruct.size()-1; i++) {
            String s = targetstruct.get(i);
            String firstchar = s.substring(0,1);

            if (firstchar.equals("*")) {
                parsedpart = bausteine.get(Integer.parseInt(s.substring(1, 2))).get(RANDOMIZER.randNumI(0, bausteine.get(Integer.parseInt(s.substring(1, 2))).size() - 1));
                System.out.print("firstchar* erkannt! \n");
            }

            else if (s.equals("user"))
                parsedpart = user;

            else if (s.equals("user's"))
                parsedpart = user + "'s";

            else
                parsedpart = s;

            message = message + " " + parsedpart;

        }
        message = message + targetstruct.get(targetstruct.size()-1);
        return message;
    }
}