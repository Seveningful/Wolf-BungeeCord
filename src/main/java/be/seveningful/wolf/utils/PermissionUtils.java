package be.seveningful.wolf.utils;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Seveningful
 */
public class PermissionUtils {

    public static List<ProxiedPlayer> getPlayersWithPermission(String s) {
        List<ProxiedPlayer> proxiedPlayerList = new ArrayList<>();
        for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
            if (p.hasPermission(s)) {
                proxiedPlayerList.add(p);
            }
        }
        return proxiedPlayerList;
    }
}
