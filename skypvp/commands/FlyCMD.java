package skypvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import skypvp.Main.Main;

public class FlyCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		if (p.hasPermission("skypvp.fly")) {

			if ((args.length == 0) || args.length == 1) {

				if (args.length == 0) {

					if (p.isFlying()) {

						p.setAllowFlight(false);
						p.setFlying(false);
						p.sendMessage(Main.Prefix + "§aDu kannst nun nicht mehr fliegen");

					} else {

						p.setAllowFlight(true);
						p.setFlying(true);
						p.sendMessage(Main.Prefix + "§aDu kannst nun fliegen");
					}

				} else {

					Player target = Bukkit.getPlayer(args[0]);

					if (target != null) {

						if (target.isFlying()) {

							target.setFlying(false);
							p.sendMessage(Main.Prefix + "§aDu kannst nun nicht mehr fliegen");

						} else {

							target.setFlying(true);
							p.sendMessage(Main.Prefix + "§aDu kannst nun fliegen");

						}

					} else {

						p.sendMessage("§cDer angegebene Spieler ist nicht online!");

					}

				}

			} else {

				p.sendMessage(Main.Prefix + "§cBitte nutze den Command /fly oder /fly <Spieler>");

			}

		} else {

			p.sendMessage(Main.noPerms);

		}

		return false;
	}

}
