package skypvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import skypvp.events.Stats;

public class stats implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player) s;

		if (c.getName().equalsIgnoreCase("stats")) {

			p.sendMessage("§7-= §eStats von §6" + p.getDisplayName() + " §7=-");
			p.sendMessage("§7Kills§8: §e" + Stats.getKills(p.getName()));
			p.sendMessage("§7Deaths§8: §e" + Stats.getDeaths(p.getName()));
			p.sendMessage("§7-= §eStats von §6" + p.getDisplayName() + " §7=-");
		}

		return false;
	}

}
