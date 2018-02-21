package core;

import commands.*;
import listeners.CommandListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import util.DATA;
import util.SECRETS;
import util.STATIC;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.security.GeneralSecurityException;



public class Main {

        public static JDABuilder builder;

        public static void main(String[] Args) throws GeneralSecurityException, IOException {

            DATA.init(); //lädt standard daten in strukturen und Bausteine

            /*RuensTestEcke---------------------------------

            sheetinit(); //startet verbindung zu googlesheet (wird auch von cmdUpdate aufgerufen!!!)

            //DATA.updatelist(DATA.strukturen,"a","1",STATIC.STRUKTUREN);
            //DATA.updatelist(DATA.bausteine, "c","3",STATIC.BAUSTEINE);

            //RuensTestEcke ende------------------------- */

            builder = new JDABuilder(AccountType.BOT);

            builder.setToken(SECRETS.token);
            builder.setAutoReconnect(true);

            builder.setStatus(OnlineStatus.ONLINE);

            addListeners();
            addCommands();

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
            CommandHandler.commands.put("update", new cmdUpdate());

        }

        public static void addListeners() {

            builder.addEventListener(new CommandListener());
        }

        public static void sheetinit() {
            try {
                SheetIntegration.setup();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
