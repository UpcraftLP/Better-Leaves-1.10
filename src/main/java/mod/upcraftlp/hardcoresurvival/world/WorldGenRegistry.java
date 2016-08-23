package mod.upcraftlp.hardcoresurvival.world;

import java.util.ArrayList;
import java.util.List;

public class WorldGenRegistry {

	private static List<IWorldChunkGenerator> overworld = new ArrayList<IWorldChunkGenerator>();
	private static List<IWorldChunkGenerator> hell = new ArrayList<IWorldChunkGenerator>();
	private static List<IWorldChunkGenerator> sky = new ArrayList<IWorldChunkGenerator>();
	
	public static void init() {
		overworld.add(new ChunkGenQuicksand());
	}
	
	public static List<IWorldChunkGenerator> getGeneratorsOverworld() {
		return overworld;
	}
	
	public static List<IWorldChunkGenerator> getGeneratorsNether() {
		return hell;
	}
	
	public static List<IWorldChunkGenerator> getGeneratorsEnd() {
		return sky;
	}
}
