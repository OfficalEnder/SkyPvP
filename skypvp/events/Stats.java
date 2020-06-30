package skypvp.events;

import org.bukkit.event.Listener;

import skypvp.Main.Main;

public class Stats implements Listener {

	public static void setKills(String name, int amount) {

		Main.cfg.set(name + ".Kills", Integer.valueOf(amount));
		Main.saveFile();

	}

	public static void addKills(String name, int amount) {

		Main.cfg.set(name + ".Kills", Integer.valueOf(getKills(name) + amount));
		Main.saveFile();

	}

	public static void removeKills(String name, int amount) {

		Main.cfg.set(name + ".Kills", Integer.valueOf(getKills(name) + amount));
		Main.saveFile();
	}

	public static Integer getKills(String name) {

		return Main.cfg.getInt(name + ".Kills");

	}

	public static void setDeaths(String name, int amount) {

		Main.cfg.set(name + ".Deaths", Integer.valueOf(amount));
		Main.saveFile();

	}

	public static void addDeaths(String name, int amount) {

		Main.cfg.set(name + ".Deaths", Integer.valueOf(getDeaths(name) + amount));
		Main.saveFile();

	}

	public static void removeDeaths(String name, int amount) {

		Main.cfg.set(name + ".Deaths", Integer.valueOf(getDeaths(name) + amount));
		Main.saveFile();
	}

	public static Integer getDeaths(String name) {

		return Main.cfg.getInt(name + ".Deaths");

	}
//
//	public static void removeCoins(String name, int amount) {
//
//		Main.cfg.set(name + ".Coins", Integer.valueOf(getCoins(name) + amount));
//		Main.saveFile();
//
//	}
//
//	public static Integer getCoins(String name) {
//
//		return Main.cfg.getInt(name + ".Coins");
//
//	}
//
//	public static void addCoins(String name, int amount) {
//
//		Main.cfg.set(name + ".Coins", Integer.valueOf(getCoins(name) + amount));
//		Main.saveFile();
//
//	}
}
