package skypvp.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import skypvp.commands.Build;

public class Block implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e) {

		if (!Build.allow.contains(e.getPlayer())) {

			e.getPlayer();
			e.setCancelled(true);

		}

	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {

		if (!Build.allow.contains(e.getPlayer())) {

			e.setCancelled(true);

		}

	}

}
