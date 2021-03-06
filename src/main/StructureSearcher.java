package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import amidst.mojangapi.world.World;
import amidst.mojangapi.world.biome.Biome;
import amidst.mojangapi.world.coordinates.CoordinatesInWorld;
import amidst.mojangapi.world.icon.WorldIcon;


public class StructureSearcher {
	
	World world;
	public CoordinatesInWorld origin = world.getSpawnWorldIcon().getCoordinates();
	
	public boolean structureFound = false;

		public List<WorldIcon> mines;
		public List<WorldIcon> villages;
		public List<WorldIcon> strongholds;
		public List<WorldIcon> temples;
		public List<WorldIcon> mansions;
		public List<WorldIcon> oceanFeatures;
		public List<WorldIcon> oceanMonuments;


	//this.structs = new Structures(world.getWorldSeed().getLong());
	
	public enum Type {
		MINE, VILLAGE, STRONGHOLD, TEMPLE, MANSION, OCEAN_FEATURE, OCEAN_MONUMENT, SLIME_CHUNK, BIOME_DATA
	}
	
	
	Type[] simpleTypes = new Type[]{Type.MINE, Type.VILLAGE, Type.STRONGHOLD, Type.TEMPLE, Type.MANSION, Type
			.OCEAN_FEATURE, Type.OCEAN_MONUMENT};
	List[] simpleLists = new List[]{mines, villages, strongholds, temples, mansions, oceanFeatures,
			oceanMonuments};
	public void findStructures() {
		for(WorldIcon icon : mansions) {
			// check if within expected distance
			if(origin.getDistance(icon.getCoordinates()) <= 100) {
				structureFound = true;
			}
		}
		
	}

	private void findMines() {
		mines = world.getMineshaftProducer().getAt(origin, null);
	}

	private void findVillages() {
		villages = world.getVillageProducer().getAt(origin, null);
	}

	private void findOceanMounments() {
		oceanMonuments = world.getOceanMonumentProducer().getAt(origin, null);
	}

	private void findOceanFeatures() {
		oceanFeatures = world.getOceanFeaturesProducer().getAt(origin, null);
	}

	private void findStrongholds() {
		strongholds = world.getStrongholdProducer().getAt(origin, null);
	}

	private void findTemples() {
		temples = world.getTempleProducer().getAt(origin, null);
	}

	private void findMansions() {
		mansions = world.getWoodlandMansionProducer().getAt(origin, null);
	}
	
}
