/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.toastengine.autoshutdown;

import java.io.InputStream;
import java.time.LocalTime;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author ToastEngine https://github.com/ToastEngine
 */
public class plugin extends JavaPlugin {

    public static Logger Logger = Bukkit.getLogger();
    public static String Prefix = ChatColor.YELLOW + "[" + ChatColor.RED + "AutoShutdown" + ChatColor.YELLOW + "] " + ChatColor.RESET + "";
    public static String Version;
    public static UptimeTask UptimeTask;
    PluginDescriptionFile SelfDesc;
    Thread ShutdownThread;

    @Override
    public void onEnable() {
        SelfDesc = Bukkit.getServer().getPluginManager().getPlugin("AutoShutdown").getDescription();
        Version = SelfDesc.getVersion();
        UptimeTask = new UptimeTask();
        //Logger.log(Level.INFO, "[AutoShutdown] Enabled v" + SelfDesc.getVersion());
        ShutdownThread = new Thread(new ShutdownTask());
        ShutdownThread.start();

    }

    @Override
    public void onDisable() {
        //Logger.log(Level.INFO, "[AutoShutdown] Disabled v" + SelfDesc.getVersion());
        ShutdownThread.interrupt();
    }

    private String ConvertSecondToHHMMSSString(int nSecondTime) {
        return LocalTime.MIN.plusSeconds(nSecondTime).toString();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getLabel().equalsIgnoreCase("as") && args.length < 1) {
                player.sendMessage(Prefix + "Version: " + SelfDesc.getVersion());
                player.sendMessage(Prefix + "Author: ToastEngine");
                player.sendMessage(Prefix + "/as help for commands.");
            } else if (cmd.getLabel().equalsIgnoreCase("as") && args.length > 0) {
                if (args[0].equalsIgnoreCase("help")) {
                    player.sendMessage(ChatColor.YELLOW + "--------------------[1/1]--------------------");
                    player.sendMessage(Prefix + "/as uptime");
                    player.sendMessage(Prefix + "/as timeleft");
                    player.sendMessage(Prefix + "/as halt");
                    player.sendMessage(Prefix + "/as start");
                    player.sendMessage(Prefix + "/as set [minutes]");
                    player.sendMessage(ChatColor.YELLOW + "--------------------[1/1]--------------------");
                } else if (args[0].equalsIgnoreCase("uptime")) {
                    int src = UptimeTask.getUptime();
                    player.sendMessage(Prefix + ConvertSecondToHHMMSSString(src)+" H:M:S");
                }
            }
        } else {
            return false;
        }
        // do something
        return false;
    }
}
