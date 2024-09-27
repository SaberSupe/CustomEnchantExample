package saber.customEnchantExample;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import io.papermc.paper.registry.data.EnchantmentRegistryEntry;
import io.papermc.paper.registry.event.RegistryEvents;
import io.papermc.paper.registry.keys.tags.ItemTypeTagKeys;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.jetbrains.annotations.NotNull;

public class CustomEnchantExampleBootStrapper implements PluginBootstrap {
    @Override
    public void bootstrap(@NotNull BootstrapContext bootstrapContext) {
        bootstrapContext.getLifecycleManager().registerEventHandler(RegistryEvents.ENCHANTMENT.freeze().newHandler(event -> {
            event.registry().register(
                    // The key of the registry
                    // Plugins should use their own namespace instead of minecraft or papermc
                    TypedKey.create(RegistryKey.ENCHANTMENT, Key.key("customenchantexample:hello")),

                    // The options and what that do can be found at this link:
                    // https://jd.papermc.io/paper/1.21.1/io/papermc/paper/registry/data/EnchantmentRegistryEntry.Builder.html
                    b -> b.description(Component.text("Hello")) // Enchantment name
                            .supportedItems(event.getOrCreateTag(ItemTypeTagKeys.PICKAXES)) // What tools it can be applied to
                            .anvilCost(1)
                            .maxLevel(1) // Max enchant level
                            .weight(1)
                            .minimumCost(EnchantmentRegistryEntry.EnchantmentCost.of(0, 0))
                            .maximumCost(EnchantmentRegistryEntry.EnchantmentCost.of(0, 0))
                            .activeSlots(EquipmentSlotGroup.ANY) // Which slot it is active in. since we are managing it our selves instead of mc, this is irrelevant
            );
        }));
    }
}
