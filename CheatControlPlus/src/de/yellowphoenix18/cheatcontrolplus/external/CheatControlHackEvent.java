package de.yellowphoenix18.cheatcontrolplus.external;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import de.yellowphoenix18.cheatcontrolplus.utils.HackType;

public class CheatControlHackEvent extends Event {
	
	public HandlerList handlers = new HandlerList();
	public Player player;
	public HackType type;
	public int timer_length = 0;
	
	public CheatControlHackEvent(Player player, HackType type, int timer_length) {
		this.player = player;
		this.type = type;
		this.timer_length = timer_length;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public int getTimerLength() {
		return this.getTimerLength();
	}
	
	public HandlerList getHandlers() {
		return this.handlers;
	}
	
	public HandlerList getHandlerList() {
		return this.handlers;
	}

}
