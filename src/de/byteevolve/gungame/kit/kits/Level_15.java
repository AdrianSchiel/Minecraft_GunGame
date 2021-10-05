package de.byteevolve.gungame.kit.kits;

import de.byteevolve.gungame.itembuilder.ItemBuilder;
import de.byteevolve.gungame.itembuilder.LeatherBuilder;
import de.byteevolve.gungame.kit.KitInventory;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class Level_15 implements KitInventory {

    @Override
    public void load(Player player) {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.getInventory().setItem(0, new ItemBuilder(Material.GOLD_SWORD, 1).setUnbreakable(true).build());
        player.getInventory().setChestplate(new ItemBuilder(Material.GOLD_CHESTPLATE,1).setName("§3§lLevel §b§l15").setUnbreakable(true).build());
        player.getInventory().setLeggings(new LeatherBuilder(Material.LEATHER_LEGGINGS,"§3§lLevel §b§l15").setCount(1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setColor(Color.TEAL).build());
        player.getInventory().setBoots(new ItemBuilder(Material.GOLD_BOOTS,1).setName("§3§lLevel §b§l15").setUnbreakable(true).build());
        player.getInventory().setHelmet(new LeatherBuilder(Material.LEATHER_HELMET,"§3§lLevel §b§l15").setCount(1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setColor(Color.TEAL).build());
    }
}
