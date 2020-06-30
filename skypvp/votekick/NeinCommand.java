package skypvp.votekick;

import skypvp.Main.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NeinCommand implements CommandExecutor {
	public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (Vote.voting) {
				Vote.addNein(p);
				Vote.votes.put(p, p.getName());
			} else {
				p.sendMessage(Main.Prefix + "§7Es findet derzeit §ckein §7Voting statt§8!");
			}
		} else {
			cs.sendMessage(Main.noPerms);
		}
		return false;
	}
}
