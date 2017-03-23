/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.toastengine.autoshutdown;

import java.io.InputStream;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author ToastEngine https://github.com/ToastEngine
 */
public class plugin extends JavaPlugin {

    Logger Logger = Bukkit.getLogger();
    PluginDescriptionFile SelfDesc;
    Thread ShutdownThread;

    @Override
    public void onEnable() {
        SelfDesc = Bukkit.getServer().getPluginManager().getPlugin("AutoShutdown").getDescription();
        Logger.log(Level.INFO, "[AutoShutdown]: Enabled v" + SelfDesc.getVersion());
        ShutdownThread = new Thread(new ShutdownTask());
        ShutdownThread.start();
        // Help!?sdlkasjdlkas

    }

    @Override
    public void onDisable() {
        Logger.log(Level.INFO, "[AutoShutdown]: Disabled v" + SelfDesc.getVersion());
        ShutdownThread.interrupt();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("basic")) { // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
            Logger.log(Level.INFO, "basic command ran :0?");
            return true;
        } //If this has happened the function will return true. 
        // If this hasn't happened the value of false will be returned.
        return false;
    }

}
