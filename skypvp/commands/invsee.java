package skypvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import skypvp.Main.Main;

public class invsee implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player) s;

		if (p.hasPermission("skypvp.invsee")) {
			if (args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if (target != null) {
					p.openInventory(target.getInventory());
				} else {
					p.sendMessage(Main.Prefix + "§cDer angegebene Spieler ist derzeit nicht online!");
				}

			} else {
				p.sendMessage(Main.Prefix + "§cBitte nutze den Command /invsee <Name>");
			}
		} else {
			p.sendMessage(Main.noPerms);
		}

		return false;
	}

}
