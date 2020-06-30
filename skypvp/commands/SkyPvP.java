package skypvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import skypvp.Main.Main;

public class SkyPvP implements CommandExecutor {

	private Main plugin;

	public SkyPvP(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		if (s instanceof Player) {

			Player p = (Player) s;

			if (!(p.hasPermission("skypvp.admin"))) {
				p.sendMessage(Main.noPerms);

			} else {

				if (args.length == 0) {
					p.sendMessage(Main.Prefix + "§cBitte nutze den Command /skypvp help");
					return true;
				}

				if (args[0].equalsIgnoreCase("help")) {
					p.sendMessage(Main.Prefix + "§6Verwaltung");
					p.sendMessage(Main.Prefix + "§e/skypvp setspawn §7Setzt den Spawn");
					p.sendMessage(Main.Prefix + "§e/spawn §7Teleportiert dich zum Spawn");
					return true;
				}

				if (args[0].equalsIgnoreCase("setspawn")) {

					Main.cfg.set("spawn.world", p.getWorld().getName());
					Main.cfg.set("spawn.x", Double.valueOf(p.getLocation().getX()));
					Main.cfg.set("spawn.y", Double.valueOf(p.getLocation().getY()));
					Main.cfg.set("spawn.z", Double.valueOf(p.getLocation().getZ()));
					Main.cfg.set("spawn.yaw", Double.valueOf(p.getLocation().getYaw()));
					Main.cfg.set("spawn.pitch", Double.valueOf(p.getLocation().getPitch()));

					this.plugin.saveConfig();
					p.sendMessage(Main.Prefix + "§aDu hast den Spawn erfolgreich gesetzt");
					return true;
				}
			}

		}
		return false;
	}

}
