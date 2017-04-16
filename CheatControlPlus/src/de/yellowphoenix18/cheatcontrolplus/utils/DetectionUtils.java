package de.yellowphoenix18.cheatcontrolplus.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class DetectionUtils {
	
	public static List<String> in_range_detection = new ArrayList<String>();
	public static List<String> in_fly_detection = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	public static boolean isFlying(Player p) {		
		if(p.getGameMode() == GameMode.SURVIVAL || p.getGameMode() == GameMode.ADVENTURE) {
			if(p.isFlying() == false && p.getAllowFlight() == false) {
				World w = p.getLocation().getWorld();
				double x = p.getLocation().getX();
				double z = p.getLocation().getZ();
				double y = p.getLocation().getY();
				Location loc_u2 = new Location(w, x, y-2, z);
				Location loc_u1 = new Location(w, x, y-1, z);
				Location loc_u1_xm = new Location(w, x-1, y-1, z);
				Location loc_u1_xp = new Location(w, x+1, y-1, z);
				Location loc_u1_zm = new Location(w, x, y-1, z-1);
				Location loc_u1_zp = new Location(w, x, y-1, z+1);
				Location loc_u1_xm_zm = new Location(w, x-1, y-1, z-1);
				Location loc_u1_xp_zp = new Location(w, x+1, y-1, z+1);
				Location loc_u1_xp_zm = new Location(w, x+1, y-1, z-1);
				Location loc_u1_xm_zp = new Location(w, x-1, y-1, z+1);
				Location loc = new Location(w, x, y, z);
				Location loc_xm = new Location(w, x-1, y, z);
				Location loc_xp = new Location(w, x+1, y, z);
				Location loc_zm = new Location(w, x, y, z-1);
				Location loc_zp = new Location(w, x, y, z+1);
				Location loc_xm_zm = new Location(w, x-1, y, z-1);
				Location loc_xp_zp = new Location(w, x+1, y, z+1);
				Location loc_xp_zm = new Location(w, x+1, y, z-1);
				Location loc_xm_zp = new Location(w, x-1, y, z+1);
				Location loc_up1 = new Location(w, x, y+1, z);
				Location loc_up1_xm = new Location(w, x-1, y+1, z);
				Location loc_up1_xp = new Location(w, x+1, y+1, z);
				Location loc_up1_zm = new Location(w, x, y+1, z-1);
				Location loc_up1_zp = new Location(w, x, y+1, z+1);
				Location loc_up1_xm_zm = new Location(w, x-1, y+1, z-1);
				Location loc_up1_xp_zp = new Location(w, x+1, y+1, z+1);
				Location loc_up1_xp_zm = new Location(w, x+1, y+1, z-1);
				Location loc_up1_xm_zp = new Location(w, x-1, y+1, z+1);
				if(loc_u2.getBlock().getTypeId() == 0 && loc_u1.getBlock().getTypeId() == 0 && loc_u1_xm.getBlock().getTypeId() == 0 && loc_u1_xp.getBlock().getTypeId() == 0
				&& loc_u1_zm.getBlock().getTypeId() == 0 && loc_u1_zp.getBlock().getTypeId() == 0 && loc_u1_xm_zm.getBlock().getTypeId() == 0 && loc_u1_xp_zp.getBlock().getTypeId() == 0
				&& loc_u1_xp_zm.getBlock().getTypeId() == 0 && loc_u1_xm_zp.getBlock().getTypeId() == 0 && loc.getBlock().getTypeId() == 0 && loc_zm.getBlock().getTypeId() == 0
				&& loc_xm.getBlock().getTypeId() == 0 && loc_xp.getBlock().getTypeId() == 0 && loc_zp.getBlock().getTypeId() == 0 && loc_xm_zm.getBlock().getTypeId() == 0
				&& loc_xp_zp.getBlock().getTypeId() == 0 && loc_xp_zm.getBlock().getTypeId() == 0 && loc_xm_zp.getBlock().getTypeId() == 0 && loc_up1.getBlock().getTypeId() == 0
				&& loc_up1_zm.getBlock().getTypeId() == 0 && loc_up1_xm.getBlock().getTypeId() == 0 && loc_up1_xp.getBlock().getTypeId() == 0 && loc_up1_zp.getBlock().getTypeId() == 0
				&& loc_up1_xm_zm.getBlock().getTypeId() == 0 && loc_up1_xp_zp.getBlock().getTypeId() == 0 && loc_up1_xp_zm.getBlock().getTypeId() == 0 && loc_up1_xm_zp.getBlock().getTypeId() == 0) {
					return true;
				}
			}
		}
		return false;
	}

}
