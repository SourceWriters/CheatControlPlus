package de.yellowphoenix18.cheatcontrolplus.external;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CheatControlCensorEvent extends Event {

	public HandlerList handlers = new HandlerList();
	
	public HandlerList getHandlers() {
		return this.handlers;
	}

}
