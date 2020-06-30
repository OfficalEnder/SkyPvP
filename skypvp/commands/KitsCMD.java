package skypvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import skypvp.Main.Main;

public class KitsCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

		Player p = (Player) s;

		if (args.length == 0) {

			ItemStack i = new ItemStack(Material.BRICK);
			ItemMeta im = i.getItemMeta();
			im.setDisplayName("§6Bronze");
			i.setItemMeta(im);

			ItemStack i2 = new ItemStack(Material.IRON_INGOT);
			ItemMeta im2 = i2.getItemMeta();
			im2.setDisplayName("§7Silver");
			i2.setItemMeta(im2);

			ItemStack i3 = new ItemStack(Material.GOLD_INGOT);
			ItemMeta im3 = i3.getItemMeta();
			im3.setDisplayName("§eGold");
			i3.setItemMeta(im3);

			ItemStack i4 = new ItemStack(Material.DIAMOND);
			ItemMeta im4 = i4.getItemMeta();
			im4.setDisplayName("§3Diamond");
			i4.setItemMeta(im4);

			ItemStack i5 = new ItemStack(Material.EMERALD);
			ItemMeta im5 = i5.getItemMeta();
			im5.setDisplayName("§aEmerald");
			i5.setItemMeta(im5);

			ItemStack i6 = new ItemStack(Material.REDSTONE);
			ItemMeta im6 = i6.getItemMeta();
			im6.setDisplayName("§l§cPhoenix");
			i6.setItemMeta(im6);

			ItemStack i7 = new ItemStack(Material.NETHER_STAR);
			ItemMeta im7 = i7.getItemMeta();
			im7.setDisplayName("§l§aXenon§2Pro");
			i7.setItemMeta(im7);

			Inventory inv = Bukkit.getServer().createInventory(null, 27, "§8Wähle dein Kit");

			inv.setItem(9, i);
			inv.setItem(2, i2);
			inv.setItem(4, i3);
			inv.setItem(6, i4);
			inv.setItem(17, i5);
			inv.setItem(21, i6);
			inv.setItem(23, i7);

			p.openInventory(inv);

		} else {
			p.sendMessage(Main.Prefix + "§cBitte nutze den Command /kits");
		}

		return false;
	}

}