package de.yellowphoenix18.cheatcontrolplus.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MainConfig {
	
	public static File f = new File("plugins/CheatControlPlus", "config.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static boolean warns_enabled = true;
	public static int max_warns = 50;
	
	public static void load() {
		warns_enabled = setObject("warns.enabled", warns_enabled);
		max_warns = setObject("warns.max", max_warns);
	}
	
	public static boolean save() {
		try {
			cfg.save(f);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static String setObject(String path, String value) {
		if(cfg.contains(path)) {
			return cfg.getString(path);
		} else {
			cfg.set(path, value);
			save();
			return value;
		}
	}
	
	public static int setObject(String path, int value) {
		if(cfg.contains(path)) {
			return cfg.getInt(path);
		} else {
			cfg.set(path, value);
			save();
			return value;
		}
	}
	
	public static boolean setObject(String path, boolean value) {
		if(cfg.contains(path)) {
			return cfg.getBoolean(path);
		} else {
			cfg.set(path, value);
			save();
			return value;
		}
	}

}
