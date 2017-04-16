package de.yellowphoenix18.cheatcontrolplus.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.yellowphoenix18.cheatcontrolplus.config.HacksConfig;
import de.yellowphoenix18.cheatcontrolplus.detection.FlyHack;
import de.yellowphoenix18.cheatcontrolplus.utils.DetectionUtils;

public class MoveListener implements Listener {
	
	@EventHandler
	public void on(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(HacksConfig.fly_enabled) {
			if(!DetectionUtils.in_fly_detection.contains(p.getUniqueId().toString())) {
				if(DetectionUtils.isFlying(p)) {
					FlyHack fly = new FlyHack(p, HacksConfig.fly_detect_time);
					fly.start();
				}			
			}
		}
	}
}
