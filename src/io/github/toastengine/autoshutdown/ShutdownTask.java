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
import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 *
 * @author 17engleandrew
 */
public class ShutdownTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000*10);//Thread.sleep(1000 * 60 * 60 * 3);
            Thread.sleep(1000 * 60 * 30);// 3hours 30minutes
            Bukkit.broadcastMessage(ChatColor.YELLOW + "[" + ChatColor.RED + "AutoRestart" + ChatColor.YELLOW + "] Reboot " + ChatColor.RESET + "in 30 minutes!");
            Thread.sleep(1000 * 60 * 10);
            Bukkit.broadcastMessage(ChatColor.YELLOW + "[" + ChatColor.RED + "AutoRestart" + ChatColor.YELLOW + "] Reboot " + ChatColor.RESET + "in 20 minutes!");
            Thread.sleep(1000 * 60 * 10);
            Bukkit.broadcastMessage(ChatColor.YELLOW + "[" + ChatColor.RED + "AutoRestart" + ChatColor.YELLOW + "] Reboot " + ChatColor.RESET + "in 10 minutes!");
            Thread.sleep(1000 * 60 * 5);
            Bukkit.broadcastMessage(ChatColor.YELLOW + "[" + ChatColor.RED + "AutoRestart" + ChatColor.YELLOW + "] Reboot " + ChatColor.RESET + "in 5 minutes!");
            Thread.sleep(1000 * 60 * 4);
            Bukkit.broadcastMessage(ChatColor.YELLOW + "[" + ChatColor.RED + "AutoRestart" + ChatColor.YELLOW + "] Reboot " + ChatColor.RESET + "in 1 minute!");
            Thread.sleep(1000 * 30);
            Bukkit.broadcastMessage(ChatColor.YELLOW + "[" + ChatColor.RED + "AutoRestart" + ChatColor.YELLOW + "] Reboot " + ChatColor.RESET + "in 30 seconds!");
            Thread.sleep(1000 * 20);
            Bukkit.broadcastMessage(ChatColor.YELLOW + "[" + ChatColor.RED + "AutoRestart" + ChatColor.YELLOW + "] Reboot " + ChatColor.RESET + "in 10 seconds!");
            for (int i = 9; i >= 1; i--) {
                Thread.sleep(1000*1);//Thread.sleep(1000);
                Bukkit.broadcastMessage(ChatColor.YELLOW + "[" + ChatColor.RED + "AutoRestart" + ChatColor.YELLOW + "] Reboot " + ChatColor.RESET + "in " + i + " second(s)!");
            }
            // Perform Safe Shutdown.
            for (World worlds : Bukkit.getWorlds()) {
                worlds.save();
                Bukkit.broadcastMessage(ChatColor.YELLOW + "[" + ChatColor.RED + "AutoRestart" + ChatColor.YELLOW + "] Reboot " + ChatColor.RESET + "Saving, " + worlds.getName());
            }
            Bukkit.getServer().savePlayers();
            Bukkit.broadcastMessage(ChatColor.YELLOW + "[" + ChatColor.RED + "AutoRestart" + ChatColor.YELLOW + "] Reboot " + ChatColor.RESET + "Saved!");
           
            for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                p.kickPlayer("Server is rebooting check back in 1-2 minutes.");
            }
            Bukkit.getServer().shutdown();
            
        } catch (InterruptedException ex) {

            Logger.getLogger(ShutdownTask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
