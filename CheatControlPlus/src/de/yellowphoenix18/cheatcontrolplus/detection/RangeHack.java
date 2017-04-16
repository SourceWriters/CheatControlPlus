package de.yellowphoenix18.cheatcontrolplus.detection;

import org.bukkit.entity.Player;

import de.yellowphoenix18.cheatcontrolplus.config.HacksConfig;
import de.yellowphoenix18.cheatcontrolplus.external.CheatControlAPI;
import de.yellowphoenix18.cheatcontrolplus.listener.DamageListener;
import de.yellowphoenix18.cheatcontrolplus.utils.DetectionEndState;
import de.yellowphoenix18.cheatcontrolplus.utils.DetectionUtils;
import de.yellowphoenix18.cheatcontrolplus.utils.HackType;
import de.yellowphoenix18.cheatcontrolplus.versionutils.VersionUtils;

public class RangeHack extends Thread {
	
	Player p;
	int max_hits;
	int timer;
	int hits = 0;
	int timer_length;
	DetectionEndState state = DetectionEndState.DETECTED;
	
	public RangeHack(Player p, int hits, int timer) {
		this.p = p;
		this.timer = timer;
		this.timer_length = timer;
		this.max_hits = hits;
	}
	
	public void addHit() {
		hits++;
	}
	
	public void run() {
		DetectionUtils.in_range_detection.add(p.getUniqueId().toString());
		while(timer > 0) {
			timer--;
			if(HacksConfig.ping_detect && HacksConfig.max_ping >= VersionUtils.getPing(p)) {
				state = DetectionEndState.FAILED;
				break;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(p != null) {
			if(hits >= max_hits) {
				if(state == DetectionEndState.DETECTED) {
					CheatControlAPI.callEvent(p, HackType.RANGE, timer_length);
				}
				DetectionUtils.in_range_detection.remove(p.getUniqueId().toString());			
			}
			DamageListener.range.remove(p);
		}
	}
 
}
