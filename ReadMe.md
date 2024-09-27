 # Custom Enchant Example  
This plugin makes an enchant called hello which can be applied to pickaxes and will send the player a "hello" message when they break a block with the pick  
  
When making your own enchant plugin, remember to put your bootstrapper into the paper-plugin.yml
  
The enchantment can be applied to a held pickaxe using the following command:  
/enchant @s customenchantexample:hello  
  
or in code using item.addEnchantment  
  
Paper has a tutorial on registries at the link below as well as javadocs if you need more info:  
https://docs.papermc.io/paper/dev/registries  
https://jd.papermc.io/paper/1.21.1/io/papermc/paper/registry/package-summary.html