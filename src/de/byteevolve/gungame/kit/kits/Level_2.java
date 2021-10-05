package de.byteevolve.gungame.kit.kits;

import de.byteevolve.gungame.itembuilder.ItemBuilder;
import de.byteevolve.gungame.itembuilder.LeatherBuilder;
import de.byteevolve.gungame.kit.KitInventory;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Level_2 implements KitInventory {
    @Override
    public void load(Player player) {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.getInventory().setItem(0, new ItemBuilder(Material.WOOD_SWORD, 1).setUnbreakable(true).build());
        player.getInventory().setChestplate(new LeatherBuilder(Material.LEATHER_CHESTPLATE,"§3§lLevel §b§l2").setUnbreakable(true).setCount(1).setColor(Color.TEAL).build());
    }
}
