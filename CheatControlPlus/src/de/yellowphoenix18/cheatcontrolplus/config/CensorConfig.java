package de.yellowphoenix18.cheatcontrolplus.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CensorConfig {
	
	public static File f = new File("plugins/CheatControlPlus", "censor.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static List<String> badwords_level1 = new ArrayList<String>();
	public static List<String> badwords_level2 = new ArrayList<String>();
	public static List<String> badwords_level3 = new ArrayList<String>();
	
	public static void load() {
		badwords_level1.add("Shut up");
		badwords_level2.add("Idiot");
		badwords_level3.add("Fuck");
		
		badwords_level1 = setObject("BadWords.Level-1.List", badwords_level1);
		badwords_level2 = setObject("BadWords.Level-2.List", badwords_level2);
		badwords_level3 = setObject("BadWords.Level-3.List", badwords_level3);
		
		
	}
	
	public static List<String> setObject(String path, List<String> obj) {
		if(cfg.contains(path)) {
			return cfg.getStringList(path);
		} else {
			cfg.set(path, obj);
			save();
			return obj;
		}
	}
	
	public static void save() {
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
