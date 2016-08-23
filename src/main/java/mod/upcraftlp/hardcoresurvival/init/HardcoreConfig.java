package mod.upcraftlp.hardcoresurvival.init;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class HardcoreConfig {

	private static final String CATEGORY_GAME_TWEAKS = "Game Tweaks";
	
	public static int stickChance;
	public static int saplingChance;
	
	public static boolean disableWoodenTools;
	public static boolean enableFlintTools;
	public static boolean enableBranches;
	public static boolean woodRequiresAxe;
	public static boolean enableUpdateChecker;
	public static boolean extraDrops;
	public static int extraChance;
	public static boolean enableQuicksand;
	public static boolean sand_pits;
	
	public static void init(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile()); 
		config.load();
		
		//General
		stickChance = config.getInt("stickDrops", Configuration.CATEGORY_GENERAL, 5, 1, 16384, "Chance to drop sticks, chance is 1/n leaf blocks");
		saplingChance = config.getInt("saplingDrops", Configuration.CATEGORY_GENERAL, 7, 1, 16384, "Chance to drop saplings, chance is 1/n leaf blocks");
		extraChance = config.getInt("extraDropChance", Configuration.CATEGORY_GENERAL, 5, 1, 16384, "chance to get extra drops, chance is 1/n leaf blocks");
		sand_pits = config.getBoolean("sand_pits", Configuration.CATEGORY_GENERAL, true, "if enabled, will generate quicksand pits (only if quicksand is enabled!)");
		enableUpdateChecker = config.getBoolean("enableUpdateChecker", Configuration.CATEGORY_GENERAL, true, "false to disable mod update checker");
		
		//Game Tweaks
		disableWoodenTools = config.getBoolean("disableWoodenTools", HardcoreConfig.CATEGORY_GAME_TWEAKS, true, "disable crafting of vanilla wooden tools");
		enableFlintTools = config.getBoolean("enableFintTools", HardcoreConfig.CATEGORY_GAME_TWEAKS, true, "enable mod flint tools, same stats as wooden tools");
		enableBranches = config.getBoolean("enableBranches", HardcoreConfig.CATEGORY_GAME_TWEAKS, true, "add branches to drop from leaves instead of sticks (they just can be used as sticks)");
		woodRequiresAxe = config.getBoolean("woodRequiresAxe", HardcoreConfig.CATEGORY_GAME_TWEAKS, true, "make wood blocks require an Axe");
		extraDrops = config.getBoolean("enableExtraDrops", HardcoreConfig.CATEGORY_GAME_TWEAKS, true, "enable/disable extra drops (acorns, pine cones, cocoa beans, etc.) from leaves");
		enableQuicksand = config.getBoolean("enableQuicksand", HardcoreConfig.CATEGORY_GAME_TWEAKS, true, "enable/disable quicksand");
		config.setCategoryRequiresMcRestart(CATEGORY_GAME_TWEAKS, true);
		config.save();
	}
	
	
}
