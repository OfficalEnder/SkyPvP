package skypvp.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import skypvp.Main.Main;

public class HealCommand implements CommandExecutor {
	
	List<Player> cooldown = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player)s;
		
		if(!cooldown.contains(p)) { //Beginn des Cooldowns von 30 Sekunden zum Spamschutz
			if(args.length == 0) Heal(p, true); else if(Bukkit.getPlayer(args[0]) != null) HealOther(p, Bukkit.getPlayer(args[0])); 
				else p.sendMessage(Main.Prefix + "§cDer Spieler " + args[0] + " ist nicht online!");
			cooldown.add(p);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				
				@Override
				public void run() {
					cooldown.remove(p);
				}
			}, 20*30);
		} else p.sendMessage(Main.Prefix + "§cBitte spamme den Befehl nicht!");
		return false;
	}
	
	private void Heal(Player p, boolean self) {	//Heal Command für sich selbst
		if(self && !p.hasPermission("skypvp.heal")) {
			p.sendMessage(Main.noPerms);
			return;
		}
		p.setHealth(p.getMaxHealth());
		p.setFoodLevel(20);
		p.sendMessage(Main.Prefix + "§aDu wurdest geheilt!");
	}
	
	private void HealOther(Player p, Player t) {	//Heal Command um andere zu heilen
		if(!p.hasPermission("skypvp.heal.other")) {
			p.sendMessage(Main.noPerms);
			return;
		}
		if(p == t) Heal(p, true); else {
			Heal(t, false);
			p.sendMessage(Main.Prefix + "§aDu hast §6§l" + t.getName() + "§a geheilt!");
		}
	}
}