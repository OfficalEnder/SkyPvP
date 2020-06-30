package skypvp.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import skypvp.Main.Main;
import skypvp.methods.Scoreboard;

public class JoinQuit implements Listener {

	private Main plugin;

	public JoinQuit(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		for(Player all : Bukkit.getOnlinePlayers()) new Scoreboard(all);
		
		if(!KillStreak.killstreak.containsKey(p.getName())) KillStreak.killstreak.put(p.getName(), 0);
		
		e.setJoinMessage(null);
		try {
			this.plugin.sl.onSpawnLocation(p.getPlayer());
		} catch(Exception exception) {
		}

				p.setHealth(20);
				p.setLevel(0);
				p.setFoodLevel(20);
				p.setExp(0);
				p.setGameMode(GameMode.SURVIVAL);
				p.setFlying(false);
				p.setAllowFlight(false);

				ItemStack ss = new ItemStack(Material.STONE_SWORD);
				ItemMeta im = ss.getItemMeta();
				im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				im.addEnchant(Enchantment.DURABILITY, 1, true);
				ss.setItemMeta(im);
				p.getInventory().setItem(0, ss);

				ItemStack angel = new ItemStack(Material.FISHING_ROD);
				ItemMeta im1 = angel.getItemMeta();
				im1.addEnchant(Enchantment.DURABILITY, 1, true);
				angel.setItemMeta(im1);
				p.getInventory().setItem(1, angel);

				ItemStack food = new ItemStack(Material.COOKED_CHICKEN, 20);
				p.getInventory().setItem(2, food);

				ItemStack ch = new ItemStack(Material.CHAINMAIL_HELMET);
				ItemMeta im2 = ch.getItemMeta();
				im2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				im2.addEnchant(Enchantment.DURABILITY, 1, true);
				ch.setItemMeta(im2);
				p.getInventory().setHelmet(ch);

				ItemStack ic = new ItemStack(Material.IRON_CHESTPLATE);
				ItemMeta im3 = ic.getItemMeta();
				im3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				im2.addEnchant(Enchantment.DURABILITY, 1, true);
				ic.setItemMeta(im3);
				p.getInventory().setChestplate(ic);

				ItemStack cl = new ItemStack(Material.CHAINMAIL_LEGGINGS);
				ItemMeta im4 = cl.getItemMeta();
				im4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				im4.addEnchant(Enchantment.DURABILITY, 1, true);
				cl.setItemMeta(im4);
				p.getInventory().setLeggings(cl);

				ItemStack cb = new ItemStack(Material.CHAINMAIL_BOOTS);
				ItemMeta im5 = cb.getItemMeta();
				im5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				im5.addEnchant(Enchantment.DURABILITY, 1, true);
				cb.setItemMeta(im5);
				p.getInventory().setBoots(cb);

				try {
					this.plugin.sl.onSpawnLocation(p.getPlayer());
				} catch(Exception exceptioin2) {
				}
		if(p.hasPermission("skypvp.team")) e.setJoinMessage(Main.Prefix + p.getDisplayName() + " §ahat den Server §2§lbetreten§8!"); 
			else e.setJoinMessage(Main.Prefix + "§8[§a+§8] §7" + p.getName());
		}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
	     Player p = e.getPlayer();
	     if (p.hasPermission("skypvp.team")) {
	       e.setQuitMessage(Main.Prefix + p.getDisplayName() + " §chat den Server §4§lverlassen§8!");
	     } else {
	       e.setQuitMessage(Main.Prefix + "§8[§c-§8] §7" + p.getName());
	     }	
	}
}