package core;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.util.ArrayList;

public class CommandParser {

    public commandContainer parser(String raw, MessageReceivedEvent event) {

        String beheaded = raw.replaceFirst(STATIC.PREFIX, "");
        String[] splitBeheaded = beheaded.split(" ");
        String invoke = splitBeheaded[0];
        ArrayList<String> split = new ArrayList<>();
        split = customSplit(beheaded);                                      //new method to get args
        String[] args = new String[split.size() - 1];
        split.subList(1, split.size()).toArray(args);
        return new commandContainer(raw, beheaded, splitBeheaded, invoke, args, event);
    }

    private ArrayList<String> customSplit(String input) {                       //takes beheaded, creates array list with args

        int i = 0;      //current pos in string
        ArrayList<String> output = new ArrayList<>();

        while (true) {

            if (input.indexOf(" ", i) == -1) {                  //last arg reached, add to list and break
                output.add(input.substring(i, input.length()));
                break;
            } else {
                if (input.substring(i, input.indexOf(" ", i)).startsWith("\"") == true && input.indexOf("\"", i + 1) != -1) {              //if " and at least one more " is found
                    output.add(input.substring(i + 1, input.indexOf("\"", i + 1)));                                                     //add arg between "
                    if (input.indexOf("\"", i + 1) == input.length() - 1) {                                                                  //if end reached, break
                        break;
                    } else {                                                                                                                               //else set i to new position
                        i = input.indexOf("\"", i + 1) + 2;
                    }
                } else {                                                                                                                              //else add statement between " ", set i to new position
                    output.add(input.substring(i, input.indexOf(" ", i)));
                    i = input.indexOf(" ", i) + 1;
                }
            }
        }

        return output;
    }

    public class commandContainer {

        public final String raw;
        public final String beheaded;
        public final String[] splitBeheaded;
        public final String invoke;
        public final String[] args;
        public final MessageReceivedEvent event;

        public commandContainer(String rw, String beheaded, String[] splitBeheaded, String invoke, String[] args, MessageReceivedEvent event) {
            this.raw = rw;
            this.beheaded = beheaded;
            this.splitBeheaded = splitBeheaded;
            this.invoke = invoke;
            this.args = args;
            this.event = event;
        }

    }

}