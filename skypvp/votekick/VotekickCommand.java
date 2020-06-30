package skypvp.votekick;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import skypvp.Main.Main;

public class VotekickCommand implements CommandExecutor {
	 
  int counter;
  int time = 30;
  int left = time;

  
  public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
	   if (cs instanceof Player) {
		   Player p = (Player)cs;
		   if (p.hasPermission("skypvp.votekick")) {
			   if (args.length >= 2) {
				   String reason = "";
				   for (int i = 1; i < args.length; i++) reason = reason + args[i] + " ";
				   final Player t = Bukkit.getPlayer(args[0]);
				   if (t != null) {
					   if (!t.hasPermission("skypvp.votekick.bypass")) {
						   if (!Vote.voting) {
							   Vote.voting = true;
							   Bukkit.broadcastMessage(" ");
							   Bukkit.broadcastMessage(Main.Prefix + "�7Es wurde ein �eVotekick �7gestartet�8!");
							   Bukkit.broadcastMessage(Main.Prefix + "�7Beschuldigter�8: �e" + t.getName());
							   Bukkit.broadcastMessage(Main.Prefix + "�7Ersteller�8: �e" + p.getName());
							   Bukkit.broadcastMessage(Main.Prefix + "�7Grund�8: �e" + reason);
							   Bukkit.broadcastMessage(Main.Prefix + "�7Stimme ab mit �a/ja �7oder �c/nein�8!");
							   Bukkit.broadcastMessage(" ");
							   counter = Integer.valueOf(Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
								   public void run() {
									   left--;
									   switch(left) {
									   case 20: case 10: case 5: case 4: case 3: case 2:
										   Bukkit.broadcastMessage(Main.Prefix + "�7Die �eAbstimmung �7endet in �6�l" + left + " Sekunden�7!");
										   break;
									   case 1:
										   Bukkit.broadcastMessage(Main.Prefix + "�7Die �eAbstimmung �7endet in �6�leiner Sekunde�7!");
										   break;
									   case 0:
										   Bukkit.broadcastMessage(Main.Prefix + "Die �eAbstimmung �7ist vorbei�8!");
										   Bukkit.broadcastMessage(Main.Prefix + "Stimmen f�r �aJa�8: �e" + Vote.getJa());
										   Bukkit.broadcastMessage(Main.Prefix + "Stimmen f�r �cNein�8: �e" + Vote.getNein());
										   Vote.voting = false;
										   Vote.votes.clear();
										   if (Vote.getJa() < Vote.getNein()) {
											   Bukkit.broadcastMessage(Main.Prefix + "�7Der Spieler wurde �cnicht �7bestraft�8!");
										   } else if (Vote.getJa() > Vote.getNein()) {
											   Bukkit.broadcastMessage(Main.Prefix + "�7Der Spieler wurde �cbestraft�8!");
											   t.kickPlayer(Main.Prefix + "�cDu wurdest gekickt! \n �7Grund�8: \n �eVotekick Bestrafung");
										   } else if (Vote.getJa() == Vote.getNein()) {
											   Bukkit.broadcastMessage(Main.Prefix + "�c�nUnentschieden�8!");
											   Bukkit.broadcastMessage(Main.Prefix + "�7Der Spieler wurde �cnicht �7bestraft�8!");
										   } 
										   left = time;
										   Vote.ja = 0;
										   Vote.nein = 0;
										   Bukkit.getScheduler().cancelTask(counter);
										   break;
									   default:
										   break;
									   }
								   }
							   },  0L, 20L));
						   } else p.sendMessage(Main.Prefix + "�cEs läuft derzeit ein Votekick!");
					   } else p.sendMessage(Main.Prefix + "�cDu kannst diesen Spieler nicht kicken!");
				   } else p.sendMessage(Main.Prefix + "�7Der Spieler �e" + args[0] + " �7existiert �cnicht�8!");
			   } else p.sendMessage(Main.Prefix + "�7Benutze �c/votekick <Spieler> <Grund>");
		   } else p.sendMessage(Main.noPerms);
	   } else cs.sendMessage(Main.noPerms);
	   return false;
  }
}
