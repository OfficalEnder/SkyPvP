package skypvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import skypvp.Main.Main;
import skypvp.events.Stats;

public class StatsReset implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player) s;
		if (p.hasPermission("skypvp.stats.reset")) {
			if (args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);

				if (t != null) {
					Stats.setDeaths(t.getName(), 0);
					Stats.setKills(t.getName(), 0);

					p.sendMessage(Main.Prefix + "§7Die Stats von §6§l" + t.getName() + " §7wurden zurück gesetzt!");
				} else
					p.sendMessage(Main.Prefix + "§cDer Spieler " + args[0] + " ist nicht online!");
			} else
				p.sendMessage(Main.Prefix + "§7Benutze §c/reset <Spieler>");
		} else
			p.sendMessage(Main.noPerms);
		return false;
	}
}
