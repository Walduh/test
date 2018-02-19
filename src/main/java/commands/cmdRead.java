package commands;

import core.SheetIntegration;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.io.IOException;

public class cmdRead implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {

        event.getTextChannel().sendMessage(SheetIntegration.read(args[0].toString(),args[1].toString(), STATIC.BAUSTEINE)).queue();

    }


    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
