package skypvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import skypvp.Main.Main;

public class FeedCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player) s;

		if (args.length == 0)
			Feed(p, true);
		else if (Bukkit.getPlayer(args[0]) != null)
			FeedOther(p, Bukkit.getPlayer(args[0]));
		else
			p.sendMessage(Main.Prefix + "§cDer Spieler " + args[0] + " ist nicht online!");
		return false;
	}

	private void Feed(Player p, boolean self) {	//Permission zum stillen des eigenen Hungers
		if (self && !p.hasPermission("skypvp.feed")) {
			p.sendMessage(Main.noPerms);
			return;
		}
		p.setFoodLevel(20);
		p.sendMessage(Main.Prefix + "§aDein essen wurde wieder aufgefüllt!");
	}

	private void FeedOther(Player p, Player t) { //Permission zum stillen anderer
		if (!p.hasPermission("skypvp.feed.other")) {
			p.sendMessage(Main.noPerms);
			return;
		}
		if (p == t)
			Feed(p, true);
		else {
			Feed(t, false);
			p.sendMessage(Main.Prefix + "§aDu hast §6§l" + t.getName() + "§a gesättigt!");
		}
	}
}