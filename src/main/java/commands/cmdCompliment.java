package commands;

import core.SheetIntegration;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.io.IOException;


public class cmdCompliment implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {
        event.getTextChannel().sendMessage(args[0]+" hat "+SheetIntegration.read("c",util.RANDOMIZER.randNumS(3,SheetIntegration.columnlentgh("c",3, STATIC.BAUSTEINE)), STATIC.BAUSTEINE)+" "+SheetIntegration.read("d",util.RANDOMIZER.randNumS(3,SheetIntegration.columnlentgh("d",3,STATIC.BAUSTEINE)),STATIC.BAUSTEINE)+"!").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {
        System.out.print("Kompliment gemacht"+"\n");
    }

    @Override
    public String help() {
        return null;
    }
}
