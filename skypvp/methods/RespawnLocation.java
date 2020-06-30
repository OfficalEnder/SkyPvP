package skypvp.methods;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import skypvp.Main.Main;

public class RespawnLocation {

	public Location onRespawnLocation(Player p) {

		String world = Main.cfg.getString("spawn.world");
		double x = Main.cfg.getDouble("spawn.x");
		double y = Main.cfg.getDouble("spawn.y");
		double z = Main.cfg.getDouble("spawn.z");
		float yaw = Main.cfg.getInt("spawn.yaw");
		float pitch = Main.cfg.getInt("spawn.pitch");

		Location loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
		p.teleport(loc);
		return loc;
	}

	public Location getSpawn() {
		return new Location(Bukkit.getWorld(Main.cfg1.getString("World")), Main.cfg1.getDouble("X"),
				Main.cfg1.getDouble("Y"), Main.cfg1.getDouble("Z"), (float) Main.cfg1.getDouble("Yaw"),
				(float) Main.cfg1.getDouble("Pitch"));

	}
}
