package de.byteevolve.gungame.kit.kits;

import de.byteevolve.gungame.itembuilder.ItemBuilder;
import de.byteevolve.gungame.kit.KitInventory;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class Level_48 implements KitInventory {

    @Override
    public void load(Player player) {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.getInventory().setItem(0, new ItemBuilder(Material.DIAMOND_AXE, 1).setUnbreakable(true).build());
        player.getInventory().setChestplate(new ItemBuilder(Material.IRON_CHESTPLATE,1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setName(" ").build());
        player.getInventory().setLeggings(new ItemBuilder(Material.IRON_LEGGINGS,1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setName(" ").build());
        player.getInventory().setBoots(new ItemBuilder(Material.IRON_BOOTS,1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setName(" ").build());
        player.getInventory().setHelmet(new ItemBuilder(Material.IRON_HELMET,1).setUnbreakable(true).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1).setName(" ").build());
    }
}
