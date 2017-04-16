package de.yellowphoenix18.cheatcontrolplus.detection;

import org.bukkit.entity.Player;

import de.yellowphoenix18.cheatcontrolplus.config.HacksConfig;
import de.yellowphoenix18.cheatcontrolplus.external.CheatControlAPI;
import de.yellowphoenix18.cheatcontrolplus.utils.DetectionEndState;
import de.yellowphoenix18.cheatcontrolplus.utils.DetectionUtils;
import de.yellowphoenix18.cheatcontrolplus.utils.HackType;
import de.yellowphoenix18.cheatcontrolplus.versionutils.VersionUtils;

public class FlyHack extends Thread {
	
	Player p;
	int timer;
	int timer_length;
	int check;
	double start_height = 0;
	DetectionEndState state = DetectionEndState.DETECTED;
	
	
	
	public FlyHack(Player p, int timer) {
		this.p = p;
		this.timer = 0;
		this.timer_length = timer;
		this.start_height = p.getLocation().getY();
	}
	
	public void run() {
		DetectionUtils.in_fly_detection.add(p.getUniqueId().toString());
		while(timer <= timer_length) {
			timer++;
			if(p != null) {
				if(HacksConfig.ping_detect && HacksConfig.max_ping >= VersionUtils.getPing(p)) {
					state = DetectionEndState.FAILED;
					break;
				}
				double reverse_minus = timer_length*0.27*(-1);
				if(!DetectionUtils.isFlying(p) || start_height-p.getLocation().getY() > reverse_minus) {
					state = DetectionEndState.FAILED;
					break;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				state = DetectionEndState.FAILED;
				break;				
			}
		}
		if(p != null) {
			if(state == DetectionEndState.DETECTED) {
				CheatControlAPI.callEvent(p, HackType.FLY, timer_length);
			}
			DetectionUtils.in_fly_detection.remove(p.getUniqueId().toString());
		}
	}

}