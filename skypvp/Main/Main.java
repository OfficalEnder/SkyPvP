package skypvp.Main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import skypvp.commands.Build;
import skypvp.commands.ChatClear;
import skypvp.commands.FeedCommand;
import skypvp.commands.FlyCMD;
import skypvp.commands.HealCommand;
import skypvp.commands.KitsCMD;
import skypvp.commands.SkyPvP;
import skypvp.commands.SpawnCMD;
import skypvp.commands.StatsReset;
import skypvp.commands.ec;
import skypvp.commands.invsee;
import skypvp.commands.stats;
import skypvp.commands.wb;
import skypvp.events.Block;
import skypvp.events.ClearLag;
import skypvp.events.Damage;
import skypvp.events.InventoryClick;
import skypvp.events.JoinQuit;
import skypvp.events.KillStreak;
import skypvp.events.PlayerDeath;
import skypvp.events.PlayerRespawn;
import skypvp.events.SpawnLocation;
import skypvp.events.Stats;
import skypvp.methods.Listeners;
import skypvp.methods.RespawnLocation;
import skypvp.umfrage.UjaCommand;
import skypvp.umfrage.UmfrageCommand;
import skypvp.umfrage.UneinCommand;
import skypvp.votekick.JaCommand;
import skypvp.votekick.NeinCommand;
import skypvp.votekick.VotekickCommand;

public class Main extends JavaPlugin {

	public static String Prefix = "§l§8[§aSky§2PvP§8] ", noPerms = "§cDir fehlt das nötige Recht für diese Aktion.";

	public static Main plugin;
	public static Main m;

	public static File file = new File("plugins/SkyPvP", "Stats.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	public static void saveFile() {

		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static File file1 = new File("plugins/SkyPvP", "Respawn.yml");
	public static FileConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);

	public SpawnLocation sl = new SpawnLocation();
	public RespawnLocation rl = new RespawnLocation();

	public void onEnable() {

		plugin = this; 
		
		Bukkit.getConsoleSender().sendMessage("§7-----------------------------------------");
		Bukkit.getConsoleSender().sendMessage(Prefix + "§aPlugin erfolgreich aktiviert");
		Bukkit.getConsoleSender().sendMessage(Prefix + "§bDeveloper§7: §7Main: §bEnderReturn");
		Bukkit.getConsoleSender().sendMessage(Prefix + "              §7featuring: §bVyrrex");
		Bukkit.getConsoleSender().sendMessage("§7-----------------------------------------");

		Bukkit.getPluginManager().registerEvents(new Block(), this);
		Bukkit.getPluginManager().registerEvents(new Damage(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
		Bukkit.getPluginManager().registerEvents(new Stats(), this);
		Bukkit.getPluginManager().registerEvents(new SpawnLocation(), this);
		Bukkit.getPluginManager().registerEvents(new KillStreak(), this);
		Bukkit.getPluginManager().registerEvents(new JoinQuit(null), this);
		Bukkit.getPluginManager().registerEvents(new PlayerRespawn(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerDeath(this), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
		Bukkit.getPluginManager().registerEvents(new ClearLag(), this);

		getCommand("kits").setExecutor(new KitsCMD());
		getCommand("spawn").setExecutor(new SpawnCMD(this));
		getCommand("skypvp").setExecutor(new SkyPvP(this));
		getCommand("build").setExecutor(new Build());
		getCommand("fly").setExecutor(new FlyCMD());

		getCommand("cc").setExecutor(new ChatClear());
		getCommand("ec").setExecutor(new ec());
		getCommand("wb").setExecutor(new wb());
		getCommand("feed").setExecutor(new FeedCommand());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("invsee").setExecutor(new invsee());
		getCommand("stats").setExecutor(new stats());
		getCommand("reset").setExecutor(new StatsReset());

		getCommand("votekick").setExecutor((CommandExecutor) new VotekickCommand());
		getCommand("ja").setExecutor((CommandExecutor) new JaCommand());
		getCommand("nein").setExecutor((CommandExecutor) new NeinCommand());

		getCommand("unein").setExecutor((CommandExecutor) new UneinCommand());
		getCommand("uja").setExecutor((CommandExecutor) new UjaCommand());
		getCommand("umfrage").setExecutor((CommandExecutor) new UmfrageCommand());
		
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§7-----------------------------------------");
		Bukkit.getConsoleSender().sendMessage(Prefix + "§cPlugin erfolgreich deaktiviert");
		Bukkit.getConsoleSender().sendMessage(Prefix + "§bDeveloper§7: §7Main: §b§lEnderReturn");
		Bukkit.getConsoleSender().sendMessage(Prefix + "               §7featuring: §bVyrrex");
		Bukkit.getConsoleSender().sendMessage("§7-----------------------------------------");

	}

	public static Plugin getInstance() {
		return (Plugin) getPlugin(Main.class);
	}

}