package main;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Plugin startet...");
        getServer().getPluginManager().registerEvents(this, this);
        Objects.requireNonNull(this.getCommand("home")).setExecutor(new HomeCMD());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        String name = getPlayerColor(e.getPlayer().getName());
        e.setJoinMessage("§2» §a" + name + " §7ist beigetreten!");
        e.getPlayer().setPlayerListHeaderFooter("§aFiA's Survival Server", "§7Sponsored by Mercedes-Benz Group AG");

        e.getPlayer().setPlayerListName(name);


    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage("§4« §c" + getPlayerColor(e.getPlayer().getName()) + " §7ist gegangen.");
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String name = e.getPlayer().getName();

        e.setFormat(getPlayerColor(name) + " §8» §f" + e.getMessage());
    }

    public String getPlayerColor(String name) {
        if (name.equalsIgnoreCase("BytePhil")) {
            name = "§bPhilipp";
        } else if (name.equalsIgnoreCase("HerrAquarium")) {
            name = "§5Benni";
        } else if (name.equalsIgnoreCase("RoboTrack")) {
            name = "§6Dominik";
        } else if (name.equalsIgnoreCase("yungztrunks")) {
            name = "§9Silvan";
        } else if (name.equalsIgnoreCase("Misaki783")) {
            name = "§dDesi";
        } else if (name.equalsIgnoreCase("xXx_MAE_xXx")) {
            name = "§cMarc";
        } else {
            name = "§7" + name;
        }
        return name;
    }
}
