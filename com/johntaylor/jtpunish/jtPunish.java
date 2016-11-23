package com.johntaylor.jtpunish;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.johntaylor.jtpunish.commands.PunishCommand;

public class jtPunish extends JavaPlugin {
	
	private static jtPunish plugin;
	
	public void onEnable() {
		plugin = this;
		createConfig();
		PunishCommand punishCommand = new PunishCommand();
		command("punish", punishCommand);
		event(punishCommand);
	}
	
	public void onDisable() {
		plugin = null;
	}
	
	public static jtPunish getInstance() {
		return plugin;
	}
	
	public void command(String cmd, CommandExecutor cmdexec) {
		Bukkit.getPluginCommand(cmd).setExecutor(cmdexec);
	}

	public void event(Listener l) {
		org.bukkit.plugin.PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(l, this);
	}

	private void createConfig() {
	    try {
	        if (!getDataFolder().exists()) {
	            getDataFolder().mkdirs();
	        }
	        File file = new File(getDataFolder(), "config.yml");
	        if (!file.exists()) {
	            getLogger().info("Config.yml not found, creating!");
	            saveDefaultConfig();
	        } else {
	            getLogger().info("Config.yml found, loading!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}