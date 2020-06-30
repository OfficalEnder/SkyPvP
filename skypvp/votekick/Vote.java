package skypvp.votekick;

import skypvp.Main.Main;
import java.util.HashMap;
import org.bukkit.entity.Player;

public class Vote {
	public static HashMap<Player, String> votes = new HashMap<>();
	public static int ja = 0;
	public static int nein = 0;
	public static boolean voting = false;

	public static void addJa(Player p) {
		if (!votes.containsKey(p)) {
			votes.put(p, p.getName());
			p.sendMessage(Main.Prefix + "§7Du hast fuer §aJa §7gestimmt§8!");
			ja++;
		} else {
			p.sendMessage(Main.Prefix + "§cDu hast bereits gevotet!");
		}
	}

	public static void addNein(Player p) {
		if (!votes.containsKey(p)) {
			votes.put(p, p.getName());
			p.sendMessage(Main.Prefix + "§7Du hast fuer §cNein §7gestimmt§8!");
			nein++;
		} else {
			p.sendMessage(Main.Prefix + "§cDu hast bereits gevotet!");
		}
	}

	public static int getJa() {
		return ja;
	}

	public static int getNein() {
		return nein;
	}
}
