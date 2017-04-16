package de.yellowphoenix18.cheatcontrolplus.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class HacksConfig {
	
	public static File f = new File("plugins/CheatControlPlus", "hacks.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static boolean ping_detect = false;
	public static int max_ping = 100;
	
	public static boolean fly_enabled = true;
	public static int fly_detect_time = 20;
	public static int fly_warns = 5;
	
	public static boolean range_enabled = true;
	public static int range_detect_time = 70;
	public static int range_detect_damages = 2;
	public static int range_warns = 5;
	
	public static void load() {
		ping_detect = setObject("settings.ping.detect", ping_detect);
		max_ping = setObject("settings.ping.max", max_ping);
		
		fly_enabled = setObject("fly.enabled", fly_enabled);
		fly_detect_time = setObject("fly.detect_time", fly_detect_time);
		fly_warns = setObject("fly.warn_points", fly_warns);
		
		range_enabled = setObject("reach.enabled", range_enabled);
		range_detect_time = setObject("reach.detect_time", range_detect_time);
		range_detect_damages = setObject("reach.detect_damages", range_detect_damages);
		range_warns = setObject("range.warn_points", range_warns);
		
		
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
