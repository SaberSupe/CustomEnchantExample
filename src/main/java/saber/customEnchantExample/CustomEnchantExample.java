package saber.customEnchantExample;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.bukkit.Registry;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomEnchantExample extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // Register listener
        getServer().getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){

        //Get the enchantment registry
        final Registry<Enchantment> enchantmentRegistry = RegistryAccess
                .registryAccess()
                .getRegistry(RegistryKey.ENCHANTMENT);

        //Get our enchant from the registry
        Enchantment helloEnchant = enchantmentRegistry.getOrThrow(TypedKey.create(
                RegistryKey.ENCHANTMENT, Key.key("customenchantexample:hello"))
        );

        //Check if the tool has our enchant
        if (event.getPlayer().getInventory().getItemInMainHand().containsEnchantment(helloEnchant)){

            //Say hello
            event.getPlayer().sendMessage(Component.text("Hello!"));
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
