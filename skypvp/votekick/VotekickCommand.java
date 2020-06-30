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
							   Bukkit.broadcastMessage(Main.Prefix + "ß7Es wurde ein ßeVotekick ß7gestartetß8!");
							   Bukkit.broadcastMessage(Main.Prefix + "ß7Beschuldigterß8: ße" + t.getName());
							   Bukkit.broadcastMessage(Main.Prefix + "ß7Erstellerß8: ße" + p.getName());
							   Bukkit.broadcastMessage(Main.Prefix + "ß7Grundß8: ße" + reason);
							   Bukkit.broadcastMessage(Main.Prefix + "ß7Stimme ab mit ßa/ja ß7oder ßc/neinß8!");
							   Bukkit.broadcastMessage(" ");
							   counter = Integer.valueOf(Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
								   public void run() {
									   left--;
									   switch(left) {
									   case 20: case 10: case 5: case 4: case 3: case 2:
										   Bukkit.broadcastMessage(Main.Prefix + "ß7Die ßeAbstimmung ß7endet in ß6ßl" + left + " Sekundenß7!");
										   break;
									   case 1:
										   Bukkit.broadcastMessage(Main.Prefix + "ß7Die ßeAbstimmung ß7endet in ß6ßleiner Sekundeß7!");
										   break;
									   case 0:
										   Bukkit.broadcastMessage(Main.Prefix + "Die ßeAbstimmung ß7ist vorbeiß8!");
										   Bukkit.broadcastMessage(Main.Prefix + "Stimmen f¸r ßaJaß8: ße" + Vote.getJa());
										   Bukkit.broadcastMessage(Main.Prefix + "Stimmen f¸r ßcNeinß8: ße" + Vote.getNein());
										   Vote.voting = false;
										   Vote.votes.clear();
										   if (Vote.getJa() < Vote.getNein()) {
											   Bukkit.broadcastMessage(Main.Prefix + "ß7Der Spieler wurde ßcnicht ß7bestraftß8!");
										   } else if (Vote.getJa() > Vote.getNein()) {
											   Bukkit.broadcastMessage(Main.Prefix + "ß7Der Spieler wurde ßcbestraftß8!");
											   t.kickPlayer(Main.Prefix + "ßcDu wurdest gekickt! \n ß7Grundß8: \n ßeVotekick Bestrafung");
										   } else if (Vote.getJa() == Vote.getNein()) {
											   Bukkit.broadcastMessage(Main.Prefix + "ßcßnUnentschiedenß8!");
											   Bukkit.broadcastMessage(Main.Prefix + "ß7Der Spieler wurde ßcnicht ß7bestraftß8!");
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
						   } else p.sendMessage(Main.Prefix + "ßcEs l√§uft derzeit ein Votekick!");
					   } else p.sendMessage(Main.Prefix + "ßcDu kannst diesen Spieler nicht kicken!");
				   } else p.sendMessage(Main.Prefix + "ß7Der Spieler ße" + args[0] + " ß7existiert ßcnichtß8!");
			   } else p.sendMessage(Main.Prefix + "ß7Benutze ßc/votekick <Spieler> <Grund>");
		   } else p.sendMessage(Main.noPerms);
	   } else cs.sendMessage(Main.noPerms);
	   return false;
  }
}
