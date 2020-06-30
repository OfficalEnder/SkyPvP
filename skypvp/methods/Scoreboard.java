package skypvp.methods;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

import skypvp.Main.Main;
import skypvp.events.KillStreak;
import skypvp.events.Stats;

public class Scoreboard {

	public Scoreboard(Player p) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
				Objective objective = board.registerNewObjective("abcd", "abcd");
				objective.setDisplaySlot(DisplaySlot.SIDEBAR);
				objective.setDisplayName("§a§lSky§2PvP");

				objective.getScore(" ").setScore(10);
				objective.getScore("§b§lK/D:").setScore(9);
				objective.getScore(" §c" + (double)(Stats.getKills(p.getName()) / Stats.getDeaths(p.getName()))).setScore(8);
				objective.getScore("  ").setScore(7);
				objective.getScore("§6§lStreak:").setScore(6);
				objective.getScore(" §6" + KillStreak.killstreak.get(p.getName())).setScore(5);;
				objective.getScore("   ").setScore(4);
				objective.getScore("§e§lOnline:").setScore(3);;
				objective.getScore("§e" + Bukkit.getOnlinePlayers().size()).setScore(2);
				objective.getScore("    ").setScore(1);;
				p.setScoreboard(board);
			}
		}, 0, 20 * 5);
	}
}