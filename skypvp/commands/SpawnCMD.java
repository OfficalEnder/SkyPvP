package skypvp.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import skypvp.Main.Main;

public class SpawnCMD implements CommandExecutor {

	private Main plugin;

	public SpawnCMD(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

		if (s instanceof Player) {

			Player p = (Player) s;

			if (c.getName().equalsIgnoreCase("spawn")) {

				if (p.getLocation().add(0, -1, 0).getBlock().getType() != Material.AIR) {
					this.plugin.sl.onSpawnLocation(p.getPlayer());

				}
			}
		}
		return false;
	}
}
