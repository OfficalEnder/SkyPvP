
package skypvp.events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import skypvp.Main.Main;

public class PlayerDeath implements Listener {

	private Main plugin;

	public PlayerDeath(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), new Runnable() {

			@Override
			public void run() {
				e.getEntity().spigot().respawn();
				plugin.sl.onSpawnLocation(e.getEntity().getPlayer());
			}
		}, 20);

		e.getDrops().clear();
		e.setDroppedExp(0);
		e.setKeepLevel(true);
		e.setDeathMessage(null);
		
		if (e.getEntity().getKiller() instanceof Player) {

			Stats.addDeaths(e.getEntity().getName(), 1);
			Stats.addKills(e.getEntity().getKiller().getName(), 1);

			if (e.getEntity().hasPermission("skypvp.admin")) {
				e.getEntity().playSound(e.getEntity().getLocation(), Sound.LEVEL_UP, 1f, 1f);
				e.getEntity().getKiller()
						.sendMessage(Main.Prefix + "§7Du hast §4" + e.getEntity().getDisplayName() + " §7getötet.");
			} else {
				e.getEntity().playSound(e.getEntity().getLocation(), Sound.LEVEL_UP, 1f, 1f);
				e.getEntity().getKiller()
						.sendMessage(Main.Prefix + "§7Du hast §8" + e.getEntity().getDisplayName() + " §7getötet.");
				return;
			}
		}
	}
}