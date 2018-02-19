package core;

import commands.*;
import listeners.CommandListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import util.ALPHABET;
import util.SECRETS;
import util.STATIC;


import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.security.GeneralSecurityException;


public class Main {

        public static JDABuilder builder;

        public static void main(String[] Args) throws GeneralSecurityException, IOException {

            //System.out.print(ALPHABET.incrementletter("p",1));


            try {
                SheetIntegration.setup();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print(SheetIntegration.read("A","1", STATIC.STRUKTUREN));
            System.out.print(SheetIntegration.read("A","1", STATIC.BAUSTEINE));

            builder = new JDABuilder(AccountType.BOT);

            builder.setToken(SECRETS.token);
            builder.setAutoReconnect(true);

            builder.setStatus(OnlineStatus.ONLINE);

            addListeners();
            addCommands();

            //System.out.print(""+SheetIntegration.columnlentgh("A",1)+"\n");




            try {
                JDA jda = builder.buildBlocking();
            } catch (LoginException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        public static void addCommands() {

            CommandHandler.commands.put("ping", new cmdPing());
            CommandHandler.commands.put("read", new cmdRead());
            CommandHandler.commands.put("compliment", new cmdCompliment());

        }

        public static void addListeners() {

            builder.addEventListener(new CommandListener());
        }


}
