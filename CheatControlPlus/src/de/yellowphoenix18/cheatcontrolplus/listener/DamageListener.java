package de.yellowphoenix18.cheatcontrolplus.listener;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.yellowphoenix18.cheatcontrolplus.config.HacksConfig;
import de.yellowphoenix18.cheatcontrolplus.detection.RangeHack;

public class DamageListener implements Listener {
	
	public static HashMap<Player, RangeHack> range = new HashMap<Player, RangeHack>();
	
	@EventHandler
	public void on(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player) e.getEntity();
			Player k = (Player) e.getDamager();
			double dis = p.getLocation().distance(k.getLocation());
			if(dis > 4) {
				if(!range.containsKey(k)) {
					RangeHack hack = new RangeHack(k, HacksConfig.range_detect_damages, HacksConfig.range_detect_time);
					hack.start();
					range.put(k, hack);
				} else {
					range.get(k).addHit();
				}
			}
		}
	}
}
