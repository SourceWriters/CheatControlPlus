package de.yellowphoenix18.cheatcontrolplus;

import org.bukkit.plugin.java.JavaPlugin;

import de.yellowphoenix18.cheatcontrolplus.utils.PluginUtils;

public class CheatControlPlus extends JavaPlugin {
	
	public static CheatControlPlus m;
	
	public void onEnable() {
		m = this;
		PluginUtils.setUp();
	}
	
	public void onDisable() {
		
	}

}
