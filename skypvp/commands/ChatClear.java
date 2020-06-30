package skypvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import skypvp.Main.Main;

public class ChatClear implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player) s;
		if (p.hasPermission("skypvp.cc")) {	//Berechtigungsabfrage für ChatClear
			if (label.equalsIgnoreCase("cc")) {
				if (s instanceof Player && args.length == 0) {
					for (int i = 0; i < 150; i++) {
						Bukkit.broadcastMessage("");
					}

					if (p.hasPermission("skypvp.team")) {	//Abfrage welche User Gruppe der Anwendene Spieler Angehöhrt (Cosmetisch)
						Bukkit.broadcastMessage(
								Main.Prefix + "§7Der Chat wurde von §4" + p.getDisplayName() + " §7geleert");
					} else if (p.hasPermission("skypvp.user")) {	
						Bukkit.broadcastMessage(
								Main.Prefix + "§7Der Chat wurde von §b" + p.getDisplayName() + " §7geleert");
						return true;
					}
				}
			}
		} else {
			p.sendMessage(Main.noPerms);

		}
		return false;
	}
}
