/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.toastengine.autoshutdown;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Andy
 */
public class plugin extends JavaPlugin{
    Logger Logger = Bukkit.getLogger();
    
    @Override
    public void onEnable(){
       Logger.log(Level.INFO, ChatColor.AQUA+"[AutoShutdown]:"+ChatColor.GREEN+" Enabled!");
    }
    
    @Override
    public void onDisable(){
        Logger.log(Level.INFO, ChatColor.AQUA+"[AutoShutdown]:"+ChatColor.RED+" Disabled!");
    }
    
}
