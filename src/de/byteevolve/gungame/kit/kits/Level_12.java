package de.byteevolve.gungame.kit.kits;

import de.byteevolve.gungame.itembuilder.ItemBuilder;
import de.byteevolve.gungame.itembuilder.LeatherBuilder;
import de.byteevolve.gungame.kit.KitInventory;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class Level_12 implements KitInventory {

    @Override
    public void load(Player player) {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.getInventory().setItem(0, new ItemBuilder(Material.GOLD_AXE, 1).setUnbreakable(true).build());
        player.getInventory().setChestplate(new LeatherBuilder(Material.LEATHER_CHESTPLATE,"§3§lLevel §b§l12").setUnbreakable(true).setCount(1).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setColor(Color.TEAL).build());
        player.getInventory().setLeggings(new LeatherBuilder(Material.LEATHER_LEGGINGS,"§3§lLevel §b§l12").setCount(1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setColor(Color.TEAL).build());
        player.getInventory().setBoots(new LeatherBuilder(Material.LEATHER_BOOTS,"§3§lLevel §b§l12").setCount(1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setColor(Color.TEAL).build());
        player.getInventory().setHelmet(new LeatherBuilder(Material.LEATHER_HELMET,"§3§lLevel §b§l12").setCount(1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setColor(Color.TEAL).build());
    }
}
