package skypvp.methods;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {

	public ItemStack createItem(Material m, int amount, String displayname) {
		ItemStack is = new ItemStack(m, amount);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(displayname);
		is.setItemMeta(im);
		return is;

	}

}
