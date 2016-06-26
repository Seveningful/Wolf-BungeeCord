package be.seveningful.wolf.utils;

import be.seveningful.wolf.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.connection.ProxiedPlayer;

/**
 * @author Seveningful
 */
public class MessagesUtils {

    public static TextComponent build(String username, long kad, String banreason, String[] args, int violatrionValue) {
        ProxiedPlayer p = Main.getPlugin().getProxy().getPlayer(username);
        TextComponent prefix = new TextComponent("(WOLF) ");
        prefix.setColor(ChatColor.DARK_GREEN);


        TextComponent usernametext = new TextComponent(username);
        usernametext.setColor(ChatColor.YELLOW);
        usernametext.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,  "/wolftp " + username));

        TextComponent middleText = new TextComponent(" is suspected for ");
        middleText.setColor(ChatColor.DARK_GREEN);

        TextComponent violationName = new TextComponent(banreason);
        violationName.setColor(ChatColor.DARK_RED);
        ComponentBuilder cb = new ComponentBuilder(ChatColor.GOLD + ChatColor.UNDERLINE.toString() + "Hack informations" + ChatColor.GOLD + " »\n");
        if(!args[0].equalsIgnoreCase("") )
            for(String ss : args) {
                cb.append(ss + "\n");
            }
        else {
            cb.append(ChatColor.GRAY + ChatColor.ITALIC.toString() + " - None -\n");
        }
        cb.append(ChatColor.YELLOW + ChatColor.UNDERLINE.toString() + "General informations" + ChatColor.YELLOW + " »" + "\n");
        cb.append(ChatColor.RED + " KAD : " + ChatColor.WHITE + kad + "\n");
        cb.append(ChatColor.RED + " Ping : " + ChatColor.WHITE +p.getPing() + " ms\n" );
        cb.append(ChatColor.RED + " Violation value : " + ChatColor.WHITE + violatrionValue + "");
        violationName.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, cb.create()));

        prefix.addExtra(usernametext);
        prefix.addExtra(middleText);
        prefix.addExtra(violationName);

        return prefix;





    }

    public static BaseComponent invalidArgs() {
        TextComponent compo = new TextComponent("Invalid arguments ! Please use ");
        compo.setColor(ChatColor.RED);
        TextComponent command = new TextComponent("/wgoto <player>");
        command.setColor(ChatColor.YELLOW);
        compo.addExtra(command);
        return compo;
    }

    public static BaseComponent invalidPlayer() {
        TextComponent compo = new TextComponent("Invalid arguments ! ");
        compo.setColor(ChatColor.RED);
        TextComponent command = new TextComponent("Player is not valid.");
        command.setColor(ChatColor.YELLOW);
        compo.addExtra(command);
        return compo;
    }
}
