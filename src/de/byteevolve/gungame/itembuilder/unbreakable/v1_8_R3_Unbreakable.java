package de.byteevolve.gungame.itembuilder.unbreakable;

import net.minecraft.server.v1_8_R3.NBTTagByte;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class v1_8_R3_Unbreakable implements Unbreakable{

    @Override
    public ItemStack makeUnbreakable(ItemStack itemStack) {
        net.minecraft.server.v1_8_R3.ItemStack nmsstack = CraftItemStack.asNMSCopy(itemStack);
        NBTTagCompound tag = new NBTTagCompound();
        tag.set("Unbreakable", new NBTTagByte((byte) 1));
        nmsstack.setTag(tag);
        return CraftItemStack.asBukkitCopy(nmsstack);
    }
}
