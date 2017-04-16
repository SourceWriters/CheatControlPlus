package de.yellowphoenix18.cheatcontrolplus.external;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.yellowphoenix18.cheatcontrolplus.utils.HackType;

public class CheatControlAPI {
	
	public static void callEvent(Player p, HackType type, int length) {
		Bukkit.getPluginManager().callEvent(new CheatControlHackEvent(p, type, length));
	}

}
