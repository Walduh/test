package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import core.*;

import java.io.IOException;

public class CommandListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().startsWith("-") && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
            try {
                CommandHandler.handleCommand(CommandHandler.parser.parser(event.getMessage().getContentRaw(), event));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}