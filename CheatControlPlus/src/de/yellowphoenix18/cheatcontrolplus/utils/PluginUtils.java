package de.yellowphoenix18.cheatcontrolplus.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import de.yellowphoenix18.cheatcontrolplus.CheatControlPlus;
import de.yellowphoenix18.cheatcontrolplus.config.HacksConfig;
import de.yellowphoenix18.cheatcontrolplus.config.MainConfig;
import de.yellowphoenix18.cheatcontrolplus.listener.DamageListener;
import de.yellowphoenix18.cheatcontrolplus.listener.MoveListener;

public class PluginUtils {
	
	public static String version = "";
	
	public static void setUp() {
		version = getServerVersion();
		if(!version.equalsIgnoreCase("v1_8_R1") && !version.equalsIgnoreCase("v1_8_R2") && !version.equalsIgnoreCase("v1_8_R3") && !version.equalsIgnoreCase("v1_9_R1") &&
		   !version.equalsIgnoreCase("v1_9_R2") && !version.equalsIgnoreCase("v1_10_R1") && !version.equalsIgnoreCase("v1_11_R1")) {
			System.out.println("[CheatControlPlus] Your Spigot-Version is not supported, disabling CheatControlPlus...");
			Bukkit.getPluginManager().disablePlugin(CheatControlPlus.m);
		}

		loadConfigs();
		loadListener();
		loadCommands();
	}
	
	public static String getServerVersion() {
		String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		return version;
	}
	
	public static void loadListener() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new DamageListener(), CheatControlPlus.m);
		pm.registerEvents(new MoveListener(), CheatControlPlus.m);
	}
	
	public static void loadCommands() {
		
	}
	
	public static void loadConfigs() {
		HacksConfig.load();
		MainConfig.load();
	}

}
