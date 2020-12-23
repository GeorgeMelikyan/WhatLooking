package George;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WhatLooking extends JavaPlugin {
    public static ConsoleCommandSender consoleCommandSender;
    public static String prefix;

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String[] color(String[] msg) {
        for (int i = 0; i < msg.length; i++) {
            msg[i] = ChatColor.translateAlternateColorCodes('&', msg[i]);
        }
        return msg;
    }

    public void onEnable() {
        consoleCommandSender = getServer().getConsoleSender();
        prefix = color("&8(&cADVENTURES&8) &7WhatLooking");
        //Bukkit.getPluginManager().registerEvents(new Login(this), this);
        consoleCommandSender.sendMessage(prefix + " enabled.");
    }

    Optional<BlockRayHit<World>> optHit = BlockRay.from(player).filter(BlockRay.onlyAirFilter()).build().end();
if (optHit.isPresent()) {
        Vector lookPos = optHit.get().getBlockPosition().toDouble();
        Collection<Entity> entities = player.getWorld().getEntities(entity -> entity != player && entity.getLocation().getPosition().distanceSquared(lookPos) < 4);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("test")){
            if(!(sender instanceof Player)){
                sender.sendMessage("Silly Robot, This command is for players!");
                return true;
            }

            Player player = (Player) sender;
            player.sendMessage("========");

            List<Entity> entities = getEntitys(player);
            player.sendMessage("========");

        }
        return true;
    }


    public void onDisable() {
        consoleCommandSender.sendMessage(prefix + " disabled.");
    }


}
