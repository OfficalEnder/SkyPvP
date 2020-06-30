package skypvp.events;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import skypvp.Main.Main;

public class KillStreak implements Listener {

	public static HashMap<String, Integer> killstreak = new HashMap<>();

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		killstreak.put(p.getName(), 0);
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		p.sendMessage("");
		p.sendMessage(Main.Prefix + "§aDu hast eine KillStreak von §6§l" + killstreak.get(p.getName()) + " §aKills");
		p.sendMessage("");
		killstreak.put(p.getName(), 0);
		if (k != null) {
			killstreak.put(k.getName(), killstreak.get(k.getName()) + 1);
			if (killstreak.get(k.getName()) == 3) {
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage(
						Main.Prefix + "§aDer Spieler §6§l" + k.getName() + " §ahat eine KillStreak von §6§l3");
				Bukkit.broadcastMessage("");
				return;
			}
			if (killstreak.get(k.getName()) == 6) {
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage(
						Main.Prefix + "§aDer Spieler §6§l" + k.getName() + " §ahat eine KillStreak von §6§l6");
				Bukkit.broadcastMessage("");
				return;
			}
			if (killstreak.get(k.getName()) == 10) {
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage(
						Main.Prefix + "§aDer Spieler §6§l" + k.getName() + " §ahat eine KillStreak von §6§l10");
				Bukkit.broadcastMessage("");
				return;
			}
			if (killstreak.get(k.getName()) == 15) {
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage(
						Main.Prefix + "§aDer Spieler §6§l" + k.getName() + " §ahat eine KillStreak von §6§l15");
				Bukkit.broadcastMessage("");
				return;
			}
			if (killstreak.get(k.getName()) == 20) {
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage(
						Main.Prefix + "§aDer Spieler §6§l" + k.getName() + " §ahat eine KillStreak von §6§l20");
				Bukkit.broadcastMessage("");
				return;

			}
		}
	}
}
