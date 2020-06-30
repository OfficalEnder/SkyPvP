package skypvp.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import skypvp.Main.Main;

public class SpawnLocation implements Listener {

	public void onSpawnLocation(Player p) {

		String world = Main.cfg.getString("spawn.world");
		double x = Main.cfg.getDouble("spawn.x");
		double y = Main.cfg.getDouble("spawn.y");
		double z = Main.cfg.getDouble("spawn.z");
		float yaw = Main.cfg.getInt("spawn.yaw");
		float pitch = Main.cfg.getInt("spawn.pitch");

		Location loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
		p.teleport(loc);
	}
}
