package main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class HomeCMD implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (s instanceof Player) {
            Player player = (Player) s;

            if (cmd.getName().equalsIgnoreCase("home")) {

                player.sendMessage("§7Du wirst jetzt zur Base teleportiert!");
                World world = Bukkit.getWorld("world");
                Location loc = new Location(world, -123, 64, -3.6, 177, 8);
                player.teleport(loc);

            }
        }
        return false;
    }
}