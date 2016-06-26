package be.seveningful.wolf;

import be.seveningful.wolf.utils.MessagesUtils;
import be.seveningful.wolf.utils.PermissionUtils;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

/**
 * @author Seveningful
 */
public class Main extends Plugin implements Listener {


    private static Main instance;
    public static Plugin getPlugin() {
        return instance;
    }

    @Override
    public void onEnable() {
        getLogger().info("Loading Wolf-BC ...");
        instance = this;
        getProxy().registerChannel("Wolf-AC");
        getProxy().getPluginManager().registerListener(this, this);
        getProxy().getPluginManager().registerCommand(this, new WolfTeleportCommand());
    }

    @EventHandler
    public void onMessageReceive(PluginMessageEvent e) {
        if(e.getTag().equalsIgnoreCase("Wolf-AC")) {
            ByteArrayDataOutput out = null;

            ByteArrayDataInput in = ByteStreams.newDataInput(e.getData());
            String type = in.readUTF();
            if(type.equalsIgnoreCase("warning")) {
                String playername = in.readUTF();
                String banreason = in.readUTF();
                getLogger().info("Received warning of" + banreason);
                long kad = in.readLong();
                int violationValue = in.readInt();
                String[] args = in.readUTF().split(";");

                TextComponent message = MessagesUtils.build(playername,kad,banreason,args, violationValue);

                for(ProxiedPlayer p : PermissionUtils.getPlayersWithPermission("wolf.warning")) {
                    p.sendMessage(message);
                }
            }
        }
    }
}
