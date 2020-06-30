package skypvp.commands; //Workbench

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import skypvp.Main.Main;

public class wb implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player) s;

		if (p.hasPermission("skypvp.wb")) {
			if (args.length == 0) {
				p.openWorkbench(null, true);
			} else {
				p.sendMessage(Main.Prefix + "§cBitte nutze den Command /wb");
			}
		} else {
			p.sendMessage(Main.noPerms);
		}

		return false;
	}

}