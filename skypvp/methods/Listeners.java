package skypvp.methods;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {
	@EventHandler
	public void onSignCreate(SignChangeEvent e) {
		Player p = e.getPlayer();

		if (e.getLine(0).equalsIgnoreCase("[SP]") && !p.hasPermission("fs.create")) {

			p.sendMessage("§cDu hast keine Berechtigung ein SkyPvP Sign zu erstellen!");
			e.getBlock().setType(Material.AIR);

			return;
		}

		if (e.getLine(2).isEmpty()) {

			e.getBlock().breakNaturally();
			p.sendMessage("§cYou must enter an ItemID!");

			return;
		}
		e.setLine(0, "§8---§c*§8---");
		e.setLine(1, "  §aSky§2PvP ");
		e.setLine(3, "§8---§c*§8---");

		Sign s = (Sign) e.getBlock().getState();
		s.update(true);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void OnInteract(PlayerInteractEvent e) {
		/* 51 */ Player p = e.getPlayer();

		/* 53 */ if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getState() instanceof Sign) {

			/* 55 */ Sign s = (Sign) e.getClickedBlock().getState();

			/* 57 */ if (s.getLine(0).equalsIgnoreCase("§8---§c*§8---")
					&& s.getLine(1).equalsIgnoreCase("  §aSky§2PvP ")
					&& s.getLine(3).equalsIgnoreCase("§8---§c*§8---")) {

				/* 59 */ if (!p.hasPermission("fs.use")) {

					/* 61 */ p.sendMessage("§cDu hast keine Brerechtigung dieses Schild zu benutzen!§c.");

					return;
				}
				try {
					/* 66 */ String[] string = s.getLine(2).split(":");

					/* 68 */ int ID = Integer.valueOf(string[0]).intValue();
					/* 69 */ int Byte = 0;

					if (s.getLine(2).contains(":")) {
						Byte = Integer.valueOf(string[1]).intValue();
					}

					Inventory inv = Bukkit.createInventory(null, 9, "§aSky§2PvP");

					for (int i = 0; i < inv.getSize(); i++) {
						inv.setItem(i, new ItemStack(ID, 1, (byte) Byte));
					}

					/* 81 */ p.openInventory(inv);
				}
				/* 83 */ catch (NumberFormatException ex) {
					/* 84 */ p.sendMessage("§cID not found!");
				}
			}
		}
	}

	public String translateString(String s) {
		/* 92 */ s = s.replaceAll("%double", ":");
		/* 93 */ return s;
	}
}