package net.isaiah.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.isaiah.mccourse.MCCourseMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FLUORITE = registerItem("fluorite");
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite");

    private static Item registerItem(String name) {
        return Items.register(
                RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MCCourseMod.MOD_ID, name)),
                Item::new,
                new Item.Settings()
        );
    }

    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(FLUORITE);
        entries.add(RAW_FLUORITE);
    }


    public static void registerModItems() {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
    }
}
