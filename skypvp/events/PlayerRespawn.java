package skypvp.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import skypvp.Main.Main;

public class PlayerRespawn implements Listener {

	private Main plugin;

	public PlayerRespawn(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {

		if (e.getPlayer().getLevel() <= 1) {
			e.getPlayer().setLevel(1);

		}

		e.setRespawnLocation(this.plugin.rl.onRespawnLocation(e.getPlayer()));

	}

}
