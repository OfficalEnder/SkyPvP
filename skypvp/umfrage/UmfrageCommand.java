package skypvp.umfrage;

import skypvp.Main.Main;
import skypvp.votekick.Vote;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UmfrageCommand implements CommandExecutor {
	Integer counter;
	int time = 31;

	public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (p.hasPermission("skypvp.umfrage")) {
				if (args.length >= 1) {
					String reason = "";
					for (int i = 0; i < args.length; i++) {
						reason = reason + args[i] + " ";
					}
					if (!Vote.voting) {
						Vote.voting = true;
						Bukkit.broadcastMessage(" ");
						Bukkit.broadcastMessage(Main.Prefix + "Es wurde eine §eUmfrage §7gestartet§8!");
						Bukkit.broadcastMessage(Main.Prefix + "Frage§8: §e" + reason);
						Bukkit.broadcastMessage(Main.Prefix + "Stimme ab mit §a/uja §7oder §c/unein§8!");
						Bukkit.broadcastMessage(" ");
						this.counter = Integer.valueOf(
								Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
									public void run() {
										UmfrageCommand.this.time--;
										if (UmfrageCommand.this.time == 20) {
											Bukkit.broadcastMessage(Main.Prefix + "§7Die §eUmfrage §7endet in §e"
													+ UmfrageCommand.this.time + " §7Sekunden§8!");
										}

										if (UmfrageCommand.this.time == 10) {
											Bukkit.broadcastMessage(Main.Prefix + "§7Die §eUmfrage §7endet in §e"
													+ UmfrageCommand.this.time + " §7Sekunden§8!");
										}

										if (UmfrageCommand.this.time == 5) {
											Bukkit.broadcastMessage(Main.Prefix + "§7Die §eUmfrage §7endet in §e"
													+ UmfrageCommand.this.time + " §7Sekunden§8!");
										}

										if (UmfrageCommand.this.time == 4) {
											Bukkit.broadcastMessage(Main.Prefix + "§7Die §eUmfrage §7endet in §e"
													+ UmfrageCommand.this.time + " §7Sekunden§8!");
										}

										if (UmfrageCommand.this.time == 3) {
											Bukkit.broadcastMessage(Main.Prefix + "§7Die §eUmfrage §7endet in §e"
													+ UmfrageCommand.this.time + " §7Sekunden§8!");
										}

										if (UmfrageCommand.this.time == 2) {
											Bukkit.broadcastMessage(Main.Prefix + "§7Die §eUmfrage §7endet in §e"
													+ UmfrageCommand.this.time + " §7Sekunden§8!");
										}

										if (UmfrageCommand.this.time == 1) {
											Bukkit.broadcastMessage(
													Main.Prefix + "§7Die §eUmfrage §7endet in §eeiner §7Sekunde§8!");
										}

										if (UmfrageCommand.this.time == 0) {
											Bukkit.broadcastMessage(Main.Prefix + "§7Die §eUmfrage §7ist vorbei§8!");
											Bukkit.broadcastMessage(
													Main.Prefix + "§7Stimmen fuer §aJa§8: §e" + Vote.getJa());
											Bukkit.broadcastMessage(
													Main.Prefix + "§7Stimmen fuer §cNein§8: §e" + Vote.getNein());
											Vote.voting = false;
											Vote.votes.clear();
											if (Vote.getJa() == Vote.getNein()) {
												Bukkit.broadcastMessage(Main.Prefix + "§c§nUnentschieden§8!");
											}
											Vote.ja = 0;
											Vote.nein = 0;
										}
									}
								}, 0L, 20L));
					} else {
						p.sendMessage(Main.Prefix + "§cEs laeuft derzeit eine Umfrage oder ein Votekick!");
					}
				} else {
					p.sendMessage(Main.Prefix + "§7Benutze §c/umfrage <Frage>");
				}
			} else {
				p.sendMessage(Main.noPerms);
			}
		} else {
			cs.sendMessage(Main.noPerms);
		}
		return false;
	}
}
