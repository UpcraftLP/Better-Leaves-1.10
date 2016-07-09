package mod.upcraftlp.betterleaves.init;

import java.util.Iterator;

import mod.upcraftlp.betterleaves.util.SysUtils;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class LeafCrafting {

	public static void registerOres()
	{
		OreDictionary.registerOre("stick", Items.STICK);
		if(LeafConfig.enableBranches) OreDictionary.registerOre("stick", LeafItems.BRANCH);
	}
	
	public static void init()
	{
		if(LeafConfig.enableFlintTools)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LeafItems.FLINT_AXE, 1), "FF ", "FS ", " S ", 'F', Items.FLINT, 'S', "stick").setMirrored(true));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LeafItems.FLINT_HOE, 1), "FF", " S", " S", 'F', Items.FLINT, 'S', "stick").setMirrored(true));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LeafItems.FLINT_PICKAXE, 1), "FFF", " S ", " S ", 'F', Items.FLINT, 'S', "stick"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LeafItems.FLINT_SHOVEL, 1), "F", "S", "S", 'F', Items.FLINT, 'S', "stick"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LeafItems.FLINT_SWORD, 1), "F", "F", "S", 'F', Items.FLINT, 'S', "stick"));
		}
		
		if(LeafConfig.extraDrops)
		{
			GameRegistry.addSmelting(new ItemStack(LeafItems.PINE_CONE,  1, 0), new ItemStack(LeafItems.PINE_CONE, 1, 1), 0.2f);
		}
	}
	
	public static void disableWoodTools()
	{
		if(LeafConfig.disableWoodenTools)
		{		
			int removed = 0;
			if(CraftingManager.getInstance().getRecipeList().isEmpty()) return;
			Iterator<IRecipe> recipes = CraftingManager.getInstance().getRecipeList().iterator();	          
			while (recipes.hasNext()) {
				IRecipe currentRecipe = recipes.next();
				ItemStack result = currentRecipe.getRecipeOutput();
				if(result != null)
				{
					if(isRecipe(result, Items.WOODEN_AXE) || isRecipe(result, Items.WOODEN_HOE) || isRecipe(result, Items.WOODEN_PICKAXE) || isRecipe(result, Items.WOODEN_SHOVEL) || isRecipe(result, Items.WOODEN_SWORD)) {
						
						removed++;
						SysUtils.println("Removed recipe for " + result.getDisplayName());
						recipes.remove();
						
					}
				}			
			}
			 SysUtils.println("Removed " + removed + " recipes in total.");
		}
		
	}
	
	private static boolean isRecipe(ItemStack result, Item toTest)
	{
		return  result.isItemEqual(new ItemStack(toTest, 1));
	}

	
	
}
