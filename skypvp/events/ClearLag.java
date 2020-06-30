package skypvp.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import skypvp.Main.Main;

public class ClearLag implements Listener {
	
	int time = 60*4;
	int left = time;

	public ClearLag() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
			
			@Override
			public void run() {
				left--;
				switch(left) {
					case 30: case 20: case 10: case 5: case 4: case 3: case 2:
						for(Player all : Bukkit.getOnlinePlayers()) all.sendMessage(Main.Prefix + "§cAlle Items werden in §6§l" + left + " Sekunde §cgelöscht");
						break;
					case 1:
						for(Player all : Bukkit.getOnlinePlayers()) all.sendMessage(Main.Prefix + "§cAlle Items werden in §6§leiner Sekunde §cgelöscht");
						break;
					case 0:
						left = time;
						for(World worlds : Bukkit.getWorlds()) {
							for(Entity all : worlds.getEntities()) {
								if(all.getType() == EntityType.DROPPED_ITEM) {
									all.remove();
								}
							}
						}
						for(Player all : Bukkit.getOnlinePlayers()) all.sendMessage(Main.Prefix + "§cAlle Items wurden gelöscht!");
						break;
					default:
						break;
				}
			}
		}, 20, 20);
	}
}
