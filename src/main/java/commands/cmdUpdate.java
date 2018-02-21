package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.DATA;
import util.STATIC;
import java.io.IOException;

public class cmdUpdate implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {
        event.getTextChannel().sendMessage("Updating...").queue();
        DATA.updatelist(DATA.strukturen,"a","1", STATIC.STRUKTUREN);
        DATA.updatelist(DATA.bausteine, "c","3",STATIC.BAUSTEINE);
        event.getTextChannel().sendMessage("Strukturen und Bausteine wurden aus dem Google-sheet ausgelesen.").queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {System.out.print("Update ausgeführt \n");

    }

    @Override
    public String help() {
        return null;
    }
}
