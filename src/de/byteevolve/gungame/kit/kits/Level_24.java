package de.byteevolve.gungame.kit.kits;

import de.byteevolve.gungame.itembuilder.ItemBuilder;
import de.byteevolve.gungame.kit.KitInventory;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class Level_24 implements KitInventory {

    @Override
    public void load(Player player) {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.getInventory().setItem(0, new ItemBuilder(Material.STONE_AXE, 1).setUnbreakable(true).build());
        player.getInventory().setChestplate(new ItemBuilder(Material.GOLD_CHESTPLATE,1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setName("§3§lLevel §b§l24").build());
        player.getInventory().setLeggings(new ItemBuilder(Material.GOLD_LEGGINGS,1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setName("§3§lLevel §b§l24").build());
        player.getInventory().setBoots(new ItemBuilder(Material.GOLD_BOOTS,1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setName("§3§lLevel §b§l24").build());
        player.getInventory().setHelmet(new ItemBuilder(Material.GOLD_HELMET,1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setName("§3§lLevel §b§l24").build());
    }
}
