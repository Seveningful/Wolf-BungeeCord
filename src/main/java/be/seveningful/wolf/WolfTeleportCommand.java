package be.seveningful.wolf;

import be.seveningful.wolf.utils.MessagesUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * @author Seveningful
 */
public class WolfTeleportCommand extends Command {


    public WolfTeleportCommand() {
        super("wgoto", "wolf.command.wgoto", "wolfgoto", "wtp", "wolftp");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) commandSender;

            if (args.length == 0) {
                p.sendMessage(MessagesUtils.invalidArgs());

            } else {
                ProxiedPlayer pp = ProxyServer.getInstance().getPlayer(args[0]);
                if (pp == null) {
                    p.sendMessage(MessagesUtils.invalidPlayer());
                } else {
                    p.connect(pp.getServer().getInfo());
                }
            }
        }
    }
}
