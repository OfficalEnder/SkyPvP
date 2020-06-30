package skypvp.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import skypvp.Main.Main;

public class Build implements CommandExecutor {

	public static ArrayList<Player> allow = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		if (p.hasPermission("skypvp.build")) {

			if (allow.contains(p)) {

				allow.remove(p);
				p.sendMessage(Main.Prefix + "§aDu kannst nun nicht mehr bauen");

			} else {

				allow.add(p);
				p.sendMessage(Main.Prefix + "§aDu kannst nun bauen");

			}

		} else {

			p.sendMessage(Main.noPerms);

		}

		return false;
	}

}
