package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.DATA;
import java.io.IOException;


public class cmdCompliment implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {
        event.getTextChannel().sendMessage(DATA.structurparser(args[0],DATA.strukturen.get(util.RANDOMIZER.randNumI(0,DATA.strukturen.size()-1)))).queue();
        //System.out.print(DATA.structurparser(args[0],DATA.strukturen.get(util.RANDOMIZER.randNumI(0,DATA.strukturen.size()-1))));
        //System.out.print(DATA.strukturen);
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
