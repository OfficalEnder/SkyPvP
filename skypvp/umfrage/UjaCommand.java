package skypvp.umfrage;

import skypvp.Main.Main;
import skypvp.votekick.Vote;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UjaCommand implements CommandExecutor {
	public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (Vote.voting) {
				Vote.addJa(p);
				Vote.votes.put(p, p.getName());
			} else {
				p.sendMessage(Main.Prefix + "§7Es findet derzeit §ckeine §7Umfrage statt§8!");
			}
		} else {
			cs.sendMessage(Main.noPerms);
		}
		return false;
	}
}
